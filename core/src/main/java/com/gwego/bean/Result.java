package com.gwego.bean;

/**
 * @author liudongxu06
 * @date 2018/7/5
 */
public class Result {
    private Integer errcode;
    private String errmsg;
    private Object data;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
