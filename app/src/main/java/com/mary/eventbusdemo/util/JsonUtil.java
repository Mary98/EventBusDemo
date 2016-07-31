package com.mary.eventbusdemo.util;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
/**
 * Gson 简单封装
 * @author Mary
 *
 */
public class JsonUtil {
    private static Gson gson = null;
    static {
        if (gson == null) {
            gson = new Gson();
        }
    }
    
    /** 屏蔽构造方法 */
    private JsonUtil() {}

    /**
     * 转成json
     * 
     * @param object
     * @return
     */
    public static String jsonString(Object object) {
        String jsonString = null;
        if (gson != null) {
            jsonString = gson.toJson(object);
        }
        return jsonString;
    }

    /**
     * 转成bean
     * 
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> T jsonToBean(String jsonString, Class<T> cls) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(jsonString, cls);
        }
        return t;
    }

    /**
     * 转成list
     * 
     * @param gsonString
     * @param cls
     * @return
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> cls) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * 转成list中有map的
     * 
     * @param gsonString
     * @return
     */
    public static <T> List<Map<String, T>> jsonToListMaps(String jsonString) {
        List<Map<String, T>> list = null;
        if (gson != null) {
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Map<String, T>>>() {
                    }.getType());
        }
        return list;
    }

    /**
     * 转成map的
     * 
     * @param gsonString
     * @return
     */
    public static <T> Map<String, T> jsonToMaps(String jsonString) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(jsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
