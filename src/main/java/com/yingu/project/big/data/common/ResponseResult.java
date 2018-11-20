package com.yingu.project.big.data.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author huangkunhao
 * @date 2018/1/15
 * @Description
 */
@Getter
@Setter
@ToString
@ApiModel(value = "响应实体")
public class ResponseResult implements Serializable {

    @ApiModelProperty(value = "业务码", required = true, example = "1000")
    protected String code;
    @ApiModelProperty(value = "业务描述", required = true, example = "调用成功")
    protected String msg;
    @ApiModelProperty(value = "业务数据，如调用成功，数据模型参见响应消息部分", required = true, example = "业务数据，如调用成功，数据模型参见响应消息部分")
    protected Object data;

    public ResponseResult() {
    }

    public ResponseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult ok(){
        return new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescription());
    }

    public static ResponseResult ok(String message){
        return new ResponseResult(ResponseCode.SUCCESS.getCode(), message);
    }

    public static ResponseResult ok(Object data){
        return new ResponseResult(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getDescription(),data);
    }

    public static ResponseResult ok(String message,Object data){
        return new ResponseResult(ResponseCode.SUCCESS.getCode(), message,data);
    }


    public static ResponseResult fail(){
        return new ResponseResult(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDescription());
    }

    public static ResponseResult fail(String message){
        return new ResponseResult(ResponseCode.ERROR.getCode(), message);
    }

    public static ResponseResult fail(Object data){
        return new ResponseResult(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDescription(),data);
    }

    public static ResponseResult fail(String message,Object data){
        return new ResponseResult(ResponseCode.ERROR.getCode(), message,data);
    }

}
