package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_user_info")
public class BxdSunshineUserInfo {
    public BxdSunshineUserInfo() {
    }

    public BxdSunshineUserInfo(String orderNum) {
        this.orderNum = orderNum;
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
     * 寿险保单一个账号在魔蝎科技中的映射ID
     */
    @Column(name = "mapping_id")
    private String mappingId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    @Column(name = "true_name")
    private String trueName;

    /**
     * 证件类型(居民身份证、身份证、军官证等)
     */
    @Column(name = "id_card_type")
    private String idCardType;

    /**
     * 证件号
     */
    @Column(name = "id_card_no")
    private String idCardNo;

    /**
     * 性别(男、女)
     */
    private String gender;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 电话号码
     */
    @Column(name = "phone_no")
    private String phoneNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 职业(学生、教师等)
     */
    private String profession;

    /**
     * 城市(全国覆盖)
     */
    private String city;

    /**
     * 地址(用户登记个人资料填写的联系地址)
     */
    private String address;

    /**
     * 独立住房情况(有、无)
     */
    private String housing;

    /**
     * 婚姻状态(未婚、已婚、离婚)
     */
    @Column(name = "marital_status")
    private String maritalStatus;

    /**
     * 是否有儿女(有、无)
     */
    private String children;

    /**
     * 月收入
     */
    @Column(name = "monthly_income")
    private String monthlyIncome;

    /**
     * 年收入
     */
    @Column(name = "annual_income")
    private String annualIncome;

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
     * 获取寿险保单一个账号在魔蝎科技中的映射ID
     *
     * @return mapping_id - 寿险保单一个账号在魔蝎科技中的映射ID
     */
    public String getMappingId() {
        return mappingId;
    }

    /**
     * 设置寿险保单一个账号在魔蝎科技中的映射ID
     *
     * @param mappingId 寿险保单一个账号在魔蝎科技中的映射ID
     */
    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取真实姓名
     *
     * @return true_name - 真实姓名
     */
    public String getTrueName() {
        return trueName;
    }

    /**
     * 设置真实姓名
     *
     * @param trueName 真实姓名
     */
    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    /**
     * 获取证件类型(居民身份证、身份证、军官证等)
     *
     * @return id_card_type - 证件类型(居民身份证、身份证、军官证等)
     */
    public String getIdCardType() {
        return idCardType;
    }

    /**
     * 设置证件类型(居民身份证、身份证、军官证等)
     *
     * @param idCardType 证件类型(居民身份证、身份证、军官证等)
     */
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    /**
     * 获取证件号
     *
     * @return id_card_no - 证件号
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置证件号
     *
     * @param idCardNo 证件号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 获取性别(男、女)
     *
     * @return gender - 性别(男、女)
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别(男、女)
     *
     * @param gender 性别(男、女)
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取电话号码
     *
     * @return phone_no - 电话号码
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置电话号码
     *
     * @param phoneNo 电话号码
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取职业(学生、教师等)
     *
     * @return profession - 职业(学生、教师等)
     */
    public String getProfession() {
        return profession;
    }

    /**
     * 设置职业(学生、教师等)
     *
     * @param profession 职业(学生、教师等)
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * 获取城市(全国覆盖)
     *
     * @return city - 城市(全国覆盖)
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市(全国覆盖)
     *
     * @param city 城市(全国覆盖)
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取地址(用户登记个人资料填写的联系地址)
     *
     * @return address - 地址(用户登记个人资料填写的联系地址)
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址(用户登记个人资料填写的联系地址)
     *
     * @param address 地址(用户登记个人资料填写的联系地址)
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取独立住房情况(有、无)
     *
     * @return housing - 独立住房情况(有、无)
     */
    public String getHousing() {
        return housing;
    }

    /**
     * 设置独立住房情况(有、无)
     *
     * @param housing 独立住房情况(有、无)
     */
    public void setHousing(String housing) {
        this.housing = housing;
    }

    /**
     * 获取婚姻状态(未婚、已婚、离婚)
     *
     * @return marital_status - 婚姻状态(未婚、已婚、离婚)
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 设置婚姻状态(未婚、已婚、离婚)
     *
     * @param maritalStatus 婚姻状态(未婚、已婚、离婚)
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * 获取是否有儿女(有、无)
     *
     * @return children - 是否有儿女(有、无)
     */
    public String getChildren() {
        return children;
    }

    /**
     * 设置是否有儿女(有、无)
     *
     * @param children 是否有儿女(有、无)
     */
    public void setChildren(String children) {
        this.children = children;
    }

    /**
     * 获取月收入
     *
     * @return monthly_income - 月收入
     */
    public String getMonthlyIncome() {
        return monthlyIncome;
    }

    /**
     * 设置月收入
     *
     * @param monthlyIncome 月收入
     */
    public void setMonthlyIncome(String monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    /**
     * 获取年收入
     *
     * @return annual_income - 年收入
     */
    public String getAnnualIncome() {
        return annualIncome;
    }

    /**
     * 设置年收入
     *
     * @param annualIncome 年收入
     */
    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
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