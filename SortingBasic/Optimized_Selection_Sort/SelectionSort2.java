package com.nero.main.java.algrorithm.SortingBasic.Optimized_Selection_Sort;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

// 在每一輪中, 可以同時找到當前未處理元素的最大值和最小值
public class SelectionSort2 {

    public static void sort(Comparable[] arr){
            int left = 0,right = arr.length-1;
            while (left < right){
                    int minIndex = left;
                    int maxIndex = right;

                    // 在每一輪查找時, 要保證arr[minIndex] <= arr[maxIndex]
                    if (arr[minIndex].compareTo(arr[maxIndex]) > 0)
                        swap(arr,minIndex,maxIndex);

                    for (int i = left+1; i < right; i++) {
                            if (arr[i].compareTo(arr[minIndex]) < 0)
                                minIndex = i;
                            else if (arr[i].compareTo(arr[maxIndex]) > 0)
                                maxIndex = i;
                        }

                    swap(arr,left,minIndex);
                    swap(arr,right,maxIndex);

                    left++;
                    right--;
                }
        }

    private static void swap(Object[] arr, int i, int j) {
            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

    public static void main(String[] args) {
            int N = 20000;
            Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Optimized_Selection_Sort.SelectionSort2", arr);

        }
}
