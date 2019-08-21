package com.nero.main.java.algorithm.Heap_Sort;

import org.omg.CORBA.INTERNAL;

public class MaxHeap<Item extends Comparable> {

    protected Item[] data;
    protected int count;
    protected int capacity;

    // 構造函數, 構造一個空堆, 可容納capacity個元素
    public MaxHeap(int capacity){
            data = (Item[])new Comparable[capacity+1];
            count = 0;
            this.capacity = capacity;
        }

    // 構造函數, 通過一個給定數組創建一個最大堆
    // 該構造堆的過程, 時間複雜度為O(n)
    public MaxHeap(Item arr[]){
            int n = arr.length;
            data = (Item[])new Comparable[n+1];
            capacity = n;

            for (int i = 0; i < n; i++)
                data[i+1] = arr[i];
            count = n;

            for (int i = count/2; i >=1 ; i--)
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


    // 像最大堆中插入一個新的元素 item
    public void insert(Item item){
            assert count + 1 <= capacity;
            data[count + 1] = item;
            count++;
            shiftUp(count);
        }

    public Item extractMax(){
            assert count > 0;
            Item ret = data[1];

            swap(1,count);
            count--;
            shiftDown(1);
            return ret;
        }

    public Item getMax(){
            assert (count > 0);
            return data[1];
        }


    private void shiftUp(int k){
            while (k > 1 && data[k/2].compareTo(data[k]) < 0){
                    swap(k,k/2);
                    k/=2;
                }
        }

    private void shiftDown(int k){
            while (2*k <= count){
                    int j = 2*k; // 在此輪循環中,data[k]和data[j]交換位置

                    if (j+1 <= count && data[j+1].compareTo(data[j]) > 0)
                        j++;
                    //data[j] 是 data[2*k]和data[2*k+1]中的最大值

                    if (data[k].compareTo(data[j]) >= 0)
                        break;

                    swap(k,j);
                    k = j;
                }
        }


    // 交換堆中索引為i和j的兩個元素
    private void swap(int i,int j){
            Item t = data[i];
            data[i] = data[j];
            data[j] = t;
        }


    public static void main(String[] args) {
            MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
            int N = 50;// 堆中元素個數
            int M = 100;// 堆中元素取值範圍[0, M)
            for (int i = 0; i < N; i++) {
                    maxHeap.insert(new Integer((int)(Math.random()*M)));
                }

            Integer[] arr = new Integer[N];
            // 將maxheap中的數據逐漸使用extractMax取出來
            // 取出來的順序應該是按照從大到小的順序取出來的
            for (int i = 0; i< N ;i++){
                    arr[i] = maxHeap.extractMax();
                    System.out.print(arr[i]+" ");
                }
            System.out.println();

            // 確保arr數組是從大到小排列的
            for (int i = 1; i < N; i++) {
                    assert arr[i-1] >= arr[i];
                }
        }
}
