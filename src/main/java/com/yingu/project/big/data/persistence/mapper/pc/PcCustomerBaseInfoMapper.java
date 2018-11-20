package com.yingu.project.big.data.persistence.mapper.pc;


import com.yingu.project.big.data.persistence.entity.pc.PcCustomerBaseInfo;
import com.yingu.project.big.data.util.MyMapper;

import java.util.Map;

public interface PcCustomerBaseInfoMapper extends MyMapper<PcCustomerBaseInfo> {
    int updateByOrderNum(PcCustomerBaseInfo customerBaseInfo);

    PcCustomerBaseInfo getBaseInfo(Map<String, Object> map);
}