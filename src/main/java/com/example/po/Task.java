package com.example.po;

import java.io.Serializable;

/**
 * 表示一次演练任务
 */
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String location;
	private Long time; // 注意：这里表示的是毫秒 是开始时间
	private Integer templateId; // 它所关联的模板id

	private Long endTime; // 这里表示的是任务的结束时间

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

}
