package com.ntels.sykim.RoadAirEnvironment.model.road;

/**
 * 측정소에 따른 대기 환경 수치 정보
 * @author sykim@ntels.com
 */
public class Row {
    /**
     * 측정 일시
     */
    private String MSRDT;
    /**
     * 도로변 구분
     */
    private String MSRCLS_CD;
    /**
     * 측정소 명
     */
    private String MSRSTE_NM;
    /**
     * 미세먼지 농도
     */
    private int PM10;
    /**
     * 오존 농도
     */
    private double O3;
    /**
     * 이산화질소 농도
     */
    private double NO2;
    /**
     * 일산화탄소 농도
     */
    private double CO;
    /**
     * 아황산가스 농도
     */
    private double SO2;
    /**
     * 초미세먼지 농도
     */
    private int PM25;

    public String getMSRDT() {
        return MSRDT;
    }

    public void setMSRDT(String MSRDT) {
        this.MSRDT = MSRDT;
    }

    public String getMSRCLS_CD() {
        return MSRCLS_CD;
    }

    public void setMSRCLS_CD(String MSRCLS_CD) {
        this.MSRCLS_CD = MSRCLS_CD;
    }

    public String getMSRSTE_NM() {
        return MSRSTE_NM;
    }

    public void setMSRSTE_NM(String MSRSTE_NM) {
        this.MSRSTE_NM = MSRSTE_NM;
    }

    public int getPM10() {
        return PM10;
    }

    public void setPM10(int PM10) {
        this.PM10 = PM10;
    }

    public double getO3() {
        return O3;
    }

    public void setO3(double o3) {
        O3 = o3;
    }

    public double getNO2() {
        return NO2;
    }

    public void setNO2(double NO2) {
        this.NO2 = NO2;
    }

    public double getCO() {
        return CO;
    }

    public void setCO(double CO) {
        this.CO = CO;
    }

    public double getSO2() {
        return SO2;
    }

    public void setSO2(double SO2) {
        this.SO2 = SO2;
    }

    public int getPM25() {
        return PM25;
    }

    public void setPM25(int PM25) {
        this.PM25 = PM25;
    }

    @Override
    public String toString() {
        return "Row{" +
                "MSRDT='" + MSRDT + '\'' +
                ", MSRCLS_CD='" + MSRCLS_CD + '\'' +
                ", MSRSTE_NM='" + MSRSTE_NM + '\'' +
                ", PM10=" + PM10 +
                ", O3=" + O3 +
                ", NO2=" + NO2 +
                ", CO=" + CO +
                ", SO2=" + SO2 +
                ", PM25=" + PM25 +
                '}';
    }
}
