package com.yingu.project.big.data.persistence.entity.pc;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "pc_customer_base_info")
public class PcCustomerBaseInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phid")
    private Integer phid;

    public Integer getPhid() {
        return phid;
    }

    public void setPhid(Integer phid) {
        this.phid = phid;
    }

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
     * 客户姓名
     */
    @Column(name = "custom_name")
    private String customName;

    /**
     * 性别：男、女、女转男、男转女、未知
     */
    private String sex;

    /**
     * 婚姻状况：已婚、未婚、离异、再婚
     */
    @Column(name = "marital_status")
    private String maritalStatus;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 户口类型：农村户口、城镇户口
     */
    @Column(name = "account_nature")
    private String accountNature;

    /**
     * 证件类型：身份证
     */
    @Column(name = "id_type")
    private String idType;

    /**
     * 证件号码
     */
    @Column(name = "id_num")
    private String idNum;

    /**
     * 民族
     */
    private String nation;

    /**
     * 最高学历
     */
    private String education;

    /**
     * 车产状况：有车、无车
     */
    @Column(name = "has_car")
    private String hasCar;

    /**
     * 是否有子女
     */
    @Column(name = "has_child")
    private Boolean hasChild;

    /**
     * 供养人数
     */
    @Column(name = "people_num")
    private String peopleNum;

    /**
     * 征信用户名
     */
    @Column(name = "credit_username")
    private String creditUsername;

    /**
     * 征信密码
     */
    @Column(name = "credit_password")
    private String creditPassword;

    /**
     * 征信验证码
     */
    @Column(name = "credit_code")
    private String creditCode;

    /**
     * 单张信用卡最高额度
     */
    @Column(name = "credit_limit")
    private String creditLimit;

    /**
     * 家庭电话
     */
    @Column(name = "home_phone")
    private String homePhone;

    /**
     * 户口所在地
     */
    @Column(name = "hk_address")
    private String hkAddress;

    /**
     * 住房类型
     */
    @Column(name = "housing_type")
    private String housingType;

    /**
     * 住房情况
     */
    @Column(name = "housing_situation")
    private String housingSituation;

    /**
     * 住宅地址
     */
    @Column(name = "zz_address")
    private String zzAddress;

    /**
     * 住宅地址是否与户口地址一致 0:否 1:是
     */
    @Column(name = "zzaddress_hkaddress_same")
    private Integer zzaddressHkaddressSame;

    /**
     * 每月家庭支出
     */
    private String expend;

    /**
     * 来本市的年份
     */
    @Column(name = "come_time")
    private String comeTime;

    /**
     * 起始居住时间 年-月
     */
    @Column(name = "start_residence_time")
    private String startResidenceTime;

    /**
     * 是否提供公积金信息
     */
    private String provide;

    /**
     * 保险公司全称
     */
    @Column(name = "insurance_company_name")
    private String insuranceCompanyName;

    /**
     * 保单生效日期
     */
    @Column(name = "insurance_take_effect_date")
    private String insuranceTakeEffectDate;

    /**
     * 被保人姓名
     */
    @Column(name = "insurance_name")
    private String insuranceName;

    /**
     * 保险金额
     */
    @Column(name = "insurance_fee")
    private BigDecimal insuranceFee;

    /**
     * 用户ID
     */
    @Column(name = "app_user_id")
    private String appUserId;

    /**
     * 身份证正面照片地址
     */
    @Column(name = "id_obvers_url")
    private String idObversUrl;


    /**
     * 身份证背面照片地址
     */
    @Column(name = "id_revers_url")
    private String idReversUrl;

    /**
     * 身份证头像地址
     */
    @Column(name = "id_head_url")
    private String idHeadUrl;

    public String getAppUserId() {
        return appUserId;
    }

    public void setAppUserId(String appUserId) {
        this.appUserId = appUserId;
    }

    public String getIdObversUrl() {
        return idObversUrl;
    }

    public void setIdObversUrl(String idObversUrl) {
        this.idObversUrl = idObversUrl;
    }

    public String getIdReversUrl() {
        return idReversUrl;
    }

    public void setIdReversUrl(String idReversUrl) {
        this.idReversUrl = idReversUrl;
    }

    public String getIdHeadUrl() {
        return idHeadUrl;
    }

    public void setIdHeadUrl(String idHeadUrl) {
        this.idHeadUrl = idHeadUrl;
    }

    public String getFractionalValue() {
        return fractionalValue;
    }

    public void setFractionalValue(String fractionalValue) {
        this.fractionalValue = fractionalValue;
    }

    /**
     * 活体对比的分数值
     */
    @Column(name = "fractional_value")

    private String fractionalValue;


    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getInsuranceTakeEffectDate() {
        return insuranceTakeEffectDate;
    }

    public void setInsuranceTakeEffectDate(String insuranceTakeEffectDate) {
        this.insuranceTakeEffectDate = insuranceTakeEffectDate;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public BigDecimal getInsuranceFee() {
        return insuranceFee;
    }

    public void setInsuranceFee(BigDecimal insuranceFee) {
        this.insuranceFee = insuranceFee;
    }

    public String getPayInterval() {
        return payInterval;
    }

    public void setPayInterval(String payInterval) {
        this.payInterval = payInterval;
    }

    public BigDecimal getPeriodInsurance() {
        return periodInsurance;
    }

    public void setPeriodInsurance(BigDecimal periodInsurance) {
        this.periodInsurance = periodInsurance;
    }

    /**
     * 缴保间隔
     */

    @Column(name = "pay_interval")
    private String payInterval;

    /**
     * 每期保险费
     */
    @Column(name = "period_insurance")
    private BigDecimal periodInsurance;

    /**
     * 是否提供保单信息
     */
    @Column(name = "insurance_provide")
    private String insuranceProvide;


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
     * 获取客户姓名
     *
     * @return custom_name - 客户姓名
     */
    public String getCustomName() {
        return customName;
    }

    /**
     * 设置客户姓名
     *
     * @param customName 客户姓名
     */
    public void setCustomName(String customName) {
        this.customName = customName;
    }

    /**
     * 获取性别：男、女、女转男、男转女、未知
     *
     * @return sex - 性别：男、女、女转男、男转女、未知
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别：男、女、女转男、男转女、未知
     *
     * @param sex 性别：男、女、女转男、男转女、未知
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取婚姻状况：已婚、未婚、离异、再婚
     *
     * @return marital_status - 婚姻状况：已婚、未婚、离异、再婚
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 设置婚姻状况：已婚、未婚、离异、再婚
     *
     * @param maritalStatus 婚姻状况：已婚、未婚、离异、再婚
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取户口类型：农村户口、城镇户口
     *
     * @return account_nature - 户口类型：农村户口、城镇户口
     */
    public String getAccountNature() {
        return accountNature;
    }

    /**
     * 设置户口类型：农村户口、城镇户口
     *
     * @param accountNature 户口类型：农村户口、城镇户口
     */
    public void setAccountNature(String accountNature) {
        this.accountNature = accountNature;
    }

    /**
     * 获取证件类型：身份证
     *
     * @return id_type - 证件类型：身份证
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置证件类型：身份证
     *
     * @param idType 证件类型：身份证
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * 获取证件号码
     *
     * @return id_num - 证件号码
     */
    public String getIdNum() {
        return idNum;
    }

    /**
     * 设置证件号码
     *
     * @param idNum 证件号码
     */
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    /**
     * 获取民族
     *
     * @return nation - 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 设置民族
     *
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * 获取最高学历
     *
     * @return education - 最高学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置最高学历
     *
     * @param education 最高学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取车产状况：有车、无车
     *
     * @return has_car - 车产状况：有车、无车
     */
    public String getHasCar() {
        return hasCar;
    }

    /**
     * 设置车产状况：有车、无车
     *
     * @param hasCar 车产状况：有车、无车
     */
    public void setHasCar(String hasCar) {
        this.hasCar = hasCar;
    }

    /**
     * 获取是否有子女
     *
     * @return has_child - 是否有子女
     */
    public Boolean getHasChild() {
        return hasChild;
    }

    /**
     * 设置是否有子女
     *
     * @param hasChild 是否有子女
     */
    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    /**
     * 获取供养人数
     *
     * @return people_num - 供养人数
     */
    public String getPeopleNum() {
        return peopleNum;
    }

    /**
     * 设置供养人数
     *
     * @param peopleNum 供养人数
     */
    public void setPeopleNum(String peopleNum) {
        this.peopleNum = peopleNum;
    }

    /**
     * 获取征信用户名
     *
     * @return credit_username - 征信用户名
     */
    public String getCreditUsername() {
        return creditUsername;
    }

    /**
     * 设置征信用户名
     *
     * @param creditUsername 征信用户名
     */
    public void setCreditUsername(String creditUsername) {
        this.creditUsername = creditUsername;
    }

    /**
     * 获取征信密码
     *
     * @return credit_password - 征信密码
     */
    public String getCreditPassword() {
        return creditPassword;
    }

    /**
     * 设置征信密码
     *
     * @param creditPassword 征信密码
     */
    public void setCreditPassword(String creditPassword) {
        this.creditPassword = creditPassword;
    }

    /**
     * 获取征信验证码
     *
     * @return credit_code - 征信验证码
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 设置征信验证码
     *
     * @param creditCode 征信验证码
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * 获取单张信用卡最高额度
     *
     * @return credit_limit - 单张信用卡最高额度
     */
    public String getCreditLimit() {
        return creditLimit;
    }

    /**
     * 设置单张信用卡最高额度
     *
     * @param creditLimit 单张信用卡最高额度
     */
    public void setCreditLimit(String creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * 获取家庭电话
     *
     * @return home_phone - 家庭电话
     */
    public String getHomePhone() {
        return homePhone;
    }

    /**
     * 设置家庭电话
     *
     * @param homePhone 家庭电话
     */
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    /**
     * 获取户口所在地
     *
     * @return hk_address - 户口所在地
     */
    public String getHkAddress() {
        return hkAddress;
    }

    /**
     * 设置户口所在地
     *
     * @param hkAddress 户口所在地
     */
    public void setHkAddress(String hkAddress) {
        this.hkAddress = hkAddress;
    }

    /**
     * 获取住房类型
     *
     * @return housing_type - 住房类型
     */
    public String getHousingType() {
        return housingType;
    }

    /**
     * 设置住房类型
     *
     * @param housingType 住房类型
     */
    public void setHousingType(String housingType) {
        this.housingType = housingType;
    }

    /**
     * 获取住房情况
     *
     * @return housing_situation - 住房情况
     */
    public String getHousingSituation() {
        return housingSituation;
    }

    /**
     * 设置住房情况
     *
     * @param housingSituation 住房情况
     */
    public void setHousingSituation(String housingSituation) {
        this.housingSituation = housingSituation;
    }

    /**
     * 获取住宅地址
     *
     * @return zz_address - 住宅地址
     */
    public String getZzAddress() {
        return zzAddress;
    }

    /**
     * 设置住宅地址
     *
     * @param zzAddress 住宅地址
     */
    public void setZzAddress(String zzAddress) {
        this.zzAddress = zzAddress;
    }

    /**
     * 获取住宅地址是否与户口地址一致 0:否 1:是
     *
     * @return zzaddress_hkaddress_same - 住宅地址是否与户口地址一致 0:否 1:是
     */
    public Integer getZzaddressHkaddressSame() {
        return zzaddressHkaddressSame;
    }

    /**
     * 设置住宅地址是否与户口地址一致 0:否 1:是
     *
     * @param zzaddressHkaddressSame 住宅地址是否与户口地址一致 0:否 1:是
     */
    public void setZzaddressHkaddressSame(Integer zzaddressHkaddressSame) {
        this.zzaddressHkaddressSame = zzaddressHkaddressSame;
    }

    /**
     * 获取 每月家庭支出
     *
     * @return expend -  每月家庭支出
     */
    public String getExpend() {
        return expend;
    }

    /**
     * 设置 每月家庭支出
     *
     * @param expend 每月家庭支出
     */
    public void setExpend(String expend) {
        this.expend = expend;
    }

    /**
     * 获取来本市的年份
     *
     * @return come_time - 来本市的年份
     */
    public String getComeTime() {
        return comeTime;
    }

    /**
     * 设置来本市的年份
     *
     * @param comeTime 来本市的年份
     */
    public void setComeTime(String comeTime) {
        this.comeTime = comeTime;
    }

    /**
     * 获取起始居住时间 年-月
     *
     * @return start_residence_time - 起始居住时间 年-月
     */
    public String getStartResidenceTime() {
        return startResidenceTime;
    }

    /**
     * 设置起始居住时间 年-月
     *
     * @param startResidenceTime 起始居住时间 年-月
     */
    public void setStartResidenceTime(String startResidenceTime) {
        this.startResidenceTime = startResidenceTime;
    }

    /**
     * 获取是否提供公积金信息
     *
     * @return provide - 是否提供公积金信息
     */
    public String getProvide() {
        return provide;
    }

    /**
     * 设置是否提供公积金信息
     *
     * @param provide 是否提供公积金信息
     */
    public void setProvide(String provide) {
        this.provide = provide;
    }

    /**
     * 获取是否提供保单信息
     *
     * @return insurance_provide - 是否提供保单信息
     */
    public String getInsuranceProvide() {
        return insuranceProvide;
    }

    /**
     * 设置是否提供保单信息
     *
     * @param insuranceProvide 是否提供保单信息
     */
    public void setInsuranceProvide(String insuranceProvide) {
        this.insuranceProvide = insuranceProvide;
    }

    public PcCustomerBaseInfo() {
    }

    public PcCustomerBaseInfo(String orderNum) {
        this.orderNum = orderNum;
    }
}