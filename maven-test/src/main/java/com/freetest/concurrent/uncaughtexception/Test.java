/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.uncaughtexception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 类Test.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月12日 下午1:16:01
 */
public class Test {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }

}
