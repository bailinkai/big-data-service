package com.yingu.project.big.data.persistence.mapper.rhzx;


import com.yingu.project.big.data.persistence.entity.rhzx.CreditQueryInfoDetails;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;
import java.util.Map;

public interface CreditQueryInfoDetailsMapper extends MyMapper<CreditQueryInfoDetails> {
    List<CreditQueryInfoDetails> selectQuerys(String orderNum);

    List<CreditQueryInfoDetails> selectQueryMap(Map<String, Object> map);

    int getSixMonthOrgQuery(String orderNum);

    int getThreeMonthCredit(String orderNum);

    int getSixMonthCredit(String orderNum);

    int getThreeMonthPerQuery(String orderNum);

    int getSixMonthPerQuery(String orderNum);

    int getGreaterThreeMonthNumberQuery(String orderNum);

    int getGreater90DaysQuery(String orderNum);
}