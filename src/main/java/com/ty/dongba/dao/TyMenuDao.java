package com.ty.dongba.dao;

import com.ty.dongba.entity.TyMenu;
import com.ty.dongba.vo.Node;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TyMenuDao {

    /**
     * 1
     * 查询 菜单 和其 子菜单k
     * 节约时间 此处 使用 map 来封装，
     * 一般情况 不推荐使用 map，因为 可读性比较差 而且 值的类型 不可控性
     * @return
     */
    List<Map<String,Object>> findPageMenus();

    /**
     * 2
     * 删除menu
     * @return
     */
    int deleteMenuById(@Param("id")Integer id);

    /**
     * 2 link TyMenuRoleDao 2
     * 在删除菜单的时候，需要检查是否有子菜单
     * @return
     */
    int findSonCountMenuById(@Param("parentId")Integer parentId);

    /**
     * 在添加或者修改的时候需要显示所有的菜单  使用 ztree 的结构
     *
     * 查出所有的 菜单id，如果有父id 也要显示
     * @return
     */
    List<Node> findZtreeMenuNodes();

    /**
     * 添加 menu
     * @param tyMenu
     * @return
     */
    int insertMenu(TyMenu tyMenu);

    /**
     * 更新菜单
     * @param tyMenu
     * @return
     */
    int updatMeunById(TyMenu tyMenu);

}
