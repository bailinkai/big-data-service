package com.yingu.project.big.data.persistence.entity.internetbank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "internet_banking_shopping_detail")
public class InternetBankingShoppingDetail {
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
     * 消费记录ID(外键)
     */
    @Column(name = "shopping_sheets_id")
    private String shoppingSheetsId;

    /**
     * 消费记录ID
     */
    @Column(name = "shoppingsheet_id")
    private String shoppingsheetId;

    /**
     * 卡号末4位
     */
    @Column(name = "card_num")
    private String cardNum;

    /**
     * 记账日期
     */
    @Column(name = "post_date")
    private String postDate;

    /**
     * 消费类型(WITHDRAW-取现; PAYMENTS-还款; INTEREST-循环利息; OVERDUEPAYMENT-延滞金; OVERDUEFEE-超额费; INSTALLMENT-分期; SHOPPING-消费; OTHERFEE-其他费用)
收入项(SALARY-工资; BONUS-奖金; ACCRUAL-利息; DEPOSIT-存现; TRANSFER-转账; LOANS-借贷; REVERSE-冲账; REFUND-退款; EARNINGS-收益; CLAIM-报销; OTHERREVENUE-其它收入)
     */
    private String category;

    /**
     * 排序
     */
    @Column(name = "order_index")
    private Integer orderIndex;

    /**
     * 交易时间
     */
    @Column(name = "trans_date")
    private Date transDate;

    /**
     * 币种. CNY-人民币; USD-美元; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     */
    @Column(name = "currency_type")
    private String currencyType;

    /**
     * 消费金额
     */
    @Column(name = "amount_money")
    private BigDecimal amountMoney;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 交易方式
     */
    @Column(name = "trans_method")
    private String transMethod;

    /**
     * 交易通道
     */
    @Column(name = "trans_channel")
    private String transChannel;

    /**
     * 描述
     */
    private String description;

    /**
     * 备注
     */
    private String remark;

    /**
     * 对方卡号
     */
    @Column(name = "opposite_card_no")
    private String oppositeCardNo;

    /**
     * 对方持卡人
     */
    @Column(name = "name_on_opposite_card")
    private String nameOnOppositeCard;

    /**
     * 对方银行
     */
    @Column(name = "opposite_bank")
    private String oppositeBank;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 交易地点
     */
    @Column(name = "trans_addr")
    private String transAddr;

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
     * 获取消费记录ID(外键)
     *
     * @return shopping_sheets_id - 消费记录ID(外键)
     */
    public String getShoppingSheetsId() {
        return shoppingSheetsId;
    }

    /**
     * 设置消费记录ID(外键)
     *
     * @param shoppingSheetsId 消费记录ID(外键)
     */
    public void setShoppingSheetsId(String shoppingSheetsId) {
        this.shoppingSheetsId = shoppingSheetsId;
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
     * 获取卡号末4位
     *
     * @return card_num - 卡号末4位
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * 设置卡号末4位
     *
     * @param cardNum 卡号末4位
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
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
     * 获取消费类型(WITHDRAW-取现; PAYMENTS-还款; INTEREST-循环利息; OVERDUEPAYMENT-延滞金; OVERDUEFEE-超额费; INSTALLMENT-分期; SHOPPING-消费; OTHERFEE-其他费用)
收入项(SALARY-工资; BONUS-奖金; ACCRUAL-利息; DEPOSIT-存现; TRANSFER-转账; LOANS-借贷; REVERSE-冲账; REFUND-退款; EARNINGS-收益; CLAIM-报销; OTHERREVENUE-其它收入)
     *
     * @return category - 消费类型(WITHDRAW-取现; PAYMENTS-还款; INTEREST-循环利息; OVERDUEPAYMENT-延滞金; OVERDUEFEE-超额费; INSTALLMENT-分期; SHOPPING-消费; OTHERFEE-其他费用)
收入项(SALARY-工资; BONUS-奖金; ACCRUAL-利息; DEPOSIT-存现; TRANSFER-转账; LOANS-借贷; REVERSE-冲账; REFUND-退款; EARNINGS-收益; CLAIM-报销; OTHERREVENUE-其它收入)
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置消费类型(WITHDRAW-取现; PAYMENTS-还款; INTEREST-循环利息; OVERDUEPAYMENT-延滞金; OVERDUEFEE-超额费; INSTALLMENT-分期; SHOPPING-消费; OTHERFEE-其他费用)
收入项(SALARY-工资; BONUS-奖金; ACCRUAL-利息; DEPOSIT-存现; TRANSFER-转账; LOANS-借贷; REVERSE-冲账; REFUND-退款; EARNINGS-收益; CLAIM-报销; OTHERREVENUE-其它收入)
     *
     * @param category 消费类型(WITHDRAW-取现; PAYMENTS-还款; INTEREST-循环利息; OVERDUEPAYMENT-延滞金; OVERDUEFEE-超额费; INSTALLMENT-分期; SHOPPING-消费; OTHERFEE-其他费用)
收入项(SALARY-工资; BONUS-奖金; ACCRUAL-利息; DEPOSIT-存现; TRANSFER-转账; LOANS-借贷; REVERSE-冲账; REFUND-退款; EARNINGS-收益; CLAIM-报销; OTHERREVENUE-其它收入)
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取排序
     *
     * @return order_index - 排序
     */
    public Integer getOrderIndex() {
        return orderIndex;
    }

    /**
     * 设置排序
     *
     * @param orderIndex 排序
     */
    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
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
     * 获取币种. CNY-人民币; USD-美元; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     *
     * @return currency_type - 币种. CNY-人民币; USD-美元; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     */
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * 设置币种. CNY-人民币; USD-美元; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     *
     * @param currencyType 币种. CNY-人民币; USD-美元; HKD-港币; EUR-欧元;KRW-韩元; GBP-英镑; JPY-日元
     */
    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    /**
     * 获取消费金额
     *
     * @return amount_money - 消费金额
     */
    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    /**
     * 设置消费金额
     *
     * @param amountMoney 消费金额
     */
    public void setAmountMoney(BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取交易方式
     *
     * @return trans_method - 交易方式
     */
    public String getTransMethod() {
        return transMethod;
    }

    /**
     * 设置交易方式
     *
     * @param transMethod 交易方式
     */
    public void setTransMethod(String transMethod) {
        this.transMethod = transMethod;
    }

    /**
     * 获取交易通道
     *
     * @return trans_channel - 交易通道
     */
    public String getTransChannel() {
        return transChannel;
    }

    /**
     * 设置交易通道
     *
     * @param transChannel 交易通道
     */
    public void setTransChannel(String transChannel) {
        this.transChannel = transChannel;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取对方卡号
     *
     * @return opposite_card_no - 对方卡号
     */
    public String getOppositeCardNo() {
        return oppositeCardNo;
    }

    /**
     * 设置对方卡号
     *
     * @param oppositeCardNo 对方卡号
     */
    public void setOppositeCardNo(String oppositeCardNo) {
        this.oppositeCardNo = oppositeCardNo;
    }

    /**
     * 获取对方持卡人
     *
     * @return name_on_opposite_card - 对方持卡人
     */
    public String getNameOnOppositeCard() {
        return nameOnOppositeCard;
    }

    /**
     * 设置对方持卡人
     *
     * @param nameOnOppositeCard 对方持卡人
     */
    public void setNameOnOppositeCard(String nameOnOppositeCard) {
        this.nameOnOppositeCard = nameOnOppositeCard;
    }

    /**
     * 获取对方银行
     *
     * @return opposite_bank - 对方银行
     */
    public String getOppositeBank() {
        return oppositeBank;
    }

    /**
     * 设置对方银行
     *
     * @param oppositeBank 对方银行
     */
    public void setOppositeBank(String oppositeBank) {
        this.oppositeBank = oppositeBank;
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

    /**
     * 获取交易地点
     *
     * @return trans_addr - 交易地点
     */
    public String getTransAddr() {
        return transAddr;
    }

    /**
     * 设置交易地点
     *
     * @param transAddr 交易地点
     */
    public void setTransAddr(String transAddr) {
        this.transAddr = transAddr;
    }
}