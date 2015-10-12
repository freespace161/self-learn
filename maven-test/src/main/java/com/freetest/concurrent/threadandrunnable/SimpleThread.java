/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.threadandrunnable;

/**
 * 类SimpleThread.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月12日 上午11:42:42
 */
public class SimpleThread extends Thread {
    private int countDown = 5;

    public SimpleThread() {
        start();
    }

    public String toString() {
        return Thread.currentThread().getName() + ":" + countDown;
    }

    public void run() {
        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SimpleThread();
        }
    }
}
