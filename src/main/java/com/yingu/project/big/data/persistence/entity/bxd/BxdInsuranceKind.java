package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_insurance_kind")
public class BxdInsuranceKind {
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
     * 险别名称
     */
    @Column(name = "insurance_kind_insurance_name")
    private String insuranceKindInsuranceName;

    /**
     * 险种类别
     */
    @Column(name = "insurance_kind_insurance_type")
    private String insuranceKindInsuranceType;

    /**
     * 责任名称
     */
    @Column(name = "insurance_kind_duty_name")
    private String insuranceKindDutyName;

    /**
     * 保额
     */
    @Column(name = "insurance_kind_insured_amount")
    private String insuranceKindInsuredAmount;

    /**
     * 保费
     */
    @Column(name = "insurance_kind_insurance_premium")
    private String insuranceKindInsurancePremium;

    /**
     * 投保人数
     */
    @Column(name = "insurance_kind_insure_num")
    private String insuranceKindInsureNum;

    /**
     * 险种状态
     */
    @Column(name = "insurance_kind_insurance_status")
    private String insuranceKindInsuranceStatus;

    /**
     * 保险期间
     */
    @Column(name = "insurance_kind_insurance_period")
    private String insuranceKindInsurancePeriod;

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
     * 获取险别名称
     *
     * @return insurance_kind_insurance_name - 险别名称
     */
    public String getInsuranceKindInsuranceName() {
        return insuranceKindInsuranceName;
    }

    /**
     * 设置险别名称
     *
     * @param insuranceKindInsuranceName 险别名称
     */
    public void setInsuranceKindInsuranceName(String insuranceKindInsuranceName) {
        this.insuranceKindInsuranceName = insuranceKindInsuranceName;
    }

    /**
     * 获取险种类别
     *
     * @return insurance_kind_insurance_type - 险种类别
     */
    public String getInsuranceKindInsuranceType() {
        return insuranceKindInsuranceType;
    }

    /**
     * 设置险种类别
     *
     * @param insuranceKindInsuranceType 险种类别
     */
    public void setInsuranceKindInsuranceType(String insuranceKindInsuranceType) {
        this.insuranceKindInsuranceType = insuranceKindInsuranceType;
    }

    /**
     * 获取责任名称
     *
     * @return insurance_kind_duty_name - 责任名称
     */
    public String getInsuranceKindDutyName() {
        return insuranceKindDutyName;
    }

    /**
     * 设置责任名称
     *
     * @param insuranceKindDutyName 责任名称
     */
    public void setInsuranceKindDutyName(String insuranceKindDutyName) {
        this.insuranceKindDutyName = insuranceKindDutyName;
    }

    /**
     * 获取保额
     *
     * @return insurance_kind_insured_amount - 保额
     */
    public String getInsuranceKindInsuredAmount() {
        return insuranceKindInsuredAmount;
    }

    /**
     * 设置保额
     *
     * @param insuranceKindInsuredAmount 保额
     */
    public void setInsuranceKindInsuredAmount(String insuranceKindInsuredAmount) {
        this.insuranceKindInsuredAmount = insuranceKindInsuredAmount;
    }

    /**
     * 获取保费
     *
     * @return insurance_kind_insurance_premium - 保费
     */
    public String getInsuranceKindInsurancePremium() {
        return insuranceKindInsurancePremium;
    }

    /**
     * 设置保费
     *
     * @param insuranceKindInsurancePremium 保费
     */
    public void setInsuranceKindInsurancePremium(String insuranceKindInsurancePremium) {
        this.insuranceKindInsurancePremium = insuranceKindInsurancePremium;
    }

    /**
     * 获取投保人数
     *
     * @return insurance_kind_insure_num - 投保人数
     */
    public String getInsuranceKindInsureNum() {
        return insuranceKindInsureNum;
    }

    /**
     * 设置投保人数
     *
     * @param insuranceKindInsureNum 投保人数
     */
    public void setInsuranceKindInsureNum(String insuranceKindInsureNum) {
        this.insuranceKindInsureNum = insuranceKindInsureNum;
    }

    /**
     * 获取险种状态
     *
     * @return insurance_kind_insurance_status - 险种状态
     */
    public String getInsuranceKindInsuranceStatus() {
        return insuranceKindInsuranceStatus;
    }

    /**
     * 设置险种状态
     *
     * @param insuranceKindInsuranceStatus 险种状态
     */
    public void setInsuranceKindInsuranceStatus(String insuranceKindInsuranceStatus) {
        this.insuranceKindInsuranceStatus = insuranceKindInsuranceStatus;
    }

    /**
     * 获取保险期间
     *
     * @return insurance_kind_insurance_period - 保险期间
     */
    public String getInsuranceKindInsurancePeriod() {
        return insuranceKindInsurancePeriod;
    }

    /**
     * 设置保险期间
     *
     * @param insuranceKindInsurancePeriod 保险期间
     */
    public void setInsuranceKindInsurancePeriod(String insuranceKindInsurancePeriod) {
        this.insuranceKindInsurancePeriod = insuranceKindInsurancePeriod;
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

    public BxdInsuranceKind() {
    }

    public BxdInsuranceKind(String detailsId) {
        this.detailsId = detailsId;
    }
}