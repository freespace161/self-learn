/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.masterworker;

/**
 * 类PlusWorker.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月15日 下午6:16:20
 */
public class PlusWorker extends Worker {

    @Override
    public Object handle(Object input) {

        Integer i = (Integer) input;
        return i * i * i;
    }

}