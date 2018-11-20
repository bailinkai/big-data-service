package com.yingu.project.big.data.persistence.mapper.internetbank;



import com.yingu.project.big.data.persistence.entity.internetbank.InternetBankingShoppingDetail;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface InternetBankingShoppingDetailMapper extends MyMapper<InternetBankingShoppingDetail> {

    void updateByOrderNumAndShoppingSheetId(InternetBankingShoppingDetail shopping);

    List<InternetBankingShoppingDetail> selectByBillsId(Map<String, Object> map);

    List<InternetBankingShoppingDetail> selectByShoppingSheetsId(Map<String, Object> map);
}