/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类TestNormal.java的实现描述：常用集合测试
 * 
 * @author free 2015年10月14日 下午2:45:12
 */
public class TestNormal {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // #1. 把Array转化成ArrayList--Arrays.asList() 实际上返回一个ArrayList，ArrayList是Arrays的一个内部私有类

        int[] a = new int[] { 123, 23, 25, 25 };
        List<Integer> list = new ArrayList(Arrays.asList(a));

        // #2.检查数组是否包含一个值 或是
        System.out.println(Arrays.asList(a).contains(23));
    }
}
