package com.ntels.sykim.RoadAirEnvironment.controller;

import com.ntels.sykim.RoadAirEnvironment.dao.RoadMapper;
import com.ntels.sykim.RoadAirEnvironment.model.RoadStatus;
import com.ntels.sykim.RoadAirEnvironment.model.SearchParam;
import com.ntels.sykim.RoadAirEnvironment.model.SelectedName;
import com.ntels.sykim.RoadAirEnvironment.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 도로 대기 환경 관련 Ajax 처리 Controller
 * @author sykim@ntels.com
 */
@Controller
public class RoadController {
    /**
     * Request Service
     */
    @Autowired
    RequestService requestService;

    /**
     * Road Mapper
     */
    @Autowired
    RoadMapper roadMapper;

    /**
     * 도로변 구분 선택에 따른 Ajax 요청 처리
     * @param model
     * @param selectRoad 선택한 도로변 구분명
     * @return datapage.jsp
     */
    @RequestMapping(value = "/changeRoad", method = RequestMethod.GET)
    public String changeRoad(Model model, String selectRoad) {
        SelectedName.selected = selectRoad;
        model.addAttribute("Road", SelectedName.selected);
        return "datapage";
    }

    /**
     * 측정소 선택에 따른 Ajax 요청 처리
     * @param model
     * @param selectMeasure 선택한 측정소 명
     * @return datapage.jsp
     */
    @RequestMapping(value = "/changeMeasure", method = RequestMethod.GET)
    public String changeMeasure(Model model, String selectMeasure) {
        SelectedName.measureStation = selectMeasure;
        model.addAttribute("Measure", SelectedName.measureStation);
        return "datapage";
    }

    /**
     * 도로변 및 측정소에 따른 대기 환경 수치 Ajax 요청 처리
     * @return 대기 환경 수치 모델
     * @throws Exception
     */
    @RequestMapping(value = "/searchEnvironment", method = RequestMethod.POST)
    public @ResponseBody RoadStatus searchEnv() throws Exception {
        requestService.getOneStatus();
        SearchParam searchParam = new SearchParam();
        searchParam.setRoadCategory(SelectedName.selected);
        searchParam.setRoadStatus(SelectedName.measureStation);

        System.out.println("status: " + roadMapper.getEnvironment(searchParam));

        return roadMapper.getEnvironment(searchParam);
    }

}
