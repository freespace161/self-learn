package com.freetest.algorithm.sort;

import scala.actors.threadpool.Arrays;

/**
 * 类QuickSort.java的实现描述：TODO 类实现描述
 * 
 * @author free 2015年9月8日 下午5:49:47
 */
public class QuickSort {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int a[] = new int[10];
        a[0] = 8;
        a[1] = 1;
        a[2] = 7;
        a[3] = 23;
        a[4] = 12;
        a[5] = 3;
        a[6] = 9;
        a[7] = 13;
        a[8] = 25;
        a[9] = 10;
        partition(a, 0, 9);
        for (int tmp : a) {
            System.out.print(tmp + "\t");
        }
    }

    public static void partition(int a[], int start, int end) {
        if (start < end) {
            int mid = sort(a, start, end);
            partition(a, start, mid - 1);
            partition(a, mid + 1, end);
        }

    }

    /**
     * 一趟排序 书中算法
     * 
     * @param a
     * @param start
     * @param end
     */
    public static int sort(int a[], int start, int end) {
        int key = a[end];
        while (start < end) {
            while (a[start] < key && start < end) {
                start++;
            }
            a[end--] = a[start];
            while (a[end] > key && start < end) {
                end--;
            }
            a[start++] = a[end];
        }

        int tmp = key;
        key = a[end];
        a[end] = tmp;
        return start;

    }

    public static int sort2() {

        return 0;
    }

}
