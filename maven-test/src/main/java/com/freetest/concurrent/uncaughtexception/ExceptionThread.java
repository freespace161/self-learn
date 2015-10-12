/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.uncaughtexception;

/**
 * 类ExceptionThread.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月12日 下午1:21:23
 */
public class ExceptionThread extends Thread {

    public void run() {
        throw new RuntimeException("test");
    }
}
