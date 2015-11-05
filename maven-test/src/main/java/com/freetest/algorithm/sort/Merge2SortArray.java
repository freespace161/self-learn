/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.algorithm.sort;

/**
 * 类Merge2SortArray.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年11月5日 上午10:24:44
 */
public class Merge2SortArray {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int a[] = new int[] { 8, 10, 15, 19, 20, 28 };
        int b[] = new int[] { 7, 9, 13, 14, 16 };

        int merge[] = mergeArray(a, b, a.length, b.length);
        for (int t : merge) {
            System.out.println(t);
        }
    }

    public static int[] mergeArray(int A[], int B[], int n, int m) {
        int tmp[] = new int[n + m];
        int i = n - 1;
        int j = m - 1;
        int k = n + m - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                tmp[k--] = A[i--];
            } else {
                tmp[k--] = B[j--];
            }
        }

        while (i >= 0) {
            tmp[k--] = A[i--];
        }
        while (j >= 0) {
            tmp[k--] = B[j--];
        }
        return tmp;
    }
}
