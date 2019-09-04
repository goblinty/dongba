package com.ty.dongba.dao;

import com.ty.dongba.entity.TyMenuRoleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TyMenuRoleDao {

    /**
     * link tymenudao 2
     * 在删除菜单的时候，需要把 角色下面绑定的菜单也要删掉
     * @return
     */
    int deleteRoleByMenuId(@Param("menuId") Integer menuId);

    /**
     * 删除角色 要删除角色和菜单的数据
     */
    int deleteRoleByRoleId(Integer roleId);


    /**
     * 添加角色的时候也要添加 角色 - 菜单的信息
     */
    int insertObjRoleMenu(@Param("roleId")Integer roleId,@Param("menuIds")Integer[] menuIds);


}
