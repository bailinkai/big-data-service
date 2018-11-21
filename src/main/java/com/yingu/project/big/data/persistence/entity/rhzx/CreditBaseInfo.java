package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.util.Date;

@Table(name = "credit_base_info")
public class CreditBaseInfo {
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
     * 用户姓名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户的证件类型
     */
    @Column(name = "id_card_type")
    private String idCardType;

    /**
     * 证件号码
     */
    @Column(name = "id_card_no")
    private String idCardNo;

    /**
     * 申请报告时间
     */
    @Column(name = "query_time")
    private String queryTime;

    /**
     * 生成报告时间
     */
    @Column(name = "report_time")
    private String reportTime;

    /**
     * 婚姻状态
     */
    @Column(name = "marital_status")
    private String maritalStatus;

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
     * 获取用户姓名
     *
     * @return user_name - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户的证件类型
     *
     * @return id_card_type - 用户的证件类型
     */
    public String getIdCardType() {
        return idCardType;
    }

    /**
     * 设置用户的证件类型
     *
     * @param idCardType 用户的证件类型
     */
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    /**
     * 获取证件号码
     *
     * @return id_card_no - 证件号码
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * 设置证件号码
     *
     * @param idCardNo 证件号码
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * 获取申请报告时间
     *
     * @return query_time - 申请报告时间
     */
    public String getQueryTime() {
        return queryTime;
    }

    /**
     * 设置申请报告时间
     *
     * @param queryTime 申请报告时间
     */
    public void setQueryTime(String queryTime) {
        this.queryTime = queryTime;
    }

    /**
     * 获取生成报告时间
     *
     * @return report_time - 生成报告时间
     */
    public String getReportTime() {
        return reportTime;
    }

    /**
     * 设置生成报告时间
     *
     * @param reportTime 生成报告时间
     */
    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 获取婚姻状态
     *
     * @return marital_status - 婚姻状态
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 设置婚姻状态
     *
     * @param maritalStatus 婚姻状态
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
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