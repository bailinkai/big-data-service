package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingDepositsDetail;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface InternetBankingDepositsDetailMapper extends MyMapper<InternetBankingDepositsDetail> {
    List<InternetBankingDepositsDetail> selectByDepositsId(Map<String, Object> map);
}