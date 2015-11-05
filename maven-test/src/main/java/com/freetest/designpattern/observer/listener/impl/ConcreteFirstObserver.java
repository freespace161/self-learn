/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.designpattern.observer.listener.impl;

import com.freetest.designpattern.observer.listener.Observer;

/**
 * 类ConcreteFirstObserver.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年11月4日 下午8:00:39
 */
public class ConcreteFirstObserver implements Observer {

    @Override
    public void onEvent(Object data) {
        System.out.println(data);
    }

}
