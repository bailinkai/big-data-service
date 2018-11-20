package com.yingu.project.big.data.persistence.mapper.sb;



import com.yingu.project.big.data.persistence.entity.sb.SbDetail;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;

public interface SbDetailMapper extends MyMapper<SbDetail> {
    List<SbDetail> orderBy(String str);
}