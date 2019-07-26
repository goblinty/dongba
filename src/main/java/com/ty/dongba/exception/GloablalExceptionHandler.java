package com.ty.dongba.exception;

import com.ty.dongba.vo.JsonResult;
import org.apache.ibatis.binding.BindingException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常类
 * 捕获各种异常
 */

@RestControllerAdvice
public class GloablalExceptionHandler{

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e){

        e.printStackTrace();

        return new JsonResult(e);
    }

    //绑定异常
    @ExceptionHandler(BindingException.class)
    public JsonResult doHandleBindException(BindException e){

        BindingResult br = e.getBindingResult();

        FieldError fr = br.getFieldError();

        JsonResult jsonResult = new JsonResult();

        jsonResult.setState(0);
        jsonResult.setMessage(fr.getDefaultMessage());

        return jsonResult;
    }


}
