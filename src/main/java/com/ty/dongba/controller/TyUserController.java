package com.ty.dongba.controller;

import com.github.pagehelper.PageInfo;
import com.ty.dongba.entity.TyUser;
import com.ty.dongba.service.TyUserService;
import com.ty.dongba.vo.JsonResult;
import com.ty.dongba.vo.TyUserDeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user/")
public class TyUserController {

    @Autowired
    private TyUserService tyUserService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Integer pageNum){

        PageInfo<TyUserDeptVo> info = tyUserService.findPageUserDept(username, pageNum);

        return new JsonResult(info);
    }

    @RequestMapping("doValidById")
    public JsonResult doUpdateValidById(Integer id,Integer valid){

        tyUserService.updateValidById(id,valid,"admin");

        return new JsonResult("update ok");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(TyUser tyUser,Integer[] roleIds){

        tyUserService.saveUserRole(tyUser, roleIds);

        return new JsonResult("save user ok");
    }

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id){

        Map<String, Object> map = tyUserService.findUserDeptById(id);

        return new JsonResult(map);
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(TyUser user,Integer[] roelIds){

        tyUserService.updateUser(user,roelIds);

        return  new JsonResult("update user ok");
    }

}
