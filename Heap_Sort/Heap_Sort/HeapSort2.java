package com.nero.main.java.algrorithm.Heap_Sort.Heap_Sort;

import com.nero.main.java.algrorithm.Heap_Sort.Max_Heap.MaxHeap;
import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

public class HeapSort2 {


    // 對整個arr數組使用HeapSort排序
    // HeapSort2,借助我們的 heapify 過程創建堆
    // 此時, 創建堆的過程時間複雜度為O(n), 將所有元素依次從堆中取出來, 實踐複雜度為O(nlogn)
    // 堆排序的總體時間複雜度依然是O(nlogn), 但是比HeapSort1性能更優, 因為創建堆的性能更優
    public static void sort(Comparable[] arr){
        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<>(arr);

        for (int i = n-1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
        SortTestHelper.testSort("com.nero.main.java.algrorithm.Heap_Sort.Heap_Sort.HeapSort2",arr);
    }
}
