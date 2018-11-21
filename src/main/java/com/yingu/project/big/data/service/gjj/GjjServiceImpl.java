package com.yingu.project.big.data.service.gjj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yingu.project.big.data.common.ResponseCode;
import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.persistence.entity.gjj.*;
import com.yingu.project.big.data.persistence.entity.pc.PcCustomerBaseInfo;
import com.yingu.project.big.data.persistence.entity.pc.PcCustomerWorkInfo;
import com.yingu.project.big.data.persistence.mapper.gjj.*;
import com.yingu.project.big.data.persistence.mapper.pc.PcCustomerBaseInfoMapper;
import com.yingu.project.big.data.persistence.mapper.pc.PcCustomerWorkInfoMapper;
import com.yingu.project.big.data.util.SubStringUUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author huangkunhao
 * @date 2018/11/21
 * @Description
 */
@Slf4j
@Service
public class GjjServiceImpl implements GjjService{

    @Autowired
    GjjBaseInfoMapper gjjBaseInfoMapper;
    @Autowired
    GjjDetialsMapper gjjDetialsMapper;
    @Autowired
    GjjLoanInfoMapper gjjLoanInfoMapper;
    @Autowired
    GjjPaymentDetailsMapper gjjPaymentDetailsMapper;
    @Autowired
    GjjOverdueDetailsMapper gjjOverdueDetailsMapper;
    @Autowired
    PcCustomerWorkInfoMapper pcCustomerWorkInfoMapper;
    @Autowired
    PcCustomerBaseInfoMapper pcCustomerBaseInfoMapper;

    @Override
    public boolean saveInfo(String orderNum, String dataString) {
        try {
            JSONObject dataStringAllInfo = JSONObject.parseObject(dataString);

            log.info("公积金所有json数据 :{}" , dataStringAllInfo.toJSONString());

            String statusCode = dataStringAllInfo.get("rspCode") == null ? "" : dataStringAllInfo.getString("rspCode");
            //当状态码为200时
            if (statusCode != null && statusCode.equals("200")) {
                //先删掉原有的
                this.delete(orderNum);

                JSONObject dataAllInfo = JSONObject.parseObject(dataStringAllInfo.getString("data"));
                //当data不为空时
                if (dataAllInfo != null || dataAllInfo.size() > 0) {
                    JSONArray transactions = dataAllInfo.get("transactions") == null ? new JSONArray() : dataAllInfo.getJSONArray("transactions");
                    if (transactions.size() > 0 || transactions != null) {
                        String wj1 = "";
                        String wj2 = "";
                        //遍历transactions数组中的每个对象
                        for (Object o : transactions) {
                            wj1 = SubStringUUID.subUUID();
                            wj2 = SubStringUUID.subUUID();
                            Map<String, Object> map = (Map<String, Object>) o;
                            GjjBaseInfo gjjBaseInfo = new GjjBaseInfo();
                            gjjBaseInfo.setOpenDate(map.get("open_date") == null ? "" : map.get("open_date").toString());
                            gjjBaseInfo.setCompanyCode(map.get("company_code") == null ? "" : map.get("company_code").toString());
                            gjjBaseInfo.setTransferAmount(map.get("transfer_amount") == null ? "" : map.get("transfer_amount").toString());
                            gjjBaseInfo.setOpenBankAccount(map.get("open_bank_account") == null ? "" : map.get("open_bank_account").toString());
                            gjjBaseInfo.setEmployeeCode(map.get("employee_code") == null ? "" : map.get("employee_code").toString());
                            gjjBaseInfo.setIdCard(map.get("id_card") == null ? "" : map.get("id_card").toString());
                            gjjBaseInfo.setPayBaseAmount(map.get("pay_base_amount") == null ? "" : map.get("pay_base_amount").toString());
                            gjjBaseInfo.setVersion(map.get("version") == null ? "" : map.get("version").toString());
                            gjjBaseInfo.setFundAmt(map.get("fund_amt") == null ? "" : map.get("fund_amt").toString());
                            gjjBaseInfo.setDepositRatioPersonal(map.get("deposit_ratio_personal") == null ? "" : map.get("deposit_ratio_personal").toString());
                            gjjBaseInfo.setHousingFundStatus(map.get("housing_fund_status") == null ? "" : map.get("housing_fund_status").toString());
                            gjjBaseInfo.setUpdateTime(map.get("update_time") == null ? "" : map.get("update_time").toString());
                            gjjBaseInfo.setOpenBankName(map.get("open_bank_name") == null ? "" : map.get("open_bank_name").toString());
                            gjjBaseInfo.setCompany(map.get("company") == null ? "" : map.get("company").toString());
                            gjjBaseInfo.setDepositRatioCompany(map.get("deposit_ratio_company") == null ? "" : map.get("deposit_ratio_company").toString());
                            gjjBaseInfo.setLastFundDate(map.get("last_fund_date") == null ? "" : map.get("last_fund_date").toString());
                            gjjBaseInfo.setDataSource(map.get("data_source") == null ? "" : map.get("data_source").toString());
                            gjjBaseInfo.setRealName(map.get("real_name") == null ? "" : map.get("real_name").toString());
                            gjjBaseInfo.setToken(map.get("token") == null ? "" : map.get("token").toString());
                            gjjBaseInfo.setFundNum(map.get("fund_num") == null ? "" : map.get("fund_num").toString());
                            gjjBaseInfo.setBalance(map.get("balance") == null ? "" : map.get("balance").toString());

                            gjjBaseInfo.setLoanInfoId(wj1);
                            gjjBaseInfo.setDetailsId(wj1);

                            gjjBaseInfo.setUuid(SubStringUUID.subUUID());
                            gjjBaseInfo.setOrderNum(orderNum);
                            gjjBaseInfo.setCreateTime(new Date());
                            gjjBaseInfoMapper.insertSelective(gjjBaseInfo);

                            //第一个json数组缴费记录
                            JSONArray detailsJsonArray = map.get("details") == null ? new JSONArray() : (JSONArray) map.get("details");
                            if (detailsJsonArray.size() > 0) {
                                for (Object o1 : detailsJsonArray) {
                                    Map<String, Object> map1 = (Map<String, Object>) o1;
                                    GjjDetials gjjDetials = new GjjDetials();
                                    gjjDetials.setNote(map1.get("note") == null ? "" : map1.get("note").toString());
                                    gjjDetials.setBalance(map1.get("balance") == null ? "" : map1.get("balance").toString());
                                    gjjDetials.setTransferAmount(map1.get("transfer_amount") == null ? "" : map1.get("transfer_amount").toString());
                                    gjjDetials.setTradingDate(map1.get("trading_date") == null ? "" : map1.get("trading_date").toString());
                                    gjjDetials.setTradingAmt(map1.get("trading_amt") == null ? "" : map1.get("trading_amt").toString());

                                    gjjDetials.setDetialsId(wj1);

                                    gjjDetials.setUuid(SubStringUUID.subUUID());
                                    gjjDetials.setOrderNum(orderNum);
                                    gjjDetials.setCreateTime(new Date());
                                    gjjDetialsMapper.insertSelective(gjjDetials);
                                }
                            }

                            JSONArray loanInfoJsonArray = map.get("loan_info") == null ? new JSONArray() : (JSONArray) map.get("loan_info");
                            if (loanInfoJsonArray.size() > 0) {
                                for (Object o1 : loanInfoJsonArray) {
                                    Map<String, Object> map1 = (Map<String, Object>) o1;
                                    GjjLoanInfo gjjLoanInfo = new GjjLoanInfo();
                                    gjjLoanInfo.setLoanName(map1.get("loan_name") == null ? "" : map1.get("loan_name").toString());
                                    gjjLoanInfo.setLoanIdcard(map1.get("loan_idcard") == null ? "" : map1.get("loan_idcard").toString());
                                    gjjLoanInfo.setCompanyName(map1.get("company_name") == null ? "" : map1.get("company_name").toString());
                                    gjjLoanInfo.setBankName(map1.get("bank_name") == null ? "" : map1.get("bank_name").toString());
                                    gjjLoanInfo.setBankAccount(map1.get("bank_account") == null ? "" : map1.get("bank_account").toString());
                                    gjjLoanInfo.setLoanNum(map1.get("loan_num") == null ? "" : map1.get("loan_num").toString());
                                    gjjLoanInfo.setLoanAmount(map1.get("loan_amount") == null ? "" : map1.get("loan_amount").toString());
                                    gjjLoanInfo.setLoanLength(map1.get("loan_length") == null ? "" : map1.get("loan_length").toString());
                                    gjjLoanInfo.setLoanRate(map1.get("loan_rate") == null ? "" : map1.get("loan_rate").toString());
                                    gjjLoanInfo.setLoanStatus(map1.get("loan_status") == null ? "" : map1.get("loan_status").toString());
                                    gjjLoanInfo.setLoanDate(map1.get("loan_date") == null ? "" : map1.get("loan_date").toString());
                                    gjjLoanInfo.setHouseType(map1.get("house_type") == null ? "" : map1.get("house_type").toString());
                                    gjjLoanInfo.setGuaranteeType(map1.get("guarantee_type") == null ? "" : map1.get("guarantee_type").toString());
                                    gjjLoanInfo.setPaymentType(map1.get("payment_type") == null ? "" : map1.get("payment_type").toString());
                                    gjjLoanInfo.setPaymentDay(map1.get("payment_day") == null ? "" : map1.get("payment_day").toString());
                                    gjjLoanInfo.setPaymentAmount(map1.get("payment_amount") == null ? "" : map1.get("payment_amount").toString());
                                    gjjLoanInfo.setDuePrincipal(map1.get("due_principal") == null ? "" : map1.get("due_principal").toString());
                                    gjjLoanInfo.setOverdueTimes(map1.get("overdue_times") == null ? "" : map1.get("overdue_times").toString());
                                    gjjLoanInfo.setOverdueAmount(map1.get("overdue_amount") == null ? "" : map1.get("overdue_amount").toString());

                                    gjjLoanInfo.setLoanInfoId(wj1);
                                    gjjLoanInfo.setPaymentDetailsId(wj2);
                                    gjjLoanInfo.setOverdueDetailsId(wj2);

                                    gjjLoanInfo.setUuid(SubStringUUID.subUUID());
                                    gjjLoanInfo.setCreateTime(new Date());
                                    gjjLoanInfo.setOrderNum(orderNum);

                                    gjjLoanInfoMapper.insertSelective(gjjLoanInfo);


                                    JSONArray patmentDetailsJsonArray = map1.get("payment_details") == null ? new JSONArray() : (JSONArray) map1.get("payment_details");
                                    if (patmentDetailsJsonArray.size() > 0) {
                                        for (Object o11 : patmentDetailsJsonArray) {
                                            Map<String, Object> map11 = (Map<String, Object>) o11;
                                            GjjPaymentDetails gjjPaymentDetails = new GjjPaymentDetails();
                                            gjjPaymentDetails.setPaymentDate(map11.get("payment_date") == null ? "" : map11.get("payment_date").toString());
                                            gjjPaymentDetails.setPaymentNum(map11.get("payment_num") == null ? "" : map11.get("payment_num").toString());
                                            gjjPaymentDetails.setPaymentPrincipal(map11.get("payment_principal") == null ? "" : map11.get("payment_principal").toString());
                                            gjjPaymentDetails.setPaymentInterest(map11.get("payment_interest") == null ? "" : map11.get("payment_interest").toString());
                                            gjjPaymentDetails.setPaymentPenalty(map11.get("payment_penalty") == null ? "" : map11.get("payment_penalty").toString());
                                            gjjPaymentDetails.setPaymentSum(map11.get("payment_sum") == null ? "" : map11.get("payment_sum").toString());
                                            gjjPaymentDetails.setPrinBalance(map11.get("prin_balance") == null ? "" : map11.get("prin_balance").toString());
                                            gjjPaymentDetails.setPaymentDescribe(map11.get("payment_describe") == null ? "" : map11.get("payment_describe").toString());

                                            gjjPaymentDetails.setPaymentDetailsId(wj2);

                                            gjjPaymentDetails.setUuid(SubStringUUID.subUUID());
                                            gjjPaymentDetails.setCreateTime(new Date());
                                            gjjPaymentDetails.setOrderNum(orderNum);

                                            gjjPaymentDetailsMapper.insertSelective(gjjPaymentDetails);

                                        }
                                    }


                                    JSONArray overdueDetailsJsonArray = map1.get("overdue_details") == null ? new JSONArray() : (JSONArray) map1.get("overdue_details");
                                    if (overdueDetailsJsonArray.size() > 0) {
                                        for (Object o11 : overdueDetailsJsonArray) {
                                            Map<String, Object> map11 = (Map<String, Object>) o11;
                                            GjjOverdueDetails gjjOverdueDetails = new GjjOverdueDetails();
                                            gjjOverdueDetails.setOverdueDate(map11.get("overdue_date") == null ? "" : map11.get("overdue_date").toString());
                                            gjjOverdueDetails.setOverduePrincipal(map11.get("overdue_principal") == null ? "" : map11.get("overdue_principal").toString());
                                            gjjOverdueDetails.setOverdueInterest(map11.get("overdue_interest") == null ? "" : map11.get("overdue_interest").toString());
                                            gjjOverdueDetails.setOverduePenalty(map11.get("overdue_penalty") == null ? "" : map11.get("overdue_penalty").toString());
                                            gjjOverdueDetails.setOverdueSummary(map11.get("overdue_summary ") == null ? "" : map11.get("overdue_summary ").toString());

                                            gjjOverdueDetails.setOverdueDetailsId(wj2);

                                            gjjOverdueDetails.setUuid(SubStringUUID.subUUID());
                                            gjjOverdueDetails.setCreateTime(new Date());
                                            gjjOverdueDetails.setOrderNum(orderNum);

                                            gjjOverdueDetailsMapper.insertSelective(gjjOverdueDetails);
                                        }
                                    }
                                }
                            }


                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("公积金接口异常 :  " + e.getLocalizedMessage());
            return false;
        }


        return true;
    }

    @Override
    public ResponseResult getGJJInfo(String orderNum) {
        List<Map<String, Object>> gjjBaseInfoList = new ArrayList<>();
        List<Map<String, Object>> detialList = new ArrayList<>();
        List<Map<String, Object>> loanInfoList = new ArrayList<>();
        List<Map<String, Object>> paymentDetails = new ArrayList<>();
        List<Map<String, Object>> gjjOverdueList = new ArrayList<>();
        Map<String, Object> base_info = new HashMap<>();

        try {
            List<GjjBaseInfo> gjjBase = gjjBaseInfoMapper.select(new GjjBaseInfo(orderNum));

            if (gjjBase.size() == 0 || gjjBase == null) {
                return new ResponseResult(ResponseCode.GJJDATANOTUSER.getCode(), ResponseCode.GJJDATANOTUSER.getDescription());
            }
            List<GjjBaseInfo> gjjBaseInfos = gjjBaseInfoMapper.select(new GjjBaseInfo(orderNum));
            if (gjjBaseInfos.size() > 0 || gjjBaseInfos != null) {
                for (GjjBaseInfo gjjBaseInfo : gjjBaseInfos) {

                    Map<String, Object> map = new HashMap<>();
                    map.put("housing_fund_status", gjjBaseInfo.getHousingFundStatus() == null ? "" : gjjBaseInfo.getHousingFundStatus());

                    map.put("company", gjjBaseInfo.getCompany() == null ? "" : gjjBaseInfo.getCompany());
                    map.put("id_card", gjjBaseInfo.getIdCard() == null ? "" : gjjBaseInfo.getIdCard());
                    map.put("real_name", gjjBaseInfo.getRealName() == null ? "" : gjjBaseInfo.getRealName());
                    map.put("fund_amt", gjjBaseInfo.getFundAmt() == null ? "" : gjjBaseInfo.getFundAmt());
                    map.put("fund_num", gjjBaseInfo.getFundNum() == null ? "" : gjjBaseInfo.getFundNum());
                    map.put("open_date", gjjBaseInfo.getOpenDate() == null ? "" : gjjBaseInfo.getOpenDate());
                    map.put("last_fund_date", gjjBaseInfo.getLastFundDate()== null ? "" : gjjBaseInfo.getLastFundDate().toString().replace(" 00:00:00",""));
                    map.put("balance", gjjBaseInfo.getBalance() == null ? "" : gjjBaseInfo.getBalance());
                    map.put("transfer_amount", gjjBaseInfo.getTransferAmount() == null ? "" : gjjBaseInfo.getTransferAmount());
                    map.put("deposit_ratio_personal", gjjBaseInfo.getDepositRatioPersonal() == null ? "" : gjjBaseInfo.getDepositRatioPersonal());
                    map.put("deposit_ratio_company", gjjBaseInfo.getDepositRatioCompany() == null ? "" : gjjBaseInfo.getDepositRatioCompany());
                    map.put("pay_base_amount", gjjBaseInfo.getPayBaseAmount() == null ? "" : gjjBaseInfo.getPayBaseAmount());
                    map.put("company_no", gjjBaseInfo.getCompanyCode() == null ? "" : gjjBaseInfo.getCompanyCode());
                    map.put("emp_no", gjjBaseInfo.getEmployeeCode() == null ? "" : gjjBaseInfo.getEmployeeCode());
                    map.put("bank_name", gjjBaseInfo.getOpenBankName() == null ? "" : gjjBaseInfo.getOpenBankName());
                    map.put("warning", false);
                    //需求一:出现欠缴、停缴、断交、封存、销户异常标记提示
                    if (StringUtils.isNotBlank(gjjBaseInfo.getHousingFundStatus())) {
                        if (gjjBaseInfo.getHousingFundStatus().contains("欠缴") || gjjBaseInfo.getHousingFundStatus().contains("停缴") || gjjBaseInfo.getHousingFundStatus().contains("断交") ||
                                gjjBaseInfo.getHousingFundStatus().contains("封存") || gjjBaseInfo.getHousingFundStatus().contains("销户")) {
                            map.put("warning", true);
                        }
                    }

                    //需求二:预留单位匹配不一致异常标记提示
                    List<PcCustomerWorkInfo> pcCustomerWorkInfoList = pcCustomerWorkInfoMapper.select(new PcCustomerWorkInfo(orderNum));
                    if (pcCustomerWorkInfoList.size() > 0) {
                        for (PcCustomerWorkInfo pcCustomerWorkInfo : pcCustomerWorkInfoList) {
                            if (StringUtils.isNotBlank(gjjBaseInfo.getCompany()) && StringUtils.isNotBlank(pcCustomerWorkInfo.getOrgName())) {
                                if (!gjjBaseInfo.getCompany().equals(pcCustomerWorkInfo.getOrgName())) {
                                    map.put("warning", true);
                                }
                            }

                        }
                    }

                    //需求三 and 四 : 身份证号 和 姓名 匹配不一致异常标记提示
                    List<PcCustomerBaseInfo> pcCustomerBaseInfoList = pcCustomerBaseInfoMapper.select(new PcCustomerBaseInfo(orderNum));
                    if (pcCustomerBaseInfoList.size() > 0) {
                        for (PcCustomerBaseInfo pcCustomerBaseInfo : pcCustomerBaseInfoList) {
                            if (StringUtils.isNotBlank(pcCustomerBaseInfo.getIdNum()) && StringUtils.isNotBlank(gjjBaseInfo.getIdCard())) {
                                if (!pcCustomerBaseInfo.getIdNum().equals(gjjBaseInfo.getIdCard())) {
                                    map.put("warning", true);
                                }
                            }
                            if (StringUtils.isNotBlank(gjjBaseInfo.getRealName()) && StringUtils.isNotBlank(pcCustomerBaseInfo.getCustomName())) {
                                if (!gjjBaseInfo.getRealName().equals(pcCustomerBaseInfo.getCustomName())) {
                                    map.put("warning", true);
                                }
                            }
                        }
                    }


                    gjjBaseInfoList.add(map);

                    //根据外键拿集合外键
                    String i = gjjBaseInfo.getDetailsId();
                    List<GjjDetials> detialsList = gjjDetialsMapper.orderBy(gjjBaseInfo.getDetailsId());
                    if (detialsList.size() > 0 || detialsList != null) {
                        for (GjjDetials gjjDetials : detialsList) {
                            Map<String, Object> detailsMap = new HashMap<>();
                            detailsMap.put("trading_amt", gjjDetials.getTradingAmt() == null ? "" : gjjDetials.getTradingAmt());
                            detailsMap.put("trading_date", gjjDetials.getTradingDate() == null ? "" : gjjDetials.getTradingDate());
                            detailsMap.put("transfer_amount", gjjDetials.getTransferAmount() == null ? "" : gjjDetials.getTransferAmount());
                            detailsMap.put("balance", gjjDetials.getBalance() == null ? "" : gjjDetials.getBalance());
                            detailsMap.put("note", gjjDetials.getNote() == null ? "" : gjjDetials.getNote());
                            detialList.add(detailsMap);
                        }
                    }

                    log.info("gjjBaseInfo.getLoanInfoId()" + gjjBaseInfo.getLoanInfoId());
                    List<GjjLoanInfo> loanInfos = gjjLoanInfoMapper.select(new GjjLoanInfo(gjjBaseInfo.getLoanInfoId()));
                    if (loanInfos.size() > 0 || loanInfos != null) {
                        for (GjjLoanInfo gjjLoanInfo : loanInfos) {
                            Map<String, Object> gjjLoanInfoMap = new HashMap<>();
                            gjjLoanInfoMap.put("bank_name", gjjLoanInfo.getBankName() == null ? "" : gjjLoanInfo.getBankName());
                            gjjLoanInfoMap.put("bank_account", gjjLoanInfo.getBankAccount() == null ? "" : gjjLoanInfo.getBankAccount());
                            gjjLoanInfoMap.put("loan_num", gjjLoanInfo.getLoanNum() == null ? "" : gjjLoanInfo.getLoanNum());
                            gjjLoanInfoMap.put("loan_amount", gjjLoanInfo.getLoanAmount() == null ? "" : gjjLoanInfo.getLoanAmount());
                            gjjLoanInfoMap.put("loan_length", gjjLoanInfo.getLoanLength() == null ? "" : gjjLoanInfo.getLoanLength());
                            gjjLoanInfoMap.put("loan_status", gjjLoanInfo.getLoanStatus() == null ? "" : gjjLoanInfo.getLoanStatus());
                            gjjLoanInfoMap.put("loan_date", gjjLoanInfo.getLoanDate() == null ? "" : gjjLoanInfo.getLoanDate());
                            gjjLoanInfoMap.put("house_type", gjjLoanInfo.getHouseType() == null ? "" : gjjLoanInfo.getHouseType());
                            gjjLoanInfoMap.put("payment_amount", gjjLoanInfo.getPaymentAmount() == null ? "" : gjjLoanInfo.getPaymentAmount());
                            gjjLoanInfoMap.put("due_principal", gjjLoanInfo.getDuePrincipal() == null ? "" : gjjLoanInfo.getDuePrincipal());
                            gjjLoanInfoMap.put("overdue_times", gjjLoanInfo.getOverdueTimes() == null ? "" : gjjLoanInfo.getOverdueTimes());
                            gjjLoanInfoMap.put("overdue_amount", gjjLoanInfo.getOverdueAmount() == null ? "" : gjjLoanInfo.getOverdueAmount());
                            gjjLoanInfoMap.put("payment_day", gjjLoanInfo.getPaymentDay() == null ? "" : gjjLoanInfo.getPaymentDay());
                            gjjLoanInfoMap.put("company_name", gjjLoanInfo.getCompanyName() == null ? "" : gjjLoanInfo.getCompanyName());
                            gjjLoanInfoMap.put("load_rate", gjjLoanInfo.getLoanRate() == null ? "" : gjjLoanInfo.getLoanRate());
                            gjjLoanInfoMap.put("warranty_way", gjjLoanInfo.getGuaranteeType() == null ? "" : gjjLoanInfo.getGuaranteeType());
                            loanInfoList.add(gjjLoanInfoMap);

                            List<GjjPaymentDetails> gjjLoanInfos = gjjPaymentDetailsMapper.select(new GjjPaymentDetails(gjjLoanInfo.getPaymentDetailsId()));
                            if (gjjLoanInfos.size() > 0) {
                                for (GjjPaymentDetails gjjPaymentDetails : gjjLoanInfos) {
                                    Map<String, Object> gjjPaymentDetailsMap = new HashMap<>();
                                    gjjPaymentDetailsMap.put("payment_num", gjjPaymentDetails.getPaymentNum() == null ? "" : gjjPaymentDetails.getPaymentNum());
                                    gjjPaymentDetailsMap.put("payment_principal", gjjPaymentDetails.getPaymentPrincipal() == null ? "" : gjjPaymentDetails.getPaymentPrincipal());
                                    gjjPaymentDetailsMap.put("payment_interest", gjjPaymentDetails.getPaymentInterest() == null ? "" : gjjPaymentDetails.getPaymentInterest());
                                    gjjPaymentDetailsMap.put("payment_penalty", gjjPaymentDetails.getPaymentPenalty() == null ? "" : gjjPaymentDetails.getPaymentPenalty());
                                    gjjPaymentDetailsMap.put("payment_sum", gjjPaymentDetails.getPaymentSum() == null ? "" : gjjPaymentDetails.getPaymentSum());
                                    gjjPaymentDetailsMap.put("prin_balance", gjjPaymentDetails.getPrinBalance() == null ? "" : gjjPaymentDetails.getPrinBalance());
                                    gjjPaymentDetailsMap.put("payment_describe", gjjPaymentDetails.getPaymentDescribe() == null ? "" : gjjPaymentDetails.getPaymentDescribe());
                                    gjjPaymentDetailsMap.put("payment_date", gjjPaymentDetails.getPaymentDate() == null ? "" : gjjPaymentDetails.getPaymentDate());
                                    paymentDetails.add(gjjPaymentDetailsMap);
                                }
                            }

                            List<GjjOverdueDetails> gjjOverdueDetailsList = gjjOverdueDetailsMapper.select(new GjjOverdueDetails(gjjLoanInfo.getOverdueDetailsId()));
                            if (gjjOverdueDetailsList.size() > 0) {
                                for (GjjOverdueDetails gjjOverdueDetails : gjjOverdueDetailsList) {
                                    Map<String, Object> gjjOverdueDetailsMap = new HashMap<>();
                                    gjjOverdueDetailsMap.put("overdue_principal", gjjOverdueDetails.getOverduePrincipal() == null ? "" : gjjOverdueDetails.getOverduePrincipal());
                                    gjjOverdueDetailsMap.put("overdue_interest", gjjOverdueDetails.getOverdueInterest() == null ? "" : gjjOverdueDetails.getOverdueInterest());
                                    gjjOverdueDetailsMap.put("overdue_penalty", gjjOverdueDetails.getOverduePenalty() == null ? "" : gjjOverdueDetails.getOverduePenalty());
                                    gjjOverdueDetailsMap.put("overdue_date", gjjOverdueDetails.getOverdueDate() == null ? "" : gjjOverdueDetails.getOverdueDate());
                                    gjjOverdueList.add(gjjOverdueDetailsMap);
                                }
                            }
                        }
                    }

                }
            }

        } catch (Exception e) {
            log.info("GjjgetInfo error mes:", e.fillInStackTrace());
        } finally {
            base_info.put("base_info", gjjBaseInfoList);
            base_info.put("payment_details", detialList);
            base_info.put("loan_info", loanInfoList);
            base_info.put("repayment_details", paymentDetails);
            base_info.put("overdue_details", gjjOverdueList);
        }
        return ResponseResult.ok(base_info);
    }

    public void delete(String orderNum){
        gjjBaseInfoMapper.delete(new GjjBaseInfo(orderNum));
        gjjDetialsMapper.delete(new GjjDetials(orderNum));
        gjjLoanInfoMapper.delete(new GjjLoanInfo(orderNum));
        gjjOverdueDetailsMapper.delete(new GjjOverdueDetails(orderNum));
        gjjPaymentDetailsMapper.delete(new GjjPaymentDetails(orderNum));
    }
}
