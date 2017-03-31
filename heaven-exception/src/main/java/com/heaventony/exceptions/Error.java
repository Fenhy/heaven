package com.heaventony.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午2:44
 */
public enum Error {

    UNKNOW_EXCEPTION(0, "unknow exception"),



    AUTHORIZATION_FAILED(10001, "authorization failed"),
    LICENSE_FAILED (10002, "license failed"),
    ;

    private int code;
    private String message;

    Error(int code) {
        this.code = code;
    }

    Error(int code, String message) {
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
