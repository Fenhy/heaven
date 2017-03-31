package com.haventony.license.verify.interceptor;

import com.haventony.license.verify.annotation.CheckLicense;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 上午10:10
 */
@Component
public class LicenseInterceptor implements HandlerInterceptor{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        logger.info(request.getMethod() + ":" + request.getRequestURL());
        if (obj instanceof HandlerMethod && !request.getMethod().equals("OPTIONS")) {
            HandlerMethod method = (HandlerMethod) obj;
            Object bean = method.getBean();
            Class<?> clazz = bean.getClass();

            //CheckLicense注解可以作用于类或者方法上
            if (clazz.getAnnotation(CheckLicense.class) != null || method.getMethodAnnotation(CheckLicense.class) != null) {

            }

        }
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}