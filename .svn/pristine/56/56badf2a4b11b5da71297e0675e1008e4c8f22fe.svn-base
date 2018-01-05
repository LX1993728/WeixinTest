package com.example.core.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.example.core.menu.MeunOperation;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 负责公众号菜单的 增加 查询 和删除
 * 
 * @author liuxun
 *
 */
public class MenuUtils {
	// 创建菜单
	public static void createMenu() throws Exception {
		AccessToken accessToken = WXGetAccessToken.requestAccessToken();
		if (accessToken == null) {
			System.out.println("获取accessToken失败");
		}
		String token = accessToken.access_token;
		ObjectMapper mapper = new ObjectMapper();
		String menuJson = mapper.writeValueAsString(MeunOperation.getMenu());
		
		StringBuilder requestUrl = new StringBuilder();
		requestUrl.append(WXConfig.MENU_CREATE_URL + "?access_token=").append(token);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(requestUrl.toString());
		StringEntity requestEntity = new StringEntity(menuJson, "utf-8");
		requestEntity.setContentEncoding("UTF-8");
		httpPost.setHeader("Content-type", "application/json");
		httpPost.setEntity(requestEntity);
		CloseableHttpResponse response = client.execute(httpPost);
		try {
			System.out.println("++++++++++++++get access_token status" + response.getStatusLine());
			
			HttpEntity entity = response.getEntity();
			System.out.println(entity.toString());
		} finally {
			response.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		MenuUtils.createMenu();
	}
}
