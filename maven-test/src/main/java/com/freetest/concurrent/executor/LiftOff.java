/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.executor;

/**
 * 类Task.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月10日 下午1:44:23
 */
public class LiftOff implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ") ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            // yield 与sleep都不释放锁
            // yield 释放cpu 直接进入就绪状态,等线程调度器调度重新进入运行状态
            // Thread.yield();
            try {
                // sleep 释放cpu 进入->blocked 状态，blocked 状态结束后进入->就绪状态
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}