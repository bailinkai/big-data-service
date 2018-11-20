package com.yingu.project.big.data.service.shebao;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yingu.project.big.data.common.ResponseCode;
import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.persistence.entity.pc.PcCustomerWorkInfo;
import com.yingu.project.big.data.persistence.entity.pc.PcOrderInfo;
import com.yingu.project.big.data.persistence.entity.sb.SbBaseInfo;
import com.yingu.project.big.data.persistence.entity.sb.SbDetail;
import com.yingu.project.big.data.persistence.mapper.pc.PcCustomerWorkInfoMapper;
import com.yingu.project.big.data.persistence.mapper.pc.PcOrderInfoMapper;
import com.yingu.project.big.data.persistence.mapper.sb.SbBaseInfoMapper;
import com.yingu.project.big.data.persistence.mapper.sb.SbDetailMapper;
import com.yingu.project.big.data.util.SubStringUUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
@Slf4j
@Service
public class SheBaoServiceImpl implements SheBaoService{

    @Autowired
    SbBaseInfoMapper sbBaseInfoMapper;
    @Autowired
    SbDetailMapper sbDetailMapper;
    @Autowired
    PcCustomerWorkInfoMapper pcCustomerWorkInfoMapper;
    @Autowired
    PcOrderInfoMapper pcOrderInfoMapper;

    @Override
    public boolean saveInfo(String oderNum, String dataString) {
        try {

            JSONObject jsonObject = JSONObject.parseObject(dataString);
            log.info("jsonObject所有信息" + jsonObject);

            //拿到这个json的状态信息
            String jsonsStatusInfo = jsonObject.getString("rspCode");

            if (jsonsStatusInfo.equals("200")) {
                //先删掉原有的
                this.delete(oderNum);

                //拿到所有data信息
                JSONObject jsonDataAllInfo = JSONObject.parseObject(jsonObject.getString("data"));

                //拿到所有transactions信息
                JSONArray transactionsAllInfo = jsonDataAllInfo.get("transactions") == null ? new JSONArray() : jsonDataAllInfo.getJSONArray("transactions");

                if (transactionsAllInfo.size() > 0) {
                    String uuid = "";
                    for (Object ob : transactionsAllInfo) {
                        uuid = SubStringUUID.subUUID();
                        Map<String, Object> map = (Map<String, Object>) ob;
                        SbBaseInfo sbBaseInfo = new SbBaseInfo();
                        sbBaseInfo.setSoinsCity(map.get("soins_city") == null ? "" : map.get("soins_city").toString());
                        sbBaseInfo.setSoinsArea(map.get("soins_area") == null ? "" : map.get("soins_area").toString());
                        sbBaseInfo.setUpdateTime(map.get("update_time") == null ? "" : map.get("update_time").toString());
                        sbBaseInfo.setUserName(map.get("user_name") == null ? "" : map.get("user_name").toString());
                        sbBaseInfo.setSoinsProv(map.get("soins_prov") == null ? "" : map.get("soins_prov").toString());
                        sbBaseInfo.setUserIdcard(map.get("user_idcard") == null ? "" : map.get("user_idcard").toString());
                        sbBaseInfo.setVersion(map.get("version") == null ? "" : map.get("version").toString());
                        sbBaseInfo.setSoinsStatus(map.get("soins_status") == null ? "" : map.get("soins_status").toString());
                        sbBaseInfo.setDataSource(map.get("data_source") == null ? "" : map.get("data_source").toString());
                        sbBaseInfo.setToken(map.get("token") == null ? "" : map.get("token").toString());
                        sbBaseInfo.setUserCompany(map.get("user_company") == null ? "" : map.get("user_company").toString());
                        sbBaseInfo.setOpenTime(map.get("open_time") == null ? "" : map.get("open_time").toString());
                        sbBaseInfo.setSoinsNum(map.get("soins_num") == null ? "" : map.get("soins_num").toString());
                        //设置外键
                        sbBaseInfo.setDetailsId(uuid);

                        sbBaseInfo.setUuid(SubStringUUID.subUUID());
                        sbBaseInfo.setOrderNum(oderNum);
                        sbBaseInfo.setCreateTime(new Date());
                        sbBaseInfoMapper.insertSelective(sbBaseInfo);

                        JSONArray detailsAllInfo = (JSONArray) map.get("details");
                        if (detailsAllInfo != null && detailsAllInfo.size() > 0) {
                            List<SbDetail> arrayList = new ArrayList<>();
                            for (Object o : detailsAllInfo) {
                                Map<String, Object> map1 = (Map<String, Object>) o;
                                SbDetail sbDetail = new SbDetail();
                                sbDetail.setTotalPay(map1.get("total_pay") == null ? "" : map1.get("total_pay").toString());
                                sbDetail.setStartTime(map1.get("start_time") == null ? "" : map1.get("start_time").toString());
                                sbDetail.setPayCardi(map1.get("pay_cardi") == null ? "" : map1.get("pay_cardi").toString());
                                sbDetail.setSoinsNature(map1.get("soins_nature") == null ? "" : map1.get("soins_nature").toString());
                                sbDetail.setSoinsType(map1.get("soins_type") == null ? "" : map1.get("soins_type").toString());
                                sbDetail.setCompPay(map1.get("comp_pay") == null ? "" : map1.get("comp_pay").toString());
                                sbDetail.setPsonPay(map1.get("pson_pay") == null ? "" : map1.get("pson_pay").toString());
                                sbDetail.setSoinsCompany(map1.get("soins_company") == null ? "" : map1.get("soins_company").toString());
                                sbDetail.setEndTime(map1.get("end_time") == null ? "" : map1.get("end_time").toString());
                                sbDetail.setPayMonths(map1.get("pay_months") == null ? "" : map1.get("pay_months").toString());
                                //外键
                                sbDetail.setDetailsId(uuid);

                                sbDetail.setUuid(SubStringUUID.subUUID());
                                sbDetail.setOrderNum(oderNum);
                                sbDetail.setCreateTime(new Date());

                                arrayList.add(sbDetail);


                            }
                            sbDetailMapper.insertList(arrayList);
                        }


                    }
                }


            }


        } catch (Exception e) {
            log.info("社保保险信息保存 异常" + e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public ResponseResult getSheBaoInfo(String orderNum) {
        Map<String, Object> allDataMap = new HashMap<>();
        List<Map<String, Object>> caseDataList = new ArrayList<>();
        List<Map<String, Object>> detailDataList = new ArrayList<>();
        try {
            //根据订单编号查询案件集合
            List<SbBaseInfo> sbBaseInfos = sbBaseInfoMapper.select(new SbBaseInfo(orderNum));
            if (sbBaseInfos.size() == 0 || sbBaseInfos == null) {
                return new ResponseResult(ResponseCode.SHEBAODATANOTUSER.getCode(), ResponseCode.SHEBAODATANOTUSER.getDescription());
            }
            String detialsId = "";
            for (SbBaseInfo sbBaseInfo : sbBaseInfos) {
                Map<String, Object> caseDataMap = new HashMap<>();
                caseDataMap.put("soins_city", sbBaseInfo.getSoinsCity() == null ? "" : sbBaseInfo.getSoinsCity());
                caseDataMap.put("user_name", sbBaseInfo.getUserName() == null ? "" : sbBaseInfo.getUserName());
                caseDataMap.put("soins_prov", sbBaseInfo.getSoinsProv() == null ? "" : sbBaseInfo.getSoinsProv());
                caseDataMap.put("open_time", sbBaseInfo.getOpenTime() == null ? "" : sbBaseInfo.getOpenTime());
                caseDataMap.put("user_idcard", sbBaseInfo.getUserIdcard() == null ? "" : sbBaseInfo.getUserIdcard());
                caseDataMap.put("update_time", sbBaseInfo.getUpdateTime() == null ? "" : sbBaseInfo.getUpdateTime());
                caseDataMap.put("soins_num", sbBaseInfo.getSoinsNum() == null ? "" : sbBaseInfo.getSoinsNum());
                caseDataMap.put("soins_status", sbBaseInfo.getSoinsStatus() == null ? "" : sbBaseInfo.getSoinsStatus());
                caseDataMap.put("user_company", sbBaseInfo.getUserCompany() == null ? "" : sbBaseInfo.getUserCompany());
                caseDataMap.put("soins_org", sbBaseInfo.getSoinsOrg() == null ? "" : sbBaseInfo.getSoinsOrg());
                caseDataMap.put("soins_area", sbBaseInfo.getSoinsArea() == null ? "" : sbBaseInfo.getSoinsArea());

                if (sbBaseInfo.getDetailsId() != null) {
                    detialsId = sbBaseInfo.getDetailsId();
                }
                boolean warning = false;
                String orgAddress = "";
                String orgName = "";
                String proposer = "";
                //查询客户工作信息表得到工作地区和单位名
                List<PcCustomerWorkInfo> pcCustomerWorkInfos = pcCustomerWorkInfoMapper.select(new PcCustomerWorkInfo(orderNum));
                if (pcCustomerWorkInfos.size() > 0) {
                    for (PcCustomerWorkInfo pcCustomerWorkInfo : pcCustomerWorkInfos) {
                        orgAddress = pcCustomerWorkInfo.getOrgAddress() == null ? "" : pcCustomerWorkInfo.getOrgAddress();
                        orgName = pcCustomerWorkInfo.getOrgName() == null ? "" : pcCustomerWorkInfo.getOrgName();
                    }
                }


                List<PcOrderInfo> pcOrderInfos = pcOrderInfoMapper.select(new PcOrderInfo(orderNum));
                if (pcOrderInfos.size() > 0) {
                    for (PcOrderInfo pcOrderInfo : pcOrderInfos) {
                        proposer = pcOrderInfo.getProposer() == null ? "" : pcOrderInfo.getProposer();
                    }
                }

                //进件市不符合异常标记
                if (StringUtils.isNotBlank(sbBaseInfo.getSoinsCity())) {
                    if (!orgAddress.contains(sbBaseInfo.getSoinsCity())) {
                        warning = true;
                    }
                }

                //进件省不符合异常标记
                if (StringUtils.isNotBlank(sbBaseInfo.getSoinsProv())) {
                    if (!orgAddress.contains(sbBaseInfo.getSoinsProv())) {
                        warning = true;
                    }
                }

                //名字不符合异常标记
                if (StringUtils.isNotBlank(sbBaseInfo.getUserName())) {
                    if (!proposer.contains(sbBaseInfo.getUserName()) || !proposer.equals(sbBaseInfo.getUserName())) {
                        warning = true;
                    }
                }

                //参保缴费异常标记
                if (StringUtils.isNotBlank(sbBaseInfo.getSoinsStatus())) {
                    if (!"参保缴费".contains(sbBaseInfo.getSoinsStatus())) {
                        warning = true;
                    }
                }

                //进件单位异常标记
                if (StringUtils.isNotBlank(sbBaseInfo.getUserCompany())) {
                    if (!orgName.equals(sbBaseInfo.getUserCompany())) {
                        warning = true;
                    }
                }
                caseDataMap.put("warning", warning);

                caseDataList.add(caseDataMap);

            }

            //拿到主键后得到集合
            List<SbDetail> sbDetailsList = sbDetailMapper.orderBy(detialsId);
            if (sbDetailsList.size() > 0 || sbDetailsList != null) {
                for (SbDetail sbDetail : sbDetailsList) {

                    Map<String, Object> detailsDataMap = new HashMap<>();
                    detailsDataMap.put("pay_cardi", sbDetail.getPayCardi() == null ? "" : sbDetail.getPayCardi());
                    detailsDataMap.put("soins_nature", sbDetail.getSoinsNature() == null ? "" : sbDetail.getSoinsNature());
                    detailsDataMap.put("soins_company", sbDetail.getSoinsCompany() == null ? "" : sbDetail.getSoinsCompany());
                    detailsDataMap.put("soins_type", sbDetail.getSoinsType() == null ? "" : sbDetail.getSoinsType());
                    detailsDataMap.put("comp_pay", sbDetail.getCompPay() == null ? "" : sbDetail.getCompPay());
                    detailsDataMap.put("pson_pay", sbDetail.getPsonPay() == null ? "" : sbDetail.getPsonPay());
                    detailsDataMap.put("start_time", sbDetail.getStartTime() == null ? "" : sbDetail.getStartTime());
                    detailsDataMap.put("end_time", sbDetail.getEndTime() == null ? "" : sbDetail.getEndTime());
                    detailsDataMap.put("pay_months", sbDetail.getPayMonths() == null ? "" : sbDetail.getPayMonths());
                    detailsDataMap.put("total_pay", sbDetail.getTotalPay() == null ? "" : sbDetail.getTotalPay());
                    boolean warningDetails = false;

                    detailsDataMap.put("warning", warningDetails);
                    detailDataList.add(detailsDataMap);
                }
            }

        } catch (Exception e) {

            log.info("shebao getCaseInfoException errorInfo" + e.getLocalizedMessage());
            return null;

        } finally {
            allDataMap.put("case_data_list", caseDataList);
            allDataMap.put("detail_data_list", detailDataList);
        }
        return ResponseResult.ok(allDataMap);
    }

    public void delete(String order_num){
        SbBaseInfo sbBaseInfo = new SbBaseInfo();
        sbBaseInfo.setOrderNum(order_num);
        sbBaseInfoMapper.delete(sbBaseInfo);

        SbDetail sbDetail = new SbDetail();
        sbDetail.setOrderNum(order_num);
        sbDetailMapper.delete(sbDetail);
    }
}
