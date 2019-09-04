package com.ty.dongba.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dongba.dao.TyMenuRoleDao;
import com.ty.dongba.dao.TyRoleDao;
import com.ty.dongba.dao.TyRoleUserDao;
import com.ty.dongba.entity.TyMenuRoleVo;
import com.ty.dongba.entity.TyRole;
import com.ty.dongba.exception.ServiceException;
import com.ty.dongba.service.TyRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.sql.rowset.serial.SerialException;
import java.util.List;

@Service
public class TyRoleServiceImpl implements TyRoleService {

    @Autowired
    private TyRoleDao tyRoleDao;

    @Autowired
    private TyRoleUserDao tyRoleUserDao;

    @Autowired
    private TyMenuRoleDao tyMenuRoleDao;

    @Override
    public PageInfo<TyRole> findRoleByPage(String name,Integer startIndex) {

        Integer pageSize = 4;

        PageHelper.startPage(startIndex,pageSize);
        List<TyRole> rolesByPage = tyRoleDao.findRolesByPage(name);

        PageInfo<TyRole> info = new PageInfo<>(rolesByPage);

        return info;
    }

    /**
     * 删除角色需要删除 绑定的菜单和 用户
     * @param roleId
     * @return
     */
    @Override
    public int deleteRoleById(Integer roleId) {

        //判断数据
        if (roleId == null || roleId < 1) throw new ServiceException("需要删除的角色id不能为空");

        tyMenuRoleDao.deleteRoleByRoleId(roleId);
        tyRoleUserDao.deleteUserByRoleId(roleId);
        int rows = tyRoleDao.deleteById(roleId);

        if (rows == 0) throw new ServiceException("删除失败，没有找到角色数据");

        return rows;
    }


    /**
     * 添加角色信息，需要去插入 menuIds
     * @param role
     * @param menuIds
     * @return
     */
    @Override
    public int saveRoles(TyRole role, Integer[] menuIds) {

        //参数合法性
        if (role == null) throw new ServiceException("插入的role不能为空");

        if (StringUtils.isEmpty(role.getName())) throw  new ServiceException("必须输入角色名称");

        if (menuIds == null || menuIds.length == 0) throw new ServiceException("必须要有角色菜单");

        //保存数据
        int row = tyRoleDao.insertRole(role);

        tyMenuRoleDao.insertObjRoleMenu(role.getId(),menuIds);

        if (row == 0) throw new ServiceException("插入失败了 qaq");
        return row;
    }

    @Override
    public TyMenuRoleVo findRoleMenuById(Integer id) {

        if (id == null || id <=0) throw new ServiceException("请输入一个正确的id");

        TyMenuRoleVo mrVo = tyRoleDao.findRoleById(id);

        if (mrVo == null) throw new ServiceException("没有查到角色数据");

        return mrVo;
    }

    @Override
    public int updateRole(TyRole role,Integer[] menusId) {

        //在更新之前需要 进行删除之前的菜单数据再重新插入

        if (role == null ) throw new ServiceException("需要修改的角色不能为空");

        if (StringUtils.isEmpty(role.getName())) throw new ServiceException("需要修改的角色名不能为空");

        if (role.getId() == null) throw new ServiceException("角色id修改不能为空");

        if (menusId == null || menusId.length ==0) throw new ServiceException("要修改的权限不能为空");

        int rows = tyRoleDao.updateRole(role);

        if (rows == 0) throw new ServiceException("修改角色失败");

        //更新菜单角色关系数据
        tyMenuRoleDao.deleteRoleByRoleId(role.getId());
        tyMenuRoleDao.insertObjRoleMenu(role.getId(),menusId);

        return rows;
    }
}
