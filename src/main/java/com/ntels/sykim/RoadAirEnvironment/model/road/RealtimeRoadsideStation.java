package com.ntels.sykim.RoadAirEnvironment.model.road;

import java.util.List;

/**
 * RealtimeRoadsideStation 모델
 * @author sykim@ntels.com
 */
public class RealtimeRoadsideStation {
    /**
     * 총 데이터 건수
     */
    private int list_total_count;
    /**
     * 요청 결과
     */
    private Result RESULT;
    /**
     * 대기환경 데이터
     */
    private List<Row> row;

    public int getList_total_count() {
        return list_total_count;
    }

    public void setList_total_count(int list_total_count) {
        this.list_total_count = list_total_count;
    }

    public Result getRESULT() {
        return RESULT;
    }

    public void setRESULT(Result RESULT) {
        this.RESULT = RESULT;
    }

    public List<Row> getRow() {
        return row;
    }

    public void setRow(List<Row> row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "RealtimeRoadsideStation{" +
                "list_total_count=" + list_total_count +
                ", RESULT=" + RESULT +
                ", row=" + row +
                '}';
    }
}
