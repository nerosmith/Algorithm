package com.nero.main.java.algrorithm.Heap_Sort.Index_Min_Heap;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

// 使用最小索引堆進行堆排序, 來驗證我們的最大索引堆的正確性
public class IndexMinHeapSort {

    public static void sort(Comparable[] arr){
            int n = arr.length;

            IndexMinHeap<Comparable> indexMinHeap = new IndexMinHeap<>(n);
            for (int i = 0; i < n; i++)
                indexMinHeap.insert(i,arr[i]);

            for (int i = 0; i < n; i++)
                arr[i] = indexMinHeap.extractMin();
        }

    public static void main(String[] args) {
            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.Heap_Sort.Index_Min_Heap.IndexMinHeapSort", arr);
        }
}
