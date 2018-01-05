package com.example;

import net.sf.ehcache.CacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import net.sf.ehcache.constructs.web.ShutdownListener;

@SpringBootApplication
public class WeixinTestApplication {

    public static void main(String[] args) {
    	System.setProperty("net.sf.ehcache.enableShutdownHook", "true");
        SpringApplication.run(WeixinTestApplication.class, args);
    }

    /**
     * 加入Ehcache的监听器
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean<ShutdownListener> testListenerRegistration() {
        ServletListenerRegistrationBean<ShutdownListener> registration = new ServletListenerRegistrationBean<ShutdownListener>(
                new ShutdownListener());
        return registration;
    }

    @Bean
    public CacheManager cacheManager() {
        return CacheManager.newInstance();
    }

}
