package com.ntels.sykim.RoadAirEnvironment.dao;

import com.ntels.sykim.RoadAirEnvironment.model.RoadCategory;
import com.ntels.sykim.RoadAirEnvironment.model.RoadStatus;
import com.ntels.sykim.RoadAirEnvironment.model.SearchParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Mybatis Mapper 인터페이스
 * @author sykim@ntels.com
 */
@Mapper
@Repository
public interface RoadMapper {
    /**
     * 모든 도로변 구분명 조회
     * @return 도로변 명
     * @throws Exception
     */
    List getCategory() throws Exception;

    /**
     * 모든 측정소명 조회
     * @param category 도로변 명
     * @return 측정소 명
     * @throws Exception
     */
    List getRoadName(String category) throws Exception;

    /**
     * 도로변 구분명 추가
     * @param roadCategory 추가할 도로변 구분명
     * @throws Exception
     */
    void addCategory(RoadCategory roadCategory) throws Exception;

    /**
     * 측정소명 추가
     * @param roadStatus 축할 측정소 명
     * @throws Exception
     */
    void addStatus(RoadStatus roadStatus) throws Exception;

    /**
     * 대기환경 수치 조회
     * @param searchParam 조회할 도로변 및 측정소 명
     * @return 대기환경 수치 정보
     * @throws Exception
     */
    RoadStatus getEnvironment(SearchParam searchParam) throws Exception;
}
