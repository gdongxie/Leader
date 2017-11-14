package com.ict.mutd.leader.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ict.mutd.leader.R;
import com.ict.mutd.leader.util.DateUtils;

/***
 * 首页
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private TextView tv_end_time, tv_warn;  //截止统计日期
    private WebView web_workshop, web_userepair, web_tools; //车间日消耗、运用修消耗、未归还工具
    private ProgressBar pb_workshop, pb_userepair, pb_tools;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        tv_end_time = view.findViewById(R.id.tv_end_time);
        tv_warn = view.findViewById(R.id.tv_warn);
        //车间日消耗  柱形图
        web_workshop = view.findViewById(R.id.webview_workshop);
        //运用修   水平条形图
        web_userepair = view.findViewById(R.id.webview_use_repair);
        //工具未归还情况  柱形图
        web_tools = view.findViewById(R.id.webview_tools);
        pb_workshop = view.findViewById(R.id.home_workshop_progressbar);
        pb_userepair = view.findViewById(R.id.home_use_repair_progressbar);
        pb_tools = view.findViewById(R.id.home_tools_progressbar);

        tv_end_time.setText("截止统计日期:\u3000" + DateUtils.getDay(-1));


        return view;
    }

}
