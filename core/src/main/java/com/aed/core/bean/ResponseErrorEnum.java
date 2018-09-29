package com.aed.core.bean;

/**
 * @author liudongxu06
 * @date 2018/9/28
 */
public enum ResponseErrorEnum {
    NORMAl(0,"ok"),
    ILLEGAL_PARAMS(100,"参数错误");

    private Integer errcode;
    private String msg;

    ResponseErrorEnum(Integer errcode, String msg) {
        this.errcode = errcode;
        this.msg = msg;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
