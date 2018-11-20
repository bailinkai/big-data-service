package com.yingu.project.big.data.resource;

import com.yingu.project.big.data.common.ResponseResult;

import com.yingu.project.big.data.service.internetbank.InternetBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
@RestController
public class InternetBankResource {

    @Autowired
    InternetBankService internetBankService;

    /**
     * 网银数据
     */
    @RequestMapping(value = "/api/cyber/bank", method = RequestMethod.POST)
    public ResponseResult InternetData(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        /*if (!userPower.getRedisPower("42", request, response)) {
            return PCFKResult.fail(WebStatus.Cookie_TimeOut.getCode(), "您没有此权限");
        }
        PCFKResult pcfkResult = commonCheck(request, response);
        if (pcfkResult.getCode() != WebStatus.SUCCESS.getCode()) {
            return pcfkResult;
        }*/
        return internetBankService.getDataByOrderNum((Map<String, Object>) param.get("datas"));
    }
}
