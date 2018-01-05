package com.example.vo;
/**
 *  为页面封装场景数据
 * @author liuxun
 *
 */

import java.util.List;

import com.example.po.template.StageSceneBase;

public class SceneGroupVO {
	StageSceneBase stageScene; // 一级
	List<StageSceneBase> childs; // 对应的二级或三级子场景数组

	public StageSceneBase getStageScene() {
		return stageScene;
	}

	public void setStageScene(StageSceneBase stageScene) {
		this.stageScene = stageScene;
	}

	public List<StageSceneBase> getChilds() {
		return childs;
	}

	public void setChilds(List<StageSceneBase> childs) {
		this.childs = childs;
	}

}
