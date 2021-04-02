package com.kuki.annotationstudy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author ：yeton
 * date : 2021/4/2 11:54
 * package：com.kuki.annotationstudy
 * description :
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {

    String value();
    int id();

}
