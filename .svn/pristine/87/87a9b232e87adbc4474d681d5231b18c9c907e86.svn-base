package com.example.controller.ajax;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.po.template.Ability;
import com.example.po.template.ImageText;
import com.example.po.template.SceneTask;
import com.example.po.template.StageSceneBase;
import com.example.po.template.StageSceneFirst;
import com.example.po.template.StageSceneMiddle;
import com.example.po.template.StageScentLast;
import com.example.po.template.Template;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * 测试 模板
 * 
 * @author liuxun
 *
 */
@Controller
public class TestTemplateController {

	@Autowired
	private CacheManager cacheManager;

	@RequestMapping(value = "/create", method = { RequestMethod.GET })
	@ResponseBody
	public Object testCreateTemplate() {
		Ehcache cache = cacheManager.getEhcache("content");

		String address = "陕西省延安县密云部落";
		Template template = new Template();
		template.setAddress(address);
		template.setTime(new Date());
		template.setName("模板测试一");
		template.setEventBigType("模板对应事件大类");
		template.setEventDetailType("模板对应事件详细分类");
		template.setEventCategory("模板对应事件类别");
		List<String> orgList = new ArrayList<>();
		orgList.add("组织单位一");
		orgList.add("组织单位二");
		orgList.add("组织单位三");
		orgList.add("组织单位四");
		template.setOrgList(orgList);
		template.setId(template.getName().hashCode());

		// 为模板设置阶段场景
		List<StageSceneBase> stageScenes = new ArrayList<>();
		// 第一项 情景概述
		StageSceneFirst sceneFirst = new StageSceneFirst();
		sceneFirst.setName("场景概述");
		sceneFirst.setDesc("演练情景描述：这是一个非常无聊的演练");
		sceneFirst.setRule("演练的原则：一共有五条原则 如下......");
		List<String> targets = new ArrayList<>();
		targets.add("演练目标一");
		targets.add("演练目标二");
		targets.add("演练目标三");
		targets.add("演练目标四");
		sceneFirst.setTargets(targets);
		sceneFirst.setExplain("场景说明：这是一个黑色的场景......");
		sceneFirst.setLevel(1);
		List<ImageText> imgts = new ArrayList<>();
		ImageText imgt1 = new ImageText();
		imgt1.setUrl("/5/6/01bca0fe-627e-4ac1-a327-c47142c13ea4.jpeg");
		imgt1.setDesc("图片描述1");
		ImageText imgt2 = new ImageText();
		imgt2.setUrl("/5/8/ff9a6499-1f74-447a-b73a-7799ccb524b5.jpeg");
		imgt2.setDesc("图片描述2");
		ImageText imgt3 = new ImageText();
		imgt3.setUrl("/5/9/047900c2-2865-4c7c-95a2-668323f653dd.jpeg");
		imgt3.setDesc("图片描述3");
		imgts.add(imgt1);
		imgts.add(imgt2);
		imgts.add(imgt3);
		sceneFirst.setImgts(imgts);

		// 添加中间阶段场景
		StageSceneMiddle sceneMiddle1 = new StageSceneMiddle();
		sceneMiddle1.setName("先期处置(一级)");
		sceneMiddle1.setLevel(1);
		sceneMiddle1.setExplain("中间阶段-先期处置 之场景说明:先期处置是一个......");
		List<SceneTask> tasks = new ArrayList<>();
		SceneTask sceneTask1 = new SceneTask();
		sceneTask1.setName("先期处置-场景任务1");
		sceneTask1.setGroups("先期处置-场景任务1 对应责任组别");
		SceneTask sceneTask2 = new SceneTask();
		sceneTask2.setName("先期处置-场景任务2");
		sceneTask2.setGroups("先期处置-场景任务2 对应责任组别");
		SceneTask sceneTask3 = new SceneTask();
		sceneTask3.setName("先期处置-场景任务3");
		sceneTask3.setGroups("先期处置-场景任务3 对应责任组别");
		tasks.add(sceneTask1);
		tasks.add(sceneTask2);
		tasks.add(sceneTask3);
		sceneMiddle1.setTasks(tasks);
		sceneMiddle1.setImgts(imgts);
		
		// 添加中间阶段场景
		StageSceneMiddle sceneMiddle2 = new StageSceneMiddle();
		sceneMiddle2.setName("先期处置(二级)");
		sceneMiddle2.setLevel(2);
		sceneMiddle2.setExplain("中间阶段-先期处置(二级) 之场景说明:先期处置是一个......");
		List<SceneTask> tasks2 = new ArrayList<>();
		SceneTask sceneTask2_1 = new SceneTask();
		sceneTask2_1.setName("先期处置(二级)-场景任务1");
		sceneTask2_1.setGroups("先期处置(二级)-场景任务1 对应责任组别");
		SceneTask sceneTask2_2 = new SceneTask();
		sceneTask2_2.setName("先期处置(二级)-场景任务2");
		sceneTask2_2.setGroups("先期处置(二级)-场景任务2 对应责任组别");
		SceneTask sceneTask2_3 = new SceneTask();
		sceneTask2_3.setName("先期处置(二级)-场景任务3");
		sceneTask2_3.setGroups("先期处置(二级)-场景任务3 对应责任组别");
		tasks2.add(sceneTask2_1);
		tasks2.add(sceneTask2_2);
		tasks2.add(sceneTask2_3);
		sceneMiddle2.setTasks(tasks2);
		sceneMiddle2.setImgts(imgts);
		
		// 添加最后阶段-总结评估 场景
		StageScentLast scentLast  = new StageScentLast();
		scentLast.setLevel(1);
		scentLast.setName("总结评估");
		List<Ability> abilities = new ArrayList<>();
		Ability ability1 = new Ability();
		ability1.setUrl("/5/8/ff9a6499-1f74-447a-b73a-7799ccb524b5.jpeg");
		ability1.setName("响应能力名称-原因清查");
		ability1.setDesc("响应能力描述- 这个原因清查指的是......");   
		Ability ability2 = new Ability();
		ability2.setUrl("/5/9/047900c2-2865-4c7c-95a2-668323f653dd.jpeg");
		ability2.setName("响应能力名称-伤亡情况");
		ability2.setDesc("响应能力描述- 这个伤亡情况指的是......");   
		Ability ability3 = new Ability();
		ability3.setUrl("/5/b/fc171f29-2d88-4fe9-a29e-b1ce7047a8ab.jpeg");
		ability3.setName("响应能力名称-应急响应");
		ability3.setDesc("响应能力描述- 这个应急响应指的是......");   
		abilities.add(ability1);
		abilities.add(ability2);
		abilities.add(ability3);
		scentLast.setAbilities(abilities );

		stageScenes.add(sceneFirst);
		stageScenes.add(sceneMiddle1);
		stageScenes.add(sceneMiddle2);
		stageScenes.add(scentLast);
		
		for(int i=0;i<stageScenes.size();i++) {
			StageSceneBase sg = stageScenes.get(i);
			sg.setIndex(i);
		}

		template.setStageScenes(stageScenes);

		cache.put(new Element("template_" + template.getId(), template));
		cache.flush();
		return template;
	}
}
