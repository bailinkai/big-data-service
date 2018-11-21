package com.yingu.project.big.data.persistence.mapper.gjj;


import com.yingu.project.big.data.persistence.entity.gjj.GjjDetials;
import com.yingu.project.big.data.util.MyMapper;

import java.util.List;

public interface GjjDetialsMapper extends MyMapper<GjjDetials> {
    List<GjjDetials> orderBy(String str);
}