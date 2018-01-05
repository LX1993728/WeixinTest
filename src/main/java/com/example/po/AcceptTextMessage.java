package com.example.po;

/**
 * 接收到的文本类型的消息
 */
public class AcceptTextMessage extends AcceptMessage{
	private static final long serialVersionUID = 1L;
	private String content; // 文本的消息内容

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
