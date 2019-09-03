package com.nero.main.java.algrorithm.Sorting_Advance.MergeSort_and_MergeSortBU_Performance_Comparison;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;
import com.nero.main.java.algrorithm.Sorting_Advance.Merge_Sort_Advance.InsertionSort;

public class MergeSortBU2 {

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
                else if (aux[i-l].compareTo(aux[j-l]) < 0){  // 左半部分所指元素 < 右半部分所指元素
                        arr[k] = aux[i];
                        i++;
                    }
                else{  // 左半部分所指元素 >= 右半部分所指元素
                        arr[k] = aux[j];
                        j++;
                    }
            }
        }

    public static void sort(Comparable[] arr){
            int n = arr.length;

            // 對於小數組, 使用插入排序優化
            for (int i = 0; i < n; i+=16)
                InsertionSort.sort(arr,i,Math.min(i+15,n-1));

            Comparable[] aux = new Comparable[n];
            for (int sz = 16;sz < n;sz+=sz)
                for (int i = 0; i < n-sz; i+=sz+sz)
                    // 對於arr[mid] <= arr[mid+1]的情況,不進行merge
                    if (arr[i+sz-1].compareTo(arr[i+sz]) > 0)
                        merge(arr,aux,i,i+sz-1,Math.min(i+sz+sz-1,n-1));
        }

    public static void main(String[] args) {
            int N = 50000;
            Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.Sorting_Advance.MergeSort_and_MergeSortBU_Performance_Comparison.MergeSortBU2", arr);
        }
}
