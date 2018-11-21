package com.yingu.project.big.data.persistence.mapper.rhzx;


import com.yingu.project.big.data.persistence.entity.rhzx.CreditOtherLoanRecordDetailAnalyzes;
import com.yingu.project.big.data.util.MyMapper;

public interface CreditOtherLoanRecordDetailAnalyzesMapper extends MyMapper<CreditOtherLoanRecordDetailAnalyzes> {
    int getOtherLoanAmount(String orderNum);

    double getOtherLoanRemain(String orderNum);
}