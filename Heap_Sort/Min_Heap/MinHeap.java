package com.nero.main.java.algrorithm.Heap_Sort.Min_Heap;

// 在堆的有關操作中，需要比較堆中元素的大小，所以Item需要extends Comparable
public class MinHeap <Item extends Comparable>{

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 構造函數, 構造一個空堆, 可容納capacity個元素
    public MinHeap(int capacity){
            data= (Item[])new Comparable[capacity+1];
            count = 0;
            this.capacity = capacity;
        }

    // 構造函數, 通過一個給定數組創建一個最小堆
    // 該構造堆的過程, 時間複雜度為O(n)
    public MinHeap(Item[] arr){

            int n = arr.length;

            data= (Item[])new Comparable[n+1];
            capacity = n;

            for (int i = 0; i < n; i++)
                data[i+1] = arr[i];
            count = n;

            for (int i = count/2; i >= 1; i--)
                shiftDown(i);
        }

    // 返回堆中的元素個數
    public int size(){
            return count;
        }

    // 返回一個布爾值, 表示堆中是否為空
    public boolean isEmpty(){
            return count == 0;
        }

    // 向最小堆中插入一個新的元素 item
    public void insert(Item item){
            assert  count+1 <= capacity;
            data[count+1] = item;
            count++;
            shfitUp(count);
        }

    // 從最小堆中取出堆頂元素, 即堆中所存儲的最小數據
    public Item extractMin(){
            assert count > 0;
            Item ret = data[1];

            swap(1,count);
            count--;
            shiftDown(1);

            return ret;
        }


    // 獲取最小堆中的堆頂元素
    public Item getMin(){
            assert count > 0;
            return data[1];
        }

    private void swap(int i, int j) {
            Item t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

    private void shfitUp(int k) {
            while ( k > 1 && data[k/2].compareTo(data[k]) > 0){
                    swap(k,k/2);
                    k/=2;
                }
        }

    private void shiftDown(int k) {
            while ( 2*k <= count ){
                    int j = 2*k; // 在此輪循環中,data[k]和data[j]交換位置
                    if (j + 1 <= count && data[j+1].compareTo(data[j]) < 0)
                        j++;
                    // data[j] 是 data[2*k]和data[2*k+1]中的最小值

                    if (data[k].compareTo(data[j]) <= 0) break;
                    swap(k,j);
                    k = j;
                }
        }

    public static void main(String[] args) {
            MinHeap<Integer> minHeap = new MinHeap<>(100);
            int N = 100; // 堆中元素個數
            int M = 100; // 堆中元素取值範圍[0, M)

            for (int i = 0; i < N; i++)
                minHeap.insert(new Integer((int)(Math.random()*M)));

            Integer[] arr = new Integer[N];
            // 將minheap中的數據逐漸使用extractMin取出來
            // 取出來的順序應該是按照從小到大的順序取出來的
            for (int i = 0; i < N; i++) {
                    arr[i] = minHeap.extractMin();
                    System.out.print(arr[i]+" ");
                }
            System.out.println();

            // 確保arr數組是從小到大排列的
            for (int i = 0; i < N; i++)
                assert arr[i-1] <= arr[i];

        }
}
