package com.ntels.sykim.RoadAirEnvironment.service;

import com.google.gson.Gson;
import com.ntels.sykim.RoadAirEnvironment.dao.RoadMapper;
import com.ntels.sykim.RoadAirEnvironment.model.ApiResponse;
import com.ntels.sykim.RoadAirEnvironment.model.RoadCategory;
import com.ntels.sykim.RoadAirEnvironment.model.RoadStatus;
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

    @Override
    public void getOneStatus() throws Exception {
        Gson gson = new Gson();
        String str = httpUtil.requestApiOne();
        RoadStatus roadStatus = new RoadStatus();

        List<Row> list = gson.fromJson(str, ApiResponse.class).getRealtimeRoadsideStation().getRow();

        roadStatus.setCarbonMonoxide(list.get(0).getCO());
        roadStatus.setDust(list.get(0).getPM10());
        roadStatus.setNitrogenDioxide(list.get(0).getNO2());
        roadStatus.setOzone(list.get(0).getO3());
        roadStatus.setSulfurDioxide(list.get(0).getSO2());
        roadStatus.setUltrafineDust(list.get(0).getPM25());
        roadStatus.setNowDate(list.get(0).getMSRDT());
        roadStatus.setRoadName(list.get(0).getMSRSTE_NM());

        roadMapper.addStatus(roadStatus);
    }

}
