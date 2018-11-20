package com.yingu.project.big.data.persistence.entity.pc;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "pc_customer_work_info")
public class PcCustomerWorkInfo {
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
     * 订单编号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 录入员工编号
     */
    @Column(name = "operator_empno")
    private String operatorEmpno;

    /**
     * 公司性质
     */
    @Column(name = "company_nature")
    private String companyNature;

    /**
     * 行业性质
     */
    @Column(name = "industry_nature")
    private String industryNature;

    /**
     * 单位注册号
     */
    @Column(name = "register_no")
    private String registerNo;

    /**
     * 职业类型
     */
    @Column(name = "profession_type")
    private String professionType;

    /**
     * 每月发薪日
     */
    @Column(name = "pay_time")
    private String payTime;

    /**
     * 工资发放形式
     */
    @Column(name = "payment_way")
    private String paymentWay;

    /**
     * 所属部门
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 职位级别
     */
    @Column(name = "job_level")
    private String jobLevel;

    /**
     * 单位电话
     */
    @Column(name = "office_tel")
    private String officeTel;

    /**
     * 入职日期
     */
    private Date hiredate;

    /**
     * 每月收入
     */
    private BigDecimal salary;

    /**
     * 单位名称
     */
    @Column(name = "org_name")
    private String orgName;

    /**
     * 组织编码
     */
    @Column(name = "org_zipcode")
    private String orgZipcode;

    /**
     * 单位地址
     */
    @Column(name = "org_address")
    private String orgAddress;

    /**
     * 行业性质代码
     */
    @Column(name = "industry_nature_code")
    private String industryNatureCode;

    /**
     * 职业类型代码
     */
    @Column(name = "profession_type_code")
    private String professionTypeCode;

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
     * 获取录入员工编号
     *
     * @return operator_empno - 录入员工编号
     */
    public String getOperatorEmpno() {
        return operatorEmpno;
    }

    /**
     * 设置录入员工编号
     *
     * @param operatorEmpno 录入员工编号
     */
    public void setOperatorEmpno(String operatorEmpno) {
        this.operatorEmpno = operatorEmpno;
    }

    /**
     * 获取公司性质
     *
     * @return company_nature - 公司性质
     */
    public String getCompanyNature() {
        return companyNature;
    }

    /**
     * 设置公司性质
     *
     * @param companyNature 公司性质
     */
    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    /**
     * 获取行业性质
     *
     * @return industry_nature - 行业性质
     */
    public String getIndustryNature() {
        return industryNature;
    }

    /**
     * 设置行业性质
     *
     * @param industryNature 行业性质
     */
    public void setIndustryNature(String industryNature) {
        this.industryNature = industryNature;
    }

    /**
     * 获取单位注册号
     *
     * @return register_no - 单位注册号
     */
    public String getRegisterNo() {
        return registerNo;
    }

    /**
     * 设置单位注册号
     *
     * @param registerNo 单位注册号
     */
    public void setRegisterNo(String registerNo) {
        this.registerNo = registerNo;
    }

    /**
     * 获取职业类型
     *
     * @return profession_type - 职业类型
     */
    public String getProfessionType() {
        return professionType;
    }

    /**
     * 设置职业类型
     *
     * @param professionType 职业类型
     */
    public void setProfessionType(String professionType) {
        this.professionType = professionType;
    }

    /**
     * 获取每月发薪日
     *
     * @return pay_time - 每月发薪日
     */
    public String getPayTime() {
        return payTime;
    }

    /**
     * 设置每月发薪日
     *
     * @param payTime 每月发薪日
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取工资发放形式
     *
     * @return payment_way - 工资发放形式
     */
    public String getPaymentWay() {
        return paymentWay;
    }

    /**
     * 设置工资发放形式
     *
     * @param paymentWay 工资发放形式
     */
    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    /**
     * 获取所属部门
     *
     * @return dept_name - 所属部门
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置所属部门
     *
     * @param deptName 所属部门
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取职位级别
     *
     * @return job_level - 职位级别
     */
    public String getJobLevel() {
        return jobLevel;
    }

    /**
     * 设置职位级别
     *
     * @param jobLevel 职位级别
     */
    public void setJobLevel(String jobLevel) {
        this.jobLevel = jobLevel;
    }

    /**
     * 获取单位电话
     *
     * @return office_tel - 单位电话
     */
    public String getOfficeTel() {
        return officeTel;
    }

    /**
     * 设置单位电话
     *
     * @param officeTel 单位电话
     */
    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    /**
     * 获取入职日期
     *
     * @return hiredate - 入职日期
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * 设置入职日期
     *
     * @param hiredate 入职日期
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    /**
     * 获取每月收入
     *
     * @return salary - 每月收入
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * 设置每月收入
     *
     * @param salary 每月收入
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * 获取单位名称
     *
     * @return org_name - 单位名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置单位名称
     *
     * @param orgName 单位名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取组织编码
     *
     * @return org_zipcode - 组织编码
     */
    public String getOrgZipcode() {
        return orgZipcode;
    }

    /**
     * 设置组织编码
     *
     * @param orgZipcode 组织编码
     */
    public void setOrgZipcode(String orgZipcode) {
        this.orgZipcode = orgZipcode;
    }

    /**
     * 获取单位地址
     *
     * @return org_address - 单位地址
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * 设置单位地址
     *
     * @param orgAddress 单位地址
     */
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    /**
     * 获取行业性质代码
     *
     * @return industry_nature_code - 行业性质代码
     */
    public String getIndustryNatureCode() {
        return industryNatureCode;
    }

    /**
     * 设置行业性质代码
     *
     * @param industryNatureCode 行业性质代码
     */
    public void setIndustryNatureCode(String industryNatureCode) {
        this.industryNatureCode = industryNatureCode;
    }

    /**
     * 获取职业类型代码
     *
     * @return profession_type_code - 职业类型代码
     */
    public String getProfessionTypeCode() {
        return professionTypeCode;
    }

    /**
     * 设置职业类型代码
     *
     * @param professionTypeCode 职业类型代码
     */
    public void setProfessionTypeCode(String professionTypeCode) {
        this.professionTypeCode = professionTypeCode;
    }

    public PcCustomerWorkInfo() {
    }



    public PcCustomerWorkInfo(String orderNum) {
        this.orderNum = orderNum;
    }
}