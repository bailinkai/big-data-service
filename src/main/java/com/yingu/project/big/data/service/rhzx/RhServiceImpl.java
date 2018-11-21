package com.yingu.project.big.data.service.rhzx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yingu.project.big.data.common.ResponseCode;
import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.persistence.entity.rhzx.*;
import com.yingu.project.big.data.persistence.mapper.rhzx.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author huangkunhao
 * @date 2018/11/21
 * @Description
 */
@Slf4j
@Service
public class RhServiceImpl implements RhService{

    @Autowired
    CreditCardRecordDetailAnalyzesMapper cardRecordDetailAnalyzesMapper;
    @Autowired
    CreditAdministrativePenaltyRecordsMapper administrativePenaltyRecordsMapper;
    @Autowired
    CreditBaseInfoMapper baseInfoMapper;
    @Autowired
    CreditFocusExecutionRecordsMapper focusExecutionRecordsMapper;
    @Autowired
    CreditGuaranteeRecordDetailAnalyzesMapper guaranteeRecordDetailAnalyzesMapper;
    @Autowired
    CreditHousingLoanRecordDetailAnalyzesMapper housingLoanRecordDetailAnalyzesMapper;
    @Autowired
    CreditOtherLoanRecordDetailAnalyzesMapper otherLoanRecordDetailAnalyzesMapper;
    @Autowired
    CreditOwedTelecomRecordsMapper owedTelecomRecordsMapper;
    @Autowired
    CreditQueryInfoDetailsMapper queryInfoDetailsMapper;
    @Autowired
    CreditRecordDetailsMapper recordDetailsMapper;
    @Autowired
    CreditRecordSummariesMapper recordSummariesMapper;
    @Autowired
    CreditTaxOwedRecordsMapper taxOwedRecordsMapper;

    @Override
    public boolean saveRhInfo(String orderNum, String result, String requestResult) {
        if (StringUtils.isBlank(result)) {
            return false;
        }
        try {
            Map map = JSONObject.parseObject(result, Map.class);
            if (Integer.parseInt(map.get("rspCode").toString()) == 200 && StringUtils.isNotBlank(map.get("data").toString())) {
                String data = JSON.toJSONString(map.get("data"));
                Map dataMap = JSONObject.parseObject(data, Map.class);

                //基本信息
                if (StringUtils.isNotBlank(dataMap.get("creditBaseInfo").toString())) {
                    Map<String, Object> baseInfoMap = JSONObject.parseObject(dataMap.get("creditBaseInfo").toString(), Map.class);
                    if (!addBaseInfo(orderNum, baseInfoMap)) {
                        log.info("保存基本信息失败" + baseInfoMap);
                    }
                }

                //行政处罚
                if (StringUtils.isNotBlank(dataMap.get("administrativePenaltyRecords").toString())) {
                    List<Object> list = JSONObject.parseArray(dataMap.get("administrativePenaltyRecords").toString(), Object.class);
                    if (!addAdministrativeSanction(orderNum, list)) {
                        log.info("保存行政处罚信息失败" + list);
                    }
                }

                //信贷
                if (StringUtils.isNotBlank(dataMap.get("creditRecordSummaries").toString())) {
                    System.out.println(JSON.toJSONString(dataMap.get("creditRecordSummaries")));
                    List<Object> list = JSONObject.parseArray(dataMap.get("creditRecordSummaries").toString(), Object.class);
                    if (!addRecordSummaries(orderNum, list)) {
                        log.info("保存信贷信息失败" + list);
                    }
                }

                //信贷记录详细信息
                if (StringUtils.isNotBlank(dataMap.get("creditRecordDetails").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("creditRecordDetails")), Object.class);
                    if (!addcreditRecordDetails(orderNum, list)) {
                        log.info("保存信贷记录详细信息失败" + list);
                    }
                }

                //征信查询记录
                if (StringUtils.isNotBlank(dataMap.get("queryInformationDetails").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("queryInformationDetails")), Object.class);
                    if (!addQueryInfo(orderNum, list)) {
                        log.info("保存信征信查询记录失败" + list);
                    }
                }

                //信用卡记录详细信息
                if (StringUtils.isNotBlank(dataMap.get("creditCardRecordDetailAnalyzes").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("creditCardRecordDetailAnalyzes")), Object.class);
                    if (!addCardRecordDetailAnalyzes(orderNum, list)) {
                        log.info("保存信用卡记录详细信息失败" + list);
                    }
                }

                //购房贷款记录相信信息
                if (StringUtils.isNotBlank(dataMap.get("housingLoanRecordDetailAnalyzes").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("housingLoanRecordDetailAnalyzes")), Object.class);
                    if (!addBuyHouseLoanRecord(orderNum, list)) {
                        log.info("保存购房贷款记录相信信息失败" + list);
                    }
                }

                //其他贷款详细信息
                if (StringUtils.isNotBlank(dataMap.get("otherLoanRecordDetailAnalyzes").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("otherLoanRecordDetailAnalyzes")), Object.class);
                    if (!addOtherLoanRecord(orderNum, list)) {
                        log.info("保存其他贷款详细信息失败" + list);
                    }
                }

                //担保信息
                if (StringUtils.isNotBlank(dataMap.get("guaranteeRecordDetailAnalyzes").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("guaranteeRecordDetailAnalyzes")), Object.class);
                    if (!addGuaranteeRecord(orderNum, list)) {
                        log.info("保存担保信息失败" + list);
                    }
                }

                //法院执行
                if (StringUtils.isNotBlank(dataMap.get("focusExecutionRecords").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("focusExecutionRecords")), Object.class);
                    if (!addFocusRecords(orderNum, list)) {
                        log.info("保存法院执行信息失败" + list);
                    }
                }

                //电信
                if (StringUtils.isNotBlank(dataMap.get("owedTelecomRecords").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("owedTelecomRecords")), Object.class);
                    if (!addOwedTelecomRecord(orderNum, list)) {
                        log.info("保存电信信息失败" + list);
                    }
                }

                //税务
                if (StringUtils.isNotBlank(dataMap.get("taxOwedRecords").toString())) {
                    List<Object> list = JSONObject.parseArray(JSON.toJSONString(dataMap.get("taxOwedRecords")), Object.class);
                    if (!addTaxOwedRecord(orderNum, list)) {
                        log.info("保存税务信息失败" + list);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("保存央行征信信息失败:" + e.getLocalizedMessage());
        }
        return false;
    }

    @Override
    public ResponseResult getRHInfo(String orderNum) {
        Integer status = 0;
        Map<String, Object> reportMap = new HashMap<>();

        Map<String, Object> baseInfoMap = new HashMap<>();

        //基本信息
        CreditBaseInfo baseInfo = new CreditBaseInfo();
        baseInfo.setOrderNum(orderNum);
        baseInfo = baseInfoMapper.selectOne(baseInfo);
        if (baseInfo != null) {
            status = 1;
            baseInfoMap.put("mapping_id", baseInfo.getMappingId() == null ? "" : baseInfo.getMappingId());
            baseInfoMap.put("user_name", baseInfo.getUserName() == null ? "" : baseInfo.getUserName());
            baseInfoMap.put("id_card", baseInfo.getIdCardNo() == null ? "" : baseInfo.getIdCardNo());
            baseInfoMap.put("query_time", baseInfo.getQueryTime() == null ? "" : baseInfo.getQueryTime());
            baseInfoMap.put("report_time", baseInfo.getReportTime() == null ? "" : baseInfo.getReportTime());
            baseInfoMap.put("id_card_type", baseInfo.getIdCardType() == null ? "" : baseInfo.getIdCardType());
            baseInfoMap.put("marital_status", baseInfo.getMaritalStatus() == null ? "" : baseInfo.getMaritalStatus());
        }

        //人行征信报告信贷
        Map<String, Object> summariesMap = new HashMap<>();
        Map<String, Object> creditLoanMap = new HashMap<>();
        Map<String, Object> buyHouseMap = new HashMap<>();
        Map<String, Object> otherMap = new HashMap<>();

        CreditRecordSummaries recordSummaries = new CreditRecordSummaries();
        recordSummaries.setOrderNum(orderNum);
        List<CreditRecordSummaries> summariesList = recordSummariesMapper.select(recordSummaries);
        if (summariesList.size() > 0) {
            status = 1;
            for (CreditRecordSummaries summaries : summariesList) {
                Integer account_num = summaries.getAccountNum();
                Integer un_settle_un_cancel = summaries.getUnSettleUnCancel();
                Integer overdue_account = summaries.getOverdueAccount();
                Integer overdue_ninety = summaries.getOverdueNinety();
                Integer guarantee = Integer.parseInt(summaries.getReportNo());
                if (summaries.getCreditType() == 1) {
                    creditLoanMap.put("account_num", account_num);
                    creditLoanMap.put("un_settle_un_cancel", un_settle_un_cancel);
                    creditLoanMap.put("overdue_account", overdue_account);
                    creditLoanMap.put("overdue_ninety", overdue_ninety);
                    creditLoanMap.put("guarantee", guarantee);
                } else if (summaries.getCreditType() == 2) {
                    buyHouseMap.put("account_num", account_num);
                    buyHouseMap.put("un_settle_un_cancel", un_settle_un_cancel);
                    buyHouseMap.put("overdue_account", overdue_account);
                    buyHouseMap.put("overdue_ninety", overdue_ninety);
                    buyHouseMap.put("guarantee", guarantee);
                } else {
                    otherMap.put("account_num", account_num);
                    otherMap.put("un_settle_un_cancel", un_settle_un_cancel);
                    otherMap.put("overdue_account", overdue_account);
                    otherMap.put("overdue_ninety", overdue_ninety);
                    otherMap.put("guarantee", guarantee);
                }
                summariesMap.put("credit_card_loan", creditLoanMap);
                summariesMap.put("other_loan", otherMap);
                summariesMap.put("house_loan", buyHouseMap);
            }
        }

        //信用卡记录详细信息
        List<Map<String, Object>> cardLoanList = new ArrayList<>();
        Map<String, Object> map = null;
        CreditCardRecordDetailAnalyzes analyzes = new CreditCardRecordDetailAnalyzes();
        analyzes.setOrderNum(orderNum);
        List<CreditCardRecordDetailAnalyzes> analyzesList = cardRecordDetailAnalyzesMapper.select(analyzes);
        if (analyzesList.size() > 0) {
            status = 1;
            for (CreditCardRecordDetailAnalyzes analyzes1 : analyzesList) {
                map = new HashMap<>();
                map.put("grant_date", analyzes1.getGrantDate() == null ? "" : analyzes1.getGrantDate());
                map.put("bank_name", analyzes1.getBankName() == null ? "" : analyzes1.getBankName());
                map.put("card_type", analyzes1.getCardType() == null ? "" : analyzes1.getCardType());
                map.put("account_currency", analyzes1.getAccountCurrency() == null ? "" : analyzes1.getAccountCurrency());
                map.put("cutoff_date", analyzes1.getCutoffDate() == null ? "" : analyzes1.getCutoffDate());
                map.put("credit_limit", analyzes1.getCreditLimit() == null ? "" : analyzes1.getCreditLimit());
                map.put("used_credit_line", analyzes1.getUsedCreditLine() == null ? "" : analyzes1.getUsedCreditLine());
                map.put("overdraft_balance", analyzes1.getOverdraftBalance() == null ? "" : analyzes1.getOverdraftBalance());
                map.put("overdue_amount", analyzes1.getOverdueAmount() == null ? "" : analyzes1.getOverdueAmount());
                map.put("is_actived", analyzes1.getIsActived() == null ? "" : analyzes1.getIsActived());
                map.put("is_closed", analyzes1.getIsClosed() == null ? "" : analyzes1.getIsClosed());
                map.put("is_overdue", analyzes1.getIsOverdue() == null ? "" : analyzes1.getIsOverdue());
                map.put("overdue_month", analyzes1.getOverdueNonth() == null ? "" : analyzes1.getOverdueNonth());
                map.put("is_sixtydays_overdraft", analyzes1.getIsSixtydaysOverdraft() == null ? "" : analyzes1.getIsSixtydaysOverdraft());
                map.put("sixtydays_overdraft_month", analyzes1.getSixtydaysOverdraftNonth() == null ? "" : analyzes1.getSixtydaysOverdraftNonth());
                map.put("is_nintydays_overdue", analyzes1.getIsNintydaysOverdue() == null ? "" : analyzes1.getIsNintydaysOverdue());
                map.put("nintydays_overdue_month", analyzes1.getNintydaysOverdueNonth() == null ? "" : analyzes1.getNintydaysOverdueNonth());
                map.put("bad_debts", analyzes1.getBadDebts() == null ? "" : analyzes1.getBadDebts());
                map.put("remaining_sum", analyzes1.getRemainingSum() == null ? "" : analyzes1.getRemainingSum());
                cardLoanList.add(map);
            }
        }

        //购房贷款记录详细信息
        List<Map<String, Object>> buyHousingList = new ArrayList<>();
        Map<String, Object> housingMap = null;
        CreditHousingLoanRecordDetailAnalyzes housingLoanRecordDetailAnalyzes = new CreditHousingLoanRecordDetailAnalyzes();
        housingLoanRecordDetailAnalyzes.setOrderNum(orderNum);
        List<CreditHousingLoanRecordDetailAnalyzes> housingLoanRecordDetailAnalyzesList = housingLoanRecordDetailAnalyzesMapper.select(housingLoanRecordDetailAnalyzes);
        if (housingLoanRecordDetailAnalyzesList.size() > 0) {
            status = 1;
            for (CreditHousingLoanRecordDetailAnalyzes loanRecordDetailAnalyzes : housingLoanRecordDetailAnalyzesList) {
                housingMap = new HashMap<>();
                housingMap.put("grant_date", loanRecordDetailAnalyzes.getGrantDate() == null ? "" : loanRecordDetailAnalyzes.getGrantDate());
                housingMap.put("bank_name", loanRecordDetailAnalyzes.getBankName() == null ? "" : loanRecordDetailAnalyzes.getBankName());
                housingMap.put("currency", loanRecordDetailAnalyzes.getCurrency() == null ? "" : loanRecordDetailAnalyzes.getCurrency());
                housingMap.put("loan_amount", loanRecordDetailAnalyzes.getLoanAmount() == null ? "" : loanRecordDetailAnalyzes.getLoanAmount());
                housingMap.put("loan_item", loanRecordDetailAnalyzes.getLoanItem() == null ? "" : loanRecordDetailAnalyzes.getLoanItem());
                housingMap.put("expiration_date", loanRecordDetailAnalyzes.getExpirationDate() == null ? "" : loanRecordDetailAnalyzes.getExpirationDate());
                housingMap.put("cutoff_date", loanRecordDetailAnalyzes.getCutoffDate() == null ? "" : loanRecordDetailAnalyzes.getCutoffDate());
                housingMap.put("is_closeout", loanRecordDetailAnalyzes.getIsCloseout() == null ? "" : loanRecordDetailAnalyzes.getIsCloseout());
                housingMap.put("remain_balance", loanRecordDetailAnalyzes.getRemainBalance() == null ? "" : loanRecordDetailAnalyzes.getRemainBalance());
                housingMap.put("is_overdue", loanRecordDetailAnalyzes.getIsOverdue() == null ? "" : loanRecordDetailAnalyzes.getIsOverdue());
                housingMap.put("overdue_amount", loanRecordDetailAnalyzes.getOverdueAmount() == null ? "" : loanRecordDetailAnalyzes.getOverdueAmount());
                housingMap.put("is_nintydays_overdue", loanRecordDetailAnalyzes.getIsNintydaysOverdue() == null ? "" : loanRecordDetailAnalyzes.getIsNintydaysOverdue());
                housingMap.put("nintydays_overdue_month", loanRecordDetailAnalyzes.getNintydaysOverdueMonth() == null ? "" : loanRecordDetailAnalyzes.getNintydaysOverdueMonth());
                housingMap.put("transfer", loanRecordDetailAnalyzes.getTransfer() == null ? "" : loanRecordDetailAnalyzes.getTransfer());
                housingMap.put("transfer_date", loanRecordDetailAnalyzes.getTransferDate() == null ? "" : loanRecordDetailAnalyzes.getTransferDate());
                housingMap.put("overdue_month", loanRecordDetailAnalyzes.getOverdueMonth() == null ? "" : loanRecordDetailAnalyzes.getOverdueMonth());
                buyHousingList.add(housingMap);
            }
        }


        //其他贷款详细信息
        List<Map<String, Object>> otherLoanList = new ArrayList<>();
        Map<String, Object> map1 = null;
        CreditOtherLoanRecordDetailAnalyzes analyzes1 = new CreditOtherLoanRecordDetailAnalyzes();
        analyzes1.setOrderNum(orderNum);
        List<CreditOtherLoanRecordDetailAnalyzes> analyzesList1 = otherLoanRecordDetailAnalyzesMapper.select(analyzes1);
        if (analyzesList1.size() > 0) {
            status = 1;
            for (CreditOtherLoanRecordDetailAnalyzes analyzes2 : analyzesList1) {
                map1 = new HashMap<>();
                map1.put("grant_date", analyzes2.getGrantDate() == null ? "" : analyzes2.getGrantDate());
                map1.put("finance_corporation", analyzes2.getFinanceCorporation() == null ? "" : analyzes2.getFinanceCorporation());
                map1.put("currency", analyzes2.getCurrency() == null ? "" : analyzes2.getCurrency());
                map1.put("loan_amount", analyzes2.getLoanAmount() == null ? "" : analyzes2.getLoanAmount());
                map1.put("loan_item", analyzes2.getLoanItem() == null ? "" : analyzes2.getLoanItem());
                map1.put("expiration_date", analyzes2.getExpirationDate() == null ? "" : analyzes2.getExpirationDate());
                map1.put("cutoff_date", analyzes2.getCutoffDate() == null ? "" : analyzes2.getCutoffDate());
                map1.put("is_closeout", analyzes2.getIsCloseout() == null ? "" : analyzes2.getIsCloseout());
                map1.put("remain_balance", analyzes2.getRemainBalance() == null ? "" : analyzes2.getRemainBalance());
                map1.put("is_overdue", analyzes2.getIsOverdue() == null ? "" : analyzes2.getIsOverdue());
                map1.put("overdue_amount", analyzes2.getOverdueAmount() == null ? "" : analyzes2.getOverdueAmount());
                map1.put("overdue_month", analyzes2.getOverdueMonth() == null ? "" : analyzes2.getOverdueMonth());
                map1.put("is_nintydays_overdue", analyzes2.getIsNintydaysOverdue() == null ? "" : analyzes2.getIsNintydaysOverdue());
                map1.put("nintydays_overdue_month", analyzes2.getNintydaysOverdueMonth() == null ? "" : analyzes2.getNintydaysOverdueMonth());
                map1.put("bad_debts", analyzes2.getBadDebts() == null ? "" : analyzes2.getBadDebts());
                map1.put("remaining_sum", analyzes2.getRemainingSum() == null ? "" : analyzes2.getRemainingSum());
                otherLoanList.add(map1);
            }
        }

        //征信记录查询
        List<Map<String, Object>> queryList = new ArrayList<>();
        Map<String, Object> map2 = null;
        Map<String, Object> rhQueryMap = new HashMap<>();
        rhQueryMap.put("status", 0);
        rhQueryMap.put("order_num", orderNum);
        List<CreditQueryInfoDetails> detailsList = queryInfoDetailsMapper.selectQueryMap(rhQueryMap);
        if (detailsList.size() > 0) {
            status = 1;
            for (CreditQueryInfoDetails details : detailsList) {
                map2 = new HashMap<>();
                map2.put("query_date_time", details.getQueryDateTime() == null ? "" : details.getQueryDateTime());
                map2.put("query_operator", details.getQueryOperator() == null ? "" : details.getQueryOperator());
                map2.put("query_reason", details.getQueryReason() == null ? "" : details.getQueryReason());
                queryList.add(map2);
            }
        }



        //征信记录查询
        List<Map<String, Object>> selfList = new ArrayList<>();
        Map<String, Object> map10 = null;
        rhQueryMap.remove("status");
        rhQueryMap.put("status", 1);
        List<CreditQueryInfoDetails> rhQueryList = queryInfoDetailsMapper.selectQueryMap(rhQueryMap);
        if (rhQueryList.size() > 0) {
            status = 1;
            for (CreditQueryInfoDetails details : rhQueryList) {
                map10 = new HashMap<>();
                map10.put("query_date_time", details.getQueryDateTime() == null ? "" : details.getQueryDateTime());
                map10.put("query_operator", details.getQueryOperator() == null ? "" : details.getQueryOperator());
                map10.put("query_reason", details.getQueryReason() == null ? "" : details.getQueryReason());
                selfList.add(map10);
            }
        }

        //担保信息
        List<Map<String, Object>> guaranteeList = new ArrayList<>();
        Map<String, Object> map3 = null;
        CreditGuaranteeRecordDetailAnalyzes analyzes2 = new CreditGuaranteeRecordDetailAnalyzes();
        analyzes2.setOrderNum(orderNum);
        List<CreditGuaranteeRecordDetailAnalyzes> analyzesList2 = guaranteeRecordDetailAnalyzesMapper.select(analyzes2);
        if (analyzesList2.size() > 0) {
            status = 1;
            for (CreditGuaranteeRecordDetailAnalyzes analyzes3 : analyzesList2) {
                map3 = new HashMap<>();
                map3.put("gurantee_date", analyzes3.getGuaranteeDate() == null ? "" : analyzes3.getGuaranteeDate());
                map3.put("warrantee", analyzes3.getWarrantee() == null ? "" : analyzes3.getWarrantee());
                map3.put("id_type", analyzes3.getIdType() == null ? "" : analyzes3.getIdType());
                map3.put("id_number", analyzes3.getIdNumber() == null ? "" : analyzes3.getIdNumber());
                map3.put("gurantee_item", analyzes3.getGuaranteeItem() == null ? "" : analyzes3.getGuaranteeItem());
                map3.put("loan_amount", analyzes3.getLoanAmount() == null ? "" : analyzes3.getLoanAmount());
                map3.put("gurantee_amount", analyzes3.getGuaranteeAmount() == null ? "" : analyzes3.getGuaranteeAmount());
                map3.put("cuttoff_date", analyzes3.getCuttoffDate() == null ? "" : analyzes3.getCuttoffDate());
                map3.put("remain_balance", analyzes3.getRemainBalance() == null ? "" : analyzes3.getRemainBalance());
                guaranteeList.add(map3);
            }
        }

        //法院执行
        List<Map<String, Object>> focusInfoList = new ArrayList<>();
        Map<String, Object> map4 = null;
        CreditFocusExecutionRecords records = new CreditFocusExecutionRecords();
        records.setOrderNum(orderNum);
        List<CreditFocusExecutionRecords> recordsList = focusExecutionRecordsMapper.select(records);
        if (recordsList.size() > 0) {
            status = 1;
            for (CreditFocusExecutionRecords record : recordsList) {
                map4 = new HashMap<>();
                map4.put("case_mark", record.getCaseMark() == null ? "" : record.getCaseMark());
                map4.put("execution_reason", record.getExecutionReason() == null ? "" : record.getExecutionReason());
                map4.put("case_end_type", record.getCaseEndType() == null ? "" : record.getCaseEndType());
                map4.put("case_found_date", record.getCaseFoundDate() == null ? "" : record.getCaseFoundDate());
                map4.put("case_status", record.getCaseStatus() == null ? "" : record.getCaseStatus());
                map4.put("apply_execution", record.getApplyExecution() == null ? "" : record.getApplyExecution());
                map4.put("already_execution", record.getAlreadyExecution() == null ? "" : record.getAlreadyExecution());
                map4.put("apply_excution_amount", record.getApplyExcutionAmount() == null ? "" : record.getApplyExcutionAmount());
                map4.put("already_execution_amount", record.getAlreadyExecutionAmount() == null ? "" : record.getAlreadyExecutionAmount());
                map4.put("case_end_date", record.getCaseEndDate() == null ? "" : record.getCaseEndDate());
                focusInfoList.add(map4);
            }
        }


        //行政处罚
        List<Map<String, Object>> administrativeList = new ArrayList<>();
        Map<String, Object> map5 = null;
        CreditAdministrativePenaltyRecords penaltyRecords = new CreditAdministrativePenaltyRecords();
        penaltyRecords.setOrderNum(orderNum);
        List<CreditAdministrativePenaltyRecords> penaltyRecordsList = administrativePenaltyRecordsMapper.select(penaltyRecords);
        if (penaltyRecordsList.size() > 0) {
            status = 1;
            for (CreditAdministrativePenaltyRecords penaltyRecord : penaltyRecordsList) {
                map5 = new HashMap<>();
                //map5.put("case_end_date", penaltyRecord.getInstitution() == null ? "" : penaltyRecord.getInstitution());
                map5.put("archive_num", penaltyRecord.getArchiveNum() == null ? "" : penaltyRecord.getArchiveNum());
                map5.put("penalty", penaltyRecord.getPenalty() == null ? "" : penaltyRecord.getPenalty());
                map5.put("administrative_review", penaltyRecord.getAdministrativeReview() == null ? "" : penaltyRecord.getAdministrativeReview());
                map5.put("penalty_amount", penaltyRecord.getPenaltyAmount() == null ? "" : penaltyRecord.getPenaltyAmount());
                map5.put("review_result", penaltyRecord.getReviewResult() == null ? "" : penaltyRecord.getReviewResult());
                map5.put("start_time", penaltyRecord.getStartTime() == null ? "" : penaltyRecord.getStartTime());
                map5.put("end_time", penaltyRecord.getEndTime() == null ? "" : penaltyRecord.getEndTime());
                map5.put("institution", penaltyRecord.getInstitution() == null ? "" : penaltyRecord.getInstitution());
                administrativeList.add(map5);
            }
        }

        //电信
        List<Map<String, Object>> owedTeleComList = new ArrayList<>();
        Map<String, Object> map6 = null;
        CreditOwedTelecomRecords owedTelecomRecords = new CreditOwedTelecomRecords();
        owedTelecomRecords.setOrderNum(orderNum);
        List<CreditOwedTelecomRecords> owedTelecomRecordsList = owedTelecomRecordsMapper.select(owedTelecomRecords);
        if (owedTelecomRecordsList.size() > 0) {
            status = 1;
            for (CreditOwedTelecomRecords telecomRecords : owedTelecomRecordsList) {
                map6 = new HashMap<>();
                map6.put("carrier_name", telecomRecords.getCarrierName() == null ? "" : telecomRecords.getCarrierName());
                map6.put("business_type", telecomRecords.getBusinessType() == null ? "" : telecomRecords.getBusinessType());
                map6.put("bookkeeping_date", telecomRecords.getBookkeepingDate() == null ? "" : telecomRecords.getBookkeepingDate());
                map6.put("service_open_time", telecomRecords.getServiceOpenTime() == null ? "" : telecomRecords.getServiceOpenTime());
                map6.put("owed_amount", telecomRecords.getOwedAmount() == null ? "" : telecomRecords.getOwedAmount());
                owedTeleComList.add(map6);
            }
        }

        //税务
        List<Map<String, Object>> taxOwedList = new ArrayList<>();
        Map<String, Object> map7 = null;
        CreditTaxOwedRecords taxOwedRecords = new CreditTaxOwedRecords();
        taxOwedRecords.setOrderNum(orderNum);
        List<CreditTaxOwedRecords> taxOwedRecordsList = taxOwedRecordsMapper.select(taxOwedRecords);
        if (taxOwedRecordsList.size() > 0) {
            status = 1;
            for (CreditTaxOwedRecords owedRecords : taxOwedRecordsList) {
                map7 = new HashMap<>();
                map7.put("institution", owedRecords.getInstitution() == null ? "" : owedRecords.getInstitution());
                map7.put("owed_date", owedRecords.getOwedDate() == null ? "" : owedRecords.getOwedDate());
                map7.put("owed_amount", owedRecords.getOwedAmount() == null ? "" : owedRecords.getOwedAmount());
                map7.put("distinguish_num", owedRecords.getDistinguishNum() == null ? "" : owedRecords.getDistinguishNum());
                taxOwedList.add(map7);
            }
        }

        //详情
        //信用卡
        List<Map<String, Object>> credit_card = new ArrayList<>();
        //购房
        List<Map<String, Object>> credit_house = new ArrayList<>();
        //其他
        List<Map<String, Object>> credit_other =  new ArrayList<>();
        //担保
        List<Map<String, Object>> credit_guarantee = new ArrayList<>();

        //内容
        List<String> occontentList = new ArrayList<>();
        List<String> occontentList2 = new ArrayList<>();
        List<String> noacontentList = new ArrayList<>();
        List<String> noacontentList2 = new ArrayList<>();
        List<String> noacontentList3 = new ArrayList<>();
        List<String> oacontentList = new ArrayList<>();
        List<String> oacontentList2 = new ArrayList<>();
        List<String> oacontentList3 = new ArrayList<>();
        List<String> o6acontentList = new ArrayList<>();
        //标题
        String ocTitle = "";
        String ocTitle2 = "";
        String noaTitle = "";
        String noaTitle2 = "";
        String noaTitle3 = "";
        String oacTitle = "";
        String oacTitle2 = "";
        String oacTitle3 = "";
        String o6aTitle = "";
        //存储标题和内容
        Map<String, Object> ocMap = new HashMap<>();
        Map<String, Object> ocMap2 = new HashMap<>();
        Map<String, Object> ocMap3 = new HashMap<>();
        Map<String, Object> noaMap = new HashMap<>();
        Map<String, Object> noaMap2 = new HashMap<>();
        Map<String, Object> oacMap = new HashMap<>();
        Map<String, Object> oacMap2 = new HashMap<>();
        Map<String, Object> o6aMap = new HashMap<>();
        Map<String, Object> o6aMap1 = new HashMap<>();




        CreditRecordDetails recordDetails = new CreditRecordDetails();
        recordDetails.setOrderNum(orderNum);
        List<CreditRecordDetails> recordDetailsList = recordDetailsMapper.select(recordDetails);
        if (recordDetailsList.size() > 0) {
            status = 1;
            for (CreditRecordDetails creditRecordDetails : recordDetailsList) {
                String content = creditRecordDetails.getContent() == null ? "" : creditRecordDetails.getContent();
                if (creditRecordDetails.getCreditType() == 1) {
                    if (creditRecordDetails.getAccountType() == 1 ) {
                        ocTitle = checkTypeToDec(1);
                        occontentList.add(content);

                    }else if(creditRecordDetails.getAccountType() == 2){
                        ocTitle2 = checkTypeToDec(2);
                        occontentList2.add(content);

                    }else if(creditRecordDetails.getAccountType() == 4){
                        o6aTitle = checkTypeToDec(4);
                        o6acontentList.add(content);

                    }

                    if (StringUtils.isNotBlank(ocTitle)) {
                        ocMap.put("content",occontentList);
                        ocMap.put("title", ocTitle);
                    }

                    if (StringUtils.isNotBlank(ocTitle2)) {
                        ocMap2.put("content",occontentList2);
                        ocMap2.put("title",ocTitle2);
                    }

                    if (StringUtils.isNotBlank(o6aTitle)) {
                        ocMap3.put("content",o6acontentList);
                        ocMap3.put("title",o6aTitle);
                    }

                } else if (creditRecordDetails.getCreditType() == 2) {
                    if (creditRecordDetails.getAccountType() == 3) {
                        noaTitle = checkTypeToDec(3);
                        noacontentList.add(content);
                    } else  if (creditRecordDetails.getAccountType() == 5){
                        Integer tyep = creditRecordDetails.getAccountType();
                        oacTitle = checkTypeToDec(tyep);
                        oacontentList.add(content);
                    }

                    if (StringUtils.isNotBlank(noaTitle)) {
                        noaMap.put("title",noaTitle);
                        noaMap.put("content",noacontentList);
                    }

                    if (StringUtils.isNotBlank(oacTitle)) {
                        noaMap2.put("title",oacTitle);
                        noaMap2.put("content",oacontentList);
                    }


                } else if (creditRecordDetails.getCreditType() == 3) {

                    if (creditRecordDetails.getAccountType() == 3) {
                        noaTitle2 = checkTypeToDec(3);
                        noacontentList2.add(content);
                    } else  if (creditRecordDetails.getAccountType() == 5){
                        oacTitle2 = checkTypeToDec(creditRecordDetails.getAccountType());
                        oacontentList2.add(content);
                    }

                    if (noaTitle2 != null && StringUtils.isNotBlank(noaTitle2)) {
                        oacMap.put("title",noaTitle2);
                        oacMap.put("content",noacontentList2);
                    }

                    if (oacTitle2 != null && StringUtils.isNotBlank(oacTitle2)) {
                        oacMap2.put("title",oacTitle2);
                        oacMap2.put("content",oacontentList2);
                    }


                } else if (creditRecordDetails.getCreditType() == 4) {

                    if (creditRecordDetails.getAccountType() == 3) {
                        noaTitle3 = checkTypeToDec(3);
                        noacontentList3.add(content);
                    } else  if (creditRecordDetails.getAccountType() == 5){
                        oacTitle3 = checkTypeToDec(5);
                        oacontentList3.add(content);
                    }

                    if (StringUtils.isNotBlank(noaTitle3) && noacontentList3.size() > 0) {
                        o6aMap.put("title",noaTitle3);
                        o6aMap.put("content",noacontentList3);
                    }

                    if (StringUtils.isNotBlank(oacTitle3) && oacontentList3.size() > 0) {
                        o6aMap1.put("title",oacTitle3);
                        o6aMap1.put("content",oacontentList3);
                    }

                }
            }
            if (ocMap != null && ocMap.size() > 0) {
                credit_card.add(ocMap);
            }
            if (ocMap2 != null && ocMap2.size() > 0) {
                credit_card.add(ocMap2);
            }
            if (ocMap3 != null && ocMap3.size() > 0) {
                credit_card.add(ocMap3);
            }
            if (noaMap != null && noaMap.size() > 0) {
                credit_house.add(noaMap);
            }
            if (noaMap2 != null && noaMap2.size() > 0) {
                credit_house.add(noaMap2);
            }
            if (oacMap2 != null && oacMap2.size() > 0) {
                credit_other.add(oacMap2);
            }
            if (oacMap != null && oacMap.size() > 0) {
                credit_other.add(oacMap);
            }
            if (o6aMap != null && o6aMap.size() > 0) {
                credit_guarantee.add(o6aMap);
            }
            if (o6aMap1 != null && o6aMap1.size() > 0) {
                credit_guarantee.add(o6aMap1);
            }
        }


        if (status == 0) {
            return new ResponseResult(ResponseCode.RHDATANOTUSER.getCode(), ResponseCode.RHDATANOTUSER.getDescription());
        } else {
            reportMap.put("credit_base_info", baseInfoMap);
            reportMap.put("credit_record_summaries", summariesMap);
            reportMap.put("credit_card", credit_card);
            reportMap.put("credit_house", credit_house);
            reportMap.put("credit_other", credit_other);
            reportMap.put("credit_guarantee", credit_guarantee);
            reportMap.put("credit_query_Information_details", queryList);
            reportMap.put("credit_query_Information_details_self", selfList);
            reportMap.put("credit_card_record_detail_analyzes", cardLoanList);
            reportMap.put("credit_housing_loan_record_detail_analyzes", buyHousingList);
            reportMap.put("credit_other_loan_record_detail_analyzes", otherLoanList);
            reportMap.put("credit_guarantee_record_detail_analyzes", guaranteeList);
            reportMap.put("credit_focus_execution_records", focusInfoList);
            reportMap.put("credit_administrative_penalty_records", administrativeList);
            reportMap.put("credit_tax_owed_records", taxOwedList);
            reportMap.put("credit_owed_telecom_records", owedTeleComList);
            return ResponseResult.ok(reportMap);
        }
    }

    /**
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/23 12:53
     * @Param
     * @return
     * @Deseription  根据类型返回响应的描述
     */
    public String checkTypeToDec(Integer i){
        String result = "";
        if (i == 1) {
            result = "发生过逾期的贷记卡账户";
        } else if (i == 2) {
            result = "从未逾期的贷记卡及透支未超过60天的准贷记卡账户";
        } else if (i == 3) {
            result = "从未逾期过的账户";
        } else if (i == 4) {
            result = "透支超过60天的准贷记卡账户";
        } else if (i == 5) {
            result = "发生过逾期的账户";
        }else{
            result = "相关描述为空";
        }

        return result;
    }

    @Override
    public ResponseResult getRHInfos(String orderNum) {
        Integer status = 0;
        Map<String, Object> reportMap = new HashMap<>();

        Map<String, Object> baseInfoMap = new HashMap<>();

        //基本信息
        CreditBaseInfo baseInfo = new CreditBaseInfo();
        baseInfo.setOrderNum(orderNum);
        baseInfo = baseInfoMapper.selectOne(baseInfo);
        if (baseInfo != null) {
            status = 1;
            baseInfoMap.put("mapping_id", baseInfo.getMappingId() == null ? "" : baseInfo.getMappingId());
            baseInfoMap.put("user_name", baseInfo.getUserName() == null ? "" : baseInfo.getUserName());
            baseInfoMap.put("id_card", baseInfo.getIdCardNo() == null ? "" : baseInfo.getIdCardNo());
            baseInfoMap.put("query_time", baseInfo.getQueryTime() == null ? "" : baseInfo.getQueryTime());
            baseInfoMap.put("report_time", baseInfo.getReportTime() == null ? "" : baseInfo.getReportTime());
            baseInfoMap.put("id_card_type", baseInfo.getIdCardType() == null ? "" : baseInfo.getIdCardType());
            baseInfoMap.put("marital_status", baseInfo.getMaritalStatus() == null ? "" : baseInfo.getMaritalStatus());
        }

        //人行征信报告信贷
        Map<String, Object> summariesMap = new HashMap<>();
        Map<String, Object> creditLoanMap = new HashMap<>();
        Map<String, Object> buyHouseMap = new HashMap<>();
        Map<String, Object> otherMap = new HashMap<>();

        CreditRecordSummaries recordSummaries = new CreditRecordSummaries();
        recordSummaries.setOrderNum(orderNum);
        List<CreditRecordSummaries> summariesList = recordSummariesMapper.select(recordSummaries);
        if (summariesList.size() > 0) {
            status = 1;
            for (CreditRecordSummaries summaries : summariesList) {
                Integer account_num = summaries.getAccountNum();
                Integer un_settle_un_cancel = summaries.getUnSettleUnCancel();
                Integer overdue_account = summaries.getOverdueAccount();
                Integer overdue_ninety = summaries.getOverdueNinety();
                Integer guarantee = Integer.parseInt(summaries.getReportNo());
                if (summaries.getCreditType() == 1) {
                    creditLoanMap.put("account_num", account_num);
                    creditLoanMap.put("un_settle_un_cancel", un_settle_un_cancel);
                    creditLoanMap.put("overdue_account", overdue_account);
                    creditLoanMap.put("overdue_ninety", overdue_ninety);
                    creditLoanMap.put("guarantee", guarantee);
                } else if (summaries.getCreditType() == 2) {
                    buyHouseMap.put("account_num", account_num);
                    buyHouseMap.put("un_settle_un_cancel", un_settle_un_cancel);
                    buyHouseMap.put("overdue_account", overdue_account);
                    buyHouseMap.put("overdue_ninety", overdue_ninety);
                    buyHouseMap.put("guarantee", guarantee);
                } else {
                    otherMap.put("account_num", account_num);
                    otherMap.put("un_settle_un_cancel", un_settle_un_cancel);
                    otherMap.put("overdue_account", overdue_account);
                    otherMap.put("overdue_ninety", overdue_ninety);
                    otherMap.put("guarantee", guarantee);
                }
                summariesMap.put("credit_card_loan", creditLoanMap);
                summariesMap.put("other_loan", otherMap);
                summariesMap.put("house_loan", buyHouseMap);
            }
        }

        //信用卡记录详细信息
        List<Map<String, Object>> cardLoanList = new ArrayList<>();
        Map<String, Object> map = null;
        CreditCardRecordDetailAnalyzes analyzes = new CreditCardRecordDetailAnalyzes();
        analyzes.setOrderNum(orderNum);
        List<CreditCardRecordDetailAnalyzes> analyzesList = cardRecordDetailAnalyzesMapper.select(analyzes);
        if (analyzesList.size() > 0) {
            status = 1;
            for (CreditCardRecordDetailAnalyzes analyzes1 : analyzesList) {
                map = new HashMap<>();
                map.put("grant_date", analyzes1.getGrantDate() == null ? "" : analyzes1.getGrantDate());
                map.put("bank_name", analyzes1.getBankName() == null ? "" : analyzes1.getBankName());
                map.put("card_type", analyzes1.getCardType() == null ? "" : analyzes1.getCardType());
                map.put("account_currency", analyzes1.getAccountCurrency() == null ? "" : analyzes1.getAccountCurrency());
                map.put("cutoff_date", analyzes1.getCutoffDate() == null ? "" : analyzes1.getCutoffDate());
                map.put("credit_limit", analyzes1.getCreditLimit() == null ? "" : analyzes1.getCreditLimit());
                map.put("used_credit_line", analyzes1.getUsedCreditLine() == null ? "" : analyzes1.getUsedCreditLine());
                map.put("overdraft_balance", analyzes1.getOverdraftBalance() == null ? "" : analyzes1.getOverdraftBalance());
                map.put("overdue_amount", analyzes1.getOverdueAmount() == null ? "" : analyzes1.getOverdueAmount());
                map.put("is_actived", analyzes1.getIsActived() == null ? "" : analyzes1.getIsActived());
                map.put("is_closed", analyzes1.getIsClosed() == null ? "" : analyzes1.getIsClosed());
                map.put("is_overdue", analyzes1.getIsOverdue() == null ? "" : analyzes1.getIsOverdue());
                map.put("overdue_month", analyzes1.getOverdueNonth() == null ? "" : analyzes1.getOverdueNonth());
                map.put("is_sixtydays_overdraft", analyzes1.getIsSixtydaysOverdraft() == null ? "" : analyzes1.getIsSixtydaysOverdraft());
                map.put("sixtydays_overdraft_month", analyzes1.getSixtydaysOverdraftNonth() == null ? "" : analyzes1.getSixtydaysOverdraftNonth());
                map.put("is_nintydays_overdue", analyzes1.getIsNintydaysOverdue() == null ? "" : analyzes1.getIsNintydaysOverdue());
                map.put("nintydays_overdue_month", analyzes1.getNintydaysOverdueNonth() == null ? "" : analyzes1.getNintydaysOverdueNonth());
                map.put("bad_debts", analyzes1.getBadDebts() == null ? "" : analyzes1.getBadDebts());
                map.put("remaining_sum", analyzes1.getRemainingSum() == null ? "" : analyzes1.getRemainingSum());
                cardLoanList.add(map);
            }
        }

        //购房贷款记录详细信息
        List<Map<String, Object>> buyHousingList = new ArrayList<>();
        Map<String, Object> housingMap = null;
        CreditHousingLoanRecordDetailAnalyzes housingLoanRecordDetailAnalyzes = new CreditHousingLoanRecordDetailAnalyzes();
        housingLoanRecordDetailAnalyzes.setOrderNum(orderNum);
        List<CreditHousingLoanRecordDetailAnalyzes> housingLoanRecordDetailAnalyzesList = housingLoanRecordDetailAnalyzesMapper.select(housingLoanRecordDetailAnalyzes);
        if (housingLoanRecordDetailAnalyzesList.size() > 0) {
            status = 1;
            for (CreditHousingLoanRecordDetailAnalyzes loanRecordDetailAnalyzes : housingLoanRecordDetailAnalyzesList) {
                housingMap = new HashMap<>();
                housingMap.put("grant_date", loanRecordDetailAnalyzes.getGrantDate() == null ? "" : loanRecordDetailAnalyzes.getGrantDate());
                housingMap.put("bank_name", loanRecordDetailAnalyzes.getBankName() == null ? "" : loanRecordDetailAnalyzes.getBankName());
                housingMap.put("currency", loanRecordDetailAnalyzes.getCurrency() == null ? "" : loanRecordDetailAnalyzes.getCurrency());
                housingMap.put("loan_amount", loanRecordDetailAnalyzes.getLoanAmount() == null ? "" : loanRecordDetailAnalyzes.getLoanAmount());
                housingMap.put("loan_item", loanRecordDetailAnalyzes.getLoanItem() == null ? "" : loanRecordDetailAnalyzes.getLoanItem());
                housingMap.put("expiration_date", loanRecordDetailAnalyzes.getExpirationDate() == null ? "" : loanRecordDetailAnalyzes.getExpirationDate());
                housingMap.put("cutoff_date", loanRecordDetailAnalyzes.getCutoffDate() == null ? "" : loanRecordDetailAnalyzes.getCutoffDate());
                housingMap.put("is_closeout", loanRecordDetailAnalyzes.getIsCloseout() == null ? "" : loanRecordDetailAnalyzes.getIsCloseout());
                housingMap.put("remain_balance", loanRecordDetailAnalyzes.getRemainBalance() == null ? "" : loanRecordDetailAnalyzes.getRemainBalance());
                housingMap.put("is_overdue", loanRecordDetailAnalyzes.getIsOverdue() == null ? "" : loanRecordDetailAnalyzes.getIsOverdue());
                housingMap.put("overdue_amount", loanRecordDetailAnalyzes.getOverdueAmount() == null ? "" : loanRecordDetailAnalyzes.getOverdueAmount());
                housingMap.put("is_nintydays_overdue", loanRecordDetailAnalyzes.getIsNintydaysOverdue() == null ? "" : loanRecordDetailAnalyzes.getIsNintydaysOverdue());
                housingMap.put("nintydays_overdue_month", loanRecordDetailAnalyzes.getNintydaysOverdueMonth() == null ? "" : loanRecordDetailAnalyzes.getNintydaysOverdueMonth());
                housingMap.put("transfer", loanRecordDetailAnalyzes.getTransfer() == null ? "" : loanRecordDetailAnalyzes.getTransfer());
                housingMap.put("transfer_date", loanRecordDetailAnalyzes.getTransferDate() == null ? "" : loanRecordDetailAnalyzes.getTransferDate());
                housingMap.put("overdue_month", loanRecordDetailAnalyzes.getOverdueMonth() == null ? "" : loanRecordDetailAnalyzes.getOverdueMonth());
                buyHousingList.add(housingMap);
            }
        }


        //其他贷款详细信息
        List<Map<String, Object>> otherLoanList = new ArrayList<>();
        Map<String, Object> map1 = null;
        CreditOtherLoanRecordDetailAnalyzes analyzes1 = new CreditOtherLoanRecordDetailAnalyzes();
        analyzes1.setOrderNum(orderNum);
        List<CreditOtherLoanRecordDetailAnalyzes> analyzesList1 = otherLoanRecordDetailAnalyzesMapper.select(analyzes1);
        if (analyzesList1.size() > 0) {
            status = 1;
            for (CreditOtherLoanRecordDetailAnalyzes analyzes2 : analyzesList1) {
                map1 = new HashMap<>();
                map1.put("grant_date", analyzes2.getGrantDate() == null ? "" : analyzes2.getGrantDate());
                map1.put("finance_corporation", analyzes2.getFinanceCorporation() == null ? "" : analyzes2.getFinanceCorporation());
                map1.put("currency", analyzes2.getCurrency() == null ? "" : analyzes2.getCurrency());
                map1.put("loan_amount", analyzes2.getLoanAmount() == null ? "" : analyzes2.getLoanAmount());
                map1.put("loan_item", analyzes2.getLoanItem() == null ? "" : analyzes2.getLoanItem());
                map1.put("expiration_date", analyzes2.getExpirationDate() == null ? "" : analyzes2.getExpirationDate());
                map1.put("cutoff_date", analyzes2.getCutoffDate() == null ? "" : analyzes2.getCutoffDate());
                map1.put("is_closeout", analyzes2.getIsCloseout() == null ? "" : analyzes2.getIsCloseout());
                map1.put("remain_balance", analyzes2.getRemainBalance() == null ? "" : analyzes2.getRemainBalance());
                map1.put("is_overdue", analyzes2.getIsOverdue() == null ? "" : analyzes2.getIsOverdue());
                map1.put("overdue_amount", analyzes2.getOverdueAmount() == null ? "" : analyzes2.getOverdueAmount());
                map1.put("overdue_month", analyzes2.getOverdueMonth() == null ? "" : analyzes2.getOverdueMonth());
                map1.put("is_nintydays_overdue", analyzes2.getIsNintydaysOverdue() == null ? "" : analyzes2.getIsNintydaysOverdue());
                map1.put("nintydays_overdue_month", analyzes2.getNintydaysOverdueMonth() == null ? "" : analyzes2.getNintydaysOverdueMonth());
                map1.put("bad_debts", analyzes2.getBadDebts() == null ? "" : analyzes2.getBadDebts());
                map1.put("remaining_sum", analyzes2.getRemainingSum() == null ? "" : analyzes2.getRemainingSum());
                otherLoanList.add(map1);
            }
        }

        //征信记录查询
        List<Map<String, Object>> queryList = new ArrayList<>();
        Map<String, Object> map2 = null;
        List<CreditQueryInfoDetails> detailsList = queryInfoDetailsMapper.selectQuerys(orderNum);
        if (detailsList.size() > 0) {
            status = 1;
            for (CreditQueryInfoDetails details : detailsList) {
                map2 = new HashMap<>();
                map2.put("query_date_time", details.getQueryDateTime() == null ? "" : details.getQueryDateTime());
                map2.put("query_operator", details.getQueryOperator() == null ? "" : details.getQueryOperator());
                map2.put("query_reason", details.getQueryReason() == null ? "" : details.getQueryReason());
                queryList.add(map2);
            }
        }

        //担保信息
        List<Map<String, Object>> guaranteeList = new ArrayList<>();
        Map<String, Object> map3 = null;
        CreditGuaranteeRecordDetailAnalyzes analyzes2 = new CreditGuaranteeRecordDetailAnalyzes();
        analyzes2.setOrderNum(orderNum);
        List<CreditGuaranteeRecordDetailAnalyzes> analyzesList2 = guaranteeRecordDetailAnalyzesMapper.select(analyzes2);
        if (analyzesList2.size() > 0) {
            status = 1;
            for (CreditGuaranteeRecordDetailAnalyzes analyzes3 : analyzesList2) {
                map3 = new HashMap<>();
                map3.put("gurantee_date", analyzes3.getGuaranteeDate() == null ? "" : analyzes3.getGuaranteeDate());
                map3.put("warrantee", analyzes3.getWarrantee() == null ? "" : analyzes3.getWarrantee());
                map3.put("id_type", analyzes3.getIdType() == null ? "" : analyzes3.getIdType());
                map3.put("id_number", analyzes3.getIdNumber() == null ? "" : analyzes3.getIdNumber());
                map3.put("gurantee_item", analyzes3.getGuaranteeItem() == null ? "" : analyzes3.getGuaranteeItem());
                map3.put("loan_amount", analyzes3.getLoanAmount() == null ? "" : analyzes3.getLoanAmount());
                map3.put("gurantee_amount", analyzes3.getGuaranteeAmount() == null ? "" : analyzes3.getGuaranteeAmount());
                map3.put("cuttoff_date", analyzes3.getCuttoffDate() == null ? "" : analyzes3.getCuttoffDate());
                map3.put("remain_balance", analyzes3.getRemainBalance() == null ? "" : analyzes3.getRemainBalance());
                guaranteeList.add(map3);
            }
        }

        //法院执行
        List<Map<String, Object>> focusInfoList = new ArrayList<>();
        Map<String, Object> map4 = null;
        CreditFocusExecutionRecords records = new CreditFocusExecutionRecords();
        records.setOrderNum(orderNum);
        List<CreditFocusExecutionRecords> recordsList = focusExecutionRecordsMapper.select(records);
        if (recordsList.size() > 0) {
            status = 1;
            for (CreditFocusExecutionRecords record : recordsList) {
                map4 = new HashMap<>();
                map4.put("case_mark", record.getCaseMark() == null ? "" : record.getCaseMark());
                map4.put("execution_reason", record.getExecutionReason() == null ? "" : record.getExecutionReason());
                map4.put("case_end_type", record.getCaseEndType() == null ? "" : record.getCaseEndType());
                map4.put("case_found_date", record.getCaseFoundDate() == null ? "" : record.getCaseFoundDate());
                map4.put("case_status", record.getCaseStatus() == null ? "" : record.getCaseStatus());
                map4.put("apply_execution", record.getApplyExecution() == null ? "" : record.getApplyExecution());
                map4.put("already_execution", record.getAlreadyExecution() == null ? "" : record.getAlreadyExecution());
                map4.put("apply_excution_amount", record.getApplyExcutionAmount() == null ? "" : record.getApplyExcutionAmount());
                map4.put("already_execution_amount", record.getAlreadyExecutionAmount() == null ? "" : record.getAlreadyExecutionAmount());
                map4.put("case_end_date", record.getCaseEndDate() == null ? "" : record.getCaseEndDate());
                focusInfoList.add(map4);
            }
        }


        //行政处罚
        List<Map<String, Object>> administrativeList = new ArrayList<>();
        Map<String, Object> map5 = null;
        CreditAdministrativePenaltyRecords penaltyRecords = new CreditAdministrativePenaltyRecords();
        penaltyRecords.setOrderNum(orderNum);
        List<CreditAdministrativePenaltyRecords> penaltyRecordsList = administrativePenaltyRecordsMapper.select(penaltyRecords);
        if (penaltyRecordsList.size() > 0) {
            status = 1;
            for (CreditAdministrativePenaltyRecords penaltyRecord : penaltyRecordsList) {
                map5 = new HashMap<>();
                //map5.put("case_end_date", penaltyRecord.getInstitution() == null ? "" : penaltyRecord.getInstitution());
                map5.put("archive_num", penaltyRecord.getArchiveNum() == null ? "" : penaltyRecord.getArchiveNum());
                map5.put("penalty", penaltyRecord.getPenalty() == null ? "" : penaltyRecord.getPenalty());
                map5.put("administrative_review", penaltyRecord.getAdministrativeReview() == null ? "" : penaltyRecord.getAdministrativeReview());
                map5.put("penalty_amount", penaltyRecord.getPenaltyAmount() == null ? "" : penaltyRecord.getPenaltyAmount());
                map5.put("review_result", penaltyRecord.getReviewResult() == null ? "" : penaltyRecord.getReviewResult());
                map5.put("start_time", penaltyRecord.getStartTime() == null ? "" : penaltyRecord.getStartTime());
                map5.put("end_time", penaltyRecord.getEndTime() == null ? "" : penaltyRecord.getEndTime());
                map5.put("institution", penaltyRecord.getInstitution() == null ? "" : penaltyRecord.getInstitution());
                administrativeList.add(map5);
            }
        }

        //电信
        List<Map<String, Object>> owedTeleComList = new ArrayList<>();
        Map<String, Object> map6 = null;
        CreditOwedTelecomRecords owedTelecomRecords = new CreditOwedTelecomRecords();
        owedTelecomRecords.setOrderNum(orderNum);
        List<CreditOwedTelecomRecords> owedTelecomRecordsList = owedTelecomRecordsMapper.select(owedTelecomRecords);
        if (owedTelecomRecordsList.size() > 0) {
            status = 1;
            for (CreditOwedTelecomRecords telecomRecords : owedTelecomRecordsList) {
                map6 = new HashMap<>();
                map6.put("carrier_name", telecomRecords.getCarrierName() == null ? "" : telecomRecords.getCarrierName());
                map6.put("business_type", telecomRecords.getBusinessType() == null ? "" : telecomRecords.getBusinessType());
                map6.put("bookkeeping_date", telecomRecords.getBookkeepingDate() == null ? "" : telecomRecords.getBookkeepingDate());
                map6.put("service_open_time", telecomRecords.getServiceOpenTime() == null ? "" : telecomRecords.getServiceOpenTime());
                map6.put("owed_amount", telecomRecords.getOwedAmount() == null ? "" : telecomRecords.getOwedAmount());
                owedTeleComList.add(map6);
            }
        }

        //税务
        List<Map<String, Object>> taxOwedList = new ArrayList<>();
        Map<String, Object> map7 = null;
        CreditTaxOwedRecords taxOwedRecords = new CreditTaxOwedRecords();
        taxOwedRecords.setOrderNum(orderNum);
        List<CreditTaxOwedRecords> taxOwedRecordsList = taxOwedRecordsMapper.select(taxOwedRecords);
        if (taxOwedRecordsList.size() > 0) {
            status = 1;
            for (CreditTaxOwedRecords owedRecords : taxOwedRecordsList) {
                map7 = new HashMap<>();
                map7.put("institution", owedRecords.getInstitution() == null ? "" : owedRecords.getInstitution());
                map7.put("owed_date", owedRecords.getOwedDate() == null ? "" : owedRecords.getOwedDate());
                map7.put("owed_amount", owedRecords.getOwedAmount() == null ? "" : owedRecords.getOwedAmount());
                map7.put("distinguish_num", owedRecords.getDistinguishNum() == null ? "" : owedRecords.getDistinguishNum());
                taxOwedList.add(map7);
            }
        }

        //详情
        //信用卡
        List<Map<String, Object>> credit_card = new ArrayList<>();
        //购房
        List<Map<String, Object>> credit_house = new ArrayList<>();
        //其他
        List<Map<String, Object>> credit_other =  new ArrayList<>();
        //担保
        List<Map<String, Object>> credit_guarantee = new ArrayList<>();

        //内容
        List<String> occontentList = new ArrayList<>();
        List<String> occontentList2 = new ArrayList<>();
        List<String> noacontentList = new ArrayList<>();
        List<String> noacontentList2 = new ArrayList<>();
        List<String> noacontentList3 = new ArrayList<>();
        List<String> oacontentList = new ArrayList<>();
        List<String> oacontentList2 = new ArrayList<>();
        List<String> oacontentList3 = new ArrayList<>();
        List<String> o6acontentList = new ArrayList<>();
        //标题
        String ocTitle = "";
        String ocTitle2 = "";
        String noaTitle = "";
        String noaTitle2 = "";
        String noaTitle3 = "";
        String oacTitle = "";
        String oacTitle2 = "";
        String oacTitle3 = "";
        String o6aTitle = "";
        //存储标题和内容
        Map<String, Object> ocMap = new HashMap<>();
        Map<String, Object> ocMap2 = new HashMap<>();
        Map<String, Object> ocMap3 = new HashMap<>();
        Map<String, Object> noaMap = new HashMap<>();
        Map<String, Object> noaMap2 = new HashMap<>();
        Map<String, Object> oacMap = new HashMap<>();
        Map<String, Object> oacMap2 = new HashMap<>();
        Map<String, Object> o6aMap = new HashMap<>();
        Map<String, Object> o6aMap1 = new HashMap<>();




        CreditRecordDetails recordDetails = new CreditRecordDetails();
        recordDetails.setOrderNum(orderNum);
        List<CreditRecordDetails> recordDetailsList = recordDetailsMapper.select(recordDetails);
        if (recordDetailsList.size() > 0) {
            status = 1;
            for (CreditRecordDetails creditRecordDetails : recordDetailsList) {
                String content = creditRecordDetails.getContent() == null ? "" : creditRecordDetails.getContent();
                if (creditRecordDetails.getCreditType() == 1) {
                    if (creditRecordDetails.getAccountType() == 1 ) {
                        ocTitle = checkTypeToDec(1);
                        occontentList.add(content);

                    }else if(creditRecordDetails.getAccountType() == 2){
                        ocTitle2 = checkTypeToDec(2);
                        occontentList2.add(content);

                    }else if(creditRecordDetails.getAccountType() == 4){
                        o6aTitle = checkTypeToDec(4);
                        o6acontentList.add(content);

                    }

                    if (StringUtils.isNotBlank(ocTitle)) {
                        ocMap.put("content",occontentList);
                        ocMap.put("title", ocTitle);
                    }

                    if (StringUtils.isNotBlank(ocTitle2)) {
                        ocMap2.put("content",occontentList2);
                        ocMap2.put("title",ocTitle2);
                    }

                    if (StringUtils.isNotBlank(o6aTitle)) {
                        ocMap3.put("content",o6acontentList);
                        ocMap3.put("title",o6aTitle);
                    }

                } else if (creditRecordDetails.getCreditType() == 2) {
                    if (creditRecordDetails.getAccountType() == 3) {
                        noaTitle = checkTypeToDec(3);
                        noacontentList.add(content);
                    } else  if (creditRecordDetails.getAccountType() == 5){
                        Integer tyep = creditRecordDetails.getAccountType();
                        oacTitle = checkTypeToDec(tyep);
                        oacontentList.add(content);
                    }

                    if (StringUtils.isNotBlank(noaTitle)) {
                        noaMap.put("title",noaTitle);
                        noaMap.put("content",noacontentList);
                    }

                    if (StringUtils.isNotBlank(oacTitle)) {
                        noaMap2.put("title",oacTitle);
                        noaMap2.put("content",oacontentList);
                    }


                } else if (creditRecordDetails.getCreditType() == 3) {

                    if (creditRecordDetails.getAccountType() == 3) {
                        noaTitle2 = checkTypeToDec(3);
                        noacontentList2.add(content);
                    } else  if (creditRecordDetails.getAccountType() == 5){
                        oacTitle2 = checkTypeToDec(creditRecordDetails.getAccountType());
                        oacontentList2.add(content);
                    }

                    if (noaTitle2 != null && StringUtils.isNotBlank(noaTitle2)) {
                        oacMap.put("title",noaTitle2);
                        oacMap.put("content",noacontentList2);
                    }

                    if (oacTitle2 != null && StringUtils.isNotBlank(oacTitle2)) {
                        oacMap2.put("title",oacTitle2);
                        oacMap2.put("content",oacontentList2);
                    }


                } else if (creditRecordDetails.getCreditType() == 4) {

                    if (creditRecordDetails.getAccountType() == 3) {
                        noaTitle3 = checkTypeToDec(3);
                        noacontentList3.add(content);
                    } else  if (creditRecordDetails.getAccountType() == 5){
                        oacTitle3 = checkTypeToDec(5);
                        oacontentList3.add(content);
                    }

                    if (StringUtils.isNotBlank(noaTitle3) && noacontentList3.size() > 0) {
                        o6aMap.put("title",noaTitle3);
                        o6aMap.put("content",noacontentList3);
                    }

                    if (StringUtils.isNotBlank(oacTitle3) && oacontentList3.size() > 0) {
                        o6aMap1.put("title",oacTitle3);
                        o6aMap1.put("content",oacontentList3);
                    }

                }
            }
            if (ocMap != null && ocMap.size() > 0) {
                credit_card.add(ocMap);
            }
            if (ocMap2 != null && ocMap2.size() > 0) {
                credit_card.add(ocMap2);
            }
            if (ocMap3 != null && ocMap3.size() > 0) {
                credit_card.add(ocMap3);
            }
            if (noaMap != null && noaMap.size() > 0) {
                credit_house.add(noaMap);
            }
            if (noaMap2 != null && noaMap2.size() > 0) {
                credit_house.add(noaMap2);
            }
            if (oacMap2 != null && oacMap2.size() > 0) {
                credit_other.add(oacMap2);
            }
            if (oacMap != null && oacMap.size() > 0) {
                credit_other.add(oacMap);
            }
            if (o6aMap != null && o6aMap.size() > 0) {
                credit_guarantee.add(o6aMap);
            }
            if (o6aMap1 != null && o6aMap1.size() > 0) {
                credit_guarantee.add(o6aMap1);
            }
        }


        if (status == 0) {
            return new ResponseResult(ResponseCode.RHDATANOTUSER.getCode(), ResponseCode.RHDATANOTUSER.getDescription());
        } else {
            reportMap.put("credit_base_info", baseInfoMap);
            reportMap.put("credit_record_summaries", summariesMap);
            reportMap.put("credit_card", credit_card);
            reportMap.put("credit_house", credit_house);
            reportMap.put("credit_other", credit_other);
            reportMap.put("credit_guarantee", credit_guarantee);
            reportMap.put("credit_query_Information_details", queryList);
            reportMap.put("credit_card_record_detail_analyzes", cardLoanList);
            reportMap.put("credit_housing_loan_record_detail_analyzes", buyHousingList);
            reportMap.put("credit_other_loan_record_detail_analyzes", otherLoanList);
            reportMap.put("credit_guarantee_record_detail_analyzes", guaranteeList);
            reportMap.put("credit_focus_execution_records", focusInfoList);
            reportMap.put("credit_administrative_penalty_records", administrativeList);
            reportMap.put("credit_tax_owed_records", taxOwedList);
            reportMap.put("credit_owed_telecom_records", owedTeleComList);
            return ResponseResult.ok(reportMap);
        }
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/15 17:17
     * @Param
     * @Deseription 央行_行政处罚
     */
    public boolean addAdministrativeSanction(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditAdministrativePenaltyRecords records = new CreditAdministrativePenaltyRecords();
            records.setOrderNum(orederNum);
            List<CreditAdministrativePenaltyRecords> recordsList = administrativePenaltyRecordsMapper.select(records);
            if(recordsList.size() > 0) {
                for(CreditAdministrativePenaltyRecords rd : recordsList) {
                    administrativePenaltyRecordsMapper.delete(rd);
                }
            }

            List<CreditAdministrativePenaltyRecords> creditAdministrativePenaltyRecordsList = new ArrayList<>();
            for (Object obj : list) {
                Map<String, Object> item = (Map<String, Object>) obj;
                records = new CreditAdministrativePenaltyRecords();
                records.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                records.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                records.setInstitution(item.get("institution") == null ? "" : item.get("institution").toString());
                records.setArchiveNum(item.get("archive_num") == null ? "" : item.get("archive_num").toString());
                records.setAdministrativeReview(item.get("administrative_review") == null ? "" : item.get("administrative_review").toString());
                records.setPenalty(item.get("penalty") == null ? "" : item.get("penalty").toString());
                records.setPenaltyAmount(item.get("penalty_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("penalty_amount").toString()));
                records.setReviewResult(item.get("review_result") == null ? "" : item.get("review_result").toString());
                records.setStartTime(item.get("start_time") == null ? "" : item.get("start_time").toString());
                records.setEndTime(item.get("end_time") == null ? "" : item.get("end_time").toString());
                records.setUuid(UUID.randomUUID().toString());
                records.setOrderNum(orederNum);
                records.setCreateTime(new Date());
                creditAdministrativePenaltyRecordsList.add(records);
            }
            administrativePenaltyRecordsMapper.insertList(creditAdministrativePenaltyRecordsList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/15 17:18
     * @Param
     * @Deseription 央行_基本信息
     */
    public boolean addBaseInfo(String orederNum, Map<String, Object> map) throws Exception {
        if (map.size() > 0) {
            CreditBaseInfo creditBaseInfo = new CreditBaseInfo();
            creditBaseInfo.setOrderNum(orederNum);
            creditBaseInfo = baseInfoMapper.selectOne(creditBaseInfo);
            if(creditBaseInfo != null) {
                baseInfoMapper.delete(creditBaseInfo);
            }
            creditBaseInfo = new CreditBaseInfo();
            creditBaseInfo.setOrderNum(orederNum);
            creditBaseInfo.setCreateTime(new Date());
            creditBaseInfo.setIdCardNo(map.get("idCard_no") == null ? "" : map.get("idCard_no").toString());
            creditBaseInfo.setMaritalStatus(map.get("marital_status") == null ? "" : map.get("marital_status").toString());
            creditBaseInfo.setReportTime(map.get("report_time") == null ? "" : map.get("report_time").toString());
            creditBaseInfo.setUserName(map.get("user_name") == null ? "" : map.get("user_name").toString());
            creditBaseInfo.setMappingId(map.get("mapping_id") == null ? "" : map.get("mapping_id").toString());
            creditBaseInfo.setIdCardType(map.get("idCard_type") == null ? "" : map.get("idCard_type").toString());
            creditBaseInfo.setReportNo(map.get("report_no") == null ? "" : map.get("report_no").toString());
            creditBaseInfo.setQueryTime(map.get("query_time") == null ? "" : map.get("query_time").toString());
            creditBaseInfo.setUuid(UUID.randomUUID().toString());
            creditBaseInfo.setOrderNum(orederNum);
            baseInfoMapper.insert(creditBaseInfo);
        }
        return true;
    }

    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/15 17:19
     * @Param
     * @Deseription 央行_信用卡记录详细信息
     */
    public boolean addCardRecordDetailAnalyzes(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditCardRecordDetailAnalyzes analyzes = new CreditCardRecordDetailAnalyzes();
            analyzes.setOrderNum(orederNum);
            List<CreditCardRecordDetailAnalyzes> analyzesList = cardRecordDetailAnalyzesMapper.select(analyzes);
            if(analyzesList.size() > 0){
                for(CreditCardRecordDetailAnalyzes aly :analyzesList) {
                    cardRecordDetailAnalyzesMapper.delete(aly);
                }
            }
            List<CreditCardRecordDetailAnalyzes> creditCardRecordDetailAnalyzesList = new ArrayList<>();
            for (Object object : list) {
                Map<String, Object> item = (Map<String, Object>) object;
                analyzes = new CreditCardRecordDetailAnalyzes();
                analyzes.setOrderNum(orederNum);
                analyzes.setAccountCurrency(item.get("account_currency") == null ? "" : item.get("account_currency").toString());
                analyzes.setCardType(item.get("card_type") == null ? "" : item.get("card_type").toString());
                analyzes.setGrantDate(item.get("grant_date") == null ? "" : item.get("grant_date").toString());
                analyzes.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                analyzes.setBankName(item.get("bank_name") == null ? "" : item.get("bank_name").toString());
                analyzes.setCutoffDate(item.get("cutoff_date") == null ? "" : item.get("cutoff_date").toString());
                analyzes.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                analyzes.setOverdueAmount(item.get("overdue_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("overdue_amount").toString()));
                analyzes.setNintydaysOverdueNonth(item.get("nintydays_overdue_month") == null ? 0 : Integer.parseInt(item.get("nintydays_overdue_month").toString()));
                analyzes.setUsedCreditLine(item.get("used_credit_line") == null ? new BigDecimal(0) : new BigDecimal(item.get("used_credit_line").toString()));
                analyzes.setSixtydaysOverdraftNonth(item.get("sixtydays_overdraft_month") == null ? 0 : Integer.parseInt(item.get("sixtydays_overdraft_month").toString()));
                analyzes.setOverdueNonth(item.get("overdue_month") == null ? 0 : Integer.parseInt(item.get("overdue_month").toString()));
                analyzes.setOverdraftBalance(item.get("overdraft_balance") == null ? new BigDecimal(0) : new BigDecimal(item.get("overdraft_balance").toString()));
                analyzes.setCreditLimit(item.get("credit_limit") == null ? new BigDecimal(0) : new BigDecimal(item.get("credit_limit").toString()));
                analyzes.setRecordDetailAutoId(item.get("recordDetail_autoId") == null ? 0 : Integer.parseInt(item.get("recordDetail_autoId").toString()));
                analyzes.setIsNintydaysOverdue(item.get("is_nintydays_overdue") == null ? false : new Boolean(item.get("is_nintydays_overdue").toString()));
                analyzes.setIsActived(item.get("is_actived") == null ? false : new Boolean(item.get("is_actived").toString()));
                analyzes.setIsSixtydaysOverdraft(item.get("is_sixtydays_overdraft") == null ? false : new Boolean(item.get("is_sixtydays_overdraft").toString()));
                analyzes.setBadDebts(item.get("bad_debts") == null ? false : new Boolean(item.get("bad_debts").toString()));
                analyzes.setIsOverdue(item.get("is_overdue") == null ? false : new Boolean(item.get("is_overdue").toString()));
                analyzes.setIsClosed(item.get("is_closed") == null ? false : new Boolean(item.get("is_closed").toString()));
                analyzes.setRemainingSum(item.get("remaining_sum") == null ? new BigDecimal(0) : new BigDecimal(item.get("remaining_sum").toString()));
                analyzes.setUuid(UUID.randomUUID().toString());
                analyzes.setCreateTime(new Date());
                creditCardRecordDetailAnalyzesList.add(analyzes);
            }
            cardRecordDetailAnalyzesMapper.insertList(creditCardRecordDetailAnalyzesList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/15 17:21
     * @Param
     * @Deseription 央行_法院执行
     */
    public boolean addFocusRecords(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditFocusExecutionRecords records = new CreditFocusExecutionRecords();
            records.setOrderNum(orederNum);
            List<CreditFocusExecutionRecords> recordsList = focusExecutionRecordsMapper.select(records);
            if (recordsList.size()>0) {
                for(CreditFocusExecutionRecords fr :recordsList) {
                    focusExecutionRecordsMapper.delete(fr);
                }
            }

            List<CreditFocusExecutionRecords> creditFocusExecutionRecordsList = new ArrayList<>();
            for (Object object : list) {
                Map<String, Object> item = (Map<String, Object>) object;
                records = new CreditFocusExecutionRecords();
                records.setOrderNum(orederNum);
                records.setUuid(UUID.randomUUID().toString());
                records.setCreateTime(new Date());
                records.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                records.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                records.setExecutionCourt(item.get("execution_court") == null ? "" : item.get("execution_court").toString());
                records.setCaseMark(item.get("case_mark") == null ? "" : item.get("case_mark").toString());
                records.setExecutionReason(item.get("execution_reason") == null ? "" : item.get("execution_reason").toString());
                records.setCaseEndType(item.get("case_end_type") == null ? "" : item.get("case_end_type").toString());
                records.setCaseFoundDate(item.get("case_found_date") == null ? "" : item.get("case_found_date").toString());
                records.setCaseStatus(item.get("case_status") == null ? "" : item.get("case_status").toString());
                records.setApplyExecution(item.get("apply_execution") == null ? "" : item.get("apply_execution").toString());
                records.setAlreadyExecution(item.get("already_execution") == null ? "" : item.get("already_execution").toString());
                records.setApplyExcutionAmount(item.get("apply_execution_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("apply_execution_amount").toString()));
                records.setAlreadyExecutionAmount(item.get("already_execution_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("already_execution_amount").toString()));
                records.setCaseEndDate(item.get("case_end_date") == null ? "" : item.get("case_end_date").toString());
                creditFocusExecutionRecordsList.add(records);
            }
            focusExecutionRecordsMapper.insertList(creditFocusExecutionRecordsList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:48
     * @Param
     * @Deseription 央行_担保记录
     */
    public boolean addGuaranteeRecord(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditGuaranteeRecordDetailAnalyzes analyzes = new CreditGuaranteeRecordDetailAnalyzes();
            analyzes.setOrderNum(orederNum);
            List<CreditGuaranteeRecordDetailAnalyzes> analyzesList = guaranteeRecordDetailAnalyzesMapper.select(analyzes);
            if(analyzesList.size() > 0){
                for (CreditGuaranteeRecordDetailAnalyzes gd : analyzesList) {
                    guaranteeRecordDetailAnalyzesMapper.delete(gd);
                }
            }
            List<CreditGuaranteeRecordDetailAnalyzes> creditGuaranteeRecordDetailAnalyzesList = new ArrayList<>();
            for (Object object : list) {
                Map<String, Object> item = (Map<String, Object>) object;
                analyzes = new CreditGuaranteeRecordDetailAnalyzes();
                analyzes.setOrderNum(orederNum);
                analyzes.setUuid(UUID.randomUUID().toString());
                analyzes.setCreateTime(new Date());
                analyzes.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                analyzes.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                analyzes.setRecordDetailAutoId(item.get("recordDetail_autoId") == null ? 0 : Integer.parseInt(item.get("recordDetail_autoId").toString()));
                analyzes.setGuaranteeDate(item.get("gurantee_date") == null ? "" : item.get("gurantee_date").toString());
                analyzes.setWarrantee(item.get("warrantee") == null ? "" : item.get("warrantee").toString());
                analyzes.setIdType(item.get("id_type") == null ? "" : item.get("id_type").toString());
                analyzes.setIdNumber(item.get("id_number") == null ? "" : item.get("id_number").toString());
                analyzes.setLoanAmount(item.get("loan_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("loan_amount").toString()));
                analyzes.setGuaranteeAmount(item.get("gurantee_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("gurantee_amount").toString()));
                analyzes.setCuttoffDate(item.get("cuttoff_date") == null ? "" : item.get("cuttoff_date").toString());
                analyzes.setRemainBalance(item.get("remain_balance") == null ? new BigDecimal(0) : new BigDecimal(item.get("remain_balance").toString()));
                analyzes.setGuaranteeItem(item.get("guarantee_item") == null ? "" : item.get("guarantee_item").toString());
                creditGuaranteeRecordDetailAnalyzesList.add(analyzes);
            }
            guaranteeRecordDetailAnalyzesMapper.insertList(creditGuaranteeRecordDetailAnalyzesList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:49
     * @Param
     * @Deseription 央行_购房贷款记录
     */
    public boolean addBuyHouseLoanRecord(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditHousingLoanRecordDetailAnalyzes analyzes = new CreditHousingLoanRecordDetailAnalyzes();
            analyzes.setOrderNum(orederNum);
            List<CreditHousingLoanRecordDetailAnalyzes> analyzesList = housingLoanRecordDetailAnalyzesMapper.select(analyzes);
            if(analyzesList.size() > 0){
                for (CreditHousingLoanRecordDetailAnalyzes ay : analyzesList) {
                    housingLoanRecordDetailAnalyzesMapper.delete(ay);
                }
            }

            List<CreditHousingLoanRecordDetailAnalyzes> creditHousingLoanRecordDetailAnalyzesList = new ArrayList<>();
            for (Object object : list) {
                Map<String, Object> item = (Map<String, Object>) object;
                analyzes = new CreditHousingLoanRecordDetailAnalyzes();
                analyzes.setOrderNum(orederNum);
                analyzes.setUuid(UUID.randomUUID().toString());
                analyzes.setCreateTime(new Date());
                analyzes.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                analyzes.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                analyzes.setRecordDetailAutoId(item.get("recordDetail_autoId") == null ? 0 : Integer.parseInt(item.get("recordDetail_autoId").toString()));
                analyzes.setGrantDate(item.get("grant_date") == null ? "" : item.get("grant_date").toString());
                analyzes.setBankName(item.get("bank_name") == null ? "" : item.get("bank_name").toString());
                analyzes.setCurrency(item.get("currency") == null ? "" : item.get("currency").toString());
                analyzes.setLoanAmount(item.get("loan_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("loan_amount").toString()));
                analyzes.setLoanItem(item.get("loan_item") == null ? "" : item.get("loan_item").toString());
                analyzes.setExpirationDate(item.get("expiration_date") == null ? "" : item.get("expiration_date").toString());
                analyzes.setCutoffDate(item.get("cutoff_date") == null ? "" : item.get("cutoff_date").toString());
                analyzes.setIsCloseout(item.get("is_closeout") == null ? false : new Boolean(item.get("is_closeout").toString()));
                analyzes.setRemainBalance(item.get("remain_balance") == null ? new BigDecimal(0) : new BigDecimal(item.get("remain_balance").toString()));
                analyzes.setIsOverdue(item.get("is_overdue") == null ? false : new Boolean(item.get("is_overdue").toString()));
                analyzes.setOverdueMonth(item.get("overdue_month") == null ? 0 : Integer.parseInt(item.get("overdue_month").toString()));
                analyzes.setOverdueAmount(item.get("overdue_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("overdue_amount").toString()));
                analyzes.setIsNintydaysOverdue(item.get("is_nintydays_overdue") == null ? false : new Boolean(item.get("is_nintydays_overdue").toString()));
                analyzes.setNintydaysOverdueMonth(item.get("nintydays_overdue_month") == null ? 0 : Integer.parseInt(item.get("nintydays_overdue_month").toString()));
                analyzes.setTransfer(item.get("transfer") == null ? false : new Boolean(item.get("transfer").toString()));
                analyzes.setTransferDate(item.get("transfer_date") == null ? "" : item.get("transfer_date").toString());
                creditHousingLoanRecordDetailAnalyzesList.add(analyzes);
            }
            housingLoanRecordDetailAnalyzesMapper.insertList(creditHousingLoanRecordDetailAnalyzesList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:50
     * @Param
     * @Deseription 央行_其他贷款记录
     */
    public boolean addOtherLoanRecord(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditOtherLoanRecordDetailAnalyzes analyzes = new CreditOtherLoanRecordDetailAnalyzes();
            analyzes.setOrderNum(orederNum);
            List<CreditOtherLoanRecordDetailAnalyzes> analyzesList = otherLoanRecordDetailAnalyzesMapper.select(analyzes);
            if(analyzesList.size()>0){
                for(CreditOtherLoanRecordDetailAnalyzes ay : analyzesList) {
                    otherLoanRecordDetailAnalyzesMapper.delete(ay);
                }
            }
            List<CreditOtherLoanRecordDetailAnalyzes> creditOtherLoanRecordDetailAnalyzesList = new ArrayList<>();
            for (Object object : list) {
                Map<String, Object> item = (Map<String, Object>) object;
                analyzes = new CreditOtherLoanRecordDetailAnalyzes();
                analyzes.setOrderNum(orederNum);
                analyzes.setUuid(UUID.randomUUID().toString());
                analyzes.setCreateTime(new Date());
                analyzes.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                analyzes.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                analyzes.setRecordDetailAutoId(item.get("recordDetail_autoId") == null ? 0 : Integer.parseInt(item.get("recordDetail_autoId").toString()));
                analyzes.setGrantDate(item.get("grant_date") == null ? "" : item.get("grant_date").toString());
                analyzes.setCurrency(item.get("currency") == null ? "" : item.get("currency").toString());
                analyzes.setLoanAmount(item.get("loan_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("loan_amount").toString()));
                analyzes.setLoanItem(item.get("loan_item") == null ? "" : item.get("loan_item").toString());
                analyzes.setExpirationDate(item.get("expiration_date") == null ? "" : item.get("expiration_date").toString());
                analyzes.setCutoffDate(item.get("cutoff_date") == null ? "" : item.get("cutoff_date").toString());
                analyzes.setIsCloseout(item.get("is_closeout") == null ? false : new Boolean(item.get("is_closeout").toString()));
                analyzes.setRemainBalance(item.get("remain_balance") == null ? new BigDecimal(0) : new BigDecimal(item.get("remain_balance").toString()));
                analyzes.setIsOverdue(item.get("is_overdue") == null ? false : new Boolean(item.get("is_overdue").toString()));
                analyzes.setOverdueMonth(item.get("overdue_month") == null ? 0 : Integer.parseInt(item.get("overdue_month").toString()));
                analyzes.setOverdueAmount(item.get("overdue_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("overdue_amount").toString()));
                analyzes.setIsNintydaysOverdue(item.get("is_nintydays_overdue") == null ? false : new Boolean(item.get("is_nintydays_overdue").toString()));
                analyzes.setNintydaysOverdueMonth(item.get("nintydays_oversue_month") == null ? 0 : Integer.parseInt(item.get("nintydays_oversue_month").toString()));
                analyzes.setBadDebts(item.get("bad_debts") == null ? false : new Boolean(item.get("bad_debts").toString()));
                analyzes.setRemainingSum(item.get("remaining_sum") == null ? new BigDecimal(0) : new BigDecimal(Integer.parseInt(item.get("remaining_sum").toString())));
                analyzes.setFinanceCorporation(item.get("finance_corporation") == null ? "" : item.get("finance_corporation").toString());
                creditOtherLoanRecordDetailAnalyzesList.add(analyzes);
            }
            otherLoanRecordDetailAnalyzesMapper.insertList(creditOtherLoanRecordDetailAnalyzesList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:50
     * @Param
     * @Deseription 央行_电信信息
     */
    public boolean addOwedTelecomRecord(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditOwedTelecomRecords records = new CreditOwedTelecomRecords();
            records.setOrderNum(orederNum);
            List<CreditOwedTelecomRecords> recordsList = owedTelecomRecordsMapper.select(records);
            if(recordsList.size() > 0){
                for(CreditOwedTelecomRecords ot : recordsList) {
                    owedTelecomRecordsMapper.delete(ot);
                }
            }
            List<CreditOwedTelecomRecords> creditOwedTelecomRecordsList = new ArrayList<>();
            for (Object object : list) {
                Map<String, Object> item = (Map<String, Object>) object;
                records = new CreditOwedTelecomRecords();
                records.setOrderNum(orederNum);
                records.setUuid(UUID.randomUUID().toString());
                records.setCreateTime(new Date());
                records.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                records.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                records.setCarrierName(item.get("carrier_name") == null ? "" : item.get("carrier_name").toString());
                records.setBusinessType(item.get("business_type") == null ? "" : item.get("business_type").toString());
                records.setBookkeepingDate(item.get("bookkeeping_date") == null ? "" : item.get("bookkeeping_date").toString());
                records.setServiceOpenTime(item.get("service_open_time") == null ? "" : item.get("service_open_time").toString());
                records.setOwedAmount(item.get("owed_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("owed_amount").toString()));
                creditOwedTelecomRecordsList.add(records);
            }
            owedTelecomRecordsMapper.insertList(creditOwedTelecomRecordsList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:51
     * @Param
     * @Deseription 央行_查询记录
     */
    public boolean addQueryInfo(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditQueryInfoDetails queryInfoDetails = new CreditQueryInfoDetails();
            queryInfoDetails.setOrderNum(orederNum);
            List<CreditQueryInfoDetails> queryInfoDetailist = queryInfoDetailsMapper.select(queryInfoDetails);
            if(queryInfoDetailist.size() > 0){
                for(CreditQueryInfoDetails re : queryInfoDetailist) {
                    queryInfoDetailsMapper.delete(re);
                }
            }

            List<CreditQueryInfoDetails> listQueryInfoDetails = new ArrayList<>();
            for (Object obj : list) {
                Map<String, Object> item = (Map<String, Object>) obj;
                queryInfoDetails = new CreditQueryInfoDetails();
                queryInfoDetails.setOrderNum(orederNum);
                queryInfoDetails.setUuid(UUID.randomUUID().toString());
                queryInfoDetails.setCreateTime(new Date());
                queryInfoDetails.setQueryOperator(item.get("query_operator") == null ? "" : item.get("query_operator").toString());
                queryInfoDetails.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                queryInfoDetails.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                queryInfoDetails.setQueryReason(item.get("query_reason") == null ? "" : item.get("query_reason").toString());
                queryInfoDetails.setQueryDateTime(item.get("query_dateTime") == null ? "" : item.get("query_dateTime").toString());
                listQueryInfoDetails.add(queryInfoDetails);
            }
            queryInfoDetailsMapper.insertList(listQueryInfoDetails);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:51
     * @Param
     * @Deseription 央行_信贷记录
     */
    public boolean addcreditRecordDetails(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditRecordDetails recordDetails = new CreditRecordDetails();
            recordDetails.setOrderNum(orederNum);
            List<CreditRecordDetails> recordDetailsList = recordDetailsMapper.select(recordDetails);
            if(recordDetailsList.size() > 0){
                for (CreditRecordDetails re : recordDetailsList) {
                    recordDetailsMapper.delete(re);
                }
            }
            List<CreditRecordDetails> creditRecordDetailsList = new ArrayList<>();
            for (Object obj : list) {
                Map<String, Object> item = (Map<String, Object>) obj;
                CreditRecordDetails recordDetail = new CreditRecordDetails();
                recordDetail.setOrderNum(orederNum);
                recordDetail.setUuid(UUID.randomUUID().toString());
                recordDetail.setCreateTime(new Date());
                recordDetail.setAutoId(item.get("auto_id") == null ? 0 : Integer.parseInt(item.get("auto_id").toString()));
                recordDetail.setAccountType(item.get("account_type") == null ? 0 : Integer.parseInt(item.get("account_type").toString()));
                recordDetail.setCreditType(item.get("credit_type") == null ? 0 : Integer.parseInt(item.get("credit_type").toString()));
                recordDetail.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                recordDetail.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                recordDetail.setContent(item.get("content") == null ? "" : item.get("content").toString());
                creditRecordDetailsList.add(recordDetail);
            }
            recordDetailsMapper.insertList(creditRecordDetailsList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:52
     * @Param
     * @Deseription 央行_信贷汇总信息
     */
    public boolean addRecordSummaries(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditRecordSummaries record = new CreditRecordSummaries();
            record.setOrderNum(orederNum);
            List<CreditRecordSummaries> recordList = recordSummariesMapper.select(record);
            if (recordList.size()>0) {
                for (CreditRecordSummaries re : recordList) {
                    recordSummariesMapper.delete(re);
                }
            }
            List<CreditRecordSummaries> recordSummariesList = new ArrayList<>();
            for (Object obj : list) {
                Map<String, Object> item = (Map<String, Object>) obj;
                CreditRecordSummaries recordSummaries = new CreditRecordSummaries();
                recordSummaries.setOrderNum(orederNum);
                recordSummaries.setAccountNum(item.get("account_num") == null ? 0 : Integer.parseInt(item.get("account_num").toString()));
                recordSummaries.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                recordSummaries.setReportNo(item.get("guarantee") == null ? "0" : item.get("guarantee").toString());
                recordSummaries.setOverdueAccount(item.get("overdue_account") == null ? 0 : Integer.parseInt(item.get("overdue_account").toString()));
                recordSummaries.setCreditType(item.get("credit_type") == null ? 0 : Integer.parseInt(item.get("credit_type").toString()));
                recordSummaries.setOverdueNinety(item.get("overdue_ninety") == null ? 0 : Integer.parseInt(item.get("overdue_ninety").toString()));
                recordSummaries.setUnSettleUnCancel(item.get("unSettle_unCancel") == null ? 0 : Integer.parseInt(item.get("unSettle_unCancel").toString()));
                recordSummaries.setUuid(UUID.randomUUID().toString());
                recordSummaries.setCreateTime(new Date());
                recordSummariesList.add(recordSummaries);
            }
            recordSummariesMapper.insertList(recordSummariesList);
        }
        return true;
    }


    /**
     * @return
     * @Author 孔荣勋【kongrongxun@yingu.com】
     * @Date 2018/5/16 9:53
     * @Param
     * @Deseription 税务信息
     */
    public boolean addTaxOwedRecord(String orederNum, List<Object> list) throws Exception {
        if (list.size() > 0) {
            CreditTaxOwedRecords records = new CreditTaxOwedRecords();
            records.setOrderNum(orederNum);
            List<CreditTaxOwedRecords> recordsList = taxOwedRecordsMapper.select(records);
            if(recordsList.size()>0 ){
                for(CreditTaxOwedRecords ta : recordsList) {
                    taxOwedRecordsMapper.delete(ta);
                }
            }
            List<CreditTaxOwedRecords> creditTaxOwedRecordsList = new ArrayList<>();
            for (Object object : list) {
                Map<String, Object> item = (Map<String, Object>) object;
                CreditTaxOwedRecords record = new CreditTaxOwedRecords();
                record.setOrderNum(orederNum);
                record.setUuid(UUID.randomUUID().toString());
                record.setCreateTime(new Date());
                record.setMappingId(item.get("mapping_id") == null ? "" : item.get("mapping_id").toString());
                record.setReportNo(item.get("report_no") == null ? "" : item.get("report_no").toString());
                record.setOwedAmount(item.get("owed_amount") == null ? new BigDecimal(0) : new BigDecimal(item.get("owed_amount").toString()));
                record.setOwedDate(item.get("owed_date") == null ? "" : item.get("owed_date").toString());
                record.setInstitution(item.get("institution") == null ? "" : item.get("institution").toString());
                record.setDistinguishNum(item.get("distinguish_num") == null ? "" : item.get("distinguish_num").toString());
                creditTaxOwedRecordsList.add(record);
            }
            taxOwedRecordsMapper.insertList(creditTaxOwedRecordsList);
        }
        return true;
    }
}
