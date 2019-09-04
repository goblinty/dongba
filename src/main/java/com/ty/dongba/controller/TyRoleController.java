package com.ty.dongba.controller;

import com.github.pagehelper.PageInfo;
import com.ty.dongba.entity.TyMenuRoleVo;
import com.ty.dongba.entity.TyRole;
import com.ty.dongba.service.TyRoleService;
import com.ty.dongba.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role/")
public class TyRoleController {

    @Autowired
    private TyRoleService tyRoleService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name,Integer pageCurrent){

        PageInfo<TyRole> roleInfo = tyRoleService.findRoleByPage(name, pageCurrent);

        return new JsonResult(roleInfo);
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer roleId){

        tyRoleService.deleteRoleById(roleId);

        return new JsonResult("删除完成");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(TyRole role,Integer[] menuIds){

        tyRoleService.saveRoles(role,menuIds);
        return new JsonResult("insert ok ");
    }

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){

        TyMenuRoleVo roleVo = tyRoleService.findRoleMenuById(id);

        return new JsonResult(roleVo);
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(TyRole role,Integer[] menuIds){

        tyRoleService.updateRole(role,menuIds);

        return new JsonResult("update ok");
    }
}
