package com.ty.dongba.dao;

import com.ty.dongba.entity.TyDept;
import com.ty.dongba.vo.Node;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TyDeptDao {

    List<Map<String,Object>> findDept();


    TyDept findById(Integer id);

    /**
     * 根据部门id统计子部门的个数
     * @param id
     * @return
     */
    int getChildCount(Integer id);
    /**
     * 根据id 删除部门
     * @param id
     * @return
     */
    int deleteObject(Integer id);

    /**
     * 显示出 部门 的 ztree
     * @return
     */
    List<Node> findZtreeDeptNodes();

    int insertObject(TyDept entity);

    int updateObject(TyDept entity);
}
