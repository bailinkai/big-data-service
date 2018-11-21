package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.util.Date;

@Table(name = "credit_record_summaries")
public class CreditRecordSummaries {
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
     * 人行征信报告编号
     */
    @Column(name = "report_no")
    private String reportNo;

    /**
     * 账户类型
     */
    @Column(name = "credit_type")
    private Integer creditType;

    /**
     * 账户数
     */
    @Column(name = "account_num")
    private Integer accountNum;

    /**
     * 未结清、未销户账户数
     */
    @Column(name = "un_settle_un_cancel")
    private Integer unSettleUnCancel;

    /**
     * 发生过逾期的账户数
     */
    @Column(name = "overdue_account")
    private Integer overdueAccount;

    /**
     * 发生过90天以上逾期的账户数
     */
    @Column(name = "overdue_ninety")
    private Integer overdueNinety;

    /**
     * 为他人担保笔数
     */
    private Integer guarantee;

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
     * 获取人行征信报告编号
     *
     * @return report_no - 人行征信报告编号
     */
    public String getReportNo() {
        return reportNo;
    }

    /**
     * 设置人行征信报告编号
     *
     * @param reportNo 人行征信报告编号
     */
    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    /**
     * 获取账户类型
     *
     * @return credit_type - 账户类型
     */
    public Integer getCreditType() {
        return creditType;
    }

    /**
     * 设置账户类型
     *
     * @param creditType 账户类型
     */
    public void setCreditType(Integer creditType) {
        this.creditType = creditType;
    }

    /**
     * 获取账户数
     *
     * @return account_num - 账户数
     */
    public Integer getAccountNum() {
        return accountNum;
    }

    /**
     * 设置账户数
     *
     * @param accountNum 账户数
     */
    public void setAccountNum(Integer accountNum) {
        this.accountNum = accountNum;
    }

    /**
     * 获取未结清、未销户账户数
     *
     * @return un_settle_un_cancel - 未结清、未销户账户数
     */
    public Integer getUnSettleUnCancel() {
        return unSettleUnCancel;
    }

    /**
     * 设置未结清、未销户账户数
     *
     * @param unSettleUnCancel 未结清、未销户账户数
     */
    public void setUnSettleUnCancel(Integer unSettleUnCancel) {
        this.unSettleUnCancel = unSettleUnCancel;
    }

    /**
     * 获取发生过逾期的账户数
     *
     * @return overdue_account - 发生过逾期的账户数
     */
    public Integer getOverdueAccount() {
        return overdueAccount;
    }

    /**
     * 设置发生过逾期的账户数
     *
     * @param overdueAccount 发生过逾期的账户数
     */
    public void setOverdueAccount(Integer overdueAccount) {
        this.overdueAccount = overdueAccount;
    }

    /**
     * 获取发生过90天以上逾期的账户数
     *
     * @return overdue_ninety - 发生过90天以上逾期的账户数
     */
    public Integer getOverdueNinety() {
        return overdueNinety;
    }

    /**
     * 设置发生过90天以上逾期的账户数
     *
     * @param overdueNinety 发生过90天以上逾期的账户数
     */
    public void setOverdueNinety(Integer overdueNinety) {
        this.overdueNinety = overdueNinety;
    }

    /**
     * 获取为他人担保笔数
     *
     * @return guarantee - 为他人担保笔数
     */
    public Integer getGuarantee() {
        return guarantee;
    }

    /**
     * 设置为他人担保笔数
     *
     * @param guarantee 为他人担保笔数
     */
    public void setGuarantee(Integer guarantee) {
        this.guarantee = guarantee;
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