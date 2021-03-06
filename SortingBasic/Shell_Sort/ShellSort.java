package com.nero.main.java.algrorithm.SortingBasic.Shell_Sort;

public class ShellSort {

    public static void sort(Comparable[] arr){
            int n = arr.length;

            int h = 1;
            while (h < n/3) h = 3*h+1;

            while (h >= 1){

                    for (int i = 0; i < n; i++) {
                            Comparable e = arr[i];
                            int j = i;
                            for (; j >= h && e.compareTo(arr[j-h]) < 0; j-=h)
                                arr[j] = arr[j-h];
                            arr[j] = e;
                        }
                    h/=3;
                }
        }
}
