package com.example.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WXGetAccessToken {
	private static final Logger logger = LoggerFactory.getLogger(WXGetAccessToken.class);

	// 请求方法
	public static synchronized AccessToken requestAccessToken()
			throws Exception {
		StringBuilder requestUrl = new StringBuilder();
		requestUrl.append(WXConfig.URL + "/cgi-bin/token?grant_type=client_credential&appid=").append(WXConfig.APPID)
				.append("&secret=").append(WXConfig.APPSECRET);
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(requestUrl.toString());
		CloseableHttpResponse response = client.execute(httpget);
		try {
			logger.info("get access_token status" + response.getStatusLine());
			HttpEntity entity = response.getEntity();
			AccessToken accessToken = new ObjectMapper().readValue(EntityUtils.toString(entity), AccessToken.class);
			if (accessToken.access_token.length() > 0) {
				accessToken.createTime = System.currentTimeMillis();
				logger.info("========== access_token= {}====== ", accessToken.access_token);
				return accessToken;
			} else {
				return null;
			}
		} finally {
			response.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		WXGetAccessToken.requestAccessToken();
	}
	
}
