package com.ntels.sykim.RoadAirEnvironment.model;

/**
 * 도로별 대기 환경 정보 모델
 * @author sykim@ntels.com
 */
public class RoadStatus {
    /**
     * 도로명
     */
    private String roadName;
    /**
     * 미세먼지 농도
     */
    private int dust;
    /**
     * 오존 농도
     */
    private double ozone;
    /**
     * 이산화질소 농도
     */
    private double nitrogenDioxide;
    /**
     * 일산화탄소 농도
     */
    private double carbonMonoxide;
    /**
     * 아황산질소 농도
     */
    private double sulfurDioxide;
    /**
     * 초미세먼지 농도
     */
    private double ultrafineDust;

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public int getDust() {
        return dust;
    }

    public void setDust(int dust) {
        this.dust = dust;
    }

    public double getOzone() {
        return ozone;
    }

    public void setOzone(float ozone) {
        this.ozone = ozone;
    }

    public double getNitrogenDioxide() {
        return nitrogenDioxide;
    }

    public void setNitrogenDioxide(float nitrogenDioxide) {
        this.nitrogenDioxide = nitrogenDioxide;
    }

    public double getCarbonMonoxide() {
        return carbonMonoxide;
    }

    public void setCarbonMonoxide(float carbonMonoxide) {
        this.carbonMonoxide = carbonMonoxide;
    }

    public double getSulfurDioxide() {
        return sulfurDioxide;
    }

    public void setSulfurDioxide(float sulfurDioxide) {
        this.sulfurDioxide = sulfurDioxide;
    }

    public double getUltrafineDust() {
        return ultrafineDust;
    }

    public void setUltrafineDust(float ultrafineDust) {
        this.ultrafineDust = ultrafineDust;
    }

    @Override
    public String toString() {
        return "RoadStatus{" +
                "roadName='" + roadName + '\'' +
                ", dust=" + dust +
                ", ozone=" + ozone +
                ", nitrogenDioxide=" + nitrogenDioxide +
                ", carbonMonoxide=" + carbonMonoxide +
                ", sulfurDioxide=" + sulfurDioxide +
                ", ultrafineDust=" + ultrafineDust +
                '}';
    }
}
