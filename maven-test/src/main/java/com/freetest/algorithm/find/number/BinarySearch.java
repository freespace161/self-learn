/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.algorithm.find.number;

/**
 * 类BinarySearch.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年9月10日 下午5:45:03
 */
public class BinarySearch {

    public static void main(String[] args) {
        int a[] = new int[] { 10, 18, 19, 30, 70 };
        System.out.println(search(70, a));
        System.out.println(search(20, a));
    }

    /**
     * 
     * @param key 待查找key
     * @param a 数组
     * @return index
     */
    static int search(int key, int a[]) {
        int end = a.length - 1;
        int start = 0;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (key < a[mid]) {
                end = mid - 1;
            } else if (key > a[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -start;
    }
}
