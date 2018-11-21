package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_sale_info")
public class BxdSunshineSaleInfo {
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
     * 销售单位名称
     */
    private String unit;

    /**
     * 销售单位地址
     */
    private String address;

    /**
     * 服务人员姓名
     */
    @Column(name = "staff_name")
    private String staffName;

    /**
     * 服务人员工号
     */
    @Column(name = "staff_no")
    private String staffNo;

    /**
     * 服务人员电话
     */
    @Column(name = "staff_phone")
    private String staffPhone;

    /**
     * 服务人员邮箱
     */
    @Column(name = "staff_email")
    private String staffEmail;

    /**
     * 服务人员联系地址
     */
    @Column(name = "staff_address")
    private String staffAddress;

    /**
     * 服务人员就职状态
     */
    @Column(name = "staff_status")
    private String staffStatus;

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
     * 获取销售单位名称
     *
     * @return unit - 销售单位名称
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置销售单位名称
     *
     * @param unit 销售单位名称
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取销售单位地址
     *
     * @return address - 销售单位地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置销售单位地址
     *
     * @param address 销售单位地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取服务人员姓名
     *
     * @return staff_name - 服务人员姓名
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置服务人员姓名
     *
     * @param staffName 服务人员姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 获取服务人员工号
     *
     * @return staff_no - 服务人员工号
     */
    public String getStaffNo() {
        return staffNo;
    }

    /**
     * 设置服务人员工号
     *
     * @param staffNo 服务人员工号
     */
    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    /**
     * 获取服务人员电话
     *
     * @return staff_phone - 服务人员电话
     */
    public String getStaffPhone() {
        return staffPhone;
    }

    /**
     * 设置服务人员电话
     *
     * @param staffPhone 服务人员电话
     */
    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    /**
     * 获取服务人员邮箱
     *
     * @return staff_email - 服务人员邮箱
     */
    public String getStaffEmail() {
        return staffEmail;
    }

    /**
     * 设置服务人员邮箱
     *
     * @param staffEmail 服务人员邮箱
     */
    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    /**
     * 获取服务人员联系地址
     *
     * @return staff_address - 服务人员联系地址
     */
    public String getStaffAddress() {
        return staffAddress;
    }

    /**
     * 设置服务人员联系地址
     *
     * @param staffAddress 服务人员联系地址
     */
    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    /**
     * 获取服务人员就职状态
     *
     * @return staff_status - 服务人员就职状态
     */
    public String getStaffStatus() {
        return staffStatus;
    }

    /**
     * 设置服务人员就职状态
     *
     * @param staffStatus 服务人员就职状态
     */
    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
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

    public BxdSunshineSaleInfo() {
    }

    public BxdSunshineSaleInfo(String orderNum) {
        this.orderNum = orderNum;
    }
}