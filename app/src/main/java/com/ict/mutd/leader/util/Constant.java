package com.ict.mutd.leader.util;

/**
 * Created by ZZL on 2017/11/13.
 * Email:gdongxie@gmail.com
 */

public class Constant {
    // public static final String BASE_URL_NETWORK1 = "http://" + SERVERIP +
    // "/knsczd/Pages/";

    public static boolean rbpflag = true;

    public static String FPFLAG = "fgflag"; //是否手势登陆

    //登陆路径
    public static final String TESTSERVER_LOGIN = "http://172.21.4.178/LeaderApp/Pages/";

    //登陆
    public static final String UserLogin = TESTSERVER_LOGIN + "UserLogin.ashx";

    //其他接口路径
    public static final String TESTSERVER = "http://172.21.4.178/LeaderAPP/Pages/APP/";

    //车间日消耗情况
    public static final String QueryDeptDayMaterialConsumptionInfoList = TESTSERVER + "QueryDeptDayMaterialConsumptionInfoList.ashx";

    //运用修重要物资消耗情况
    public static final String QueryYYXDayImportantMaterialConsumptionInfoList = TESTSERVER + "QueryYYXDayImportantMaterialConsumptionInfoList.ashx";

    //工具未归还情况
    public static final String QueryToolsNoReturnInfoList = TESTSERVER + "QueryToolsNoReturnInfoList.ashx";

}
