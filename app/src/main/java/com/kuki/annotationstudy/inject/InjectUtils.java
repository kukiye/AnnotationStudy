package com.kuki.annotationstudy.inject;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * author ：yeton
 * date : 2021/4/2 17:57
 * package：com.kuki.annotationstudy.inject
 * description :
 */
public class InjectUtils {
    
    public static void injectView(Activity activity){
        Class<? extends Activity> aClass = activity.getClass();

        //获得此类的所有属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            //判断属性是否被InjectView注解声明
            if(field.isAnnotationPresent(InjectView.class)){
                //获取属性
                InjectView injectView = field.getAnnotation(InjectView.class);
                int id = injectView.value();
                View view = activity.findViewById(id);

                field.setAccessible(true);
                try {
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

    }
    
}
