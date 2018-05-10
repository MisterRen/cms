package com.xinchuan.console.common;

import java.io.Serializable;

/**
 * <p>
 * ajax返回值包装类
 * </p>
 * Copyright (C) 2018 东方CJ. All Rights Reserved.
 *
 * @author xinhe.REN (Create on:2018年05月10日)
 * @version 1.0
 * @fileName AjaxMsg.java
 */
public class AjaxMsg<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
