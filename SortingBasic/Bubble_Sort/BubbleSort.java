package com.nero.main.java.algrorithm.SortingBasic.Bubble_Sort;

public class BubbleSort {

    public static void sort(Comparable[] arr){
            int n = arr.length;
            boolean swapped = false;

            do {
                swapped = false;
                for (int i = 1; i < n; i++) {
                        if (arr[i-1].compareTo(arr[i]) > 0){
                                swap(arr,i-1,i);
                                swapped = true;
                            }

                        // 優化, 每一趟Bubble Sort都將最大的元素放在了最後的位置
                        // 所以下一次排序, 最後的元素可以不再考慮
                        n--;
                    }
                }while (swapped);

        }

    private static void swap(Object[] arr, int i, int j) {
                Object t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
        }
}
