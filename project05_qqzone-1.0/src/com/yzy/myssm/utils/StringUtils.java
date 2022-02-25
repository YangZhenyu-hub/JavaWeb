package com.yzy.myssm.utils;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author yzy 729141789@qq.com
 * @Date 2022-02-24 11:09
 * @Version
 **/
public class StringUtils {
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
