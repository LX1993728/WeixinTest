package com.example.serviceImpl;

import com.example.core.config.Global;
import com.example.po.AcceptTextMessage;
import com.example.po.User;
import com.example.service.HandlerService;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandlerServiceImpl implements HandlerService{

    @Autowired
    CacheManager cacheManager;

	@Override
    public Boolean sendMessage(String userName, String orgName, String content) {
        Ehcache cache = cacheManager.getEhcache("content");

        User user = null;
        // 新用户注册
        if (!cache.isKeyInCache("user_" + Global.currentTaskNum+"_"+orgName+"-"+userName)){ // 说明是新用户 需进行注册
            user = new User();
            user.setCurrentTaskNum(Global.currentTaskNum);
            user.setName(userName);
            user.setOrgName(orgName);
            user.setWxUserName(orgName+"-"+userName); // 唯一标识
            cache.put(new Element("user_" + Global.currentTaskNum+"_"+user.getWxUserName(),user));
        }else {
            user = (User) cache.get("user_" + Global.currentTaskNum+"_"+orgName+"-"+userName).getObjectValue();
        }

        // 然后进行消息处理   暂时不包含图片
        AcceptTextMessage acceptTextMessage = new AcceptTextMessage();
        acceptTextMessage.setStatus(1); // 如果是手动发送消息，则直接是上墙
        acceptTextMessage.setContent(content);
        acceptTextMessage.setMsgType("text");
        acceptTextMessage.setCreateTime(System.currentTimeMillis());
        acceptTextMessage.setMsgId(System.currentTimeMillis());
        acceptTextMessage.setUser(user);
        acceptTextMessage.setIndex(Global.index);
        cache.put(new Element("message_" + Global.currentTaskNum +"_"+acceptTextMessage.getMsgId(),acceptTextMessage));

        cache.flush();

        return Boolean.TRUE;
    }
}
