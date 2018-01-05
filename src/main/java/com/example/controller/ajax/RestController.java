package com.example.controller.ajax;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.example.po.template.StageSceneBase;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

@SuppressWarnings("all")
@Controller
@RequestMapping("/cache")
public class RestController {

	private static CacheManager cacheManager = CacheManager.newInstance();

	/**
	 * 打印在ehcache 中存储的所有内容
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String testCache() throws JsonProcessingException {
		Ehcache cache = cacheManager.getEhcache("content");
		ObjectMapper mapper = new ObjectMapper();

		List keys = cache.getKeys();
		for (Object key : keys) {
			System.out.println("====" + key + "  ===" + mapper.writeValueAsString(cache.get(key).getObjectValue()));
		}
		cache.flush();

		return "ccc";
	}

	/**
	 * 查看session中创建模板的数据
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/temp", method = RequestMethod.GET)
	@ResponseBody
	public Object testTemplateSession(HttpSession session) throws JsonProcessingException {
		Ehcache cache = cacheManager.getEhcache("content");
		ObjectMapper mapper = new ObjectMapper();
		if (session.getAttribute("T_scenes") != null) {
			return mapper.writeValueAsString(session.getAttribute("T_scenes"));
		}else {
			return "模板场景集合为NULL";
		}
	}

}
