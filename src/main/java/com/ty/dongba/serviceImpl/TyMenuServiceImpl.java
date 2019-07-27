package com.ty.dongba.serviceImpl;

import com.ty.dongba.dao.TyMenuDao;
import com.ty.dongba.dao.TyMenuRoleDao;
import com.ty.dongba.entity.TyMenu;
import com.ty.dongba.exception.ServiceException;
import com.ty.dongba.service.TyMenuService;
import com.ty.dongba.vo.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class TyMenuServiceImpl implements TyMenuService {

    @Autowired
    private TyMenuDao tyMenuDao;


    @Override
    public List<Map<String, Object>> findPageMenu() {

        List<Map<String, Object>> pageMenus = tyMenuDao.findPageMenus();

        if (pageMenus == null || pageMenus.size() == 0)
            throw new ServiceException("没有查到菜单信息");
        return pageMenus;
    }


    @Autowired
    private TyMenuRoleDao tyMenuRoleDao;

    @Override
    public int deleteMenusById(Integer id) {

        if (id == null || id == 0) throw new ServiceException("请选择一个id");

        int sonCount = tyMenuDao.findSonCountMenuById(id);

        if (sonCount > 0) throw new ServiceException("请删除所有子菜单");

        //执行删除
        int rows = tyMenuDao.deleteMenuById(id);

        if (rows == 0) throw new ServiceException("删除失败");

        tyMenuRoleDao.deleteRoleByMenuId(id);

        return rows;
    }

    /**
     * 前端显示所有的 菜单
     * @return
     */
    @Override
    public List<Node> findZtreeMenuNodes() {

        List<Node> nodeList = tyMenuDao.findZtreeMenuNodes();

        if (nodeList == null || nodeList.size() ==0) throw new ServiceException("没有找到菜单");

        return nodeList;
    }

    @Override
    public int insertMenu(TyMenu tyMenu) {

        if (tyMenu == null ) throw new ServiceException("添加的数据不能为空");

        if (StringUtils.isEmpty(tyMenu.getName())) throw new ServiceException("插入的菜单名称不能为空");

        int rows = tyMenuDao.insertMenu(tyMenu);

        if (rows == 0) throw new ServiceException("添加失败");

        return rows;
    }

    @Override
    public int updateMenu(TyMenu tyMenu) {

        if (tyMenu == null ) throw new ServiceException("修改的数据不能为空");

        if (StringUtils.isEmpty(tyMenu.getName())) throw new ServiceException("修改的菜单名称不能为空");

        int rows = tyMenuDao.updatMeunById(tyMenu);

        if (rows == 0) throw new ServiceException("修改失败");

        return rows;
    }


}
