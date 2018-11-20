package com.yingu.project.big.data.persistence.entity.sb;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sb_base_info")
public class SbBaseInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 社保uuid
     */
    private String uuid;

    /**
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 数据获取时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 用户所在单位
     */
    @Column(name = "user_company")
    private String userCompany;

    /**
     * 社保开户区县
     */
    @Column(name = "soins_area")
    private String soinsArea;

    /**
     * 用户身份证号
     */
    @Column(name = "user_idcard")
    private String userIdcard;

    /**
     * 社保开户机构
     */
    @Column(name = "soins_org")
    private String soinsOrg;

    /**
     * 数据源
     */
    @Column(name = "data_source")
    private String dataSource;

    /**
     * 社保开户日期
     */
    @Column(name = "open_time")
    private String openTime;

    /**
     * 社保账号
     */
    @Column(name = "soins_num")
    private String soinsNum;

    /**
     * 社保开户城市
     */
    @Column(name = "soins_city")
    private String soinsCity;

    /**
     * 社保状态
     */
    @Column(name = "soins_status")
    private String soinsStatus;

    /**
     * 系统用户id
     */
    private String token;

    /**
     * 接口版本
     */
    private String version;

    /**
     * 外键
     */
    @Column(name = "details_id")
    private String detailsId;

    /**
     * 社保开户省份
     */
    @Column(name = "soins_prov")
    private String soinsProv;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

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
     * 获取社保uuid
     *
     * @return uuid - 社保uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置社保uuid
     *
     * @param uuid 社保uuid
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
     * 获取数据获取时间
     *
     * @return update_time - 数据获取时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置数据获取时间
     *
     * @param updateTime 数据获取时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取用户所在单位
     *
     * @return user_company - 用户所在单位
     */
    public String getUserCompany() {
        return userCompany;
    }

    /**
     * 设置用户所在单位
     *
     * @param userCompany 用户所在单位
     */
    public void setUserCompany(String userCompany) {
        this.userCompany = userCompany;
    }

    /**
     * 获取社保开户区县
     *
     * @return soins_area - 社保开户区县
     */
    public String getSoinsArea() {
        return soinsArea;
    }

    /**
     * 设置社保开户区县
     *
     * @param soinsArea 社保开户区县
     */
    public void setSoinsArea(String soinsArea) {
        this.soinsArea = soinsArea;
    }

    /**
     * 获取用户身份证号
     *
     * @return user_idcard - 用户身份证号
     */
    public String getUserIdcard() {
        return userIdcard;
    }

    /**
     * 设置用户身份证号
     *
     * @param userIdcard 用户身份证号
     */
    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }

    /**
     * 获取社保开户机构
     *
     * @return soins_org - 社保开户机构
     */
    public String getSoinsOrg() {
        return soinsOrg;
    }

    /**
     * 设置社保开户机构
     *
     * @param soinsOrg 社保开户机构
     */
    public void setSoinsOrg(String soinsOrg) {
        this.soinsOrg = soinsOrg;
    }

    /**
     * 获取数据源
     *
     * @return data_source - 数据源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据源
     *
     * @param dataSource 数据源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取社保开户日期
     *
     * @return open_time - 社保开户日期
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * 设置社保开户日期
     *
     * @param openTime 社保开户日期
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取社保账号
     *
     * @return soins_num - 社保账号
     */
    public String getSoinsNum() {
        return soinsNum;
    }

    /**
     * 设置社保账号
     *
     * @param soinsNum 社保账号
     */
    public void setSoinsNum(String soinsNum) {
        this.soinsNum = soinsNum;
    }

    /**
     * 获取社保开户城市
     *
     * @return soins_city - 社保开户城市
     */
    public String getSoinsCity() {
        return soinsCity;
    }

    /**
     * 设置社保开户城市
     *
     * @param soinsCity 社保开户城市
     */
    public void setSoinsCity(String soinsCity) {
        this.soinsCity = soinsCity;
    }

    /**
     * 获取社保状态
     *
     * @return soins_status - 社保状态
     */
    public String getSoinsStatus() {
        return soinsStatus;
    }

    /**
     * 设置社保状态
     *
     * @param soinsStatus 社保状态
     */
    public void setSoinsStatus(String soinsStatus) {
        this.soinsStatus = soinsStatus;
    }

    /**
     * 获取系统用户id
     *
     * @return token - 系统用户id
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置系统用户id
     *
     * @param token 系统用户id
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取接口版本
     *
     * @return version - 接口版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置接口版本
     *
     * @param version 接口版本
     */
    public void setVersion(String version) {
        this.version = version;
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
     * 获取社保开户省份
     *
     * @return soins_prov - 社保开户省份
     */
    public String getSoinsProv() {
        return soinsProv;
    }

    /**
     * 设置社保开户省份
     *
     * @param soinsProv 社保开户省份
     */
    public void setSoinsProv(String soinsProv) {
        this.soinsProv = soinsProv;
    }

    /**
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    public SbBaseInfo(String orderNum) {
        this.orderNum = orderNum;
    }

    public SbBaseInfo() {
    }
}