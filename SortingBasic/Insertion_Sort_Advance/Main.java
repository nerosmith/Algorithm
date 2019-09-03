package com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

import java.util.Arrays;

public class Main {
    // 比較SelectionSort和InsertionSort兩種排序算法的性能效率
    // 優化後，插入排序比選擇排序性能略好
    // 對於有序性強的數組，插入排序遠遠優於選擇排序
    public static void main(String[] args) {
            int N = 20000;

            // 測試1 一般測試
            System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
            Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);

            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance.SelectionSort",arr);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance.InsertionSort",arr2);

            System.out.println();

            // 测试2 有序性更强的测试
            System.out.println("Test for more ordered random array, size = " + N + " , random range [0,3]");

            arr = SortTestHelper.generateRandomArray(N, 0, 3);
            arr2 = Arrays.copyOf(arr, arr.length);

            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance.SelectionSort",arr);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance.InsertionSort",arr2);

            System.out.println();

            // 測試3 測試近乎有序的數組
            int swapTimes = 100;
            System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

            arr = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
            arr2 = Arrays.copyOf(arr, arr.length);

            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance.SelectionSort",arr);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort_Advance.InsertionSort",arr2);

        }
}
