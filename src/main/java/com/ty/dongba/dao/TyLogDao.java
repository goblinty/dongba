package com.ty.dongba.dao;

import com.ty.dongba.entity.TyLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 数据层
 */

@Mapper
public interface TyLogDao {

    /**
     * 分页查询 logs
     * 可以选择有没有 username、
     * @return
     */
    List<TyLog> findPageLogs(@Param("username") String username);

    /**
     * 用于计算总数
     * @param username
     * @return
     */
    /*int getRowCount(@Param("username") String username);*/

    /**
     * 删除log
     * @param ids
     * @return
     */
    int deleteLogsByIds(@Param("ids")Integer[] ids);

    /**
     * 添加日志
     * @param log
     * @return
     */
    int insertLog(TyLog log);
}
