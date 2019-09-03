package com.nero.main.java.algrorithm.Sorting_Advance.Merge_Sort_Create_aux_Array_Out_of_Merge;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;
import com.nero.main.java.algrorithm.Sorting_Advance.Merge_Sort_Advance.InsertionSort;

import java.util.Arrays;

// 在 mergeSort2中, 我們一次性申請aux空間,
// 並將這個輔助空間以參數形式傳遞給完成歸併排序的各個子函數
public class MergeSort2 {


    // 將arr[l...mid]和arr[mid+1...r]兩部分進行歸併
    // 其中aux為完成merge過程所需要的輔助空間
    private static void merge(Comparable[] arr,Comparable[] aux,int l,int mid ,int r){

            System.arraycopy(arr,l,aux,l,r-l+1);

            // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
            int i = l,j = mid+1;
            for (int k = l; k <= r; k++) {
                if (i > mid){ // 如果左半部分元素已經全部處理完畢
                    arr[k] = aux[j];
                    j++;
                }
                else if (j > r){ // 如果右半部分元素已經全部處理完畢
                    arr[k] = aux[i];
                    i++;
                }
                else if (aux[i].compareTo(aux[j]) < 0){  // 左半部分所指元素 < 右半部分所指元素
                    arr[k] = aux[i];
                    i++;
                }
                else{  // 左半部分所指元素 >= 右半部分所指元素
                    arr[k] = aux[j];
                    j++;
                }
            }
        }

    // 遞歸使用歸併排序,對arr[l...r]的範圍進行排序
    private static void sort(Comparable[] arr,Comparable[] aux,int l,int r){

        //優化2: 對於小規模數組, 使用插入排序
        if (r - l <= 15){
                InsertionSort.sort(arr,l,r);
                return;
            }

        int mid = (l+r)/2;
        sort(arr,aux,l,mid);
        sort(arr,aux,mid+1,r);

        //優化1: 對於arr[mid] <= arr[mid+1]的情況,不進行merge
        //對於近乎有序的數組非常有效,但是對於一般情況,有一定的性能損失
        if (arr[mid].compareTo(arr[mid+1]) > 0)
            merge(arr,aux,l,mid,r);
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        Comparable[] aux = new Comparable[n];
        sort(arr,aux,0,n-1);
    }

    public static void main(String[] args) {

        int N = 50000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("com.nero.main.java.algrorithm.Sorting_Advance.Merge_Sort_Create_aux_Array_Out_of_Merge.MergeSort2", arr);
    }
}
