package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingDepositsDetail;

import java.util.List;
import java.util.Map;

public interface InternetBankingDepositsDetailMapper {
    List<InternetBankingDepositsDetail> selectByDepositsId(Map<String, Object> map);
}