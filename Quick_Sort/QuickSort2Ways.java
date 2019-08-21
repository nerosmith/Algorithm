package com.nero.main.java.algorithm.Quick_Sort;

import com.nero.main.java.algorithm.SortTestHelper.SortTestHelper;
import com.nero.main.java.algorithm.SortingBasic.InsertionSort;

public class QuickSort2Ways {

    // 雙路快速排序的partition
    // 對arr[l...r]部分進行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]

    private static int partition(Comparable[] arr ,int l,int r){

            //隨機在arr[l...r]的範圍中, 選擇一個數值作為標定點pivot
            swap(arr,l,(int)(Math.random()*(r-l+1)+l));
            Comparable v = arr[l];

            //arr[l+1...i) <= v; arr(j...r] >= v
            int i = l+1,j =r;
            while(true){
                    //這裡的邊界, arr[i].compareTo(v) < 0, 不能是arr[i].compareTo(v) <= 0
                    while(i <= r &&  arr[i].compareTo(v)<0)
                        i++;
                    //這裡的邊界, arr[j].compareTo(v) > 0, 不能是arr[j].compareTo(v) >= 0
                    while (j >= l+1 && arr[j].compareTo(v)>0)
                        j--;
                    if (i > j)
                        break;
                    swap(arr,i,j);
                    i++;
                    j--;

                    //比如數組 1,0,0, ..., 0, 0
                    //a. 對於arr[i]<v和arr[j]>v的方式，第一次partition得到的分點是數組中間
                    //b. 對於arr[i]<=v和arr[j]>=v的方式，第一次partition得到的分點是數組的倒數第二個。
                    //這是因為對於連續出現相等的情況，a方式會交換i和j的值；
                    // 而b方式則會將連續出現的這些值歸為其中一方，使得兩棵子樹不平衡
                }
            swap(arr,l,j);
            return j;
        }

    // 遞歸使用快速排序,對arr[l...r]的範圍進行排序
    private static void swap(Comparable[] arr ,int l,int r){
            //if (l>=r)
            //return;
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
            SortTestHelper.tesrSort("com.nero.main.java.algorithm.Quick_Sort.QuickSort2Ways",arr);
        }
}
