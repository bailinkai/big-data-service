package com.yingu.project.big.data.service.bxd;

import com.yingu.project.big.data.common.ResponseResult;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
public interface InsuranceService {


    boolean saveInfo(String orderNum, String stringData);

    ResponseResult getBXDInfo(String orderNum);

    ResponseResult getAllInfo(String orderNum);
}
