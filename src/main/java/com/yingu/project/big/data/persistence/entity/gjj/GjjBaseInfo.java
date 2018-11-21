package com.yingu.project.big.data.persistence.entity.gjj;

import javax.persistence.*;
import java.util.Date;

@Table(name = "gjj_base_info")
public class GjjBaseInfo {
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
     * 公司编码
     */
    @Column(name = "company_code")
    private String companyCode;

    /**
     * 转出金额
     */
    @Column(name = "transfer_amount")
    private String transferAmount;

    /**
     * 开户银行账号
     */
    @Column(name = "open_bank_account")
    private String openBankAccount;

    /**
     * 员工编码
     */
    @Column(name = "employee_code")
    private String employeeCode;

    /**
     * 身份证号
     */
    @Column(name = "id_card")
    private String idCard;

    /**
     * 缴纳基数
     */
    @Column(name = "pay_base_amount")
    private String payBaseAmount;

    /**
     * 接口版本
     */
    private String version;

    /**
     * 交易记录
     */
    @Column(name = "details_id")
    private String detailsId;

    /**
     * 月缴存额
     */
    @Column(name = "fund_amt")
    private String fundAmt;

    /**
     * 个人缴纳比例
     */
    @Column(name = "deposit_ratio_personal")
    private String depositRatioPersonal;

    /**
     * 开户日期
     */
    @Column(name = "open_date")
    private String openDate;

    /**
     * 公积金账户状态
     */
    @Column(name = "housing_fund_status")
    private String housingFundStatus;

    /**
     * 接口调用时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 开户银行名
     */
    @Column(name = "open_bank_name")
    private String openBankName;

    /**
     * 所属单位
     */
    private String company;

    /**
     * 单位缴纳比例
     */
    @Column(name = "deposit_ratio_company")
    private String depositRatioCompany;

    /**
     * 末次缴存年
     */
    @Column(name = "last_fund_date")
    private String lastFundDate;

    /**
     * 数据源
     */
    @Column(name = "data_source")
    private String dataSource;

    /**
     * 登记姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 系统用户id
     */
    private String token;

    /**
     * 公积金账号
     */
    @Column(name = "fund_num")
    private String fundNum;

    /**
     * 账户余额
     */
    private String balance;

    /**
     * 外键
     */
    @Column(name = "loan_info_id")
    private String loanInfoId;

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
     * 获取公司编码
     *
     * @return company_code - 公司编码
     */
    public String getCompanyCode() {
        return companyCode;
    }

    /**
     * 设置公司编码
     *
     * @param companyCode 公司编码
     */
    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    /**
     * 获取转出金额
     *
     * @return transfer_amount - 转出金额
     */
    public String getTransferAmount() {
        return transferAmount;
    }

    /**
     * 设置转出金额
     *
     * @param transferAmount 转出金额
     */
    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    /**
     * 获取开户银行账号
     *
     * @return open_bank_account - 开户银行账号
     */
    public String getOpenBankAccount() {
        return openBankAccount;
    }

    /**
     * 设置开户银行账号
     *
     * @param openBankAccount 开户银行账号
     */
    public void setOpenBankAccount(String openBankAccount) {
        this.openBankAccount = openBankAccount;
    }

    /**
     * 获取员工编码
     *
     * @return employee_code - 员工编码
     */
    public String getEmployeeCode() {
        return employeeCode;
    }

    /**
     * 设置员工编码
     *
     * @param employeeCode 员工编码
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    /**
     * 获取身份证号
     *
     * @return id_card - 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取缴纳基数
     *
     * @return pay_base_amount - 缴纳基数
     */
    public String getPayBaseAmount() {
        return payBaseAmount;
    }

    /**
     * 设置缴纳基数
     *
     * @param payBaseAmount 缴纳基数
     */
    public void setPayBaseAmount(String payBaseAmount) {
        this.payBaseAmount = payBaseAmount;
    }

    /**
     * 获取接口版本
     *
     * @return version - 接口版本
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置接口版本
     *
     * @param version 接口版本
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取交易记录
     *
     * @return details_id - 交易记录
     */
    public String getDetailsId() {
        return detailsId;
    }

    /**
     * 设置交易记录
     *
     * @param detailsId 交易记录
     */
    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    /**
     * 获取月缴存额
     *
     * @return fund_amt - 月缴存额
     */
    public String getFundAmt() {
        return fundAmt;
    }

    /**
     * 设置月缴存额
     *
     * @param fundAmt 月缴存额
     */
    public void setFundAmt(String fundAmt) {
        this.fundAmt = fundAmt;
    }

    /**
     * 获取个人缴纳比例
     *
     * @return deposit_ratio_personal - 个人缴纳比例
     */
    public String getDepositRatioPersonal() {
        return depositRatioPersonal;
    }

    /**
     * 设置个人缴纳比例
     *
     * @param depositRatioPersonal 个人缴纳比例
     */
    public void setDepositRatioPersonal(String depositRatioPersonal) {
        this.depositRatioPersonal = depositRatioPersonal;
    }

    /**
     * 获取开户日期
     *
     * @return open_date - 开户日期
     */
    public String getOpenDate() {
        return openDate;
    }

    /**
     * 设置开户日期
     *
     * @param openDate 开户日期
     */
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    /**
     * 获取公积金账户状态
     *
     * @return housing_fund_status - 公积金账户状态
     */
    public String getHousingFundStatus() {
        return housingFundStatus;
    }

    /**
     * 设置公积金账户状态
     *
     * @param housingFundStatus 公积金账户状态
     */
    public void setHousingFundStatus(String housingFundStatus) {
        this.housingFundStatus = housingFundStatus;
    }

    /**
     * 获取接口调用时间
     *
     * @return update_time - 接口调用时间
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置接口调用时间
     *
     * @param updateTime 接口调用时间
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取开户银行名
     *
     * @return open_bank_name - 开户银行名
     */
    public String getOpenBankName() {
        return openBankName;
    }

    /**
     * 设置开户银行名
     *
     * @param openBankName 开户银行名
     */
    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    /**
     * 获取所属单位
     *
     * @return company - 所属单位
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置所属单位
     *
     * @param company 所属单位
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取单位缴纳比例
     *
     * @return deposit_ratio_company - 单位缴纳比例
     */
    public String getDepositRatioCompany() {
        return depositRatioCompany;
    }

    /**
     * 设置单位缴纳比例
     *
     * @param depositRatioCompany 单位缴纳比例
     */
    public void setDepositRatioCompany(String depositRatioCompany) {
        this.depositRatioCompany = depositRatioCompany;
    }

    /**
     * 获取末次缴存年
     *
     * @return last_fund_date - 末次缴存年
     */
    public String getLastFundDate() {
        return lastFundDate;
    }

    /**
     * 设置末次缴存年
     *
     * @param lastFundDate 末次缴存年
     */
    public void setLastFundDate(String lastFundDate) {
        this.lastFundDate = lastFundDate;
    }

    /**
     * 获取数据源
     *
     * @return data_source - 数据源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据源
     *
     * @param dataSource 数据源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取登记姓名
     *
     * @return real_name - 登记姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置登记姓名
     *
     * @param realName 登记姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取系统用户id
     *
     * @return token - 系统用户id
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置系统用户id
     *
     * @param token 系统用户id
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 获取公积金账号
     *
     * @return fund_num - 公积金账号
     */
    public String getFundNum() {
        return fundNum;
    }

    /**
     * 设置公积金账号
     *
     * @param fundNum 公积金账号
     */
    public void setFundNum(String fundNum) {
        this.fundNum = fundNum;
    }

    /**
     * 获取账户余额
     *
     * @return balance - 账户余额
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 设置账户余额
     *
     * @param balance 账户余额
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 获取外键
     *
     * @return loan_info_id - 外键
     */
    public String getLoanInfoId() {
        return loanInfoId;
    }

    /**
     * 设置外键
     *
     * @param loanInfoId 外键
     */
    public void setLoanInfoId(String loanInfoId) {
        this.loanInfoId = loanInfoId;
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

    public GjjBaseInfo() {
    }

    public GjjBaseInfo(String orderNum) {
        this.orderNum = orderNum;
    }
}