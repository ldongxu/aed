package com.aed.common;

import com.aed.core.bean.ResponseErrorEnum;
import com.aed.core.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.UnexpectedTypeException;

/**
 * @author liudongxu06
 * @date 2018/9/28
 */
@ControllerAdvice
public class RestExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(UnexpectedTypeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private Result illegalParamsExceptionHandler(UnexpectedTypeException e){
        logger.error("请求参数不合法！",e);
        return Result.buildFail(ResponseErrorEnum.ILLEGAL_PARAMS);
    }
}
