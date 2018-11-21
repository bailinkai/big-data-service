package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "credit_guarantee_record_detail_analyzes")
public class CreditGuaranteeRecordDetailAnalyzes {
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
     * autoId
     */
    @Column(name = "record_detail_auto_id")
    private Integer recordDetailAutoId;

    /**
     * 担保日期
     */
    @Column(name = "guarantee_date")
    private String guaranteeDate;

    /**
     * 被担保人
     */
    @Column(name = "warrantee")
    private String warrantee;
    /**
     * 被担保人证件类型
     */
    @Column(name = "id_type")
    private String idType;

    /**
     * 被担保人证件号码
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 担保对象
     */
    @Column(name = "guarantee_item")
    private String guaranteeItem;

    /**
     * 单号合同金额、信用卡授信额度
     */
    @Column(name = "loan_amount")
    private BigDecimal loanAmount;

    /**
     * 担保金额
     */
    @Column(name = "guarantee_amount")
    private BigDecimal guaranteeAmount;

    /**
     * 截止日期
     */
    @Column(name = "cuttoff_date")
    private String cuttoffDate;

    /**
     * 担保贷款余额
     */
    @Column(name = "remain_balance")
    private BigDecimal remainBalance;

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
     * 获取autoId
     *
     * @return record_detail_auto_id - autoId
     */
    public Integer getRecordDetailAutoId() {
        return recordDetailAutoId;
    }

    /**
     * 设置autoId
     *
     * @param recordDetailAutoId autoId
     */
    public void setRecordDetailAutoId(Integer recordDetailAutoId) {
        this.recordDetailAutoId = recordDetailAutoId;
    }

    /**
     * 获取担保日期
     *
     * @return guarantee_date - 担保日期
     */
    public String getGuaranteeDate() {
        return guaranteeDate;
    }

    /**
     * 设置担保日期
     *
     * @param guaranteeDate 担保日期
     */
    public void setGuaranteeDate(String guaranteeDate) {
        this.guaranteeDate = guaranteeDate;
    }

    /**
     * 获取被担保人证件类型
     *
     * @return id_type - 被担保人证件类型
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置被担保人证件类型
     *
     * @param idType 被担保人证件类型
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * 获取被担保人证件号码
     *
     * @return id_number - 被担保人证件号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置被担保人证件号码
     *
     * @param idNumber 被担保人证件号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * 获取担保对象
     *
     * @return guarantee_item - 担保对象
     */
    public String getGuaranteeItem() {
        return guaranteeItem;
    }

    /**
     * 设置担保对象
     *
     * @param guaranteeItem 担保对象
     */
    public void setGuaranteeItem(String guaranteeItem) {
        this.guaranteeItem = guaranteeItem;
    }

    /**
     * 获取单号合同金额、信用卡授信额度
     *
     * @return loan_amount - 单号合同金额、信用卡授信额度
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * 设置单号合同金额、信用卡授信额度
     *
     * @param loanAmount 单号合同金额、信用卡授信额度
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * 获取担保金额
     *
     * @return guarantee_amount - 担保金额
     */
    public BigDecimal getGuaranteeAmount() {
        return guaranteeAmount;
    }

    /**
     * 设置担保金额
     *
     * @param guaranteeAmount 担保金额
     */
    public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
        this.guaranteeAmount = guaranteeAmount;
    }

    /**
     * 获取截止日期
     *
     * @return cuttoff_date - 截止日期
     */
    public String getCuttoffDate() {
        return cuttoffDate;
    }

    /**
     * 设置截止日期
     *
     * @param cuttoffDate 截止日期
     */
    public void setCuttoffDate(String cuttoffDate) {
        this.cuttoffDate = cuttoffDate;
    }

    /**
     * 获取担保贷款余额
     *
     * @return remain_balance - 担保贷款余额
     */
    public BigDecimal getRemainBalance() {
        return remainBalance;
    }

    /**
     * 设置担保贷款余额
     *
     * @param remainBalance 担保贷款余额
     */
    public void setRemainBalance(BigDecimal remainBalance) {
        this.remainBalance = remainBalance;
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

    public String getWarrantee() {
        return warrantee;
    }

    public void setWarrantee(String warrantee) {
        this.warrantee = warrantee;
    }
}