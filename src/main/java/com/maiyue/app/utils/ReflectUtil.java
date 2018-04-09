package com.maiyue.app.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;




public class ReflectUtil {
	
	
    public static Object getFieldValue(Object obj , String fieldName ){
        if(obj == null){
            return null ;
        }
        Field targetField = getTargetField(obj.getClass(), fieldName);
        try {
            return FieldUtils.readField(targetField, obj, true) ;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null ;
    }

    
    public static Field getTargetField(Class<?> targetClass, String fieldName) {
        Field field = null;

        try {
            if (targetClass == null) {
                return field;
            }

            if (Object.class.equals(targetClass)) {
                return field;
            }

            field = FieldUtils.getDeclaredField(targetClass, fieldName, true);
            if (field == null) {
                field = getTargetField(targetClass.getSuperclass(), fieldName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return field;
    }

    
    
    public static void setFieldValue(Object obj , String fieldName , Object value ){
        if(null == obj){return;}
        Field targetField = getTargetField(obj.getClass(), fieldName);
        try {
            FieldUtils.writeField(targetField, obj, value) ;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    /**
     * bean转map
     * @param obj
     * @param filterBlank
     * @return
     */
    public static Map<String,Object> beanToMap(Object obj,boolean filterBlank){
        if(obj == null){
            return null;
        }

        Map<String,Object> map = new HashMap<String,Object>();

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);
                    if(value != null){
                        if(filterBlank && value instanceof String){
                            if(StringUtils.isNotBlank(String.valueOf(value))){
                                map.put(key, value);
                            }
                            continue;
                        }

                        map.put(key, value);
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return map;
    }
    
    
    
}
