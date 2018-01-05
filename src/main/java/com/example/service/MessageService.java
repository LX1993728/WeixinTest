package com.example.service;

import com.example.po.InputMessage;

/**
 * 用于操作  已添加用户->所发送过的各种消息
 */
public interface MessageService {
    // 处理用户发送的消息 完成后台逻辑 并进行回复
    public String resolveAndReplyMessageToUser(InputMessage inputMessage);
}
