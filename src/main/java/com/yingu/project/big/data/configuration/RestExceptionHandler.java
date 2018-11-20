package com.yingu.project.big.data.configuration;

import com.yingu.project.big.data.common.ResponseCode;
import com.yingu.project.big.data.common.ResponseResult;

import com.yingu.project.big.data.exception.RequestParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author huangkunhao
 * @date 2018/1/12
 * @Description 统一异常处理
 */
@Slf4j
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {


    @ExceptionHandler(RequestParamException.class)
    private ResponseResult paramExceptionHandler(RequestParamException e){
        log.info("Request Param Exception : {}", e.getMessage());
        ResponseResult res = new ResponseResult(e.getCode(), e.getMessage());
        return res;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus
    private ResponseResult exceptionHandler(Exception e){
        log.error("Exception", e);
        ResponseResult res = new ResponseResult(ResponseCode.ERROR.getCode(), e.getMessage());
        return res;
    }


}
