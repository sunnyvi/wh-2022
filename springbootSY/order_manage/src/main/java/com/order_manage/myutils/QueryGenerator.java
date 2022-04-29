package com.order_manage.myutils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.text.SimpleDateFormat;
import java.util.Map;

public class QueryGenerator {
    public static final String SQL_RULES_COLUMN = "SQL_RULES_COLUMN";

    private static final String BEGIN = "_begin";
    private static final String END = "_end";
    /**
     * 数字类型字段，拼接此后缀 接受多值参数
     */
    private static final String MULTI = "_MultiString";
    private static final String STAR = "*";
    private static final String COMMA = ",";
    /**
     * 查询 逗号转义符 相当于一个逗号【作废】
     */
    public static final String QUERY_COMMA_ESCAPE = "++";
    private static final String NOT_EQUAL = "!";
    /**页面带有规则值查询，空格作为分隔符*/
    private static final String QUERY_SEPARATE_KEYWORD = " ";
    /**高级查询前端传来的参数名*/
    private static final String SUPER_QUERY_PARAMS = "superQueryParams";
    /** 高级查询前端传来的拼接方式参数名 */
    private static final String SUPER_QUERY_MATCH_TYPE = "superQueryMatchType";
    /** 单引号 */
    public static final String SQL_SQ = "'";
    /**排序列*/
    private static final String ORDER_COLUMN = "column";
    /**排序方式*/
    private static final String ORDER_TYPE = "order";
    private static final String ORDER_TYPE_ASC = "ASC";

    /**mysql 模糊查询之特殊字符下划线 （_、\）*/
    public static final String LIKE_MYSQL_SPECIAL_STRS = "_,%";

    /**日期格式化yyyy-MM-dd*/
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**to_date*/
    public static final String TO_DATE = "to_date";

    /**时间格式化 */
    private static final ThreadLocal<SimpleDateFormat> LOCAL = new ThreadLocal<SimpleDateFormat>();
    private static SimpleDateFormat getTime(){
        SimpleDateFormat time = LOCAL.get();
        if(time == null){
            time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            LOCAL.set(time);
        }
        return time;
    }

    /**
     * 获取查询条件构造器QueryWrapper实例 通用查询条件已被封装完成
     * @param searchObj 查询实体
     * @param parameterMap request.getParameterMap()
     * @return QueryWrapper实例
     */
    public static <T> QueryWrapper<T> initQueryWrapper(T searchObj, Map<String, String[]> parameterMap){
        long start = System.currentTimeMillis();
        QueryWrapper<T> queryWrapper = new QueryWrapper<T>();
        // installMplus(queryWrapper, searchObj, parameterMap);
        // log.debug("---查询条件构造器初始化完成,耗时:"+(System.currentTimeMillis()-start)+"毫秒----");
        return queryWrapper;
    }


}
