package com.ict.mutd.leader.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.sax.RootElement;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.ict.mutd.leader.R;
import com.ict.mutd.leader.model.HorizontalVolumeChart;
import com.ict.mutd.leader.model.ToolsBean;
import com.ict.mutd.leader.model.UseRepairBean;
import com.ict.mutd.leader.model.WorkShopBean;
import com.ict.mutd.leader.util.Constant;
import com.ict.mutd.leader.util.DateUtils;
import com.ict.mutd.leader.util.GsonUtils;
import com.ict.mutd.leader.util.MyResponse;
import com.ict.mutd.leader.util.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/***
 * 首页
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";
    private TextView tv_end_time, tv_warn, tv_use_warn, tv_tools_warn;  //截止统计日期
    private WebView web_workshop, web_userepair, web_tools; //车间日消耗、运用修消耗、未归还工具
    private ProgressBar pb_workshop, pb_userepair, pb_tools;

    private WorkShopBean workShopBean;
    private List<WorkShopBean.ResultInfoListBean> workshopList = new ArrayList<>();
    private UseRepairBean useRepairBean;
    private List<UseRepairBean.ResultInfoListBean> userepairList = new ArrayList<>();
    private ToolsBean toolsBean;
    private List<ToolsBean.ResultInfoListBean> toolsList = new ArrayList<>();
    private Handler handler = new Handler();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        tv_end_time = view.findViewById(R.id.tv_end_time);
        tv_warn = view.findViewById(R.id.tv_warn);
        tv_use_warn = view.findViewById(R.id.tv_use_warn);
        tv_tools_warn = view.findViewById(R.id.tv_tool_warn);
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

        getWorkShopData();

        getUseRepairData();

        getToolsData();

        return view;
    }

    /***
     * 获取未归还工具情况
     */
    private void getToolsData() {
        OkHttpUtils.post()
                .url(Constant.QueryToolsNoReturnInfoList)
                .addParams("TodayDate", DateUtils.getDay(0))
                .build()
                .connTimeOut(7000)
                .readTimeOut(10000)
                .writeTimeOut(10000)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("工具", e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("工具", response);
                        if (response != null) {
                            toolsBean = GsonUtils.jsonToBean(response, ToolsBean.class);
                            if (toolsBean.getType() == MyResponse.OK) {
                                toolsList = toolsBean.getResultInfoList();
                                if (toolsList.size() > 0) {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            setView(web_tools, "file:///android_asset/web/verticalvolumechart.html", 2);
                                        }
                                    });
                                } else {
                                    web_tools.setVisibility(View.GONE);
                                    pb_tools.setVisibility(View.GONE);
                                    tv_tools_warn.setVisibility(View.VISIBLE);
                                }
                            } else {
                                ToastUtils.showToast(getActivity(), toolsBean.getDesc());
                            }
                        }


                    }
                });

    }

    /***
     * 获取运用修重要物资日消耗情况
     */
    private void getUseRepairData() {
        OkHttpUtils.post()
                .url(Constant.QueryYYXDayImportantMaterialConsumptionInfoList)
                .addParams("StartDate", DateUtils.getDay(0))
                .addParams("EndDate", DateUtils.getDay(0))
                .build()
                .connTimeOut(7000)
                .readTimeOut(10000)
                .writeTimeOut(10000)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Log.d("运用修", e.toString());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("运用修", response);
                        if (response != null) {
                            useRepairBean = GsonUtils.jsonToBean(response, UseRepairBean.class);
                            if (useRepairBean.getType() == MyResponse.OK) {
                                userepairList = useRepairBean.getResultInfoList();
                                if (userepairList.size() > 0) {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            setView(web_userepair, "file:///android_asset/web/horizontalvolumechart.html", 1);
                                        }
                                    });
                                } else {
                                    web_userepair.setVisibility(View.GONE);
                                    pb_userepair.setVisibility(View.GONE);
                                    tv_use_warn.setVisibility(View.VISIBLE);
                                }
                            } else {
                                ToastUtils.showToast(getActivity(), useRepairBean.getDesc());
                            }
                        }

                    }
                });
    }

    /***
     * 获取车间日消耗数据情况
     */
    private void getWorkShopData() {
        OkHttpUtils.post()
                .url(Constant.QueryDeptDayMaterialConsumptionInfoList)
                .addParams("StartDate", DateUtils.getDay(0))
                .addParams("EndDate", DateUtils.getDay(0))
                .build()
                .connTimeOut(7000)
                .readTimeOut(10000)
                .writeTimeOut(10000)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        ToastUtils.showToast(getActivity(), "网络连接异常");
                        Log.d("车间日消耗", e.toString());

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Log.d("车间日消耗", response);
                        if (response != null) {
                            workShopBean = GsonUtils.jsonToBean(response, WorkShopBean.class);

                            if (workShopBean.getType() == MyResponse.OK) {
                                workshopList = workShopBean.getResultInfoList();
                                if (workshopList.size() > 0) {
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            setView(web_workshop, "file:///android_asset/web/verticalvolumechart.html", 0);
                                        }
                                    });
                                } else {
                                    web_workshop.setVisibility(View.GONE);
                                    pb_workshop.setVisibility(View.GONE);
                                    tv_warn.setVisibility(View.VISIBLE);
                                }

                            } else {
                                ToastUtils.showToast(getActivity(), workShopBean.getDesc());
                            }
                        }

                    }
                });


    }

    private void setView(final WebView webview, String fileurl, final int flag) {
        webview.setBackgroundColor(Color.TRANSPARENT);
        CookieManager.getInstance().setAcceptCookie(true);
        webview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        webview.setVerticalScrollBarEnabled(true);
        webview.setHorizontalScrollBarEnabled(false);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(fileurl);
        webview.addJavascriptInterface(this, "SurveyUtil");
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                super.onConsoleMessage(message, lineNumber, sourceID);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                switch (flag) {
                    case 0:
                        getWorkShop(webview);
                        pb_workshop.setVisibility(View.GONE);
                        break;
                    case 1:
                        getUseRepair(webview);
                        pb_userepair.setVisibility(View.GONE);
                        break;
                    case 2:
                        getTools(webview);
                        pb_tools.setVisibility(View.GONE);
                        break;
                }


            }
        });
    }

    /***
     * 未归还工具统计数据
     * @param webview
     */
    @JavascriptInterface
    private void getTools(WebView webview) {
        boolean colorByPoint = true;
        String legend = "";
        List<String> seriesname = new ArrayList<>();
        seriesname.add("数量");
        List<String> yAxis = new ArrayList<String>();
        List<List<Double>> seriesdata = new ArrayList<List<Double>>();
        List temp = new ArrayList();
        for (int i = 0; i < workshopList.size(); i++) {
            yAxis.add(toolsList.get(i).getSDeptName());
            if ((Double.parseDouble(toolsList.get(i).getINumber())) > 0) {
                temp.add(Double.parseDouble(String.valueOf(Double.parseDouble(workshopList.get(i).getIAmount()))));
            }

        }
        seriesdata.add(temp);

        List<String> xAxis = new ArrayList<String>();

        String textUnit = "个";
        String unit = "个";
        HorizontalVolumeChart underRank = new HorizontalVolumeChart(colorByPoint, legend, seriesname, yAxis, seriesdata, textUnit, unit);
        underRank.setxAxis(xAxis);
        Log.e("工具", GsonUtils.toJson(underRank).toString());
        webview.loadUrl("javascript:showData('" + GsonUtils.toJson(underRank) + "')");

    }

    /**
     * 运用修重要物资日消耗数据
     *
     * @param webview
     */
    @JavascriptInterface
    private void getUseRepair(WebView webview) {
        boolean colorByPoint = true;
        String legend = "";
        List<String> seriesname = new ArrayList<>();
        seriesname.add("金额");
        List<String> yAxis = new ArrayList<String>();
        List<List<Double>> seriesdata = new ArrayList<List<Double>>();
        for (int i = 0; i < userepairList.size(); i++) {
            yAxis.add(userepairList.get(i).getSMaterialname());
        }

//        yAxis.add("仓库1");
//        yAxis.add("仓库2");
//        yAxis.add("仓库3");
//        yAxis.add("仓库4");
//        yAxis.add("仓库5");
//        yAxis.add("仓库6");
//        yAxis.add("仓库7");

        List temp = new ArrayList();
        for (int i = 0; i < userepairList.size(); i++) {
            if ((Double.parseDouble(userepairList.get(i).getIAmount()) / 10000) > 0) {
                Double s = Double.parseDouble(String.valueOf(Double.parseDouble(userepairList.get(i).getIAmount()) / 10000));
                BigDecimal decimal = new BigDecimal(s);
                temp.add(decimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }
        }
//        temp.add(20);
//        temp.add(10);
//        temp.add(30);
//        temp.add(40);
//        temp.add(10);
//        temp.add(40);
//        temp.add(10);
//

        seriesdata.add(temp);

        List<String> xAxis = new ArrayList<String>();
        String textUnit = "万元";

        String unit = "万元";
        HorizontalVolumeChart underRank = new HorizontalVolumeChart(colorByPoint, legend, seriesname, yAxis, seriesdata, textUnit, unit);

        underRank.setxAxis(xAxis);

        Log.e("运用修", GsonUtils.toJson(underRank).toString());


        webview.loadUrl("javascript:showData('" + GsonUtils.toJson(underRank) + "')");
    }

    /***
     * 车间日消耗柱状图数据
     */
    @JavascriptInterface
    private void getWorkShop(WebView webview) {
        boolean colorByPoint = true;
        String legend = "";
        List<String> seriesname = new ArrayList<>();
        seriesname.add("金额");
        List<String> yAxis = new ArrayList<String>();
        List<List<Double>> seriesdata = new ArrayList<List<Double>>();
        List temp = new ArrayList();
        for (int i = 0; i < workshopList.size(); i++) {
            yAxis.add(workshopList.get(i).getSDeptName());
            if ((Double.parseDouble(workshopList.get(i).getIAmount()) / 10000) > 0) {
                Double s = Double.parseDouble(String.valueOf(Double.parseDouble(workshopList.get(i).getIAmount()) / 10000));
                BigDecimal decimal = new BigDecimal(s);
                temp.add(decimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            }

        }
        seriesdata.add(temp);

        List<String> xAxis = new ArrayList<String>();

        String textUnit = "万元";
        String unit = "万元";
        HorizontalVolumeChart underRank = new HorizontalVolumeChart(colorByPoint, legend, seriesname, yAxis, seriesdata, textUnit, unit);
        underRank.setxAxis(xAxis);
        Log.e("车间", GsonUtils.toJson(underRank).toString());
        webview.loadUrl("javascript:showData('" + GsonUtils.toJson(underRank) + "')");

    }


}
