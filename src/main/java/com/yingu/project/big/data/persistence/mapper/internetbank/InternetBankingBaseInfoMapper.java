package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingBaseInfo;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface InternetBankingBaseInfoMapper extends MyMapper<InternetBankingBaseInfo> {

    void updateByOrderNumAndFullCardNum(InternetBankingBaseInfo baseInfo);

    List<InternetBankingBaseInfo> selectByOrderNum(Map<String, Object> map);
}