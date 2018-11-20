package com.yingu.project.big.data.service.impl;

import com.yingu.project.big.data.common.ResponseResult;
import com.yingu.project.big.data.common.WyStatus;
import com.yingu.project.big.data.persistence.entity.internetbank.*;
import com.yingu.project.big.data.persistence.mapper.internetbank.*;
import com.yingu.project.big.data.service.InternetBankService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
