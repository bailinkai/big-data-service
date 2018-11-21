package com.yingu.project.big.data.persistence.entity.gjj;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gjj_overdue_details")
public class GjjOverdueDetails {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 公积金uuid
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
    @Column(name = "overdue_details_id")
    private String overdueDetailsId;

    /**
     * 逾期日期
     */
    @Column(name = "overdue_date")
    private String overdueDate;

    /**
     * 逾期本金
     */
    @Column(name = "overdue_principal")
    private String overduePrincipal;

    /**
     * 逾期利息
     */
    @Column(name = "overdue_interest")
    private String overdueInterest;

    /**
     * 逾期罚息
     */
    @Column(name = "overdue_penalty")
    private String overduePenalty;

    /**
     * 合计
     */
    @Column(name = "overdue_summary")
    private String overdueSummary;

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
     * 获取公积金uuid
     *
     * @return uuid - 公积金uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置公积金uuid
     *
     * @param uuid 公积金uuid
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
     * @return overdue_details_id - 外键
     */
    public String getOverdueDetailsId() {
        return overdueDetailsId;
    }

    /**
     * 设置外键
     *
     * @param overdueDetailsId 外键
     */
    public void setOverdueDetailsId(String overdueDetailsId) {
        this.overdueDetailsId = overdueDetailsId;
    }

    /**
     * 获取逾期日期
     *
     * @return overdue_date - 逾期日期
     */
    public String getOverdueDate() {
        return overdueDate;
    }

    /**
     * 设置逾期日期
     *
     * @param overdueDate 逾期日期
     */
    public void setOverdueDate(String overdueDate) {
        this.overdueDate = overdueDate;
    }

    /**
     * 获取逾期本金
     *
     * @return overdue_principal - 逾期本金
     */
    public String getOverduePrincipal() {
        return overduePrincipal;
    }

    /**
     * 设置逾期本金
     *
     * @param overduePrincipal 逾期本金
     */
    public void setOverduePrincipal(String overduePrincipal) {
        this.overduePrincipal = overduePrincipal;
    }

    /**
     * 获取逾期利息
     *
     * @return overdue_interest - 逾期利息
     */
    public String getOverdueInterest() {
        return overdueInterest;
    }

    /**
     * 设置逾期利息
     *
     * @param overdueInterest 逾期利息
     */
    public void setOverdueInterest(String overdueInterest) {
        this.overdueInterest = overdueInterest;
    }

    /**
     * 获取逾期罚息
     *
     * @return overdue_penalty - 逾期罚息
     */
    public String getOverduePenalty() {
        return overduePenalty;
    }

    /**
     * 设置逾期罚息
     *
     * @param overduePenalty 逾期罚息
     */
    public void setOverduePenalty(String overduePenalty) {
        this.overduePenalty = overduePenalty;
    }

    /**
     * 获取合计
     *
     * @return overdue_summary - 合计
     */
    public String getOverdueSummary() {
        return overdueSummary;
    }

    /**
     * 设置合计
     *
     * @param overdueSummary 合计
     */
    public void setOverdueSummary(String overdueSummary) {
        this.overdueSummary = overdueSummary;
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

    public GjjOverdueDetails() {
    }

    public GjjOverdueDetails(String overdueDetailsId) {
        this.overdueDetailsId = overdueDetailsId;
    }
}