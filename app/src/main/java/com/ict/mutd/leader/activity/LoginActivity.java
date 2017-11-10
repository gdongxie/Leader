package com.ict.mutd.leader.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.githang.statusbar.StatusBarCompat;
import com.ict.mutd.leader.R;
import com.ict.mutd.leader.util.ActvityManager;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //设置状态栏颜色
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.light_blue), true);
        ActvityManager.activityList.add(LoginActivity.this);
    }

}
