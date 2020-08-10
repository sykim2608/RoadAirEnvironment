package com.ntels.sykim.RoadAirEnvironment.service;

/**
 * 도로변 대기 환경 조회
 * @author sykim@ntels.com
 */
public interface RequestService {
    /**
     * 모든 측정소 대기 환경 요청 처리
     * @throws Exception
     */
    void getAllStatus() throws Exception;

    /**
     * 특정 측정소 대기 환경 요청 처리
     * @throws Exception
     */
    void getOneStatus() throws Exception;
}
