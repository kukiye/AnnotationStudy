package com.kuki.annotationstudy.inject;

import androidx.annotation.IdRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author ：yeton
 * date : 2021/4/2 17:58
 * package：com.kuki.annotationstudy.inject
 * description :反射控件的注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectView {

  @IdRes int value();
}
