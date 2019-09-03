package com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

import java.util.Arrays;

public class Main {
    // 比較SelectionSort和InsertionSort兩種排序算法的性能效率
    public static void main(String[] args) {
            int N = 20000;
            System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
            Integer[] arr = SortTestHelper.generateRandomArray(N,0,N);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);

            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort.SelectionSort",arr);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.SortingBasic.Insertion_Sort.InsertionSort",arr2);

        }
}
