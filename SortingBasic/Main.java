package com.nero.main.java.algorithm.SortingBasic;

import com.nero.main.java.algorithm.SortTestHelper.SortTestHelper;

import java.util.Arrays;

public class Main {
    // 比較SelectionSort和InsertionSort兩種排序算法的性能效率
    public static void main(String[] args) {
            int N = 20000;
            System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");
            Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N,10);
            Integer[] arr2 = Arrays.copyOf(arr,arr.length);

            SortTestHelper.tesrSort("com.nero.main.java.algorithm.SortingBasic.SelectionSort",arr);
            SortTestHelper.tesrSort("com.nero.main.java.algorithm.SortingBasic.InsertionSort",arr2);
        }
}
