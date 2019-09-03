package com.nero.main.java.algrorithm.Binary_Search_Tree.Binary_Search;

// 遞歸的二分查找算法
public class BinarySearch2 {

    private static int find(Comparable[] arr,int l,int r ,Comparable target){
            if (l > r)
                return -1;

            // int mid =（l + r）/ 2
            // 防止極端情況下的整形溢出，使用下面的邏輯求出mid
            int mid = l+(r-l)/2;

            if (arr[mid].compareTo(target) == 0)
                return mid;

            // 在arr[l...mid-1]之中查找target
            if (arr[mid].compareTo(target) > 0)
                return find(arr,l,mid -1,target);

            //在arr[mid+1...r]之中查找target
            else
                return find(arr,mid+1,r,target);
        }

    // 二分查找法,在有序數組arr中,查找target
    // 如果找到target,返回相應的索引index
    // 如果沒有找到target,返回-1
    public static int find(Comparable[] arr, Comparable target){
            return find(arr,0,arr.length-1,target);
        }

    public static void main(String[] args) {
            int N = 1000000;
            Integer[] arr = new Integer[N];
            for (int i = 0; i < N; i++)
                arr[i] = new Integer(i);

            // 對於我們的待查找數組[0...N)
            // 對[0...N)區間的數值使用二分查找，最終結果應該就是數字本身
            // 對[N...2*N)區間的數值使用二分查找，因為這些數字不在arr中，結果為-1
            for (int i = 0; i < 2*N; i++) {
                    int v = BinarySearch.find(arr,new Integer(i));
                    if (i < N)
                        assert v == i;
                    else
                        assert v == -1;
                }
        }
}
