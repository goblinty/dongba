package com.ty.dongba.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TyUserDao {

    int getUserCountByDeptId (Integer DeptId);
}
