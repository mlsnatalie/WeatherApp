package com.yintech.orderdemo.data.remote

/**
 *
 * Created by zhangliang on 2018/5/5.
 */
enum class ApiCode (val code: String, val description: String) {
    // common
    SUCCESS("0000", "操作成功"),
    ERROR_SYSTEM("10", "系统异常"),
    PARAM_IS_EMPTY("2001", "缺少必要参数"),
    ERROR_PASSWORD_PATTERN("2002", "不可设置为初始密码"),
    // common

    // auth
    ERROR_AUTHENTICATION("1001", "非法用户"),
    ERROR_JWT_TOKEN_EXPIRED("1002", "授权过期"),// 重新登录
    ERROR_AUTHENTICATION_FAILED("1003", "没有访问权限"),
    ERROR_AUTHENTICATION_METHOD("1004", "不支持的请求方法"),
    ERROR_AUTHENTICATION_FAILED2("1005", "没有访问权限"),

    // user
    ERROR_EXISTS_MOBILE("3101", "手机号已存在"),
    ERROR_NOT_EXISTS_MOBILE("3102", "非法用户"),
    /**
     * 请重新设置密码
     */
    MUST_SET_PASSWORD("3103", "请重新设置密码"),
    // user

    // version
    INVALID_VERSION("3001", "非法或无效版本"),
    NOT_LATEST_VERSION("3002", "不是最新版本"),
    ERROR_EXISTS_VERSION("3003", "已存在相同或更高的版本"),

    // investorAuth
    ERROR_INVESTOR_CERT_INVALID("3500", "尚未进行风险评测或者评测结果已经失效"),
    ERROR_INVESTOR_CERT_EXIST_IDCARD("3501", "已经绑定身份证"),
    ERROR_INVESTOR_CERT_EXIST_EXTROINFO("3502", "已经进行过信息采集"),

    // network etc.
    ERROR_NETWORK("99001", "网络连接失败"),
    ERROR_HTTP("99002", "协议出错"),
    ERROR_PARSE("99002", "解析错误"),
    ERROR_UNKNOWN("99002", "未知错误"),
}
