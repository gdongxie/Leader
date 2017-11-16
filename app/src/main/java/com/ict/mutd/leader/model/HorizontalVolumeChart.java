package com.ict.mutd.leader.model;

import java.util.List;

/**
 * Created by ZZL on 2017/11/15.
 * Email:gdongxie@gmail.com
 */

public class HorizontalVolumeChart {

    private boolean colorByPoint;
    private String legend;
    private List<String> seriesname;
    private List<String> yAxis;
    private List<List<Double>> seriesdata;

    private List<String> xAxis;

    public List<String> getxAxis() {
        return xAxis;
    }

    public void setxAxis(List<String> xAxis) {
        this.xAxis = xAxis;
    }

    private String textUnit;


    public String getLegend() {
        return legend;
    }

    public void setLegend(String legend) {
        this.legend = legend;
    }


    public List<String> getyAxis() {
        return yAxis;
    }

    public void setyAxis(List<String> yAxis) {
        this.yAxis = yAxis;
    }

    public HorizontalVolumeChart(boolean colorByPoint, String legend, List<String> seriesname, List<String> yAxis, List<List<Double>> seriesdata, String textUnit, String unit) {
        this.colorByPoint = colorByPoint;
        this.legend = legend;
        this.seriesname = seriesname;
        this.yAxis = yAxis;
        this.seriesdata = seriesdata;

        this.textUnit = textUnit;
        this.unit = unit;
    }

    public String getTextUnit() {
        return textUnit;
    }

    public void setTextUnit(String textUnit) {
        this.textUnit = textUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    private String unit;

    public List<String> getSeriesname() {
        return seriesname;
    }

    public void setSeriesname(List<String> seriesname) {
        this.seriesname = seriesname;
    }

}
