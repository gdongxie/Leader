package com.ict.mutd.leader.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by ZZL on 2017/11/13.
 * Email:gdongxie@gmail.com
 * 日期工具类
 */

public class DateUtils {
    /**
     * 获取日期
     *
     * @param type -1;前一天,0:当天,1:后一天
     * @return
     */
    public  static String getDay(int type){

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, type);
        return sf.format(c.getTime());
    }

    /**
     * 获取当前月份
     * @return
     */
    public  static String getMonth(){

        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 0);
        return sf.format(c.getTime());
    }
    /**
     * 获取当前年份
     * @return
     */
    public  static String getYear(){

        SimpleDateFormat sf = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, 0);
        return sf.format(c.getTime());
    }
    /**
     * 获取当前年月
     */
    public static String getYearMonth(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        return sdf.format(new java.util.Date());
    }

}
