package com.broada.one.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.broada.one.data.domain.Area;
import com.broada.one.data.domain.City;
import com.broada.one.data.domain.Province;
import com.broada.one.data.repo.AreaRepo;
import com.broada.one.data.repo.CityRepo;
import com.broada.one.data.repo.ProvinceRepo;
import com.broada.one.service.AreaService;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private ProvinceRepo provinceRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private AreaRepo areaRepo;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Map<String, String> getAreaInfo() {
        HashMap<String, String> map = new HashMap<>();
        String province = (String) redisTemplate.boundHashOps("Areas").get("province");
        String city = (String) redisTemplate.boundHashOps("Areas").get("city");
        String area = (String) redisTemplate.boundHashOps("Areas").get("area");
        if (StringUtils.isEmpty(province)) {
            List<Province> provinceList = Lists.newArrayList(provinceRepo.findAll());
            province = JSONObject.toJSONString(provinceList);
            redisTemplate.boundHashOps("Areas").put("province",province);
            System.out.println("从数据库中读数据");
        }
        if (StringUtils.isEmpty(city)) {
            List<City> cityList = Lists.newArrayList(cityRepo.findAll());
            city = JSONObject.toJSONString(cityList);
            redisTemplate.boundHashOps("Areas").put("city",city);
        }
        if (StringUtils.isEmpty(area)) {
            List<Area> areaList = Lists.newArrayList(areaRepo.findAll());
            area = JSONObject.toJSONString(areaList);
            redisTemplate.boundHashOps("Areas").put("area",area);
        }
        map.put("province", province);
        map.put("city",city);
        map.put("area",area);
        return map;
    }

}
