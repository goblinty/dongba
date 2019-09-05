package com.ty.dongba.dao;

import com.ty.dongba.entity.TyUser;
import com.ty.dongba.vo.TyUserDeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TyUserDao {

    int getUserCountByDeptId (Integer DeptId);

    List<TyUserDeptVo> findPageUserDept(@Param("username") String username);

    /**
     * 用户启用和禁用
     */
    int validById(@Param("id")Integer id,
                  @Param("valid") Integer valid,@Param("modifiedUser") String modifiedUser);


    int insertUser(TyUser tyUser);

    TyUserDeptVo findUserDeptById(Integer id);

    int updateUser(TyUser tyUser);
}
