package com.lz.pretty.common.domain;

import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.exception.CustomException;
import lombok.Data;

/**
 * 类描述:
 * 接口数据请求统一响应数据结构
 *
 * @author lz
 * @create 2022-06-13 13:48
 */

@Data
public class AjaxResponse {

    private boolean isok;  //请求是否处理成功
    private int code;       //请求响应状态码
    private String message;  //请求结果描述信息
    private Object data;     //请求结果数据（通常用于查询操作）

    public AjaxResponse() {
    }

    //请求出现异常时的响应数据封装
    public static AjaxResponse error(CustomException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }


    // 请求出现异常时的响应数据封装
    public static AjaxResponse error(CustomExceptionType customExceptionType, String errorMessage) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }


    //请求成功的响应，不带查询数据（用于删除、修改、新增接口）
    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        return ajaxResponse;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
