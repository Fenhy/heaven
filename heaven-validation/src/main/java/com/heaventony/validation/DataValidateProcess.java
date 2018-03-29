package com.heaventony.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @author: tonywill
 * Email: tongwei1985@gmail.com
 * Date: 2017/3/28
 * Time: 上午10:10
 */
public class DataValidateProcess {


    public static Map<String, Object> validate(Object bean) {
        Map<String, Object> result = new HashMap<String, Object>(10);
        result.put("message", "验证通过");
        result.put("result", true);

        Class<?> cls = bean.getClass();

        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(bean);
                Annotation[] anos = field.getAnnotations();
                for (Annotation annotation : anos) {
                    Class<?> clazz = annotation.annotationType();
                    Method[] methods = clazz.getDeclaredMethods();
                    for (Method method: methods) {
                        String methodName = method.getName();

                        Object obj = DataValidateProcess.class.newInstance();
                        try {
                            Method m = obj.getClass().getDeclaredMethod(methodName, Object.class, Field.class);
                            result = (Map<String, Object>)m.invoke(obj, value, field);
                            if(result.get("result").equals(false)) {
                                return result;
                            }
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }finally {
                field.setAccessible(false);
            }
        }
        return result;
    }

    public Map<String, Object> nullable(Object value, Field field) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        DataValidation annotation = field.getAnnotation(DataValidation.class);

        boolean isNull = value == null || "".equals(value);
        if (!annotation.nullable() && isNull){
            result.put("message", field.getName() + "字段不能为空");
            result.put("result", false);
        } else {
            result.put("message", "验证通过");
            result.put("result", true);
        }
        return result;
    }

    public Map<String, Object> maxLength(Object value, Field field) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        DataValidation annotation = field.getAnnotation(DataValidation.class);
        if (value != null && value.toString().length() > annotation.maxLength()){
            result.put("message", field.getName() + "字段长度超过" + annotation.maxLength());
            result.put("result", false);
        } else {
            result.put("message", "验证通过");
            result.put("result", true);
        }
        return result;
    }

    public Map<String, Object> minLength(Object value, Field field) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        DataValidation annotation = field.getAnnotation(DataValidation.class);
        if (value != null && value.toString().length() < annotation.minLength()){
            result.put("message", field.getName() + "字段长度小于" + annotation.minLength());
            result.put("result", false);
        } else {
            result.put("message", "验证通过");
            result.put("result", true);
        }
        return result;
    }

}
