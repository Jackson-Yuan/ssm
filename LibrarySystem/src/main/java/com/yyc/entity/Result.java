package com.yyc.entity;

/**
 * Created by yyc on 2018/8/7.
 */
/**
 * 所有json返回的对象都用(泛型)*/
public class Result<T> {
    private Boolean success;

    private T data;

    private String message;

    public Result() {
    }

    public Result(Boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
