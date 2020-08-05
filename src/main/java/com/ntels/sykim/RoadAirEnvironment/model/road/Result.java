package com.ntels.sykim.RoadAirEnvironment.model.road;

/**
 * 요청 결고 메시지 모델
 * @author sykim@ntels.com
 */
public class Result {
    /**
     * 요청 결콰 코드
     */
    private String CODE;
    /**
     * 요청 결과 메시지
     */
    private String MESSAGE;

    public String getCODE() {
        return CODE;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    @Override
    public String toString() {
        return "Result{" +
                "CODE='" + CODE + '\'' +
                ", MESSAGE='" + MESSAGE + '\'' +
                '}';
    }
}
