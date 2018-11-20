package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_insurant_detail")
public class BxdInsurantDetail {
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
     * 被保险人证件号码
     */
    @Column(name = "insurant_id_card_num")
    private String insurantIdCardNum;

    /**
     * 被保险人证件类型
     */
    @Column(name = "insurant_id_card_type")
    private String insurantIdCardType;

    /**
     * 被保险人姓名
     */
    @Column(name = "insurant_name")
    private String insurantName;

    /**
     * 被保险人与投保人关系
     */
    @Column(name = "insurant_relationship")
    private String insurantRelationship;

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
     * 获取被保险人证件号码
     *
     * @return insurant_id_card_num - 被保险人证件号码
     */
    public String getInsurantIdCardNum() {
        return insurantIdCardNum;
    }

    /**
     * 设置被保险人证件号码
     *
     * @param insurantIdCardNum 被保险人证件号码
     */
    public void setInsurantIdCardNum(String insurantIdCardNum) {
        this.insurantIdCardNum = insurantIdCardNum;
    }

    /**
     * 获取被保险人证件类型
     *
     * @return insurant_id_card_type - 被保险人证件类型
     */
    public String getInsurantIdCardType() {
        return insurantIdCardType;
    }

    /**
     * 设置被保险人证件类型
     *
     * @param insurantIdCardType 被保险人证件类型
     */
    public void setInsurantIdCardType(String insurantIdCardType) {
        this.insurantIdCardType = insurantIdCardType;
    }

    /**
     * 获取被保险人姓名
     *
     * @return insurant_name - 被保险人姓名
     */
    public String getInsurantName() {
        return insurantName;
    }

    /**
     * 设置被保险人姓名
     *
     * @param insurantName 被保险人姓名
     */
    public void setInsurantName(String insurantName) {
        this.insurantName = insurantName;
    }

    /**
     * 获取被保险人与投保人关系
     *
     * @return insurant_relationship - 被保险人与投保人关系
     */
    public String getInsurantRelationship() {
        return insurantRelationship;
    }

    /**
     * 设置被保险人与投保人关系
     *
     * @param insurantRelationship 被保险人与投保人关系
     */
    public void setInsurantRelationship(String insurantRelationship) {
        this.insurantRelationship = insurantRelationship;
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

    public BxdInsurantDetail() {
    }

    public BxdInsurantDetail(String detailsId) {
        this.detailsId = detailsId;
    }
}