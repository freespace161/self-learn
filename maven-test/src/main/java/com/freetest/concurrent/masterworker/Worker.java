/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.concurrent.masterworker;

import java.util.Map;
import java.util.Queue;

/**
 * 类Worker.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月15日 下午6:15:44
 */
public class Worker implements Runnable {

    // 任务队列，用于取得子任务
    protected Queue<Object> workQueue;
    // 子任务处理结果集
    protected Map<String, Object> resultMap;

    public void setWorkQueue(Queue<Object> workQueue) {
        this.workQueue = workQueue;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    // 子任务处理的逻辑，在子类中实现具体逻辑
    public Object handle(Object input) {
        return input;
    }

    @Override
    public void run() {

        while (true) {
            // 获取子任务
            Object input = workQueue.poll();
            if (input == null) {
                break;
            }
            // 处理子任务
            Object re = handle(input);
            resultMap.put(Integer.toString(input.hashCode()), re);
        }
    }

}