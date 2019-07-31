package com.ty.dongba.serviceImpl;

import com.ty.dongba.dao.TyDeptDao;
import com.ty.dongba.dao.TyUserDao;
import com.ty.dongba.entity.TyDept;
import com.ty.dongba.exception.ServiceException;
import com.ty.dongba.service.TyDeptService;
import com.ty.dongba.vo.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class TyDeptServiceImpl implements TyDeptService {

    @Autowired
    private TyDeptDao tyDeptDao;
    @Autowired
    private TyUserDao tyUserDao;

    @Override
    public List<Map<String, Object>> findDepts() {

        return tyDeptDao.findDept();
    }

    @Override
    public List<Node> findZtreeDeptNodes() {

        return tyDeptDao.findZtreeDeptNodes();
    }

    @Override
    public int deleteObject(Integer id) {
        //1.合法性验证
        if(id==null||id<=0)
            throw new ServiceException("数据不合法,id="+id);
        //2.执行删除操作
        //2.1判定此id对应的菜单是否有子元素
        int childCount= tyDeptDao.getChildCount(id);
        if(childCount>0)
            throw new ServiceException("此元素有子元素，不允许删除");
        //2.2判定此部门是否有用户
        int userCount= tyUserDao.getUserCountByDeptId(id);
        if(userCount>0)
            throw new ServiceException("此部门有员工，不允许对部门进行删除");
        //2.2判定此部门是否已经被用户使用,假如有则拒绝删除
        //2.3执行删除操作
        int rows= tyDeptDao.deleteObject(id);
        if(rows==0)
            throw new ServiceException("此信息可能已经不存在");
        return rows;

    }

    @Override
    public int saveObject(TyDept tyDept) {
        //1.合法验证
        if(tyDept==null)
            throw new ServiceException("保存对象不能为空");
        if(StringUtils.isEmpty(tyDept.getName()))
            throw new ServiceException("部门名不能为空");
        int rows;
        //2.保存数据
        try{
            rows= tyDeptDao.insertObject(tyDept);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServiceException("保存失败");
        }
        //3.返回数据
        return rows;

    }

    @Override
    public int updateObject(TyDept tyDept) {
        //1.合法验证
        if(tyDept==null)
            throw new ServiceException("保存对象不能为空");
        if(StringUtils.isEmpty(tyDept.getName()))
            throw new ServiceException("部门名不能为空");

        //2.更新数据
        int rows= tyDeptDao.updateObject(tyDept);
        if(rows==0)
            throw new ServiceException("记录可能已经不存在");
        //3.返回数据
        return rows;

    }
}
