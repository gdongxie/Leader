package com.ict.mutd.leader.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ZZL on 2017/11/9.
 * Email:gdongxie@gmail.com
 */

public class ToastUtils {
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}


