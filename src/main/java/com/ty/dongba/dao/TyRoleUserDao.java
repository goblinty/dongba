package com.ty.dongba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

@Mapper
public interface TyRoleUserDao {

    int deleteUserByRoleId(Integer roleId);

    int insertUserRole(@Param("userId")Integer userId,
                   @Param("roleIds")Integer[] roles);

    List<Integer> findRoleIdsByUserId(Integer id);

    int deleteUserRoleByUserId(Integer userId);
}
