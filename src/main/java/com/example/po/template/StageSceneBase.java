package com.example.po.template;

import java.io.Serializable;

/**
 * 阶段场景的基类
 * 
 * @author liuxun
 *
 */
public class StageSceneBase implements Serializable {
	private static final long serialVersionUID = 1L;

	// 所有子类的共有属性
	private int level; // 阶段级别 1,2,3 分别表示是几级场景
	private String name; // 场景名称
	private int index; // 在模板中场景数组中的下标位置

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
