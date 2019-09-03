package com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance;

public class SelectionSort {

    public static void sort(Comparable[] arr){
            int n = arr.length;
            for( int i = 0 ; i < n ; i ++ ){
                    // 尋找(i, n)區間裡的最小值的索引
                    int minIndex = i;
                    for( int j = i + 1 ; j < n ; j ++ )
                        if( arr[j].compareTo(arr[minIndex]) < 0)
                            minIndex = j;

                    swap( arr , i , minIndex);
                }
        }

    private static void swap(Object[] arr, int i, int j) {
            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

}
