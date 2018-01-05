package com.example.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.po.Task;
import com.example.po.template.Template;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

/**
 * 主页处理控制器
 * @author liuxun
 *
 */
@SuppressWarnings("all")
@Controller
public class IndexController {
	@Autowired
	CacheManager cacheManager;
	
	@RequestMapping(value = "/index", method = { RequestMethod.GET })
	public String toIndexPage(Model model) {
		// 获取所有的模板 和所有的演练历史任务
		
		
		List<Template> templates = new ArrayList<>();
		List<Task> tasks = new ArrayList<>();
		Ehcache cache = cacheManager.getEhcache("content");
		List<String> keys = cache.getKeys();
		for (String key : keys) {
			if (key.startsWith("template_")) {
				Template template = (Template) cache.get(key).getObjectValue();
				templates.add(template);
			}
			if (key.startsWith("task_")) {
				Task task = (Task) cache.get(key).getObjectValue();
				tasks.add(task);
			}
		}
		
		model.addAttribute("templates", templates);
		model.addAttribute("tasks", tasks);
		
		return "index";
	}

}
