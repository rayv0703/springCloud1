package com.broada;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RayvMybatisApplicationTests {
	String strDt = "2010-10-1";
	String endDt ="2018-10-1";
	@Test
	public void contextLoads() {
		System.out.println(strDt.compareTo(endDt));
	}

}

