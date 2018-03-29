package com.heaventony.exceptions.handler;

import com.heaventony.exceptions.*;
import com.heaventony.exceptions.StatusCode;
import com.heaventony.web.result.ResponseBean;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午2:51
 */

@ControllerAdvice
@ResponseBody
@EnableWebMvc
public class GlobalExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final int UNAUTH = 401;

    @ExceptionHandler(AuthException.class)
    public ResponseBean authException(HttpServletResponse response) {
        response.setStatus(UNAUTH);
        return generateResult(new ExceptionBody(StatusCode.AUTHORIZATION_FAILED));
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseBean globalException(HttpServletResponse response, GlobalException ex) {
//        response.setStatus(UNAUTH);
        logger.info(ex.getStatusCode().getMessage());
        return generateResult(new ExceptionBody(ex.getStatusCode()));
    }

    @ExceptionHandler(UnknownAccountException.class)
    public ResponseBean unknownAccountException(HttpServletResponse response) {
        response.setStatus(UNAUTH);
        return generateResult(new ExceptionBody(StatusCode.UNKNOW_ACCOUNTEXCEPTION));
    }

    @ExceptionHandler(LicenseException.class)
    public ResponseBean licenseException(HttpServletResponse response) {
        response.setStatus(UNAUTH);
        return generateResult(new ExceptionBody(StatusCode.LICENSE_FAILED));
    }

    private ResponseBean generateResult(ExceptionBody exBody) {
        ResponseBean result = new ResponseBean();
        result.setCode(exBody.getCode());
        result.setMessage(exBody.getMessage());
        return result;
    }
}
