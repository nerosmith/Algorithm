package com.nero.main.java.algrorithm.Binary_Search_Tree.Lower_Bound_and_Upper_Bound_in_Binary_Search;

import java.util.Arrays;

public class Main {
    private static Integer[] generateRandomOrderedArray(int n, int rangeL, int rangeR){

            Integer[] arr = new Integer[n];

            for(int i = 0 ; i < n ; i ++)
                arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
            Arrays.sort(arr);
            return arr;
        }


    public static void main(String[] args) {

            int n = 1000;
            int m = 100;
            Integer[] arr = generateRandomOrderedArray(n, 0, m);

            // 我們使用簡單的線性查找法來驗證我們寫的二分查找法
            for (int i = -1; i <= m + 1; i++) {

                    if (BinarySearch.lower_bound(arr, i) != LinearSearch.lower_bound(arr, i))
                        throw new IllegalArgumentException("lower_bound error!");

                    if (BinarySearch.upper_bound(arr, i) != LinearSearch.upper_bound(arr, i))
                        throw new IllegalArgumentException("upper_bound error!");
                }

            System.out.println("test completed:)");
        }
}
