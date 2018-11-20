package com.yingu.project.big.data.common;

/**
 * 网银枚举
 */
public enum WyStatus {
    BILLTYPE_DONE("DONE", "已出账单", false),
    BILLTYPE_UNDONE("UNDONE", "未出账单", false),
    CURRENCYTYPE_CNY("CNY", "人民币", false),
    CURRENCYTYPE_USD("USD", "美元", false),
    CURRENCYTYPE_HKD("HKD", "港币", false),
    CURRENCYTYPE_EUR("EUR", "欧元", false),
    CURRENCYTYPE_KRW("KRW", "韩元", false),
    CURRENCYTYPE_GBP("GBP", "英镑", false),
    CURRENCYTYPE_JPY("JPY", "日元", false),
    INSTALLMENTTYPE_CONSUME("CONSUME", "消费", false),
    INSTALLMENTTYPE_CASH("CASH", "现金", false),
    INSTALLMENTTYPE_BILL("BILL", "账单", false),
    CATEGORY_WITHDRAW("WITHDRAW", "-取现", false),
    CATEGORY_PAYMENTS("PAYMENTS", "-还款", false),
    CATEGORY_INTEREST("INTEREST", "-循环利息", false),
    CATEGORY_OVERDUEPAYMENT("OVERDUEPAYMENT", "-延滞金", false),
    CATEGORY_HANDLINGFEE("HANDLINGFEE", "-手续费", false),
    CATEGORY_SOCIALSECURITY("SOCIALSECURITY", "-社保", false),
    CATEGORY_COMMUNICATIONFEE("COMMUNICATIONFEE", "-通讯费", false),
    CATEGORY_LIVINGEXPENSE("LIVINGEXPENSE", "-生活费", false),
    CATEGORY_OTHEREXPENSE("OTHEREXPENSE", "-其它支出", false),
    CATEGORY_FUND("FUND", "-公积金", false),
    CATEGORY_RENT("RENT", "-房租", false),
    CATEGORY_FINANCE("FINANCE", "-理财", false),
    CATEGORY_CONSUMPTION("CONSUMPTION", "-消费", false),
    CATEGORY_REPAYMENT("REPAYMENT", "-还贷", false),
    CATEGORY_OVERDUEFEE("OVERDUEFEE", "-超额费", false),
    CATEGORY_INSTALLMENT("INSTALLMENT", "-分期", false),
    CATEGORY_SHOPPING("SHOPPING", "-消费", false),
    CATEGORY_OTHERFEE("OTHERFEE", "-其他费用", false),
    CATEGORY_SALARY("SALARY", "-工资", true),
    CATEGORY_BONUS("BONUS", "-奖金", true),
    CATEGORY_ACCRUAL("ACCRUAL", "-利息", true),
    CATEGORY_DEPOSIT("DEPOSIT", "-存现", true),
    CATEGORY_TRANSFER("TRANSFER", "-转账", true),
    CATEGORY_LOANS("LOANS", "-借贷", true),
    CATEGORY_REVERSE("REVERSE", "-冲账", true),
    CATEGORY_REFUND("REFUND", "-退款", true),
    CATEGORY_EARNINGS("EARNINGS", "-收益", true),
    CATEGORY_CLAIM("CLAIM", "-报销", true),
    CATEGORY_OTHERREVENUE("OTHERREVENUE", "-其它收入", true),
    UNKNOWN("UNKNOWN", "-未知", true);

    /**
     * code值
     */
    private final String code;

    /**
     * code对应的描述
     */
    private final String message;

    /**
     *
     */
    private final boolean bool;

    WyStatus(String code, String message, boolean bool) {
        this.code = code;
        this.message = message;
        this.bool = bool;
    }

    public static WyStatus getWyStatus(String code) {
        for (WyStatus e : WyStatus.values()) {
            if (code.equals(e.getCode())) {
                return e;
            }
        }
        return WyStatus.UNKNOWN;
    }

    /**
     * 获取code值
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 获取code值对应的描述
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * 获取code值对应的描述
     *
     * @return
     */
    public boolean getBool() {
        return bool;
    }
}
