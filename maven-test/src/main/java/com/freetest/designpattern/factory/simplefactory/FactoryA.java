/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.designpattern.factory.simplefactory;

/**
 * 类FactoryA.java的实现描述：TODO 类实现描述 
 * @author free 2015年11月9日 下午3:26:23
 */
public class FactoryA implements ServiceFactory {

    @Override
    public Service getService() {
         
        return new ServiceA();
    }

}
