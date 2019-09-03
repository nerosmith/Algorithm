package com.nero.main.java.algrorithm.Binary_Search_Tree.Lower_Bound_and_Upper_Bound_in_Binary_Search;

public class LinearSearch {

    // 線性查找法, 實現lower_bound
    // 即在一個有序數組arr中, 尋找大於等於target的元素的第一個索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回arr的元素個數 n
    public static int lower_bound(Comparable[] arr,Comparable target) {

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");

            for (int i = 0; i < arr.length; i++)
                if (arr[i].compareTo(target) >= 0)
                    return i;

            return arr.length;
        }

    // 線性查找法, 實現upper_bound
    // 即在一個有序數組arr中, 尋找大於target的元素的第一個索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回arr的元素個數 n
    public static int upper_bound(Comparable[] arr,Comparable target){
            if(arr == null)
                throw new IllegalArgumentException("arr can not be null.");

            for (int i = 0; i < arr.length; i++)
                if (arr[i].compareTo(target) > 0)
                  return i;

            return arr.length;
        }

}
