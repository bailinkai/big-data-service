package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_detail")
public class BxdDetail {
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
     * 保险产品名称
     */
    @Column(name = "insurance_name")
    private String insuranceName;

    /**
     * 保单类型
     */
    @Column(name = "insurance_type")
    private String insuranceType;

    /**
     * 保单号码
     */
    @Column(name = "insurance_id")
    private String insuranceId;

    /**
     * 保单状态
     */
    @Column(name = "insurance_status")
    private String insuranceStatus;

    /**
     * 主险名称
     */
    @Column(name = "insurance_main")
    private String insuranceMain;

    /**
     * 保险份数
     */
    @Column(name = "insurance_num")
    private String insuranceNum;

    /**
     * 外键
     */
    @Column(name = "details_id_two")
    private String detailsIdTwo;

    /**
     * 归属机构名称
     */
    private String attribution;

    /**
     * 销售渠道
     */
    @Column(name = "sales_channel")
    private String salesChannel;

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
     * 获取保险产品名称
     *
     * @return insurance_name - 保险产品名称
     */
    public String getInsuranceName() {
        return insuranceName;
    }

    /**
     * 设置保险产品名称
     *
     * @param insuranceName 保险产品名称
     */
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    /**
     * 获取保单类型
     *
     * @return insurance_type - 保单类型
     */
    public String getInsuranceType() {
        return insuranceType;
    }

    /**
     * 设置保单类型
     *
     * @param insuranceType 保单类型
     */
    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    /**
     * 获取保单号码
     *
     * @return insurance_id - 保单号码
     */
    public String getInsuranceId() {
        return insuranceId;
    }

    /**
     * 设置保单号码
     *
     * @param insuranceId 保单号码
     */
    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    /**
     * 获取保单状态
     *
     * @return insurance_status - 保单状态
     */
    public String getInsuranceStatus() {
        return insuranceStatus;
    }

    /**
     * 设置保单状态
     *
     * @param insuranceStatus 保单状态
     */
    public void setInsuranceStatus(String insuranceStatus) {
        this.insuranceStatus = insuranceStatus;
    }

    /**
     * 获取主险名称
     *
     * @return insurance_main - 主险名称
     */
    public String getInsuranceMain() {
        return insuranceMain;
    }

    /**
     * 设置主险名称
     *
     * @param insuranceMain 主险名称
     */
    public void setInsuranceMain(String insuranceMain) {
        this.insuranceMain = insuranceMain;
    }

    /**
     * 获取保险份数
     *
     * @return insurance_num - 保险份数
     */
    public String getInsuranceNum() {
        return insuranceNum;
    }

    /**
     * 设置保险份数
     *
     * @param insuranceNum 保险份数
     */
    public void setInsuranceNum(String insuranceNum) {
        this.insuranceNum = insuranceNum;
    }

    /**
     * 获取外键
     *
     * @return details_id_two - 外键
     */
    public String getDetailsIdTwo() {
        return detailsIdTwo;
    }

    /**
     * 设置外键
     *
     * @param detailsIdTwo 外键
     */
    public void setDetailsIdTwo(String detailsIdTwo) {
        this.detailsIdTwo = detailsIdTwo;
    }

    /**
     * 获取归属机构名称
     *
     * @return attribution - 归属机构名称
     */
    public String getAttribution() {
        return attribution;
    }

    /**
     * 设置归属机构名称
     *
     * @param attribution 归属机构名称
     */
    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    /**
     * 获取销售渠道
     *
     * @return sales_channel - 销售渠道
     */
    public String getSalesChannel() {
        return salesChannel;
    }

    /**
     * 设置销售渠道
     *
     * @param salesChannel 销售渠道
     */
    public void setSalesChannel(String salesChannel) {
        this.salesChannel = salesChannel;
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

    public BxdDetail() {
    }

    public BxdDetail(String detailsId) {
        this.detailsId = detailsId;
    }
}