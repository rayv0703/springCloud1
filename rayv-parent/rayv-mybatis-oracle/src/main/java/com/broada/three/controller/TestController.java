package com.broada.three.controller;

import com.broada.three.data.vo.response.A0005Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequestMapping("/three")
@Api(value = "测试磊磊的接口", tags = "测试磊磊的接口")
public class TestController {

    @RequestMapping(value = "/test/leilei", method = RequestMethod.POST)
    @ApiOperation(value = "测试磊磊的接口", notes = "测试磊磊的接口")
    public void test( @RequestBody MultipartFile file) {
        //System.out.println(username);
        //System.out.println(password);
        String filename = file.getResource().getFilename();
        //String name = file.getName();
        System.out.println(filename);
    }
}
