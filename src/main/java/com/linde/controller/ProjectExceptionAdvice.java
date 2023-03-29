package com.linde.controller;

import com.linde.exception.BusinessException;
import com.linde.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler(SystemException.class)
    public  Result doSystemException(SystemException systemException){
        //记录日志
        //发送信息给运维
        //发送邮件给开发人员


        return new Result(systemException.getCode(),null,systemException.getMessage());
    }

    @ExceptionHandler(BusinessException.class)
    public  Result doBusinessException(BusinessException businessException){
        //记录日志
        //发送信息给运维
        //发送邮件给开发人员

        return new Result(businessException.getCode(),null,businessException.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public  Result doException(Exception exception){

        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后尝试！");
    }
}