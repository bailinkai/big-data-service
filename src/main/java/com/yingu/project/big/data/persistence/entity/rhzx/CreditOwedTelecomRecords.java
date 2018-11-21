package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "credit_owed_telecom_records")
public class CreditOwedTelecomRecords {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 人行征信uuid
     */
    private String uuid;

    /**
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 映射ID
     */
    @Column(name = "mapping_id")
    private String mappingId;

    /**
     * 报告编号
     */
    @Column(name = "report_no")
    private String reportNo;

    /**
     * 电信运营商
     */
    @Column(name = "carrier_name")
    private String carrierName;

    /**
     * 业务类型
     */
    @Column(name = "business_type")
    private String businessType;

    /**
     * 记账年月
     */
    @Column(name = "bookkeeping_date")
    private String bookkeepingDate;

    /**
     * 业务开通时间
     */
    @Column(name = "service_open_time")
    private String serviceOpenTime;

    /**
     * 欠费金额
     */
    @Column(name = "owed_amount")
    private BigDecimal owedAmount;

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
     * 获取人行征信uuid
     *
     * @return uuid - 人行征信uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置人行征信uuid
     *
     * @param uuid 人行征信uuid
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
     * 获取映射ID
     *
     * @return mapping_id - 映射ID
     */
    public String getMappingId() {
        return mappingId;
    }

    /**
     * 设置映射ID
     *
     * @param mappingId 映射ID
     */
    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    /**
     * 获取报告编号
     *
     * @return report_no - 报告编号
     */
    public String getReportNo() {
        return reportNo;
    }

    /**
     * 设置报告编号
     *
     * @param reportNo 报告编号
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    /**
     * 获取电信运营商
     *
     * @return carrier_name - 电信运营商
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * 设置电信运营商
     *
     * @param carrierName 电信运营商
     */
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    /**
     * 获取业务类型
     *
     * @return business_type - 业务类型
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置业务类型
     *
     * @param businessType 业务类型
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取记账年月
     *
     * @return bookkeeping_date - 记账年月
     */
    public String getBookkeepingDate() {
        return bookkeepingDate;
    }

    /**
     * 设置记账年月
     *
     * @param bookkeepingDate 记账年月
     */
    public void setBookkeepingDate(String bookkeepingDate) {
        this.bookkeepingDate = bookkeepingDate;
    }

    /**
     * 获取业务开通时间
     *
     * @return service_open_time - 业务开通时间
     */
    public String getServiceOpenTime() {
        return serviceOpenTime;
    }

    /**
     * 设置业务开通时间
     *
     * @param serviceOpenTime 业务开通时间
     */
    public void setServiceOpenTime(String serviceOpenTime) {
        this.serviceOpenTime = serviceOpenTime;
    }

    /**
     * 获取欠费金额
     *
     * @return owed_amount - 欠费金额
     */
    public BigDecimal getOwedAmount() {
        return owedAmount;
    }

    /**
     * 设置欠费金额
     *
     * @param owedAmount 欠费金额
     */
    public void setOwedAmount(BigDecimal owedAmount) {
        this.owedAmount = owedAmount;
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