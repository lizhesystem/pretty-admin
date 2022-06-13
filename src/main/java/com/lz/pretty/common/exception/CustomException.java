package com.lz.pretty.common.exception;

import com.lz.pretty.common.constant.CustomExceptionType;

/**
 * 类描述:
 * 用户自定义异常
 *
 * @author lz
 * @create 2022-06-13 13:43
 */
public class CustomException extends RuntimeException {

    private int code;
    private String message;

    public CustomException() {
    }

    public CustomException(CustomExceptionType exceptionTypeEnum) {
        this.code = exceptionTypeEnum.getCode();
        this.message = exceptionTypeEnum.getTypeDesc();
    }

    public CustomException(CustomExceptionType exceptionType, String message) {
        this.code = exceptionType.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
