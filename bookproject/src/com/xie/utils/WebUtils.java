package com.xie.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author xie
 * @create 2022-11-09
 */
public class WebUtils {
    /**
     * 将请求的数据封装到bean对象中
     * @param value
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成int型
     * @param str
     * @param defaultValue
     * @return
     */
    public static int parseInt(String str,int defaultValue){

        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
