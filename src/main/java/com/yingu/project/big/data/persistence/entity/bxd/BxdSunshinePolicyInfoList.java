package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_sunshine_policy_info_list")
public class BxdSunshinePolicyInfoList {
    public BxdSunshinePolicyInfoList() {
    }

    public BxdSunshinePolicyInfoList(String orderNum) {
        this.orderNum = orderNum;
    }

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
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 寿险保单一个账号在魔蝎科技中的映射ID	
     */
    @Column(name = "mapping_id")
    private String mappingId;

    /**
     * 承保险种对应的保单号
     */
    @Column(name = "policy_no")
    private String policyNo;

    /**
     * 保险公司名称
     */
    private String company;

    /**
     * 主险名称
     */
    @Column(name = "main_insurance")
    private String mainInsurance;

    /**
     * 险种类别(人身险、财产险、分红险等)
     */
    private String type;

    /**
     * 保障起始时间
     */
    @Column(name = "start_date")
    private String startDate;

    /**
     * 保障终止时间
     */
    @Column(name = "end_date")
    private String endDate;

    /**
     * 保障期限
     */
    private String period;

    /**
     * 保险状态(有效-已签发、缴费有效、有效、无效、已过期等)
     */
    private String status;

    /**
     * 保险份数
     */
    private String quantity;

    /**
     * 保障金额
     */
    private String amount;

    /**
     * 外键
     */
    @Column(name = "list_id")
    private String listId;

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
     * 获取寿险保单一个账号在魔蝎科技中的映射ID	
     *
     * @return mapping_id - 寿险保单一个账号在魔蝎科技中的映射ID	
     */
    public String getMappingId() {
        return mappingId;
    }

    /**
     * 设置寿险保单一个账号在魔蝎科技中的映射ID	
     *
     * @param mappingId 寿险保单一个账号在魔蝎科技中的映射ID	
     */
    public void setMappingId(String mappingId) {
        this.mappingId = mappingId;
    }

    /**
     * 获取承保险种对应的保单号
     *
     * @return policy_no - 承保险种对应的保单号
     */
    public String getPolicyNo() {
        return policyNo;
    }

    /**
     * 设置承保险种对应的保单号
     *
     * @param policyNo 承保险种对应的保单号
     */
    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    /**
     * 获取保险公司名称
     *
     * @return company - 保险公司名称
     */
    public String getCompany() {
        return company;
    }

    /**
     * 设置保险公司名称
     *
     * @param company 保险公司名称
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 获取主险名称
     *
     * @return main_insurance - 主险名称
     */
    public String getMainInsurance() {
        return mainInsurance;
    }

    /**
     * 设置主险名称
     *
     * @param mainInsurance 主险名称
     */
    public void setMainInsurance(String mainInsurance) {
        this.mainInsurance = mainInsurance;
    }

    /**
     * 获取险种类别(人身险、财产险、分红险等)
     *
     * @return type - 险种类别(人身险、财产险、分红险等)
     */
    public String getType() {
        return type;
    }

    /**
     * 设置险种类别(人身险、财产险、分红险等)
     *
     * @param type 险种类别(人身险、财产险、分红险等)
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取保障起始时间
     *
     * @return start_date - 保障起始时间
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置保障起始时间
     *
     * @param startDate 保障起始时间
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取保障终止时间
     *
     * @return end_date - 保障终止时间
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置保障终止时间
     *
     * @param endDate 保障终止时间
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取保障期限
     *
     * @return period - 保障期限
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置保障期限
     *
     * @param period 保障期限
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * 获取保险状态(有效-已签发、缴费有效、有效、无效、已过期等)
     *
     * @return status - 保险状态(有效-已签发、缴费有效、有效、无效、已过期等)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置保险状态(有效-已签发、缴费有效、有效、无效、已过期等)
     *
     * @param status 保险状态(有效-已签发、缴费有效、有效、无效、已过期等)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取保险份数
     *
     * @return quantity - 保险份数
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * 设置保险份数
     *
     * @param quantity 保险份数
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    /**
     * 获取保障金额
     *
     * @return amount - 保障金额
     */
    public String getAmount() {
        return amount;
    }

    /**
     * 设置保障金额
     *
     * @param amount 保障金额
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * 获取外键
     *
     * @return list_id - 外键
     */
    public String getListId() {
        return listId;
    }

    /**
     * 设置外键
     *
     * @param listId 外键
     */
    public void setListId(String listId) {
        this.listId = listId;
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