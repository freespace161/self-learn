/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.algorithm.find.anumbermorethanhalf;

/**
 * 类FindTheNumber.java的实现描述： 某个数在指定数组中出现次数大于数组大小的一半，找出这个数
 * 
 * @author free 2015年10月10日 下午3:46:11
 */
public class FindTheNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a[] = new int[] { 8, 8, 3, 3, 2, 3, 5, 3, 3, 3, 4, 3 };

        System.out.println(findTheNum(a));
    }

    public static int findTheNum(int a[]) {
        int nTimes = 0;
        int i = 0;
        // 假设-1 是一个不存在的数字,因为java必须初使化
        int candidate = -1;
        while (i < a.length) {
            if (nTimes == 0) {
                candidate = a[i];
                i++;
            } else {
                if (candidate == a[i]) {
                    nTimes++;
                    i++;
                } else {
                    nTimes--;
                }
            }
        }
        return candidate;
    }
}
