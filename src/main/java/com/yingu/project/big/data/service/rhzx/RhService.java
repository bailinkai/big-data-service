package com.yingu.project.big.data.service.rhzx;

import com.yingu.project.big.data.common.ResponseResult;


/**
 * @author huangkunhao
 * @date 2018/11/21
 * @Description
 */
public interface RhService {

    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/15 17:13
     * @Param
     * @Deseription 新增人行保存查询信息
     */
    boolean saveRhInfo(String orderNum, String result, String requestResult);


    /**
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 14:07
     * @Param
     * @return
     * @Deseription  获取央行信息
     */
    ResponseResult getRHInfo(String orderNum);



    /**
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 14:07
     * @Param
     * @return
     * @Deseription  获取央行信息
     */
    ResponseResult getRHInfos(String orderNum);
}
