package com.heaventony.web.result;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午2:56
 */
@Data
public class Result {

    private String message;

    private int code;

    private Object data;

}
