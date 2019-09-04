package com.ty.dongba.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TyRoleUserDao {

    int deleteUserByRoleId(Integer roleId);

}
