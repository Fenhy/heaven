package com.heaventony.auth.interceptor;

import com.heaventony.auth.annotation.IgnoreToken;
import com.heaventony.exceptions.AuthExcetpion;
import com.heaventony.web.request.enums.RequestMethod;
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
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 上午10:38
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    public static final String AUTHORIZATION_HEADER = "Authorization-token";

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 拦截spring mvc restful接口，如果不带IngoreToken注解的接口都需要校验token
     * @param request
     * @param response
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        logger.info(request.getMethod() + ":" + request.getRequestURL());
        if (obj instanceof HandlerMethod && !RequestMethod.OPTIONS.equals(request.getMethod())) {
            HandlerMethod method = (HandlerMethod) obj;
            Object bean = method.getBean();
            Class<?> clazz = bean.getClass();

            //IngoreToken注解可以作用于类或者方法上
            if (clazz.getAnnotation(IgnoreToken.class) != null || method.getMethodAnnotation(IgnoreToken.class) != null) {
                return true;
            }
            String token = request.getHeader(AUTHORIZATION_HEADER);
            if (token == null){
                throw new AuthExcetpion();
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
