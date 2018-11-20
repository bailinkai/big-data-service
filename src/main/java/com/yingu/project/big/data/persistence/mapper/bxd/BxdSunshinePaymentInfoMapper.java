package com.yingu.project.big.data.persistence.mapper.bxd;


import com.yingu.project.big.data.persistence.entity.bxd.BxdSunshinePaymentInfo;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;

public interface BxdSunshinePaymentInfoMapper extends MyMapper<BxdSunshinePaymentInfo> {
    List<BxdSunshinePaymentInfo> orderBy(BxdSunshinePaymentInfo bxdSunshinePaymentInfo);
}