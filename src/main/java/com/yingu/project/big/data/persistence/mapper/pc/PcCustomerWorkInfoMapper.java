package com.yingu.project.big.data.persistence.mapper.pc;


import com.yingu.project.big.data.persistence.entity.pc.PcCustomerWorkInfo;
import com.yingu.project.big.data.util.MyMapper;

public interface PcCustomerWorkInfoMapper extends MyMapper<PcCustomerWorkInfo> {
    int updateByOrderNum(PcCustomerWorkInfo workInfo);
}