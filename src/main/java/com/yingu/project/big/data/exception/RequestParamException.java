package com.yingu.project.big.data.exception;


import com.yingu.project.big.data.common.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author huangkunhao
 * @date 2018/1/12
 * @Description 请求参数异常
 */
@Getter
@Setter
public class RequestParamException extends BigDataBaseException{

    private Integer code;

    public RequestParamException(String message){
        super(message);
        this.code = ResponseCode.PARAM_INVALID.getCode();
    }

    public RequestParamException(Integer code, String message){
        super(message);
        this.code = code;
    }
}
