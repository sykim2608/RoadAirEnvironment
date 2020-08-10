package com.ntels.sykim.RoadAirEnvironment.model;

/**
 * 선택된 도로변 구분 및 측정소 명 모델
 * @author sykim@ntels.com
 */
public class SelectedName {
    /**
     * 선택된 도로변 구분 명
     */
    public static String selected = "중앙차로";

    /**
     * 선택된 측정소 명
     */
    public static String measureStation = "강남대로";

    public static String getMeasureStation() {
        return measureStation;
    }

    public static void setMeasureStation(String measureStation) {
        SelectedName.measureStation = measureStation;
    }

    public static String getSelected() {
        return selected;
    }

    public static void setSelected(String selected) {
        SelectedName.selected = selected;
    }

}
