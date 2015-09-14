/*
 * Copyright baidu.com All right reserved. This software is the
 * confidential and proprietary information of baidu.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with baidu.com.
 */
package com.freetest.algorithm.sort;

/**
 * 类HeapSort.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年9月10日 下午8:03:42
 */
public class HeapSort {

    public static void main(String[] args) {
        int a[] = new int[] { 0, 8, 10, 3, 7, 23, 20 };

        // heapAdjust(a, 3, 6);
        heapSort(a, 6);
        for (int tmp : a) {
            System.out.print(tmp + "\t");
        }

    }

    static void heapSort(int a[], int n) {
        buildMaxHeap(a, n);
        for (int i = n; i >= 1; i--) {
            swap(a, 1, i);
            heapAdjust(a, 1, i - 1);
        }
    }

    /**
     * 建 堆
     * 
     * @param a
     * @param n
     */
    static void buildMaxHeap(int a[], int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapAdjust(a, i, n);
        }
    }

    /**
     * 堆调整，自下而上
     * 
     * @param a数组
     * @param p 父结点
     * @param n 元数个数
     */
    static void heapAdjust(int a[], int p, int n) {
        int tmp = a[p];
        for (int left = 2 * p; left <= n; left *= 2) {
            if (left < n && a[left] < a[left + 1]) {
                left++; // 记录最大的下标
            }
            if (tmp >= a[left]) {
                break;
            }
            a[p] = a[left]; // 大数向上移
            p = left; // 下标往下继续找
        }
        a[p] = tmp; // 最大的给父结点
    }

    static void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
