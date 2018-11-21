package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "credit_card_record_detail_analyzes")
public class CreditCardRecordDetailAnalyzes {
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
     * 信用卡发放时间
     */
    @Column(name = "grant_date")
    private String grantDate;

    /**
     * 发放信用卡的银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 信用卡类型
     */
    @Column(name = "card_type")
    private String cardType;

    /**
     * 账户币种
     */
    @Column(name = "account_currency")
    private String accountCurrency;

    /**
     * 获取本信用卡信息的最后时间
     */
    @Column(name = "cutoff_date")
    private String cutoffDate;

    /**
     * 信用额度
     */
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    /**
     * 已使用额度
     */
    @Column(name = "used_credit_line")
    private BigDecimal usedCreditLine;

    /**
     * 透支金额
     */
    @Column(name = "overdraft_balance")
    private BigDecimal overdraftBalance;

    /**
     * 逾期金额
     */
    @Column(name = "overdue_amount")
    private BigDecimal overdueAmount;

    /**
     * 该账户是否激活过
     */
    @Column(name = "is_actived")
    private Boolean isActived;

    /**
     * 该账户是否已销户
     */
    @Column(name = "is_closed")
    private Boolean isClosed;

    /**
     * 该账户是否有逾期记录
     */
    @Column(name = "is_overdue")
    private Boolean isOverdue;

    /**
     * 有过逾期记录的月数
     */
    @Column(name = "overdue_nonth")
    private Integer overdueNonth;

    /**
     * 准贷记卡账户是否有大于60天逾期
     */
    @Column(name = "is_sixtydays_overdraft")
    private Boolean isSixtydaysOverdraft;

    /**
     * 准贷记卡是否有超过60天逾期记录月数
     */
    @Column(name = "sixtydays_overdraft_nonth")
    private Integer sixtydaysOverdraftNonth;

    /**
     * 该账户是否有超过90天逾期
     */
    @Column(name = "is_nintydays_overdue")
    private Boolean isNintydaysOverdue;

    /**
     * 该账户有超过90天逾期记录月数
     */
    @Column(name = "nintydays_overdue_nonth")
    private Integer nintydaysOverdueNonth;

    /**
     * 是否已变成呆账
     */
    @Column(name = "bad_debts")
    private Boolean badDebts;

    /**
     * 余额(人民币)
     */
    @Column(name = "remaining_sum")
    private BigDecimal remainingSum;

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
     * 获取信用卡发放时间
     *
     * @return grant_date - 信用卡发放时间
     */
    public String getGrantDate() {
        return grantDate;
    }

    /**
     * 设置信用卡发放时间
     *
     * @param grantDate 信用卡发放时间
     */
    public void setGrantDate(String grantDate) {
        this.grantDate = grantDate;
    }

    /**
     * 获取发放信用卡的银行名称
     *
     * @return bank_name - 发放信用卡的银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置发放信用卡的银行名称
     *
     * @param bankName 发放信用卡的银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取信用卡类型
     *
     * @return card_type - 信用卡类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 设置信用卡类型
     *
     * @param cardType 信用卡类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * 获取账户币种
     *
     * @return account_currency - 账户币种
     */
    public String getAccountCurrency() {
        return accountCurrency;
    }

    /**
     * 设置账户币种
     *
     * @param accountCurrency 账户币种
     */
    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    /**
     * 获取获取本信用卡信息的最后时间
     *
     * @return cutoff_date - 获取本信用卡信息的最后时间
     */
    public String getCutoffDate() {
        return cutoffDate;
    }

    /**
     * 设置获取本信用卡信息的最后时间
     *
     * @param cutoffDate 获取本信用卡信息的最后时间
     */
    public void setCutoffDate(String cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    /**
     * 获取信用额度
     *
     * @return credit_limit - 信用额度
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * 设置信用额度
     *
     * @param creditLimit 信用额度
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * 获取已使用额度
     *
     * @return used_credit_line - 已使用额度
     */
    public BigDecimal getUsedCreditLine() {
        return usedCreditLine;
    }

    /**
     * 设置已使用额度
     *
     * @param usedCreditLine 已使用额度
     */
    public void setUsedCreditLine(BigDecimal usedCreditLine) {
        this.usedCreditLine = usedCreditLine;
    }

    /**
     * 获取透支金额
     *
     * @return overdraft_balance - 透支金额
     */
    public BigDecimal getOverdraftBalance() {
        return overdraftBalance;
    }

    /**
     * 设置透支金额
     *
     * @param overdraftBalance 透支金额
     */
    public void setOverdraftBalance(BigDecimal overdraftBalance) {
        this.overdraftBalance = overdraftBalance;
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
     * 获取该账户是否激活过
     *
     * @return is_actived - 该账户是否激活过
     */
    public Boolean getIsActived() {
        return isActived;
    }

    /**
     * 设置该账户是否激活过
     *
     * @param isActived 该账户是否激活过
     */
    public void setIsActived(Boolean isActived) {
        this.isActived = isActived;
    }

    /**
     * 获取该账户是否已销户
     *
     * @return is_closed - 该账户是否已销户
     */
    public Boolean getIsClosed() {
        return isClosed;
    }

    /**
     * 设置该账户是否已销户
     *
     * @param isClosed 该账户是否已销户
     */
    public void setIsClosed(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    /**
     * 获取该账户是否有逾期记录
     *
     * @return is_overdue - 该账户是否有逾期记录
     */
    public Boolean getIsOverdue() {
        return isOverdue;
    }

    /**
     * 设置该账户是否有逾期记录
     *
     * @param isOverdue 该账户是否有逾期记录
     */
    public void setIsOverdue(Boolean isOverdue) {
        this.isOverdue = isOverdue;
    }

    /**
     * 获取有过逾期记录的月数
     *
     * @return overdue_nonth - 有过逾期记录的月数
     */
    public Integer getOverdueNonth() {
        return overdueNonth;
    }

    /**
     * 设置有过逾期记录的月数
     *
     * @param overdueNonth 有过逾期记录的月数
     */
    public void setOverdueNonth(Integer overdueNonth) {
        this.overdueNonth = overdueNonth;
    }

    /**
     * 获取准贷记卡账户是否有大于60天逾期
     *
     * @return is_sixtydays_overdraft - 准贷记卡账户是否有大于60天逾期
     */
    public Boolean getIsSixtydaysOverdraft() {
        return isSixtydaysOverdraft;
    }

    /**
     * 设置准贷记卡账户是否有大于60天逾期
     *
     * @param isSixtydaysOverdraft 准贷记卡账户是否有大于60天逾期
     */
    public void setIsSixtydaysOverdraft(Boolean isSixtydaysOverdraft) {
        this.isSixtydaysOverdraft = isSixtydaysOverdraft;
    }

    /**
     * 获取准贷记卡是否有超过60天逾期记录月数
     *
     * @return sixtydays_overdraft_nonth - 准贷记卡是否有超过60天逾期记录月数
     */
    public Integer getSixtydaysOverdraftNonth() {
        return sixtydaysOverdraftNonth;
    }

    /**
     * 设置准贷记卡是否有超过60天逾期记录月数
     *
     * @param sixtydaysOverdraftNonth 准贷记卡是否有超过60天逾期记录月数
     */
    public void setSixtydaysOverdraftNonth(Integer sixtydaysOverdraftNonth) {
        this.sixtydaysOverdraftNonth = sixtydaysOverdraftNonth;
    }

    /**
     * 获取该账户是否有超过90天逾期
     *
     * @return is_nintydays_overdue - 该账户是否有超过90天逾期
     */
    public Boolean getIsNintydaysOverdue() {
        return isNintydaysOverdue;
    }

    /**
     * 设置该账户是否有超过90天逾期
     *
     * @param isNintydaysOverdue 该账户是否有超过90天逾期
     */
    public void setIsNintydaysOverdue(Boolean isNintydaysOverdue) {
        this.isNintydaysOverdue = isNintydaysOverdue;
    }

    /**
     * 获取该账户有超过90天逾期记录月数
     *
     * @return nintydays_overdue_nonth - 该账户有超过90天逾期记录月数
     */
    public Integer getNintydaysOverdueNonth() {
        return nintydaysOverdueNonth;
    }

    /**
     * 设置该账户有超过90天逾期记录月数
     *
     * @param nintydaysOverdueNonth 该账户有超过90天逾期记录月数
     */
    public void setNintydaysOverdueNonth(Integer nintydaysOverdueNonth) {
        this.nintydaysOverdueNonth = nintydaysOverdueNonth;
    }

    /**
     * 获取是否已变成呆账
     *
     * @return bad_debts - 是否已变成呆账
     */
    public Boolean getBadDebts() {
        return badDebts;
    }

    /**
     * 设置是否已变成呆账
     *
     * @param badDebts 是否已变成呆账
     */
    public void setBadDebts(Boolean badDebts) {
        this.badDebts = badDebts;
    }

    /**
     * 获取余额(人民币)
     *
     * @return remaining_sum - 余额(人民币)
     */
    public BigDecimal getRemainingSum() {
        return remainingSum;
    }

    /**
     * 设置余额(人民币)
     *
     * @param remainingSum 余额(人民币)
     */
    public void setRemainingSum(BigDecimal remainingSum) {
        this.remainingSum = remainingSum;
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