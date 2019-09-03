package com.nero.main.java.algrorithm.Binary_Search_Tree.Floor_and_Ceil_in_Binary_Search;

public class BinarySearch {

    public static int find(Comparable[] arr, Comparable target){
            int l = 0,r = arr.length-1;
            while (l <= r ){
                    // int mid =（l + r）/ 2
                    // 防止極端情況下的整形溢出，使用下面的邏輯求出mid
                    int mid = l+(r-l)/2;

                    if (arr[mid].compareTo(target) == 0)
                        return mid;

                    //在arr[l...mid-1]之中查找target
                    if (arr[mid].compareTo(target) > 0)
                        r = mid-1;

                        //在arr[mid+1...r]之中查找target
                    else
                        l = mid+1;
                }
            return -1;
        }

    // 二分查找法, 在有序數組arr中, 查找target
    // 如果找到target, 返回第一個target相應的索引index
    // 如果沒有找到target, 返回比target小的最大值相應的索引, 如果這個最大值有多個, 返回最大索引
    // 如果這個target比整個數組的最小元素值還要小, 則不存在這個target的floor值, 返回-1
    static int floor(Comparable[] arr, Comparable target){
            // 尋找比target小的最大索引
            int l = -1,r = arr.length - 1;
            while ( l < r){
                    // 使用向上取整避免死循環
                    int mid = l+(r-l+1)/2;
                   if (arr[mid].compareTo(target) >= 0)
                        r = mid-1;
                    else
                        l = mid;
                }

            assert l == r;

            // 如果該索引+1就是target本身, 該索引+1即為返回值
            if (l+1 < arr.length && arr[l+1] == target)
                return l+1;

            // 否則, 該索引即為返回值
            return l;
        }

    // 二分查找法, 在有序數組arr中, 查找target
    // 如果找到target, 返回最後一個target相應的索引index
    // 如果沒有找到target, 返回比target大的最小值相應的索引, 如果這個最小值有多個, 返回最小的索引
    // 如果這個target比整個數組的最大元素值還要大, 則不存在這個target的ceil值, 返回整個數組元素個數n
    static int ceil(Comparable[] arr, Comparable target){

            // 尋找比target大的最小索引值
            int l = 0,r = arr.length;
            while (l < r){
                    // 使用普通的向下取整即可避免死循環
                    int mid = l + (r-l)/2;
                    if (arr[mid].compareTo(target) <= 0)
                        l = mid+1;
                    else
                        r = mid;
                }

            assert l == r;

            // 如果該索引-1就是target本身, 該索引+1即為返回值
            if( r - 1 >= 0 && arr[r-1] == target )
                return r-1;

            return r;
        }

    // 測試我們用二分查找法實現的floor和ceil兩個函數
    // 請仔細觀察在我們的測試用例中，有若干的重複元素，對於這些重複元素，floor和ceil計算結果的區別
    public static void main(String[] args) {
            Integer[] arr = new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6};
            for (int i = 0; i <= 8 ; i++) {
                    int floorIndex = floor(arr, i);
                    System.out.println("the floor index of " + i + " is " + floorIndex + ".");
                    if( floorIndex >= 0 && floorIndex < arr.length )
                        System.out.println("The value is " + arr[floorIndex] + ".");
                    System.out.println();

                    int ceilIndex = ceil(arr,i);
                    System.out.println("the ceil index of " + i + " is " + ceilIndex + ".");
                    if( ceilIndex >= 0 && ceilIndex < arr.length )
                        System.out.println("The value is " + arr[ceilIndex] + ".");
                    System.out.println();

                    System.out.println();
                }
        }

}
