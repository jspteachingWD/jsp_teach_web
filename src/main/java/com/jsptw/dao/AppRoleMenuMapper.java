package com.jsptw.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jsptw.entity.AppRoleMenu;
import com.jsptw.entity.AppRoleMenuExample;

public interface AppRoleMenuMapper {
    int countByExample(AppRoleMenuExample example);

    int deleteByExample(AppRoleMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppRoleMenu record);

    int insertSelective(AppRoleMenu record);

    List<AppRoleMenu> selectByExample(AppRoleMenuExample example);

    AppRoleMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppRoleMenu record, @Param("example") AppRoleMenuExample example);

    int updateByExample(@Param("record") AppRoleMenu record, @Param("example") AppRoleMenuExample example);

    int updateByPrimaryKeySelective(AppRoleMenu record);

    int updateByPrimaryKey(AppRoleMenu record);
}