package com.ict.mutd.leader.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ict.mutd.leader.R;
import com.ict.mutd.leader.util.PreferUtils;
import com.ict.mutd.leader.view.SwitchButton;

public class FPSetActivity extends BaseActivity {
    private LinearLayout ll_fp;
    private SwitchButton my_fp_switch;
    private RelativeLayout rl_fp;
    private RelativeLayout rl_top_bar_back;
    private TextView top_bar_title;

    @Override
    protected int initContentView() {
        return R.layout.activity_fpset;
    }

    @Override
    protected void initView() {
        ll_fp = findViewById(R.id.ll_fp);
        my_fp_switch = findViewById(R.id.my_fp_switch);
        rl_fp = findViewById(R.id.rl_fp);
        boolean flag = PreferUtils.getGestureStatus(getApplicationContext());
        if (flag) {
            rl_fp.setVisibility(View.VISIBLE);
        } else {
            rl_fp.setVisibility(View.GONE);
        }
        my_fp_switch.setSelected(flag);
        rl_top_bar_back = findViewById(R.id.rl_top_bar_back);
        rl_top_bar_back.setVisibility(View.VISIBLE);
        top_bar_title = findViewById(R.id.top_bar_title);

    }

    @Override
    protected void initData() {

        top_bar_title.setText("手势密码");

    }

    @Override
    protected void initListener() {
        rl_top_bar_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        rl_fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FPSetActivity.this, ReGestureLoginActivity.class);
                startActivity(intent);
            }
        });
        my_fp_switch.setOnSwitchButtonClick(new SwitchButton.OnSwitchButtonClick() {
            @Override
            public void onClick(boolean selected) {
                if (selected) {
                    rl_fp.setVisibility(View.VISIBLE);

                } else {
                    rl_fp.setVisibility(View.GONE);
                }
                PreferUtils.saveGestureStatus(getApplicationContext(), selected);
            }
        });
    }

}

