package com.nero.main.java.algrorithm.Heap_Sort.Min_Heap;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

public class MinHeapSort {

        // 將所有的元素依次添加到最小堆中, 再在將所有元素從堆中依次取出來, 完成排序
        // 使用這樣的一個最小堆排序, 來檢驗我們的最小堆的正確性
        public static void sort(Comparable[] arr){
                int n = arr.length;
                MinHeap<Comparable> minHeap = new MinHeap<>(n);
                for (int i = 0; i < n; i++)
                    minHeap.insert(arr[i]);

                for (int i = 0; i < n; i++)
                    arr[i] = minHeap.extractMin();

            }

        // 測試 MinHeapSort
        public static void main(String[] args) {
                int N = 1000000;
                Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
                SortTestHelper.testSort("com.nero.main.java.algrorithm.Heap_Sort.Min_Heap.MinHeapSort",arr);
            }

    }
