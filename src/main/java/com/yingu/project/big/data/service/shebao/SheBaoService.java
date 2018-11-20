package com.yingu.project.big.data.service.shebao;

import com.yingu.project.big.data.common.ResponseResult;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
public interface SheBaoService {


    boolean saveInfo(String oderNum, String dataString);

    ResponseResult getSheBaoInfo(String orderNum);

}
