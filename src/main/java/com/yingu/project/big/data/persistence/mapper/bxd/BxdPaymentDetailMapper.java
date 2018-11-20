package com.yingu.project.big.data.persistence.mapper.bxd;


import com.yingu.project.big.data.persistence.entity.bxd.BxdPaymentDetail;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;

public interface BxdPaymentDetailMapper extends MyMapper<BxdPaymentDetail> {
    List<BxdPaymentDetail> orderBy(String str);
}