package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingInstallmentDetail;

import java.util.List;
import java.util.Map;

public interface InternetBankingInstallmentDetailMapper{
    void updateByOrderNumAndShoppingsheetId(InternetBankingInstallmentDetail installment);

    List<InternetBankingInstallmentDetail> selectByInstallmentsId(Map<String, Object> map);
}