package com.nero.main.java.algorithm.Heap_Sort;

import java.sql.SQLOutput;
import java.util.Arrays;

public class IndexMaxHeap<Item extends Comparable> {

    protected Item[] data; // 最大索引堆中的数据
    protected int[] indexes; // 最大索引堆中的索引, indexes[x] = i 表示索引i在x的位置
    protected int[] reverse; // 最大索引堆中的反向索引, reverse[i] = x 表示索引i在x的位置
    protected int count;
    protected int capacity;

    // 構造函數, 構造一個空堆, 可容納capacity個元素
    public IndexMaxHeap(int capacity){
            data = (Item[])new Comparable[capacity+1];
            indexes = new int[capacity+1];
            reverse = new int[capacity+1];
            for (int i = 0; i <= capacity ; i++) {
                    reverse[i] = 0;
               }

            count = 0;
            this.capacity = capacity;
        }

    // 返回索引堆中的元素個數
    public int size(){
            return count;
        }

    // 返回一個布爾值, 表示索引堆中是否為空
    public boolean isEmpty(){
            return count == 0;
        }

    // 向最大索引堆中插入一個新的元素, 新元素的索引為i, 元素為item
    // 傳入的 i 對用戶而言,是從0索引的
    public void insert(int i ,Item item){
            assert count + 1 <= capacity;
            assert i+1 >= 1 && i+1 <= capacity;

            // 再插入一個新元素前,還需要保證索引i所在的位置是沒有元素的。
            assert !contain(i);

            i+=1;
            data[i] = item;
            indexes[count+1] = i;
            reverse[i] = count+1;
            count++ ;
            shiftUp(count);
        }

    // 從最大索引堆中取出堆頂元素, 即索引堆中所存儲的最大數據
    public Item extractMax(){
            assert count > 0;
            Item ret = data[indexes[1]];
            swapIndexes(1,count);
            reverse[indexes[count]] = 0;
            count--;
            shiftDown(1);

            return ret;
        }

    // 從最大索引堆中取出堆頂元素的索引
    public int extractMaxIndex(){
            assert count > 0;

            //這裡會減一,是因為 i 對用戶而言,是從0索引的
            int ret = indexes[1] -1;
            swapIndexes(1,count);
            reverse[indexes[count]] = 0;
            count--;
            shiftDown(1);

            return ret;
         }


    // 獲取最大索引堆中的堆頂元素
    public Item getMax(){
            assert count > 0;
            return data[indexes[1]];
        }

    // 獲取最大索引堆中的堆頂元素的索引
    public int getMaxIndex(){
            assert count > 0;
            return indexes[1] - 1;
        }

    // 看索引i所在的位置是否存在元素
    boolean contain(int i){
             assert i+1>= 1 && i+1 <= capacity;
             return reverse[i+1] != 0;
         }

    // 獲取最大索引堆中索引為i的元素
    public Item getItem(int i) {
            assert contain(i);
            return data[i+1];
        }


    // 將最大索引堆中索引為i的元素修改為newItem
    public void change(int i ,Item newItem){
            assert contain(i);

            i+=1;
            data[i] = newItem;

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之後shiftUp(j), 再shiftDown(j)
//            for (int j = 1 ; j <= count; j++){
//                    if (indexes[j] == i){
//                          shiftUp(j);
//                           shiftDown(j);
//                           return;
//                       }
//                }

        // 有了 reverse 之後,
        // 我們可以非常簡單的通過reverse直接定位索引i在indexes中的位置
            shiftUp(reverse[i]);
            shiftDown(reverse[i]);

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

    // 索引堆中, 數據之間的比較根據data的大小進行比較, 但實際操作的是索引
    private void shiftUp(int k){
            while ( k > 1 && data[indexes[k/2]].compareTo(data[indexes[k]]) <  0 ){
                    swapIndexes(k,k/2);
                    k/= 2;
                }
        }

    // 索引堆中, 數據之間的比較根據data的大小進行比較, 但實際操作的是索引
    private void shiftDown(int k){
            while (2*k <= count){
                    int j = 2*k;
                    if (j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) > 0)
                        j++;

                    if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0)
                        break;

                    swapIndexes(k,j);
                    k = j;
                }
        }


    // 測試索引堆中的索引數組index 和 反向數組reverse
    // 注意:這個測試在向堆中插入元素以後, 不進行extract操作有效
    public boolean testIndexes(){
            int[] copyIndexes = new int[count+1];
            int[] copyReverseIndexes = new int[count+1];

        for (int i = 0; i <= count; i++) {
                copyIndexes[i] = indexes[i];
                copyReverseIndexes[i] = reverse[i];
            }
            copyIndexes[0] = 0;
            copyReverseIndexes[0] = 0;
            Arrays.sort(copyIndexes);
            Arrays.sort(copyReverseIndexes);


            //在對索引堆中的索引和反向索引進行排序後,
            //兩個數組都應該正好是1...count這count個索引
            boolean res = true;
            for (int i = 1; i <= count ; i++) {
                    if (copyIndexes[i-1]+1 != copyIndexes[i]){
                            if (copyIndexes[i-1] + 1 !=  copyIndexes[i]){
                                    res = false;
                                    break;
                                }

                            if (!res){
                                    System.out.println("Error!");
                                    return false;
                                }
                        }
                }
            return true;
        }

    public static void main(String[] args) {
            int N = 1000000;
            IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(N);

            for (int i = 0; i < N; i++)
                indexMaxHeap.insert(i,(int)(Math.random()*N));

            assert indexMaxHeap.testIndexes();
        }
}
