package com.ntels.sykim.RoadAirEnvironment.controller;

import com.ntels.sykim.RoadAirEnvironment.dao.RoadMapper;
import com.ntels.sykim.RoadAirEnvironment.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;

/**
 * Index Controller
 * @author sykim@ntels.com
 */
@Controller
public class IndexController {
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
     * 시작 페이지 출력
     * @return datapage.jsp
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) throws Exception {
        //requestService.getAllStatus();

        List<String> categoryList = roadMapper.getCategory();
        HashMap<String, String> map = new HashMap<>();

        for(int i=0;i<categoryList.size();i++) {
           // map.put(categoryList.get(i), roadMapper.getRoadName(categoryList.get(i)).toString());
        }

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("nameMap", map);

        System.out.println(map.toString());
        return "datapage";
    }
}
