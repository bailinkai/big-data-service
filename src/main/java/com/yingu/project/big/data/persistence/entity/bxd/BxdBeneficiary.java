package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_beneficiary")
public class BxdBeneficiary {
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
     * 受益人类型(生存/死亡)
     */
    @Column(name = "beneficiary_status")
    private String beneficiaryStatus;

    /**
     * 与被保险人关系
     */
    @Column(name = "beneficiary_relationship")
    private String beneficiaryRelationship;

    /**
     * 受益人姓名
     */
    @Column(name = "beneficiary_name")
    private String beneficiaryName;

    /**
     * 受益顺序
     */
    @Column(name = "beneficiary_order")
    private String beneficiaryOrder;

    /**
     * 受益比例
     */
    @Column(name = "beneficiary_scale")
    private String beneficiaryScale;

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
     * 获取受益人类型(生存/死亡)
     *
     * @return beneficiary_status - 受益人类型(生存/死亡)
     */
    public String getBeneficiaryStatus() {
        return beneficiaryStatus;
    }

    /**
     * 设置受益人类型(生存/死亡)
     *
     * @param beneficiaryStatus 受益人类型(生存/死亡)
     */
    public void setBeneficiaryStatus(String beneficiaryStatus) {
        this.beneficiaryStatus = beneficiaryStatus;
    }

    /**
     * 获取与被保险人关系
     *
     * @return beneficiary_relationship - 与被保险人关系
     */
    public String getBeneficiaryRelationship() {
        return beneficiaryRelationship;
    }

    /**
     * 设置与被保险人关系
     *
     * @param beneficiaryRelationship 与被保险人关系
     */
    public void setBeneficiaryRelationship(String beneficiaryRelationship) {
        this.beneficiaryRelationship = beneficiaryRelationship;
    }

    /**
     * 获取受益人姓名
     *
     * @return beneficiary_name - 受益人姓名
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * 设置受益人姓名
     *
     * @param beneficiaryName 受益人姓名
     */
    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
    }

    /**
     * 获取受益顺序
     *
     * @return beneficiary_order - 受益顺序
     */
    public String getBeneficiaryOrder() {
        return beneficiaryOrder;
    }

    /**
     * 设置受益顺序
     *
     * @param beneficiaryOrder 受益顺序
     */
    public void setBeneficiaryOrder(String beneficiaryOrder) {
        this.beneficiaryOrder = beneficiaryOrder;
    }

    /**
     * 获取受益比例
     *
     * @return beneficiary_scale - 受益比例
     */
    public String getBeneficiaryScale() {
        return beneficiaryScale;
    }

    /**
     * 设置受益比例
     *
     * @param beneficiaryScale 受益比例
     */
    public void setBeneficiaryScale(String beneficiaryScale) {
        this.beneficiaryScale = beneficiaryScale;
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

    public BxdBeneficiary() {
    }

    public BxdBeneficiary(String detailsId) {
        this.detailsId = detailsId;
    }
}