package com.example.po;

import java.io.Serializable;

/**
 * 定义消息
 */
public class AcceptMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private Long msgId; // 消息Id 区分消息的唯一标识
	private String msgType; // 消息类型 "image"、"text"
	private Long createTime; // 接收消息的时间 毫秒
	private User user; // 是哪个用户发送的消息
	private Integer index; // 消息对应的模板场景数组中的下标 默认值为0  对应第一项 演练评估

	private Integer status; // 表示当前消息的状态 0:待审核 1:上墙 2:下墙

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getId() {
		return this.msgId.toString();
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
