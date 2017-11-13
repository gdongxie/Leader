package com.ict.mutd.leader.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ZZL on 2017/11/13.
 * Email:gdongxie@gmail.com
 * 缓存工具类  保存相关信息
 */

public class PreferUtils {

    /***
     * 保存用户名
     * @param context
     * @param userName
     */
    public static void saveUserName(Context context, String userName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName", userName);
        editor.commit();
    }

    /***
     * 获取用户名
     * @param context
     * @return
     */
    public static String getUserName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("userName", Context.MODE_PRIVATE);
        return sharedPreferences.getString("userName", "");
    }

    /**
     * 保存登陆状态
     *
     * @param context
     * @param isLogin
     */
    public static void saveLoginStatus(Context context, boolean isLogin) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLogin", isLogin);
        editor.commit();
    }

    /***
     * 获取登陆状态
     * @param context
     * @return
     */
    public static boolean getLoginStatus(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("isLogin", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLogin", false);
    }

    /***
     * 保存单位名称
     * @param context
     * @param deptName
     */
    public static void saveDeptName(Context context, String deptName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("deptName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("deptName", deptName);
        editor.commit();
    }

    /**
     * 获取单位名称
     *
     * @param context
     * @return
     */
    public static String getDeptName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("deptName", Context.MODE_PRIVATE);
        return sharedPreferences.getString("deptName", "");
    }

    /**
     * 保存部门名称
     *
     * @param context
     * @param departName
     */
    public static void saveDepartName(Context context, String departName) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("departName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("departName", departName);
        editor.commit();
    }

    /**
     * 获取部门名称
     *
     * @param context
     * @return
     */
    public static String getDepartName(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("departName", Context.MODE_PRIVATE);
        return sharedPreferences.getString("departName", "");
    }
}
