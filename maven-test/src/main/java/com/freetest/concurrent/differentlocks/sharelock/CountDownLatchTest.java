/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.differentlocks.sharelock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 类CountDownLatchTest.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月19日 下午4:18:11
 */
public class CountDownLatchTest {

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);// 两个工人的协作
        Worker worker1 = new Worker("zhang san", 5000, latch);
        Worker worker2 = new Worker("li si", 8000, latch);
        worker1.start();//
        worker2.start();//
        latch.await();// 等待所有工人完成工作
        System.out.println("all work done at " + sdf.format(new Date()));
    }

    static class Worker extends Thread {
        String workerName;
        int workTime;
        CountDownLatch latch;

        public Worker(String workerName, int workTime, CountDownLatch latch) {
            this.workerName = workerName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run() {
            System.out.println("Worker " + workerName + " do work begin at " + sdf.format(new Date()));
            doWork();// 工作了
            System.out.println("Worker " + workerName + " do work complete at " + sdf.format(new Date()));
            latch.countDown();// 工人完成工作，计数器减一

        }

        private void doWork() {
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
