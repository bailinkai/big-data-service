package com.yingu.project.big.data.persistence.mapper.rhzx;


import com.yingu.project.big.data.persistence.entity.rhzx.CreditCardRecordDetailAnalyzes;
import com.yingu.project.big.data.util.MyMapper;

public interface CreditCardRecordDetailAnalyzesMapper extends MyMapper<CreditCardRecordDetailAnalyzes> {
    int getCreditMonth(String orderNum);

    int getAllAccount(String orderNum);

    int getUnSettleUnCancel(String orderNum);

    double getUsedLimit(String orderNum);

    String getRecordIsBadDebts(String orderNum);
}