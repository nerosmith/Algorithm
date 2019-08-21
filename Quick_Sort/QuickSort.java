package com.nero.main.java.algorithm.Quick_Sort;

import com.nero.main.java.algorithm.SortTestHelper.SortTestHelper;
import com.nero.main.java.algorithm.SortingBasic.InsertionSort;

public class QuickSort {

    // 對arr[l...r]部分進行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]

    private static int partition(Comparable[] arr ,int l,int r){

            //隨機在arr[l...r]的範圍中, 選擇一個數值作為標定點pivot
            swap(arr,l,(int)(Math.random()*(r-l+1)+l));

            Comparable v = arr[l];
            int j = l;
            for( int i = l + 1 ; i <= r ; i ++ )
                if( arr[i].compareTo(v) < 0 ){
                        swap(arr, ++j, i);
                    }
            swap(arr, l, j);
            return j;
        }

    // 遞歸使用快速排序,對arr[l...r]的範圍進行排序
    private static void swap(Comparable[] arr ,int l,int r){
//            if (l>=r)
//                return;
            // 對於小規模數組, 使用插入排序
            if (r-1 <= 15){
                    InsertionSort.sort(arr,l,r);
                    return;
                }
            int p = partition(arr,l,r);
            sort(arr,l,p-1);
            sort(arr,p+1,r);
        }

    public static void sort(Comparable[] arr){
            int n = arr.length;
            sort(arr,0,n-1);
        }


    private static void sort(Object[] arr,int i,int j){
            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

    public static void main(String[] args) {
            //QuickSort也是一個O(nlogn)複雜度的算法
            //可以在1秒之內輕鬆處理100萬數量級的數據
            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
            SortTestHelper.tesrSort("com.nero.main.java.algorithm.Quick_Sort.QuickSort",arr);
        }
}
