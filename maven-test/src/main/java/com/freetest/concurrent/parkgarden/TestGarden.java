/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.parkgarden;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 类TestGarden.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月14日 下午3:55:41
 */
public class TestGarden {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance("entrance " + i));
        }
        exec.shutdown();
        Entrance.cancel();
        exec.awaitTermination(250, TimeUnit.MILLISECONDS);
        System.out.println(" total:" + Entrance.getTotal());
    }
}
