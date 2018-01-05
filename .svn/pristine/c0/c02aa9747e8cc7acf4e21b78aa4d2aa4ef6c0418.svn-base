package com.example.po;

import java.io.Serializable;

/**
 *  定义 微信用户
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long currentTaskNum; // 任务编号
    private String name; // 用户姓名，由用户自己输入
    private String orgName; // 当前用户属于的组织名 由用户输入的  1-用户名 进行决定
    private String wxUserName; // 该用户在当前微信公众号中的唯一标示 —— 也是当前对象的主键

    public Long getCurrentTaskNum() {
        return currentTaskNum;
    }

    public void setCurrentTaskNum(Long currentTaskNum) {
        this.currentTaskNum = currentTaskNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getWxUserName() {
        return wxUserName;
    }

    public void setWxUserName(String wxUserName) {
        this.wxUserName = wxUserName;
    }
}
