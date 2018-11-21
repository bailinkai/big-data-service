package com.yingu.project.big.data.service.bxd;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.persistence.entity.bxd.*;
import com.yingu.project.big.data.persistence.mapper.bxd.*;
import com.yingu.project.big.data.util.SubStringUUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
public class SunshineInsuranceSaveInfoServiceImpl implements SunshineInsuranceSaveInfoService {

    @Autowired
    BxdSunshineUserInfoMapper bxdSunshineUserInfoMapper;
    @Autowired
    BxdSunshinePolicyInfoListMapper bxdSunshinePolicyInfoListMapper;
    @Autowired
    BxdSunshineSaleInfoMapper bxdSunshineSaleInfoMapper;
    @Autowired
    BxdSunshineBeneficiaryListMapper bxdSunshineBeneficiaryListMapper;
    @Autowired
    BxdSunshineDutyListMapper bxdSunshineDutyListMapper;
    @Autowired
    BxdSunshineInsurantListMapper bxdSunshineInsurantListMapper;
    @Autowired
    BxdSunshinePayRecordListMapper bxdSunshinePayRecordListMapper;
    @Autowired
    BxdSunshinePaymentInfoMapper bxdSunshinePaymentInfoMapper;
    @Autowired
    BxdSunshineApplicantMapper bxdSunshineApplicantMapper;

    @Override
    public boolean saveSunInfo(JSONObject jsonObject, String orderNum) {
        try {
            //jsonObject中是transactionsInfo 中的数据
            if (jsonObject.size() > 0) {

                this.delteSunInfo(orderNum);

                List<BxdSunshinePayRecordList> bxdSunshinePayRecordListList = new ArrayList<>();
                List<BxdSunshinePolicyInfoList> bxdSunshinePolicyInfoListList = new ArrayList<>();
                List<BxdSunshineBeneficiaryList> bxdSunshineBeneficiaryListList = new ArrayList<>();
                List<BxdSunshineDutyList> bxdSunshineDutyListList = new ArrayList<>();
                List<BxdSunshineInsurantList> bxdSunshineInsurantListList = new ArrayList<>();
                //userInfo
                JSONObject userInfoOb = jsonObject.get("userInfo") == null ? new JSONObject() : (JSONObject) jsonObject.get("userInfo");
                //当客户信息不为空时
                if (userInfoOb != null) {
                    BxdSunshineUserInfo bxdSunshineUserInfo = new BxdSunshineUserInfo();
                    bxdSunshineUserInfo.setMappingId(userInfoOb.get("mapping_id") == null ? "" : userInfoOb.get("mapping_id").toString());
                    bxdSunshineUserInfo.setUsername(userInfoOb.get("username") == null ? "" : userInfoOb.get("username").toString());
                    bxdSunshineUserInfo.setTrueName(userInfoOb.get("true_name") == null ? "" : userInfoOb.get("true_name").toString());
                    bxdSunshineUserInfo.setIdCardType(userInfoOb.get("id_card_type") == null ? "" : userInfoOb.get("id_card_type").toString());
                    bxdSunshineUserInfo.setIdCardNo(userInfoOb.get("id_card_no") == null ? "" : userInfoOb.get("id_card_no").toString());
                    bxdSunshineUserInfo.setGender(userInfoOb.get("gender") == null ? "" : userInfoOb.get("gender").toString());
                    bxdSunshineUserInfo.setBirthday(userInfoOb.get("birthday") == null ? "" : userInfoOb.get("birthday").toString());
                    bxdSunshineUserInfo.setPhoneNo(userInfoOb.get("phone_no") == null ? "" : userInfoOb.get("phone_no").toString());
                    bxdSunshineUserInfo.setEmail(userInfoOb.get("email") == null ? "" : userInfoOb.get("email").toString());
                    bxdSunshineUserInfo.setProfession(userInfoOb.get("profession") == null ? "" : userInfoOb.get("profession").toString());
                    bxdSunshineUserInfo.setCity(userInfoOb.get("city") == null ? "" : userInfoOb.get("city").toString());
                    bxdSunshineUserInfo.setAddress(userInfoOb.get("address") == null ? "" : userInfoOb.get("address").toString());
                    bxdSunshineUserInfo.setHousing(userInfoOb.get("housing") == null ? "" : userInfoOb.get("housing").toString());
                    bxdSunshineUserInfo.setMaritalStatus(userInfoOb.get("marital_status") == null ? "" : userInfoOb.get("marital_status").toString());
                    bxdSunshineUserInfo.setChildren(userInfoOb.get("children") == null ? "" : userInfoOb.get("children").toString());
                    bxdSunshineUserInfo.setMonthlyIncome(userInfoOb.get("monthly_income") == null ? "" : userInfoOb.get("monthly_income").toString());
                    bxdSunshineUserInfo.setAnnualIncome(userInfoOb.get("annual_income") == null ? "" : userInfoOb.get("annual_income").toString());

                    bxdSunshineUserInfo.setUuid(SubStringUUID.subUUID());
                    bxdSunshineUserInfo.setOrderNum(orderNum);
                    bxdSunshineUserInfo.setCreateTime(new Date());
                    bxdSunshineUserInfoMapper.insert(bxdSunshineUserInfo);
                }
                //policyInfoList
                JSONArray policyInfoList = jsonObject.get("policyInfoList") == null ? new JSONArray() : jsonObject.getJSONArray("policyInfoList");
                if (policyInfoList.size() > 0) {
                    String listId = "";

                    List<BxdSunshineSaleInfo> bxdSunshineSaleInfoList = new ArrayList<>();
                    for (Object ob : policyInfoList) {
                        listId = SubStringUUID.subUUID();
                        Map<String, Object> map = (Map<String, Object>) ob;
                        BxdSunshinePolicyInfoList bxdSunshinePolicyInfoList = new BxdSunshinePolicyInfoList();
                        bxdSunshinePolicyInfoList.setEndDate(map.get("end_date") == null ? "" : map.get("end_date").toString());
                        bxdSunshinePolicyInfoList.setPolicyNo(map.get("policy_no") == null ? "" : map.get("policy_no").toString());
                        bxdSunshinePolicyInfoList.setMainInsurance(map.get("main_insurance") == null ? "" : map.get("main_insurance").toString());
                        bxdSunshinePolicyInfoList.setMappingId(map.get("mapping_id") == null ? "" : map.get("mapping_id").toString());
                        bxdSunshinePolicyInfoList.setCompany(map.get("company") == null ? "" : map.get("company").toString());
                        bxdSunshinePolicyInfoList.setStartDate(map.get("start_date") == null ? "" : map.get("start_date").toString());
                        bxdSunshinePolicyInfoList.setListId(listId);

                        bxdSunshinePolicyInfoList.setUuid(SubStringUUID.subUUID());
                        bxdSunshinePolicyInfoList.setOrderNum(orderNum);
                        bxdSunshinePolicyInfoList.setCreateTime(new Date());

                        //bxdSunshinePolicyInfoListMapper.insert(bxdSunshinePolicyInfoList);
                        bxdSunshinePolicyInfoListList.add(bxdSunshinePolicyInfoList);

                        JSONObject saleInfoOb = map.get("saleInfo") == null ? new JSONObject() : JSONObject.parseObject(map.get("saleInfo").toString());

                        BxdSunshineSaleInfo bxdSunshineSaleInfo = new BxdSunshineSaleInfo();
                        bxdSunshineSaleInfo.setUnit(saleInfoOb.get("unit") == null ? "" : saleInfoOb.get("unit").toString());
                        bxdSunshineSaleInfo.setAddress(saleInfoOb.get("address") == null ? "" : saleInfoOb.get("address").toString());
                        bxdSunshineSaleInfo.setStaffName(saleInfoOb.get("staff_name") == null ? "" : saleInfoOb.get("staff_name").toString());
                        bxdSunshineSaleInfo.setStaffNo(saleInfoOb.get("staff_no") == null ? "" : saleInfoOb.get("staff_no").toString());
                        bxdSunshineSaleInfo.setStaffPhone(saleInfoOb.get("staff_phone") == null ? "" : saleInfoOb.get("staff_phone").toString());
                        bxdSunshineSaleInfo.setStaffEmail(saleInfoOb.get("staff_email") == null ? "" : saleInfoOb.get("staff_email").toString());
                        bxdSunshineSaleInfo.setStaffAddress(saleInfoOb.get("staff_address") == null ? "" : saleInfoOb.get("staff_address").toString());
                        bxdSunshineSaleInfo.setStaffStatus(saleInfoOb.get("staff_status") == null ? "" : saleInfoOb.get("staff_status").toString());

                        bxdSunshineSaleInfo.setListId(listId);
                        bxdSunshineSaleInfo.setCreateTime(new Date());
                        bxdSunshineSaleInfo.setUuid(SubStringUUID.subUUID());
                        bxdSunshineSaleInfo.setOrderNum(orderNum);
                        // bxdSunshineSaleInfoMapper.insert(bxdSunshineSaleInfo);
                        bxdSunshineSaleInfoList.add(bxdSunshineSaleInfo);

                        JSONArray beneficiaryList = map.get("beneficiaryList") == null ? new JSONArray() : (JSONArray) map.get("beneficiaryList");
                        if (beneficiaryList.size() > 0) {

                            for (Object ob1 : beneficiaryList) {
                                Map<String, Object> map1 = (Map<String, Object>) ob1;
                                BxdSunshineBeneficiaryList bxdSunshineBeneficiaryList = new BxdSunshineBeneficiaryList();
                                bxdSunshineBeneficiaryList.setName(map1.get("name") == null ? "" : map1.get("name").toString());
                                bxdSunshineBeneficiaryList.setRelation(map1.get("relation") == null ? "" : map1.get("relation").toString());
                                bxdSunshineBeneficiaryList.setBeOrder(map1.get("be_order") == null ? "" : map1.get("be_order").toString());
                                bxdSunshineBeneficiaryList.setScale(map1.get("scale") == null ? "" : map1.get("scale").toString());
                                bxdSunshineBeneficiaryList.setType(map1.get("type") == null ? "" : map1.get("type").toString());
                                bxdSunshineBeneficiaryList.setIdCardType(map1.get("id_card_type") == null ? "" : map1.get("id_card_type").toString());
                                bxdSunshineBeneficiaryList.setIdCardNo(map1.get("id_card_no") == null ? "" : map1.get("id_card_no").toString());

                                bxdSunshineBeneficiaryList.setListId(listId);
                                bxdSunshineBeneficiaryList.setCreateTime(new Date());
                                bxdSunshineBeneficiaryList.setUuid(SubStringUUID.subUUID());
                                bxdSunshineBeneficiaryList.setOrderNum(orderNum);
                                //bxdSunshineBeneficiaryListMapper.insert(bxdSunshineBeneficiaryList);
                                bxdSunshineBeneficiaryListList.add(bxdSunshineBeneficiaryList);
                            }
                        }

                        JSONArray dutyList = map.get("dutyList") == null ? new JSONArray() : (JSONArray) map.get("dutyList");
                        if (dutyList.size() > 0) {

                            for (Object ob1 : dutyList) {
                                Map<String, Object> map1 = (Map<String, Object>) ob1;
                                BxdSunshineDutyList bxdSunshineDutyList = new BxdSunshineDutyList();
                                bxdSunshineDutyList.setName(map1.get("name") == null ? "" : map1.get("name").toString());
                                bxdSunshineDutyList.setAmount(map1.get("amount") == null ? "" : map1.get("amount").toString());
                                bxdSunshineDutyList.setPremium(map1.get("premium") == null ? "" : map1.get("premium").toString());
                                bxdSunshineDutyList.setQuantity(map1.get("quantity") == null ? "" : map1.get("quantity").toString());
                                bxdSunshineDutyList.setStatus(map1.get("status") == null ? "" : map1.get("status").toString());
                                bxdSunshineDutyList.setStartDate(map1.get("start_date") == null ? "" : map1.get("start_date").toString());
                                bxdSunshineDutyList.setEndDate(map1.get("end_date") == null ? "" : map1.get("end_date").toString());
                                bxdSunshineDutyList.setGrade(map1.get("grade") == null ? "" : map1.get("grade").toString());
                                bxdSunshineDutyList.setMainInsurance(map1.get("main_insurance") == null ? null : Boolean.parseBoolean(map1.get("main_insurance").toString()));
                                bxdSunshineDutyList.setPeriod(map1.get("period") == null ? "" : map1.get("period").toString());
                                bxdSunshineDutyList.setTotalPremium(map1.get("total_premium") == null ? "" : map1.get("total_premium").toString());
                                bxdSunshineDutyList.setPeriodAmount(map1.get("period_amount") == null ? "" : map1.get("period_amount").toString());
                                bxdSunshineDutyList.setAddtionAmount(map1.get("addtion_amount") == null ? "" : map1.get("addtion_amount").toString());
                                bxdSunshineDutyList.setPayPeriod(map1.get("pay_period") == null ? "" : map1.get("pay_period").toString());
                                bxdSunshineDutyList.setNextPayDate(map1.get("next_pay_date") == null ? "" : map1.get("next_pay_date").toString());
                                bxdSunshineDutyList.setNextPayAmount(map1.get("next_pay_amount") == null ? "" : map1.get("next_pay_amount").toString());
                                bxdSunshineDutyList.setPayDueDate(map1.get("pay_due_date") == null ? "" : map1.get("pay_due_date").toString());
                                bxdSunshineDutyList.setPaymentDate(map1.get("payment_date") == null ? "" : map1.get("payment_date").toString());
                                bxdSunshineDutyList.setPayType(map1.get("pay_type") == null ? "" : map1.get("pay_type").toString());
                                bxdSunshineDutyList.setPayAddress(map1.get("pay_address") == null ? "" : map1.get("pay_address").toString());
                                bxdSunshineDutyList.setPayAccount(map1.get("pay_account") == null ? "" : map1.get("pay_account").toString());
                                bxdSunshineDutyList.setPayBank(map1.get("pay_bank") == null ? "" : map1.get("pay_bank").toString());
                                bxdSunshineDutyList.setCreateTime(new Date());
                                bxdSunshineDutyList.setOrderNum(orderNum);
                                bxdSunshineDutyList.setUuid(SubStringUUID.subUUID());
                                bxdSunshineDutyList.setListId(listId);
                                //bxdSunshineDutyListMapper.insert(bxdSunshineDutyList);
                                bxdSunshineDutyListList.add(bxdSunshineDutyList);
                            }
                        }

                        JSONArray insurantList = map.get("insurantList") == null ? new JSONArray() : (JSONArray) map.get("insurantList");
                        if (insurantList.size() > 0) {

                            for (Object ob1 : insurantList) {
                                Map<String, Object> map1 = (Map<String, Object>) ob1;
                                BxdSunshineInsurantList bxdSunshineInsurantList = new BxdSunshineInsurantList();
                                bxdSunshineInsurantList.setName(map1.get("name") == null ? "" : map1.get("name").toString());
                                bxdSunshineInsurantList.setGender(map1.get("gender") == null ? "" : map1.get("gender").toString());
                                bxdSunshineInsurantList.setRelation(map1.get("relation") == null ? "" : map1.get("relation").toString());
                                bxdSunshineInsurantList.setBirthday(map1.get("birthday") == null ? "" : map1.get("birthday").toString());
                                bxdSunshineInsurantList.setIdCardType(map1.get("id_card_type") == null ? "" : map1.get("id_card_type").toString());
                                bxdSunshineInsurantList.setIdCardNo(map1.get("id_card_no") == null ? "" : map1.get("id_card_no").toString());
                                bxdSunshineInsurantList.setPhoneNo(map1.get("phone_no") == null ? "" : map1.get("phone_no").toString());
                                bxdSunshineInsurantList.setEmail(map1.get("email") == null ? "" : map1.get("email").toString());
                                bxdSunshineInsurantList.setAddress(map1.get("address") == null ? "" : map1.get("address").toString());
                                bxdSunshineInsurantList.setCreateTime(new Date());
                                bxdSunshineInsurantList.setUuid(SubStringUUID.subUUID());
                                bxdSunshineInsurantList.setListId(listId);
                                bxdSunshineInsurantList.setOrderNum(orderNum);
                                //bxdSunshineInsurantListMapper.insert(bxdSunshineInsurantList);
                                bxdSunshineInsurantListList.add(bxdSunshineInsurantList);
                            }

                        }
                        JSONObject paymentInfo = map.get("paymentInfo") == null ? new JSONObject() : JSONObject.parseObject(map.get("paymentInfo").toString());
                        if (paymentInfo.size() > 0) {
                            String period_amount = paymentInfo.get("period_amount") == null ? "" : paymentInfo.get("period_amount").toString();

                            BxdSunshinePaymentInfo bxdSunshinePaymentInfo = new BxdSunshinePaymentInfo();
                            bxdSunshinePaymentInfo.setTotalPremium(paymentInfo.get("total_premium") == null ? "" : paymentInfo.get("total_premium").toString());
                            bxdSunshinePaymentInfo.setPeriodAmount(paymentInfo.get("period_amount") == null ? "" : paymentInfo.get("period_amount").toString());
                            bxdSunshinePaymentInfo.setPeriod(paymentInfo.get("period") == null ? "" : paymentInfo.get("period").toString());
                            bxdSunshinePaymentInfo.setStartDate(paymentInfo.get("start_date") == null ? "" : paymentInfo.get("start_date").toString());
                            bxdSunshinePaymentInfo.setEndDate(paymentInfo.get("end_date") == null ? "" : paymentInfo.get("end_date").toString());
                            bxdSunshinePaymentInfo.setPayModel(paymentInfo.get("pay_model") == null ? "" : paymentInfo.get("pay_model").toString());
                            bxdSunshinePaymentInfo.setNextPayDate(paymentInfo.get("next_pay_date") == null ? "" : paymentInfo.get("next_pay_date").toString());
                            bxdSunshinePaymentInfo.setNextPayAmount(paymentInfo.get("next_pay_amount") == null ? "" : paymentInfo.get("next_pay_amount").toString());
                            bxdSunshinePaymentInfo.setPayDueDate(paymentInfo.get("pay_due_date") == null ? "" : paymentInfo.get("pay_due_date").toString());
                            bxdSunshinePaymentInfo.setDatePayable(paymentInfo.get("date_payable") == null ? "" : paymentInfo.get("date_payable").toString());
                            bxdSunshinePaymentInfo.setPaidDate(paymentInfo.get("paid_date") == null ? "" : paymentInfo.get("paid_date").toString());
                            bxdSunshinePaymentInfo.setType(paymentInfo.get("type") == null ? "" : paymentInfo.get("type").toString());
                            bxdSunshinePaymentInfo.setAccount(paymentInfo.get("account") == null ? "" : paymentInfo.get("account").toString());
                            bxdSunshinePaymentInfo.setBank(paymentInfo.get("bank") == null ? "" : paymentInfo.get("bank").toString());
                            bxdSunshinePaymentInfo.setStatus(paymentInfo.get("status") == null ? "" : paymentInfo.get("status").toString());
                            bxdSunshinePaymentInfo.setCurrentPayDueDate(paymentInfo.get("current_pay_due_date") == null ? "" : paymentInfo.get("current_pay_due_date").toString());
                            bxdSunshinePaymentInfo.setAddress(paymentInfo.get("address") == null ? "" : paymentInfo.get("address").toString());
                            bxdSunshinePaymentInfo.setFirstPayDate(paymentInfo.get("first_pay_date") == null ? "" : paymentInfo.get("first_pay_date").toString());
                            bxdSunshinePaymentInfo.setFirstPayAmount(paymentInfo.get("first_pay_amount") == null ? "" : paymentInfo.get("first_pay_amount").toString());
                            bxdSunshinePaymentInfo.setPayCount(paymentInfo.get("pay_count") == null ? "" : paymentInfo.get("pay_count").toString());
                            bxdSunshinePaymentInfo.setPaidCount(paymentInfo.get("paid_count") == null ? "" : paymentInfo.get("paid_count").toString());
                            bxdSunshinePaymentInfo.setCreateTime(new Date());
                            bxdSunshinePaymentInfo.setUuid(SubStringUUID.subUUID());
                            bxdSunshinePaymentInfo.setOrderNum(orderNum);
                            bxdSunshinePaymentInfo.setListId(listId);
                            bxdSunshinePaymentInfo.setPayRecordListId(listId);
                            bxdSunshinePaymentInfoMapper.insert(bxdSunshinePaymentInfo);

                            JSONArray payRecordList = paymentInfo.get("payRecordList") == null ? new JSONArray() : (JSONArray) paymentInfo.get("payRecordList");
                            if (payRecordList.size() > 0) {

                                for (Object ob1 : payRecordList) {
                                    Map<String, Object> map1 = (Map<String, Object>) ob1;
                                    BxdSunshinePayRecordList bxdSunshinePayRecordList = new BxdSunshinePayRecordList();
                                    bxdSunshinePayRecordList.setDate(map1.get("date") == null ? "" : map1.get("date").toString());
                                    bxdSunshinePayRecordList.setAmount(map1.get("amount") == null ? "" : map1.get("amount").toString());
                                    bxdSunshinePayRecordList.setAccount(map1.get("account") == null ? "" : map1.get("account").toString());
                                    bxdSunshinePayRecordList.setType(map1.get("type") == null ? "" : map1.get("type").toString());
                                    bxdSunshinePayRecordList.setStatus(map1.get("status") == null ? "" : map1.get("status").toString());
                                    bxdSunshinePayRecordList.setDescription(map1.get("description") == null ? "" : map1.get("description").toString());

                                    bxdSunshinePayRecordList.setCreateTime(new Date());
                                    bxdSunshinePayRecordList.setUuid(SubStringUUID.subUUID());
                                    bxdSunshinePayRecordList.setOrderNum(orderNum);
                                    bxdSunshinePayRecordList.setPayRecordListId(listId);

                                    bxdSunshinePayRecordListList.add(bxdSunshinePayRecordList);
                                    //bxdSunshinePayRecordListMapper.insert(bxdSunshinePayRecordList);
                                }
                            }
                        }

                        JSONObject applicant = map.get("applicant") == null ? new JSONObject() : (JSONObject) map.get("applicant");
                        if (applicant.size() > 0) {
                            BxdSunshineApplicant bxdSunshineApplicant = new BxdSunshineApplicant();
                            bxdSunshineApplicant.setName(applicant.get("name") == null ? "" : applicant.get("name").toString());
                            bxdSunshineApplicant.setGender(applicant.get("gender") == null ? "" : applicant.get("gender").toString());
                            bxdSunshineApplicant.setBirthday(applicant.get("birthday") == null ? "" : applicant.get("birthday").toString());
                            bxdSunshineApplicant.setIdCardType(applicant.get("id_card_type") == null ? "" : applicant.get("id_card_type").toString());
                            bxdSunshineApplicant.setIdCardNo(applicant.get("id_card_no") == null ? "" : applicant.get("id_card_no").toString());
                            bxdSunshineApplicant.setPhoneNo(applicant.get("phone_no") == null ? "" : applicant.get("phone_no").toString());
                            bxdSunshineApplicant.setEmail(applicant.get("email") == null ? "" : applicant.get("email").toString());
                            bxdSunshineApplicant.setAddress(applicant.get("address") == null ? "" : applicant.get("address").toString());
                            bxdSunshineApplicant.setCompany(applicant.get("company") == null ? "" : applicant.get("company").toString());
                            bxdSunshineApplicant.setCompanyAddress(applicant.get("company_address") == null ? "" : applicant.get("company_address").toString());
                            bxdSunshineApplicant.setUuid(SubStringUUID.subUUID());
                            bxdSunshineApplicant.setOrderNum(orderNum);
                            bxdSunshineApplicant.setCreateTime(new Date());
                            bxdSunshineApplicant.setListId(listId);
                            bxdSunshineApplicantMapper.insert(bxdSunshineApplicant);
                        }
                    }
                }

                if (!bxdSunshinePayRecordListList.isEmpty()) {
                    bxdSunshinePayRecordListMapper.insertList(bxdSunshinePayRecordListList);
                }

                if (!bxdSunshinePolicyInfoListList.isEmpty()) {
                    bxdSunshinePolicyInfoListMapper.insertList(bxdSunshinePolicyInfoListList);
                }

                if (!bxdSunshineBeneficiaryListList.isEmpty()) {
                    bxdSunshineBeneficiaryListMapper.insertList(bxdSunshineBeneficiaryListList);
                }

                if (!bxdSunshineDutyListList.isEmpty()) {
                    bxdSunshineDutyListMapper.insertList(bxdSunshineDutyListList);
                }
                if (!bxdSunshineInsurantListList.isEmpty()) {
                    bxdSunshineInsurantListMapper.insertList(bxdSunshineInsurantListList);
                }

            }
            return true;
        } catch (Exception e) {

            log.info("saveSunInfo error message" + e.getLocalizedMessage());
            return false;
        }
    }


    public void delteSunInfo(String orderNum) {
        bxdSunshineApplicantMapper.delete(new BxdSunshineApplicant(orderNum));
        bxdSunshineBeneficiaryListMapper.delete(new BxdSunshineBeneficiaryList(orderNum));
        bxdSunshineUserInfoMapper.delete(new BxdSunshineUserInfo(orderNum));
        bxdSunshinePolicyInfoListMapper.delete(new BxdSunshinePolicyInfoList(orderNum));
        bxdSunshineInsurantListMapper.delete(new BxdSunshineInsurantList(orderNum));
        bxdSunshinePaymentInfoMapper.delete(new BxdSunshinePaymentInfo(orderNum));
        bxdSunshineSaleInfoMapper.delete(new BxdSunshineSaleInfo(orderNum));
        bxdSunshineDutyListMapper.delete(new BxdSunshineDutyList(orderNum));
        bxdSunshinePayRecordListMapper.delete(new BxdSunshinePayRecordList(orderNum));
    }

    @Override
    public ResponseResult getSunInfo(String orderNum) {
        try {


            Map<String, Object> dataMap = new HashMap<>();
            List<Map<String, Object>> warranty_main_info = new ArrayList<>();
            List<Map<String, Object>> applicant_info = new ArrayList<>();
            List<Map<String, Object>> warranty_add_info = new ArrayList<>();
            List<Map<String, Object>> warranty_people_info = new ArrayList<>();

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
                    marital_status = bxdSunshineUserInfo.getMaritalStatus() == null ? "" : bxdSunshineUserInfo.getMaritalStatus();
                    name = bxdSunshineUserInfo.getUsername() == null ? "" : bxdSunshineUserInfo.getUsername();
                }
            }
            //投保人信息
            List<BxdSunshineApplicant> applicantLists = bxdSunshineApplicantMapper.select(new BxdSunshineApplicant(orderNum));
            if (applicantLists.size() > 0) {
                for (BxdSunshineApplicant bxdSunshineApplicant : applicantLists) {
                    Map<String, Object> bxdApplicantMap = new HashMap<>();
                    bxdApplicantMap.put("name", bxdSunshineApplicant.getName() == null ? "" : bxdSunshineApplicant.getName().toString());
                    bxdApplicantMap.put("id_card_type", bxdSunshineApplicant.getIdCardType() == null ? "" : bxdSunshineApplicant.getIdCardType());
                    bxdApplicantMap.put("id_card_no", bxdSunshineApplicant.getIdCardNo() == null ? "" : bxdSunshineApplicant.getIdCardNo());
                    bxdApplicantMap.put("phone_no", bxdSunshineApplicant.getPhoneNo() == null ? "" : bxdSunshineApplicant.getPhoneNo());
                    bxdApplicantMap.put("profession", profession);
                    bxdApplicantMap.put("city", city);
                    bxdApplicantMap.put("marital_status", marital_status);
                    bxdApplicantMap.put("address", bxdSunshineApplicant.getAddress() == null ? "" : bxdSunshineApplicant.getAddress());
                    bxdApplicantMap.put("company", bxdSunshineApplicant.getCompany() == null ? "" : bxdSunshineApplicant.getCompany());
                    bxdApplicantMap.put("company_address", bxdSunshineApplicant.getCompanyAddress() == null ? "" : bxdSunshineApplicant.getCompanyAddress());
                    bxdApplicantMap.put("applicant_email", bxdSunshineApplicant.getEmail() == null ? "" : bxdSunshineApplicant.getEmail());
                    applicant_info.add(bxdApplicantMap);
                }
            }


            //主险信息
            //拿到policyInfoList的相关信息
            List<BxdSunshinePolicyInfoList> bxdBases = bxdSunshinePolicyInfoListMapper.select(new BxdSunshinePolicyInfoList(orderNum));
            if (bxdBases.size() > 0) {

                String wj1 = "";
                if (bxdBases.size() > 0) {
                    for (BxdSunshinePolicyInfoList bxdSunshinePolicyInfoList : bxdBases) {
                        //拿到paymentInfo的外键
                        wj1 = bxdSunshinePolicyInfoList.getListId() == null ? "" : bxdSunshinePolicyInfoList.getListId();
                        //查询所有的paymentInfo信息
                        List<BxdSunshinePaymentInfo> paymentInfos = bxdSunshinePaymentInfoMapper.select(new BxdSunshinePaymentInfo(wj1));
                        if (paymentInfos.size() > 0) {
                            String wj2 = "";
                            for (BxdSunshinePaymentInfo bxdSunshinePaymentInfo : paymentInfos) {
                                //拿到payRecordList的外键
                                wj2 = bxdSunshinePaymentInfo.getPayRecordListId() == null ? "" : bxdSunshinePaymentInfo.getPayRecordListId();
                                //查询所有的payRecordList信息
                                List<BxdSunshinePayRecordList> recordLists = bxdSunshinePayRecordListMapper.select(new BxdSunshinePayRecordList(wj2));
                                if (recordLists.size() > 0) {
                                    for (BxdSunshinePayRecordList bxdSunshinePayRecordList : recordLists) {
                                        Map<String, Object> detailMap = new HashMap<>();
                                        //拼接数据并进行封装
                                        detailMap.put("policy_no", bxdSunshinePolicyInfoList.getPolicyNo() == null ? "" : bxdSunshinePolicyInfoList.getPolicyNo());
                                        detailMap.put("company", bxdSunshinePolicyInfoList.getCompany() == null ? "" : bxdSunshinePolicyInfoList.getCompany());
                                        detailMap.put("main_insurance", bxdSunshinePolicyInfoList.getMainInsurance() == null ? "" : bxdSunshinePolicyInfoList.getMainInsurance());
                                        detailMap.put("type", bxdSunshinePolicyInfoList.getType() == null ? "" : bxdSunshinePolicyInfoList.getType());
                                        detailMap.put("quantity", bxdSunshinePolicyInfoList.getQuantity() == null ? "" : bxdSunshinePolicyInfoList.getQuantity());
                                        detailMap.put("ensure_amount", bxdSunshinePolicyInfoList.getAmount() == null ? "" : bxdSunshinePolicyInfoList.getAmount());
                                        detailMap.put("start_date", bxdSunshinePolicyInfoList.getStartDate() == null ? "" : bxdSunshinePolicyInfoList.getStartDate());
                                        detailMap.put("end_date", bxdSunshinePolicyInfoList.getEndDate() == null ? "" : bxdSunshinePolicyInfoList.getEndDate());
                                        detailMap.put("status", bxdSunshinePolicyInfoList.getStatus() == null ? "" : bxdSunshinePolicyInfoList.getStatus());


                                        detailMap.put("paid_count", bxdSunshinePaymentInfo.getPaidCount() == null ? "" : bxdSunshinePaymentInfo.getPaidCount());
                                        detailMap.put("pay_model", bxdSunshinePaymentInfo.getPayModel() == null ? "" : bxdSunshinePaymentInfo.getPayModel());
                                        detailMap.put("current_pay_due_date", bxdSunshinePaymentInfo.getCurrentPayDueDate() == null ? "" : bxdSunshinePaymentInfo.getCurrentPayDueDate());
                                        detailMap.put("date_payable", bxdSunshinePaymentInfo.getDatePayable() == null ? "" : bxdSunshinePaymentInfo.getDatePayable());
                                        detailMap.put("pay_status", bxdSunshinePaymentInfo.getStatus() == null ? "" : bxdSunshinePaymentInfo.getStatus());
                                        detailMap.put("next_pay_date", bxdSunshinePaymentInfo.getNextPayDate() == null ? "" : bxdSunshinePaymentInfo.getNextPayDate());
                                        detailMap.put("next_pay_amount", bxdSunshinePaymentInfo.getNextPayAmount() == null ? "" : bxdSunshinePaymentInfo.getNextPayAmount());

                                        detailMap.put("amount", bxdSunshinePaymentInfo.getPeriodAmount() == null ? "" : bxdSunshinePaymentInfo.getPeriodAmount());
                                        detailMap.put("date", bxdSunshinePayRecordList.getDate() == null ? "" : bxdSunshinePayRecordList.getDate());

                                        warranty_main_info.add(detailMap);
                                    }
                                } else {
                                    Map<String, Object> detailMap = new HashMap<>();
                                    //拼接数据并进行封装
                                    detailMap.put("policy_no", bxdSunshinePolicyInfoList.getPolicyNo() == null ? "" : bxdSunshinePolicyInfoList.getPolicyNo());
                                    detailMap.put("company", bxdSunshinePolicyInfoList.getCompany() == null ? "" : bxdSunshinePolicyInfoList.getCompany());
                                    detailMap.put("main_insurance", bxdSunshinePolicyInfoList.getMainInsurance() == null ? "" : bxdSunshinePolicyInfoList.getMainInsurance());
                                    detailMap.put("type", bxdSunshinePolicyInfoList.getType() == null ? "" : bxdSunshinePolicyInfoList.getType());
                                    detailMap.put("quantity", bxdSunshinePolicyInfoList.getQuantity() == null ? "" : bxdSunshinePolicyInfoList.getQuantity());
                                    detailMap.put("ensure_amount", bxdSunshinePolicyInfoList.getAmount() == null ? "" : bxdSunshinePolicyInfoList.getAmount());
                                    detailMap.put("start_date", bxdSunshinePolicyInfoList.getStartDate() == null ? "" : bxdSunshinePolicyInfoList.getStartDate());
                                    detailMap.put("end_date", bxdSunshinePolicyInfoList.getEndDate() == null ? "" : bxdSunshinePolicyInfoList.getEndDate());
                                    detailMap.put("status", bxdSunshinePolicyInfoList.getStatus() == null ? "" : bxdSunshinePolicyInfoList.getStatus());
                                    detailMap.put("period", bxdSunshinePolicyInfoList.getPeriod() == null ? "" : bxdSunshinePolicyInfoList.getPeriod());

                                    detailMap.put("paid_count", bxdSunshinePaymentInfo.getPaidCount() == null ? "" : bxdSunshinePaymentInfo.getPaidCount());
                                    detailMap.put("pay_model", bxdSunshinePaymentInfo.getPayModel() == null ? "" : bxdSunshinePaymentInfo.getPayModel());
                                    detailMap.put("current_pay_due_date", bxdSunshinePaymentInfo.getCurrentPayDueDate() == null ? "" : bxdSunshinePaymentInfo.getCurrentPayDueDate());
                                    detailMap.put("date_payable", bxdSunshinePaymentInfo.getDatePayable() == null ? "" : bxdSunshinePaymentInfo.getDatePayable());
                                    detailMap.put("pay_status", bxdSunshinePaymentInfo.getStatus() == null ? "" : bxdSunshinePaymentInfo.getStatus());
                                    detailMap.put("next_pay_date", bxdSunshinePaymentInfo.getNextPayDate() == null ? "" : bxdSunshinePaymentInfo.getNextPayDate());
                                    detailMap.put("next_pay_amount", bxdSunshinePaymentInfo.getNextPayAmount() == null ? "" : bxdSunshinePaymentInfo.getNextPayAmount());

                                    detailMap.put("amount", bxdSunshinePaymentInfo.getPeriodAmount() == null ? "" : bxdSunshinePaymentInfo.getPeriodAmount());
                                    warranty_main_info.add(detailMap);
                                }


                            }
                        } else {
                            Map<String, Object> detailMap = new HashMap<>();
                            //拼接数据并进行封装
                            detailMap.put("policy_no", bxdSunshinePolicyInfoList.getPolicyNo() == null ? "" : bxdSunshinePolicyInfoList.getPolicyNo());
                            detailMap.put("company", bxdSunshinePolicyInfoList.getCompany() == null ? "" : bxdSunshinePolicyInfoList.getCompany());
                            detailMap.put("main_insurance", bxdSunshinePolicyInfoList.getMainInsurance() == null ? "" : bxdSunshinePolicyInfoList.getMainInsurance());
                            detailMap.put("type", bxdSunshinePolicyInfoList.getType() == null ? "" : bxdSunshinePolicyInfoList.getType());
                            detailMap.put("quantity", bxdSunshinePolicyInfoList.getQuantity() == null ? "" : bxdSunshinePolicyInfoList.getQuantity());
                            detailMap.put("ensure_amount", bxdSunshinePolicyInfoList.getAmount() == null ? "" : bxdSunshinePolicyInfoList.getAmount());
                            detailMap.put("start_date", bxdSunshinePolicyInfoList.getStartDate() == null ? "" : bxdSunshinePolicyInfoList.getStartDate());
                            detailMap.put("end_date", bxdSunshinePolicyInfoList.getEndDate() == null ? "" : bxdSunshinePolicyInfoList.getEndDate());
                            detailMap.put("status", bxdSunshinePolicyInfoList.getStatus() == null ? "" : bxdSunshinePolicyInfoList.getStatus());
                            detailMap.put("period", bxdSunshinePolicyInfoList.getPeriod() == null ? "" : bxdSunshinePolicyInfoList.getPeriod());
                            detailMap.put("amount", bxdSunshinePolicyInfoList.getAmount() == null ? "" : bxdSunshinePolicyInfoList.getAmount());
                            warranty_main_info.add(detailMap);
                        }

                        //附加险
                        List<BxdSunshineDutyList> dutyLists = bxdSunshineDutyListMapper.select(new BxdSunshineDutyList(wj1));
                        if (dutyLists.size() > 0) {

                            for (BxdSunshineDutyList bxdSunshineDutyList : dutyLists) {
                                Map<String, Object> detailMap = new HashMap<>();
                                detailMap.put("policy_no", bxdSunshinePolicyInfoList.getPolicyNo() == null ? "" : bxdSunshinePolicyInfoList.getPolicyNo());
                                detailMap.put("company", bxdSunshinePolicyInfoList.getCompany() == null ? "" : bxdSunshinePolicyInfoList.getCompany());
                                detailMap.put("name", bxdSunshineDutyList.getName() == null ? "" : bxdSunshineDutyList.getName());
                                detailMap.put("quantity", bxdSunshineDutyList.getQuantity() == null ? "" : bxdSunshineDutyList.getQuantity());
                                detailMap.put("ensure_amount", bxdSunshineDutyList.getAmount() == null ? "" : bxdSunshineDutyList.getAmount());
                                detailMap.put("premium", bxdSunshineDutyList.getPremium() == null ? "" : bxdSunshineDutyList.getPremium());
                                detailMap.put("start_date", bxdSunshineDutyList.getStartDate() == null ? "" : bxdSunshineDutyList.getStartDate());
                                detailMap.put("end_date", bxdSunshineDutyList.getEndDate() == null ? "" : bxdSunshineDutyList.getEndDate());
                                detailMap.put("status", bxdSunshineDutyList.getStatus() == null ? "" : bxdSunshineDutyList.getStatus());
                                detailMap.put("period", bxdSunshineDutyList.getPeriod() == null ? "" : bxdSunshineDutyList.getPeriod());

                                detailMap.put("pay_type", bxdSunshineDutyList.getPayType() == null ? "" : bxdSunshineDutyList.getPayType());
                                detailMap.put("pay_due_date", bxdSunshineDutyList.getPayDueDate() == null ? "" : bxdSunshineDutyList.getPayDueDate());
                                detailMap.put("payment_date", bxdSunshineDutyList.getPaymentDate() == null ? "" : bxdSunshineDutyList.getPaymentDate());

                                detailMap.put("total_premium", bxdSunshineDutyList.getTotalPremium() == null ? "" : bxdSunshineDutyList.getTotalPremium());
                                detailMap.put("next_pay_date", bxdSunshineDutyList.getNextPayDate() == null ? "" : bxdSunshineDutyList.getNextPayDate());
                                detailMap.put("next_pay_amount", bxdSunshineDutyList.getNextPayAmount() == null ? "" : bxdSunshineDutyList.getNextPayAmount());

                                warranty_add_info.add(detailMap);
                            }

                        }

                        List<BxdSunshineInsurantList> insurantLists = bxdSunshineInsurantListMapper.select(new BxdSunshineInsurantList(wj1));
                        List<BxdSunshineBeneficiaryList> beneficiaryLists = bxdSunshineBeneficiaryListMapper.select(new BxdSunshineBeneficiaryList(wj1));
                        if (insurantLists.size() > 0) {
                            for (BxdSunshineInsurantList bxdSunshineInsurantList : insurantLists) {
                                //当两个都有值时
                                if (beneficiaryLists.size() > 0) {
                                    for (BxdSunshineBeneficiaryList bxdSunshineBeneficiaryList : beneficiaryLists) {
                                        Map<String, Object> detailMap = new HashMap<>();
                                        detailMap.put("id_card_no", bxdSunshineInsurantList.getIdCardNo() == null ? "" : bxdSunshineInsurantList.getIdCardNo());
                                        detailMap.put("name", bxdSunshineInsurantList.getName() == null ? "" : bxdSunshineInsurantList.getName());
                                        detailMap.put("relation_one", bxdSunshineInsurantList.getRelation() == null ? "" : bxdSunshineInsurantList.getRelation());
                                        detailMap.put("profit_name", bxdSunshineBeneficiaryList.getName() == null ? "" : bxdSunshineBeneficiaryList.getName());
                                        detailMap.put("relation_two", bxdSunshineBeneficiaryList.getRelation() == null ? "" : bxdSunshineBeneficiaryList.getRelation());
                                        warranty_people_info.add(detailMap);
                                    }
                                } else {
                                    //当只有一个都有值时
                                    Map<String, Object> detailMap = new HashMap<>();
                                    detailMap.put("id_card_no", bxdSunshineInsurantList.getIdCardNo() == null ? "" : bxdSunshineInsurantList.getIdCardNo());
                                    detailMap.put("name", bxdSunshineInsurantList.getName() == null ? "" : bxdSunshineInsurantList.getName());
                                    detailMap.put("relation_one", bxdSunshineInsurantList.getRelation() == null ? "" : bxdSunshineInsurantList.getRelation());
                                    warranty_people_info.add(detailMap);
                                }
                            }
                        }

                    }
                }
            }

            dataMap.put("warranty_type", 2);
            dataMap.put("applicant_info", applicant_info);
            dataMap.put("warranty_main_info", warranty_main_info);
            dataMap.put("warranty_add_info", warranty_add_info);
            dataMap.put("warranty_people_info", warranty_people_info);
            return ResponseResult.ok(dataMap);
        } catch (Exception e) {
            log.info("getSunInfo error message" + e.getLocalizedMessage());
            return null;
        }

    }

}
