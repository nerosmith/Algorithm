package com.nero.main.java.algorithm.Heap_Sort;
import com.nero.main.java.algorithm.SortTestHelper.SortTestHelper;



public class HeapSort {

    // 對整個arr數組使用HeapSort排序
    // HeapSort, 將所有的元素依次添加到堆中,在將所有元素從堆中依次取出來, 即完成了排序
    // 無論是創建堆的過程, 還是從堆中依次取出元素的過程, 時間複雜度均為O(nlogn)
    // 整個堆排序的整體時間複雜度為O(nlogn)
    public static void sort(Comparable[] arr){
            int n = arr.length;
            MaxHeap<Comparable> maxHeap = new MaxHeap<>(n);

            for (int i = 0; i < n; i++)
                maxHeap.insert(arr[i]);

            for (int i = n-1; i >= 0; i--)
                arr[i] = maxHeap.extractMax();
        }

    public static void main(String[] args) {
            int N = 1000000;
            Integer[] arr = SortTestHelper.generateRandomArray(N,0,100000);
            SortTestHelper.tesrSort("com.nero.main.java.algorithm.Heap_Sort.HeapSort",arr);
        }
}
