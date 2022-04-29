package com.custmanager.myutils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyMethord
{
    /**
     * 判断实体类对象的属性的值为否为空（等于  “null” 或 null 或 “”   这三种，均视为空）
     * @param obj
     * @return
     * @throws Exception
     */
    public static  Integer objectFieldIsEmpty(Object obj) {
        Class<?> clazz = obj.getClass();  //得到类对象
        Field[] fs = clazz.getDeclaredFields(); //得到属性集合
        List list = new ArrayList();
        for(Field field:fs){            //遍历属性
            field.setAccessible(true); //设置属性是可以访问的（私有的也可以）
            try {

                if(field.get(obj) != null && field.get(obj) != "" && !("null".equalsIgnoreCase(field.get(obj).toString()))){
                    String name=(String)field.getName();
                    if(name.equals("serialVersionUID")) continue;//第一条属性是serialVersionUID
                    list.add(name);
                }
            } catch (IllegalAccessException e) {
               // throw new MyException(CodeEnum.COMMON_ERROR.getCode(),e.getMessage());
            }
        }
        return list.size();
    }
}
