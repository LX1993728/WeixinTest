package com.example.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.example.core.utils.WebServicesClient;

/**
 * 创建时间：2017年12月20日 上午11:12:13 项目名称：WeixinTest
 * 
 * @author wy
 * @version 1.0
 * @since JDK 1.6.0_21 文件名称：MapController.java 类说明：
 */
@Controller
@RequestMapping("/map")
public class MapController {

	@RequestMapping("/getPersonOnline")
	@ResponseBody
	public Map<String, String> getPersonOnline() {
		WebServicesClient client = new WebServicesClient();
		System.out.println(client.getMemberStatus("demo01","demo01"));
		return client.getMemberStatus("demo01","demo01");
	}
	
	@RequestMapping("/callPersonOnlineVideo")
	@ResponseBody
	public Map<String, String> callPersonOnlineVideo(String userId,Boolean single) {
		WebServicesClient client = new WebServicesClient();
		System.out.println(userId);
		JSONArray array = JSONArray.parseArray(userId);
		String[] str = new String[array.size()];
		if(single == true){
			System.out.println((String) array.get(0));
			String[] singleStr = new String[]{"7",(String) array.get(0)};
			client.call("demo01","demo01",singleStr); 
		}else{
			String[] str1 = array.toArray(str);
			client.call("demo01","demo01",str1); 
		}
		return null;
	}
	
}
