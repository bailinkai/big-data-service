package com.yingu.project.big.data.persistence.mapper.rhzx;

import com.yingu.project.big.data.persistence.entity.rhzx.CreditRecordSummaries;
import com.yingu.project.big.data.util.MyMapper;


public interface CreditRecordSummariesMapper extends MyMapper<CreditRecordSummaries> {
    int getHousingLoanAccount(String orderNum);

    int getAllHousingLoanAccount(String orderNum);

    int getGreaterThenAccountNumber(String orderNum);
}