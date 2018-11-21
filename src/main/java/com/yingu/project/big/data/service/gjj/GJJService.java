package com.yingu.project.big.data.service.gjj;

import com.yingu.project.big.data.common.ResponseResult;

/**
 * @author huangkunhao
 * @date 2018/11/21
 * @Description
 */
public interface GjjService {

    boolean saveInfo(String orderNum,String dataString);

    ResponseResult getGJJInfo(String orderNum);
}
