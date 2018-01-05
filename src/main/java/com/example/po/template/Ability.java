package com.example.po.template;

import java.io.Serializable;

/**
 * 演练评估 场景中的子成员项——响应能力
 * 
 * @author liuxun
 *
 */
public class Ability implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name; // 响应能力名称
	private String url; // 对应的图片相对路径
	private String desc; // 对应的描述

	private String assess; // 评估描述
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getAssess() {
		return assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	
}
