package com.broada;

import com.broada.three.data.domain.Dept;
import com.broada.three.data.domain.Student;
import com.broada.three.data.mapper.DeptnoMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.Name;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

public class Test01 {


    @Test
    public void test01(){
        Map<Integer,String> map=new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.putIfAbsent(i,"val"+i);
        }
        map.forEach((key,value)-> System.out.println(value));
    }
    @Test
    public void test02(){
        int max = NumberUtils.max(1, 2, 3, 4, 56, 7, 99);
        System.out.println(max);
        int num = StringUtils.countMatches("周磊磊磊", "磊");
        System.out.println(num);
    }
    @Test
    public void test03() throws JsonProcessingException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = sdf.parse("2010-01-02 12:00:00");
        Student stu = new Student("张三啊12312321", date, 100.111111);
        System.out.println(new ObjectMapper().writeValueAsString(stu));

        ArrayList<String> strList = new ArrayList<>(10);
        strList.add("一一一");
        strList.add("二二二");
        strList.add(1,"三三三");
        int[] arr = {1, 2, 3, 4};
        int[] nums = Arrays.copyOf(arr, 4);
        Arrays.stream(nums).forEach(a-> System.out.println(a));
        strList.stream().limit(2l).forEach(b-> System.out.println(b));
    }
    @Test
    public void test04(){
        BigDecimal a = new BigDecimal(20);
        BigDecimal b = new BigDecimal(3);
        System.out.println("a/b ="+a.divide(b));
    }
    @Test
    public void test05(){
        String[] strArr = {"张三","李四","王五","赵六","张三小刘"};
        List<String> strList = Arrays.asList(strArr);
        for (String str : strList) {
            System.out.println(str);
        }
        System.out.println("================lambda表达式forEach");
        //lambda表达式forEach
        strList.forEach(str->{
            System.out.println(str);
        });
        System.out.println("================lambda表达式forEach");
        strList.forEach(System.out::println);
        System.out.println("================lambda表达式forEach");
        strList.stream().sorted((String o1,String o2)->o2.compareTo(o1)).forEach(str -> System.out.println(str));
        Predicate<String> p1= (n) -> n.startsWith("张");
        Predicate<String> p2 = (n) ->n.length() == 4;
        System.out.println("================lambda表达式last===========>>>");
        strList.stream().filter(p1.and(p2)).forEach(name-> System.out.println(name));
    }
    @Test
    public void test06(){
        List<Integer> nums = Arrays.asList(100, 200, 300, 400, 500, 600);
        //nums.stream().map(num ->num + .12*num).forEach(num -> System.out.println(num));
        IntSummaryStatistics statistics = nums.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("sum: "+statistics.getSum());
        System.out.println("count: "+statistics.getCount());
        System.out.println("avg: "+statistics.getAverage());
        System.out.println("min: "+statistics.getMin());
    }
@Test
    public void test07(){
     int[] arr = {1,2,3,4,5};
    Arrays.stream(arr);
}
}
