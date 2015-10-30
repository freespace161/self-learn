/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.algorithm.sort;

/**
 * 类InsertSort.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年10月30日 上午10:23:02
 */
public class InsertSort {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int a[] = new int[] { 4, 5, 1, 3, 7, 8, 20, 6 };
        insertSort(a, a.length);
        for (int t : a) {
            System.out.println(t);
        }
    }

    public static void insertSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int key = a[i + 1];
            int j = i;
            for (; j >= 0; j--) {
                if (key < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = key;
        }
    }
}
