package com.yingu.project.big.data.resource;

import com.yingu.project.big.data.common.ResponseResult;
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

    /**
     * 社保
     * @param param
     * @return
     */
    @RequestMapping(value = "api/provide/sb",method = RequestMethod.POST)
    public ResponseResult getSheBaoInfo(@RequestBody Map<String, Object> param){
        Map<String, Object> datas = (Map<String, Object>) param.get("datas");
        String orderNum = datas.get("order_num").toString();
        return sheBaoService.getSheBaoInfo(orderNum);
    }
}
