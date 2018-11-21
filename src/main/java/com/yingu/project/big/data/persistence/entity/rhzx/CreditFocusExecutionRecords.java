package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "credit_focus_execution_records")
public class CreditFocusExecutionRecords {
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

    @Column(name = "execution_court")
    private String executionCourt;

    /**
     * 案号
     */
    @Column(name = "case_mark")
    private String caseMark;

    /**
     * 执行案由
     */
    @Column(name = "execution_reason")
    private String executionReason;

    /**
     * 结案方式
     */
    @Column(name = "case_end_type")
    private String caseEndType;

    /**
     * 立案时间
     */
    @Column(name = "case_found_date")
    private String caseFoundDate;

    /**
     * 案件状态
     */
    @Column(name = "case_status")
    private String caseStatus;

    /**
     * 申请执行标的
     */
    @Column(name = "apply_execution")
    private String applyExecution;

    /**
     * 已执行标的
     */
    @Column(name = "already_execution")
    private String alreadyExecution;

    /**
     * 申请执行标的金额
     */
    @Column(name = "apply_excution_amount")
    private BigDecimal applyExcutionAmount;

    /**
     * 已执行标的金额
     */
    @Column(name = "already_execution_amount")
    private BigDecimal alreadyExecutionAmount;

    /**
     * 结案时间
     */
    @Column(name = "case_end_date")
    private String caseEndDate;

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
     * @return execution_court
     */
    public String getExecutionCourt() {
        return executionCourt;
    }

    /**
     * @param executionCourt
     */
    public void setExecutionCourt(String executionCourt) {
        this.executionCourt = executionCourt;
    }

    /**
     * 获取案号
     *
     * @return case_mark - 案号
     */
    public String getCaseMark() {
        return caseMark;
    }

    /**
     * 设置案号
     *
     * @param caseMark 案号
     */
    public void setCaseMark(String caseMark) {
        this.caseMark = caseMark;
    }

    /**
     * 获取执行案由
     *
     * @return execution_reason - 执行案由
     */
    public String getExecutionReason() {
        return executionReason;
    }

    /**
     * 设置执行案由
     *
     * @param executionReason 执行案由
     */
    public void setExecutionReason(String executionReason) {
        this.executionReason = executionReason;
    }

    /**
     * 获取结案方式
     *
     * @return case_end_type - 结案方式
     */
    public String getCaseEndType() {
        return caseEndType;
    }

    /**
     * 设置结案方式
     *
     * @param caseEndType 结案方式
     */
    public void setCaseEndType(String caseEndType) {
        this.caseEndType = caseEndType;
    }

    /**
     * 获取立案时间
     *
     * @return case_found_date - 立案时间
     */
    public String getCaseFoundDate() {
        return caseFoundDate;
    }

    /**
     * 设置立案时间
     *
     * @param caseFoundDate 立案时间
     */
    public void setCaseFoundDate(String caseFoundDate) {
        this.caseFoundDate = caseFoundDate;
    }

    /**
     * 获取案件状态
     *
     * @return case_status - 案件状态
     */
    public String getCaseStatus() {
        return caseStatus;
    }

    /**
     * 设置案件状态
     *
     * @param caseStatus 案件状态
     */
    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    /**
     * 获取申请执行标的
     *
     * @return apply_execution - 申请执行标的
     */
    public String getApplyExecution() {
        return applyExecution;
    }

    /**
     * 设置申请执行标的
     *
     * @param applyExecution 申请执行标的
     */
    public void setApplyExecution(String applyExecution) {
        this.applyExecution = applyExecution;
    }

    /**
     * 获取已执行标的
     *
     * @return already_execution - 已执行标的
     */
    public String getAlreadyExecution() {
        return alreadyExecution;
    }

    /**
     * 设置已执行标的
     *
     * @param alreadyExecution 已执行标的
     */
    public void setAlreadyExecution(String alreadyExecution) {
        this.alreadyExecution = alreadyExecution;
    }

    /**
     * 获取申请执行标的金额
     *
     * @return apply_excution_amount - 申请执行标的金额
     */
    public BigDecimal getApplyExcutionAmount() {
        return applyExcutionAmount;
    }

    /**
     * 设置申请执行标的金额
     *
     * @param applyExcutionAmount 申请执行标的金额
     */
    public void setApplyExcutionAmount(BigDecimal applyExcutionAmount) {
        this.applyExcutionAmount = applyExcutionAmount;
    }

    /**
     * 获取已执行标的金额
     *
     * @return already_execution_amount - 已执行标的金额
     */
    public BigDecimal getAlreadyExecutionAmount() {
        return alreadyExecutionAmount;
    }

    /**
     * 设置已执行标的金额
     *
     * @param alreadyExecutionAmount 已执行标的金额
     */
    public void setAlreadyExecutionAmount(BigDecimal alreadyExecutionAmount) {
        this.alreadyExecutionAmount = alreadyExecutionAmount;
    }

    /**
     * 获取结案时间
     *
     * @return case_end_date - 结案时间
     */
    public String getCaseEndDate() {
        return caseEndDate;
    }

    /**
     * 设置结案时间
     *
     * @param caseEndDate 结案时间
     */
    public void setCaseEndDate(String caseEndDate) {
        this.caseEndDate = caseEndDate;
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