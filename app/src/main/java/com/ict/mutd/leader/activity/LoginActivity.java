package com.ict.mutd.leader.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.githang.statusbar.StatusBarCompat;
import com.ict.mutd.leader.R;
import com.ict.mutd.leader.model.LoginResultInfo;
import com.ict.mutd.leader.util.ActvityManager;
import com.ict.mutd.leader.util.Constant;
import com.ict.mutd.leader.util.GsonUtils;
import com.ict.mutd.leader.util.MyResponse;
import com.ict.mutd.leader.util.PreferUtils;
import com.ict.mutd.leader.util.ToastUtils;
import com.ict.mutd.leader.util.cache.ACache;
import com.ict.mutd.leader.view.ClearEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private ClearEditText et_userName, et_userPwd;
    private CheckBox checkBox;
    private LinearLayout ll_login;
    private String userName = "", userPwd = "";
    private ACache aCache;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //设置状态栏颜色
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.light_blue), true);
        ActvityManager.activityList.add(LoginActivity.this);
        initView();
        initData();
        initListener();
    }


    private void initView() {
        et_userName = (ClearEditText) findViewById(R.id.et_uesrName);
        et_userPwd = (ClearEditText) findViewById(R.id.et_userPwd);
        checkBox = (CheckBox) findViewById(R.id.cb);
        ll_login = (LinearLayout) findViewById(R.id.ll_login);
    }

    private void initData() {
        aCache = ACache.get(this);
        if (Constant.rbpflag) {
            if (!TextUtils.isEmpty(PreferUtils.getUserName(getApplicationContext()))) {
                et_userName.setText(PreferUtils.getUserName(getApplicationContext()));
            }

        }


    }

    private void initListener() {
        ll_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                userName = et_userName.getText().toString().trim();
                Log.d(TAG, userName);
                userPwd = et_userPwd.getText().toString().trim();
                Log.d(TAG, userPwd);
                if (TextUtils.isEmpty(userName)) {
                    ToastUtils.showToast(LoginActivity.this, "请输入用户名");
                    return;
                } else if (TextUtils.isEmpty(userPwd)) {
                    ToastUtils.showToast(LoginActivity.this, "请输入密码");
                    return;
                } else {
                    Log.d(TAG, "用户名：" + userName + "\u3000密码:" + userPwd);
                    login(userName, userPwd);
                }
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                Constant.rbpflag = isCheck;
            }
        });
    }

    /**
     * 登陆
     *
     * @param userName
     * @param userPwd
     */
    private void login(final String userName, String userPwd) {
        OkHttpUtils.post()
                .url(Constant.UserLogin)
                .addParams("userName", userName)
                .addParams("userPwd", userPwd)
                .build()
                .connTimeOut(7000)
                .readTimeOut(10000)
                .writeTimeOut(10000)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        Log.d(TAG, e.toString());
                        ToastUtils.showToast(LoginActivity.this, "网络连接异常，请稍后重试");
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d(TAG, response);
                        if (response != null) {
                            LoginResultInfo loginResultInfo = GsonUtils.jsonToBean(response, LoginResultInfo.class);
                            if (loginResultInfo.Type == MyResponse.OK) {
                                //保存用户名
                                PreferUtils.saveUserName(getApplicationContext(), loginResultInfo.getLoginInfo().getUserInfo().getStuffName());
                                //保存登陆状态
                                PreferUtils.saveLoginStatus(getApplicationContext(), true);
                                //保存单位名称
                                Log.d(TAG, "单位：" + loginResultInfo.getLoginInfo().getDepotInfo().getDeptName());
                                PreferUtils.saveDeptName(getApplicationContext(), loginResultInfo.getLoginInfo().getDepotInfo().getDeptName());
                                //保存部门名称
                                Log.d(TAG, "部门:" + loginResultInfo.getLoginInfo().getDepartmentDeptWL().getDeptName());
                                PreferUtils.saveDepartName(getApplicationContext(), loginResultInfo.getLoginInfo().getDepartmentDeptWL().getDeptName());

                                String gesturePassword = aCache.getAsString(com.ict.mutd.leader.util.constant.Constant.GESTURE_PASSWORD);
                                Log.d(TAG, "gesturePassword=" + gesturePassword);
                                if (gesturePassword == null || TextUtils.isEmpty(gesturePassword)) {
                                    intent = new Intent(LoginActivity.this, CreateGestureActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    intent = new Intent(LoginActivity.this, GestureLoginActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            } else {
                                ToastUtils.showToast(LoginActivity.this, loginResultInfo.Desc);
                            }
                        }
                    }
                });

    }

}
