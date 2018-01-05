package com.example.core.config;

import com.example.po.Task;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 在启动完成后 执行一些操作
 */
@Configuration
public class AfterStartup implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    CacheManager cacheManager;

    /**
     * 程序启动完毕 自动判断加载资源到ehcache
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Ehcache cache = cacheManager.getEhcache("content");

        if (!cache.isKeyInCache("currentTaskNum")){
            cache.put(new Element("currentTaskNum",Global.currentTaskNum)); // 默认值是0  为了测试方便 可先设置别的值
        }else { // 如果ehcache中活动编号 没有被重置为0 说明还没开启新的演练，在程序重启后 取出上次的演练编号 重新赋值
            Global.currentTaskNum = (Long) cache.get("currentTaskNum").getObjectValue();
        }

        Long  currentTaskNum = Global.currentTaskNum;
        if (currentTaskNum == 0){ // 表示已经关闭演练  后台 不再接收任意消息  不进行任意处理
            return;
        }

        if (!cache.isKeyInCache("index")){
            cache.put(new Element("index",Global.index)); // 默认值是0  即演练评估
        }else { // 如果ehcache中的index 存在 则读取后放置到全局变量中  方便读取
            Global.index =  (Integer) cache.get("index").getObjectValue();
        }
        
        List<String> currentTaskOrgList = new ArrayList<>();
        currentTaskOrgList.add("公安局");
        currentTaskOrgList.add("国土资源局");
        currentTaskOrgList.add("水利水电局");
        currentTaskOrgList.add("税务局");

        if (!cache.isKeyInCache("currentTaskOrgList")){
            cache.put(new Element("currentTaskOrgList",currentTaskOrgList));
        }

        if (!cache.isKeyInCache("check")){ // 表示是否开启审核
            cache.put(new Element("check",Global.check));
        }else {
            Global.check = (Boolean) cache.get("check").getObjectValue();
        }


        String taskName = "task_"+currentTaskNum;
        if (!cache.isKeyInCache(taskName)){
            cache.put(new Element(taskName,new Task()));
        }

        cache.flush();

    }
}
