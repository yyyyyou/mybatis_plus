package com.yao.utils;

import java.util.HashMap;
import java.util.Map;

public class ResultData {
    public static Integer SUCCESS = 2000;//成功状态码
    public static Integer ERROR = 2001;//失败状态码
    private boolean isSuccess;//是否成功
    private Integer code;//返回成功码
    private String message;//返回消息
    private Map<Object, Object> data = new HashMap<>();//返回数据，map可以key,value形式返回

    //方法私有化，只能自己调用自己
    ResultData() {}


    //调用成功的方法
    public static ResultData ok() {
        ResultData resultData = new ResultData();
        resultData.setIsSuccess(true);
        resultData.setCode(SUCCESS);
        resultData.setMessage("成功");
        return resultData;
    }

    //调用失败方法
    public static ResultData fail() {
        ResultData resultData = new ResultData();
        resultData.setIsSuccess(false);
        resultData.setMessage("失败");
        resultData.setCode(ERROR);
        return resultData;
    }

    //返回数据(key,value形式)
    public ResultData data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    //返回数据直接是一个map集合
    public ResultData data(Map<Object, Object> map) {
        this.setData(map);
        return this;
    }

    //这下面是参数的set和get方法
    public boolean isSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public void setData(Map<Object, Object> data) {
        this.data = data;
    }
}