/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.threadandrunnable;

/**
 * 类SelfManage.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月12日 上午11:49:19
 */
public class SelfManage implements Runnable {

    private Thread t = new Thread(this);
    private int countDown = 5;

    public SelfManage() {
        t.start();
    }

    @Override
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
            new SelfManage();
        }
    }

}
