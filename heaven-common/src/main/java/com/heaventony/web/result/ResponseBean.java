package com.heaventony.web.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午2:56
 */
@Data
public class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    private String version;

    private int code;

    private T data;

}
