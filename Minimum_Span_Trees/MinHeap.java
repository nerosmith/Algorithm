package com.nero.main.java.algorithm.Minimum_Span_Trees;

public class MinHeap<Item extends  Comparable> {
    protected Item[] data;
    protected int count;
    protected int capacity;

    // 構造函數, 構造一個空堆, 可容納capacity個元素
    public MinHeap(int capacity){
            data = (Item[])new Comparable[capacity+1];
            count = 0 ;
            this.capacity = capacity;
        }

    // 構造函數, 通過一個給定數組創建一個最小堆
    // 時間複雜度為O(n)
    public MinHeap(Item arr[]){
            int n = arr.length;
            data = (Item[])new Comparable[n+1];
            capacity = n;

            for (int i = 0; i < n; i++)
               data[i+1] = arr[i];
            count = n;
             for (int i = count/2; i >= 1 ; i--)
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
            assert count+1 <= capacity;
            data[count+1] = item;
            count++;
            shiftUp(count);
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

    // 交換堆中索引為 i 和 count 的兩個元素
    private void swap(int i, int count) {
            Item t = data[i];
            data[i] = data[count];
            data[count] = t;
        }

    private void shiftUp(int count) {
            while(count > 1 && data[count/2].compareTo(data[count]) > 0){
                    swap(count,count/2);
                    count /= 2;
                }
        }

    private void shiftDown(int i) {
            while(2 * i <= count){
                    int j = 2*i; // 在此輪循環中,data[i]和data[j]交換位置
                    if (j+1 <= count && data[j+1].compareTo(data[j]) < 0)
                        j++;
                    // data[j] 是 data[2*i]和data[2*i+1]中的最小值
                    if (data[i].compareTo(data[j]) <= 0) break;
                    swap(i,j);
                    i = j;
                }
        }
}
