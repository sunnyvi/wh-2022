package com.serviceapp.myutils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestRequest {


    private static RestTemplate client = new RestTemplate();

    public static String restfulGetUtils(String url) throws JSONException {
        ResponseEntity result = client.getForEntity(url, String.class);
        return result.getBody().toString();
    }


    public static String restfulPostUtils(String url, JSONObject json) throws JSONException {
        HttpEntity<String> formEntity = getHttpEntity(json);
        String res = client.postForEntity(url, formEntity, String.class).getBody();
        return res;
    }

    public static String restfulPostUtils(String url, String json) throws JSONException {
        HttpEntity<String> formEntity = getHttpEntity(json);
        String res = client.postForEntity(url, formEntity, String.class).getBody();
        return res;
    }

    public static String restfulPutUtils(String url, JSONObject json) throws JSONException {
        HttpEntity<String> formEntity = getHttpEntity(json);
        String res = client.exchange(url, HttpMethod.PUT, formEntity, String.class).getBody();
        return res;
    }

    public static String restfulDeleteUtils(String url) throws JSONException {
        //HttpEntity<String> formEntity = getHttpEntity(json);
        String res = client.exchange(url, HttpMethod.DELETE, null, String.class).getBody();
        return res;

    }

    public static String restfulRequest(String url, JSONObject json, HttpMethod httpMethod) {
        HttpEntity<String> formEntity = getHttpEntity(json);
        String res = client.exchange(url, httpMethod, formEntity, String.class).getBody();
        return res;
    }

    public static HttpEntity<String> getHttpEntity(JSONObject json) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return new HttpEntity<String>(json.toString(), headers);
    }

    //TODO 所有接口的传参改为json String，不要以JSONObject
    public static HttpEntity<String> getHttpEntity(String json) {
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        return new HttpEntity<String>(json.toString(), headers);
    }
}
