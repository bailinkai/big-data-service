package com.yingu.project.big.data.resource;

import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.service.bxd.InsuranceService;
import com.yingu.project.big.data.service.gjj.GjjService;
import com.yingu.project.big.data.service.shebao.SheBaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
@RestController
public class CreditRecordResource {


    @Autowired
    SheBaoService sheBaoService;
    @Autowired
    InsuranceService insuranceService;
    @Autowired
    GjjService gjjService;

    /**
     * 社保
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/provide/sb",method = RequestMethod.POST)
    public ResponseResult getSheBaoInfo(@RequestBody Map<String, Object> param){
        Map<String, Object> datas = (Map<String, Object>) param.get("datas");
        String orderNum = datas.get("order_num").toString();
        return sheBaoService.getSheBaoInfo(orderNum);
    }

    /**
     * 保险单
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/provide/bxd",method = RequestMethod.POST)
    public ResponseResult testGetBxdInfo(@RequestBody Map<String, Object> param){
        Map<String, Object> datas = (Map<String, Object>) param.get("datas");
        String orderNumber = datas.get("order_num").toString();
        return insuranceService.getAllInfo(orderNumber);
    }

    /**
     * 公积金
     * @param param
     * @return
     */
    @RequestMapping(value = "api/provide/gjj",method = RequestMethod.POST)
    public ResponseResult getGjjInfo(@RequestBody Map<String, Object> param){
        Map<String, Object> datas = (Map<String, Object>) param.get("datas");
        String order_num = datas.get("order_num").toString();
        return gjjService.getGJJInfo(order_num);
    }


}
