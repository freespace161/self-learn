/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类TestExecutor.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月10日 下午1:42:10
 */
public class TestExecutor {
    public static void main(String[] args) {
        //
        // 1.cachedthreadpool所有的线程会马上调度起来
        // 2.FixedThredPool是指定同时运行的线程数，其余的放入队列，
        // 3.singleThreadExecutor同时运行的线程只有一个，其余的放入队列，按队列的顺序调度
        ExecutorService exec = Executors.newCachedThreadPool();
        // ExecutorService exec = Executors.newFixedThreadPool(2);
        // ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
