package com.ntels.sykim.RoadAirEnvironment.util;

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
     * 모든 측정소에 대한 데이터 요청
     * @return 모든 측정소 내 대기환경 응답 정보
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
     * 선택된 측정소에 대한 데이터 요청
     * @param roadName 조회할 측정소 명
     * @return 사용자 지정 측정소 내 대기환경 응답 정보
     */
    public String requestApiOne(String roadName) {
        String url = "http://openAPI.seoul.go.kr:8088/73416874526b7379353661776a5369/json/RealtimeRoadsideStation/1/25/";
        String link;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        link = new StringBuilder(url).append(roadName).toString();

        ResponseEntity<String> responseEntity = restTemplate.exchange(link, HttpMethod.GET, entity, String.class);

        return responseEntity.getBody();

    }
}
