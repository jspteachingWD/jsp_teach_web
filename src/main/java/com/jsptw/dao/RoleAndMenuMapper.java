package com.jsptw.dao;

import org.apache.ibatis.annotations.Param;

import com.jsptw.entity.AppMenu;
import com.jsptw.entity.AppRole;

import java.util.List;
import java.util.Set;

/**
 * * 描    述：查询用户角色与权限类
 */
public interface RoleAndMenuMapper {

    /**
     * 通过用户id获取角色
     * @param id        userID
     * @param status    0:禁用,1:启用
     * @return          List<AppRole>
     */
    Set<AppRole> getAppRolesByUserId(@Param("id")Integer id, @Param("status")Integer status);

    /**
     * 通过用户id获取权限
     * @param id        userID
     * @param navMenu   0:不显示在导航菜单中,1:显示在导航菜单中
     * @return          List<AppMenu>
     */
    List<AppMenu> getAppMenusByUserId(@Param("id")Integer id, @Param("navMenu")Integer navMenu);


    /**
     * 通过角色id获取权限
     * @param id        roleID
     * @param navMenu   0:不显示在导航菜单中,1:显示在导航菜单中
     * @return          List<AppMenu>
     */
    Set<AppMenu> getAppMenusByRoleId(@Param("id")Integer id, @Param("navMenu")Integer navMenu);

}
