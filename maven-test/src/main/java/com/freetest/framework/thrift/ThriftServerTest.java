/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.framework.thrift;

import java.net.InetSocketAddress;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.THsHaServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

import com.freetest.framework.thrift.TestService.Iface;
import com.freetest.framework.thrift.impl.MyService;

/**
 * 类ThriftServierTest.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年9月9日 下午8:55:54
 */
public class ThriftServerTest {

    public static void main(String[] args) {
        TestService.Processor<Iface> processor = new TestService.Processor<Iface>(new MyService());
        try {
            TServerTransport transport = new TServerSocket(new InetSocketAddress("127.0.0.1", 8888));
            
            
            TThreadPoolServer.Args svrArgs = new TThreadPoolServer.Args(transport); // thread pool args
            svrArgs.processor(processor);

            TProtocolFactory factory = new TCompactProtocol.Factory(); // 使用compact
            svrArgs.protocolFactory(factory);

            // server
            TServer server = new TThreadPoolServer(svrArgs);
            server.serve();// server start
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
}
