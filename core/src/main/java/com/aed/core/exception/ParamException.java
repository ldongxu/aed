package com.aed.core.exception;

/**
 * @author liudongxu06
 * @date 2018/7/5
 */
public class ParamException extends RuntimeException{
    public ParamException() {
        super("参数异常");
    }

    public ParamException(String message) {
        super(message);
    }
}
