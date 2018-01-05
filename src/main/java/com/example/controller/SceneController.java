package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.core.config.Global;
import com.example.po.Task;
import com.example.po.template.ImageText;
import com.example.po.template.StageSceneBase;
import com.example.po.template.StageSceneFirst;
import com.example.po.template.StageSceneMiddle;
import com.example.po.template.Template;
import com.example.vo.SceneGroupVO;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * 演练场景-推演的接口处理
 * 
 * @author liuxun
 *
 */
@Controller
@RequestMapping("/scene")
public class SceneController {
	@Autowired
	private CacheManager cacheManager;
	
	private List<SceneGroupVO> resolveDataByTemplate(Template template){
		List<StageSceneBase> scenes = template.getStageScenes();
		List<SceneGroupVO> groupVOs = new ArrayList<>();
		// 进行数据的封装
		for (StageSceneBase scene : scenes) {
			if (scene.getLevel() == 1) {
				SceneGroupVO groupVO = new SceneGroupVO();
				groupVO.setStageScene(scene);
				groupVO.setChilds(new ArrayList<StageSceneBase>());;
				groupVOs.add(groupVO);
			}else {
				if (groupVOs.size()>0) {
					groupVOs.get(groupVOs.size()-1).getChilds().add(scene);
				}
				
			}
		}
		System.out.println("========"+JSON.toJSONString(groupVOs));
		return groupVOs;
	}

	/**
	 * 开启模板演练的接口
	 * @param model
	 * @param session
	 * @param template
	 * @return
	 */
	@RequestMapping(value = "/begin", method = { RequestMethod.GET })
	public String toBeginTaskByTemplate(Model model, HttpSession session, Template template) {
		if (template.getId() == null) {
			return "400";
		}
		Ehcache cache = cacheManager.getEhcache("content");
		String key = "template_" + template.getId().intValue();
		if (cache.isKeyInCache(key)) {
			// 覆盖 template
			template = (Template) cache.get(key).getObjectValue();
		} else {
			cache.flush();
			return "404";
		}
		// 0. 设置结束时间
		List<String> keys = cache.getKeys();
		for (String task_key : keys) {
			if (task_key.startsWith("task_")) {
				Task itemTask = (Task) cache.get(task_key).getObjectValue();
				if (itemTask.getEndTime() == null) {
					itemTask.setEndTime(System.currentTimeMillis());
					cache.put(new Element(task_key, itemTask));
				}
			}
		}

		// 1. 首先创建一个Task
		Task task = new Task();
		task.setTime(System.currentTimeMillis());
		task.setName(template.getName());
		task.setTemplateId(template.getId());
		task.setLocation(template.getAddress());
		cache.put(new Element("task_" + task.getTime(), task));

		// 2.设置全局的currentTaskNum 即当前任务的主键 即时间
		Global.currentTaskNum = task.getTime();
		cache.put(new Element("currentTaskNum", Global.currentTaskNum));

		// 3.演练场景的下标重置为0 即表示开启新的演练任务都从 "演练评估" 第一个场景开始
		Global.index = 0;
		cache.put(new Element("index", Global.index));

		// 4.从模板中获取 演练的组织单位数组 并存入currentTaskOrgList
		cache.put(new Element("currentTaskOrgList", template.getOrgList()));

		// 5.每次开启新的演练默认都开启 微信消息 审核
		Global.check = Boolean.TRUE;
		cache.put(new Element("check", Global.check));
		
		session.setAttribute("template", template); // 表示当前演练对应的模板
		session.setAttribute("task", task); // 表示当前的演练
		session.setAttribute("stages", resolveDataByTemplate(template));
		Boolean isHistory = task.getTime().equals(Global.currentTaskNum)?Boolean.FALSE:Boolean.TRUE;
		session.setAttribute("isHistory", isHistory); // 用于页面区分是开启演练还是演练历史
		
		cache.flush();
		return "scene";
	}

	/**
	 * 查询历史演练模板
	 * @param model
	 * @param session
	 * @param task
	 * @return
	 */
	@RequestMapping(value = "/query", method = { RequestMethod.GET })
	public String toQueryHistoryTask(Model model, HttpSession session, Task task) {
		if (task.getTime() == null) {
			return "400";
		}
		Ehcache cache = cacheManager.getEhcache("content");
		String key = "task_" + task.getTime().toString();
		if (cache.isKeyInCache(key)) {
			// 覆盖 task
			task = (Task) cache.get(key).getObjectValue();
		} else {
			cache.flush();
			return "404";
		}
		Template template = (Template) cache.get("template_"+task.getTemplateId()).getObjectValue();
		
		
		session.setAttribute("template", template); // 表示当前演练对应的模板
		session.setAttribute("task", task); // 表示当前的演练
		session.setAttribute("stages", resolveDataByTemplate(template)); // 封装数据给页面
		Boolean isHistory = task.getTime().equals(Global.currentTaskNum)?Boolean.FALSE:Boolean.TRUE;
		session.setAttribute("isHistory", isHistory); // 用于页面区分是开启演练还是演练历史

		cache.flush();
		return "scene";
	}
	
	/**
	 * 点击阶段场景后的事件
	 * @param session
	 * @param model
	 * @param scene
	 * @return
	 */
	@RequestMapping(value = "/toScene", method = { RequestMethod.GET })
	public String toScene( HttpSession session,Model model, StageSceneBase scene) {
		Object object = session.getAttribute("template");
		Boolean isHistory = (Boolean) session.getAttribute("isHistory");
		if (object == null || isHistory == null) {
			return "404";
		}
		Template template = (Template) object;
		List<StageSceneBase> scenes = template.getStageScenes();
		int index = scene.getIndex();
		// 如果当前正在演练 则修改全局的index
		if (!isHistory && index < scenes.size()-1) {
			Ehcache cache = cacheManager.getEhcache("content");
			Global.index = index;
			cache.put(new Element("index", Global.index));
			cache.flush();
		}
		
		if (index == 0 || index > scenes.size()-1) { // 如果阶段超过下标，则跳转到第一个阶段
			model.addAttribute("scene", scenes.get(0));
			session.setAttribute("index", 0);
			return "sceneFirst";
		}
		
		if (index == scenes.size()-1) {
			model.addAttribute("scene", scenes.get(index));
			session.setAttribute("index", index);
			return "sceneLast";
		}
		
		session.setAttribute("index", index);
		model.addAttribute("scene", scenes.get(index));
		return "sceneMiddle";
	}
	
	/**
	 * 跳转到展示图片轮播图的接口
	 * @param session
	 * @param model
	 * @param index
	 * @return
	 */
	@RequestMapping(value = "/toImgts", method = { RequestMethod.GET })
	public String toImgtsPage(HttpSession session,Model model,Long index) {
		Object object = session.getAttribute("template");
		if (object == null) {
			return "404";
		}
		Template template = (Template) object;
		List<StageSceneBase> scenes = template.getStageScenes();
		if (!(index.longValue()>=0 && index.longValue()<=scenes.size()-1)) {
			return "400";
		}
		List<ImageText> imgts = null;
		StageSceneBase scene = scenes.get(index.intValue());
		if (scene instanceof StageSceneFirst) {
			imgts = ((StageSceneFirst) scene).getImgts();
		}else if (scene instanceof StageSceneMiddle) {
			imgts = ((StageSceneMiddle) scene).getImgts();
		}
		model.addAttribute("imgts", imgts);
		return "slideshow";
	}
	
	// 结束历史查看或者结束推演过程
	@RequestMapping(value = "/endScene", method = { RequestMethod.GET })
	public String endScene( HttpSession session,Model model) {
		Object object = session.getAttribute("template");
		Object taskObj = session.getAttribute("task");
		Boolean isHistory = (Boolean) session.getAttribute("isHistory");
		if (object == null || isHistory == null || taskObj == null) {
			return "404";
		}
		Ehcache cache = cacheManager.getEhcache("content");
		if (!isHistory) {
			Global.currentTaskNum = 0L;
			cache.put(new Element("currentTaskNum", Global.currentTaskNum));

			Global.index = 0;
			cache.put(new Element("index", Global.index));
			cache.remove("currentTaskOrgList");

			Global.check = Boolean.TRUE;
			cache.put(new Element("check", Global.check));
		}
		Task task = (Task) taskObj;
		if (task.getEndTime() == null) {
			task.setEndTime(System.currentTimeMillis());
		}
		cache.put(new Element("task_" + task.getTime(), task));
		cache.flush();
		
		return "redirect:/index";
	}
}
