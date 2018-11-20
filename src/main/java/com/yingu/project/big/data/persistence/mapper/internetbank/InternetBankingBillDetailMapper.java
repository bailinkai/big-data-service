package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingBillDetail;

import java.util.List;
import java.util.Map;

public interface InternetBankingBillDetailMapper {
    void updateByOrderNumAndBillId(InternetBankingBillDetail bill);

    List<InternetBankingBillDetail> selectByOrderNumAndTime(Map<String, Object> map);
}