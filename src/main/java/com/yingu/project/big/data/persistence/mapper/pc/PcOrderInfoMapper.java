package com.yingu.project.big.data.persistence.mapper.pc;


import com.yingu.project.big.data.persistence.entity.pc.PcOrderInfo;
import com.yingu.project.big.data.util.MyMapper;

public interface PcOrderInfoMapper extends MyMapper<PcOrderInfo> {
    int updateByOrderNum(PcOrderInfo orderInfo);
}