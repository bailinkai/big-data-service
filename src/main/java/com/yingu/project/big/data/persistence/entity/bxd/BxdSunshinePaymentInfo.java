package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_payment_info")
public class BxdSunshinePaymentInfo {
    public BxdSunshinePaymentInfo() {
    }

    public BxdSunshinePaymentInfo(String listId) {
        this.listId = listId;
    }

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
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 保期内应缴总金额
     */
    @Column(name = "total_premium")
    private String totalPremium;

    /**
     * 保期内已缴费金额
     */
    @Column(name = "period_amount")
    private String periodAmount;

    /**
     * 缴费期限
     */
    private String period;

    /**
     * 缴费开始时间
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * 缴费终止时间
     */
    @Column(name = "end_date")
    private String endDate;

    /**
     * 缴费模式(	月缴（交）、年缴（交）、一次性缴清等)
     */
    @Column(name = "pay_model")
    private String payModel;

    /**
     * 下期缴费日期
     */
    @Column(name = "next_pay_date")
    private String nextPayDate;

    /**
     * 下期缴费金额
     */
    @Column(name = "next_pay_amount")
    private String nextPayAmount;

    /**
     * 缴费期满日期
     */
    @Column(name = "pay_due_date")
    private String payDueDate;

    /**
     * 本期交至日期
     */
    @Column(name = "date_payable")
    private String datePayable;

    /**
     * 缴费日期
     */
    @Column(name = "paid_date")
    private String paidDate;

    /**
     * 缴费方式(银行转账、现金等)
     */
    private String type;

    /**
     * 缴费账户
     */
    private String account;

    /**
     * 缴费银行
     */
    private String bank;

    /**
     * 缴费状态(已缴、未缴（待缴）等)
     */
    private String status;

    /**
     * 本期应缴时间
     */
    @Column(name = "current_pay_due_date")
    private String currentPayDueDate;

    /**
     * 缴费地址(保险公司地址、银行地址等)
     */
    private String address;

    /**
     * 首期缴费日期
     */
    @Column(name = "first_pay_date")
    private String firstPayDate;

    /**
     * 首期缴费金额
     */
    @Column(name = "first_pay_amount")
    private String firstPayAmount;

    /**
     * 总缴费次数
     */
    @Column(name = "pay_count")
    private String payCount;

    /**
     * 已缴费次数
     */
    @Column(name = "paid_count")
    private String paidCount;

    /**
     * 外键
     */
    @Column(name = "list_id")
    private String listId;

    /**
     * 外键
     */
    @Column(name = "pay_record_list_id")
    private String payRecordListId;

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
     * 获取保期内应缴总金额
     *
     * @return total_premium - 保期内应缴总金额
     */
    public String getTotalPremium() {
        return totalPremium;
    }

    /**
     * 设置保期内应缴总金额
     *
     * @param totalPremium 保期内应缴总金额
     */
    public void setTotalPremium(String totalPremium) {
        this.totalPremium = totalPremium;
    }

    /**
     * 获取保期内已缴费金额
     *
     * @return period_amount - 保期内已缴费金额
     */
    public String getPeriodAmount() {
        return periodAmount;
    }

    /**
     * 设置保期内已缴费金额
     *
     * @param periodAmount 保期内已缴费金额
     */
    public void setPeriodAmount(String periodAmount) {
        this.periodAmount = periodAmount;
    }

    /**
     * 获取缴费期限
     *
     * @return period - 缴费期限
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置缴费期限
     *
     * @param period 缴费期限
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 获取缴费开始时间
     *
     * @return start_date - 缴费开始时间
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置缴费开始时间
     *
     * @param startDate 缴费开始时间
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取缴费终止时间
     *
     * @return end_date - 缴费终止时间
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置缴费终止时间
     *
     * @param endDate 缴费终止时间
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取缴费模式(	月缴（交）、年缴（交）、一次性缴清等)
     *
     * @return pay_model - 缴费模式(	月缴（交）、年缴（交）、一次性缴清等)
     */
    public String getPayModel() {
        return payModel;
    }

    /**
     * 设置缴费模式(	月缴（交）、年缴（交）、一次性缴清等)
     *
     * @param payModel 缴费模式(	月缴（交）、年缴（交）、一次性缴清等)
     */
    public void setPayModel(String payModel) {
        this.payModel = payModel;
    }

    /**
     * 获取下期缴费日期
     *
     * @return next_pay_date - 下期缴费日期
     */
    public String getNextPayDate() {
        return nextPayDate;
    }

    /**
     * 设置下期缴费日期
     *
     * @param nextPayDate 下期缴费日期
     */
    public void setNextPayDate(String nextPayDate) {
        this.nextPayDate = nextPayDate;
    }

    /**
     * 获取下期缴费金额
     *
     * @return next_pay_amount - 下期缴费金额
     */
    public String getNextPayAmount() {
        return nextPayAmount;
    }

    /**
     * 设置下期缴费金额
     *
     * @param nextPayAmount 下期缴费金额
     */
    public void setNextPayAmount(String nextPayAmount) {
        this.nextPayAmount = nextPayAmount;
    }

    /**
     * 获取缴费期满日期
     *
     * @return pay_due_date - 缴费期满日期
     */
    public String getPayDueDate() {
        return payDueDate;
    }

    /**
     * 设置缴费期满日期
     *
     * @param payDueDate 缴费期满日期
     */
    public void setPayDueDate(String payDueDate) {
        this.payDueDate = payDueDate;
    }

    /**
     * 获取本期交至日期
     *
     * @return date_payable - 本期交至日期
     */
    public String getDatePayable() {
        return datePayable;
    }

    /**
     * 设置本期交至日期
     *
     * @param datePayable 本期交至日期
     */
    public void setDatePayable(String datePayable) {
        this.datePayable = datePayable;
    }

    /**
     * 获取缴费日期
     *
     * @return paid_date - 缴费日期
     */
    public String getPaidDate() {
        return paidDate;
    }

    /**
     * 设置缴费日期
     *
     * @param paidDate 缴费日期
     */
    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    /**
     * 获取缴费方式(银行转账、现金等)
     *
     * @return type - 缴费方式(银行转账、现金等)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置缴费方式(银行转账、现金等)
     *
     * @param type 缴费方式(银行转账、现金等)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取缴费账户
     *
     * @return account - 缴费账户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置缴费账户
     *
     * @param account 缴费账户
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取缴费银行
     *
     * @return bank - 缴费银行
     */
    public String getBank() {
        return bank;
    }

    /**
     * 设置缴费银行
     *
     * @param bank 缴费银行
     */
    public void setBank(String bank) {
        this.bank = bank;
    }

    /**
     * 获取缴费状态(已缴、未缴（待缴）等)
     *
     * @return status - 缴费状态(已缴、未缴（待缴）等)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置缴费状态(已缴、未缴（待缴）等)
     *
     * @param status 缴费状态(已缴、未缴（待缴）等)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取本期应缴时间
     *
     * @return current_pay_due_date - 本期应缴时间
     */
    public String getCurrentPayDueDate() {
        return currentPayDueDate;
    }

    /**
     * 设置本期应缴时间
     *
     * @param currentPayDueDate 本期应缴时间
     */
    public void setCurrentPayDueDate(String currentPayDueDate) {
        this.currentPayDueDate = currentPayDueDate;
    }

    /**
     * 获取缴费地址(保险公司地址、银行地址等)
     *
     * @return address - 缴费地址(保险公司地址、银行地址等)
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置缴费地址(保险公司地址、银行地址等)
     *
     * @param address 缴费地址(保险公司地址、银行地址等)
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取首期缴费日期
     *
     * @return first_pay_date - 首期缴费日期
     */
    public String getFirstPayDate() {
        return firstPayDate;
    }

    /**
     * 设置首期缴费日期
     *
     * @param firstPayDate 首期缴费日期
     */
    public void setFirstPayDate(String firstPayDate) {
        this.firstPayDate = firstPayDate;
    }

    /**
     * 获取首期缴费金额
     *
     * @return first_pay_amount - 首期缴费金额
     */
    public String getFirstPayAmount() {
        return firstPayAmount;
    }

    /**
     * 设置首期缴费金额
     *
     * @param firstPayAmount 首期缴费金额
     */
    public void setFirstPayAmount(String firstPayAmount) {
        this.firstPayAmount = firstPayAmount;
    }

    /**
     * 获取总缴费次数
     *
     * @return pay_count - 总缴费次数
     */
    public String getPayCount() {
        return payCount;
    }

    /**
     * 设置总缴费次数
     *
     * @param payCount 总缴费次数
     */
    public void setPayCount(String payCount) {
        this.payCount = payCount;
    }

    /**
     * 获取已缴费次数
     *
     * @return paid_count - 已缴费次数
     */
    public String getPaidCount() {
        return paidCount;
    }

    /**
     * 设置已缴费次数
     *
     * @param paidCount 已缴费次数
     */
    public void setPaidCount(String paidCount) {
        this.paidCount = paidCount;
    }

    /**
     * 获取外键
     *
     * @return list_id - 外键
     */
    public String getListId() {
        return listId;
    }

    /**
     * 设置外键
     *
     * @param listId 外键
     */
    public void setListId(String listId) {
        this.listId = listId;
    }

    /**
     * 获取外键
     *
     * @return pay_record_list_id - 外键
     */
    public String getPayRecordListId() {
        return payRecordListId;
    }

    /**
     * 设置外键
     *
     * @param payRecordListId 外键
     */
    public void setPayRecordListId(String payRecordListId) {
        this.payRecordListId = payRecordListId;
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
}