package com.aed.app.bean;

/**
 * @author liudongxu06
 * @date 2018/7/5
 */
public class Result {
    public static final String COMMON_OK_MSG = "OK";
    public static final int COMMON_OK_CODE = 0;
    private static final Result COMMON_OK_RESULT = new Result(COMMON_OK_CODE,COMMON_OK_MSG);
    private Integer errcode;
    private String errmsg;
    private Object data;

    public Result() {
    }

    public Result(Integer errcode, String errmsg) {
        this.errcode = errcode;
        this.errmsg = errmsg;
    }

    public static Result buildOk(){
        return COMMON_OK_RESULT;
    }

    public static Result buildOk(String msg){
        return buildOk(msg,null);
    }

    public static Result buildOk(Object data){
        return buildOk(COMMON_OK_MSG,data);
    }

    public static Result buildOk(String msg,Object data){
        return buildResult(COMMON_OK_CODE,msg,data);
    }
    public static Result buildResult(Integer errcode,String msg,Object data){
        Result result = new Result();
        result.setErrcode(errcode);
        result.setErrmsg(msg);
        result.setData(data);
        return result;
    }
    public static Result buildCommonFail(String msg){
        return buildFail(100,msg);
    }
    public static Result buildFail(Integer errcode,String msg){
        return buildResult(errcode,msg,null);
    }
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
