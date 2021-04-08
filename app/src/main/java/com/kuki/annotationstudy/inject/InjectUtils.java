package com.kuki.annotationstudy.inject;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Field;

/**
 * author ：yeton
 * date : 2021/4/2 17:57
 * package：com.kuki.annotationstudy.inject
 * description :
 */
public class InjectUtils {

    /**
     * 通过反射注解获取activity 的view
     *
     * @param activity
     */
    public static void injectView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();

        //获得此类的所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //判断属性是否被InjectView注解声明
            if (field.isAnnotationPresent(InjectView.class)) {
                //获取属性
                InjectView injectView = field.getAnnotation(InjectView.class);
                //获得了注解中设置的id
                int id = injectView.value();
                View view = activity.findViewById(id);
                //反射设置 属性的值
                //设置访问权限，允许操作private的属性
                field.setAccessible(true);
                try {
                    //反射赋值
                    field.set(activity, view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    /**
     * 通过反射注解获取activity 的Intent Data
     *
     * @param activity
     */
    public static void injectIntentData(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();

        Field[] declaredFieldArr = aClass.getDeclaredFields();
        for (Field field : declaredFieldArr) {
            if (field.isAnnotationPresent(IntentData.class)) {

                IntentData intentData = field.getAnnotation(IntentData.class);
                String injectValue = intentData.value();
                //                Log.d("InjectUtils", "injectValue==" + injectValue);
                //注入的值可能是空
                String fildName = TextUtils.isEmpty(injectValue) ? field.getName() : injectValue;
                //                Log.d("InjectUtils", "field.getName()==" + field.getName());
                //                Log.d("InjectUtils", "fildName==" + fildName);

                //从Intent 中获取fildName作为Key的值
                Bundle bundle = activity.getIntent().getExtras();
                if (bundle.containsKey(fildName)) {
                    Object object = bundle.get(fildName);

                    //给activity的属性赋值 通过反射
                    field.setAccessible(true);

                    try {
                        field.set(activity, object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }


        }

    }


}
