package com.heaventony.exceptions;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午2:44
 */
public enum StatusCode {

    //位置错误
    UNKNOW_EXCEPTION(0, "unknow exception"),
    UNKNOW_ACCOUNTEXCEPTION(10001, "用户名不存在"),
    PASSWORD_EXCEPTION(10002, "密码错误"),
    LOCKED_ACCOUNTEXCEPTION(10003, "账户锁定状态"),
    DISABLE_ACCOUNTEXCEPTION(10004, "账户被禁用"),
    EXCESSIVEATTEMPTS_EXCEPTION(10005, "登陆次数过多"),
    EXPIREDCREDENTIALS_EXCEPTION(10006, "用户凭证过期"),
    AUTHORIZATION_FAILED(20002, "authorization failed"),
    LICENSE_FAILED (30003, "license failed"),
    ;

    private int code;
    private String message;

    StatusCode(int code) {
        this.code = code;
    }

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
