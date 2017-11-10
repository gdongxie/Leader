package com.ict.mutd.leader.activity;

import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.ict.mutd.leader.R;
import com.ict.mutd.leader.adapter.MyFragmentPagerAdapter;
import com.ict.mutd.leader.fragment.ApprovalFragment;
import com.ict.mutd.leader.fragment.ChartFragment;
import com.ict.mutd.leader.fragment.HomeFragment;
import com.ict.mutd.leader.fragment.SettingFragment;
import com.ict.mutd.leader.util.ActvityManager;
import com.ict.mutd.leader.util.NetWorkUti;
import com.ict.mutd.leader.util.ToastUtils;
import com.ict.mutd.leader.view.NoScrollViewPager;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    //头部标题栏
    private RelativeLayout top;
    //ViewPager
    private NoScrollViewPager container;
    //底部栏
    private RadioGroup rg_bottom;
    //标题
    private TextView tv_title;
    //首页，审批，图表，设置四个栏目
    private RadioButton rb_home, rb_approval, rb_chat, rb_setting;


    private FragmentManager fragmentManager;
    private ArrayList<Fragment> fragmentArrayList;
    private HomeFragment homeFragment;
    private ApprovalFragment approvalFragment;
    private ChartFragment chartFragment;
    private SettingFragment settingFragment;
    private Drawable drawable1, drawable2, drawable3, drawable4;


    @Override
    protected int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        container = findViewById(R.id.container);
        rg_bottom = findViewById(R.id.rg_bottom);
        tv_title = findViewById(R.id.top_bar_title);
        rb_home = findViewById(R.id.bottom_1);
        rb_approval = findViewById(R.id.bottom_2);
        rb_chat = findViewById(R.id.bottom_3);
        rb_setting = findViewById(R.id.bottom_4);

    }


    @Override
    protected void initData() {
        ActvityManager.activityList.add(MainActivity.this);

        drawable1 = getResources().getDrawable(R.drawable.navigation_home);
        drawable2 = getResources().getDrawable(R.drawable.navigation_approval);
        drawable3 = getResources().getDrawable(R.drawable.navigation_chat);
        drawable4 = getResources().getDrawable(R.drawable.navigation_setting);
        WindowManager windowManager = this.getWindowManager();
        int width = windowManager.getDefaultDisplay().getWidth();
        int i = 60;
        if (width < 1080) {
            i = 30;
        }
        drawable1.setBounds(0, 0, i, i);
        drawable2.setBounds(0, 0, i, i);
        drawable3.setBounds(0, 0, i, i);
        drawable4.setBounds(0, 0, i, i);
        rb_home.setCompoundDrawables(null, drawable1, null, null);
        rb_approval.setCompoundDrawables(null, drawable2, null, null);
        rb_chat.setCompoundDrawables(null, drawable3, null, null);
        rb_setting.setCompoundDrawables(null, drawable4, null, null);
        rg_bottom.check(R.id.bottom_1);


        //判断网络是否连接
        if (NetWorkUti.isNetworkAvalible(this)) {//有网络

        } else {
            ToastUtils.showToast(this, "网络未连接");
        }
        //   setBrightnessMode(this,0);

        rg_bottom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkId) {
                switch (checkId) {
                    case R.id.bottom_1:
                        rg_bottom.check(R.id.bottom_1);
                        container.setCurrentItem(0, false);
                        tv_title.setText("首页");
                        break;
                    case R.id.bottom_2:
                        rg_bottom.check(R.id.bottom_2);
                        container.setCurrentItem(1, false);
                        tv_title.setText("审批");
                        break;
                    case R.id.bottom_3:
                        rg_bottom.check(R.id.bottom_3);
                        container.setCurrentItem(2, false);
                        tv_title.setText("图表");
                        break;
                    case R.id.bottom_4:
                        rg_bottom.check(R.id.bottom_4);
                        container.setCurrentItem(3, false);
                        tv_title.setText("设置");
                }

            }
        });
        //实例化Fragment
        fragmentManager = getSupportFragmentManager();
        homeFragment = new HomeFragment();
        approvalFragment = new ApprovalFragment();
        chartFragment = new ChartFragment();
        settingFragment = new SettingFragment();
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(homeFragment);
        fragmentArrayList.add(approvalFragment);
        fragmentArrayList.add(chartFragment);
        fragmentArrayList.add(settingFragment);
        //设置ViewPager适配器
        container.setAdapter(new MyFragmentPagerAdapter(fragmentManager, fragmentArrayList));
        //显示第一个Fragment
        container.setCurrentItem(0);
        tv_title.setText("首页");
        //ViewPager设置页面滑动监听
        container.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        rg_bottom.check(R.id.bottom_1);
                        tv_title.setText("首页");
                        break;
                    case 1:
                        rg_bottom.check(R.id.bottom_2);
                        tv_title.setText("审批");
                        break;
                    case 2:
                        rg_bottom.check(R.id.bottom_3);
                        tv_title.setText("图表");
                        break;
                    case 3:
                        rg_bottom.check(R.id.bottom_4);
                        tv_title.setText("设置");
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initListener() {

    }

    /***
     * 点击两次退出程序
     * @param keyCode
     * @param event
     * @return
     */
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
            long secondTime = System.currentTimeMillis();
            if (secondTime - firstTime > 2000) {
                ToastUtils.showToast(this, "再按一次退出领导APP");
                firstTime = secondTime;
            } else {
                ActvityManager.exitClient(MainActivity.this);
            }
        }
        return true;
    }
}
