package com.yingu.project.big.data.persistence.entity.bxd;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bxd_sunshine_duty_list")
public class BxdSunshineDutyList {
    public BxdSunshineDutyList(String listId) {
        this.listId = listId;
    }

    public BxdSunshineDutyList() {
    }

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
     * 责任（附加险）名称
     */
    private String name;

    /**
     * 保险金额
     */
    private String amount;

    /**
     * 保费总额
     */
    private String premium;

    /**
     * 保险份数
     */
    private String quantity;

    /**
     * 保险状态
     */
    private String status;

    /**
     * 开始时间
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * 终止时间
     */
    @Column(name = "end_date")
    private String endDate;

    /**
     * 档次
     */
    private String grade;

    /**
     * 是否是主险
     */
    @Column(name = "main_insurance")
    private Boolean mainInsurance;

    /**
     * 保障期限
     */
    private String period;

    /**
     * 缴费总金额
     */
    @Column(name = "total_premium")
    private String totalPremium;

    /**
     * 保期缴费金额
     */
    @Column(name = "period_amount")
    private String periodAmount;

    /**
     * 追加保费
     */
    @Column(name = "addtion_amount")
    private String addtionAmount;

    /**
     * 缴费期限
     */
    @Column(name = "pay_period")
    private String payPeriod;

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
     * 缴费日期
     */
    @Column(name = "payment_date")
    private String paymentDate;

    /**
     * 缴费方式(银行转账、现金等)
     */
    @Column(name = "pay_type")
    private String payType;

    /**
     * 缴费地址
     */
    @Column(name = "pay_address")
    private String payAddress;

    /**
     * 缴费账户
     */
    @Column(name = "pay_account")
    private String payAccount;

    /**
     * 缴费银行
     */
    @Column(name = "pay_bank")
    private String payBank;

    /**
     * 外键
     */
    @Column(name = "list_id")
    private String listId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
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
     * 获取责任（附加险）名称
     *
     * @return name - 责任（附加险）名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置责任（附加险）名称
     *
     * @param name 责任（附加险）名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取保险金额
     *
     * @return amount - 保险金额
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置保险金额
     *
     * @param amount 保险金额
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 获取保费总额
     *
     * @return premium - 保费总额
     */
    public String getPremium() {
        return premium;
    }

    /**
     * 设置保费总额
     *
     * @param premium 保费总额
     */
    public void setPremium(String premium) {
        this.premium = premium;
    }

    /**
     * 获取保险份数
     *
     * @return quantity - 保险份数
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * 设置保险份数
     *
     * @param quantity 保险份数
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取保险状态
     *
     * @return status - 保险状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置保险状态
     *
     * @param status 保险状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取开始时间
     *
     * @return start_date - 开始时间
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置开始时间
     *
     * @param startDate 开始时间
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取终止时间
     *
     * @return end_date - 终止时间
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置终止时间
     *
     * @param endDate 终止时间
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取档次
     *
     * @return grade - 档次
     */
    public String getGrade() {
        return grade;
    }

    /**
     * 设置档次
     *
     * @param grade 档次
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * 获取是否是主险
     *
     * @return main_insurance - 是否是主险
     */
    public Boolean getMainInsurance() {
        return mainInsurance;
    }

    /**
     * 设置是否是主险
     *
     * @param mainInsurance 是否是主险
     */
    public void setMainInsurance(Boolean mainInsurance) {
        this.mainInsurance = mainInsurance;
    }

    /**
     * 获取保障期限
     *
     * @return period - 保障期限
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置保障期限
     *
     * @param period 保障期限
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 获取缴费总金额
     *
     * @return total_premium - 缴费总金额
     */
    public String getTotalPremium() {
        return totalPremium;
    }

    /**
     * 设置缴费总金额
     *
     * @param totalPremium 缴费总金额
     */
    public void setTotalPremium(String totalPremium) {
        this.totalPremium = totalPremium;
    }

    /**
     * 获取保期缴费金额
     *
     * @return period_amount - 保期缴费金额
     */
    public String getPeriodAmount() {
        return periodAmount;
    }

    /**
     * 设置保期缴费金额
     *
     * @param periodAmount 保期缴费金额
     */
    public void setPeriodAmount(String periodAmount) {
        this.periodAmount = periodAmount;
    }

    /**
     * 获取追加保费
     *
     * @return addtion_amount - 追加保费
     */
    public String getAddtionAmount() {
        return addtionAmount;
    }

    /**
     * 设置追加保费
     *
     * @param addtionAmount 追加保费
     */
    public void setAddtionAmount(String addtionAmount) {
        this.addtionAmount = addtionAmount;
    }

    /**
     * 获取缴费期限
     *
     * @return pay_period - 缴费期限
     */
    public String getPayPeriod() {
        return payPeriod;
    }

    /**
     * 设置缴费期限
     *
     * @param payPeriod 缴费期限
     */
    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
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
     * 获取缴费日期
     *
     * @return payment_date - 缴费日期
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * 设置缴费日期
     *
     * @param paymentDate 缴费日期
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * 获取缴费方式(银行转账、现金等)
     *
     * @return pay_type - 缴费方式(银行转账、现金等)
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置缴费方式(银行转账、现金等)
     *
     * @param payType 缴费方式(银行转账、现金等)
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取缴费地址
     *
     * @return pay_address - 缴费地址
     */
    public String getPayAddress() {
        return payAddress;
    }

    /**
     * 设置缴费地址
     *
     * @param payAddress 缴费地址
     */
    public void setPayAddress(String payAddress) {
        this.payAddress = payAddress;
    }

    /**
     * 获取缴费账户
     *
     * @return pay_account - 缴费账户
     */
    public String getPayAccount() {
        return payAccount;
    }

    /**
     * 设置缴费账户
     *
     * @param payAccount 缴费账户
     */
    public void setPayAccount(String payAccount) {
        this.payAccount = payAccount;
    }

    /**
     * 获取缴费银行
     *
     * @return pay_bank - 缴费银行
     */
    public String getPayBank() {
        return payBank;
    }

    /**
     * 设置缴费银行
     *
     * @param payBank 缴费银行
     */
    public void setPayBank(String payBank) {
        this.payBank = payBank;
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