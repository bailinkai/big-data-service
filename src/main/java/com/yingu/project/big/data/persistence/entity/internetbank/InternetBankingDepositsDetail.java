package com.yingu.project.big.data.persistence.entity.internetbank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "internet_banking_deposits_detail")
public class InternetBankingDepositsDetail {
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
     * 存款ID
     */
    @Column(name = "deposits_id")
    private String depositsId;

    /**
     * 金额
     */
    private BigDecimal balance;

    /**
     * 定期类型(如:整存整取)
     */
    @Column(name = "deposit_type")
    private String depositType;

    /**
     * 币种. CNY-人民币; USD-美元
     */
    @Column(name = "currency_type")
    private String currencyType;

    /**
     * 计息日期
     */
    @Column(name = "deposit_date")
    private String depositDate;

    /**
     * 到期日期
     */
    @Column(name = "due_date")
    private String dueDate;

    /**
     * 存期
     */
    private Integer period;

    /**
     * 存期单位
     */
    @Column(name = "period_unit")
    private String periodUnit;

    /**
     * 利率
     */
    private BigDecimal interest;

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
     * 获取存款ID
     *
     * @return deposits_id - 存款ID
     */
    public String getDepositsId() {
        return depositsId;
    }

    /**
     * 设置存款ID
     *
     * @param depositsId 存款ID
     */
    public void setDepositsId(String depositsId) {
        this.depositsId = depositsId;
    }

    /**
     * 获取金额
     *
     * @return balance - 金额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置金额
     *
     * @param balance 金额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取定期类型(如:整存整取)
     *
     * @return deposit_type - 定期类型(如:整存整取)
     */
    public String getDepositType() {
        return depositType;
    }

    /**
     * 设置定期类型(如:整存整取)
     *
     * @param depositType 定期类型(如:整存整取)
     */
    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    /**
     * 获取币种. CNY-人民币; USD-美元
     *
     * @return currency_type - 币种. CNY-人民币; USD-美元
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置币种. CNY-人民币; USD-美元
     *
     * @param currencyType 币种. CNY-人民币; USD-美元
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * 获取计息日期
     *
     * @return deposit_date - 计息日期
     */
    public String getDepositDate() {
        return depositDate;
    }

    /**
     * 设置计息日期
     *
     * @param depositDate 计息日期
     */
    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    /**
     * 获取到期日期
     *
     * @return due_date - 到期日期
     */
    public String getDueDate() {
        return dueDate;
    }

    /**
     * 设置到期日期
     *
     * @param dueDate 到期日期
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * 获取存期
     *
     * @return period - 存期
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 设置存期
     *
     * @param period 存期
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 获取存期单位
     *
     * @return period_unit - 存期单位
     */
    public String getPeriodUnit() {
        return periodUnit;
    }

    /**
     * 设置存期单位
     *
     * @param periodUnit 存期单位
     */
    public void setPeriodUnit(String periodUnit) {
        this.periodUnit = periodUnit;
    }

    /**
     * 获取利率
     *
     * @return interest - 利率
     */
    public BigDecimal getInterest() {
        return interest;
    }

    /**
     * 设置利率
     *
     * @param interest 利率
     */
    public void setInterest(BigDecimal interest) {
        this.interest = interest;
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