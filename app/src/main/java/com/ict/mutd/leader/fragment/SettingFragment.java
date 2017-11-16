package com.ict.mutd.leader.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ict.mutd.leader.R;
import com.ict.mutd.leader.activity.FPSetActivity;
import com.ict.mutd.leader.util.PreferUtils;

/**
 * 设置
 */
public class SettingFragment extends Fragment implements View.OnClickListener {
    private TextView tv_unit, tv_department, tv_name;//单位、部门、姓名
    private RelativeLayout rl_figure_password, rl_about, rl_logout;//手势密码、关于、退出
    private Intent intent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_setting, null);
        tv_unit = view.findViewById(R.id.tv_unit);
        tv_department = view.findViewById(R.id.tv_department);
        tv_name = view.findViewById(R.id.tv_name);
        //单位
        tv_unit.setText(PreferUtils.getDeptName(getActivity().getApplicationContext()));
        //部门
        tv_department.setText(PreferUtils.getDepartName(getActivity().getApplicationContext()));
        //姓名
        tv_name.setText(PreferUtils.getUserName(getActivity().getApplicationContext()));
        //手势密码
        rl_figure_password = view.findViewById(R.id.rl_figure_password);
        //关于
        rl_about = view.findViewById(R.id.rl_about);
        //退出
        rl_logout = view.findViewById(R.id.rl_logout);

        setListener();
        return view;
    }

    /***
     * 设置监听事件
     */
    private void setListener() {
        rl_figure_password.setOnClickListener(this);
        rl_about.setOnClickListener(this);
        rl_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_figure_password:
                intent = new Intent(getActivity(), FPSetActivity.class);
                getActivity().startActivity(intent);
                break;
            case R.id.rl_about:

                break;
            case R.id.rl_logout:

                break;
        }
    }
}
