package com.aed.app.exception;

/**
 * @author liudongxu06
 * @date 2018/7/5
 */
public class ApiException extends RuntimeException{
    protected Integer errorCode;

    public ApiException(String message, Throwable cause, Integer errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ApiException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}
