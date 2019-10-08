package com.yingu.project.big.data.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 *
 * Created by KRX on 2018/01/10.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
    //TODO 注意，该接口不能被扫描到，否则会报错
    //FIXME 注意，该接口不能被扫描到，否则会报错
}
