package com.yingu.project.big.data.persistence.entity.sb;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sb_detail")
public class SbDetail {
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
     * 外键
     */
    @Column(name = "details_id")
    private String detailsId;

    /**
     * 缴费总计
     */
    @Column(name = "total_pay")
    private String totalPay;

    /**
     * 缴费结束时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 社保种类
     */
    @Column(name = "soins_type")
    private String soinsType;

    /**
     * 缴费性质(默认为缴费，缴费的话为空值，若不是缴费，会有具体的描述)
     */
    @Column(name = "soins_nature")
    private String soinsNature;

    /**
     * 缴费基数
     */
    @Column(name = "pay_cardi")
    private String payCardi;

    /**
     * 缴费开始时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 个人缴费
     */
    @Column(name = "pson_pay")
    private String psonPay;

    /**
     * 单位缴费
     */
    @Column(name = "comp_pay")
    private String compPay;

    /**
     * 缴费月数
     */
    @Column(name = "pay_months")
    private String payMonths;

    /**
     * 所属单位
     */
    @Column(name = "soins_company")
    private String soinsCompany;

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
     * 获取缴费总计
     *
     * @return total_pay - 缴费总计
     */
    public String getTotalPay() {
        return totalPay;
    }

    /**
     * 设置缴费总计
     *
     * @param totalPay 缴费总计
     */
    public void setTotalPay(String totalPay) {
        this.totalPay = totalPay;
    }

    /**
     * 获取缴费结束时间
     *
     * @return end_time - 缴费结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置缴费结束时间
     *
     * @param endTime 缴费结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取社保种类
     *
     * @return soins_type - 社保种类
     */
    public String getSoinsType() {
        return soinsType;
    }

    /**
     * 设置社保种类
     *
     * @param soinsType 社保种类
     */
    public void setSoinsType(String soinsType) {
        this.soinsType = soinsType;
    }

    /**
     * 获取缴费性质(默认为缴费，缴费的话为空值，若不是缴费，会有具体的描述)
     *
     * @return soins_nature - 缴费性质(默认为缴费，缴费的话为空值，若不是缴费，会有具体的描述)
     */
    public String getSoinsNature() {
        return soinsNature;
    }

    /**
     * 设置缴费性质(默认为缴费，缴费的话为空值，若不是缴费，会有具体的描述)
     *
     * @param soinsNature 缴费性质(默认为缴费，缴费的话为空值，若不是缴费，会有具体的描述)
     */
    public void setSoinsNature(String soinsNature) {
        this.soinsNature = soinsNature;
    }

    /**
     * 获取缴费基数
     *
     * @return pay_cardi - 缴费基数
     */
    public String getPayCardi() {
        return payCardi;
    }

    /**
     * 设置缴费基数
     *
     * @param payCardi 缴费基数
     */
    public void setPayCardi(String payCardi) {
        this.payCardi = payCardi;
    }

    /**
     * 获取缴费开始时间
     *
     * @return start_time - 缴费开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置缴费开始时间
     *
     * @param startTime 缴费开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取个人缴费
     *
     * @return pson_pay - 个人缴费
     */
    public String getPsonPay() {
        return psonPay;
    }

    /**
     * 设置个人缴费
     *
     * @param psonPay 个人缴费
     */
    public void setPsonPay(String psonPay) {
        this.psonPay = psonPay;
    }

    /**
     * 获取单位缴费
     *
     * @return comp_pay - 单位缴费
     */
    public String getCompPay() {
        return compPay;
    }

    /**
     * 设置单位缴费
     *
     * @param compPay 单位缴费
     */
    public void setCompPay(String compPay) {
        this.compPay = compPay;
    }

    /**
     * 获取缴费月数
     *
     * @return pay_months - 缴费月数
     */
    public String getPayMonths() {
        return payMonths;
    }

    /**
     * 设置缴费月数
     *
     * @param payMonths 缴费月数
     */
    public void setPayMonths(String payMonths) {
        this.payMonths = payMonths;
    }

    /**
     * 获取所属单位
     *
     * @return soins_company - 所属单位
     */
    public String getSoinsCompany() {
        return soinsCompany;
    }

    /**
     * 设置所属单位
     *
     * @param soinsCompany 所属单位
     */
    public void setSoinsCompany(String soinsCompany) {
        this.soinsCompany = soinsCompany;
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

    public SbDetail() {
    }

    public SbDetail(String detailsId) {
        this.detailsId = detailsId;
    }
}