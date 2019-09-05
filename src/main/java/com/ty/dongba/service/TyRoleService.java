package com.ty.dongba.service;

import com.github.pagehelper.PageInfo;
import com.ty.dongba.entity.TyMenuRoleVo;
import com.ty.dongba.entity.TyRole;
import com.ty.dongba.vo.CheckBox;

import java.util.List;

public interface TyRoleService {

    PageInfo<TyRole> findRoleByPage(String name,Integer startIndex);

    int deleteRoleById(Integer roleId);

    int saveRoles(TyRole role,Integer[] menuIds);

    TyMenuRoleVo findRoleMenuById(Integer id);

    int updateRole(TyRole role,Integer[] menusId);

    List<CheckBox> findRoleUser();
}
