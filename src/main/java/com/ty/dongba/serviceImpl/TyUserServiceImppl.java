package com.ty.dongba.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ty.dongba.dao.TyRoleUserDao;
import com.ty.dongba.dao.TyUserDao;
import com.ty.dongba.entity.TyUser;
import com.ty.dongba.exception.ServiceException;
import com.ty.dongba.service.TyUserService;
import com.ty.dongba.vo.TyUserDeptVo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TyUserServiceImppl implements TyUserService {


    @Autowired
    private TyUserDao tyUserDao;

    @Autowired
    private TyRoleUserDao tyRoleUserDao;

    @Override
    public PageInfo<TyUserDeptVo> findPageUserDept(String username, Integer pageCurrent) {

        if (pageCurrent == null || pageCurrent < 1 ) throw new ServiceException("当前的页码值不对");

        PageHelper.startPage(pageCurrent,4);
        List<TyUserDeptVo> list = tyUserDao.findPageUserDept(username);

        PageInfo<TyUserDeptVo> info = new PageInfo<>(list);

        return info;
    }

    @Override
    public int updateValidById(Integer id, Integer valid, String modifiedUser) {

        //验证参数合法性
        if(id == null || id < 1 ) throw new ServiceException("要修改状态的用户不能为空id");

        if(valid != 1 && valid != 0) throw new ServiceException("请求的状态参数不合法");

        if (StringUtils.isEmpty(modifiedUser)) throw new ServiceException("修改的用户不能为空");

        int rows = 0;

        try {

            rows = tyUserDao.validById(id, valid, modifiedUser);
        }catch (Exception e){

            e.printStackTrace();

            throw new ServiceException("底层出错了");
        }
        if (rows == 0) throw new ServiceException("修改用户状态失败 了");
        return rows;
    }

    @Override
    public int saveUserRole(TyUser tyUser, Integer[] roleIds) {

        if (tyUser == null) throw new ServiceException("保存的对象不能为空");

        if (StringUtils.isEmpty(tyUser.getUsername())) throw new ServiceException("新加入的用户名不能为空");

        if (roleIds == null || roleIds.length == 0) throw new ServiceException("知晓要为用户指定一个角色");

        //将数据写入数据库
        String salt = UUID.randomUUID().toString();

        tyUser.setSalt(salt);

        //加密
        SimpleHash sHash = new SimpleHash("MD5", tyUser.getPassword(), salt);
        tyUser.setPassword(sHash.toHex());

        int rows = tyUserDao.insertUser(tyUser);

        tyRoleUserDao.insertUserRole(tyUser.getId(),roleIds);

        if (rows == 0) throw new ServiceException("添加用户失败");

        return rows;
    }

    @Override
    public Map<String, Object> findUserDeptById(Integer userId) {

        if (userId == null || userId <= 0) throw new ServiceException("输入的用户id不对");

        //进行查询，获得 vo
        TyUserDeptVo userDeptVo = tyUserDao.findUserDeptById(userId);

        if (userDeptVo == null) throw new ServiceException("此用户不存在");

        List<Integer> roleIds = tyRoleUserDao.findRoleIdsByUserId(userId);

        if (roleIds == null || roleIds.size() == 0) throw new ServiceException("查找的用户必须要有个角色");

        //进行数据的封装
        HashMap<String, Object> map = new HashMap<>();
        map.put("user",userDeptVo);
        map.put("roleIds",roleIds);

        return map;
    }

    @Override
    public int updateUser(TyUser user, Integer[] roleIds) {

        //1.参数有效性验证
        if(user==null)
            throw new IllegalArgumentException("保存对象不能为空");
        if(StringUtils.isEmpty(user.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");
        if(roleIds==null||roleIds.length==0)
            throw new IllegalArgumentException("必须为其指定角色");
        //其它验证自己实现，例如用户名已经存在，密码长度，...

        int rows = tyUserDao.updateUser(user);

        //用户关系数据
        tyRoleUserDao.deleteUserRoleByUserId(user.getId());
        tyRoleUserDao.insertUserRole(user.getId(),roleIds);

        if (rows == 0) throw new ServiceException("修改用户失败");
        return rows;
    }
}
