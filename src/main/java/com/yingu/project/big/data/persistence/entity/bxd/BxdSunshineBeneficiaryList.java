package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_beneficiary_list")
public class BxdSunshineBeneficiaryList {
    public BxdSunshineBeneficiaryList() {
    }

    public BxdSunshineBeneficiaryList(String listId) {
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
     * 受益人姓名
     */
    private String name;

    /**
     * 受益人和投保人的关系
     */
    private String relation;

    /**
     * 受益顺序
     */
    @Column(name = "be_order")
    private String beOrder;

    /**
     * 受益比例
     */
    private String scale;

    /**
     * 受益类型(0-未知；1-存活受益人； 2-死亡收益人)
     */
    private String type;

    /**
     * 受益人证件类型
     */
    @Column(name = "id_card_type")
    private String idCardType;

    /**
     * 受益人证件号码
     */
    @Column(name = "id_card_no")
    private String idCardNo;

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
     * 获取受益人姓名
     *
     * @return name - 受益人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置受益人姓名
     *
     * @param name 受益人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取受益人和投保人的关系
     *
     * @return relation - 受益人和投保人的关系
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 设置受益人和投保人的关系
     *
     * @param relation 受益人和投保人的关系
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * 获取受益顺序
     *
     * @return be_order - 受益顺序
     */
    public String getBeOrder() {
        return beOrder;
    }

    /**
     * 设置受益顺序
     *
     * @param beOrder 受益顺序
     */
    public void setBeOrder(String beOrder) {
        this.beOrder = beOrder;
    }

    /**
     * 获取受益比例
     *
     * @return scale - 受益比例
     */
    public String getScale() {
        return scale;
    }

    /**
     * 设置受益比例
     *
     * @param scale 受益比例
     */
    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     * 获取受益类型(0-未知；1-存活受益人； 2-死亡收益人)
     *
     * @return type - 受益类型(0-未知；1-存活受益人； 2-死亡收益人)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置受益类型(0-未知；1-存活受益人； 2-死亡收益人)
     *
     * @param type 受益类型(0-未知；1-存活受益人； 2-死亡收益人)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取受益人证件类型
     *
     * @return id_card_type - 受益人证件类型
     */
    public String getIdCardType() {
        return idCardType;
    }

    /**
     * 设置受益人证件类型
     *
     * @param idCardType 受益人证件类型
     */
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    /**
     * 获取受益人证件号码
     *
     * @return id_card_no - 受益人证件号码
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置受益人证件号码
     *
     * @param idCardNo 受益人证件号码
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
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