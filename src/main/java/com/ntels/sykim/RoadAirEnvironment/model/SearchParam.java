package com.ntels.sykim.RoadAirEnvironment.model;

public class SearchParam {
    private String RoadCategory;
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
