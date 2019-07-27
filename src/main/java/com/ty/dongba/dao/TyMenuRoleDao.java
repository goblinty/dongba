package com.ty.dongba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TyMenuRoleDao {

    /**
     * link tymenudao 2
     * 在删除菜单的时候，需要把 角色下面绑定的菜单也要删掉
     * @return
     */
    int deleteRoleByMenuId(@Param("menuId") Integer menuId);
}
