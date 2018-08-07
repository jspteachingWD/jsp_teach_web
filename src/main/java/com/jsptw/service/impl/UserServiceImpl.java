package com.jsptw.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jsptw.dao.AppUserMapper;
import com.jsptw.dao.AppUserRoleMapper;
import com.jsptw.entity.AppUser;
import com.jsptw.entity.AppUserExample;
import com.jsptw.entity.AppUserRole;
import com.jsptw.exception.DuplicatedUserException;
import com.jsptw.service.UserService;
import com.jsptw.util.PasswordMd5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    protected final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private AppUserMapper userMapper;
    @Autowired
    private AppUserRoleMapper appUserRoleMapper;

    public List<AppUser> getUserList() {
        AppUserExample example = new AppUserExample();
        return userMapper.selectByExample(example);
    }

    @Override
    public AppUser getUserByUserName(String userName) throws Exception {
        AppUserExample example = new AppUserExample();
        example.createCriteria().andUsernameEqualTo(userName);
        List<AppUser> users = userMapper.selectByExample(example);
        if (null == users){
            throw new Exception("用户不存在！");
        }
        return users.get(0);
    }

    @Override
    public Integer saveUser(JSONObject object) throws DuplicatedUserException {
        Date date = new Date();
        AppUser appUser = JSONObject.parseObject(object.toJSONString(), AppUser.class);

        AppUserExample example = new AppUserExample();
        example.createCriteria().andUsernameEqualTo(appUser.getUsername());
        List<AppUser> appUsers = userMapper.selectByExample(example);
        if (null != appUsers && appUsers.size() > 0) {
            throw new DuplicatedUserException();
        }

        appUser.setPassword(PasswordMd5.standPwdEncoder(appUser.getPassword()));
        appUser.setCreatetime(date);
        appUser.setLastupdate(date);
        appUser.setStatus(1);//用户状态1可用
        userMapper.insertSelective(appUser);

        AppUserRole appUserRole = new AppUserRole();
        appUserRole.setRoleid(2);//普通用户角色
        appUserRole.setUserid(appUser.getId());
        appUserRoleMapper.insertSelective(appUserRole);

        return null;
    }
}
