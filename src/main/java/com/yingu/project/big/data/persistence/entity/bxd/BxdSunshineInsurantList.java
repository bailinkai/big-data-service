package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_insurant_list")
public class BxdSunshineInsurantList {
    public BxdSunshineInsurantList() {
    }

    public BxdSunshineInsurantList(String listId) {
        this.listId = listId;
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
     * 被保人姓名
     */
    private String name;

    /**
     * 被保人性别
     */
    private String gender;

    /**
     * 投保人和被保人关系
     */
    private String relation;

    /**
     * 被保人生日
     */
    private String birthday;

    /**
     * 被保人证件类型
     */
    @Column(name = "id_card_type")
    private String idCardType;

    /**
     * 被保人证件号
     */
    @Column(name = "id_card_no")
    private String idCardNo;

    /**
     * 被保人电话号
     */
    @Column(name = "phone_no")
    private String phoneNo;

    /**
     * 被保人邮箱
     */
    private String email;

    /**
     * 被保人地址
     */
    private String address;

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
     * 获取被保人姓名
     *
     * @return name - 被保人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置被保人姓名
     *
     * @param name 被保人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取被保人性别
     *
     * @return gender - 被保人性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置被保人性别
     *
     * @param gender 被保人性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取投保人和被保人关系
     *
     * @return relation - 投保人和被保人关系
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 设置投保人和被保人关系
     *
     * @param relation 投保人和被保人关系
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * 获取被保人生日
     *
     * @return birthday - 被保人生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置被保人生日
     *
     * @param birthday 被保人生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取被保人证件类型
     *
     * @return id_card_type - 被保人证件类型
     */
    public String getIdCardType() {
        return idCardType;
    }

    /**
     * 设置被保人证件类型
     *
     * @param idCardType 被保人证件类型
     */
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    /**
     * 获取被保人证件号
     *
     * @return id_card_no - 被保人证件号
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置被保人证件号
     *
     * @param idCardNo 被保人证件号
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 获取被保人电话号
     *
     * @return phone_no - 被保人电话号
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置被保人电话号
     *
     * @param phoneNo 被保人电话号
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * 获取被保人邮箱
     *
     * @return email - 被保人邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置被保人邮箱
     *
     * @param email 被保人邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取被保人地址
     *
     * @return address - 被保人地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置被保人地址
     *
     * @param address 被保人地址
     */
    public void setAddress(String address) {
        this.address = address;
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