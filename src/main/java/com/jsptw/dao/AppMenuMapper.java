package com.jsptw.dao;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.jsptw.entity.AppMenu;
import com.jsptw.entity.AppMenuExample;

public interface AppMenuMapper {
    int countByExample(AppMenuExample example);

    int deleteByExample(AppMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppMenu record);

    int insertSelective(AppMenu record);

    List<AppMenu> selectByExample(AppMenuExample example);

    AppMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppMenu record, @Param("example") AppMenuExample example);

    int updateByExample(@Param("record") AppMenu record, @Param("example") AppMenuExample example);

    int updateByPrimaryKeySelective(AppMenu record);

    int updateByPrimaryKey(AppMenu record);
}