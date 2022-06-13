package com.lz.pretty.common.constant;

/**
 * 类描述:异常的类型
 *
 * @author lz
 * @create 2022-06-13 13:39
 */
public enum CustomExceptionType {
    USER_INPUT_ERROR(400, "用户输入异常"),
    SYSTEM_ERROR(500, "系统服务异常"),
    OTHER_ERROR(999, "其他未知异常");

    CustomExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    private int code;
    private String typeDesc;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}
