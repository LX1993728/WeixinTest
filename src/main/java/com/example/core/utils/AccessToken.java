package com.example.core.utils;

import java.io.Serializable;
import java.util.Date;

public class AccessToken implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public String access_token; // 获取到的凭证
	public Long expires_in; // 凭证有效时间，单位：秒
	public Long createTime; // 凭证的获取时间

	public AccessToken() {
	}

	public AccessToken(String access_token, long expires_in) {
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.createTime = new Date().getTime();
	}
}
