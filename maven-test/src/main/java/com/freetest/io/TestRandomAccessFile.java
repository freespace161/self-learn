/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 类TestRandomAccessFile.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年9月22日 下午8:05:58
 */
public class TestRandomAccessFile {

    /**
     * @param args
     */
    public static void main(String[] args) {

        try {
            RandomAccessFile raf =
                    new RandomAccessFile(TestRandomAccessFile.class.getResource("/com/freetest/io/randaccessfile")
                            .getPath(), "r");
            String line = "";

            while ((line = raf.readLine()) != null) {

                System.out.println(line);
                // raf.skipBytes(line.length() / 2);
            }
            raf.close();
            // FileChannel chanel = raf.getChannel();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
