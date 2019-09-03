package com.nero.main.java.algrorithm.Heap_Sort.Index_Min_Heap;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class IndexMinHeap<Item extends Comparable> {

    protected Item[] data; // 最小索引堆中的數據
    protected int[] indexes; // 最小索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    protected int[] reverse; // 最小索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    protected int count;
    protected int capacity;

    // 構造函數, 構造一個空堆, 可容納capacity個元素
    public IndexMinHeap(int capacity){
            data = (Item[])new Comparable[capacity+1];
            indexes = new int[capacity+1];
            reverse = new int[capacity+1];
            for (int i = 0; i <= capacity; i++)
                reverse[i] = 0;

            count = 0;
            this.capacity = capacity;
        }

    // 返回堆中的元素個數
    public int size(){
        return count;
    }

    // 返回一個布爾值, 表示堆中是否為空
    public boolean isEmpty(){
        return count == 0;
    }

    // 向最小索引堆中插入一個新的元素, 新元素的索引為i, 元素為item
    // 傳入的i對用戶而言,是從0索引的
    public void insert(int i,Item item){
            assert count+1 <= capacity;
            assert i + 1 >= 1 && i + 1 <= capacity;

            // 再插入一個新元素前,還需要保證索引i所在的位置是沒有元素的。
            assert !contain(i);

            i+=1;
            data[i] = item;
            indexes[count+1] = i;
            reverse[i] = count+1;
            count++;

            shiftUp(count);
        }

    // 從最小索引堆中取出堆頂元素, 即索引堆中所存儲的最小數據
    public Item extractMin(){
            assert count > 0;

            Item ret = data[indexes[1]];
            swapIndexes(1,count);
            reverse[indexes[count]] = 0;
            count--;
            shiftDown(1);

            return ret;
        }

    // 獲取最小索引堆中的堆頂元素
    public Item getMin(){
            assert count > 0;
            return data[indexes[1]];
        }

    // 獲取最小索引堆中的堆頂元素的索引
    public int getMinIndex(){
           assert count > 0;
           return indexes[1] -1;
        }

    // 看索引i所在的位置是否存在元素
    boolean contain(int i){
            assert i+1 >= 1 && i+1 <= capacity;
            return reverse[i+1] != 0;
        }

    // 獲取最小索引堆中索引為i的元素
    public Item getItem(int i){
            assert contain(i);
            return data[i+1];
        }

    // 將最小索引堆中索引為i的元素修改為newItem
    public void change(int i ,Item newItem){
            assert contain(i);

            i+=1;
            data[i] = newItem;

            // 有了 reverse 之後
            // 可以非常簡單的通過reverse直接定位索引i在indexes中的位置
            shiftUp( reverse[i] );
            shiftDown( reverse[i] );
        }

    // 交換索引堆中的索引i和j
    // 由於有了反向索引reverse數組，
    // indexes數組發生改變以後， 相應的就需要維護reverse數組
    private void swapIndexes(int i ,int j){
            int t = indexes[i];
            indexes[i] = indexes[j];
            indexes[j] = t;

            reverse[indexes[i]] = i;
            reverse[indexes[j]] = j;
        }

    private void shiftUp(int k){
            while (k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) > 0){
                    swapIndexes(k, k/2);
                    k /= 2;
                }
        }

    private void shiftDown(int k) {
                while (2*k <= count){
                        int j = 2*k;
                        if (j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) < 0)
                            j++;

                        if (data[indexes[k]].compareTo(data[indexes[j]]) <= 0)
                            break;

                        swapIndexes(k, j);
                        k = j;
                    }
        }

    public static void main(String[] args) {
            int N = 1000000;
            IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<>(N);
            for (int i = 0; i < N; i++)
                indexMinHeap.insert(i,new Integer((int)(Math.random()*N)));


            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++) {
                    arr[i] = indexMinHeap.extractMin();
                    System.out.print(arr[i]+" ");
                }
            System.out.println();

            for (int i = 0; i < N; i++)
                assert arr[i-1] <= arr[i];
        }


}
