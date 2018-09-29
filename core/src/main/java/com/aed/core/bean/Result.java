package com.aed.core.bean;

/**
 * @author liudongxu06
 * @date 2018/7/5
 */
public class Result {
    private static final Result COMMON_OK_RESULT = new Result(ResponseErrorEnum.NORMAl, null);
    private Integer errcode;
    private String msg;
    private Object data;

    private Result() {
    }

    private Result(ResponseErrorEnum responseErrorEnum, Object data) {
        this.data = data;
        this.errcode = responseErrorEnum.getErrcode();
        this.msg = responseErrorEnum.getMsg();
    }


    public static Result buildOk() {
        return COMMON_OK_RESULT;
    }


    public static Result buildOkWithData(Object data) {
        return new Result(ResponseErrorEnum.NORMAl, data);
    }

    public static Result buildFail(ResponseErrorEnum errEnum) {
        return new Result(errEnum, null);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
