package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_pay_record_list")
public class BxdSunshinePayRecordList {
    public BxdSunshinePayRecordList(String payRecordListId) {
        this.payRecordListId = payRecordListId;
    }

    public BxdSunshinePayRecordList() {
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
     * 外键
     */
    @Column(name = "pay_record_list_id")
    private String payRecordListId;

    /**
     * 缴费时间
     */
    private String date;

    /**
     * 缴费金额
     */
    private String amount;

    /**
     * 缴费账户
     */
    private String account;

    /**
     * 缴费类型
     */
    private String type;

    /**
     * 缴费状态
     */
    private String status;

    /**
     * 缴费描述
     */
    private String description;

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
     * 获取缴费时间
     *
     * @return date - 缴费时间
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置缴费时间
     *
     * @param date 缴费时间
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取缴费金额
     *
     * @return amount - 缴费金额
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置缴费金额
     *
     * @param amount 缴费金额
     */
    public void setAmount(String amount) {
        this.amount = amount;
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
     * 获取缴费类型
     *
     * @return type - 缴费类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置缴费类型
     *
     * @param type 缴费类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取缴费状态
     *
     * @return status - 缴费状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置缴费状态
     *
     * @param status 缴费状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取缴费描述
     *
     * @return description - 缴费描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置缴费描述
     *
     * @param description 缴费描述
     */
    public void setDescription(String description) {
        this.description = description;
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