/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.framework.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 类ThriftClientTest.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年9月9日 下午9:11:11
 */
public class ThriftClientTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TTransport transport = new TSocket("127.0.0.1", 8888);

        TProtocol protocol = new TCompactProtocol(transport);

        TestService.Client client = new TestService.Client(protocol);
        try {
            transport.open();

            String response = client.doRequest("nihao...hello");

            System.out.println(response);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
