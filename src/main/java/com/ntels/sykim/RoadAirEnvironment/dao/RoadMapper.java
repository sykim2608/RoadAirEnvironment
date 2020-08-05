package com.ntels.sykim.RoadAirEnvironment.dao;

import com.ntels.sykim.RoadAirEnvironment.model.RoadCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


/**
 * Mybatis Mapper 인터페이스
 * @author sykim@ntels.com
 */
@Mapper
@Repository
public interface RoadMapper {
    List getCategory() throws Exception;

    List getRoadName(String category) throws Exception;

    void addCategory(RoadCategory roadCategory) throws Exception;
}
