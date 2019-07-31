package com.ty.dongba.controller;

import com.ty.dongba.entity.TyDept;
import com.ty.dongba.service.TyDeptService;
import com.ty.dongba.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept/")
public class TyDeptController {

    @Autowired
    private TyDeptService tyDeptService;

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects(){

        return new JsonResult(tyDeptService.findDepts());
    }

    @RequestMapping("doFindZTreeNodes")
    public JsonResult doFindZTreeNodes(){

        return new JsonResult(tyDeptService.findZtreeDeptNodes());
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){
        tyDeptService.deleteObject(id);
        return new JsonResult("delete OK");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(TyDept entity){
        tyDeptService.saveObject(entity);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(TyDept entity){
        tyDeptService.updateObject(entity);
        return new JsonResult("update ok");
    }


}
