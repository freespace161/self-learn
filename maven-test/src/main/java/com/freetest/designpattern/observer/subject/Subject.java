/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.designpattern.observer.subject;

import com.freetest.designpattern.observer.listener.Observer;

/**
 * 类Subject.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年11月4日 下午8:02:29
 */
public interface Subject {
    void register(Observer obj);

    void unregister(Observer obj);

    void publishEvent(Object event);

}
