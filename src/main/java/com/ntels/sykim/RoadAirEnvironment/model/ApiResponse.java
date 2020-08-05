package com.ntels.sykim.RoadAirEnvironment.model;

import com.ntels.sykim.RoadAirEnvironment.model.road.RealtimeRoadsideStation;

/**
 * API 요청에 따른 메시지 응답 모델
 * @author sykim@ntels.com
 */
public class ApiResponse {
    /**
     * RealtimeRoadsideStation
     */
    private RealtimeRoadsideStation RealtimeRoadsideStation;

    public com.ntels.sykim.RoadAirEnvironment.model.road.RealtimeRoadsideStation getRealtimeRoadsideStation() {
        return RealtimeRoadsideStation;
    }

    public void setRealtimeRoadsideStation(com.ntels.sykim.RoadAirEnvironment.model.road.RealtimeRoadsideStation realtimeRoadsideStation) {
        RealtimeRoadsideStation = realtimeRoadsideStation;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "RealtimeRoadsideStation=" + RealtimeRoadsideStation +
                '}';
    }
}
