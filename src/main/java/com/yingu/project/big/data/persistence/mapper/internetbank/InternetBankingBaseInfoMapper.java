package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingBaseInfo;

import java.util.List;
import java.util.Map;

public interface InternetBankingBaseInfoMapper {

    void updateByOrderNumAndFullCardNum(InternetBankingBaseInfo baseInfo);

    List<InternetBankingBaseInfo> selectByOrderNum(Map<String, Object> map);
}