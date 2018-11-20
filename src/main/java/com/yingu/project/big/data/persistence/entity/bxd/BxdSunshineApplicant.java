package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_applicant")
public class BxdSunshineApplicant {
    public BxdSunshineApplicant() {
    }

    public BxdSunshineApplicant(String orderNum) {
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
     * 投保人姓名
     */
    private String name;

    /**
     * 投保人性别
     */
    private String gender;

    /**
     * 投保人生日
     */
    private String birthday;

    /**
     * 投保人证件类型(居民身份证、身份证、军官证等)
     */
    @Column(name = "id_card_type")
    private String idCardType;

    /**
     * 投保人身份证号
     */
    @Column(name = "id_card_no")
    private String idCardNo;

    /**
     * 投保人电话号码
     */
    @Column(name = "phone_no")
    private String phoneNo;

    /**
     * 投保人邮箱
     */
    private String email;

    /**
     * 投保人地址
     */
    private String address;

    /**
     * 投保人公司
     */
    private String company;

    /**
     * 投保人公司地址
     */
    @Column(name = "company_address")
    private String companyAddress;

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
     * 获取投保人姓名
     *
     * @return name - 投保人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置投保人姓名
     *
     * @param name 投保人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取投保人性别
     *
     * @return gender - 投保人性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置投保人性别
     *
     * @param gender 投保人性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取投保人生日
     *
     * @return birthday - 投保人生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置投保人生日
     *
     * @param birthday 投保人生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取投保人证件类型(居民身份证、身份证、军官证等)
     *
     * @return id_card_type - 投保人证件类型(居民身份证、身份证、军官证等)
     */
    public String getIdCardType() {
        return idCardType;
    }

    /**
     * 设置投保人证件类型(居民身份证、身份证、军官证等)
     *
     * @param idCardType 投保人证件类型(居民身份证、身份证、军官证等)
     */
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    /**
     * 获取投保人身份证号
     *
     * @return id_card_no - 投保人身份证号
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置投保人身份证号
     *
     * @param idCardNo 投保人身份证号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 获取投保人电话号码
     *
     * @return phone_no - 投保人电话号码
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置投保人电话号码
     *
     * @param phoneNo 投保人电话号码
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 获取投保人邮箱
     *
     * @return email - 投保人邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置投保人邮箱
     *
     * @param email 投保人邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取投保人地址
     *
     * @return address - 投保人地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置投保人地址
     *
     * @param address 投保人地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取投保人公司
     *
     * @return company - 投保人公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置投保人公司
     *
     * @param company 投保人公司
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取投保人公司地址
     *
     * @return company_address - 投保人公司地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 设置投保人公司地址
     *
     * @param companyAddress 投保人公司地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
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