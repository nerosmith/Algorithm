package com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort;

public class InsertionSort {

    public static void sort(Comparable[] arr){
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                // 尋找元素arr[i]合適的插入位置
                //寫法1
//                   for (int j = i; j > 0 ; j--) {
//                            if (arr[j].compareTo(arr[j-1]) < 0)
//                                swap(arr,j,j-1);
//                            else
//                                break;
//                        }
                //寫法2
                  for (int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j--) {
                           swap(arr,j,j-1);
                       }

                }
        }

    private static void swap(Object[] arr,int i,int j){
            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

}
