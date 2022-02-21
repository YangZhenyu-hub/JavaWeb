package com.yzy.myssm.utils;


/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-20 10:51
 * @Version
 **/
public class StringUtils {

    //判断字符串是否为null或者""
    public static boolean isEmpty(String str){
        return str==null||"".equals(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

}
