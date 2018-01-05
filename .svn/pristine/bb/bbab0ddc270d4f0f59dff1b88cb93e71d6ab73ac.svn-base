package com.example.serviceImpl;

import com.example.core.config.Global;
import com.example.po.*;
import com.example.service.MessageService;
import com.example.service.UserService;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.SynchronizationType;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    CacheManager cacheManager;

    @Autowired
    UserService userService;

    @SuppressWarnings("unchecked")
	@Override
    public synchronized String resolveAndReplyMessageToUser(InputMessage inputMessage) {
        String message = null;
        Ehcache cache = cacheManager.getEhcache("content");
        Boolean registeredByWXName = userService.isRegisteredByWXName(inputMessage);
        if (registeredByWXName.booleanValue()) { // 如果已经注册，开始判断消息类型进行保存 并提示 当前对话已被记录
            String msgType = inputMessage.getMsgType();
            if (msgType.equals("text")) {
                AcceptTextMessage acceptTextMessage = new AcceptTextMessage();
                acceptTextMessage.setUser((User) cache.get("user_" + Global.currentTaskNum+"_"+inputMessage.getFromUserName()).getObjectValue());
                acceptTextMessage.setContent(inputMessage.getContent());
                System.out.println("======"+inputMessage.getMsgId());
                acceptTextMessage.setMsgId(inputMessage.getMsgId());
                System.out.println("======"+acceptTextMessage.getMsgId());
                acceptTextMessage.setCreateTime(inputMessage.getCreateTime()*1000);
                acceptTextMessage.setMsgType(inputMessage.getMsgType());
                acceptTextMessage.setStatus(Global.check?0:1);
                acceptTextMessage.setIndex(Global.index);
                acceptTextMessage.setId(acceptTextMessage.getMsgId().toString());
                cache.put(new Element("message_" + Global.currentTaskNum +"_"+acceptTextMessage.getMsgId(),acceptTextMessage));
            }

            if (msgType.equals("image")) {
                AcceptImageMessage acceptImageMessage = new AcceptImageMessage();
                acceptImageMessage.setUser((User) cache.get("user_" + Global.currentTaskNum+"_"+inputMessage.getFromUserName()).getObjectValue());
                acceptImageMessage.setMediaId(inputMessage.getMediaId());
                acceptImageMessage.setPicUrl(inputMessage.getPicUrl());
                acceptImageMessage.setMsgId(inputMessage.getMsgId());
                acceptImageMessage.setCreateTime(inputMessage.getCreateTime()*1000);
                acceptImageMessage.setMsgType(inputMessage.getMsgType());
                acceptImageMessage.setStatus(Global.check?0:1);
                acceptImageMessage.setIndex(Global.index);
                acceptImageMessage.setId(acceptImageMessage.getMsgId().toString());
                cache.put(new Element("message_" + Global.currentTaskNum +"_"+acceptImageMessage.getMsgId(),acceptImageMessage));
            }
            message = "以上通话已被记录";
        } else { // 如果没有注册，进行注册 如果注册失败 给出提示信息并返回
            if (userService.registerUser(inputMessage).booleanValue()) {
                message = "您已成功注册";
            } else {
                List<String> list = (List<String>) cache.get("currentTaskOrgList").getObjectValue();
                StringBuilder builder = new StringBuilder();
                builder.append("请输入组织编号和自己的名称:").append("\r\n");
                builder.append("例如: 1-张三 (注意:不允许空格）").append("\r\n");
                for (int i = 0; i < list.size(); i++) {
                    builder.append(i + " " + list.get(i)).append("\r\n");
                }
                message = builder.toString();
            }
        }
        cache.flush();
        return message;
    }
}
