package com.yingu.project.big.data.persistence.entity.gjj;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gjj_payment_details")
public class GjjPaymentDetails {
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
    @Column(name = "payment_details_id")
    private String paymentDetailsId;

    /**
     * 还款日期
     */
    @Column(name = "payment_date")
    private String paymentDate;

    /**
     * 还款期次
     */
    @Column(name = "payment_num")
    private String paymentNum;

    /**
     * 偿还本金
     */
    @Column(name = "payment_principal")
    private String paymentPrincipal;

    /**
     * 偿还利息
     */
    @Column(name = "payment_interest")
    private String paymentInterest;

    /**
     * 偿还罚息
     */
    @Column(name = "payment_penalty")
    private String paymentPenalty;

    /**
     * 本息合计
     */
    @Column(name = "payment_sum")
    private String paymentSum;

    /**
     * 本金余额
     */
    @Column(name = "prin_balance")
    private String prinBalance;

    /**
     * 还款描述
     */
    @Column(name = "payment_describe")
    private String paymentDescribe;

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
     * 获取还款日期
     *
     * @return payment_date - 还款日期
     */
    public String getPaymentDate() {
        return paymentDate;
    }

    /**
     * 设置还款日期
     *
     * @param paymentDate 还款日期
     */
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * 获取还款期次
     *
     * @return payment_num - 还款期次
     */
    public String getPaymentNum() {
        return paymentNum;
    }

    /**
     * 设置还款期次
     *
     * @param paymentNum 还款期次
     */
    public void setPaymentNum(String paymentNum) {
        this.paymentNum = paymentNum;
    }

    /**
     * 获取偿还本金
     *
     * @return payment_principal - 偿还本金
     */
    public String getPaymentPrincipal() {
        return paymentPrincipal;
    }

    /**
     * 设置偿还本金
     *
     * @param paymentPrincipal 偿还本金
     */
    public void setPaymentPrincipal(String paymentPrincipal) {
        this.paymentPrincipal = paymentPrincipal;
    }

    /**
     * 获取偿还利息
     *
     * @return payment_interest - 偿还利息
     */
    public String getPaymentInterest() {
        return paymentInterest;
    }

    /**
     * 设置偿还利息
     *
     * @param paymentInterest 偿还利息
     */
    public void setPaymentInterest(String paymentInterest) {
        this.paymentInterest = paymentInterest;
    }

    /**
     * 获取偿还罚息
     *
     * @return payment_penalty - 偿还罚息
     */
    public String getPaymentPenalty() {
        return paymentPenalty;
    }

    /**
     * 设置偿还罚息
     *
     * @param paymentPenalty 偿还罚息
     */
    public void setPaymentPenalty(String paymentPenalty) {
        this.paymentPenalty = paymentPenalty;
    }

    /**
     * 获取本息合计
     *
     * @return payment_sum - 本息合计
     */
    public String getPaymentSum() {
        return paymentSum;
    }

    /**
     * 设置本息合计
     *
     * @param paymentSum 本息合计
     */
    public void setPaymentSum(String paymentSum) {
        this.paymentSum = paymentSum;
    }

    /**
     * 获取本金余额
     *
     * @return prin_balance - 本金余额
     */
    public String getPrinBalance() {
        return prinBalance;
    }

    /**
     * 设置本金余额
     *
     * @param prinBalance 本金余额
     */
    public void setPrinBalance(String prinBalance) {
        this.prinBalance = prinBalance;
    }

    /**
     * 获取还款描述
     *
     * @return payment_describe - 还款描述
     */
    public String getPaymentDescribe() {
        return paymentDescribe;
    }

    /**
     * 设置还款描述
     *
     * @param paymentDescribe 还款描述
     */
    public void setPaymentDescribe(String paymentDescribe) {
        this.paymentDescribe = paymentDescribe;
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

    public GjjPaymentDetails() {
    }

    public GjjPaymentDetails(String paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }
}