package com.ty.dongba.controller;

import com.ty.dongba.entity.TyMenu;
import com.ty.dongba.service.TyMenuService;
import com.ty.dongba.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu/")
public class TyMenuController {

    @Autowired
    private TyMenuService tyMenuService;

    @RequestMapping("/doFindObjects")
    public JsonResult doFindObjects(){

        return new JsonResult(tyMenuService.findPageMenu());
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){

        tyMenuService.deleteMenusById(id);

        return new JsonResult("delete ok");
    }

    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes(){

        return new JsonResult(tyMenuService.findZtreeMenuNodes());
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(TyMenu tyMenu){

        tyMenuService.insertMenu(tyMenu);

        return new JsonResult("insert ok");
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(TyMenu tyMenu){

        tyMenuService.updateMenu(tyMenu);

        return new JsonResult("update ok");
    }
}
