package com.yingu.project.big.data.persistence.entity.rhzx;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "credit_tax_owed_records")
public class CreditTaxOwedRecords {
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
     * 主管税务机关
     */
    private String institution;

    /**
     * 欠税统计时间
     */
    @Column(name = "owed_date")
    private String owedDate;

    /**
     * 欠税总额
     */
    @Column(name = "owed_amount")
    private BigDecimal owedAmount;

    /**
     * 纳税人识别号
     */
    @Column(name = "distinguish_num")
    private String distinguishNum;

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
     * 获取主管税务机关
     *
     * @return institution - 主管税务机关
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * 设置主管税务机关
     *
     * @param institution 主管税务机关
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * 获取欠税统计时间
     *
     * @return owed_date - 欠税统计时间
     */
    public String getOwedDate() {
        return owedDate;
    }

    /**
     * 设置欠税统计时间
     *
     * @param owedDate 欠税统计时间
     */
    public void setOwedDate(String owedDate) {
        this.owedDate = owedDate;
    }

    /**
     * 获取欠税总额
     *
     * @return owed_amount - 欠税总额
     */
    public BigDecimal getOwedAmount() {
        return owedAmount;
    }

    /**
     * 设置欠税总额
     *
     * @param owedAmount 欠税总额
     */
    public void setOwedAmount(BigDecimal owedAmount) {
        this.owedAmount = owedAmount;
    }

    /**
     * 获取纳税人识别号
     *
     * @return distinguish_num - 纳税人识别号
     */
    public String getDistinguishNum() {
        return distinguishNum;
    }

    /**
     * 设置纳税人识别号
     *
     * @param distinguishNum 纳税人识别号
     */
    public void setDistinguishNum(String distinguishNum) {
        this.distinguishNum = distinguishNum;
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