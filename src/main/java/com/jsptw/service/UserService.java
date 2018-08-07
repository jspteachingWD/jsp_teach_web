package com.jsptw.service;

import com.alibaba.fastjson.JSONObject;
import com.jsptw.entity.AppUser;

import java.util.List;

public interface UserService {

    List<AppUser> getUserList();

    AppUser getUserByUserName(String userName) throws Exception;

    Integer saveUser(JSONObject object) throws Exception ;

}
