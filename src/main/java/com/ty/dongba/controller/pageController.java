package com.ty.dongba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 静态资源通用访问
 */

@Controller
@RequestMapping("/")
public class pageController {

    //返回首页
    @RequestMapping("doIndexUI")
    public String doIndexUI() {
        return "starter";
    }

    //自动跳转
    @RequestMapping("{module}/{page}")
    public String findPages(@PathVariable("page")String page){

        return "sys/"+page;
    }

    @RequestMapping("doPageUI")
    public String doPageUI(){

        return "common/page";
    }

}
