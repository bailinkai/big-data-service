package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.util.Date;

@Table(name = "credit_record_details")
public class CreditRecordDetails {
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
     * 记录唯一ID
     */
    @Column(name = "auto_id")
    private Integer autoId;

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
     * 信贷类型
     */
    @Column(name = "credit_type")
    private Integer creditType;

    /**
     * 账户类型
     */
    @Column(name = "account_type")
    private Integer accountType;

    /**
     * 账户明细
     */
    private String content;

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
     * 获取记录唯一ID
     *
     * @return auto_id - 记录唯一ID
     */
    public Integer getAutoId() {
        return autoId;
    }

    /**
     * 设置记录唯一ID
     *
     * @param autoId 记录唯一ID
     */
    public void setAutoId(Integer autoId) {
        this.autoId = autoId;
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
     * 获取信贷类型
     *
     * @return credit_type - 信贷类型
     */
    public Integer getCreditType() {
        return creditType;
    }

    /**
     * 设置信贷类型
     *
     * @param creditType 信贷类型
     */
    public void setCreditType(Integer creditType) {
        this.creditType = creditType;
    }

    /**
     * 获取账户类型
     *
     * @return account_type - 账户类型
     */
    public Integer getAccountType() {
        return accountType;
    }

    /**
     * 设置账户类型
     *
     * @param accountType 账户类型
     */
    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取账户明细
     *
     * @return content - 账户明细
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置账户明细
     *
     * @param content 账户明细
     */
    public void setContent(String content) {
        this.content = content;
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