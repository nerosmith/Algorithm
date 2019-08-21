package com.nero.main.java.algorithm.SortTestHelper;

import java.lang.reflect.Method;

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

    // 生成一個近乎有序的數組
    // 首先生成一個含有[0...n-1]的完全有序數組, 之後隨機交換swapTimes對數
    // swapTimes定義了數組的無序程度:
    // swapTimes == 0 時, 數組完全
    // swapTimes 越大, 數組越趨向於無序
    public static Integer[] generateNearlyOrderedArray(int n ,int swapTimes){
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++)
                arr[i] = new Integer(i);

            for (int i = 0; i < swapTimes; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    int t = arr[a];
                    arr[a] = arr[b];
                    arr[b] = t;
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

    //判斷arr數組是否有序
    public static boolean isSorted(Comparable[] arr){
            for (int i = 0; i < arr.length-1; i++) {
                    if (arr[i].compareTo(arr[i+1]) > 0)
                        return false;
                }
            return true;
        }

    //測試sortClassName所對應的排序算法排序arr數組所得到結果的正確性和算法運行時間
    public static void tesrSort(String sortClassName,Comparable[] arr){
            try {

                //通过sortClassName获得排序函数的Class对象
                Class sortClass  = Class.forName(sortClassName);

                //通過排序函數的Class對象獲得排序方法
                Method sortMethod = sortClass.getMethod("sort",new Class[]{Comparable[].class});

                //排序參數只有一個，是可比較數組arr
                Object[] params = new Object[]{arr};

                long startTime = System.currentTimeMillis();
                //調用排序函數
                sortMethod.invoke(null,params);
                long endTime = System.currentTimeMillis();

                assert isSorted(arr);
                System.out.println(sortClass.getSimpleName()+ " : " +(double) (endTime-startTime)/1000 + " ms" );
            }
            catch (Exception e){
                    e.printStackTrace();
                }
        }


}
