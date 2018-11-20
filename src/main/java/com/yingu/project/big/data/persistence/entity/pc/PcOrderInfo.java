package com.yingu.project.big.data.persistence.entity.pc;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "pc_order_info")
public class PcOrderInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phid")
    private Integer phid;

    public Integer getPhid() {
        return phid;
    }

    public void setPhid(Integer phid) {
        this.phid = phid;
    }

    /**
     * uuid(不带‘-’符号的uuid)
     */
    private String uuid;

    /**
     * 编号 系统编码+门店编码+globalId QJ1201704010004
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 产品编号
     */
    @Column(name = "product_id")
    private String productId;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 费率
     */
    private BigDecimal rate;

    /**
     * 申请状态
     */
    private String status;

    /**
     * 申请人
     */
    private String proposer;

    /**
     * 申请贷款金额-贷款金额
     */
    @Column(name = "expect_amount")
    private BigDecimal expectAmount;

    /**
     * 实际支付金额
     */
    @Column(name = "actual_amount")
    private BigDecimal actualAmount;

    /**
     * 销售人员姓名
     */
    private String salesman;

    /**
     * 销售人员 员工号
     */
    @Column(name = "salesman_empno")
    private String salesmanEmpno;

    /**
     * 团队经理姓名
     */
    @Column(name = "team_manager")
    private String teamManager;

    /**
     * 团队经理员工号
     */
    @Column(name = "team_manager_empno")
    private String teamManagerEmpno;

    /**
     * 贷款用途
     */
    private String purpose;

    /**
     * 客服姓名
     */
    @Column(name = "custom_service")
    private String customService;

    /**
     * 客服员工号
     */
    @Column(name = "custom_service_empno")
    private String customServiceEmpno;

    /**
     * 申请期限 1 2 3 6 12 36
     */
    private String term;

    /**
     * 申请时间-下单时间
     */
    @Column(name = "application_time")
    private Date applicationTime;

    /**
     * 销售渠道
     */
    @Column(name = "sale_channel")
    private String saleChannel;

    /**
     * 还款方式
     */
    @Column(name = "rufund_way")
    private String rufundWay;

    /**
     * 门店编号=组织编号  为线上借款端数字编码 对应sys_org表 deptNo
     */
    @Column(name = "store_id")
    private String storeId;

    /**
     * 组织编号
     */
    @Column(name = "org_id")
    private String orgId;

    /**
     * 组织名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 身份证
     */
    @Column(name = "id_num")
    private String idNum;

    /**
     * 操作员员工号
     */
    @Column(name = "operator_empno")
    private String operatorEmpno;

    /**
     * 操作员姓名
     */
    @Column(name = "operator_empname")
    private String operatorEmpname;

    /**
     * 实际支付实际
     */
    @Column(name = "actual_pay_time")
    private Date actualPayTime;

    /**
     * 实际批复产品编号
     */
    @Column(name = "actual_product_id")
    private String actualProductId;

    /**
     * 实际批复产品名称
     */
    @Column(name = "actual_product_name")
    private String actualProductName;

    /**
     * 实际支付费率
     */
    @Column(name = "actual_rate")
    private String actualRate;

    /**
     * 订单类型 1普惠2云钱袋
     */
    @Column(name = "order_type")
    private Integer orderType;

    /**
     * 区分订单来源。1门店（0也表示门店，历史数据是为NULL）2LoanApp（线上订单，端对端）3、新银谷普惠运营系统，数据来源线上借款端
     */
    @Column(name = "order_source")
    private String orderSource;

    /**
     * 是否加急 1加急 0 不加急
     */
    @Column(name = "is_urgent")
    private Boolean isUrgent;

    /**
     * 是否复议
     */
    @Column(name = "is_fuyi")
    private Boolean isFuyi;

    /**
     * 新贵时代3标识
     */
    @Column(name = "sign_xgsd3")
    private String signXgsd3;

    /**
     * 新贵时代3上一个订单的单号
     */
    @Column(name = "last_order_num")
    private String lastOrderNum;

    public String getSignXgsd3() {
        return signXgsd3;
    }

    public void setSignXgsd3(String singXgsd3) {
        this.signXgsd3 = singXgsd3;
    }

    public String getLastOrderNum() {
        return lastOrderNum;
    }

    public void setLastOrderNum(String lastOrderNum) {
        this.lastOrderNum = lastOrderNum;
    }

    public Boolean getIsFuyi() {
        return isFuyi;
    }

    public void setIsFuyi(Boolean fuyi) {
        isFuyi = fuyi;
    }

    /**
     * 家人是否知道本次贷款  1、知道 0、不知道
     */
    @Column(name = "is_know")
    private Boolean isKnow;

    /**
     * 是否已上传扫描件
     */
    @Column(name = "is_uploaded")
    private Boolean isUploaded;

    /**
     * 1、有征信报告
     */
    @Column(name = "has_credit_report")
    private Boolean hasCreditReport;

    /**
     * 质检时间
     */
    @Column(name = "checked_time")
    private Date checkedTime;

    /**
     * 确认金额时间
     */
    @Column(name = "confirm_amount_time")
    private Date confirmAmountTime;

    /**
     * 客户类型：1、银谷在线；2、云钱袋；3、新用户
     */
    @Column(name = "custom_type")
    private String customType;

    /**
     * 募集批次编号
     */
    @Column(name = "apply_batch")
    private String applyBatch;

    /**
     * 募集申请日期
     */
    @Column(name = "apply_date")
    private Date applyDate;

    /**
     * 计划包 Model_Package ID
     */
    @Column(name = "package_id")
    private String packageId;

    /**
     * 录单操作时长
     */
    @Column(name = "record_order_consume_time")
    private String recordOrderConsumeTime;

    /**
     * 开户类型(2:银行,1:第三方)字段
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 是否可变更还款日（2:银行,1:第三方,0:未确定）
     */
    @Column(name = "can_repay_advance")
    private Boolean canRepayAdvance;

    /**
     * 还款日期类型： 0:15/30 还款日   or  1: 对日还款,即1-31号均可作为还款日
     */
    @Column(name = "repay_date_type")
    private String repayDateType;

    /**
     * 放款成功时间
     */
    @Column(name = "loan_success_time")
    private Date loanSuccessTime;

    /**
     * 结算时间
     */
    @Column(name = "settle_time")
    private Date settleTime;

    /**
     * 是否购买保险:0 不购买,1 购买
     */
    @Column(name = "is_buy_insurance")
    private Boolean isBuyInsurance;

    /**
     * 签约时间
     */
    @Column(name = "signing_time")
    private Date signingTime;

    /**
     * 划扣操作日期
     */
    @Column(name = "withhold_date")
    private String withholdDate;

    /**
     * 划扣操作计数，不能超过已有渠道总数
     */
    @Column(name = "whthhold_count")
    private Integer whthholdCount;

    /**
     * 签约金额
     */
    @Column(name = "signature_principal")
    private BigDecimal signaturePrincipal;

    /**
     * 月偿还本金数额
     */
    @Column(name = "month_principal")
    private BigDecimal monthPrincipal;

    /**
     * 签约日期（债匹后的签约日期）
     */
    @Column(name = "signing_date")
    private Date signingDate;

    /**
     * 状态（1：未完成还款；2：已完成全部还款；3：提前结清申请；4：提前结清;5:逾期）
     */
    @Column(name = "loan_status")
    private Integer loanStatus;

    /**
     * 放款状态（1：未放款；2：放款中；3：放款成功；4：放款失败；5：拒绝贷款;）
     */
    @Column(name = "draw_status")
    private Integer drawStatus;

    /**
     * 放款失败原因
     */
    @Column(name = "loan_failure_reason")
    private String loanFailureReason;

    /**
     * 审核员员工号
     */
    @Column(name = "approval_emp")
    private String approvalEmp;

    /**
     * 审核员姓名
     */
    @Column(name = "approval_emp_name")
    private String approvalEmpName;

    /**
     * 接单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 借款端返回拒贷结果
     */
    @Column(name = "loan_reject_result")
    private String loanRejectResult;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取uuid(不带‘-’符号的uuid)
     *
     * @return uuid - uuid(不带‘-’符号的uuid)
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置uuid(不带‘-’符号的uuid)
     *
     * @param uuid uuid(不带‘-’符号的uuid)
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取编号 系统编码+门店编码+globalId QJ1201704010004
     *
     * @return order_num - 编号 系统编码+门店编码+globalId QJ1201704010004
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置编号 系统编码+门店编码+globalId QJ1201704010004
     *
     * @param orderNum 编号 系统编码+门店编码+globalId QJ1201704010004
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取产品编号
     *
     * @return product_id - 产品编号
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置产品编号
     *
     * @param productId 产品编号
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取费率
     *
     * @return rate - 费率
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 设置费率
     *
     * @param rate 费率
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 获取申请状态
     *
     * @return status - 申请状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置申请状态
     *
     * @param status 申请状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取申请人
     *
     * @return proposer - 申请人
     */
    public String getProposer() {
        return proposer;
    }

    /**
     * 设置申请人
     *
     * @param proposer 申请人
     */
    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    /**
     * 获取申请贷款金额-贷款金额
     *
     * @return expect_amount - 申请贷款金额-贷款金额
     */
    public BigDecimal getExpectAmount() {
        return expectAmount;
    }

    /**
     * 设置申请贷款金额-贷款金额
     *
     * @param expectAmount 申请贷款金额-贷款金额
     */
    public void setExpectAmount(BigDecimal expectAmount) {
        this.expectAmount = expectAmount;
    }

    /**
     * 获取实际支付金额
     *
     * @return actual_amount - 实际支付金额
     */
    public BigDecimal getActualAmount() {
        return actualAmount;
    }

    /**
     * 设置实际支付金额
     *
     * @param actualAmount 实际支付金额
     */
    public void setActualAmount(BigDecimal actualAmount) {
        this.actualAmount = actualAmount;
    }

    /**
     * 获取销售人员姓名
     *
     * @return salesman - 销售人员姓名
     */
    public String getSalesman() {
        return salesman;
    }

    /**
     * 设置销售人员姓名
     *
     * @param salesman 销售人员姓名
     */
    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    /**
     * 获取销售人员 员工号
     *
     * @return salesman_empno - 销售人员 员工号
     */
    public String getSalesmanEmpno() {
        return salesmanEmpno;
    }

    /**
     * 设置销售人员 员工号
     *
     * @param salesmanEmpno 销售人员 员工号
     */
    public void setSalesmanEmpno(String salesmanEmpno) {
        this.salesmanEmpno = salesmanEmpno;
    }

    /**
     * 获取团队经理姓名
     *
     * @return team_manager - 团队经理姓名
     */
    public String getTeamManager() {
        return teamManager;
    }

    /**
     * 设置团队经理姓名
     *
     * @param teamManager 团队经理姓名
     */
    public void setTeamManager(String teamManager) {
        this.teamManager = teamManager;
    }

    /**
     * 获取团队经理员工号
     *
     * @return team_manager_empno - 团队经理员工号
     */
    public String getTeamManagerEmpno() {
        return teamManagerEmpno;
    }

    /**
     * 设置团队经理员工号
     *
     * @param teamManagerEmpno 团队经理员工号
     */
    public void setTeamManagerEmpno(String teamManagerEmpno) {
        this.teamManagerEmpno = teamManagerEmpno;
    }

    /**
     * 获取贷款用途
     *
     * @return purpose - 贷款用途
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * 设置贷款用途
     *
     * @param purpose 贷款用途
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * 获取客服姓名
     *
     * @return custom_service - 客服姓名
     */
    public String getCustomService() {
        return customService;
    }

    /**
     * 设置客服姓名
     *
     * @param customService 客服姓名
     */
    public void setCustomService(String customService) {
        this.customService = customService;
    }

    /**
     * 获取客服员工号
     *
     * @return custom_service_empno - 客服员工号
     */
    public String getCustomServiceEmpno() {
        return customServiceEmpno;
    }

    /**
     * 设置客服员工号
     *
     * @param customServiceEmpno 客服员工号
     */
    public void setCustomServiceEmpno(String customServiceEmpno) {
        this.customServiceEmpno = customServiceEmpno;
    }

    /**
     * 获取申请期限 1 2 3 6 12 36
     *
     * @return term - 申请期限 1 2 3 6 12 36
     */
    public String getTerm() {
        return term;
    }

    /**
     * 设置申请期限 1 2 3 6 12 36
     *
     * @param term 申请期限 1 2 3 6 12 36
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     * 获取申请时间-下单时间
     *
     * @return application_time - 申请时间-下单时间
     */
    public Date getApplicationTime() {
        return applicationTime;
    }

    /**
     * 设置申请时间-下单时间
     *
     * @param applicationTime 申请时间-下单时间
     */
    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    /**
     * 获取销售渠道
     *
     * @return sale_channel - 销售渠道
     */
    public String getSaleChannel() {
        return saleChannel;
    }

    /**
     * 设置销售渠道
     *
     * @param saleChannel 销售渠道
     */
    public void setSaleChannel(String saleChannel) {
        this.saleChannel = saleChannel;
    }

    /**
     * 获取还款方式
     *
     * @return rufund_way - 还款方式
     */
    public String getRufundWay() {
        return rufundWay;
    }

    /**
     * 设置还款方式
     *
     * @param rufundWay 还款方式
     */
    public void setRufundWay(String rufundWay) {
        this.rufundWay = rufundWay;
    }

    /**
     * 获取门店编号=组织编号  为线上借款端数字编码 对应sys_org表 deptNo
     *
     * @return store_id - 门店编号=组织编号  为线上借款端数字编码 对应sys_org表 deptNo
     */
    public String getStoreId() {
        return storeId;
    }

    /**
     * 设置门店编号=组织编号  为线上借款端数字编码 对应sys_org表 deptNo
     *
     * @param storeId 门店编号=组织编号  为线上借款端数字编码 对应sys_org表 deptNo
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取组织编号
     *
     * @return org_id - 组织编号
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置组织编号
     *
     * @param orgId 组织编号
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取组织名称
     *
     * @return org_name - 组织名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置组织名称
     *
     * @param orgName 组织名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取身份证
     *
     * @return id_num - 身份证
     */
    public String getIdNum() {
        return idNum;
    }

    /**
     * 设置身份证
     *
     * @param idNum 身份证
     */
    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    /**
     * 获取操作员员工号
     *
     * @return operator_empno - 操作员员工号
     */
    public String getOperatorEmpno() {
        return operatorEmpno;
    }

    /**
     * 设置操作员员工号
     *
     * @param operatorEmpno 操作员员工号
     */
    public void setOperatorEmpno(String operatorEmpno) {
        this.operatorEmpno = operatorEmpno;
    }

    /**
     * 获取操作员姓名
     *
     * @return operator_empname - 操作员姓名
     */
    public String getOperatorEmpname() {
        return operatorEmpname;
    }

    /**
     * 设置操作员姓名
     *
     * @param operatorEmpname 操作员姓名
     */
    public void setOperatorEmpname(String operatorEmpname) {
        this.operatorEmpname = operatorEmpname;
    }

    /**
     * 获取实际支付实际
     *
     * @return actual_pay_time - 实际支付实际
     */
    public Date getActualPayTime() {
        return actualPayTime;
    }

    /**
     * 设置实际支付实际
     *
     * @param actualPayTime 实际支付实际
     */
    public void setActualPayTime(Date actualPayTime) {
        this.actualPayTime = actualPayTime;
    }

    /**
     * 获取实际批复产品编号
     *
     * @return actual_product_id - 实际批复产品编号
     */
    public String getActualProductId() {
        return actualProductId;
    }

    /**
     * 设置实际批复产品编号
     *
     * @param actualProductId 实际批复产品编号
     */
    public void setActualProductId(String actualProductId) {
        this.actualProductId = actualProductId;
    }

    /**
     * 获取实际批复产品名称
     *
     * @return actual_product_name - 实际批复产品名称
     */
    public String getActualProductName() {
        return actualProductName;
    }

    /**
     * 设置实际批复产品名称
     *
     * @param actualProductName 实际批复产品名称
     */
    public void setActualProductName(String actualProductName) {
        this.actualProductName = actualProductName;
    }

    /**
     * 获取实际支付费率
     *
     * @return actual_rate - 实际支付费率
     */
    public String getActualRate() {
        return actualRate;
    }

    /**
     * 设置实际支付费率
     *
     * @param actualRate 实际支付费率
     */
    public void setActualRate(String actualRate) {
        this.actualRate = actualRate;
    }

    /**
     * 获取订单类型 1普惠2云钱袋
     *
     * @return order_type - 订单类型 1普惠2云钱袋
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 设置订单类型 1普惠2云钱袋
     *
     * @param orderType 订单类型 1普惠2云钱袋
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取区分订单来源。1门店（0也表示门店，历史数据是为NULL）2LoanApp（线上订单，端对端）3、新银谷普惠运营系统，数据来源线上借款端
     *
     * @return order_source - 区分订单来源。1门店（0也表示门店，历史数据是为NULL）2LoanApp（线上订单，端对端）3、新银谷普惠运营系统，数据来源线上借款端
     */
    public String getOrderSource() {
        return orderSource;
    }

    /**
     * 设置区分订单来源。1门店（0也表示门店，历史数据是为NULL）2LoanApp（线上订单，端对端）3、新银谷普惠运营系统，数据来源线上借款端
     *
     * @param orderSource 区分订单来源。1门店（0也表示门店，历史数据是为NULL）2LoanApp（线上订单，端对端）3、新银谷普惠运营系统，数据来源线上借款端
     */
    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    /**
     * 获取是否加急 1加急 0 不加急
     *
     * @return is_urgent - 是否加急 1加急 0 不加急
     */
    public Boolean getIsUrgent() {
        return isUrgent;
    }

    /**
     * 设置是否加急 1加急 0 不加急
     *
     * @param isUrgent 是否加急 1加急 0 不加急
     */
    public void setIsUrgent(Boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    /**
     * 获取家人是否知道本次贷款  1、知道 0、不知道
     *
     * @return is_know - 家人是否知道本次贷款  1、知道 0、不知道
     */
    public Boolean getIsKnow() {
        return isKnow;
    }

    /**
     * 设置家人是否知道本次贷款  1、知道 0、不知道
     *
     * @param isKnow 家人是否知道本次贷款  1、知道 0、不知道
     */
    public void setIsKnow(Boolean isKnow) {
        this.isKnow = isKnow;
    }

    /**
     * 获取是否已上传扫描件
     *
     * @return is_uploaded - 是否已上传扫描件
     */
    public Boolean getIsUploaded() {
        return isUploaded;
    }

    /**
     * 设置是否已上传扫描件
     *
     * @param isUploaded 是否已上传扫描件
     */
    public void setIsUploaded(Boolean isUploaded) {
        this.isUploaded = isUploaded;
    }

    /**
     * 获取1、有征信报告
     *
     * @return has_credit_report - 1、有征信报告
     */
    public Boolean getHasCreditReport() {
        return hasCreditReport;
    }

    /**
     * 设置1、有征信报告
     *
     * @param hasCreditReport 1、有征信报告
     */
    public void setHasCreditReport(Boolean hasCreditReport) {
        this.hasCreditReport = hasCreditReport;
    }

    /**
     * 获取质检时间
     *
     * @return checked_time - 质检时间
     */
    public Date getCheckedTime() {
        return checkedTime;
    }

    /**
     * 设置质检时间
     *
     * @param checkedTime 质检时间
     */
    public void setCheckedTime(Date checkedTime) {
        this.checkedTime = checkedTime;
    }

    /**
     * 获取确认金额时间
     *
     * @return confirm_amount_time - 确认金额时间
     */
    public Date getConfirmAmountTime() {
        return confirmAmountTime;
    }

    /**
     * 设置确认金额时间
     *
     * @param confirmAmountTime 确认金额时间
     */
    public void setConfirmAmountTime(Date confirmAmountTime) {
        this.confirmAmountTime = confirmAmountTime;
    }

    /**
     * 获取客户类型：1、银谷在线；2、云钱袋；3、新用户
     *
     * @return custom_type - 客户类型：1、银谷在线；2、云钱袋；3、新用户
     */
    public String getCustomType() {
        return customType;
    }

    /**
     * 设置客户类型：1、银谷在线；2、云钱袋；3、新用户
     *
     * @param customType 客户类型：1、银谷在线；2、云钱袋；3、新用户
     */
    public void setCustomType(String customType) {
        this.customType = customType;
    }

    /**
     * 获取募集批次编号
     *
     * @return apply_batch - 募集批次编号
     */
    public String getApplyBatch() {
        return applyBatch;
    }

    /**
     * 设置募集批次编号
     *
     * @param applyBatch 募集批次编号
     */
    public void setApplyBatch(String applyBatch) {
        this.applyBatch = applyBatch;
    }

    /**
     * 获取募集申请日期
     *
     * @return apply_date - 募集申请日期
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 设置募集申请日期
     *
     * @param applyDate 募集申请日期
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 获取计划包 Model_Package ID
     *
     * @return package_id - 计划包 Model_Package ID
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * 设置计划包 Model_Package ID
     *
     * @param packageId 计划包 Model_Package ID
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    /**
     * 获取录单操作时长
     *
     * @return record_order_consume_time - 录单操作时长
     */
    public String getRecordOrderConsumeTime() {
        return recordOrderConsumeTime;
    }

    /**
     * 设置录单操作时长
     *
     * @param recordOrderConsumeTime 录单操作时长
     */
    public void setRecordOrderConsumeTime(String recordOrderConsumeTime) {
        this.recordOrderConsumeTime = recordOrderConsumeTime;
    }

    /**
     * 获取开户类型(2:银行,1:第三方)字段
     *
     * @return account_type - 开户类型(2:银行,1:第三方)字段
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置开户类型(2:银行,1:第三方)字段
     *
     * @param accountType 开户类型(2:银行,1:第三方)字段
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取是否可变更还款日（2:银行,1:第三方,0:未确定）
     *
     * @return can_repay_advance - 是否可变更还款日（2:银行,1:第三方,0:未确定）
     */
    public Boolean getCanRepayAdvance() {
        return canRepayAdvance;
    }

    /**
     * 设置是否可变更还款日（2:银行,1:第三方,0:未确定）
     *
     * @param canRepayAdvance 是否可变更还款日（2:银行,1:第三方,0:未确定）
     */
    public void setCanRepayAdvance(Boolean canRepayAdvance) {
        this.canRepayAdvance = canRepayAdvance;
    }

    /**
     * 获取还款日期类型： 0:15/30 还款日   or  1: 对日还款,即1-31号均可作为还款日
     *
     * @return repay_date_type - 还款日期类型： 0:15/30 还款日   or  1: 对日还款,即1-31号均可作为还款日
     */
    public String getRepayDateType() {
        return repayDateType;
    }

    /**
     * 设置还款日期类型： 0:15/30 还款日   or  1: 对日还款,即1-31号均可作为还款日
     *
     * @param repayDateType 还款日期类型： 0:15/30 还款日   or  1: 对日还款,即1-31号均可作为还款日
     */
    public void setRepayDateType(String repayDateType) {
        this.repayDateType = repayDateType;
    }

    /**
     * 获取放款成功时间
     *
     * @return loan_success_time - 放款成功时间
     */
    public Date getLoanSuccessTime() {
        return loanSuccessTime;
    }

    /**
     * 设置放款成功时间
     *
     * @param loanSuccessTime 放款成功时间
     */
    public void setLoanSuccessTime(Date loanSuccessTime) {
        this.loanSuccessTime = loanSuccessTime;
    }

    /**
     * 获取结算时间
     *
     * @return settle_time - 结算时间
     */
    public Date getSettleTime() {
        return settleTime;
    }

    /**
     * 设置结算时间
     *
     * @param settleTime 结算时间
     */
    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    /**
     * 获取是否购买保险:0 不购买,1 购买
     *
     * @return is_buy_insurance - 是否购买保险:0 不购买,1 购买
     */
    public Boolean getIsBuyInsurance() {
        return isBuyInsurance;
    }

    /**
     * 设置是否购买保险:0 不购买,1 购买
     *
     * @param isBuyInsurance 是否购买保险:0 不购买,1 购买
     */
    public void setIsBuyInsurance(Boolean isBuyInsurance) {
        this.isBuyInsurance = isBuyInsurance;
    }

    /**
     * 获取签约时间
     *
     * @return signing_time - 签约时间
     */
    public Date getSigningTime() {
        return signingTime;
    }

    /**
     * 设置签约时间
     *
     * @param signingTime 签约时间
     */
    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    /**
     * 获取划扣操作日期
     *
     * @return withhold_date - 划扣操作日期
     */
    public String getWithholdDate() {
        return withholdDate;
    }

    /**
     * 设置划扣操作日期
     *
     * @param withholdDate 划扣操作日期
     */
    public void setWithholdDate(String withholdDate) {
        this.withholdDate = withholdDate;
    }

    /**
     * 获取划扣操作计数，不能超过已有渠道总数
     *
     * @return whthhold_count - 划扣操作计数，不能超过已有渠道总数
     */
    public Integer getWhthholdCount() {
        return whthholdCount;
    }

    /**
     * 设置划扣操作计数，不能超过已有渠道总数
     *
     * @param whthholdCount 划扣操作计数，不能超过已有渠道总数
     */
    public void setWhthholdCount(Integer whthholdCount) {
        this.whthholdCount = whthholdCount;
    }

    /**
     * 获取签约金额
     *
     * @return signature_principal - 签约金额
     */
    public BigDecimal getSignaturePrincipal() {
        return signaturePrincipal;
    }

    /**
     * 设置签约金额
     *
     * @param signaturePrincipal 签约金额
     */
    public void setSignaturePrincipal(BigDecimal signaturePrincipal) {
        this.signaturePrincipal = signaturePrincipal;
    }

    /**
     * 获取月偿还本金数额
     *
     * @return month_principal - 月偿还本金数额
     */
    public BigDecimal getMonthPrincipal() {
        return monthPrincipal;
    }

    /**
     * 设置月偿还本金数额
     *
     * @param monthPrincipal 月偿还本金数额
     */
    public void setMonthPrincipal(BigDecimal monthPrincipal) {
        this.monthPrincipal = monthPrincipal;
    }

    /**
     * 获取签约日期（债匹后的签约日期）
     *
     * @return signing_date - 签约日期（债匹后的签约日期）
     */
    public Date getSigningDate() {
        return signingDate;
    }

    /**
     * 设置签约日期（债匹后的签约日期）
     *
     * @param signingDate 签约日期（债匹后的签约日期）
     */
    public void setSigningDate(Date signingDate) {
        this.signingDate = signingDate;
    }

    /**
     * 获取状态（1：未完成还款；2：已完成全部还款；3：提前结清申请；4：提前结清;5:逾期）
     *
     * @return loan_status - 状态（1：未完成还款；2：已完成全部还款；3：提前结清申请；4：提前结清;5:逾期）
     */
    public Integer getLoanStatus() {
        return loanStatus;
    }

    /**
     * 设置状态（1：未完成还款；2：已完成全部还款；3：提前结清申请；4：提前结清;5:逾期）
     *
     * @param loanStatus 状态（1：未完成还款；2：已完成全部还款；3：提前结清申请；4：提前结清;5:逾期）
     */
    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    /**
     * 获取放款状态（1：未放款；2：放款中；3：放款成功；4：放款失败；5：拒绝贷款;）
     *
     * @return draw_status - 放款状态（1：未放款；2：放款中；3：放款成功；4：放款失败；5：拒绝贷款;）
     */
    public Integer getDrawStatus() {
        return drawStatus;
    }

    /**
     * 设置放款状态（1：未放款；2：放款中；3：放款成功；4：放款失败；5：拒绝贷款;）
     *
     * @param drawStatus 放款状态（1：未放款；2：放款中；3：放款成功；4：放款失败；5：拒绝贷款;）
     */
    public void setDrawStatus(Integer drawStatus) {
        this.drawStatus = drawStatus;
    }

    /**
     * 获取放款失败原因
     *
     * @return loan_failure_reason - 放款失败原因
     */
    public String getLoanFailureReason() {
        return loanFailureReason;
    }

    /**
     * 设置放款失败原因
     *
     * @param loanFailureReason 放款失败原因
     */
    public void setLoanFailureReason(String loanFailureReason) {
        this.loanFailureReason = loanFailureReason;
    }

    /**
     * 获取审核员员工号
     *
     * @return approval_emp - 审核员员工号
     */
    public String getApprovalEmp() {
        return approvalEmp;
    }

    /**
     * 设置审核员员工号
     *
     * @param approvalEmp 审核员员工号
     */
    public void setApprovalEmp(String approvalEmp) {
        this.approvalEmp = approvalEmp;
    }

    /**
     * 获取审核员姓名
     *
     * @return approval_emp_name - 审核员姓名
     */
    public String getApprovalEmpName() {
        return approvalEmpName;
    }

    /**
     * 设置审核员姓名
     *
     * @param approvalEmpName 审核员姓名
     */
    public void setApprovalEmpName(String approvalEmpName) {
        this.approvalEmpName = approvalEmpName;
    }

    /**
     * 获取接单时间
     *
     * @return order_time - 接单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置接单时间
     *
     * @param orderTime 接单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取借款端返回拒贷结果
     *
     * @return loan_reject_result - 借款端返回拒贷结果
     */
    public String getLoanRejectResult() {
        return loanRejectResult;
    }

    /**
     * 设置借款端返回拒贷结果
     *
     * @param loanRejectResult 借款端返回拒贷结果
     */
    public void setLoanRejectResult(String loanRejectResult) {
        this.loanRejectResult = loanRejectResult;
    }

    public PcOrderInfo() {
    }

    public PcOrderInfo(String orderNum) {
        this.orderNum = orderNum;
    }
}