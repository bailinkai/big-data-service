package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "credit_administrative_penalty_records")
public class CreditAdministrativePenaltyRecords {
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
     * 处罚机构
     */
    private String institution;

    /**
     * 处罚内容
     */
    private String penalty;

    /**
     * 文书编号
     */
    @Column(name = "archive_num")
    private String archiveNum;

    /**
     * 是否行政复议
     */
    @Column(name = "administrative_review")
    private String administrativeReview;

    /**
     * 处罚金额
     */
    @Column(name = "penalty_amount")
    private BigDecimal penaltyAmount;

    /**
     * 行政复议结果
     */
    @Column(name = "review_result")
    private String reviewResult;

    /**
     * 处罚生效时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 处罚截止时间
     */
    @Column(name = "end_time")
    private String endTime;

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
     * 获取处罚机构
     *
     * @return institution - 处罚机构
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 设置处罚机构
     *
     * @param institution 处罚机构
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * 获取处罚内容
     *
     * @return penalty - 处罚内容
     */
    public String getPenalty() {
        return penalty;
    }

    /**
     * 设置处罚内容
     *
     * @param penalty 处罚内容
     */
    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }

    /**
     * 获取文书编号
     *
     * @return archive_num - 文书编号
     */
    public String getArchiveNum() {
        return archiveNum;
    }

    /**
     * 设置文书编号
     *
     * @param archiveNum 文书编号
     */
    public void setArchiveNum(String archiveNum) {
        this.archiveNum = archiveNum;
    }

    /**
     * 获取是否行政复议
     *
     * @return administrative_review - 是否行政复议
     */
    public String getAdministrativeReview() {
        return administrativeReview;
    }

    /**
     * 设置是否行政复议
     *
     * @param administrativeReview 是否行政复议
     */
    public void setAdministrativeReview(String administrativeReview) {
        this.administrativeReview = administrativeReview;
    }

    /**
     * 获取处罚金额
     *
     * @return penalty_amount - 处罚金额
     */
    public BigDecimal getPenaltyAmount() {
        return penaltyAmount;
    }

    /**
     * 设置处罚金额
     *
     * @param penaltyAmount 处罚金额
     */
    public void setPenaltyAmount(BigDecimal penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    /**
     * 获取行政复议结果
     *
     * @return review_result - 行政复议结果
     */
    public String getReviewResult() {
        return reviewResult;
    }

    /**
     * 设置行政复议结果
     *
     * @param reviewResult 行政复议结果
     */
    public void setReviewResult(String reviewResult) {
        this.reviewResult = reviewResult;
    }

    /**
     * 获取处罚生效时间
     *
     * @return start_time - 处罚生效时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置处罚生效时间
     *
     * @param startTime 处罚生效时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取处罚截止时间
     *
     * @return end_time - 处罚截止时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置处罚截止时间
     *
     * @param endTime 处罚截止时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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