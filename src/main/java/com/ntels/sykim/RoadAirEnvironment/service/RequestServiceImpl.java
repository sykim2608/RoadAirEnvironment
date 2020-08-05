package com.ntels.sykim.RoadAirEnvironment.service;

import com.google.gson.Gson;
import com.ntels.sykim.RoadAirEnvironment.dao.RoadMapper;
import com.ntels.sykim.RoadAirEnvironment.model.ApiResponse;
import com.ntels.sykim.RoadAirEnvironment.model.RoadCategory;
import com.ntels.sykim.RoadAirEnvironment.model.road.Row;
import com.ntels.sykim.RoadAirEnvironment.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    /**
     * Http Util
     */
    @Autowired
    HttpUtil httpUtil;

    /**
     * Road Mapper
     */
    @Autowired
    RoadMapper roadMapper;

    /**
     * 도로변 및 측정소 카테고리 저장
     * @throws Exception
     */
    @Override
    public void getAllStatus() throws Exception {
        Gson gson = new Gson();
        String str = httpUtil.requestApiAll();
        RoadCategory roadCategory = new RoadCategory();

        List<Row> list = gson.fromJson(str, ApiResponse.class).getRealtimeRoadsideStation().getRow();

        for(int i=0;i<list.size();i++) {
            roadCategory.setCategory(list.get(i).getMSRCLS_CD());
            roadCategory.setName(list.get(i).getMSRSTE_NM());
            roadMapper.addCategory(roadCategory);
        }
    }
}
