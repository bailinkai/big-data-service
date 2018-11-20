package com.yingu.project.big.data.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author huangkunhao
 * @date 2018/1/15
 * @Description
 */
@Getter
@NoArgsConstructor
public enum ResponseCode {

    SUCCESS(1000, "成功"),
    ERROR(1001, "失败"),
    PARAM_INVALID(1002, "参数异常"),
    Login_Param_Null(-100, "账号或密码为空"),
    Cookie_TimeOut(-101, "账号已在别处登录"),
    Login_Account_Error(-102, "账号密码或账号输入错误"),
    Param_Data_Error(-103, "系统参数为空"),
    Select_User_NUll(-104, "无此用户"),
    Update_Pwd_Data_Null(-110, "更新密码参数为空"),
    Old_Pwd_Is_Error(-111, "老密码与原有密码不一致"),
    PROVINCEISNULL(1001, "省级参数不能为空"),
    AREAISNULL(1002, "区县级参数不能为空"),
    CITYISNULL(1003, "市級参数为不能空"),
    BUSINESSDEPARTMENT(1004, "营业部参数不能为空"),
    BUSINESSDEPARTMENTISTURE(1005, "营业部存在"),
    IS_NULL(-201, "请求参数为空"),
    Sys_IS_NULL(-200, "系统所需查询参数为空"),
    BUSINESSDEPARTMENTISFALSE(1006, "您的所在地不是该业务部的业务范围，请重新选择预约业务部"),
    ORGIDISNULL(1007, "门店ID不能为空"),
    ORGNAMEISNULL(1008, "门店名不能为空"),
    PRODUCTIDISNULL(1009, "产品ID不能为空"),
    CREATETIMEISNULL(1010, "进件时间"),
    PASTMUSTERISOK(1011, "符合进件规则"),
    DZSW_NAMEISNULL(-202, "真实姓名不能为空"),
    DZSW_IDNOISNULL(-203, "身份证号不能为空"),
    DZSW_MOBILEISNULL(-204, "手机号码不能为空"),
    DZSW_IDNOISERROR(-204, "身份证号格式错误"),
    DZSW_ZUZHIORUSERNAME_ISNULL(-205, "组织机构或个人用户名称不能为空"),
    DZSW_USERIDISNULL(-206, "调用者编号不能为空"),
    DZSW_NOUSERIDINSQL(-207, "调用者编号无效"),
    AREACONROL(1016, "不符合大纲要求(系统)"),
    NegativeINFO(1020, "负面信息(系统拒绝)"),
    PASTMUSTERNOOK2(1013, "工作居住城市/区域不符"),
    JMSLIMITSERROR(1014, "消息队列接收参数异常"),
    ORDERNUMISNULL(1015, "订单编号不能为空"),
    JXLNODATA(100200, "没有此用户报告"),
    ORDERNUM_ERROR(-300, "订单号不存在"),
    JXLNODATAINFO(100400, "聚信立没有此用户报告"),
    DZSW_ZUZHIORUSERNAME_ISCF(-208, "组织机构或个人用户名称不能重复"),
    PRODUCTCONTROL(1012, "不符合门店/产品优化调整(系统)"),
    ZXTNODATA(100300, "增信通没有此用户报告"),
    SHEBAODATANOTUSER(100400, "社保没有此用户报告"),
    GJJDATANOTUSER(100500, "公积金没有此用户报告"),
    BXDDATANOTUSER(100600, "保险单没有此用户报告"),
    RHDATANOTUSER(100700, "人行征信没有此用户报告"),
    TDDATANOTUSER(100800, "同盾没有此用户报告"),
    DZSWNOTINFO(100900, "电子商务没有此用户报告"),
    XJXHNOTUSER(101300, "互金协会没有此用户报告"),
    NOTASIC(100910, "暂未开放区间配置"),
    NOTEQUALs(101000, "已有该配置！"),
    SQLHAVEDATA(101010, "已有报告"),
    SYS_REFUSE(101019, "系统拒贷不予复议"),
    NonTargetCustomerGroup(101020, "非目标客户群(系统拒绝)"),
    API_ISNULL(100900, "三方接口查询为空");


    private Integer code;
    private String description;

    ResponseCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
