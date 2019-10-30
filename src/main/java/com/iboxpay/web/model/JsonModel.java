package com.iboxpay.web.model;

import java.util.List;

public class JsonModel<T> {

    private Integer code;
    private String msg;
    private T obj;
    private List<T> rows;
    private Integer total;

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

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "JsonModel [code=" + code + ", msg=" + msg + ", obj=" + obj
                + ", rows=" + rows + ", total=" + total + "]";
    }
}
