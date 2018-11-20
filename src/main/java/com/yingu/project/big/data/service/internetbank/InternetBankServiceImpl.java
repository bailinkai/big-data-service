package com.yingu.project.big.data.service.internetbank;

import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.common.WyStatus;
import com.yingu.project.big.data.persistence.entity.internetbank.*;
import com.yingu.project.big.data.persistence.mapper.internetbank.*;
import com.yingu.project.big.data.util.SubStringUUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
@Service
public class InternetBankServiceImpl implements InternetBankService {

    @Autowired
    InternetBankingBaseInfoMapper baseInfoMapper;
    @Autowired
    InternetBankingDepositsDetailMapper depositMapper;
    @Autowired
    InternetBankingShoppingDetailMapper shoppingMapper;
    @Autowired
    InternetBankingBillDetailMapper billMapper;
    @Autowired
    InternetBankingInstallmentDetailMapper installMapper;

    @Override
    public boolean insertList(List<Map<String, Object>> dataList, String orderNum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<InternetBankingBaseInfo> baseInfos = new ArrayList<>();
/*        List<InternetBankingDepositsDetail> depositsDetails = new ArrayList<>();*/
/*        List<InternetBankingBillDetail> billDetails = new ArrayList<>();*/
/*        List<InternetBankingInstallmentDetail> installmentDetails = new ArrayList<>();*/
 /*       List<InternetBankingShoppingDetail> shoppingDetails = new ArrayList<>();*/
        Date date = new Date();
        try {
            if (null != dataList && dataList.size() > 0 && StringUtils.isNotBlank(orderNum)) {
                InternetBankingBillDetail billDb = new InternetBankingBillDetail();
                billDb.setOrderNum(orderNum);

                billMapper.delete(billDb);

                InternetBankingInstallmentDetail installmentDb = new InternetBankingInstallmentDetail();
                installmentDb.setOrderNum(orderNum);

                installMapper.delete(installmentDb);

                InternetBankingShoppingDetail shoppingDb = new InternetBankingShoppingDetail();
                shoppingDb.setOrderNum(orderNum);

                shoppingMapper.delete(shoppingDb);

                InternetBankingDepositsDetail depositDb = new InternetBankingDepositsDetail();
                depositDb.setOrderNum(orderNum);

                depositMapper.delete(depositDb);
            }

            for (Map<String, Object> baseInfoMap : dataList) {
                InternetBankingBaseInfo baseInfo = new InternetBankingBaseInfo();
                InternetBankingBaseInfo baseInfoDb = new InternetBankingBaseInfo();
                baseInfo.setUuid(SubStringUUID.subUUID());
                baseInfo.setOrderNum(orderNum);
                baseInfo.setCardNum(baseInfoMap.get("card_num") == null ? null : baseInfoMap.get("card_num").toString());
                baseInfo.setOpenBank(baseInfoMap.get("open_bank") == null ? null : baseInfoMap.get("open_bank").toString());
                baseInfo.setBalance(baseInfoMap.get("balance") == null ? new BigDecimal(0) : new BigDecimal(baseInfoMap.get("balance").toString()));
                baseInfo.setBankId(baseInfoMap.get("bank_id") == null ? null : baseInfoMap.get("bank_id").toString());
                baseInfo.setBankName(baseInfoMap.get("bank_name") == null ? null : baseInfoMap.get("bank_name").toString());
                baseInfo.setOpenTime(baseInfoMap.get("open_time") == null ? null : baseInfoMap.get("open_time").toString());
                baseInfo.setCardId(baseInfoMap.get("card_id") == null ? null : baseInfoMap.get("card_id").toString());
                baseInfo.setFullCardNum(baseInfoMap.get("full_card_num") == null ? null : baseInfoMap.get("full_card_num").toString());
                baseInfo.setNameOnCard(baseInfoMap.get("name_on_card") == null ? null : baseInfoMap.get("name_on_card").toString());
                baseInfo.setCardType(baseInfoMap.get("card_type") == null ? null : baseInfoMap.get("card_type").toString());
                baseInfo.setCurrentBillRemainAmt(baseInfoMap.get("current_bill_remain_amt") == null ? null : new BigDecimal(baseInfoMap.get("current_bill_remain_amt").toString()));
                baseInfo.setCurrentBillRemainMinPayment(baseInfoMap.get("current_bill_remain_min_payment") == null ? null : new BigDecimal(baseInfoMap.get("current_bill_remain_min_payment").toString()));
                baseInfo.setCurrentBillPaidAmt(baseInfoMap.get("current_bill_paid_amt") == null ? null : new BigDecimal(baseInfoMap.get("current_bill_paid_amt").toString()));
                baseInfo.setCurrentBillAmt(baseInfoMap.get("current_bill_amt") == null ? null : new BigDecimal(baseInfoMap.get("current_bill_amt").toString()));
                baseInfo.setCashLimit(baseInfoMap.get("cash_limit") == null ? null : new BigDecimal(baseInfoMap.get("cash_limit").toString()));
                baseInfo.setCashBalance(baseInfoMap.get("cash_balance") == null ? null : new BigDecimal(baseInfoMap.get("cash_balance").toString()));
                baseInfo.setCreditLimit(baseInfoMap.get("credit_limit") == null ? null : new BigDecimal(baseInfoMap.get("credit_limit").toString()));
                baseInfo.setCreateTime(date);
                baseInfoDb.setOrderNum(orderNum);
                baseInfoDb.setFullCardNum(baseInfo.getFullCardNum());
                if (baseInfoMapper.selectOne(baseInfoDb) == null) {
                    baseInfos.add(baseInfo);
                    List<Map<String, Object>> deposits = baseInfoMap.get("deposits") == null ? null : (List<Map<String, Object>>) baseInfoMap.get("deposits");
                    if (deposits != null && !deposits.isEmpty()) {
                        baseInfo.setDepositsId(SubStringUUID.subUUID());
                        List<InternetBankingDepositsDetail> depositsDetails = new ArrayList<>();
                        for (Map<String, Object> depositMap : deposits) {
                            InternetBankingDepositsDetail deposit = new InternetBankingDepositsDetail();
                            deposit.setUuid(SubStringUUID.subUUID());
                            deposit.setOrderNum(orderNum);
                            deposit.setDepositsId(baseInfo.getDepositsId());
                            deposit.setDepositDate(depositMap.get("deposit_date") == null ? null : depositMap.get("deposit_date").toString());
                            deposit.setPeriod(depositMap.get("period") == null ? null : Integer.parseInt(depositMap.get("period").toString()));
                            deposit.setBalance(depositMap.get("balance") == null ? null : new BigDecimal(depositMap.get("balance").toString()));
                            deposit.setPeriodUnit(depositMap.get("period_unit") == null ? null : depositMap.get("period_unit").toString());
                            deposit.setInterest(depositMap.get("interest") == null ? null : new BigDecimal(depositMap.get("interest").toString()));
                            deposit.setCurrencyType(depositMap.get("currency_type") == null ? null : depositMap.get("currency_type").toString());
                            deposit.setDueDate(depositMap.get("due_date") == null ? null : depositMap.get("due_date").toString());
                            deposit.setDepositType(depositMap.get("deposit_type") == null ? null : depositMap.get("deposit_type").toString());
                            deposit.setCreateTime(date);
                            depositsDetails.add(deposit);
                        }
                        if (!depositsDetails.isEmpty()) {
                            depositMapper.insertList(depositsDetails);
                        }
                    }
                } else {
                    baseInfoMapper.updateByOrderNumAndFullCardNum(baseInfo);
                }
                List<Map<String, Object>> bills = baseInfoMap.get("bills") == null ? null : (List<Map<String, Object>>) baseInfoMap.get("bills");
                if (bills != null && !bills.isEmpty()) {
                    baseInfo.setBillsId(SubStringUUID.subUUID());
                    List<InternetBankingBillDetail> billDetails = new ArrayList<>();
                    for (Map<String, Object> billMap : bills) {
                        InternetBankingBillDetail bill = new InternetBankingBillDetail();
                        bill.setUuid(SubStringUUID.subUUID());
                        bill.setOrderNum(orderNum);
                        bill.setBillsId(baseInfo.getBillsId());
                        bill.setBillId(billMap.get("bill_id") == null ? null : billMap.get("bill_id").toString());
                        bill.setBillMonth(billMap.get("bill_month") == null ? null : billMap.get("bill_month").toString());
                        bill.setBankName(billMap.get("bank_name") == null ? null : billMap.get("bank_name").toString());
                        bill.setBillType(billMap.get("bill_type") == null ? null : billMap.get("bill_type").toString());
                        bill.setBillDate(billMap.get("bill_date") == null ? null : billMap.get("bill_date").toString());
                        bill.setPaymentDueDate(billMap.get("payment_due_date") == null ? null : billMap.get("payment_due_date").toString());
                        bill.setNewBalance(billMap.get("new_balance") == null ? null : new BigDecimal(billMap.get("new_balance").toString()));
                        bill.setUsdNewBalance(billMap.get("usd_new_balance") == null ? null : new BigDecimal(billMap.get("usd_new_balance").toString()));
                        bill.setMinPayment(billMap.get("min_payment") == null ? null : new BigDecimal(billMap.get("min_payment").toString()));
                        bill.setUsdMinPayment(billMap.get("usd_min_payment") == null ? null : new BigDecimal(billMap.get("usd_min_payment").toString()));
                        bill.setLastBalance(billMap.get("last_balance") == null ? null : new BigDecimal(billMap.get("last_balance").toString()));
                        bill.setUsdLastBalance(billMap.get("usd_last_balance") == null ? null : new BigDecimal(billMap.get("usd_last_balance").toString()));
                        bill.setLastPayment(billMap.get("last_payment") == null ? null : new BigDecimal(billMap.get("last_payment").toString()));
                        bill.setUsdLastPayment(billMap.get("usd_last_payment") == null ? null : new BigDecimal(billMap.get("usd_last_payment").toString()));
                        bill.setNewCharges(billMap.get("new_charges") == null ? null : new BigDecimal(billMap.get("new_charges").toString()));
                        bill.setUsdNewCharges(billMap.get("usd_new_charges") == null ? null : new BigDecimal(billMap.get("usd_new_charges").toString()));
                        bill.setInterest(billMap.get("interest") == null ? null : new BigDecimal(billMap.get("interest").toString()));
                        bill.setUsdInterest(billMap.get("usd_interest") == null ? null : new BigDecimal(billMap.get("usd_interest").toString()));
                        bill.setAdjust(billMap.get("adjust") == null ? null : new BigDecimal(billMap.get("adjust").toString()));
                        bill.setUsdAdjust(billMap.get("usd_adjust") == null ? null : new BigDecimal(billMap.get("usd_adjust").toString()));
                        bill.setCreditLimit(billMap.get("credit_limit") == null ? null : new BigDecimal(billMap.get("credit_limit").toString()));
                        bill.setUsdCreditLimit(billMap.get("usd_credit_limit") == null ? null : new BigDecimal(billMap.get("usd_credit_limit").toString()));
                        bill.setCashLimit(billMap.get("cash_limit") == null ? null : new BigDecimal(billMap.get("cash_limit").toString()));
                        bill.setUsdCashLimit(billMap.get("usd_cash_limit") == null ? null : new BigDecimal(billMap.get("usd_cash_limit").toString()));
                        bill.setCreateTime(date);
                        billDetails.add(bill);

                        List<Map<String, Object>> installments = billMap.get("installments") == null ? null : (List<Map<String, Object>>) billMap.get("installments");
                        if (installments != null && !installments.isEmpty()) {
                            bill.setInstallmentsId(SubStringUUID.subUUID());
                            List<InternetBankingInstallmentDetail> installmentDetails = new ArrayList<>();
                            for (Map<String, Object> installmentMap : installments) {
                                InternetBankingInstallmentDetail installment = new InternetBankingInstallmentDetail();
                                installment.setUuid(SubStringUUID.subUUID());
                                installment.setOrderNum(orderNum);
                                installment.setInstallmentsId(bill.getInstallmentsId());
                                installment.setShoppingsheetId(installmentMap.get("shoppingsheet_id") == null ? null : installmentMap.get("shoppingsheet_id").toString());
                                installment.setInstallmentDesc(installmentMap.get("installment_desc") == null ? null : installmentMap.get("installment_desc").toString());
                                installment.setTransDate(installmentMap.get("trans_date") == null ? null : sdf.parse(installmentMap.get("trans_date").toString()));
                                installment.setCurrencyType(installmentMap.get("currency_type") == null ? null : installmentMap.get("currency_type").toString());
                                installment.setPostDate(installmentMap.get("post_date") == null ? null : installmentMap.get("post_date").toString());
                                installment.setCurrentMonth(installmentMap.get("current_month") == null ? null : Short.parseShort(installmentMap.get("current_month").toString()));
                                installment.setAmountMoney(installmentMap.get("amount_money") == null ? null : new BigDecimal(installmentMap.get("amount_money").toString()));
                                installment.setTotalMonth(installmentMap.get("total_month") == null ? null : Short.parseShort(installmentMap.get("total_month").toString()));
                                installment.setInstallmentType(installmentMap.get("installment_type") == null ? null : installmentMap.get("installment_type").toString());
                                installment.setHandingFee(installmentMap.get("handing_fee") == null ? null : new BigDecimal(installmentMap.get("handing_fee").toString()));
                                installment.setTransferFee(installmentMap.get("transfer_fee") == null ? null : new BigDecimal(installmentMap.get("transfer_fee").toString()));
                                installment.setTransferfeeDesc(installmentMap.get("transferfee_desc") == null ? null : installmentMap.get("transferfee_desc").toString());
                                installment.setHandingfeeDesc(installmentMap.get("handingfee_desc") == null ? null : installmentMap.get("handingfee_desc").toString());
                                installment.setCreateTime(date);
                                installmentDetails.add(installment);
                            }
                            if (!installmentDetails.isEmpty()) {
                                installMapper.insertList(installmentDetails);
                            }
                        }

                        List<Map<String, Object>> shoppingSheets = billMap.get("shopping_sheets") == null ? null : (List<Map<String, Object>>) billMap.get("shopping_sheets");
                        if (shoppingSheets != null && !shoppingSheets.isEmpty()) {
                            bill.setShoppingSheetsId(SubStringUUID.subUUID());
                            List<InternetBankingShoppingDetail> shoppingDetails = new ArrayList<>();
                            for (Map<String, Object> shoppingSheetMap : shoppingSheets) {
                                InternetBankingShoppingDetail shopping = new InternetBankingShoppingDetail();
                                shopping.setUuid(SubStringUUID.subUUID());
                                shopping.setOrderNum(orderNum);
                                shopping.setShoppingSheetsId(bill.getShoppingSheetsId());
                                shopping.setShoppingsheetId(shoppingSheetMap.get("id") == null ? null : shoppingSheetMap.get("id").toString());
                                shopping.setTransDate(shoppingSheetMap.get("trans_date") == null ? null : sdf.parse(shoppingSheetMap.get("trans_date").toString()));
                                shopping.setTransChannel(shoppingSheetMap.get("trans_channel") == null ? null : shoppingSheetMap.get("trans_channel").toString());
                                shopping.setOppositeBank(shoppingSheetMap.get("opposite_bank") == null ? null : shoppingSheetMap.get("opposite_bank").toString());
                                shopping.setDescription(shoppingSheetMap.get("description") == null ? null : shoppingSheetMap.get("description").toString());
                                shopping.setRemark(shoppingSheetMap.get("remark") == null ? null : shoppingSheetMap.get("remark").toString());
                                shopping.setAmountMoney(shoppingSheetMap.get("amount_money") == null ? null : new BigDecimal(shoppingSheetMap.get("amount_money").toString()));
                                shopping.setOrderIndex(shoppingSheetMap.get("order_index") == null ? null : Integer.parseInt(shoppingSheetMap.get("order_index").toString()));
                                shopping.setTransAddr(shoppingSheetMap.get("trans_addr") == null ? null : shoppingSheetMap.get("trans_addr").toString());
                                shopping.setCardNum(shoppingSheetMap.get("card_num") == null ? null : shoppingSheetMap.get("card_num").toString());
                                shopping.setOppositeCardNo(shoppingSheetMap.get("opposite_card_no") == null ? null : shoppingSheetMap.get("opposite_card_no").toString());
                                shopping.setBalance(shoppingSheetMap.get("balance") == null ? null : new BigDecimal(shoppingSheetMap.get("balance").toString()));
                                shopping.setCurrencyType(shoppingSheetMap.get("currency_type") == null ? null : shoppingSheetMap.get("currency_type").toString());
                                shopping.setPostDate(shoppingSheetMap.get("post_date") == null ? null : shoppingSheetMap.get("post_date").toString());
                                shopping.setTransMethod(shoppingSheetMap.get("trans_method") == null ? null : shoppingSheetMap.get("trans_method").toString());
                                shopping.setCategory(shoppingSheetMap.get("category") == null ? null : shoppingSheetMap.get("category").toString());
                                shopping.setNameOnOppositeCard(shoppingSheetMap.get("name_on_opposite_card") == null ? null : shoppingSheetMap.get("name_on_opposite_card").toString());
                                shopping.setCreateTime(new Date());
                                shoppingDetails.add(shopping);
                            }
                            if (!shoppingDetails.isEmpty()) {
                                shoppingMapper.insertList(shoppingDetails);
                            }
                        }
                    }
                    if (!billDetails.isEmpty()) {
                        billMapper.insertList(billDetails);
                    }
                }
            }

            if (!baseInfos.isEmpty()) {
                baseInfoMapper.insertList(baseInfos);
            }
/*            if (!billDetails.isEmpty()) {
                billMapper.insertList(billDetails);
            }*/
/*            if (!depositsDetails.isEmpty()) {
                depositMapper.insertList(depositsDetails);
            }*/
/*            if (!shoppingDetails.isEmpty()) {
                shoppingMapper.insertList(shoppingDetails);
            }*/
/*            if (!installmentDetails.isEmpty()) {
                installMapper.insertList(installmentDetails);
            }*/
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ResponseResult getDataByOrderNum(Map<String, Object> map) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<InternetBankingBaseInfo> baseInfos = baseInfoMapper.selectByOrderNum(map);
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> bankCards = new ArrayList<>();
        for (InternetBankingBaseInfo baseInfo : baseInfos) {
            List<Map<String, Object>> deposits = new ArrayList<>();
            List<Map<String, Object>> shoppings = new ArrayList<>();
            List<Map<String, Object>> monthList = new ArrayList<>();
            Map<String, Object> bankCard = new HashMap<>();
            bankCard.put("bank_name", baseInfo.getBankName());
            bankCard.put("name_on_card", baseInfo.getNameOnCard());
            bankCard.put("full_card_num", this.subString(baseInfo.getFullCardNum()));
            bankCard.put("balance", baseInfo.getBalance());
            bankCard.put("open_time", baseInfo.getOpenTime() == null ? "未知" : baseInfo.getOpenTime());
            if ("借记卡".equals(baseInfo.getCardType())) {
                bankCard.put("card_type", baseInfo.getCardType());
                bankCard.put("open_bank", baseInfo.getOpenBank() == null ? baseInfo.getBankName() : baseInfo.getOpenBank());
                map.put("deposits_id", baseInfo.getDepositsId());
                List<InternetBankingDepositsDetail> depositsDetails = depositMapper.selectByDepositsId(map);
                for (InternetBankingDepositsDetail depositsDetail : depositsDetails) {
                    Map<String, Object> deposit = new HashMap<>();
                    deposit.put("deposit_type", depositsDetail.getDepositType());
                    deposit.put("balance", depositsDetail.getBalance());
                    deposit.put("period", depositsDetail.getPeriod());
                    deposit.put("period_unit", depositsDetail.getPeriodUnit());
                    deposit.put("deposit_date", depositsDetail.getDepositDate());
                    deposit.put("due_date", depositsDetail.getDepositDate());
                    deposits.add(deposit);
                }
                map.put("bills_id", baseInfo.getBillsId());
                List<InternetBankingShoppingDetail> shoppingDetails = shoppingMapper.selectByBillsId(map);
                for (InternetBankingShoppingDetail shoppingDetail : shoppingDetails) {
                    Map<String, Object> shopping = new HashMap<>();
                    shopping.put("card_num", shoppingDetail.getCardNum());
                    shopping.put("post_date", shoppingDetail.getPostDate());
                    shopping.put("trans_date", sdf.format(shoppingDetail.getTransDate()));
                    shopping.put("trans_addr", shoppingDetail.getTransAddr());
                    shopping.put("trans_method", shoppingDetail.getTransMethod());
                    shopping.put("currency_type", WyStatus.getWyStatus(shoppingDetail.getCurrencyType()).getMessage());
                    shopping.put("category", shoppingDetail.getCategory() + WyStatus.getWyStatus(shoppingDetail.getCategory()).getMessage());
                    shopping.put("income_money", WyStatus.CATEGORY_TRANSFER.getCode().equals(shoppingDetail.getCategory()) ? (shoppingDetail.getAmountMoney().compareTo(BigDecimal.ZERO) > 0 ? "" :
                            shoppingDetail.getAmountMoney().abs()) : WyStatus.getWyStatus(shoppingDetail.getCategory()).getBool() ? shoppingDetail.getAmountMoney().abs() : "");
                    shopping.put("pay_money", WyStatus.CATEGORY_TRANSFER.getCode().equals(shoppingDetail.getCategory()) ? (shoppingDetail.getAmountMoney().compareTo(BigDecimal.ZERO) < 0 ? "" :
                            shoppingDetail.getAmountMoney()) : WyStatus.getWyStatus(shoppingDetail.getCategory()).getBool() ? "" : shoppingDetail.getAmountMoney());
                    shopping.put("balance", shoppingDetail.getBalance());
                    shopping.put("opposite_card_no", shoppingDetail.getOppositeCardNo());
                    shopping.put("name_on_opposite_card", shoppingDetail.getNameOnOppositeCard());
                    shopping.put("opposite_bank", shoppingDetail.getOppositeBank());
                    shopping.put("remark", shoppingDetail.getRemark());
                    shopping.put("description", shoppingDetail.getDescription());
                    shoppings.add(shopping);
                }
            } else {
                bankCard.put("cash_balance", baseInfo.getCashBalance());
                bankCard.put("card_type", "贷记卡");
                map.put("bills_id", baseInfo.getBillsId());
                Calendar cal = Calendar.getInstance();
                for (int i = 1; i < 14; i++) {
                    map = this.setParam(map, cal, i);
                    Map<String, Object> monthMap = new HashMap<>();
                    List<Map<String, Object>> billList = new ArrayList<>();
                    List<Map<String, Object>> shoppingList = new ArrayList<>();
                    List<Map<String, Object>> installmentList = new ArrayList<>();
                    List<InternetBankingBillDetail> billDetails = billMapper.selectByOrderNumAndTime(map);
                    for (InternetBankingBillDetail billDetail : billDetails) {
                        Map<String, Object> bill = new HashMap<>();
                        bill.put("card_num", baseInfo.getCardNum());
                        bill.put("bank_name", billDetail.getBankName());
                        bill.put("bill_type", WyStatus.getWyStatus(billDetail.getBillType()).getMessage());
                        bill.put("bill_month", billDetail.getBillMonth());
                        bill.put("bill_date", billDetail.getBillDate());
                        bill.put("payment_due_date", billDetail.getPaymentDueDate());
                        bill.put("new_balance", billDetail.getNewBalance() == null ? 0 : billDetail.getNewBalance());
                        bill.put("usd_new_balance", billDetail.getUsdNewBalance() == null ? 0 : billDetail.getUsdNewBalance());
                        bill.put("min_payment", billDetail.getMinPayment() == null ? 0 : billDetail.getMinPayment());
                        bill.put("usd_min_payment", billDetail.getUsdMinPayment() == null ? 0 : billDetail.getUsdMinPayment());
                        billList.add(bill);
                        map.put("shopping_sheets_id", billDetail.getShoppingSheetsId());
                        List<InternetBankingShoppingDetail> shoppingDetails = shoppingMapper.selectByShoppingSheetsId(map);
                        for (InternetBankingShoppingDetail shoppingDetail : shoppingDetails) {
                            Map<String, Object> shopping = new HashMap<>();
                            shopping.put("card_num", shoppingDetail.getCardNum());
                            shopping.put("post_date", shoppingDetail.getPostDate());
                            shopping.put("trans_date", sdf.format(shoppingDetail.getTransDate()));
                            shopping.put("category", shoppingDetail.getCategory() + WyStatus.getWyStatus(shoppingDetail.getCategory()).getMessage());
                            shopping.put("currency_type", WyStatus.getWyStatus(shoppingDetail.getCurrencyType()).getMessage());
                            shopping.put("amount_money", shoppingDetail.getAmountMoney());
                            shopping.put("remark", shoppingDetail.getRemark());
                            shopping.put("description", shoppingDetail.getDescription());
                            shoppingList.add(shopping);
                        }
                        map.put("installments_id", billDetail.getInstallmentsId());
                        List<InternetBankingInstallmentDetail> installmentDetails = installMapper.selectByInstallmentsId(map);
                        for (InternetBankingInstallmentDetail installmentDetail : installmentDetails) {
                            Map<String, Object> installment = new HashMap<>();
                            installment.put("installment_desc", installmentDetail.getInstallmentDesc());
                            installment.put("trans_date", sdf.format(installmentDetail.getTransDate()));
                            installment.put("post_date", installmentDetail.getPostDate());
                            installment.put("currency_type", WyStatus.getWyStatus(installmentDetail.getCurrencyType()).getMessage());
                            installment.put("amount_money", installmentDetail.getAmountMoney());
                            installment.put("total_month", installmentDetail.getTotalMonth());
                            installment.put("current_month", installmentDetail.getCurrentMonth());
                            installment.put("installment_type", WyStatus.getWyStatus(installmentDetail.getInstallmentType()).getMessage());
                            installmentList.add(installment);
                        }
                    }
                    monthMap.put("shoppings", shoppingList);
                    monthMap.put("bills", billList);
                    monthMap.put("installments", installmentList);
                    monthMap.put("title", "近" + i + "个月");
                    monthList.add(monthMap);
                }
            }
            bankCard.put("deposits", deposits);
            bankCard.put("shoppings", shoppings);
            bankCard.put("months", monthList);
            bankCards.add(bankCard);
        }
        result.put("list", bankCards);
        return ResponseResult.ok(result);
    }

    private String subString(String fullCardNum) {
        if (StringUtils.isNotBlank(fullCardNum)) {
            return fullCardNum.substring(0, 4) + "****" + fullCardNum.substring(fullCardNum.length() - 4, fullCardNum.length());
        } else {
            return fullCardNum;
        }
    }

    private Map<String, Object> setParam(Map<String, Object> map, Calendar cal, int i) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        cal.add(Calendar.MONTH, -i);
        map.put("startTime", sdf.format(cal.getTime()));
        cal.add(Calendar.MONTH, 1);
        map.put("endTime", sdf.format(cal.getTime()));
        return map;
    }
}
