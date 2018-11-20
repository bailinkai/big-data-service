package com.yingu.project.big.data.persistence.entity.internetbank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "internet_banking_bill_detail")
public class InternetBankingBillDetail {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 订单编号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 账单ID(外键)
     */
    @Column(name = "bills_id")
    private String billsId;

    /**
     * 账单ID
     */
    @Column(name = "bill_id")
    private String billId;

    /**
     * 账单类型. DONE-已出账单;UNDONE-未出账单
     */
    @Column(name = "bill_type")
    private String billType;

    /**
     * 银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 账单月份
     */
    @Column(name = "bill_month")
    private String billMonth;

    /**
     * 账单日
     */
    @Column(name = "bill_date")
    private String billDate;

    /**
     * 还款日
     */
    @Column(name = "payment_due_date")
    private String paymentDueDate;

    /**
     * 本期账单金额
     */
    @Column(name = "new_balance")
    private BigDecimal newBalance;

    /**
     * 本期账单金额-美元
     */
    @Column(name = "usd_new_balance")
    private BigDecimal usdNewBalance;

    /**
     * 最低还款额
     */
    @Column(name = "min_payment")
    private BigDecimal minPayment;

    /**
     * 最低还款额-美元
     */
    @Column(name = "usd_min_payment")
    private BigDecimal usdMinPayment;

    /**
     * 上期账单金额
     */
    @Column(name = "last_balance")
    private BigDecimal lastBalance;

    /**
     * 上期账单金额-美元
     */
    @Column(name = "usd_last_balance")
    private BigDecimal usdLastBalance;

    /**
     * 上期还款金额
     */
    @Column(name = "last_payment")
    private BigDecimal lastPayment;

    /**
     * 上期还款金额-美元
     */
    @Column(name = "usd_last_payment")
    private BigDecimal usdLastPayment;

    /**
     * 本期新增款额(算一个账单的周期)
     */
    @Column(name = "new_charges")
    private BigDecimal newCharges;

    /**
     * 本期新增款额-美元(算一个账单的周期)
     */
    @Column(name = "usd_new_charges")
    private BigDecimal usdNewCharges;

    /**
     * 循环利息
     */
    private BigDecimal interest;

    /**
     * 循环利息-美元
     */
    @Column(name = "usd_interest")
    private BigDecimal usdInterest;

    /**
     * 调整金额
     */
    private BigDecimal adjust;

    /**
     * 调整金额-美元
     */
    @Column(name = "usd_adjust")
    private BigDecimal usdAdjust;

    /**
     * 信用卡额度
     */
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    /**
     * 信用卡额度-美元
     */
    @Column(name = "usd_credit_limit")
    private BigDecimal usdCreditLimit;

    /**
     * 预借现金额度
     */
    @Column(name = "cash_limit")
    private BigDecimal cashLimit;

    /**
     * 预借现金额度-美元
     */
    @Column(name = "usd_cash_limit")
    private BigDecimal usdCashLimit;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 消费记录ID(外键)
     */
    @Column(name = "shopping_sheets_id")
    private String shoppingSheetsId;

    /**
     * 分期ID(外键)
     */
    @Column(name = "installments_id")
    private String installmentsId;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取uuid
     *
     * @return uuid - uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置uuid
     *
     * @param uuid uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取订单编号
     *
     * @return order_num - 订单编号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单编号
     *
     * @param orderNum 订单编号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取账单ID(外键)
     *
     * @return bills_id - 账单ID(外键)
     */
    public String getBillsId() {
        return billsId;
    }

    /**
     * 设置账单ID(外键)
     *
     * @param billsId 账单ID(外键)
     */
    public void setBillsId(String billsId) {
        this.billsId = billsId;
    }

    /**
     * 获取账单ID
     *
     * @return bill_id - 账单ID
     */
    public String getBillId() {
        return billId;
    }

    /**
     * 设置账单ID
     *
     * @param billId 账单ID
     */
    public void setBillId(String billId) {
        this.billId = billId;
    }

    /**
     * 获取账单类型. DONE-已出账单;UNDONE-未出账单
     *
     * @return bill_type - 账单类型. DONE-已出账单;UNDONE-未出账单
     */
    public String getBillType() {
        return billType;
    }

    /**
     * 设置账单类型. DONE-已出账单;UNDONE-未出账单
     *
     * @param billType 账单类型. DONE-已出账单;UNDONE-未出账单
     */
    public void setBillType(String billType) {
        this.billType = billType;
    }

    /**
     * 获取银行名称
     *
     * @return bank_name - 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行名称
     *
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取账单月份
     *
     * @return bill_month - 账单月份
     */
    public String getBillMonth() {
        return billMonth;
    }

    /**
     * 设置账单月份
     *
     * @param billMonth 账单月份
     */
    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    /**
     * 获取账单日
     *
     * @return bill_date - 账单日
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * 设置账单日
     *
     * @param billDate 账单日
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    /**
     * 获取还款日
     *
     * @return payment_due_date - 还款日
     */
    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * 设置还款日
     *
     * @param paymentDueDate 还款日
     */
    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    /**
     * 获取本期账单金额
     *
     * @return new_balance - 本期账单金额
     */
    public BigDecimal getNewBalance() {
        return newBalance;
    }

    /**
     * 设置本期账单金额
     *
     * @param newBalance 本期账单金额
     */
    public void setNewBalance(BigDecimal newBalance) {
        this.newBalance = newBalance;
    }

    /**
     * 获取本期账单金额-美元
     *
     * @return usd_new_balance - 本期账单金额-美元
     */
    public BigDecimal getUsdNewBalance() {
        return usdNewBalance;
    }

    /**
     * 设置本期账单金额-美元
     *
     * @param usdNewBalance 本期账单金额-美元
     */
    public void setUsdNewBalance(BigDecimal usdNewBalance) {
        this.usdNewBalance = usdNewBalance;
    }

    /**
     * 获取最低还款额
     *
     * @return min_payment - 最低还款额
     */
    public BigDecimal getMinPayment() {
        return minPayment;
    }

    /**
     * 设置最低还款额
     *
     * @param minPayment 最低还款额
     */
    public void setMinPayment(BigDecimal minPayment) {
        this.minPayment = minPayment;
    }

    /**
     * 获取最低还款额-美元
     *
     * @return usd_min_payment - 最低还款额-美元
     */
    public BigDecimal getUsdMinPayment() {
        return usdMinPayment;
    }

    /**
     * 设置最低还款额-美元
     *
     * @param usdMinPayment 最低还款额-美元
     */
    public void setUsdMinPayment(BigDecimal usdMinPayment) {
        this.usdMinPayment = usdMinPayment;
    }

    /**
     * 获取上期账单金额
     *
     * @return last_balance - 上期账单金额
     */
    public BigDecimal getLastBalance() {
        return lastBalance;
    }

    /**
     * 设置上期账单金额
     *
     * @param lastBalance 上期账单金额
     */
    public void setLastBalance(BigDecimal lastBalance) {
        this.lastBalance = lastBalance;
    }

    /**
     * 获取上期账单金额-美元
     *
     * @return usd_last_balance - 上期账单金额-美元
     */
    public BigDecimal getUsdLastBalance() {
        return usdLastBalance;
    }

    /**
     * 设置上期账单金额-美元
     *
     * @param usdLastBalance 上期账单金额-美元
     */
    public void setUsdLastBalance(BigDecimal usdLastBalance) {
        this.usdLastBalance = usdLastBalance;
    }

    /**
     * 获取上期还款金额
     *
     * @return last_payment - 上期还款金额
     */
    public BigDecimal getLastPayment() {
        return lastPayment;
    }

    /**
     * 设置上期还款金额
     *
     * @param lastPayment 上期还款金额
     */
    public void setLastPayment(BigDecimal lastPayment) {
        this.lastPayment = lastPayment;
    }

    /**
     * 获取上期还款金额-美元
     *
     * @return usd_last_payment - 上期还款金额-美元
     */
    public BigDecimal getUsdLastPayment() {
        return usdLastPayment;
    }

    /**
     * 设置上期还款金额-美元
     *
     * @param usdLastPayment 上期还款金额-美元
     */
    public void setUsdLastPayment(BigDecimal usdLastPayment) {
        this.usdLastPayment = usdLastPayment;
    }

    /**
     * 获取本期新增款额(算一个账单的周期)
     *
     * @return new_charges - 本期新增款额(算一个账单的周期)
     */
    public BigDecimal getNewCharges() {
        return newCharges;
    }

    /**
     * 设置本期新增款额(算一个账单的周期)
     *
     * @param newCharges 本期新增款额(算一个账单的周期)
     */
    public void setNewCharges(BigDecimal newCharges) {
        this.newCharges = newCharges;
    }

    /**
     * 获取本期新增款额-美元(算一个账单的周期)
     *
     * @return usd_new_charges - 本期新增款额-美元(算一个账单的周期)
     */
    public BigDecimal getUsdNewCharges() {
        return usdNewCharges;
    }

    /**
     * 设置本期新增款额-美元(算一个账单的周期)
     *
     * @param usdNewCharges 本期新增款额-美元(算一个账单的周期)
     */
    public void setUsdNewCharges(BigDecimal usdNewCharges) {
        this.usdNewCharges = usdNewCharges;
    }

    /**
     * 获取循环利息
     *
     * @return interest - 循环利息
     */
    public BigDecimal getInterest() {
        return interest;
    }

    /**
     * 设置循环利息
     *
     * @param interest 循环利息
     */
    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    /**
     * 获取循环利息-美元
     *
     * @return usd_interest - 循环利息-美元
     */
    public BigDecimal getUsdInterest() {
        return usdInterest;
    }

    /**
     * 设置循环利息-美元
     *
     * @param usdInterest 循环利息-美元
     */
    public void setUsdInterest(BigDecimal usdInterest) {
        this.usdInterest = usdInterest;
    }

    /**
     * 获取调整金额
     *
     * @return adjust - 调整金额
     */
    public BigDecimal getAdjust() {
        return adjust;
    }

    /**
     * 设置调整金额
     *
     * @param adjust 调整金额
     */
    public void setAdjust(BigDecimal adjust) {
        this.adjust = adjust;
    }

    /**
     * 获取调整金额-美元
     *
     * @return usd_adjust - 调整金额-美元
     */
    public BigDecimal getUsdAdjust() {
        return usdAdjust;
    }

    /**
     * 设置调整金额-美元
     *
     * @param usdAdjust 调整金额-美元
     */
    public void setUsdAdjust(BigDecimal usdAdjust) {
        this.usdAdjust = usdAdjust;
    }

    /**
     * 获取信用卡额度
     *
     * @return credit_limit - 信用卡额度
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * 设置信用卡额度
     *
     * @param creditLimit 信用卡额度
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * 获取信用卡额度-美元
     *
     * @return usd_credit_limit - 信用卡额度-美元
     */
    public BigDecimal getUsdCreditLimit() {
        return usdCreditLimit;
    }

    /**
     * 设置信用卡额度-美元
     *
     * @param usdCreditLimit 信用卡额度-美元
     */
    public void setUsdCreditLimit(BigDecimal usdCreditLimit) {
        this.usdCreditLimit = usdCreditLimit;
    }

    /**
     * 获取预借现金额度
     *
     * @return cash_limit - 预借现金额度
     */
    public BigDecimal getCashLimit() {
        return cashLimit;
    }

    /**
     * 设置预借现金额度
     *
     * @param cashLimit 预借现金额度
     */
    public void setCashLimit(BigDecimal cashLimit) {
        this.cashLimit = cashLimit;
    }

    /**
     * 获取预借现金额度-美元
     *
     * @return usd_cash_limit - 预借现金额度-美元
     */
    public BigDecimal getUsdCashLimit() {
        return usdCashLimit;
    }

    /**
     * 设置预借现金额度-美元
     *
     * @param usdCashLimit 预借现金额度-美元
     */
    public void setUsdCashLimit(BigDecimal usdCashLimit) {
        this.usdCashLimit = usdCashLimit;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取消费记录ID(外键)
     *
     * @return shopping_sheets_id - 消费记录ID(外键)
     */
    public String getShoppingSheetsId() {
        return shoppingSheetsId;
    }

    /**
     * 设置消费记录ID(外键)
     *
     * @param shoppingSheetsId 消费记录ID(外键)
     */
    public void setShoppingSheetsId(String shoppingSheetsId) {
        this.shoppingSheetsId = shoppingSheetsId;
    }

    /**
     * 获取分期ID(外键)
     *
     * @return installments_id - 分期ID(外键)
     */
    public String getInstallmentsId() {
        return installmentsId;
    }

    /**
     * 设置分期ID(外键)
     *
     * @param installmentsId 分期ID(外键)
     */
    public void setInstallmentsId(String installmentsId) {
        this.installmentsId = installmentsId;
    }
}