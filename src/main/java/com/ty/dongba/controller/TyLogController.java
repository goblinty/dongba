package com.ty.dongba.controller;

import com.github.pagehelper.PageInfo;
import com.ty.dongba.entity.TyLog;
import com.ty.dongba.service.TyLogService;
import com.ty.dongba.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log/")
public class TyLogController {

    @Autowired
    private TyLogService tyLogService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Integer pageNum){

        PageInfo<TyLog> pageLogs = tyLogService.getPageLogs(username, pageNum);

        return new JsonResult(pageLogs);
    }

    @RequestMapping("doDeleteObjById")
    public JsonResult doDeleteObjById(Integer[] ids){

        tyLogService.deleteLogs(ids);

        return new JsonResult("delete ok lelelel");
    }

    //空余的 插入之后在做，需要 aop
}
