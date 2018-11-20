package com.yingu.project.big.data.service.internetbank;

import com.yingu.project.big.data.common.ResponseResult;

import java.util.List;
import java.util.Map;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
public interface InternetBankService {

    boolean insertList(List<Map<String, Object>> dataList, String orderNum);

    ResponseResult getDataByOrderNum(Map<String, Object> map);
}
