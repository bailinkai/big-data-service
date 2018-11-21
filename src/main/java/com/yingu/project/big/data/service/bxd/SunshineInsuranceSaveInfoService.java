package com.yingu.project.big.data.service.bxd;


import com.alibaba.fastjson.JSONObject;
import com.yingu.project.big.data.common.ResponseResult;

public interface SunshineInsuranceSaveInfoService {
    boolean saveSunInfo(JSONObject jsonObject, String orderNum);
    ResponseResult getSunInfo(String orderNum);
}
