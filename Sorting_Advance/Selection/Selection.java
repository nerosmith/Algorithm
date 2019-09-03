package com.nero.main.java.algrorithm.Sorting_Advance.Selection;

public class Selection {

    //　對arr[l...r]部分進行partition操作
    //　返回p，使得arr [l ... p-1] <arr [p]; arr [p + 1 ... r]> arr [p]
    //　partition 過程, 和快排的partition一樣

    private static int partition(Comparable[] arr,int l,int r){

            // 隨機在arr[l...r]的範圍中, 選擇一個數值作為標定點pivot
            swap(arr,l,(int)(Math.random()*(r-l+1))+l);

            Comparable v = arr[l];

            int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
            for (int i = l+1; i <= r ; i++) {
                       if (arr[i].compareTo(v) < 0){
                                j++;
                                swap(arr,j,i);
                            }
                }

            swap(arr,l,j);

            return j;
        }

    // 尋找nums數組中第k小的元素
    // 在這算法中, k是從0開始索引的, 即最小的元素是第0小元素, 以此類推
    // 如果希望算法中k的語意是從1開始的, 只需要在整個邏輯開始進行k--即可, 可以參考solve2
    public static Comparable solve(Comparable[] nums,int k){
            assert nums != null && k >= 0 && k <= nums.length;
            return solve(nums,0,nums.length-1,k);
        }

    public  static Comparable solve2(Comparable[] nums,int k){
            return Selection.solve(nums,k-1);
        }

    private static Comparable solve(Comparable[] nums, int l, int r, int k) {
            if (l == r)
                return nums[l];

            // partition之後, nums[p]的正確位置就在索引p上
            int p = partition(nums,l,r);

            if (k == p)
                return nums[p];
            // 如果 k < p, 只需要在nums[l...p-1]中找第k小元素即可
            else if (k < p)
                return solve(nums,l,p-1,k);
            // 如果 k > p, 則需要在nums[p+1...r]中找第k-p-1小元素
            // 由於傳入selection的依然是nums, 而不是nums[p+1...r],
            // 所以傳入的最後一個參數依然是k, 而不是k-p-1
            else
                return solve(nums,p+1,r,k);
        }


    private static void swap(Object[] arr, int i, int j) {
            Object t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }

    // 測試 Selection
    public static void main(String[] args) {
            // 生成一個大小為n, 包含0...n-1這n個元素的隨機數組arr
            int N = 10000;
            Integer[] arr = TestHelper.generateOrderedArray(N);
            TestHelper.shuffleArray(arr);

            // 驗證Selection.solve, 對arr數組求第i小元素, 應該為i
            for (int i = 0; i < N; i++) {
                    assert (int)solve(arr,i) == i;
                    System.out.println("test"+i+" complete.");
                }
            System.out.println("Test Selection.solve completed.");
            System.out.println();

            // 驗證Selection.solve2, 對arr數組求第i小元素, 應該為i-1
            // 因為在Selection.solve2中, 第k小元素的k是從1索引的
            for (int i = 0; i < N; i++) {
                    assert (int)solve2(arr,i) == i-1;
                    System.out.println("test"+i+" complete.");
                }
            System.out.println("Test Selection.solve2 completed.");
        }
}
