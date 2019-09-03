package com.nero.main.java.algrorithm.Sorting_Advance.Selection;

public class TestHelper {

    // 生成一個完全有序的數組
    public static Integer[] generateOrderedArray( int n ){

            Integer[] arr = new Integer[n];
            for( int i = 0 ; i < n ; i ++ )
                arr[i] = new Integer(i);

            return arr;
        }

    // 將數組arr隨機化
    public static void shuffleArray( Object[] arr ){

            int n = arr.length;
            for( int i = 0 ; i < n ; i ++ ){
                int j = (int)(Math.random() * (n-i)) + i;

                Object t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
}
