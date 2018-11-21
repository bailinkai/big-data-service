package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.util.Date;

@Table(name = "credit_query_info_details")
public class CreditQueryInfoDetails {
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
     * 记录查询时间
     */
    @Column(name = "query_date_time")
    private String queryDateTime;

    /**
     * 查询操作员
     */
    @Column(name = "query_operator")
    private String queryOperator;

    /**
     * 查询原因
     */
    @Column(name = "query_reason")
    private String queryReason;

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
     * 获取记录查询时间
     *
     * @return query_date_time - 记录查询时间
     */
    public String getQueryDateTime() {
        return queryDateTime;
    }

    /**
     * 设置记录查询时间
     *
     * @param queryDateTime 记录查询时间
     */
    public void setQueryDateTime(String queryDateTime) {
        this.queryDateTime = queryDateTime;
    }

    /**
     * 获取查询操作员
     *
     * @return query_operator - 查询操作员
     */
    public String getQueryOperator() {
        return queryOperator;
    }

    /**
     * 设置查询操作员
     *
     * @param queryOperator 查询操作员
     */
    public void setQueryOperator(String queryOperator) {
        this.queryOperator = queryOperator;
    }

    /**
     * 获取查询原因
     *
     * @return query_reason - 查询原因
     */
    public String getQueryReason() {
        return queryReason;
    }

    /**
     * 设置查询原因
     *
     * @param queryReason 查询原因
     */
    public void setQueryReason(String queryReason) {
        this.queryReason = queryReason;
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