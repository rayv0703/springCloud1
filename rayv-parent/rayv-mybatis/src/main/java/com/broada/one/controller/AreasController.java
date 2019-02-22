package com.broada.one.controller;

import com.broada.one.service.AreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api("区域信息查询")
@RequestMapping("/area")
public class AreasController {

    @Autowired
    private AreaService areaService;

    @ApiOperation(value = "省市区",notes = "省市区联动")
    @RequestMapping(value = "/one/getAreaInfo",method = RequestMethod.GET)
    public Map<String,String> getAreaInfo(){



        Map<String,String> map = areaService.getAreaInfo();
        return map;
    }
}
