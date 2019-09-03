package com.nero.main.java.algrorithm.Shortest_Path.Implementation_of_Dijkstra;

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
            for (int i = 0; i <= capacity ; i++)
                    reverse[i] = 0;

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

    // 向最小索引堆中插入一個新的元素, 新元素的索引為 i, 元素為 item
    // 傳入的i對用戶而言,是從0索引的
    public void insert(int i,Item item){
            assert count+1 <= capacity;
            assert i + 1 >= 1 && i + 1 <= capacity;

            // 再插入一個新元素前,還需要保證索引 i 所在的位置是沒有元素的。
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
            swapIndexes(1 , count );
            reverse[indexes[count]] = 0;
            count--;
            shiftDown(1);

            return ret;
        }

    // 從最小索引堆中取出堆頂元素的索引
    public int extractMinIndex(){
            assert count > 0;

            int ret = indexes[1] - 1;
            swapIndexes(1 , count );
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
            return indexes[1]-1;
        }

    // 看索引i所在的位置是否存在元素
    boolean contain(int i) {
            assert  i + 1 >= 1 && i + 1 <= capacity;
            return reverse[i+1] != 0;
        }

    // 獲取最小索引堆中索引為 i 的元素
    public Item getItem(int i){
            assert contain(i);
            return data[i+1];
        }

    public void change(int i ,Item newItem){
            assert contain(i);

            i+=1;
            data[i] = newItem;

           // 有了 reverse 之後,
           // 通過 reverse 直接定位索引 i 在 indexes 中的位置
            shiftUp(reverse[i] );
            shiftDown(reverse[i]);
        }

    // 交換索引堆中的索引 i 和 count
    // 由於有了反向索引 reverse 數組，
    // indexes 數組發生改變以後， 相應的就需要維護 reverse 數組
    private void swapIndexes(int i, int count) {
            int t = indexes[i];
            indexes[i] = indexes[count];
            indexes[count] = t;

            reverse[indexes[i]] = i;
            reverse[indexes[count]] = count;
        }

    // 索引堆中, 數據之間的比較根據 data 的大小進行比較, 但實際操作的是索引
    private void shiftUp(int count) {
            while(count > 1 && data[indexes[count/2]].compareTo(data[indexes[count]]) > 0){
                swapIndexes(count,count/2);
                count /= 2;
             }
        }

    // 索引堆中, 數據之間的比較根據data的大小進行比較, 但實際操作的是索引
    private void shiftDown(int i) {
        while(2 * i <= count){
                int j = 2*i; // 在此輪循環中, data[i] 和 data[j] 交換位置
                if (j+1 <= count && data[indexes[j+1]].compareTo(data[indexes[j]]) < 0)
                    j++;
                // data[j] 是 data[2*i] 和 data[2*i+1] 中的最小值
                if (data[indexes[i]].compareTo(data[indexes[j]]) <= 0) break;
                swapIndexes(i,j);
                i = j;
            }
        }
}
