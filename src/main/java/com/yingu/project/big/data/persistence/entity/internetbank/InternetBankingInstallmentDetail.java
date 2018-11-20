package com.yingu.project.big.data.persistence.entity.internetbank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "internet_banking_installment_detail")
public class InternetBankingInstallmentDetail {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * uuid
     */
    private String uuid;

    /**
     * 订单编号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 分期ID
     */
    @Column(name = "installments_id")
    private String installmentsId;

    /**
     * 消费记录ID
     */
    @Column(name = "shoppingsheet_id")
    private String shoppingsheetId;

    /**
     * 记账日期
     */
    @Column(name = "post_date")
    private String postDate;

    /**
     * 交易时间
     */
    @Column(name = "trans_date")
    private Date transDate;

    /**
     * 分期描述
     */
    @Column(name = "installment_desc")
    private String installmentDesc;

    /**
     * 分期手续费描述
     */
    @Column(name = "handingfee_desc")
    private String handingfeeDesc;

    /**
     * 分期转账手续费描述
     */
    @Column(name = "transferfee_desc")
    private String transferfeeDesc;

    /**
     * 分期类型(CONSUME-消费; CASH-现金; BILL-账单)
     */
    @Column(name = "installment_type")
    private String installmentType;

    /**
     * 总分期数
     */
    @Column(name = "total_month")
    private Short totalMonth;

    /**
     * 当前分期数
     */
    @Column(name = "current_month")
    private Short currentMonth;

    /**
     * 币种. CNY-人民币; USD-美元 ; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     */
    @Column(name = "currency_type")
    private String currencyType;

    /**
     * 本期金额
     */
    @Column(name = "amount_money")
    private BigDecimal amountMoney;

    /**
     * 本期手续费
     */
    @Column(name = "handing_fee")
    private BigDecimal handingFee;

    /**
     * 转账手续费
     */
    @Column(name = "transfer_fee")
    private BigDecimal transferFee;

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
     * 获取uuid
     *
     * @return uuid - uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置uuid
     *
     * @param uuid uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取订单编号
     *
     * @return order_num - 订单编号
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置订单编号
     *
     * @param orderNum 订单编号
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取分期ID
     *
     * @return installments_id - 分期ID
     */
    public String getInstallmentsId() {
        return installmentsId;
    }

    /**
     * 设置分期ID
     *
     * @param installmentsId 分期ID
     */
    public void setInstallmentsId(String installmentsId) {
        this.installmentsId = installmentsId;
    }

    /**
     * 获取消费记录ID
     *
     * @return shoppingsheet_id - 消费记录ID
     */
    public String getShoppingsheetId() {
        return shoppingsheetId;
    }

    /**
     * 设置消费记录ID
     *
     * @param shoppingsheetId 消费记录ID
     */
    public void setShoppingsheetId(String shoppingsheetId) {
        this.shoppingsheetId = shoppingsheetId;
    }

    /**
     * 获取记账日期
     *
     * @return post_date - 记账日期
     */
    public String getPostDate() {
        return postDate;
    }

    /**
     * 设置记账日期
     *
     * @param postDate 记账日期
     */
    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    /**
     * 获取交易时间
     *
     * @return trans_date - 交易时间
     */
    public Date getTransDate() {
        return transDate;
    }

    /**
     * 设置交易时间
     *
     * @param transDate 交易时间
     */
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    /**
     * 获取分期描述
     *
     * @return installment_desc - 分期描述
     */
    public String getInstallmentDesc() {
        return installmentDesc;
    }

    /**
     * 设置分期描述
     *
     * @param installmentDesc 分期描述
     */
    public void setInstallmentDesc(String installmentDesc) {
        this.installmentDesc = installmentDesc;
    }

    /**
     * 获取分期手续费描述
     *
     * @return handingfee_desc - 分期手续费描述
     */
    public String getHandingfeeDesc() {
        return handingfeeDesc;
    }

    /**
     * 设置分期手续费描述
     *
     * @param handingfeeDesc 分期手续费描述
     */
    public void setHandingfeeDesc(String handingfeeDesc) {
        this.handingfeeDesc = handingfeeDesc;
    }

    /**
     * 获取分期转账手续费描述
     *
     * @return transferfee_desc - 分期转账手续费描述
     */
    public String getTransferfeeDesc() {
        return transferfeeDesc;
    }

    /**
     * 设置分期转账手续费描述
     *
     * @param transferfeeDesc 分期转账手续费描述
     */
    public void setTransferfeeDesc(String transferfeeDesc) {
        this.transferfeeDesc = transferfeeDesc;
    }

    /**
     * 获取分期类型(CONSUME-消费; CASH-现金; BILL-账单)
     *
     * @return installment_type - 分期类型(CONSUME-消费; CASH-现金; BILL-账单)
     */
    public String getInstallmentType() {
        return installmentType;
    }

    /**
     * 设置分期类型(CONSUME-消费; CASH-现金; BILL-账单)
     *
     * @param installmentType 分期类型(CONSUME-消费; CASH-现金; BILL-账单)
     */
    public void setInstallmentType(String installmentType) {
        this.installmentType = installmentType;
    }

    /**
     * 获取总分期数
     *
     * @return total_month - 总分期数
     */
    public Short getTotalMonth() {
        return totalMonth;
    }

    /**
     * 设置总分期数
     *
     * @param totalMonth 总分期数
     */
    public void setTotalMonth(Short totalMonth) {
        this.totalMonth = totalMonth;
    }

    /**
     * 获取当前分期数
     *
     * @return current_month - 当前分期数
     */
    public Short getCurrentMonth() {
        return currentMonth;
    }

    /**
     * 设置当前分期数
     *
     * @param currentMonth 当前分期数
     */
    public void setCurrentMonth(Short currentMonth) {
        this.currentMonth = currentMonth;
    }

    /**
     * 获取币种. CNY-人民币; USD-美元 ; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     *
     * @return currency_type - 币种. CNY-人民币; USD-美元 ; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置币种. CNY-人民币; USD-美元 ; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     *
     * @param currencyType 币种. CNY-人民币; USD-美元 ; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * 获取本期金额
     *
     * @return amount_money - 本期金额
     */
    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    /**
     * 设置本期金额
     *
     * @param amountMoney 本期金额
     */
    public void setAmountMoney(BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
    }

    /**
     * 获取本期手续费
     *
     * @return handing_fee - 本期手续费
     */
    public BigDecimal getHandingFee() {
        return handingFee;
    }

    /**
     * 设置本期手续费
     *
     * @param handingFee 本期手续费
     */
    public void setHandingFee(BigDecimal handingFee) {
        this.handingFee = handingFee;
    }

    /**
     * 获取转账手续费
     *
     * @return transfer_fee - 转账手续费
     */
    public BigDecimal getTransferFee() {
        return transferFee;
    }

    /**
     * 设置转账手续费
     *
     * @param transferFee 转账手续费
     */
    public void setTransferFee(BigDecimal transferFee) {
        this.transferFee = transferFee;
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