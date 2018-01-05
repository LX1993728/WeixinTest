package com.example.service;

import com.example.po.InputMessage;

/**
 * 用户查询  和添加用户
 */
public interface UserService {
    // 根据用户的微信唯一标示 进行判断 该用户是否已经在ehcache中存在
    public Boolean isRegisteredByWXName(InputMessage inputMessage);

    // 将用户存入ehcache中
    public Boolean registerUser(InputMessage inputMessage);
}
