package com.heaventony.license.verify.interceptor;

import com.heaventony.license.verify.VerifyLicense;
import com.heaventony.license.verify.annotation.CheckLicense;
import com.heaventony.exceptions.LicenseException;
import com.heaventony.web.request.enums.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 上午10:10
 */
@Component
public class LicenseInterceptor implements HandlerInterceptor{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private VerifyLicense verifyLicense;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        logger.info(request.getMethod() + ":" + request.getRequestURL());
        if (obj instanceof HandlerMethod && !RequestMethod.OPTIONS.equals(request.getMethod())) {
            HandlerMethod method = (HandlerMethod) obj;
            Object bean = method.getBean();
            Class<?> clazz = bean.getClass();

            //CheckLicense注解可以作用于类或者方法上
            if (clazz.getAnnotation(CheckLicense.class) != null || method.getMethodAnnotation(CheckLicense.class) != null) {
                if (!verifyLicense.verify()) {
                    throw new LicenseException();
                }
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
