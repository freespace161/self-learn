/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.designpattern.observer;

import com.freetest.designpattern.observer.listener.impl.CacheObserver;
import com.freetest.designpattern.observer.subject.impl.MySubject;

/**
 * 类TestObserver.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年11月5日 下午2:56:06
 */
public class TestObserver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MySubject subject = new MySubject();
        subject.register(new CacheObserver());
        subject.update();
    }

}
