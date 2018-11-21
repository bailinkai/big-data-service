package com.yingu.project.big.data.persistence.entity.gjj;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gjj_detials")
public class GjjDetials {
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
    @Column(name = "detials_id")
    private String detialsId;

    /**
     * 业务描述
     */
    private String note;

    /**
     * 转入余额(单位：元)
     */
    @Column(name = "trading_amt")
    private String tradingAmt;

    /**
     * 交易日期
     */
    @Column(name = "trading_date")
    private String tradingDate;

    /**
     * 转出余额(单位：元)
     */
    @Column(name = "transfer_amount")
    private String transferAmount;

    /**
     * 缴纳基数
     */
    @Column(name = "pay_base")
    private String payBase;

    /**
     * 账户余额
     */
    private String balance;

    /**
     * 所属单位
     */
    private String company;

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
     * @return detials_id - 外键
     */
    public String getDetialsId() {
        return detialsId;
    }

    /**
     * 设置外键
     *
     * @param detialsId 外键
     */
    public void setDetialsId(String detialsId) {
        this.detialsId = detialsId;
    }

    /**
     * 获取业务描述
     *
     * @return note - 业务描述
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置业务描述
     *
     * @param note 业务描述
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取转入余额(单位：元)
     *
     * @return trading_amt - 转入余额(单位：元)
     */
    public String getTradingAmt() {
        return tradingAmt;
    }

    /**
     * 设置转入余额(单位：元)
     *
     * @param tradingAmt 转入余额(单位：元)
     */
    public void setTradingAmt(String tradingAmt) {
        this.tradingAmt = tradingAmt;
    }

    /**
     * 获取交易日期
     *
     * @return trading_date - 交易日期
     */
    public String getTradingDate() {
        return tradingDate;
    }

    /**
     * 设置交易日期
     *
     * @param tradingDate 交易日期
     */
    public void setTradingDate(String tradingDate) {
        this.tradingDate = tradingDate;
    }

    /**
     * 获取转出余额(单位：元)
     *
     * @return transfer_amount - 转出余额(单位：元)
     */
    public String getTransferAmount() {
        return transferAmount;
    }

    /**
     * 设置转出余额(单位：元)
     *
     * @param transferAmount 转出余额(单位：元)
     */
    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    /**
     * 获取缴纳基数
     *
     * @return pay_base - 缴纳基数
     */
    public String getPayBase() {
        return payBase;
    }

    /**
     * 设置缴纳基数
     *
     * @param payBase 缴纳基数
     */
    public void setPayBase(String payBase) {
        this.payBase = payBase;
    }

    /**
     * 获取账户余额
     *
     * @return balance - 账户余额
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 设置账户余额
     *
     * @param balance 账户余额
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 获取所属单位
     *
     * @return company - 所属单位
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置所属单位
     *
     * @param company 所属单位
     */
    public void setCompany(String company) {
        this.company = company;
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

    public GjjDetials() {
    }

    public GjjDetials(String detialsId) {
        this.detialsId = detialsId;
    }
}