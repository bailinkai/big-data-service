package com.yingu.project.big.data.service.bxd;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yingu.project.big.data.common.ResponseCode;
import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.persistence.entity.bxd.*;
import com.yingu.project.big.data.persistence.entity.pc.PcCustomerBaseInfo;
import com.yingu.project.big.data.persistence.mapper.bxd.*;
import com.yingu.project.big.data.persistence.mapper.pc.PcCustomerBaseInfoMapper;
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
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    BxdBaseInfoMapper bxdBaseInfoMapper;
    @Autowired
    BxdDetailMapper bxdDetailMapper;
    @Autowired
    BxdInsurantDetailMapper bxdInsurantDetailMapper;
    @Autowired
    BxdApplicantDetailMapper bxdApplicantDetailMapper;
    @Autowired
    BxdBeneficiaryMapper bxdBeneficiaryMapper;
    @Autowired
    BxdPaymentDetailMapper bxdPaymentDetailMapper;
    @Autowired
    BxdInsuranceKindMapper bxdInsuranceKindMapper;
    @Autowired
    BxdVehicleInsuranceDetailMapper bxdVehicleInsuranceDetailMapper;
    @Autowired
    PcCustomerBaseInfoMapper pcCustomerBaseInfoMapper;
    @Autowired
    BxdSunshineUserInfoMapper bxdSunshineUserInfoMapper;
    @Autowired
    BxdSunshinePolicyInfoListMapper bxdSunshinePolicyInfoListMapper;
    @Autowired
    BxdSunshineBeneficiaryListMapper bxdSunshineBeneficiaryListMapper;
    @Autowired
    BxdSunshineInsurantListMapper bxdSunshineInsurantListMapper;
    @Autowired
    BxdSunshinePaymentInfoMapper bxdSunshinePaymentInfoMapper;
    @Autowired
    BxdSunshineApplicantMapper bxdSunshineApplicantMapper;
    @Autowired
    SunshineInsuranceSaveInfoService sunshineInsuranceSaveInfoService;

    @Override
    public boolean saveInfo(String orderNum, String stringData) {
        try {
            List<BxdDetail> bxdDetails = new ArrayList<>();
            List<BxdBaseInfo> baseInfoList = new ArrayList<>();
            List<BxdInsurantDetail> bxdInsurantDetailList = new ArrayList<>();
            List<BxdApplicantDetail> bxdApplicantDetailList = new ArrayList<>();
            List<BxdBeneficiary> bxdBeneficiaryList = new ArrayList<>();
            List<BxdPaymentDetail> bxdPaymentDetailList = new ArrayList<>();
            List<BxdInsuranceKind> bxdInsuranceKindList = new ArrayList<>();
            List<BxdVehicleInsuranceDetail> bxdVehicleInsuranceDetailList = new ArrayList<>();

            //整个json文件所有信息
            JSONObject jsonObject = JSONObject.parseObject(stringData);
            System.out.println("jsonObject所有信息" + jsonObject);

            //拿到这个json的状态信息
            String jsonsStatusInfo = jsonObject.getString("rspCode");
            //当状态码返回200时
            if (jsonsStatusInfo.toString().equals("200")) {

                //拿到这个json的所有data信息
                JSONObject jsonsAllDataInfo = JSONObject.parseObject(jsonObject.getString("data"));
                //根据sourceType的值做分发
                String sourceType = jsonsAllDataInfo.get("sourceType") == null ? "" : jsonsAllDataInfo.get("sourceType").toString();
                if (StringUtils.isNotBlank(sourceType) && sourceType.equals("2")) {
                    JSONObject jsonsAllTransactionsInfo = jsonsAllDataInfo.get("transactions") == null ? new JSONObject() : JSONObject.parseObject(jsonsAllDataInfo.get("transactions").toString());
                    sunshineInsuranceSaveInfoService.saveSunInfo(jsonsAllTransactionsInfo, orderNum);
                } else {

                    this.delete(orderNum);

                    //拿到这个json的所有transactions信息
                    JSONArray jsonsAllTransactionsInfo = jsonsAllDataInfo.getJSONArray("transactions");

                    if (jsonsAllTransactionsInfo.size() > 0) {
                        String uuidOne = "";
                        for (Object ob : jsonsAllTransactionsInfo) {
                            uuidOne = SubStringUUID.subUUID();
                            Map<String, Object> map = (Map<String, Object>) ob;

                            BxdBaseInfo bxd = new BxdBaseInfo();
                            bxd.setUpdateTime(map.get("update_time") == null ? "" : map.get("update_time").toString());
                            bxd.setName(map.get("name") == null ? "" : map.get("name").toString());
                            bxd.setCompany(map.get("company") == null ? "" : map.get("company").toString());
                            bxd.setWebsiteId(map.get("website_id") == null ? "" : map.get("website_id").toString());
                            bxd.setToken(map.get("token") == null ? "" : map.get("token").toString());
                            bxd.setVersion(map.get("version") == null ? "" : map.get("version").toString());
                            bxd.setIdCardType(map.get("id_card_type") == null ? "" : map.get("id_card_type").toString());
                            bxd.setCellPhone(map.get("cell_phone") == null ? "" : map.get("cell_phone").toString());
                            bxd.setEmail(map.get("email") == null ? "" : map.get("email").toString());
                            bxd.setIdCardNum(map.get("id_card_num") == null ? "" : map.get("id_card_num").toString());
                            bxd.setDatasource(map.get("datasource") == null ? "" : map.get("datasource").toString());
                            bxd.setTelephone(map.get("telephone") == null ? "" : map.get("telephone").toString());
                            bxd.setTelephoneDay(map.get("telephone_day") == null ? "" : map.get("telephone_day").toString());
                            bxd.setTelephoneNight(map.get("telephone_night") == null ? "" : map.get("telephone_night").toString());
                            bxd.setSafeLevel(map.get("safe_level") == null ? "" : map.get("safe_level").toString());
                            bxd.setNickname(map.get("nickname") == null ? "" : map.get("nickname").toString());
                            bxd.setWxid(map.get("wxid") == null ? "" : map.get("wxid").toString());
                            bxd.setHobby(map.get("hobby") == null ? "" : map.get("hobby").toString());
                            bxd.setCompanySchool(map.get("company_school") == null ? "" : map.get("company_school").toString());
                            bxd.setOccupation(map.get("occupation") == null ? "" : map.get("occupation").toString());
                            bxd.setPolicySrcName(map.get("policy_src_name") == null ? "" : map.get("policy_src_name").toString());
                            bxd.setHeight(map.get("height") == null ? "" : map.get("height").toString());
                            bxd.setWeight(map.get("weight") == null ? "" : map.get("weight").toString());
                            bxd.setHousing(map.get("housing") == null ? "" : map.get("housing").toString());
                            bxd.setQqNum(map.get("qq_num") == null ? "" : map.get("qq_num").toString());
                            bxd.setIsVip(map.get("is_vip") == null ? "" : map.get("is_vip").toString());
                            //设置外键
                            bxd.setDetailsId(uuidOne);

                            bxd.setUuid(SubStringUUID.subUUID());
                            bxd.setOrderNum(orderNum);
                            bxd.setCreateTime(new Date());

                            baseInfoList.add(bxd);

                            //拿到details的值
                            JSONArray detailsAllInfo = (JSONArray) map.get("details");

                            //当details的值不为空时
                            if (detailsAllInfo.size() > 0 && detailsAllInfo != null) {

                                String uuidTwo = "";
                                for (Object o : detailsAllInfo) {
                                    uuidTwo = SubStringUUID.subUUID();
                                    Map<String, Object> map1 = (Map<String, Object>) o;
                                    BxdDetail bxdDetail = new BxdDetail();
                                    bxdDetail.setInsuranceId(map1.get("insurance_id") == null ? "" : map1.get("insurance_id").toString());
                                    bxdDetail.setInsuranceType(map1.get("insurance_type") == null ? "" : map1.get("insurance_type").toString());
                                    bxdDetail.setInsuranceMain(map1.get("insurance_main") == null ? "" : map1.get("insurance_main").toString());
                                    bxdDetail.setInsuranceStatus(map1.get("insurance_status") == null ? "" : map1.get("insurance_status").toString());
                                    //设置外键
                                    bxdDetail.setDetailsId(uuidOne);
                                    bxdDetail.setDetailsIdTwo(uuidTwo);


                                    bxdDetail.setUuid(SubStringUUID.subUUID());
                                    bxdDetail.setOrderNum(orderNum);
                                    bxdDetail.setCreateTime(new Date());
                                    //bxdDetailMapper.insertSelective(bxdDetail);
                                    bxdDetails.add(bxdDetail);

                                    //拿到insurant_details的值
                                    JSONArray insurantDetailsmap1AllInfo = (JSONArray) map1.get("insurant_details");
                                    if (insurantDetailsmap1AllInfo != null && insurantDetailsmap1AllInfo.size() > 0) {

                                        for (Object object : insurantDetailsmap1AllInfo) {
                                            Map<String, Object> map2 = (Map<String, Object>) object;
                                            BxdInsurantDetail bxdInsurantDetail = new BxdInsurantDetail();
                                            bxdInsurantDetail.setInsurantIdCardNum(map2.get("insurant_id_card_num") == null ? "" : map2.get("insurant_id_card_num").toString());
                                            bxdInsurantDetail.setInsurantName(map2.get("insurant_name") == null ? "" : map2.get("insurant_name").toString());
                                            bxdInsurantDetail.setInsurantIdCardType(map2.get("insurant_id_card_type") == null ? "" : map2.get("insurant_id_card_type").toString());
                                            bxdInsurantDetail.setInsurantRelationship(map2.get("insurant_relationship") == null ? "" : map2.get("insurant_relationship").toString());
                                            //设置外键
                                            bxdInsurantDetail.setDetailsId(uuidTwo);

                                            bxdInsurantDetail.setUuid(SubStringUUID.subUUID());
                                            bxdInsurantDetail.setOrderNum(orderNum);
                                            bxdInsurantDetail.setCreateTime(new Date());

                                            bxdInsurantDetailList.add(bxdInsurantDetail);
                                            //bxdInsurantDetailMapper.insertSelective(bxdInsurantDetail);

                                        }
                                    }

                                    //拿到applicant_details的值
                                    JSONArray applicantDetailsAllInfo = (JSONArray) map1.get("applicant_details");
                                    if (applicantDetailsAllInfo.size() > 0) {

                                        for (Object object : applicantDetailsAllInfo) {
                                            Map<String, Object> map2 = (Map<String, Object>) object;
                                            BxdApplicantDetail bxdApplicantDetail = new BxdApplicantDetail();
                                            bxdApplicantDetail.setApplicantAddress(map2.get("applicant_address") == null ? "" : map2.get("applicant_address").toString());
                                            bxdApplicantDetail.setApplicantIdCardType(map2.get("applicant_id_card_type") == null ? "" : map2.get("applicant_id_card_type").toString());
                                            bxdApplicantDetail.setApplicantCellPhone(map2.get("applicant_cell_phone") == null ? "" : map2.get("applicant_cell_phone").toString());
                                            bxdApplicantDetail.setApplicantEmail(map2.get("applicant_email") == null ? "" : map2.get("applicant_email").toString());
                                            bxdApplicantDetail.setApplicantIdCardNum(map2.get("applicant_id_card_num") == null ? "" : map2.get("applicant_id_card_num").toString());
                                            bxdApplicantDetail.setApplicantGender(map2.get("applicant_gender") == null ? "" : map2.get("applicant_gender").toString());
                                            bxdApplicantDetail.setApplicantCity(map2.get("applicant_city") == null ? "" : map2.get("applicant_city").toString());
                                            bxdApplicantDetail.setApplicantMarried(map2.get("applicant_married") == null ? "" : map2.get("applicant_married").toString());
                                            bxdApplicantDetail.setApplicantAnnualIncome(map2.get("applicant_annual_income") == null ? "" : map2.get("applicant_annual_income").toString());
                                            bxdApplicantDetail.setApplicantProfession(map2.get("applicant_profession") == null ? "" : map2.get("applicant_profession").toString());
                                            bxdApplicantDetail.setApplicantHealthStatus(map2.get("applicant_health_status") == null ? "" : map2.get("applicant_health_status").toString());
                                            bxdApplicantDetail.setApplicantChildren(map2.get("applicant_children") == null ? "" : map2.get("applicant_children").toString());
                                            bxdApplicantDetail.setApplicantEmail(map2.get("applicant_email") == null ? "" : map2.get("applicant_email").toString());
                                            bxdApplicantDetail.setApplicantName(map2.get("applicant_name") == null ? "" : map2.get("applicant_name").toString());
                                            //设置外键
                                            bxdApplicantDetail.setDetailsId(uuidTwo);

                                            bxdApplicantDetail.setUuid(SubStringUUID.subUUID());
                                            bxdApplicantDetail.setOrderNum(orderNum);
                                            bxdApplicantDetail.setCreateTime(new Date());

                                            bxdApplicantDetailList.add(bxdApplicantDetail);
                                            //bxdApplicantDetailMapper.insertSelective(bxdApplicantDetail);
                                        }
                                    }

                                    //拿到beneficiary的值
                                    JSONArray beneficiartAllInfo = (JSONArray) map1.get("beneficiary");
                                    if (beneficiartAllInfo.size() > 0) {

                                        for (Object object : beneficiartAllInfo) {
                                            Map<String, Object> map2 = (Map<String, Object>) object;
                                            BxdBeneficiary bxdBeneficiary = new BxdBeneficiary();
                                            bxdBeneficiary.setBeneficiaryStatus(map2.get("beneficiary_status") == null ? "" : map2.get("beneficiary_status").toString());
                                            bxdBeneficiary.setBeneficiaryRelationship(map2.get("beneficiary_relationship") == null ? "" : map2.get("beneficiary_relationship").toString());
                                            bxdBeneficiary.setBeneficiaryName(map2.get("beneficiary_name") == null ? "" : map2.get("beneficiary_name").toString());
                                            bxdBeneficiary.setBeneficiaryOrder(map2.get("beneficiary_order") == null ? "" : map2.get("beneficiary_order").toString());
                                            bxdBeneficiary.setBeneficiaryScale(map2.get("beneficiary_scale") == null ? "" : map2.get("beneficiary_scale").toString());
                                            //设置外键
                                            bxdBeneficiary.setDetailsId(uuidTwo);

                                            bxdBeneficiary.setUuid(SubStringUUID.subUUID());
                                            bxdBeneficiary.setOrderNum(orderNum);
                                            bxdBeneficiary.setCreateTime(new Date());

                                            bxdBeneficiaryList.add(bxdBeneficiary);
                                            //bxdBeneficiaryMapper.insertSelective(bxdBeneficiary);

                                        }
                                    }

                                    //拿到payment_details的值
                                    JSONArray paymentDetailsAllInfo = (JSONArray) map1.get("payment_details");
                                    if (paymentDetailsAllInfo.size() > 0) {

                                        for (Object object : paymentDetailsAllInfo) {
                                            Map<String, Object> map2 = (Map<String, Object>) object;
                                            BxdPaymentDetail bxdPaymentDetail = new BxdPaymentDetail();
                                            bxdPaymentDetail.setPayAmt(map2.get("pay_amt") == null ? "" : map2.get("pay_amt").toString());
                                            bxdPaymentDetail.setPolicyStartDate(map2.get("policy_start_date") == null ? "" : map2.get("policy_start_date").toString());
                                            bxdPaymentDetail.setEndDate(map2.get("end_date") == null ? "" : map2.get("end_date").toString());
                                            bxdPaymentDetail.setStartDate(map2.get("start_date") == null ? "" : map2.get("start_date").toString());
                                            bxdPaymentDetail.setPayEndDate(map2.get("pay_end_date") == null ? "" : map2.get("pay_end_date").toString());
                                            bxdPaymentDetail.setInsuranceAmt(map2.get("insurance_amt") == null ? "" : map2.get("insurance_amt").toString());
                                            bxdPaymentDetail.setInsurancePremium(map2.get("insurance_premium") == null ? "" : map2.get("insurance_premium").toString());
                                            bxdPaymentDetail.setNextPayDate(map2.get("next_pay_date") == null ? "" : map2.get("next_pay_date").toString());
                                            bxdPaymentDetail.setPayNeedTimes(map2.get("pay_need_times") == null ? "" : map2.get("pay_need_times").toString());
                                            bxdPaymentDetail.setPayHadTimes(map2.get("pay_had_times") == null ? "" : map2.get("pay_had_times").toString());
                                            bxdPaymentDetail.setPayPeriod(map2.get("pay_period") == null ? "" : map2.get("pay_period").toString());
                                            bxdPaymentDetail.setPaymentType(map2.get("payment_type") == null ? "" : map2.get("payment_type").toString());
                                            bxdPaymentDetail.setPaymentBank(map2.get("payment_bank") == null ? "" : map2.get("payment_bank").toString());
                                            bxdPaymentDetail.setPaymentAccount(map2.get("payment_account") == null ? "" : map2.get("payment_account").toString());
                                            bxdPaymentDetail.setPaymentFrequency(map2.get("payment_frequency") == null ? "" : map2.get("payment_frequency").toString());
                                            bxdPaymentDetail.setPaymentDatePayable(map2.get("payment_date_payable") == null ? "" : map2.get("payment_date_payable").toString());
                                            bxdPaymentDetail.setPaymentDateCharge(map2.get("payment_date_charge") == null ? "" : map2.get("payment_date_charge").toString());
                                            bxdPaymentDetail.setPaymentPremiumPayable(map2.get("payment_premium_payable") == null ? "" : map2.get("payment_premium_payable").toString());
                                            bxdPaymentDetail.setPaymentPremiumCharge(map2.get("payment_premium_charge") == null ? "" : map2.get("payment_premium_charge").toString());
                                            //设置外键
                                            bxdPaymentDetail.setDetailsId(uuidTwo);

                                            bxdPaymentDetail.setUuid(SubStringUUID.subUUID());
                                            bxdPaymentDetail.setOrderNum(orderNum);
                                            bxdPaymentDetail.setCreateTime(new Date());

                                            bxdPaymentDetailList.add(bxdPaymentDetail);
                                            //bxdPaymentDetailMapper.insertSelective(bxdPaymentDetail);

                                        }
                                    }

                                    //拿到insurance_kind的值
                                    JSONArray insuranceKindAllInfo = (JSONArray) map1.get("insurance_kind");
                                    if (insuranceKindAllInfo.size() > 0) {

                                        for (Object object : insuranceKindAllInfo) {
                                            Map<String, Object> map2 = (Map<String, Object>) object;
                                            BxdInsuranceKind bxdInsuranceKind = new BxdInsuranceKind();
                                            bxdInsuranceKind.setInsuranceKindInsuranceName(map2.get("insurance_kind_insurance_name") == null ? "" : map2.get("insurance_kind_insurance_name").toString());
                                            bxdInsuranceKind.setInsuranceKindInsuranceType(map2.get("insurance_kind_insurance_type") == null ? "" : map2.get("insurance_kind_insurance_type").toString());
                                            bxdInsuranceKind.setInsuranceKindDutyName(map2.get("insurance_kind_duty_name") == null ? "" : map2.get("insurance_kind_duty_name").toString());
                                            bxdInsuranceKind.setInsuranceKindInsuredAmount(map2.get("insurance_kind_insured_amount") == null ? "" : map2.get("insurance_kind_insured_amount").toString());
                                            bxdInsuranceKind.setInsuranceKindInsurancePremium(map2.get("insurance_kind_insurance_premium") == null ? "" : map2.get("insurance_kind_insurance_premium").toString());
                                            bxdInsuranceKind.setInsuranceKindInsureNum(map2.get("insurance_kind_insure_num") == null ? "" : map2.get("insurance_kind_insure_num").toString());
                                            bxdInsuranceKind.setInsuranceKindInsuranceStatus(map2.get("insurance_kind_insurance_status") == null ? "" : map2.get("insurance_kind_insurance_status").toString());
                                            bxdInsuranceKind.setInsuranceKindInsurancePeriod(map2.get("insurance_kind_insurance_period") == null ? "" : map2.get("insurance_kind_insurance_period").toString());
                                            //设置外键
                                            bxdInsuranceKind.setDetailsId(uuidTwo);
                                            bxdInsuranceKind.setUuid(SubStringUUID.subUUID());
                                            bxdInsuranceKind.setOrderNum(orderNum);
                                            bxdInsuranceKind.setCreateTime(new Date());

                                            bxdInsuranceKindList.add(bxdInsuranceKind);
                                            // bxdInsuranceKindMapper.insertSelective(bxdInsuranceKind);

                                        }
                                    }

                                    //拿到vehicle_insurance_details的值
                                    JSONArray vehicleInsuranceDetailsAllInfo = (JSONArray) map1.get("vehicle_insurance_details");
                                    if (vehicleInsuranceDetailsAllInfo.size() > 0) {

                                        for (Object object : vehicleInsuranceDetailsAllInfo) {
                                            Map<String, Object> map2 = (Map<String, Object>) object;

                                            BxdVehicleInsuranceDetail bxdVehicleInsuranceDetail = new BxdVehicleInsuranceDetail();
                                            bxdVehicleInsuranceDetail.setVehicleAdjustRatio(map2.get("vehicle_adjust_ratio") == null ? "" : map2.get("vehicle_adjust_ratio").toString());
                                            bxdVehicleInsuranceDetail.setVehicleAdjustRatioReason(map2.get("vehicle_adjust_ratio_reason") == null ? "" : map2.get("vehicle_adjust_ratio_reason").toString());
                                            bxdVehicleInsuranceDetail.setVehicleLicenseNo(map2.get("vehicle_license_no") == null ? "" : map2.get("vehicle_license_no").toString());
                                            bxdVehicleInsuranceDetail.setVehicleCarUsage(map2.get("vehicle_car_usage") == null ? "" : map2.get("vehicle_car_usage").toString());

                                            bxdVehicleInsuranceDetail.setVehicleVinNo(map2.get("vehicle_vin_no") == null ? "" : map2.get("vehicle_vin_no").toString());
                                            bxdVehicleInsuranceDetail.setVehiclePassengerCapacity(map2.get("vehicle_passenger_capacity") == null ? "" : map2.get("vehicle_passenger_capacity").toString());
                                            bxdVehicleInsuranceDetail.setVehicleWeightingCapacity(map2.get("vehicle_weighting_capacity") == null ? "" : map2.get("vehicle_weighting_capacity").toString());
                                            //设置外键
                                            bxdVehicleInsuranceDetail.setDetailsId(uuidTwo);
                                            bxdVehicleInsuranceDetail.setUuid(SubStringUUID.subUUID());
                                            bxdVehicleInsuranceDetail.setOrderNum(orderNum);
                                            bxdVehicleInsuranceDetail.setCreateTime(new Date());

                                            bxdVehicleInsuranceDetailList.add(bxdVehicleInsuranceDetail);
                                            //bxdVehicleInsuranceDetailMapper.insertSelective(bxdVehicleInsuranceDetail);
                                        }

                                    }

                                }
                            }

                        }
                    }
                    /*
                        List<BxdPaymentDetail> bxdPaymentDetailList = new ArrayList<>();
                        List<BxdInsuranceKind> bxdInsuranceKindList = new ArrayList<>();
                        List<BxdVehicleInsuranceDetail> bxdVehicleInsuranceDetailList = new ArrayList<>();
                        */
                    if (!bxdDetails.isEmpty()) {
                        bxdDetailMapper.insertList(bxdDetails);
                    }

                    if (!baseInfoList.isEmpty()) {
                        bxdBaseInfoMapper.insertList(baseInfoList);
                    }

                    if (!bxdInsurantDetailList.isEmpty()) {
                        bxdInsurantDetailMapper.insertList(bxdInsurantDetailList);
                    }

                    if (!bxdApplicantDetailList.isEmpty()) {
                        bxdApplicantDetailMapper.insertList(bxdApplicantDetailList);
                    }
                    if (!bxdBeneficiaryList.isEmpty()) {
                        bxdBeneficiaryMapper.insertList(bxdBeneficiaryList);
                    }
                    if (!bxdPaymentDetailList.isEmpty()) {
                        bxdPaymentDetailMapper.insertList(bxdPaymentDetailList);
                    }
                    if (!bxdInsuranceKindList.isEmpty()) {
                        bxdInsuranceKindMapper.insertList(bxdInsuranceKindList);
                    }
                    if (!bxdVehicleInsuranceDetailList.isEmpty()) {
                        bxdVehicleInsuranceDetailMapper.insertList(bxdVehicleInsuranceDetailList);
                    }
                }

            }
            return true;
        } catch (Exception e) {
            log.error("保险单数据保存失败，错误信息:" + e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public ResponseResult getBXDInfo(String orderNum) {
        Map<String, Object> dataMap = new HashMap<>();
        List<Map<String, Object>> applicant_info = new ArrayList<>();
        List<Map<String, Object>> warranty_base_info = new ArrayList<>();
        List<Map<String, Object>> warranty_details = new ArrayList<>();
        List<Map<String, Object>> payment_info = new ArrayList<>();
        List<Map<String, Object>> other_info = new ArrayList<>();
        try {
            //查询该订单编号的所有保险单List集合

            List<BxdBaseInfo> bxdBase = bxdBaseInfoMapper.select(new BxdBaseInfo(orderNum));
            List<BxdSunshinePolicyInfoList> bxdBases = bxdSunshinePolicyInfoListMapper.select(new BxdSunshinePolicyInfoList(orderNum));
            if (bxdBase.size() <= 0 && bxdBases.size() <= 0) {
                return new ResponseResult(ResponseCode.BXDDATANOTUSER.getCode(), ResponseCode.BXDDATANOTUSER.getDescription());
            }
            if (bxdBase.size() > 0) {
                for (BxdBaseInfo bxdBI : bxdBase) {
                    //拿到details外键
                    String telephone = bxdBI.getTelephone() == null ? "" : bxdBI.getTelephone();
                    String company_school = bxdBI.getCompanySchool() == null ? "" : bxdBI.getCompanySchool();
                    String company = bxdBI.getCompany() == null ? "" : bxdBI.getCompany();
                    String details = bxdBI.getDetailsId() == null ? "" : bxdBI.getDetailsId();
                    String name = bxdBI.getName() == null ? "" : bxdBI.getName();

                    //根据details外键查询对应的所有的details对象
                    List<BxdDetail> bxdDetails = bxdDetailMapper.select(new BxdDetail(details));
                    if (bxdDetails.size() > 0) {
                        for (BxdDetail bxdDetail : bxdDetails) {
                            //遍历拿到其中一个对象
                            Map<String, Object> detailMap = new HashMap<>();
                            detailMap.put("insurance_id", bxdDetail.getInsuranceId() == null ? "" : bxdDetail.getInsuranceId());
                            detailMap.put("company", company == null ? "" : company);
                            detailMap.put("name", name == null ? "" : name);
                            detailMap.put("insurance_name", bxdDetail.getInsuranceName() == null ? "" : bxdDetail.getInsuranceName());
                            detailMap.put("insurance_type", bxdDetail.getInsuranceType() == null ? "" : bxdDetail.getInsuranceType());
                            detailMap.put("insurance_main", bxdDetail.getInsuranceMain() == null ? "" : bxdDetail.getInsuranceMain());
                            detailMap.put("insurance_num", bxdDetail.getInsuranceNum() == null ? "" : bxdDetail.getInsuranceNum());

                            warranty_base_info.add(detailMap);
                            //拿到对应的里面的list对应的外键
                            String detailsIdTwo = bxdDetail.getDetailsIdTwo();

                            List<BxdApplicantDetail> applicantDetailList = bxdApplicantDetailMapper.select(new BxdApplicantDetail(detailsIdTwo));
                            List<PcCustomerBaseInfo> customerBaseInfos = pcCustomerBaseInfoMapper.select(new PcCustomerBaseInfo(orderNum));
                            String phone = "";
                            if (customerBaseInfos.size() > 0) {

                                for (PcCustomerBaseInfo pcCustomerBaseInfo : customerBaseInfos) {
                                    phone = pcCustomerBaseInfo.getPhone() == null ? "" : pcCustomerBaseInfo.getPhone();
                                }
                            }
                            if (applicantDetailList.size() > 0) {
                                for (BxdApplicantDetail bxdApplicantDetail : applicantDetailList) {
                                    Map<String, Object> bxdApplicantMap = new HashMap<>();
                                    bxdApplicantMap.put("applicant_name", bxdApplicantDetail.getApplicantName() == null ? "" : bxdApplicantDetail.getApplicantName());
                                    bxdApplicantMap.put("applicant_id_card_num", bxdApplicantDetail.getApplicantIdCardNum() == null ? "" : bxdApplicantDetail.getApplicantIdCardNum());
                                    bxdApplicantMap.put("applicant_cell_phone", bxdApplicantDetail.getApplicantCellPhone() == null ? "" : bxdApplicantDetail.getApplicantCellPhone());
                                    bxdApplicantMap.put("applicant_profession", bxdApplicantDetail.getApplicantProfession() == null ? "" : bxdApplicantDetail.getApplicantProfession());
                                    bxdApplicantMap.put("applicant_address", bxdApplicantDetail.getApplicantAddress() == null ? "" : bxdApplicantDetail.getApplicantAddress());

                                    bxdApplicantMap.put("applicant_email", bxdApplicantDetail.getApplicantEmail() == null ? "" : bxdApplicantDetail.getApplicantEmail());
                                    bxdApplicantMap.put("wxid", bxdBI.getWxid() == null ? "" : bxdBI.getWxid());

                                    bxdApplicantMap.put("telephone", telephone);
                                    bxdApplicantMap.put("company_school", company_school);
                                    bxdApplicantMap.put("warning", false);

                                    applicant_info.add(bxdApplicantMap);
                                }

                            }


                            List<BxdInsuranceKind> bxdInsuranceKinds = bxdInsuranceKindMapper.select(new BxdInsuranceKind(detailsIdTwo));
                            if (bxdInsuranceKinds.size() > 0) {
                                for (BxdInsuranceKind bxdInsuranceKind : bxdInsuranceKinds) {
                                    Map<String, Object> insuranceKindMap = new HashMap<>();
                                    insuranceKindMap.put("insurance_kind_insurance_name", bxdInsuranceKind.getInsuranceKindInsuranceName() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceName());
                                    insuranceKindMap.put("insurance_kind_insurance_type", bxdInsuranceKind.getInsuranceKindInsuranceType() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceType());
                                    insuranceKindMap.put("insurance_kind_insured_amount", bxdInsuranceKind.getInsuranceKindInsuredAmount() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuredAmount());
                                    insuranceKindMap.put("insurance_kind_insurance_premium", bxdInsuranceKind.getInsuranceKindInsurancePremium() == null ? "" : bxdInsuranceKind.getInsuranceKindInsurancePremium());
                                    insuranceKindMap.put("insurance_kind_insurance_status", bxdInsuranceKind.getInsuranceKindInsuranceStatus() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceStatus());
                                    insuranceKindMap.put("insurance_kind_insurance_period", bxdInsuranceKind.getInsuranceKindInsurancePeriod() == null ? "" : bxdInsuranceKind.getInsuranceKindInsurancePeriod());

                                    warranty_details.add(insuranceKindMap);
                                }
                            }

                            List<BxdPaymentDetail> paymentDetails = bxdPaymentDetailMapper.orderBy(detailsIdTwo);
                            if (paymentDetails.size() > 0) {
                                for (BxdPaymentDetail bxdPaymentDetail : paymentDetails) {
                                    Map<String, Object> paymentDetailMap = new HashMap<>();
                                    paymentDetailMap.put("insurance_amt", bxdPaymentDetail.getInsuranceAmt() == null ? "" : bxdPaymentDetail.getInsuranceAmt());
                                    paymentDetailMap.put("start_date", bxdPaymentDetail.getStartDate() == null ? "" : bxdPaymentDetail.getStartDate());
                                    paymentDetailMap.put("pay_end_date", bxdPaymentDetail.getPayEndDate() == null ? "" : bxdPaymentDetail.getPayEndDate());
                                    paymentDetailMap.put("pay_amt", bxdPaymentDetail.getPayAmt() == null ? "" : bxdPaymentDetail.getPayAmt());
                                    paymentDetailMap.put("pay_had_times", bxdPaymentDetail.getPayHadTimes() == null ? "" : bxdPaymentDetail.getPayHadTimes());
                                    paymentDetailMap.put("pay_period", bxdPaymentDetail.getPayPeriod() == null ? "" : bxdPaymentDetail.getPayPeriod());
                                    paymentDetailMap.put("next_pay_date", bxdPaymentDetail.getNextPayDate() == null ? "" : bxdPaymentDetail.getNextPayDate());
                                    paymentDetailMap.put("policy_start_date", bxdPaymentDetail.getPolicyStartDate() == null ? "" : bxdPaymentDetail.getPolicyStartDate());
                                    paymentDetailMap.put("end_date", bxdPaymentDetail.getEndDate() == null ? "" : bxdPaymentDetail.getEndDate());
                                    paymentDetailMap.put("pay_need_times", bxdPaymentDetail.getPayNeedTimes() == null ? "" : bxdPaymentDetail.getPayNeedTimes());
                                    paymentDetailMap.put("insurance_premium", bxdPaymentDetail.getInsurancePremium() == null ? "" : bxdPaymentDetail.getInsurancePremium());
                                    paymentDetailMap.put("payment_premium_payable", bxdPaymentDetail.getPaymentPremiumPayable() == null ? "" : bxdPaymentDetail.getPaymentPremiumPayable());
                                    paymentDetailMap.put("payment_premium_charge", bxdPaymentDetail.getPaymentPremiumCharge() == null ? "" : bxdPaymentDetail.getPaymentPremiumCharge());
                                    paymentDetailMap.put("payment_frequency", bxdPaymentDetail.getPaymentFrequency() == null ? "" : bxdPaymentDetail.getPaymentFrequency());
                                    paymentDetailMap.put("payment_type", bxdPaymentDetail.getPaymentType() == null ? "" : bxdPaymentDetail.getPaymentType());
                                    paymentDetailMap.put("warning", false);

                                    payment_info.add(paymentDetailMap);
                                }
                            }


                            List<BxdInsurantDetail> insurantDetails = bxdInsurantDetailMapper.select(new BxdInsurantDetail(detailsIdTwo));
                            List<BxdBeneficiary> beneficiaries = bxdBeneficiaryMapper.select(new BxdBeneficiary(detailsIdTwo));
                            List<BxdVehicleInsuranceDetail> vehicleInsuranceDetails = bxdVehicleInsuranceDetailMapper.select(new BxdVehicleInsuranceDetail(detailsIdTwo));
                            if (insurantDetails.size() > 0) {
                                for (BxdInsurantDetail bxdInsurantDetail : insurantDetails) {
                                    Map<String, Object> InsurantDetailMap = new HashMap<>();
                                    InsurantDetailMap.put("insurant_id_card_num", bxdInsurantDetail.getInsurantIdCardNum() == null ? "" : bxdInsurantDetail.getInsurantIdCardNum());
                                    InsurantDetailMap.put("insurant_name", bxdInsurantDetail.getInsurantName() == null ? "" : bxdInsurantDetail.getInsurantName());
                                    InsurantDetailMap.put("insurant_relationship", bxdInsurantDetail.getInsurantRelationship() == null ? "" : bxdInsurantDetail.getInsurantRelationship());
                                    InsurantDetailMap.put("beneficiary_name", "");
                                    InsurantDetailMap.put("beneficiary_relationship", "");
                                    InsurantDetailMap.put("auto_insurance", "无");
                                    if (vehicleInsuranceDetails.size() > 0) {
                                        InsurantDetailMap.put("auto_insurance", "有");
                                    }
                                    if (beneficiaries.size() > 0) {
                                        for (BxdBeneficiary bxdBeneficiary : beneficiaries) {
                                            InsurantDetailMap.put("beneficiary_name", bxdBeneficiary.getBeneficiaryName() == null ? "" : bxdBeneficiary.getBeneficiaryName());
                                            InsurantDetailMap.put("beneficiary_relationship", bxdBeneficiary.getBeneficiaryRelationship() == null ? "" : bxdBeneficiary.getBeneficiaryRelationship());
                                            other_info.add(InsurantDetailMap);
                                        }
                                    } else {
                                        other_info.add(InsurantDetailMap);
                                    }
                                }
                            }
                        }


                    }
                }

            } else if (bxdBases.size() > 0) {
                return sunshineInsuranceSaveInfoService.getSunInfo(orderNum);
            }
        } catch (Exception e) {
            log.info("bxdGetInfoException exceptionMessage  = ", e.getMessage());
        } finally {
            dataMap.put("applicant_info", applicant_info);
            dataMap.put("warranty_base_info", warranty_base_info);
            dataMap.put("warranty_type", 1);
            dataMap.put("warranty_details", warranty_details);
            dataMap.put("payment_info", payment_info);
            dataMap.put("other_info", other_info);
        }
        return ResponseResult.ok(dataMap);
    }

    @Override
    public ResponseResult getAllInfo(String orderNum) {
        Map<String, Object> dataMap = new HashMap<>();
        List<Map<String, Object>> applicant_info = new ArrayList<>();
        List<Map<String, Object>> warranty_base_info = new ArrayList<>();
        List<Map<String, Object>> warranty_details = new ArrayList<>();
        List<Map<String, Object>> payment_info = new ArrayList<>();
        List<Map<String, Object>> other_info = new ArrayList<>();
        try {
            //查询该订单编号的所有保险单List集合

            List<BxdBaseInfo> bxdBase = bxdBaseInfoMapper.select(new BxdBaseInfo(orderNum));
            List<BxdSunshinePolicyInfoList> bxdBases = bxdSunshinePolicyInfoListMapper.select(new BxdSunshinePolicyInfoList(orderNum));
            if (bxdBase.size() <= 0 && bxdBases.size() <= 0) {
                return new ResponseResult(ResponseCode.BXDDATANOTUSER.getCode(), ResponseCode.BXDDATANOTUSER.getDescription());
            }
            if (bxdBase.size() > 0) {
                for (BxdBaseInfo bxdBI : bxdBase) {
                    //拿到details外键
                    String telephone = bxdBI.getTelephone() == null ? "" : bxdBI.getTelephone();
                    String company_school = bxdBI.getCompanySchool() == null ? "" : bxdBI.getCompanySchool();
                    String company = bxdBI.getCompany() == null ? "" : bxdBI.getCompany();
                    String details = bxdBI.getDetailsId() == null ? "" : bxdBI.getDetailsId();
                    String name = bxdBI.getName() == null ? "" : bxdBI.getName();

                    //根据details外键查询对应的所有的details对象
                    List<BxdDetail> bxdDetails = bxdDetailMapper.select(new BxdDetail(details));
                    if (bxdDetails.size() > 0) {
                        for (BxdDetail bxdDetail : bxdDetails) {
                            //遍历拿到其中一个对象
                            Map<String, Object> detailMap = new HashMap<>();
                            detailMap.put("insurance_id", bxdDetail.getInsuranceId() == null ? "" : bxdDetail.getInsuranceId());
                            detailMap.put("company", company == null ? "" : company);
                            detailMap.put("name", name == null ? "" : name);
                            detailMap.put("insurance_name", bxdDetail.getInsuranceName() == null ? "" : bxdDetail.getInsuranceName());
                            detailMap.put("insurance_type", bxdDetail.getInsuranceType() == null ? "" : bxdDetail.getInsuranceType());
                            detailMap.put("insurance_main", bxdDetail.getInsuranceMain() == null ? "" : bxdDetail.getInsuranceMain());
                            detailMap.put("insurance_num", bxdDetail.getInsuranceNum() == null ? "" : bxdDetail.getInsuranceNum());

                            warranty_base_info.add(detailMap);
                            //拿到对应的里面的list对应的外键
                            String detailsIdTwo = bxdDetail.getDetailsIdTwo();

                            List<BxdApplicantDetail> applicantDetailList = bxdApplicantDetailMapper.select(new BxdApplicantDetail(detailsIdTwo));
                            List<PcCustomerBaseInfo> customerBaseInfos = pcCustomerBaseInfoMapper.select(new PcCustomerBaseInfo(orderNum));
                            String phone = "";
                            if (customerBaseInfos.size() > 0) {

                                for (PcCustomerBaseInfo pcCustomerBaseInfo : customerBaseInfos) {
                                    phone = pcCustomerBaseInfo.getPhone() == null ? "" : pcCustomerBaseInfo.getPhone();
                                }
                            }
                            if (applicantDetailList.size() > 0) {
                                for (BxdApplicantDetail bxdApplicantDetail : applicantDetailList) {
                                    Map<String, Object> bxdApplicantMap = new HashMap<>();
                                    bxdApplicantMap.put("applicant_name", bxdApplicantDetail.getApplicantName() == null ? "" : bxdApplicantDetail.getApplicantName());
                                    bxdApplicantMap.put("applicant_id_card_num", bxdApplicantDetail.getApplicantIdCardNum() == null ? "" : bxdApplicantDetail.getApplicantIdCardNum());
                                    bxdApplicantMap.put("applicant_cell_phone", bxdApplicantDetail.getApplicantCellPhone() == null ? "" : bxdApplicantDetail.getApplicantCellPhone());
                                    bxdApplicantMap.put("applicant_profession", bxdApplicantDetail.getApplicantProfession() == null ? "" : bxdApplicantDetail.getApplicantProfession());
                                    bxdApplicantMap.put("applicant_address", bxdApplicantDetail.getApplicantAddress() == null ? "" : bxdApplicantDetail.getApplicantAddress());

                                    bxdApplicantMap.put("applicant_email", bxdApplicantDetail.getApplicantEmail() == null ? "" : bxdApplicantDetail.getApplicantEmail());
                                    bxdApplicantMap.put("wxid", bxdBI.getWxid() == null ? "" : bxdBI.getWxid());

                                    bxdApplicantMap.put("telephone", telephone);
                                    bxdApplicantMap.put("warning", false);
                                    bxdApplicantMap.put("company_school", company_school);


                                    applicant_info.add(bxdApplicantMap);
                                }

                            }

                            List<BxdInsuranceKind> bxdInsuranceKinds = bxdInsuranceKindMapper.select(new BxdInsuranceKind(detailsIdTwo));
                            if (bxdInsuranceKinds.size() > 0) {
                                for (BxdInsuranceKind bxdInsuranceKind : bxdInsuranceKinds) {
                                    Map<String, Object> insuranceKindMap = new HashMap<>();
                                    insuranceKindMap.put("insurance_kind_insurance_name", bxdInsuranceKind.getInsuranceKindInsuranceName() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceName());
                                    insuranceKindMap.put("insurance_kind_insurance_type", bxdInsuranceKind.getInsuranceKindInsuranceType() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceType());
                                    insuranceKindMap.put("insurance_kind_insured_amount", bxdInsuranceKind.getInsuranceKindInsuredAmount() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuredAmount());
                                    insuranceKindMap.put("insurance_kind_insurance_period", bxdInsuranceKind.getInsuranceKindInsurancePeriod() == null ? "" : bxdInsuranceKind.getInsuranceKindInsurancePeriod());
                                    insuranceKindMap.put("insurance_kind_insurance_premium", bxdInsuranceKind.getInsuranceKindInsurancePremium() == null ? "" : bxdInsuranceKind.getInsuranceKindInsurancePremium());
                                    insuranceKindMap.put("insurance_kind_insurance_status", bxdInsuranceKind.getInsuranceKindInsuranceStatus() == null ? "" : bxdInsuranceKind.getInsuranceKindInsuranceStatus());

                                    warranty_details.add(insuranceKindMap);
                                }
                            }

                            List<BxdPaymentDetail> paymentDetails = bxdPaymentDetailMapper.orderBy(detailsIdTwo);
                            if (paymentDetails.size() > 0) {
                                for (BxdPaymentDetail bxdPaymentDetail : paymentDetails) {
                                    Map<String, Object> paymentDetailMap = new HashMap<>();
                                    paymentDetailMap.put("insurance_amt", bxdPaymentDetail.getInsuranceAmt() == null ? "" : bxdPaymentDetail.getInsuranceAmt());
                                    paymentDetailMap.put("start_date", bxdPaymentDetail.getStartDate() == null ? "" : bxdPaymentDetail.getStartDate());
                                    paymentDetailMap.put("pay_end_date", bxdPaymentDetail.getPayEndDate() == null ? "" : bxdPaymentDetail.getPayEndDate());
                                    paymentDetailMap.put("pay_amt", bxdPaymentDetail.getPayAmt() == null ? "" : bxdPaymentDetail.getPayAmt());
                                    paymentDetailMap.put("pay_had_times", bxdPaymentDetail.getPayHadTimes() == null ? "" : bxdPaymentDetail.getPayHadTimes());
                                    paymentDetailMap.put("pay_period", bxdPaymentDetail.getPayPeriod() == null ? "" : bxdPaymentDetail.getPayPeriod());
                                    paymentDetailMap.put("payment_frequency", bxdPaymentDetail.getPaymentFrequency() == null ? "" : bxdPaymentDetail.getPaymentFrequency());
                                    paymentDetailMap.put("payment_type", bxdPaymentDetail.getPaymentType() == null ? "" : bxdPaymentDetail.getPaymentType());
                                    paymentDetailMap.put("warning", false);

                                    paymentDetailMap.put("next_pay_date", bxdPaymentDetail.getNextPayDate() == null ? "" : bxdPaymentDetail.getNextPayDate());
                                    paymentDetailMap.put("policy_start_date", bxdPaymentDetail.getPolicyStartDate() == null ? "" : bxdPaymentDetail.getPolicyStartDate());
                                    paymentDetailMap.put("end_date", bxdPaymentDetail.getEndDate() == null ? "" : bxdPaymentDetail.getEndDate());
                                    paymentDetailMap.put("pay_need_times", bxdPaymentDetail.getPayNeedTimes() == null ? "" : bxdPaymentDetail.getPayNeedTimes());
                                    paymentDetailMap.put("insurance_premium", bxdPaymentDetail.getInsurancePremium() == null ? "" : bxdPaymentDetail.getInsurancePremium());
                                    paymentDetailMap.put("payment_premium_payable", bxdPaymentDetail.getPaymentPremiumPayable() == null ? "" : bxdPaymentDetail.getPaymentPremiumPayable());
                                    paymentDetailMap.put("payment_premium_charge", bxdPaymentDetail.getPaymentPremiumCharge() == null ? "" : bxdPaymentDetail.getPaymentPremiumCharge());


                                    payment_info.add(paymentDetailMap);
                                }
                            }

                            List<BxdInsurantDetail> insurantDetails = bxdInsurantDetailMapper.select(new BxdInsurantDetail(detailsIdTwo));
                            List<BxdBeneficiary> beneficiaries = bxdBeneficiaryMapper.select(new BxdBeneficiary(detailsIdTwo));
                            List<BxdVehicleInsuranceDetail> vehicleInsuranceDetails = bxdVehicleInsuranceDetailMapper.select(new BxdVehicleInsuranceDetail(detailsIdTwo));
                            if (insurantDetails.size() > 0) {
                                for (BxdInsurantDetail bxdInsurantDetail : insurantDetails) {
                                    Map<String, Object> InsurantDetailMap = new HashMap<>();
                                    InsurantDetailMap.put("insurant_id_card_num", bxdInsurantDetail.getInsurantIdCardNum() == null ? "" : bxdInsurantDetail.getInsurantIdCardNum());
                                    InsurantDetailMap.put("insurant_relationship", bxdInsurantDetail.getInsurantRelationship() == null ? "" : bxdInsurantDetail.getInsurantRelationship());
                                    InsurantDetailMap.put("insurant_name", bxdInsurantDetail.getInsurantName() == null ? "" : bxdInsurantDetail.getInsurantName());
                                    InsurantDetailMap.put("beneficiary_name", "");
                                    InsurantDetailMap.put("beneficiary_relationship", "");
                                    InsurantDetailMap.put("auto_insurance", "无");
                                    if (vehicleInsuranceDetails.size() > 0) {
                                        InsurantDetailMap.put("auto_insurance", "有");
                                    }
                                    if (beneficiaries.size() > 0) {
                                        for (BxdBeneficiary bxdBeneficiary : beneficiaries) {
                                            InsurantDetailMap.put("beneficiary_relationship", bxdBeneficiary.getBeneficiaryRelationship() == null ? "" : bxdBeneficiary.getBeneficiaryRelationship());
                                            InsurantDetailMap.put("beneficiary_name", bxdBeneficiary.getBeneficiaryName() == null ? "" : bxdBeneficiary.getBeneficiaryName());
                                            other_info.add(InsurantDetailMap);
                                        }
                                    } else {
                                        other_info.add(InsurantDetailMap);
                                    }
                                }
                            }
                        }

                    }
                }

            } else if (bxdBases.size() > 0) {
                String name = "";
                String profession = "";
                String city = "";
                String marital_status = "";
                //拿到user的相关信息
                List<BxdSunshineUserInfo> userInfos = bxdSunshineUserInfoMapper.select(new BxdSunshineUserInfo(orderNum));
                if (userInfos.size() > 0) {
                    for (BxdSunshineUserInfo bxdSunshineUserInfo : userInfos) {
                        profession = bxdSunshineUserInfo.getProfession() == null ? "" : bxdSunshineUserInfo.getProfession();
                        city = bxdSunshineUserInfo.getCity() == null ? "" : bxdSunshineUserInfo.getCity();
                        name = bxdSunshineUserInfo.getUsername() == null ? "" : bxdSunshineUserInfo.getUsername();
                        marital_status = bxdSunshineUserInfo.getMaritalStatus() == null ? "" : bxdSunshineUserInfo.getMaritalStatus();
                    }
                }
                //投保人信息
                List<BxdSunshineApplicant> applicantLists = bxdSunshineApplicantMapper.select(new BxdSunshineApplicant(orderNum));
                if (applicantLists.size() > 0) {
                    for (BxdSunshineApplicant bxdSunshineApplicant : applicantLists) {
                        Map<String, Object> bxdApplicantMap = new HashMap<>();
                        bxdApplicantMap.put("applicant_name", bxdSunshineApplicant.getName() == null ? "" : bxdSunshineApplicant.getName());
                        bxdApplicantMap.put("applicant_id_card_num", bxdSunshineApplicant.getIdCardNo() == null ? "" : bxdSunshineApplicant.getIdCardNo());
                        bxdApplicantMap.put("applicant_cell_phone", bxdSunshineApplicant.getPhoneNo() == null ? "" : bxdSunshineApplicant.getPhoneNo());
                        bxdApplicantMap.put("applicant_profession", profession);
                        bxdApplicantMap.put("applicant_address", bxdSunshineApplicant.getAddress() == null ? "" : bxdSunshineApplicant.getAddress());
                        bxdApplicantMap.put("warning", false);
                        bxdApplicantMap.put("company_school", bxdSunshineApplicant.getCompany() == null ? "" : bxdSunshineApplicant.getCompany());

                        applicant_info.add(bxdApplicantMap);
                    }
                }

                //保单信息 warranty_base_info
                List<BxdSunshinePolicyInfoList> BxdSunshinePolicyInfoList = bxdSunshinePolicyInfoListMapper.select(new BxdSunshinePolicyInfoList(orderNum));
                if (BxdSunshinePolicyInfoList.size() > 0) {
                    for (BxdSunshinePolicyInfoList bxdSunshinePolicyInfoList : BxdSunshinePolicyInfoList) {
                        //遍历拿到其中一个对象
                        Map<String, Object> detailMap = new HashMap<>();
                        detailMap.put("insurance_id", bxdSunshinePolicyInfoList.getPolicyNo() == null ? "" : bxdSunshinePolicyInfoList.getPolicyNo());
                        detailMap.put("company", bxdSunshinePolicyInfoList.getCompany() == null ? "" : bxdSunshinePolicyInfoList.getCompany() == null);
                        detailMap.put("name", name);
                        detailMap.put("insurance_name", "");
                        detailMap.put("insurance_type", bxdSunshinePolicyInfoList.getType() == null ? "" : bxdSunshinePolicyInfoList.getType());
                        detailMap.put("insurance_main", bxdSunshinePolicyInfoList.getMainInsurance() == null ? "" : bxdSunshinePolicyInfoList.getMainInsurance());
                        detailMap.put("insurance_num", bxdSunshinePolicyInfoList.getQuantity() == null ? "" : bxdSunshinePolicyInfoList.getQuantity());

                        warranty_base_info.add(detailMap);
                    }

                    for (BxdSunshinePolicyInfoList bxdSunshinePolicyInfoList : BxdSunshinePolicyInfoList) {
                        Map<String, Object> insuranceKindMap = new HashMap<>();
                        //遍历拿到其中一个对象
                        insuranceKindMap.put("insurance_kind_insurance_name", bxdSunshinePolicyInfoList.getMainInsurance() == null ? "" : bxdSunshinePolicyInfoList.getMainInsurance());
                        insuranceKindMap.put("insurance_kind_insurance_type", bxdSunshinePolicyInfoList.getType() == null ? "" : bxdSunshinePolicyInfoList.getType());
                        insuranceKindMap.put("insurance_kind_insured_amount", bxdSunshinePolicyInfoList.getAmount() == null ? "" : bxdSunshinePolicyInfoList.getAmount());
                        insuranceKindMap.put("insurance_kind_insurance_premium", "");
                        insuranceKindMap.put("insurance_kind_insurance_status", bxdSunshinePolicyInfoList.getStatus() == null ? "" : bxdSunshinePolicyInfoList.getStatus());
                        insuranceKindMap.put("insurance_kind_insurance_period", bxdSunshinePolicyInfoList.getPeriod() == null ? "" : bxdSunshinePolicyInfoList.getPeriod());

                        warranty_details.add(insuranceKindMap);
                    }
                }

                //查询所有的paymentInfo信息
                BxdSunshinePaymentInfo bxdSunshine = new BxdSunshinePaymentInfo();
                bxdSunshine.setOrderNum(orderNum);
                List<BxdSunshinePaymentInfo> paymentInfos = bxdSunshinePaymentInfoMapper.orderBy(bxdSunshine);
                if (paymentInfos.size() > 0) {
                    for (BxdSunshinePaymentInfo bxdSunshinePaymentInfo : paymentInfos) {
                        Map<String, Object> paymentDetailMap = new HashMap<>();
                        paymentDetailMap.put("insurance_amt", bxdSunshinePaymentInfo.getTotalPremium() == null ? "" : bxdSunshinePaymentInfo.getTotalPremium());
                        paymentDetailMap.put("start_date", bxdSunshinePaymentInfo.getStartDate() == null ? "" : bxdSunshinePaymentInfo.getStartDate());
                        paymentDetailMap.put("pay_end_date", bxdSunshinePaymentInfo.getEndDate() == null ? "" : bxdSunshinePaymentInfo.getEndDate());
                        paymentDetailMap.put("pay_amt", bxdSunshinePaymentInfo.getPeriodAmount() == null ? "" : bxdSunshinePaymentInfo.getPeriodAmount());
                        paymentDetailMap.put("pay_had_times", bxdSunshinePaymentInfo.getPaidCount() == null ? "" : bxdSunshinePaymentInfo.getPaidCount());
                        paymentDetailMap.put("pay_period", bxdSunshinePaymentInfo.getPeriod() == null ? "" : bxdSunshinePaymentInfo.getPeriod());
                        paymentDetailMap.put("payment_frequency", bxdSunshinePaymentInfo.getPayModel() == null ? "" : bxdSunshinePaymentInfo.getPayModel());
                        paymentDetailMap.put("payment_type", bxdSunshinePaymentInfo.getType() == null ? "" : bxdSunshinePaymentInfo.getType());

                        payment_info.add(paymentDetailMap);
                    }
                }

                //other_info
                BxdSunshineInsurantList bxdSunshineInsura = new BxdSunshineInsurantList();
                bxdSunshineInsura.setOrderNum(orderNum);
                List<BxdSunshineInsurantList> insurantLists = bxdSunshineInsurantListMapper.select(bxdSunshineInsura);
                BxdSunshineBeneficiaryList bxdSunshineBeneficia = new BxdSunshineBeneficiaryList();
                bxdSunshineBeneficia.setOrderNum(orderNum);
                List<BxdSunshineBeneficiaryList> bxdSunshineBenefi = bxdSunshineBeneficiaryListMapper.select(bxdSunshineBeneficia);
                if (insurantLists.size() > 0) {
                    for (BxdSunshineInsurantList bxdSunshineInsurantList : insurantLists) {
                        Map<String, Object> InsurantDetailMap = new HashMap<>();
                        InsurantDetailMap.put("insurant_id_card_num", bxdSunshineInsurantList.getIdCardNo() == null ? "" : bxdSunshineInsurantList.getIdCardNo());
                        InsurantDetailMap.put("insurant_name", bxdSunshineInsurantList.getName() == null ? "" : bxdSunshineInsurantList.getName());
                        InsurantDetailMap.put("insurant_relationship", bxdSunshineInsurantList.getRelation() == null ? "" : bxdSunshineInsurantList.getRelation());
                        InsurantDetailMap.put("beneficiary_name", "");
                        InsurantDetailMap.put("beneficiary_relationship", "");
                        InsurantDetailMap.put("auto_insurance", "无");
                        if (bxdSunshineBenefi.size() > 0) {
                            for (BxdSunshineBeneficiaryList bxdSunshineBeneficiaryList : bxdSunshineBenefi) {
                                InsurantDetailMap.put("beneficiary_name", bxdSunshineBeneficiaryList.getName() == null ? "" : bxdSunshineBeneficiaryList.getName());
                                InsurantDetailMap.put("beneficiary_relationship", bxdSunshineBeneficiaryList.getRelation() == null ? "" : bxdSunshineBeneficiaryList.getRelation());

                            }
                        }
                        other_info.add(InsurantDetailMap);
                    }
                }
            }
        } catch (Exception e) {

            log.info("bxd get Info Exception", e);
        } finally {
            dataMap.put("applicant_info", applicant_info);
            dataMap.put("warranty_base_info", warranty_base_info);
            dataMap.put("warranty_details", warranty_details);
            dataMap.put("payment_info", payment_info);
            dataMap.put("other_info", other_info);
        }
        return ResponseResult.ok(dataMap);
    }


    public void delete(String orderNum) {
        bxdApplicantDetailMapper.delete(new BxdApplicantDetail(orderNum));
        bxdBaseInfoMapper.delete(new BxdBaseInfo(orderNum));
        bxdBeneficiaryMapper.delete(new BxdBeneficiary(orderNum));
        bxdDetailMapper.delete(new BxdDetail(orderNum));
        bxdInsuranceKindMapper.delete(new BxdInsuranceKind(orderNum));
        bxdInsuranceKindMapper.delete(new BxdInsuranceKind(orderNum));
        bxdPaymentDetailMapper.delete(new BxdPaymentDetail(orderNum));
    }
}
