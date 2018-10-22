package com.aed.core.bean;

/**
 * @author liudongxu06
 * @date 2018/9/28
 */
public enum ResponseErrorEnum {
    NORMAl(0,"ok"),
    ILLEGAL_PARAMS(100,"参数错误"),
    CMS_LOGINED(200,"管理员用户已登陆"),
    ILLEGAL_CMS_LOGIN_PARAMS(201,"管理员登陆账号或密码错误"),
    NOT_EXIST_CMS_USER(202,"管理员账号不存在"),
    NOT_EXIST_APP_USER(300,"账号不存在"),
    ILLEGAL_APP_LOGIN_PARAMS(301,"账号或密码错误"),
    APP_LOGINED(302,"用户已登陆");

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
