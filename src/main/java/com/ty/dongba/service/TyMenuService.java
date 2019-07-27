package com.ty.dongba.service;

import com.ty.dongba.entity.TyMenu;
import com.ty.dongba.vo.Node;

import java.util.List;
import java.util.Map;

public interface TyMenuService {

    List<Map<String,Object>> findPageMenu();

    int deleteMenusById(Integer id);

    List<Node> findZtreeMenuNodes();

    int insertMenu(TyMenu tyMenu);

    int updateMenu(TyMenu tyMenu);
}
