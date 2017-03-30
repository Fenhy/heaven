package com.heaventony.exceptions.handler;

import com.heaventony.exceptions.AuthExcetpion;
import com.heaventony.exceptions.Error;
import com.heaventony.exceptions.ExceptionBody;
import com.heaventony.web.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 下午2:51
 */

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final int UNAUTH = 401;

    @ExceptionHandler(AuthExcetpion.class)
    public Result authException(HttpServletResponse response) {
        response.setStatus(UNAUTH);
        return generateResult(new ExceptionBody(Error.AUTHORIZATION_FAILED));
    }

    private Result generateResult(ExceptionBody exBody) {
        Result result = new Result();
        result.setCode(exBody.getCode());
        result.setMessage(exBody.getMessage());
        return result;
    }
}
