package com.nero.main.java.algrorithm.Sorting_Advance.Quick_Sort_Three_Ways;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;
import com.nero.main.java.algrorithm.Sorting_Advance.Merge_Sort_Advance.InsertionSort;

public class QuickSort3Ways {

    // 遞歸使用快速排序,對arr[l...r]的範圍進行排序
    private static void sort(Comparable[] arr, int l, int r){

        // 對於小規模數組, 使用插入排序
        if( r - l <= 15 ){
            InsertionSort.sort(arr, l, r);
            return;
        }

        // 隨機在arr[l...r]的範圍中, 選擇一個數值作為標定點pivot
        swap( arr, l, (int)(Math.random()*(r-l+1)) + l );

        Comparable v = arr[l];

        int lt = l;     // arr[l+1...lt] < v
        int gt = r + 1; // arr[gt...r] > v
        int i = l+1;    // arr[lt+1...i) == v
        while( i < gt ){
            if( arr[i].compareTo(v) < 0 ){
                swap( arr, i, lt+1);
                i ++;
                lt ++;
            }
            else if( arr[i].compareTo(v) > 0 ){
                swap( arr, i, gt-1);
                gt --;
            }
            else{ // arr[i] == v
                i ++;
            }
        }

        swap( arr, l, lt );

        sort(arr, l, lt-1);
        sort(arr, gt, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 測試 QuickSort3Ways
    public static void main(String[] args) {
        // 三路快速排序算法也是一個O(nlogn)複雜度的算法
        // 可以在1秒之內輕鬆處理100萬數量級的數據
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.nero.main.java.algrorithm.Sorting_Advance.Quick_Sort_Three_Ways.QuickSort3Ways", arr);
    }
}