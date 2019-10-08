package com.yingu.project.big.data.resource;

import com.yingu.project.big.data.common.ResponseResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
  * @author bailinkai
  * @date 2019/10/08
 * @Description  测试请求与响应
 */

@RestController
public class TestResource {

    @RequestMapping(value = "/api/zxt/getDetails", method = RequestMethod.POST)
    public ResponseResult InternetData(@RequestBody Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) {
        return new ResponseResult(100900,"三方接口查询为空","{'null':'查寻不到+1'}");
    }
}
