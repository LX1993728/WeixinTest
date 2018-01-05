package com.example.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.core.utils.Page;
import com.example.po.Task;
import com.example.po.template.StageSceneBase;
import com.example.po.template.StageSceneFirst;
import com.example.po.template.StageSceneMiddle;
import com.example.po.template.StageScentLast;
import com.example.po.template.Template;
import com.example.service.TemplateService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * 关于模板创建的控制器
 * 
 * @author liuxun
 *
 */
// TODO: 关于模板新建的所有接口，暂时先不进行数据校验，后期完善......
@SuppressWarnings("all")
@Controller
@RequestMapping("/template")
public class TemplateController {
	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private TemplateService templateService;

	/**
	 * 跳转到模板新建页面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/toCreate", method = { RequestMethod.GET })
	public String toCreate(HttpSession session) {

		// 让上次session中有关新建模板存入的内容都失效
		session.setAttribute("T_template", null);
		session.setAttribute("T_level", null);
		session.setAttribute("T_uuid", null);
		session.setAttribute("T_name", null);
		session.setAttribute("T_scenes", null);
		return "newTemplate";
	}

	/**
	 * 提交上一次编辑的阶段场景内容,并把当前的场景内容进行回显 注意：当前的场景 我这里指的是 即将跳转到的场景
	 * 
	 * @param session
	 * @param scene
	 *            封装的上一次编辑的场景内容
	 * @param uuid
	 *            当前的场景 在页面中的唯一标识
	 * @param level
	 *            当前的场景 当前的场景是几级的
	 * @param name
	 *            当前的场景对应的名称 用来为场景name属性赋值 以及 判断场景的类型
	 * @return
	 */
	@RequestMapping(value = "/stageFirst_submit", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object stageFirstSubmit(HttpSession session, Model model, StageSceneFirst scene, Long uuid, Long level,
			String name) {
		return getInfoForStageSubmit(session, model, scene, uuid, level, name);
	}

	@RequestMapping(value = "/stageLast_submit", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object stageLastSubmit(HttpSession session, Model model, StageScentLast scene, Long uuid, Long level,
			String name) {
		return getInfoForStageSubmit(session, model, scene, uuid, level, name);
	}

	@RequestMapping(value = "/stageMiddle_submit", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object stageSubmit(HttpSession session, Model model, StageSceneMiddle scene, Long uuid, Long level,
			String name) {
		return getInfoForStageSubmit(session, model, scene, uuid, level, name);
	}

	private Object getInfoForStageSubmit(HttpSession session, Model model, StageSceneBase scene, Long uuid, Long level,
			String name) {
		// 1.获取上次编辑的场景相关属性
		Long levelL = null;
		Long uuidL = null;
		String nameL = null;
		if (session.getAttribute("T_level") != null && session.getAttribute("T_uuid") != null
				&& session.getAttribute("T_name") != null) {
			levelL = (Long) session.getAttribute("T_level");
			uuidL = (Long) session.getAttribute("T_uuid");
			nameL = (String) session.getAttribute("T_name");
		} else { // 如果是第一次进入，则默认为场景概述
			levelL = 1L;
			uuidL = -1L;
			nameL = "场景概述";
		}

		// 2.判断保存整个模板 中所有scene的的map集合 是否存在，没有则创建
		if (session.getAttribute("T_scenes") == null) {
			session.setAttribute("T_scenes", new HashMap<Long, StageSceneBase>());
		}

		Map<Long, StageSceneBase> scenesMap = (Map<Long, StageSceneBase>) session.getAttribute("T_scenes");
		// 3.如果上次有编辑 则保存上次编辑场景的内容
		if (levelL != null && uuidL != null && nameL != null) {
			// 为上次的场景表单的级别以及名称赋值
			scene.setLevel(levelL.intValue());
			scene.setName(nameL);
			// 重新存入
			scenesMap.put(uuidL, scene);
			session.setAttribute("T_scenes", scenesMap);
		}

		// 5.将即将跳转的 场景有关属性 设置为 过去式
		session.setAttribute("T_level", level);
		session.setAttribute("T_uuid", uuid);
		session.setAttribute("T_name", name);

		// 6.即将跳转的页面 以前编辑过内容 则进行回显
		if (scenesMap.containsKey(uuid)) {
			return uuid;
		} else {
			return uuid;
		}
	}
	

	/**
	 * 模板表单提交
	 * 
	 * @param session
	 * @param uuids
	 *            所有的场景唯一标识
	 * @param template
	 *            封装模板的基本数据
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/template_submit", method = { RequestMethod.POST,RequestMethod.GET })
	@ResponseBody
	public Object toSubmitTemplate(HttpSession session,HttpServletResponse response, String uuids, Template template) throws  Exception {
		// 1. 校验
		// 1.1 TODO: 模板表单 基本属性校验
		// 1.2 TODO: 模板表单 场景属性校验
		// 1.3 TODO: 模板表单 参数合法性校验
		System.out.println("=======");
		JSONArray jsonArray = JSON.parseArray(uuids);
		List<Long> uuidsPs = new ArrayList<>();
		for(int i=0;i< jsonArray.size();i++) {
			String uuidStr = (String) jsonArray.get(i);
	        uuidsPs.add(Long.parseLong(uuidStr));
		}
		String result = resolveForTemplateSubmit(session, uuidsPs, template);
		if (result.equals("200")) {
			response.setStatus(200);
			return "成功提交";
		}
		if (result.equals("400")) {
			response.setStatus(400);
			return "输入非法";
		}
		response.setStatus(500);
		return "服务器正在维护中....";
	}

	// 封装私有方法
	private String resolveForTemplateSubmit(HttpSession session, List<Long> uuids, Template template) {
		// 1.从session中获取场景集合 根据uuids数组进行筛选
		if (session.getAttribute("T_scenes") == null || uuids == null) {
			return "400";
		}

		// 2.进行筛选取值
		Map<Long, StageSceneBase> scenesMap = (Map<Long, StageSceneBase>) session.getAttribute("T_scenes");
		List<StageSceneBase> newSceneList = new ArrayList<StageSceneBase>();
		for (Long uuid : uuids) {
			if (scenesMap.containsKey(uuid)) {
				StageSceneBase base = scenesMap.get(uuid);
				newSceneList.add(base);
			}else { // 如果有空的场景，必须先赋值才行
				return "400";
			}
		}

		// 3.遍历设置下标
		for (StageSceneBase base : newSceneList) {
			base.setIndex(newSceneList.indexOf(base));
		}

		template.setId(template.getName().hashCode());
		template.setStageScenes(newSceneList);
		Ehcache cache = cacheManager.getEhcache("content");
		cache.put(new Element("template_" + template.getId(), template));
		cache.flush();

		return "200";
	}

	// 跳转到对应的JSP
	@RequestMapping(value = "/toScenePage", method = { RequestMethod.GET })
	public String toSubmit(HttpSession session, Model model, String name, Long uuid) {
		if (name == null || name.trim().length() == 0) {
			return "404";
		}
		if (uuid != null) {
			if (session.getAttribute("T_scenes") != null) {
				Map<Long, StageSceneBase> scenesMap = (Map<Long, StageSceneBase>) session.getAttribute("T_scenes");
				if (scenesMap.containsKey(uuid)) {
					model.addAttribute("scene", scenesMap.get(uuid));
				}
			}
		}
		return name;
	}
	
	// 自定义属性编辑器
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		// Date.class必须是与controler方法形参pojo属性一致的date类型，这里是java.util.Date
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}

}
