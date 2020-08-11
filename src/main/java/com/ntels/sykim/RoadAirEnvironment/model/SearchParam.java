package com.ntels.sykim.RoadAirEnvironment.model;

/**
 * 도로변 및 측정소 구분에 따른 조회 파라미터 모델
 * @author sykim@ntels.com
 */
public class SearchParam {
    /**
     * 도로변 구분 명
     */
    private String RoadCategory;
    /**
     * 측정소 명
     */
    private String RoadStatus;

    public String getRoadCategory() {
        return RoadCategory;
    }

    public void setRoadCategory(String roadCategory) {
        RoadCategory = roadCategory;
    }

    public String getRoadStatus() {
        return RoadStatus;
    }

    public void setRoadStatus(String roadStatus) {
        RoadStatus = roadStatus;
    }

    @Override
    public String toString() {
        return "SearchParam{" +
                "RoadCategory='" + RoadCategory + '\'' +
                ", RoadStatus='" + RoadStatus + '\'' +
                '}';
    }
}
