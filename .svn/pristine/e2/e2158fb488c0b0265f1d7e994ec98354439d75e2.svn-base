package com.example.serviceImpl;

import com.example.core.config.Global;
import com.example.po.InputMessage;
import com.example.po.User;
import com.example.service.UserService;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    CacheManager cacheManager;

    @Override
    public Boolean isRegisteredByWXName(InputMessage inputMessage) {
        Ehcache cache = cacheManager.getEhcache("content");
        String fromUserName = "user_" + Global.currentTaskNum+"_"+inputMessage.getFromUserName();
        boolean isExists = cache.isKeyInCache(fromUserName);
        cache.flush();
        return isExists;
    }

    @SuppressWarnings("unchecked")
	@Override
    public Boolean registerUser(InputMessage inputMessage) {
        String msgType = inputMessage.getMsgType();
        if (!msgType.equals("text")){
            return Boolean.FALSE;
        }
        String content = inputMessage.getContent();
        Pattern p = Pattern.compile("([0-9]+)(-)(.+)");
        Matcher m = p.matcher(content);
        if (m.find()){
            int orgIndex = Integer.parseInt(m.group(1));
            Ehcache cache = cacheManager.getEhcache("content");
            List<String> list = (List<String>) cache.get("currentTaskOrgList").getObjectValue();
            if (orgIndex >=0 && orgIndex<= list.size()-1){
                User user = new User();
                user.setCurrentTaskNum(Global.currentTaskNum);
                user.setName(m.group(3));
                user.setOrgName(list.get(orgIndex));
                user.setWxUserName(inputMessage.getFromUserName());
                cache.put(new Element("user_" + Global.currentTaskNum+"_"+user.getWxUserName(),user));
                cache.flush();
                return Boolean.TRUE;
            }else {
            		cache.flush();
                return Boolean.FALSE;
            }
        }else {
            return Boolean.FALSE;
        }

    }


}
