package com.example.po.template;

import java.io.Serializable;

/**
 * 通用的 图片-描述类
 * 
 * @author liuxun
 *
 */
public class ImageText implements Serializable {
	private static final long serialVersionUID = 1L;
	private String url; // 图片的相对路径
	private String desc; // 对应的图片描述

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

}
