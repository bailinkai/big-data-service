package com.yingu.project.big.data.persistence.entity.gjj;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gjj_loan_info")
public class GjjLoanInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公积金uuid
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
    @Column(name = "loan_info_id")
    private String loanInfoId;

    /**
     * 贷款人姓名
     */
    @Column(name = "loan_name")
    private String loanName;

    /**
     * 贷款人身份证号
     */
    @Column(name = "loan_idcard")
    private String loanIdcard;

    /**
     * 单位名称
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 委托银行
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 还款账户
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * 贷款合同编号
     */
    @Column(name = "loan_num")
    private String loanNum;

    /**
     * 贷款金额
     */
    @Column(name = "loan_amount")
    private String loanAmount;

    /**
     * 贷款年限
     */
    @Column(name = "loan_length")
    private String loanLength;

    /**
     * 贷款利率
     */
    @Column(name = "loan_rate")
    private String loanRate;

    /**
     * 还款状态
     */
    @Column(name = "loan_status")
    private String loanStatus;

    /**
     * 担保方式
     */
    @Column(name = "guarantee_type")
    private String guaranteeType;

    /**
     * 还款方式
     */
    @Column(name = "payment_type")
    private String paymentType;

    /**
     * 月还款日期
     */
    @Column(name = "payment_day")
    private String paymentDay;

    /**
     * 放款日期
     */
    @Column(name = "loan_date")
    private String loanDate;

    /**
     * 购房类型
     */
    @Column(name = "house_type")
    private String houseType;

    /**
     * 月还款金额
     */
    @Column(name = "payment_amount")
    private String paymentAmount;

    /**
     * 已还本金
     */
    @Column(name = "due_principal")
    private String duePrincipal;

    /**
     * 逾期次数
     */
    @Column(name = "overdue_times")
    private String overdueTimes;

    /**
     * 逾期金额
     */
    @Column(name = "overdue_amount")
    private String overdueAmount;

    /**
     * 外键
     */
    @Column(name = "payment_details_id")
    private String paymentDetailsId;

    /**
     * 外键
     */
    @Column(name = "overdue_details_id")
    private String overdueDetailsId;

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
     * 获取公积金uuid
     *
     * @return uuid - 公积金uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置公积金uuid
     *
     * @param uuid 公积金uuid
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
     * @return loan_info_id - 外键
     */
    public String getLoanInfoId() {
        return loanInfoId;
    }

    /**
     * 设置外键
     *
     * @param loanInfoId 外键
     */
    public void setLoanInfoId(String loanInfoId) {
        this.loanInfoId = loanInfoId;
    }

    /**
     * 获取贷款人姓名
     *
     * @return loan_name - 贷款人姓名
     */
    public String getLoanName() {
        return loanName;
    }

    /**
     * 设置贷款人姓名
     *
     * @param loanName 贷款人姓名
     */
    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    /**
     * 获取贷款人身份证号
     *
     * @return loan_idcard - 贷款人身份证号
     */
    public String getLoanIdcard() {
        return loanIdcard;
    }

    /**
     * 设置贷款人身份证号
     *
     * @param loanIdcard 贷款人身份证号
     */
    public void setLoanIdcard(String loanIdcard) {
        this.loanIdcard = loanIdcard;
    }

    /**
     * 获取单位名称
     *
     * @return company_name - 单位名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置单位名称
     *
     * @param companyName 单位名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取委托银行
     *
     * @return bank_name - 委托银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置委托银行
     *
     * @param bankName 委托银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取还款账户
     *
     * @return bank_account - 还款账户
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置还款账户
     *
     * @param bankAccount 还款账户
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * 获取贷款合同编号
     *
     * @return loan_num - 贷款合同编号
     */
    public String getLoanNum() {
        return loanNum;
    }

    /**
     * 设置贷款合同编号
     *
     * @param loanNum 贷款合同编号
     */
    public void setLoanNum(String loanNum) {
        this.loanNum = loanNum;
    }

    /**
     * 获取贷款金额
     *
     * @return loan_amount - 贷款金额
     */
    public String getLoanAmount() {
        return loanAmount;
    }

    /**
     * 设置贷款金额
     *
     * @param loanAmount 贷款金额
     */
    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * 获取贷款年限
     *
     * @return loan_length - 贷款年限
     */
    public String getLoanLength() {
        return loanLength;
    }

    /**
     * 设置贷款年限
     *
     * @param loanLength 贷款年限
     */
    public void setLoanLength(String loanLength) {
        this.loanLength = loanLength;
    }

    /**
     * 获取贷款利率
     *
     * @return loan_rate - 贷款利率
     */
    public String getLoanRate() {
        return loanRate;
    }

    /**
     * 设置贷款利率
     *
     * @param loanRate 贷款利率
     */
    public void setLoanRate(String loanRate) {
        this.loanRate = loanRate;
    }

    /**
     * 获取还款状态
     *
     * @return loan_status - 还款状态
     */
    public String getLoanStatus() {
        return loanStatus;
    }

    /**
     * 设置还款状态
     *
     * @param loanStatus 还款状态
     */
    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    /**
     * 获取担保方式
     *
     * @return guarantee_type - 担保方式
     */
    public String getGuaranteeType() {
        return guaranteeType;
    }

    /**
     * 设置担保方式
     *
     * @param guaranteeType 担保方式
     */
    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }

    /**
     * 获取还款方式
     *
     * @return payment_type - 还款方式
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * 设置还款方式
     *
     * @param paymentType 还款方式
     */
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * 获取月还款日期
     *
     * @return payment_day - 月还款日期
     */
    public String getPaymentDay() {
        return paymentDay;
    }

    /**
     * 设置月还款日期
     *
     * @param paymentDay 月还款日期
     */
    public void setPaymentDay(String paymentDay) {
        this.paymentDay = paymentDay;
    }

    /**
     * 获取放款日期
     *
     * @return loan_date - 放款日期
     */
    public String getLoanDate() {
        return loanDate;
    }

    /**
     * 设置放款日期
     *
     * @param loanDate 放款日期
     */
    public void setLoanDate(String loanDate) {
        this.loanDate = loanDate;
    }

    /**
     * 获取购房类型
     *
     * @return house_type - 购房类型
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * 设置购房类型
     *
     * @param houseType 购房类型
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    /**
     * 获取月还款金额
     *
     * @return payment_amount - 月还款金额
     */
    public String getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * 设置月还款金额
     *
     * @param paymentAmount 月还款金额
     */
    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * 获取已还本金
     *
     * @return due_principal - 已还本金
     */
    public String getDuePrincipal() {
        return duePrincipal;
    }

    /**
     * 设置已还本金
     *
     * @param duePrincipal 已还本金
     */
    public void setDuePrincipal(String duePrincipal) {
        this.duePrincipal = duePrincipal;
    }

    /**
     * 获取逾期次数
     *
     * @return overdue_times - 逾期次数
     */
    public String getOverdueTimes() {
        return overdueTimes;
    }

    /**
     * 设置逾期次数
     *
     * @param overdueTimes 逾期次数
     */
    public void setOverdueTimes(String overdueTimes) {
        this.overdueTimes = overdueTimes;
    }

    /**
     * 获取逾期金额
     *
     * @return overdue_amount - 逾期金额
     */
    public String getOverdueAmount() {
        return overdueAmount;
    }

    /**
     * 设置逾期金额
     *
     * @param overdueAmount 逾期金额
     */
    public void setOverdueAmount(String overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    /**
     * 获取外键
     *
     * @return payment_details_id - 外键
     */
    public String getPaymentDetailsId() {
        return paymentDetailsId;
    }

    /**
     * 设置外键
     *
     * @param paymentDetailsId 外键
     */
    public void setPaymentDetailsId(String paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    /**
     * 获取外键
     *
     * @return overdue_details_id - 外键
     */
    public String getOverdueDetailsId() {
        return overdueDetailsId;
    }

    /**
     * 设置外键
     *
     * @param overdueDetailsId 外键
     */
    public void setOverdueDetailsId(String overdueDetailsId) {
        this.overdueDetailsId = overdueDetailsId;
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

    public GjjLoanInfo() {
    }

    public GjjLoanInfo(String loanInfoId) {
        this.loanInfoId = loanInfoId;
    }
}