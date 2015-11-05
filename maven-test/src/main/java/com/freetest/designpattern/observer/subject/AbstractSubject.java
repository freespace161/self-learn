/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.designpattern.observer.subject;

import java.util.ArrayList;
import java.util.List;

import com.freetest.designpattern.observer.listener.Observer;

/**
 * 类AbstractSubject.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年11月4日 下午8:04:29
 */
public abstract class AbstractSubject implements Subject {
    protected List<Observer> list = new ArrayList<Observer>();

    @Override
    public void register(Observer obj) {
        list.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        list.remove(obj);
    }

    @Override
    public void publishEvent(Object event) {
        for (Observer obj : list) {
            obj.onEvent(event);
        }
    }

}
