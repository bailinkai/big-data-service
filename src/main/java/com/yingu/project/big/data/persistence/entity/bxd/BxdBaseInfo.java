package com.yingu.project.big.data.persistence.entity.bxd;

import javax.persistence.*;
import java.util.Date;

@Table(name = "bxd_base_info")
public class BxdBaseInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 保险单uuid
     */
    private String uuid;

    /**
     * 订单号
     */
    @Column(name = "order_num")
    private String orderNum;

    /**
     * 接口调用时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 姓名
     */
    private String name;

    /**
     * 保险公司名称
     */
    private String company;

    /**
     * 用户账号
     */
    @Column(name = "website_id")
    private String websiteId;

    /**
     * 系统用户id
     */
    private String token;

    /**
     * 接口版本
     */
    private String version;

    /**
     * 外键
     */
    @Column(name = "details_id")
    private String detailsId;

    /**
     * 证件类型
     */
    @Column(name = "id_card_type")
    private String idCardType;

    /**
     * 手机号码
     */
    @Column(name = "cell_phone")
    private String cellPhone;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 证件号码
     */
    @Column(name = "id_card_num")
    private String idCardNum;

    /**
     * 数据源
     */
    private String datasource;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 白天固定电话
     */
    @Column(name = "telephone_day")
    private String telephoneDay;

    /**
     * 晚上固定电话
     */
    @Column(name = "telephone_night")
    private String telephoneNight;

    /**
     * 邮编
     */
    private String postcode;

    @Column(name = "safe_level")
    private String safeLevel;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 微信账号
     */
    private String wxid;

    /**
     * 兴趣爱好
     */
    private String hobby;

    /**
     * 公司/学校
     */
    @Column(name = "company_school")
    private String companySchool;

    /**
     * 职位/学生
     */
    private String occupation;

    /**
     * 投保政策(新投保)
     */
    @Column(name = "policy_src_name")
    private String policySrcName;

    /**
     * 身高
     */
    private String height;

    /**
     * 体重
     */
    private String weight;

    /**
     * 抽烟时长
     */
    @Column(name = "smoke_year")
    private String smokeYear;

    /**
     * 抽烟频率
     */
    @Column(name = "smoking_frequency")
    private String smokingFrequency;

    /**
     * 抽烟中断时间
     */
    @Column(name = "smoking_cessation")
    private String smokingCessation;

    /**
     * 是否有独立住房
     */
    private String housing;

    /**
     * QQ号
     */
    @Column(name = "qq_num")
    private String qqNum;

    /**
     * 是否VIP
     */
    @Column(name = "is_vip")
    private String isVip;

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
     * 获取保险单uuid
     *
     * @return uuid - 保险单uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置保险单uuid
     *
     * @param uuid 保险单uuid
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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取用户账号
     *
     * @return website_id - 用户账号
     */
    public String getWebsiteId() {
        return websiteId;
    }

    /**
     * 设置用户账号
     *
     * @param websiteId 用户账号
     */
    public void setWebsiteId(String websiteId) {
        this.websiteId = websiteId;
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
     * 获取外键
     *
     * @return details_id - 外键
     */
    public String getDetailsId() {
        return detailsId;
    }

    /**
     * 设置外键
     *
     * @param detailsId 外键
     */
    public void setDetailsId(String detailsId) {
        this.detailsId = detailsId;
    }

    /**
     * 获取证件类型
     *
     * @return id_card_type - 证件类型
     */
    public String getIdCardType() {
        return idCardType;
    }

    /**
     * 设置证件类型
     *
     * @param idCardType 证件类型
     */
    public void setIdCardType(String idCardType) {
        this.idCardType = idCardType;
    }

    /**
     * 获取手机号码
     *
     * @return cell_phone - 手机号码
     */
    public String getCellPhone() {
        return cellPhone;
    }

    /**
     * 设置手机号码
     *
     * @param cellPhone 手机号码
     */
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    /**
     * 获取电子邮箱
     *
     * @return email - 电子邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮箱
     *
     * @param email 电子邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取证件号码
     *
     * @return id_card_num - 证件号码
     */
    public String getIdCardNum() {
        return idCardNum;
    }

    /**
     * 设置证件号码
     *
     * @param idCardNum 证件号码
     */
    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    /**
     * 获取数据源
     *
     * @return datasource - 数据源
     */
    public String getDatasource() {
        return datasource;
    }

    /**
     * 设置数据源
     *
     * @param datasource 数据源
     */
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    /**
     * 获取固定电话
     *
     * @return telephone - 固定电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置固定电话
     *
     * @param telephone 固定电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取白天固定电话
     *
     * @return telephone_day - 白天固定电话
     */
    public String getTelephoneDay() {
        return telephoneDay;
    }

    /**
     * 设置白天固定电话
     *
     * @param telephoneDay 白天固定电话
     */
    public void setTelephoneDay(String telephoneDay) {
        this.telephoneDay = telephoneDay;
    }

    /**
     * 获取晚上固定电话
     *
     * @return telephone_night - 晚上固定电话
     */
    public String getTelephoneNight() {
        return telephoneNight;
    }

    /**
     * 设置晚上固定电话
     *
     * @param telephoneNight 晚上固定电话
     */
    public void setTelephoneNight(String telephoneNight) {
        this.telephoneNight = telephoneNight;
    }

    /**
     * 获取邮编
     *
     * @return postcode - 邮编
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 设置邮编
     *
     * @param postcode 邮编
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * @return safe_level
     */
    public String getSafeLevel() {
        return safeLevel;
    }

    /**
     * @param safeLevel
     */
    public void setSafeLevel(String safeLevel) {
        this.safeLevel = safeLevel;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取微信账号
     *
     * @return wxid - 微信账号
     */
    public String getWxid() {
        return wxid;
    }

    /**
     * 设置微信账号
     *
     * @param wxid 微信账号
     */
    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    /**
     * 获取兴趣爱好
     *
     * @return hobby - 兴趣爱好
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置兴趣爱好
     *
     * @param hobby 兴趣爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * 获取公司/学校
     *
     * @return company_school - 公司/学校
     */
    public String getCompanySchool() {
        return companySchool;
    }

    /**
     * 设置公司/学校
     *
     * @param companySchool 公司/学校
     */
    public void setCompanySchool(String companySchool) {
        this.companySchool = companySchool;
    }

    /**
     * 获取职位/学生
     *
     * @return occupation - 职位/学生
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * 设置职位/学生
     *
     * @param occupation 职位/学生
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * 获取投保政策(新投保)
     *
     * @return policy_src_name - 投保政策(新投保)
     */
    public String getPolicySrcName() {
        return policySrcName;
    }

    /**
     * 设置投保政策(新投保)
     *
     * @param policySrcName 投保政策(新投保)
     */
    public void setPolicySrcName(String policySrcName) {
        this.policySrcName = policySrcName;
    }

    /**
     * 获取身高
     *
     * @return height - 身高
     */
    public String getHeight() {
        return height;
    }

    /**
     * 设置身高
     *
     * @param height 身高
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * 获取体重
     *
     * @return weight - 体重
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置体重
     *
     * @param weight 体重
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 获取抽烟时长
     *
     * @return smoke_year - 抽烟时长
     */
    public String getSmokeYear() {
        return smokeYear;
    }

    /**
     * 设置抽烟时长
     *
     * @param smokeYear 抽烟时长
     */
    public void setSmokeYear(String smokeYear) {
        this.smokeYear = smokeYear;
    }

    /**
     * 获取抽烟频率
     *
     * @return smoking_frequency - 抽烟频率
     */
    public String getSmokingFrequency() {
        return smokingFrequency;
    }

    /**
     * 设置抽烟频率
     *
     * @param smokingFrequency 抽烟频率
     */
    public void setSmokingFrequency(String smokingFrequency) {
        this.smokingFrequency = smokingFrequency;
    }

    /**
     * 获取抽烟中断时间
     *
     * @return smoking_cessation - 抽烟中断时间
     */
    public String getSmokingCessation() {
        return smokingCessation;
    }

    /**
     * 设置抽烟中断时间
     *
     * @param smokingCessation 抽烟中断时间
     */
    public void setSmokingCessation(String smokingCessation) {
        this.smokingCessation = smokingCessation;
    }

    /**
     * 获取是否有独立住房
     *
     * @return housing - 是否有独立住房
     */
    public String getHousing() {
        return housing;
    }

    /**
     * 设置是否有独立住房
     *
     * @param housing 是否有独立住房
     */
    public void setHousing(String housing) {
        this.housing = housing;
    }

    /**
     * 获取QQ号
     *
     * @return qq_num - QQ号
     */
    public String getQqNum() {
        return qqNum;
    }

    /**
     * 设置QQ号
     *
     * @param qqNum QQ号
     */
    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    /**
     * 获取是否VIP
     *
     * @return is_vip - 是否VIP
     */
    public String getIsVip() {
        return isVip;
    }

    /**
     * 设置是否VIP
     *
     * @param isVip 是否VIP
     */
    public void setIsVip(String isVip) {
        this.isVip = isVip;
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

    public BxdBaseInfo() {
    }

    public BxdBaseInfo(String orderNum) {
        this.orderNum = orderNum;
    }
}