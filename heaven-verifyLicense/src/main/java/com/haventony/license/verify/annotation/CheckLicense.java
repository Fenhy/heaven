package com.haventony.license.verify.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/31
 * Time: 上午9:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CheckLicense {
}
