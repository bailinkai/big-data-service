package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_payment_detail")
public class BxdPaymentDetail {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 保险单uuid
     */
    private String uuid;

    /**
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 外键
     */
    @Column(name = "details_id")
    private String detailsId;

    /**
     * 期交保费
     */
    @Column(name = "pay_amt")
    private String payAmt;

    /**
     * 保单开始日期
     */
    @Column(name = "policy_start_date")
    private String policyStartDate;

    /**
     * 保单终止日期
     */
    @Column(name = "end_date")
    private String endDate;

    /**
     * 首期缴费日期
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * 交至日期
     */
    @Column(name = "pay_end_date")
    private String payEndDate;

    /**
     * 保险金额
     */
    @Column(name = "insurance_amt")
    private String insuranceAmt;

    /**
     * 总保费
     */
    @Column(name = "insurance_premium")
    private String insurancePremium;

    /**
     * 下次缴费日期
     */
    @Column(name = "next_pay_date")
    private String nextPayDate;

    /**
     * 需交费次数
     */
    @Column(name = "pay_need_times")
    private String payNeedTimes;

    /**
     * 已交费次数
     */
    @Column(name = "pay_had_times")
    private String payHadTimes;

    /**
     * 交费年限
     */
    @Column(name = "pay_period")
    private String payPeriod;

    /**
     * 交费方式类型
     */
    @Column(name = "payment_type")
    private String paymentType;

    /**
     * 交费银行
     */
    @Column(name = "payment_bank")
    private String paymentBank;

    /**
     * 交费账号
     */
    @Column(name = "payment_account")
    private String paymentAccount;

    /**
     * 交费频率
     */
    @Column(name = "payment_frequency")
    private String paymentFrequency;

    /**
     * 应交日期
     */
    @Column(name = "payment_date_payable")
    private String paymentDatePayable;

    /**
     * 扣款日期
     */
    @Column(name = "payment_date_charge")
    private String paymentDateCharge;

    /**
     * 当期应交保费
     */
    @Column(name = "payment_premium_payable")
    private String paymentPremiumPayable;

    /**
     * 当期实交保费
     */
    @Column(name = "payment_premium_charge")
    private String paymentPremiumCharge;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取保险单uuid
     *
     * @return uuid - 保险单uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置保险单uuid
     *
     * @param uuid 保险单uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取订单号
     *
     * @return order_num - 订单号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单号
     *
     * @param orderNum 订单号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取外键
     *
     * @return details_id - 外键
     */
    public String getDetailsId() {
        return detailsId;
    }

    /**
     * 设置外键
     *
     * @param detailsId 外键
     */
    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    /**
     * 获取期交保费
     *
     * @return pay_amt - 期交保费
     */
    public String getPayAmt() {
        return payAmt;
    }

    /**
     * 设置期交保费
     *
     * @param payAmt 期交保费
     */
    public void setPayAmt(String payAmt) {
        this.payAmt = payAmt;
    }

    /**
     * 获取保单开始日期
     *
     * @return policy_start_date - 保单开始日期
     */
    public String getPolicyStartDate() {
        return policyStartDate;
    }

    /**
     * 设置保单开始日期
     *
     * @param policyStartDate 保单开始日期
     */
    public void setPolicyStartDate(String policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    /**
     * 获取保单终止日期
     *
     * @return end_date - 保单终止日期
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置保单终止日期
     *
     * @param endDate 保单终止日期
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取首期缴费日期
     *
     * @return start_date - 首期缴费日期
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置首期缴费日期
     *
     * @param startDate 首期缴费日期
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取交至日期
     *
     * @return pay_end_date - 交至日期
     */
    public String getPayEndDate() {
        return payEndDate;
    }

    /**
     * 设置交至日期
     *
     * @param payEndDate 交至日期
     */
    public void setPayEndDate(String payEndDate) {
        this.payEndDate = payEndDate;
    }

    /**
     * 获取保险金额
     *
     * @return insurance_amt - 保险金额
     */
    public String getInsuranceAmt() {
        return insuranceAmt;
    }

    /**
     * 设置保险金额
     *
     * @param insuranceAmt 保险金额
     */
    public void setInsuranceAmt(String insuranceAmt) {
        this.insuranceAmt = insuranceAmt;
    }

    /**
     * 获取总保费
     *
     * @return insurance_premium - 总保费
     */
    public String getInsurancePremium() {
        return insurancePremium;
    }

    /**
     * 设置总保费
     *
     * @param insurancePremium 总保费
     */
    public void setInsurancePremium(String insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    /**
     * 获取下次缴费日期
     *
     * @return next_pay_date - 下次缴费日期
     */
    public String getNextPayDate() {
        return nextPayDate;
    }

    /**
     * 设置下次缴费日期
     *
     * @param nextPayDate 下次缴费日期
     */
    public void setNextPayDate(String nextPayDate) {
        this.nextPayDate = nextPayDate;
    }

    /**
     * 获取需交费次数
     *
     * @return pay_need_times - 需交费次数
     */
    public String getPayNeedTimes() {
        return payNeedTimes;
    }

    /**
     * 设置需交费次数
     *
     * @param payNeedTimes 需交费次数
     */
    public void setPayNeedTimes(String payNeedTimes) {
        this.payNeedTimes = payNeedTimes;
    }

    /**
     * 获取已交费次数
     *
     * @return pay_had_times - 已交费次数
     */
    public String getPayHadTimes() {
        return payHadTimes;
    }

    /**
     * 设置已交费次数
     *
     * @param payHadTimes 已交费次数
     */
    public void setPayHadTimes(String payHadTimes) {
        this.payHadTimes = payHadTimes;
    }

    /**
     * 获取交费年限
     *
     * @return pay_period - 交费年限
     */
    public String getPayPeriod() {
        return payPeriod;
    }

    /**
     * 设置交费年限
     *
     * @param payPeriod 交费年限
     */
    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    /**
     * 获取交费方式类型
     *
     * @return payment_type - 交费方式类型
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 设置交费方式类型
     *
     * @param paymentType 交费方式类型
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取交费银行
     *
     * @return payment_bank - 交费银行
     */
    public String getPaymentBank() {
        return paymentBank;
    }

    /**
     * 设置交费银行
     *
     * @param paymentBank 交费银行
     */
    public void setPaymentBank(String paymentBank) {
        this.paymentBank = paymentBank;
    }

    /**
     * 获取交费账号
     *
     * @return payment_account - 交费账号
     */
    public String getPaymentAccount() {
        return paymentAccount;
    }

    /**
     * 设置交费账号
     *
     * @param paymentAccount 交费账号
     */
    public void setPaymentAccount(String paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    /**
     * 获取交费频率
     *
     * @return payment_frequency - 交费频率
     */
    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    /**
     * 设置交费频率
     *
     * @param paymentFrequency 交费频率
     */
    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    /**
     * 获取应交日期
     *
     * @return payment_date_payable - 应交日期
     */
    public String getPaymentDatePayable() {
        return paymentDatePayable;
    }

    /**
     * 设置应交日期
     *
     * @param paymentDatePayable 应交日期
     */
    public void setPaymentDatePayable(String paymentDatePayable) {
        this.paymentDatePayable = paymentDatePayable;
    }

    /**
     * 获取扣款日期
     *
     * @return payment_date_charge - 扣款日期
     */
    public String getPaymentDateCharge() {
        return paymentDateCharge;
    }

    /**
     * 设置扣款日期
     *
     * @param paymentDateCharge 扣款日期
     */
    public void setPaymentDateCharge(String paymentDateCharge) {
        this.paymentDateCharge = paymentDateCharge;
    }

    /**
     * 获取当期应交保费
     *
     * @return payment_premium_payable - 当期应交保费
     */
    public String getPaymentPremiumPayable() {
        return paymentPremiumPayable;
    }

    /**
     * 设置当期应交保费
     *
     * @param paymentPremiumPayable 当期应交保费
     */
    public void setPaymentPremiumPayable(String paymentPremiumPayable) {
        this.paymentPremiumPayable = paymentPremiumPayable;
    }

    /**
     * 获取当期实交保费
     *
     * @return payment_premium_charge - 当期实交保费
     */
    public String getPaymentPremiumCharge() {
        return paymentPremiumCharge;
    }

    /**
     * 设置当期实交保费
     *
     * @param paymentPremiumCharge 当期实交保费
     */
    public void setPaymentPremiumCharge(String paymentPremiumCharge) {
        this.paymentPremiumCharge = paymentPremiumCharge;
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

    public BxdPaymentDetail() {
    }

    public BxdPaymentDetail(String detailsId) {
        this.detailsId = detailsId;
    }
}