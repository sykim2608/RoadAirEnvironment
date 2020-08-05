package com.ntels.sykim.RoadAirEnvironment.service;

import com.ntels.sykim.RoadAirEnvironment.model.road.Row;
import java.util.List;

/**
 * 도로변 대기 환경 조회
 * @author sykim@ntels.com
 */
public interface RequestService {
    /**
     * 모든 도로변 대기 환경 조회
     * @return 도로별 대기 환경 수치
     */
    void getAllStatus() throws Exception;
}
