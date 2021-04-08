package com.kuki.annotationstudy.inject;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author ：yeton
 * date : 2021/4/8 17:50
 * package：com.kuki.annotationstudy.inject
 * description : 通过反射和注解方式获取Intent Data
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IntentData {
    String value() default "";
}
