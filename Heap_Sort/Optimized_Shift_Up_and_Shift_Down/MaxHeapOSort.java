package com.nero.main.java.algrorithm.Heap_Sort.Optimized_Shift_Up_and_Shift_Down;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

public class MaxHeapOSort {

    // 對整個arr數組使用MaxHeapOSort排序
    // MaxHeapOSort, 將所有的元素依次添加到堆中, 在將所有元素從堆中依次取出來, 即完成了排序
    public static void sort(Comparable[] arr){
            int n = arr.length;
            MaxHeapO<Comparable> maxHeap = new MaxHeapO<>(n);

            for (int i = 0; i < n; i++)
                maxHeap.insert(arr[i]);

            for (int i = n-1; i >= 0; i--)
                arr[i] = maxHeap.extractMax();
        }

    public static void main(String[] args) {
            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
            SortTestHelper.testSort("com.nero.main.java.algrorithm.Heap_Sort.Optimized_Shift_Up_and_Shift_Down.MaxHeapOSort", arr);
        }


}
