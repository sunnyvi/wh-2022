package com.serviceapp.myutils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    //遍历，判断第一个非字母的字符位置，
    // 用于提取订单号里的custcode
    public static int findNotChar(String s){
        if(s==null||s.length()==0){
            return -1;
        }
        return IntStream.range(0,s.length()).filter(i->{
            char c = Character.toLowerCase(s.charAt(i));
            if(c<'a'||c>'z'){
                return true;
            }
            return  false;
        }).findFirst().getAsInt();
    }



    /**
     * origin字段向target转化
     * @param origin
     * @param target
     * @return
     */
    public static <T> T swap(Object origin,T target){
        Field[] tFs = target.getClass().getDeclaredFields();//获得属性
        Field[] oFs = origin.getClass().getDeclaredFields();//获得属性
        for(int i=0;i<tFs.length;i++){
            String tname=tFs[i].getName();
            for(int j=0;j<oFs.length;j++){
                if(oFs[j].getName().equals(tname)){
                    Object val=getValue(origin, tname);
                    setValue(target, tname, val);
                }
            }
        }
        return target;
    }
    /**
     *
     * @param beanObj 实体类
     */
    private static Object getValue(Object beanObj,String name){
        try {
            Field[] fields = beanObj.getClass().getDeclaredFields();//获得属性
            Class clazz = beanObj.getClass();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String names=field.getName();
                if(!names.equals(name)){
                    continue;
                }
                // 此处应该判断beanObj,property不为null
                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                Method getMethod = pd.getReadMethod();
                if (getMethod != null) {
                    //System.out.println(beanObj+"的字段是:"+field.getName()+"，类型是："+field.getType()+"，取到的值是： "+getMethod.invoke(beanObj));
                    return getMethod.invoke(beanObj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *
     * @param beanObj 实体类
     * @param name 字段名
     * @param value 值
     */
    private static void setValue(Object beanObj,String name,Object value){
        try {
            Field[] fields = beanObj.getClass().getDeclaredFields();//获得属性
            Class clazz = beanObj.getClass();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String names=field.getName();
                if(!names.equals(name)){
                    continue;
                }

                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), beanObj.getClass());
                Method setMethod = pd.getWriteMethod();
                if (setMethod != null) {
                    setMethod.invoke(beanObj, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     //TODO 效率待定
    //通过JSONObject 做中间类型，将字段大部分相同的两个类进行转换，主要用在实体和实体temp对应的两个表的数据插入
 /*    public static <T> T change(Object origin,T target){
        return JSONObject.parseObject(JSONObject.toJSONString(origin), T.);
     }*/
}
