package com.broada;

import com.broada.springboot.RayvMybatisOracleApplication;
import com.broada.three.data.domain.Dept;
import com.broada.three.data.mapper.DeptnoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RayvMybatisOracleApplication.class)
@Slf4j
public class ApplicationTests {

    private  final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);



    @Autowired
    private Task task;
    @Test
    public void testLog(){
        logger.info("information");
        logger.error("error");
        logger.debug("debug");
    }

    @Test
    public void test() throws Exception {
        task.doTaskone();
        task.doTasktwo();
        task.doTaskthree();
    }

    @Autowired
    DeptnoMapper mapper;
    @Test
    public void test07(){
        Dept dept = mapper.findByDeptno(10);
        System.out.println(dept.getDname());
    }
}
