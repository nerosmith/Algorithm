package com.nero.main.java.algrorithm.SortingBasic.Selection_Sort_Generate_Test_Cases;

public class SortTestHelper {

    //生成有n個元素的隨機數組,每個元素的隨機範圍為[rangeL,rangeR]
    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR){
            assert rangeL <= rangeR;
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Integer((int)(Math.random()*(rangeR-rangeL+1)+rangeL));
            }
            return arr;
        }

    // 打印arr數組的所有內容
    public static void printArray(Object arr[]){
            for (int i = 0; i < arr.length; i++) {
                    System.out.print( arr[i] );
                    System.out.print( ' ' );
                }
            System.out.println();
            return;
        }
}
