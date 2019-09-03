package com.nero.main.java.algrorithm.Heap_Sort.Index_Heap;


// 使用最大索引堆進行堆排序, 來驗證我們的最大索引堆的正確性
// 最大索引堆的主要作用不是用於排序, 我們在這裡使用排序只是為了驗證我們的最大索引堆實現的正確性
// 在後續的圖論中, 無論是最小生成樹算法, 還是最短路徑算法, 我們都需要使用索引堆進行優化:)

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

public class IndexHeapSort {

    public static void sort(Comparable[] arr){
            int n = arr.length;
            IndexMaxHeap<Comparable> indexMaxHeap = new IndexMaxHeap<>(n);

            for (int i = 0; i < n; i++)
                indexMaxHeap.insert(i,arr[i]);

            for (int i = n-1; i >= 0; i--)
                arr[i] = indexMaxHeap.extractMax();
        }

    public static void main(String[] args) {
            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.Heap_Sort.Index_Heap.IndexHeapSort",arr);
        }
}
