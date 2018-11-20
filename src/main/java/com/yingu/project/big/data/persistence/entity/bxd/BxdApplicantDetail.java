package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_applicant_detail")
public class BxdApplicantDetail {
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
     * 投保人联系地址
     */
    @Column(name = "applicant_address")
    private String applicantAddress;

    /**
     * 投保人证件类型
     */
    @Column(name = "applicant_id_card_type")
    private String applicantIdCardType;

    /**
     * 投保人手机号码
     */
    @Column(name = "applicant_cell_phone")
    private String applicantCellPhone;

    /**
     * 投保人电子邮箱
     */
    @Column(name = "applicant_email")
    private String applicantEmail;

    /**
     * 投保人姓名
     */
    @Column(name = "applicant_name")
    private String applicantName;

    /**
     * 投保人证件号码
     */
    @Column(name = "applicant_id_card_num")
    private String applicantIdCardNum;

    /**
     * 性别
     */
    @Column(name = "applicant_gender")
    private String applicantGender;

    /**
     * 城市
     */
    @Column(name = "applicant_city")
    private String applicantCity;

    /**
     * 婚姻状况
     */
    @Column(name = "applicant_married")
    private String applicantMarried;

    /**
     * 年收入
     */
    @Column(name = "applicant_annual_income")
    private String applicantAnnualIncome;

    /**
     * 职业
     */
    @Column(name = "applicant_profession")
    private String applicantProfession;

    /**
     * 健康状况
     */
    @Column(name = "applicant_health_status")
    private String applicantHealthStatus;

    /**
     * 儿女状况
     */
    @Column(name = "applicant_children")
    private String applicantChildren;

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
     * 获取投保人联系地址
     *
     * @return applicant_address - 投保人联系地址
     */
    public String getApplicantAddress() {
        return applicantAddress;
    }

    /**
     * 设置投保人联系地址
     *
     * @param applicantAddress 投保人联系地址
     */
    public void setApplicantAddress(String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }

    /**
     * 获取投保人证件类型
     *
     * @return applicant_id_card_type - 投保人证件类型
     */
    public String getApplicantIdCardType() {
        return applicantIdCardType;
    }

    /**
     * 设置投保人证件类型
     *
     * @param applicantIdCardType 投保人证件类型
     */
    public void setApplicantIdCardType(String applicantIdCardType) {
        this.applicantIdCardType = applicantIdCardType;
    }

    /**
     * 获取投保人手机号码
     *
     * @return applicant_cell_phone - 投保人手机号码
     */
    public String getApplicantCellPhone() {
        return applicantCellPhone;
    }

    /**
     * 设置投保人手机号码
     *
     * @param applicantCellPhone 投保人手机号码
     */
    public void setApplicantCellPhone(String applicantCellPhone) {
        this.applicantCellPhone = applicantCellPhone;
    }

    /**
     * 获取投保人电子邮箱
     *
     * @return applicant_email - 投保人电子邮箱
     */
    public String getApplicantEmail() {
        return applicantEmail;
    }

    /**
     * 设置投保人电子邮箱
     *
     * @param applicantEmail 投保人电子邮箱
     */
    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    /**
     * 获取投保人姓名
     *
     * @return applicant_name - 投保人姓名
     */
    public String getApplicantName() {
        return applicantName;
    }

    /**
     * 设置投保人姓名
     *
     * @param applicantName 投保人姓名
     */
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    /**
     * 获取投保人证件号码
     *
     * @return applicant_id_card_num - 投保人证件号码
     */
    public String getApplicantIdCardNum() {
        return applicantIdCardNum;
    }

    /**
     * 设置投保人证件号码
     *
     * @param applicantIdCardNum 投保人证件号码
     */
    public void setApplicantIdCardNum(String applicantIdCardNum) {
        this.applicantIdCardNum = applicantIdCardNum;
    }

    /**
     * 获取性别
     *
     * @return applicant_gender - 性别
     */
    public String getApplicantGender() {
        return applicantGender;
    }

    /**
     * 设置性别
     *
     * @param applicantGender 性别
     */
    public void setApplicantGender(String applicantGender) {
        this.applicantGender = applicantGender;
    }

    /**
     * 获取城市
     *
     * @return applicant_city - 城市
     */
    public String getApplicantCity() {
        return applicantCity;
    }

    /**
     * 设置城市
     *
     * @param applicantCity 城市
     */
    public void setApplicantCity(String applicantCity) {
        this.applicantCity = applicantCity;
    }

    /**
     * 获取婚姻状况
     *
     * @return applicant_married - 婚姻状况
     */
    public String getApplicantMarried() {
        return applicantMarried;
    }

    /**
     * 设置婚姻状况
     *
     * @param applicantMarried 婚姻状况
     */
    public void setApplicantMarried(String applicantMarried) {
        this.applicantMarried = applicantMarried;
    }

    /**
     * 获取年收入
     *
     * @return applicant_annual_income - 年收入
     */
    public String getApplicantAnnualIncome() {
        return applicantAnnualIncome;
    }

    /**
     * 设置年收入
     *
     * @param applicantAnnualIncome 年收入
     */
    public void setApplicantAnnualIncome(String applicantAnnualIncome) {
        this.applicantAnnualIncome = applicantAnnualIncome;
    }

    /**
     * 获取职业
     *
     * @return applicant_profession - 职业
     */
    public String getApplicantProfession() {
        return applicantProfession;
    }

    /**
     * 设置职业
     *
     * @param applicantProfession 职业
     */
    public void setApplicantProfession(String applicantProfession) {
        this.applicantProfession = applicantProfession;
    }

    /**
     * 获取健康状况
     *
     * @return applicant_health_status - 健康状况
     */
    public String getApplicantHealthStatus() {
        return applicantHealthStatus;
    }

    /**
     * 设置健康状况
     *
     * @param applicantHealthStatus 健康状况
     */
    public void setApplicantHealthStatus(String applicantHealthStatus) {
        this.applicantHealthStatus = applicantHealthStatus;
    }

    /**
     * 获取儿女状况
     *
     * @return applicant_children - 儿女状况
     */
    public String getApplicantChildren() {
        return applicantChildren;
    }

    /**
     * 设置儿女状况
     *
     * @param applicantChildren 儿女状况
     */
    public void setApplicantChildren(String applicantChildren) {
        this.applicantChildren = applicantChildren;
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

    public BxdApplicantDetail() {
    }

    public BxdApplicantDetail(String detailsId) {
        this.detailsId = detailsId;
    }
}