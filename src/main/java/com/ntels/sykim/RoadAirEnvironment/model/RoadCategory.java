package com.ntels.sykim.RoadAirEnvironment.model;

/**
 * 도로변 구분 모델
 * @author sykim@ntels.com
 */
public class RoadCategory {
    /**
     * 도로변 구분
     */
    private String category;
    /**
     * 도로명
     */
    private String name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoadCategory{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
