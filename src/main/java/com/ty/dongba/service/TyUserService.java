package com.ty.dongba.service;

import com.github.pagehelper.PageInfo;
import com.ty.dongba.entity.TyUser;
import com.ty.dongba.vo.TyUserDeptVo;

import java.util.Map;

public interface TyUserService {

    PageInfo<TyUserDeptVo> findPageUserDept(String username,Integer pageCurrent);

    int updateValidById(Integer id,Integer valid,String modifiedUser);

    int saveUserRole(TyUser tyUser,Integer[] roleIds);

    Map<String,Object> findUserDeptById(Integer userId);

    int updateUser(TyUser user,Integer[] roleIds);
}
