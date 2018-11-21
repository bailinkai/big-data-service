package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "credit_housing_loan_record_detail_analyzes")
public class CreditHousingLoanRecordDetailAnalyzes {
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
     * 贷款发放时间
     */
    @Column(name = "grant_date")
    private String grantDate;

    /**
     * 发放贷款的银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 贷款币种
     */
    private String currency;

    /**
     * 购房贷款总金额
     */
    @Column(name = "loan_amount")
    private BigDecimal loanAmount;

    /**
     * 贷款对象
     */
    @Column(name = "loan_item")
    private String loanItem;

    /**
     * 购房贷款到期日
     */
    @Column(name = "expiration_date")
    private String expirationDate;

    /**
     * 本征信报告获取该购房贷款信息的最后时间
     */
    @Column(name = "cutoff_date")
    private String cutoffDate;

    /**
     * 购房贷款是否已结清
     */
    @Column(name = "is_closeout")
    private Boolean isCloseout;

    /**
     * 购房贷款余额
     */
    @Column(name = "remain_balance")
    private BigDecimal remainBalance;

    /**
     * 购房贷款是否有逾期
     */
    @Column(name = "is_overdue")
    private Boolean isOverdue;

    /**
     * 购房贷款有逾期的月数
     */
    @Column(name = "overdue_month")
    private Integer overdueMonth;

    /**
     * 逾期金额
     */
    @Column(name = "overdue_amount")
    private BigDecimal overdueAmount;

    /**
     * 购房贷款是否有超过90天的逾期
     */
    @Column(name = "is_nintydays_overdue")
    private Boolean isNintydaysOverdue;

    /**
     * 购房贷款逾期超过90天的月数
     */
    @Column(name = "nintydays_overdue_month")
    private Integer nintydaysOverdueMonth;

    /**
     * 是否已转出
     */
    private Boolean transfer;

    /**
     * 转出日期
     */
    @Column(name = "transfer_date")
    private String transferDate;

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
     * 获取贷款发放时间
     *
     * @return grant_date - 贷款发放时间
     */
    public String getGrantDate() {
        return grantDate;
    }

    /**
     * 设置贷款发放时间
     *
     * @param grantDate 贷款发放时间
     */
    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    /**
     * 获取发放贷款的银行名称
     *
     * @return bank_name - 发放贷款的银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置发放贷款的银行名称
     *
     * @param bankName 发放贷款的银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取贷款币种
     *
     * @return currency - 贷款币种
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 设置贷款币种
     *
     * @param currency 贷款币种
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 获取购房贷款总金额
     *
     * @return loan_amount - 购房贷款总金额
     */
    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    /**
     * 设置购房贷款总金额
     *
     * @param loanAmount 购房贷款总金额
     */
    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * 获取贷款对象
     *
     * @return loan_item - 贷款对象
     */
    public String getLoanItem() {
        return loanItem;
    }

    /**
     * 设置贷款对象
     *
     * @param loanItem 贷款对象
     */
    public void setLoanItem(String loanItem) {
        this.loanItem = loanItem;
    }

    /**
     * 获取购房贷款到期日
     *
     * @return expiration_date - 购房贷款到期日
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * 设置购房贷款到期日
     *
     * @param expirationDate 购房贷款到期日
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * 获取本征信报告获取该购房贷款信息的最后时间
     *
     * @return cutoff_date - 本征信报告获取该购房贷款信息的最后时间
     */
    public String getCutoffDate() {
        return cutoffDate;
    }

    /**
     * 设置本征信报告获取该购房贷款信息的最后时间
     *
     * @param cutoffDate 本征信报告获取该购房贷款信息的最后时间
     */
    public void setCutoffDate(String cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    /**
     * 获取购房贷款是否已结清
     *
     * @return is_closeout - 购房贷款是否已结清
     */
    public Boolean getIsCloseout() {
        return isCloseout;
    }

    /**
     * 设置购房贷款是否已结清
     *
     * @param isCloseout 购房贷款是否已结清
     */
    public void setIsCloseout(Boolean isCloseout) {
        this.isCloseout = isCloseout;
    }

    /**
     * 获取购房贷款余额
     *
     * @return remain_balance - 购房贷款余额
     */
    public BigDecimal getRemainBalance() {
        return remainBalance;
    }

    /**
     * 设置购房贷款余额
     *
     * @param remainBalance 购房贷款余额
     */
    public void setRemainBalance(BigDecimal remainBalance) {
        this.remainBalance = remainBalance;
    }

    /**
     * 获取购房贷款是否有逾期
     *
     * @return is_overdue - 购房贷款是否有逾期
     */
    public Boolean getIsOverdue() {
        return isOverdue;
    }

    /**
     * 设置购房贷款是否有逾期
     *
     * @param isOverdue 购房贷款是否有逾期
     */
    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    /**
     * 获取购房贷款有逾期的月数
     *
     * @return overdue_month - 购房贷款有逾期的月数
     */
    public Integer getOverdueMonth() {
        return overdueMonth;
    }

    /**
     * 设置购房贷款有逾期的月数
     *
     * @param overdueMonth 购房贷款有逾期的月数
     */
    public void setOverdueMonth(Integer overdueMonth) {
        this.overdueMonth = overdueMonth;
    }

    /**
     * 获取逾期金额
     *
     * @return overdue_amount - 逾期金额
     */
    public BigDecimal getOverdueAmount() {
        return overdueAmount;
    }

    /**
     * 设置逾期金额
     *
     * @param overdueAmount 逾期金额
     */
    public void setOverdueAmount(BigDecimal overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    /**
     * 获取购房贷款是否有超过90天的逾期
     *
     * @return is_nintydays_overdue - 购房贷款是否有超过90天的逾期
     */
    public Boolean getIsNintydaysOverdue() {
        return isNintydaysOverdue;
    }

    /**
     * 设置购房贷款是否有超过90天的逾期
     *
     * @param isNintydaysOverdue 购房贷款是否有超过90天的逾期
     */
    public void setIsNintydaysOverdue(Boolean isNintydaysOverdue) {
        this.isNintydaysOverdue = isNintydaysOverdue;
    }

    /**
     * 获取购房贷款逾期超过90天的月数
     *
     * @return nintydays_overdue_month - 购房贷款逾期超过90天的月数
     */
    public Integer getNintydaysOverdueMonth() {
        return nintydaysOverdueMonth;
    }

    /**
     * 设置购房贷款逾期超过90天的月数
     *
     * @param nintydaysOverdueMonth 购房贷款逾期超过90天的月数
     */
    public void setNintydaysOverdueMonth(Integer nintydaysOverdueMonth) {
        this.nintydaysOverdueMonth = nintydaysOverdueMonth;
    }

    /**
     * 获取是否已转出
     *
     * @return transfer - 是否已转出
     */
    public Boolean getTransfer() {
        return transfer;
    }

    /**
     * 设置是否已转出
     *
     * @param transfer 是否已转出
     */
    public void setTransfer(Boolean transfer) {
        this.transfer = transfer;
    }

    /**
     * 获取转出日期
     *
     * @return transfer_date - 转出日期
     */
    public String getTransferDate() {
        return transferDate;
    }

    /**
     * 设置转出日期
     *
     * @param transferDate 转出日期
     */
    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
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