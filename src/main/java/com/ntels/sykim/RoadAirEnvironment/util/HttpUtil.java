package com.ntels.sykim.RoadAirEnvironment.util;

import com.ntels.sykim.RoadAirEnvironment.model.SelectedName;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Http Api 요청
 * @author sykim@ntels.com
 */
@Component
public class HttpUtil {
    /**
     * 모든 측정소에 대한 대기 환경 API 요청
     * @return 모든 측정소에 대한 API 응답
     */
    public String requestApiAll() {
        String url = "http://openAPI.seoul.go.kr:8088/73416874526b7379353661776a5369/json/RealtimeRoadsideStation/1/25";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return responseEntity.getBody();
    }

    /**
     * 선택한 측정소에 대한 대기 환경 API 요청
     * @return 선택한 측정소에 대한 API 응답
     */
    public String requestApiOne() {
        String url = "http://openAPI.seoul.go.kr:8088/73416874526b7379353661776a5369/json/RealtimeRoadsideStation/1/25/";
        String link;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        link = new StringBuilder(url).append(SelectedName.selected).append("/").append(SelectedName.measureStation).toString();

        System.out.println("link: " + link);

        ResponseEntity<String> responseEntity = restTemplate.exchange(link, HttpMethod.GET, entity, String.class);

        return responseEntity.getBody();

    }
}
