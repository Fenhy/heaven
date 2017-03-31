package com.heaventony.web.config;

import com.heaventony.license.verify.interceptor.LicenseInterceptor;
import com.heaventony.auth.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/29
 * Time: 上午11:54
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Resource
    AuthInterceptor authInterceptor;

    @Resource
    LicenseInterceptor licenseInterceptor;

//    @Bean
//    public CommonsMultipartResolver commonsMultipartResolver() {
//        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
//        resolver.setMaxUploadSize(1024 * 1024 * 20);
//        return resolver;
//    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(licenseInterceptor);
        registry.addInterceptor(authInterceptor);
    }
}
