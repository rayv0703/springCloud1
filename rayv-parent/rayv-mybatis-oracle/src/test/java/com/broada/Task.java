package com.broada;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Task {
    private static Random r = new Random();

    @Async
    public void doTaskone() throws InterruptedException {
        System.out.println("开始做任务一...");
        long start = System.currentTimeMillis();
        Thread.sleep(r.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务一耗时: "+(end-start)+"毫秒");
    }
    @Async
    public void doTasktwo() throws InterruptedException {
        System.out.println("开始做任务二...");
        long start = System.currentTimeMillis();
        Thread.sleep(r.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务二耗时: "+(end-start)+"毫秒");
    }
    @Async
    public void doTaskthree() throws InterruptedException {
        System.out.println("开始做任务三...");
        long start = System.currentTimeMillis();
        Thread.sleep(r.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("任务三耗时: "+(end-start)+"毫秒");
    }

}
