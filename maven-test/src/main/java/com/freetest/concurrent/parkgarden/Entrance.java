/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.parkgarden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 类Entrance.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月14日 下午3:45:12
 */
public class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> list = new ArrayList<Entrance>();

    private String entranceId;
    private volatile static boolean stop = false;

    public Entrance(String id) {
        entranceId = id;
        list.add(this);
    }

    public String toString() {
        return "#" + entranceId;
    }

    @Override
    public void run() {
        while (!stop) {
            // try {
            // TimeUnit.MILLISECONDS.sleep(20);
            // } catch (InterruptedException e) {
            // e.printStackTrace();
            // }
            System.out.println(this + " total : " + count.increment());
        }
    }

    public static void cancel() {
        stop = true;
    }

    public static int getTotal() {
        return count.getCount();
    }
}
