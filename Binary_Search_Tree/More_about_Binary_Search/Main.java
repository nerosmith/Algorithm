package com.nero.main.java.algrorithm.Binary_Search_Tree.More_about_Binary_Search;

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

            for (int i = -1; i <= m + 1; i++) {

                    if (BinarySearch.firstGreaterOrEqual(arr, i)
                            != LinearSearch.firstGreaterOrEqual(arr, i))
                        throw new IllegalArgumentException("firstGreaterOrEqual error! " + i);

                    if (BinarySearch.firstGreaterThan(arr, i)
                            != LinearSearch.firstGreaterThan(arr, i))
                        throw new IllegalArgumentException("firstGreaterThan error! " + i);

                    if (BinarySearch.lastLessOrEqual(arr, i)
                            != LinearSearch.lastLessOrEqual(arr, i))
                        throw new IllegalArgumentException("lastLessOrEqual error! " + i);

                    if (BinarySearch.lastLessThan(arr, i)
                            != LinearSearch.lastLessThan(arr, i))
                        throw new IllegalArgumentException("lastLessThan error! " + i);
                }

            System.out.println("test completed:)");


        }
}
