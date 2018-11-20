package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingInstallmentDetail;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface InternetBankingInstallmentDetailMapper extends MyMapper<InternetBankingInstallmentDetail>{
    void updateByOrderNumAndShoppingsheetId(InternetBankingInstallmentDetail installment);

    List<InternetBankingInstallmentDetail> selectByInstallmentsId(Map<String, Object> map);
}