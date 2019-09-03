package com.nero.main.java.algrorithm.Binary_Search_Tree.More_about_Binary_Search;

public class BinarySearch {

    // 二分查找法, 在一個有序數組arr中, 尋找大於等於target的元素的第一個索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回arr的元素個數 n
    // 相當於 lower_bound
    public static int firstGreaterOrEqual(Comparable[] arr,Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");

            int l = 0,r =arr.length;
            while(l != r){
                    int mid = l + (r-l)/2;
                    if (arr[mid].compareTo(target) < 0)
                        l = mid + 1;
                    else
                        r = mid;
                }

            return l;
        }

    // 二分查找法, 在一個有序數組arr中, 尋找大於target的元素的第一個索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回arr的元素個數 n
    // 相當於 upper_bound
    public static int firstGreaterThan(Comparable[] arr,Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");

            int l = 0,r =arr.length;
            while(l != r){
                    int mid = l + (r-l)/2;
                    if (arr[mid].compareTo(target) <= 0)
                        l = mid + 1;
                    else
                        r = mid;
                }

            return l;
        }

    // 二分查找法, 在一個有序數組arr中, 尋找小於等於target的元素的最大索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回 -1
    public static int lastLessOrEqual(Comparable[] arr,Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");

            int l = -1,r =arr.length-1;
            while(l != r){
                    int mid = l + (r-l+1)/2;
                    if (arr[mid].compareTo(target) > 0)
                        r = mid - 1;
                    else
                       l = mid;
                }

            return l;
        }

    // 二分查找法, 在一個有序數組arr中, 尋找小於target的元素的最大索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回 -1
    public static int lastLessThan(Comparable[] arr, Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");

                int l = -1,r =arr.length-1;
            while(l != r){
                    int mid = l + (r-l+1)/2;
                    if (arr[mid].compareTo(target) >= 0)
                        r = mid - 1;
                    else
                        l = mid;
                }

            return l;

        }
}
