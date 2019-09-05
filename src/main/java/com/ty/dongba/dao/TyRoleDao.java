package com.ty.dongba.dao;

import com.ty.dongba.entity.TyMenuRoleVo;
import com.ty.dongba.entity.TyRole;
import com.ty.dongba.vo.CheckBox;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TyRoleDao {

    List<TyRole> findRolesByPage(@Param("name") String name);

    //添加
    int insertRole(TyRole role);

    int deleteById(Integer id);

    /**
     * 使用 role 的id 来进行 查找回显
     * @param id
     * @return
     */
    TyMenuRoleVo findRoleById(Integer id);

    int updateRole(TyRole role);

    List<CheckBox> findObjects();
}
