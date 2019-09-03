package com.nero.main.java.algrorithm.SortingBasic.Bubble_Sort;

public class BubbleSort2 {

    public static void sort(Comparable[] arr){
            int n = arr.length;
            int newn; // 使用newn進行優化

            do {
                newn = 0;
                for (int i = 1; i < n; i++) {
                        if (arr[i-1].compareTo(arr[i]) > 0){
                                swap(arr,i-1,i);

                                // 記錄最後一次的交換位置,在此之後的元素在下一輪掃描中均不考慮
                                newn = i;
                            }
                    }
                n = newn;
            }while (newn > 0);
        }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
