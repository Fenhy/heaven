package com.heaventony.web.request;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/8/10
 * Time: 下午5:34
 */
@Data
public class RequestParam<T> {

    private String version;
    private String action;
    private T params;
}
