package com.nero.main.java.algrorithm.Sorting_Advance.Merge_Sort;

import com.nero.main.java.algrorithm.SortingBasic.Selection_Sort_Detect_Performance.SortTestHelper;

import java.util.Arrays;

public class MergeSort {
    private static void merge(Comparable[] arr,int l,int mid ,int r){
            Comparable[] aux = Arrays.copyOfRange(arr,l,r+1);

            // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
            int i = l,j = mid+1;
            for (int k = l; k <= r; k++) {
                if (i > mid){ // 如果左半部分元素已經全部處理完畢
                    arr[k] = aux[j-l];
                    j++;
                }
                else if (j > r){ // 如果右半部分元素已經全部處理完畢
                    arr[k] = aux[i-l];
                    i++;
                }
                else if (aux[i-l].compareTo(aux[j-l]) < 0){  // 左半部分所指元素 < 右半部分所指元素
                    arr[k] = aux[i-l];
                    i++;
                }
                else{  // 左半部分所指元素 >= 右半部分所指元素
                    arr[k] = aux[j-l];
                    j++;
                }
            }
        }

    // 遞歸使用歸併排序,對arr[l...r]的範圍進行排序
    private static void sort(Comparable[] arr,int l,int r){
            if (l >= r)
                return;
            int mid = (l+r)/2;
            sort(arr,l,mid);
            sort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }

    public static void sort(Comparable[] arr){
            int n = arr.length;
            sort(arr,0,n-1);
        }

    public static void main(String[] args) {

            //Merge Sort是一個O(nlogn)複雜度的算法
            //可以在1秒之內輕鬆處理100萬數量級的數據
            //如果使用SelectionSort, InsertionSort或者BubbleSort處理100萬級的數據
            //就見識了O(n^2)的算法和O(nlogn)算法的本質差異

            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
            SortTestHelper.tesrSort("com.nero.main.java.algrorithm.Sorting_Advance.Merge_Sort.MergeSort", arr);
        }
}
