package com.yao.utils;

/**
 * 通用的返回结果
 * @param <T>
 */
public class ResultT<T> {

    private Boolean success;

    private String code;

    private String message;

    private T data;

    public static final String SUCCESS_CODE="200";
    public static final String ERROR_CODE="500";
    public static final String SUCCESS_MESSAGE="成功";

    public ResultT(String code, String message) {
        this.success=false;
        this.code = code;
        this.message = message;
    }

    public ResultT() {

    }


    public ResultT ResultSuccess(String message) {
        this.success=true;
        this.code = SUCCESS_CODE;
        this.message = message;
        return this;
    }
    public ResultT ResultError(String message) {
        this.success=false;
        this.code =ERROR_CODE ;
        this.message = message;
        return this;
    }

    public ResultT(T data) {
        this.success=true;
        this.code = SUCCESS_CODE;
        this.message = SUCCESS_MESSAGE;
        this.data = data;
    }
    public ResultT(T data,String message) {
        this.success=true;
        this.code = SUCCESS_CODE;
        this.message = message;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultT{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}