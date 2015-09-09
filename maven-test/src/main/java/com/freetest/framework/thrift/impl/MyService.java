/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.framework.thrift.impl;

import org.apache.thrift.TException;

import com.freetest.framework.thrift.TestService.Iface;

/**
 * 类MyService.java的实现描述：TODO 类实现描述
 * 
 * @author wangjinyuan 2015年9月9日 下午8:58:00
 */
public class MyService implements Iface {

    public String doRequest(String req) throws TException {

        return "get .." + req;
    }

}
