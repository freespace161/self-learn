/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.parkgarden;

/**
 * 类Count.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月14日 下午3:43:03
 */
public class Count {
    private int count;

    public synchronized int increment() {
        int tmp = count;
        return count = ++tmp;
    }

    public int getCount() {
        return count;
    }
}
