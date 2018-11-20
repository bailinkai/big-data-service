package com.yingu.project.big.data.persistence.entity.internetbank;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "internet_banking_base_info")
public class InternetBankingBaseInfo {
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
     * 银行卡ID
     */
    @Column(name = "card_id")
    private String cardId;

    /**
     * 银行卡类型：借记卡或信用卡
     */
    @Column(name = "card_type")
    private String cardType;

    /**
     * 银行名称
     */
    @Column(name = "bank_name")
    private String bankName;

    /**
     * 银行简称 (例:招商银行-简称“CMB”,详见“附录:服务支持列表”)
     */
    @Column(name = "bank_id")
    private String bankId;

    /**
     * 卡号后四位
     */
    @Column(name = "card_num")
    private String cardNum;

    /**
     * 持卡人
     */
    @Column(name = "name_on_card")
    private String nameOnCard;

    /**
     * 借记卡余额/信用卡可用额度
     */
    private BigDecimal balance;

    /**
     * 信用卡额度
     */
    @Column(name = "credit_limit")
    private BigDecimal creditLimit;

    /**
     * 信用卡现金可用额度
     */
    @Column(name = "cash_balance")
    private BigDecimal cashBalance;

    /**
     * 信用卡现金额度
     */
    @Column(name = "cash_limit")
    private BigDecimal cashLimit;

    /**
     * 开户银行
     */
    @Column(name = "open_bank")
    private String openBank;

    /**
     * 开卡时间
     */
    @Column(name = "open_time")
    private String openTime;

    /**
     * 本期账单金额
     */
    @Column(name = "current_bill_amt")
    private BigDecimal currentBillAmt;

    /**
     * 本期已还金额
     */
    @Column(name = "current_bill_paid_amt")
    private BigDecimal currentBillPaidAmt;

    /**
     * 本期剩余应还金额
     */
    @Column(name = "current_bill_remain_amt")
    private BigDecimal currentBillRemainAmt;

    /**
     * 本期剩余最低应还金额
     */
    @Column(name = "current_bill_remain_min_payment")
    private BigDecimal currentBillRemainMinPayment;

    /**
     * 存款明细ID
     */
    @Column(name = "deposits_id")
    private String depositsId;

    /**
     * 账单ID
     */
    @Column(name = "bills_id")
    private String billsId;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 完整卡号
     */
    @Column(name = "full_card_num")
    private String fullCardNum;

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
     * 获取银行卡ID
     *
     * @return card_id - 银行卡ID
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 设置银行卡ID
     *
     * @param cardId 银行卡ID
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 获取银行卡类型：借记卡或信用卡
     *
     * @return card_type - 银行卡类型：借记卡或信用卡
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 设置银行卡类型：借记卡或信用卡
     *
     * @param cardType 银行卡类型：借记卡或信用卡
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * 获取银行名称
     *
     * @return bank_name - 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置银行名称
     *
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 获取银行简称 (例:招商银行-简称“CMB”,详见“附录:服务支持列表”)
     *
     * @return bank_id - 银行简称 (例:招商银行-简称“CMB”,详见“附录:服务支持列表”)
     */
    public String getBankId() {
        return bankId;
    }

    /**
     * 设置银行简称 (例:招商银行-简称“CMB”,详见“附录:服务支持列表”)
     *
     * @param bankId 银行简称 (例:招商银行-简称“CMB”,详见“附录:服务支持列表”)
     */
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取卡号后四位
     *
     * @return card_num - 卡号后四位
     */
    public String getCardNum() {
        return cardNum;
    }

    /**
     * 设置卡号后四位
     *
     * @param cardNum 卡号后四位
     */
    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * 获取持卡人
     *
     * @return name_on_card - 持卡人
     */
    public String getNameOnCard() {
        return nameOnCard;
    }

    /**
     * 设置持卡人
     *
     * @param nameOnCard 持卡人
     */
    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    /**
     * 获取借记卡余额/信用卡可用额度
     *
     * @return balance - 借记卡余额/信用卡可用额度
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置借记卡余额/信用卡可用额度
     *
     * @param balance 借记卡余额/信用卡可用额度
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取信用卡额度
     *
     * @return credit_limit - 信用卡额度
     */
    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    /**
     * 设置信用卡额度
     *
     * @param creditLimit 信用卡额度
     */
    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * 获取信用卡现金可用额度
     *
     * @return cash_balance - 信用卡现金可用额度
     */
    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    /**
     * 设置信用卡现金可用额度
     *
     * @param cashBalance 信用卡现金可用额度
     */
    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    /**
     * 获取信用卡现金额度
     *
     * @return cash_limit - 信用卡现金额度
     */
    public BigDecimal getCashLimit() {
        return cashLimit;
    }

    /**
     * 设置信用卡现金额度
     *
     * @param cashLimit 信用卡现金额度
     */
    public void setCashLimit(BigDecimal cashLimit) {
        this.cashLimit = cashLimit;
    }

    /**
     * 获取开户银行
     *
     * @return open_bank - 开户银行
     */
    public String getOpenBank() {
        return openBank;
    }

    /**
     * 设置开户银行
     *
     * @param openBank 开户银行
     */
    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    /**
     * 获取开卡时间
     *
     * @return open_time - 开卡时间
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * 设置开卡时间
     *
     * @param openTime 开卡时间
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    /**
     * 获取本期账单金额
     *
     * @return current_bill_amt - 本期账单金额
     */
    public BigDecimal getCurrentBillAmt() {
        return currentBillAmt;
    }

    /**
     * 设置本期账单金额
     *
     * @param currentBillAmt 本期账单金额
     */
    public void setCurrentBillAmt(BigDecimal currentBillAmt) {
        this.currentBillAmt = currentBillAmt;
    }

    /**
     * 获取本期已还金额
     *
     * @return current_bill_paid_amt - 本期已还金额
     */
    public BigDecimal getCurrentBillPaidAmt() {
        return currentBillPaidAmt;
    }

    /**
     * 设置本期已还金额
     *
     * @param currentBillPaidAmt 本期已还金额
     */
    public void setCurrentBillPaidAmt(BigDecimal currentBillPaidAmt) {
        this.currentBillPaidAmt = currentBillPaidAmt;
    }

    /**
     * 获取本期剩余应还金额
     *
     * @return current_bill_remain_amt - 本期剩余应还金额
     */
    public BigDecimal getCurrentBillRemainAmt() {
        return currentBillRemainAmt;
    }

    /**
     * 设置本期剩余应还金额
     *
     * @param currentBillRemainAmt 本期剩余应还金额
     */
    public void setCurrentBillRemainAmt(BigDecimal currentBillRemainAmt) {
        this.currentBillRemainAmt = currentBillRemainAmt;
    }

    /**
     * 获取本期剩余最低应还金额
     *
     * @return current_bill_remain_min_payment - 本期剩余最低应还金额
     */
    public BigDecimal getCurrentBillRemainMinPayment() {
        return currentBillRemainMinPayment;
    }

    /**
     * 设置本期剩余最低应还金额
     *
     * @param currentBillRemainMinPayment 本期剩余最低应还金额
     */
    public void setCurrentBillRemainMinPayment(BigDecimal currentBillRemainMinPayment) {
        this.currentBillRemainMinPayment = currentBillRemainMinPayment;
    }

    /**
     * 获取存款明细ID
     *
     * @return deposits_id - 存款明细ID
     */
    public String getDepositsId() {
        return depositsId;
    }

    /**
     * 设置存款明细ID
     *
     * @param depositsId 存款明细ID
     */
    public void setDepositsId(String depositsId) {
        this.depositsId = depositsId;
    }

    /**
     * 获取账单ID
     *
     * @return bills_id - 账单ID
     */
    public String getBillsId() {
        return billsId;
    }

    /**
     * 设置账单ID
     *
     * @param billsId 账单ID
     */
    public void setBillsId(String billsId) {
        this.billsId = billsId;
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
     * 获取完整卡号
     *
     * @return full_card_num - 完整卡号
     */
    public String getFullCardNum() {
        return fullCardNum;
    }

    /**
     * 设置完整卡号
     *
     * @param fullCardNum 完整卡号
     */
    public void setFullCardNum(String fullCardNum) {
        this.fullCardNum = fullCardNum;
    }
}