package com.example.po.template;

import java.io.Serializable;

/**
 * 演练场景 中间项中的成员
 * 
 * @author liuxun
 *
 */
public class SceneTask implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name; // 场景任务名称
	private String groups; // 对应的责任组别

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

}
