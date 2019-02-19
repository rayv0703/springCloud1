package com.broada;


import com.broada.one.data.vo.request.A001IM01_RequestVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestMain {


    public static void main(String[] args) throws JsonProcessingException {
        A001IM01_RequestVo requestVo = new A001IM01_RequestVo();
        requestVo.setSname("zhangsan");
        requestVo.setConsphone("18672331800");
        requestVo.setAddress("上海市");
        System.out.println(new ObjectMapper().writeValueAsString(requestVo));
    }
}
