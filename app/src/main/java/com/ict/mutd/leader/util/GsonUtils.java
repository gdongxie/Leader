package com.ict.mutd.leader.util;

import com.google.gson.Gson;

/**
 * Created by ZZL on 2017/11/13.
 * Email:gdongxie@gmail.com
 */

public class GsonUtils {
    /**
     * json转Bean类
     *
     * @param result
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonToBean(String result, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(result, clazz);
    }

    /**
     * object转json
     *
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }
}
