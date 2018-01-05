package com.example.po.template;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Template implements Serializable {
	private static final long serialVersionUID = 1L;

	// 基本信息
	private String name; // 演练名称
	private String address; // 演练地址
	private Date time; // 事发时间

	// 事发分类定级
	private String eventBigType; // 事件大类
	private String eventDetailType; // 事件详细分类
	private String eventCategory; // 事件类别

	// 参演单位数组
	private List<String> orgList;

	// 阶段场景数组
	private List<StageSceneBase> stageScenes; // 阶段场景

	// 主键：唯一标识
	private Integer Id; // ==name.hashCode();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getEventBigType() {
		return eventBigType;
	}

	public void setEventBigType(String eventBigType) {
		this.eventBigType = eventBigType;
	}

	public String getEventDetailType() {
		return eventDetailType;
	}

	public void setEventDetailType(String eventDetailType) {
		this.eventDetailType = eventDetailType;
	}

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public List<String> getOrgList() {
		return orgList;
	}

	public void setOrgList(List<String> orgList) {
		this.orgList = orgList;
	}

	public List<StageSceneBase> getStageScenes() {
		return stageScenes;
	}

	public void setStageScenes(List<StageSceneBase> stageScenes) {
		this.stageScenes = stageScenes;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

}
