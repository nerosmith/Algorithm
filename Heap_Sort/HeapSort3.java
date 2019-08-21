package com.nero.main.java.algorithm.Heap_Sort;

import com.nero.main.java.algorithm.SortTestHelper.SortTestHelper;

public class HeapSort3 {

    public static void sort(Comparable[] arr){
            int n =arr.length;

            // 注意，此時我們的堆是從0開始索引的
            // 從(最後一個元素的索引-1)/2開始
            // 最後一個元素的索引 = n-1
            for (int i = (n-1-1)/2; i >= 0 ; i--)
                    shiftDown2(arr,n,i);

            for (int i = n-1; i > 0; i--) {
                    swap(arr,0,i);
                    shiftDown2(arr,i,0);
                }
        }

    private static void swap(Object[] arr,int i ,int j){
            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

    // 原始的shiftDown過程
    private static void shiftDown(Comparable[] arr,int n ,int k){

            while(2*k+1 < n){
                    int j = 2*k+1;
                    if (j+1 < n && arr[j+1].compareTo(arr[j]) > 0)
                        j+=1;
                    if (arr[k].compareTo(arr[j]) >= 0) break;

                    swap(arr,k,j);
                    k = j;
                }
        }


    // 優化的shiftDown過程, 使用賦值的方式取代不斷的swap
    // 該優化思想和我們之前對插入排序進行優化的思路是一致的
    private static void  shiftDown2(Comparable[] arr,int n ,int k){
            Comparable e = arr[k];
            while(2*k+1 < n){
                    int j = 2*k+1;
                    if (j+1 < n && arr[j+1].compareTo(arr[j]) > 0)
                        j+=1;

                    if (e.compareTo(arr[j]) >= 0)
                        break;

                    arr[k] = arr[j];
                    k = j;
                }
            arr[k] = e;
        }

    public static void main(String[] args) {
            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
            SortTestHelper.tesrSort("com.nero.main.java.algorithm.Heap_Sort.HeapSort3", arr);
        }
}
