package com.yingu.project.big.data.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author huangkunhao
 * @date 2018/1/15
 * @Description
 */
@Getter
@NoArgsConstructor
public enum ResponseCode {

    SUCCESS("1000", "成功"),
    ERROR("1001", "失败"),
    PARAM_INVALID("1002", "参数异常");


    private String code;
    private String description;

    ResponseCode(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
