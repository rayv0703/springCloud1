package com.broada;

import com.broada.one.data.domain.Area;
import com.broada.one.data.domain.City;
import com.broada.one.data.domain.Province;
import com.broada.one.data.domain.Student;
import com.broada.one.data.mapper.StudentMapper;
import com.broada.one.data.repo.AreaRepo;
import com.broada.one.data.repo.CityRepo;
import com.broada.one.data.repo.ProvinceRepo;
import com.broada.springboot.RayvMybatisApplication;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RayvMybatisApplication.class)
public class RayvMybatisApplicationTests {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ProvinceRepo provinceRepo;
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private AreaRepo areaRepo;

    @Test
    public void contextLoads() throws InterruptedException {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        String str = redisTemplate.opsForValue().get("abc");
        System.out.println(str);

    }

    @Test
    public void test01() {
        ExecutorService pool = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10000; i++) {
            pool.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    RedisSerializer redisSerializer = new StringRedisSerializer();
                    redisTemplate.setKeySerializer(redisSerializer);
                    String str = redisTemplate.opsForValue().get("abc");
                    System.out.println(str);
                }
            }));
        }
        System.out.println("test over");
    }

    @Test
    public void test02() {
        stringRedisTemplate.opsForValue().set("zz", "zhoulei");
        String str = stringRedisTemplate.opsForValue().get("zz");
        System.out.println(str);
    }

    @Test
    public void test03() {
        stringRedisTemplate.opsForValue().set("cc", "橙子哥", 10, TimeUnit.SECONDS);
    }

    @Test
    public void test04() throws InterruptedException {
        String str = stringRedisTemplate.opsForValue().get("cc");
        for (int i = 0; i < 5; i++) {
            System.out.println(str);
            Thread.sleep(2000);
        }
    }

    @Test
    public void test05() {
        System.out.println(stringRedisTemplate.opsForValue().setIfAbsent("multi", "multi"));
        System.out.println(stringRedisTemplate.opsForValue().setIfAbsent("multi", "multi"));
    }

    @Test
    public void test06() {
        String str = stringRedisTemplate.opsForValue().get("multi");
        System.out.println(str);
    }

    @Test
    public void test07() {
        stringRedisTemplate.opsForValue().increment("incrlong", 1);
        stringRedisTemplate.opsForValue().increment("incrlong");
        System.out.println("获得值为: " + stringRedisTemplate.opsForValue().get("incrlong"));
    }

    @Test
    public void test08() {
        System.out.println(stringRedisTemplate.opsForValue().append("multi", "multi"));

    }

    @Test
    public void test09() {
        String[] ids = {"01", "02", "03"};
        List<Student> stuList = studentMapper.findByIds(ids);
        stuList.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void test10() {
        Iterable<Province> provinceIterable = provinceRepo.findAll();
        Iterator<Province> iterator = provinceIterable.iterator();
        while (iterator.hasNext()) {
            Province p = iterator.next();
            stringRedisTemplate.boundHashOps("province").put(p.getProvinceId(), p.getProvinceName());

        }
        System.out.println("province完成导入");
        Iterable<City> cityIterable = cityRepo.findAll();
        Iterator<City> cityIterator = cityIterable.iterator();
        while (cityIterator.hasNext()){
            City city = cityIterator.next();
            stringRedisTemplate.boundHashOps("city").put(city.getCityId(),city.getCityName());

        }
        System.out.println("city完成导入");
        Iterable<Area> areaIterable = areaRepo.findAll();
        Iterator<Area> areaIterator = areaIterable.iterator();
        while (areaIterator.hasNext()){
            Area area = areaIterator.next();
            stringRedisTemplate.boundHashOps("area").put(area.getAreaId(),area.getAreaName());

        }
        System.out.println("area完成导入");
    }

    @Test
    public void test11() {
        Iterable<Province> provinceIterable = provinceRepo.findAll();
        Iterator<Province> provinceIterator = provinceIterable.iterator();
        while (provinceIterator.hasNext()){
            Province province = provinceIterator.next();
            String provinceId = province.getProvinceId();
        }
    }
}

