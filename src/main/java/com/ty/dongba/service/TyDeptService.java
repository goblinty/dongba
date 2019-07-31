package com.ty.dongba.service;

import com.ty.dongba.entity.TyDept;
import com.ty.dongba.vo.Node;

import java.util.List;
import java.util.Map;

public interface TyDeptService {

        List<Map<String,Object>> findDepts();

        /* 寻找部门 ，使用 ztree显示*/
        List<Node> findZtreeDeptNodes();

        int deleteObject(Integer id);

        int saveObject(TyDept tyDept);

        int updateObject(TyDept tyDept);
    }


