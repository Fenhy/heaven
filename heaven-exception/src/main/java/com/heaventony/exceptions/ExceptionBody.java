package com.heaventony.exceptions;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午3:25
 */
@Data
public class ExceptionBody {

    private int code;

    private String message;

    public ExceptionBody () {

    }

    public ExceptionBody (StatusCode e) {
        
        e = e == null ? StatusCode.UNKNOW_EXCEPTION : e;

        this.code = e.getCode();
        this.message = e.getMessage();

    }

}
