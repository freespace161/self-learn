/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.io.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

/**
 * 类PortTest.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年11月5日 下午4:16:07
 */
public class PortTest {
    public static void main(String[] args) throws IOException {

        System.out.println(selectFreePort());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }

    private static int selectFreePort() throws IOException {
        ServerSocket serverSocket = new ServerSocket(0);
        int port = serverSocket.getLocalPort();
        serverSocket.close();
        return port;
    }
}
