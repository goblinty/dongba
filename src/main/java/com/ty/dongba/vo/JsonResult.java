package com.ty.dongba.vo;

import java.io.Serializable;

/**
 * 封装返回 前端的数据
 */
public class JsonResult implements Serializable {


    private static final long serialVersionUID = -4244787796640513938L;

    //状态码 ， success 1    error 0
    private int state = 1;

    //状态信息
    private String message = "ok";

    //封装正确的数据
    private Object data;

    public JsonResult() {
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Object data) {
        this.data = data;
    }

    //出现异常时
    public JsonResult(Throwable t){

        this.state = 0;
        this.message = t.getMessage();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
