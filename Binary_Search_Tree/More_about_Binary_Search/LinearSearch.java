package com.nero.main.java.algrorithm.Binary_Search_Tree.More_about_Binary_Search;

public class LinearSearch {

    // 線性查找法, 在一個有序數組arr中, 尋找大於等於target的元素的第一個索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回arr的元素個數 n
    // 相當於 lower_bound
    public static int firstGreaterOrEqual(Comparable[] arr,Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");

            for (int i = 0; i < arr.length; i++)
                if (arr[i].compareTo(target) >= 0)
                    return i;

            return arr.length;
        }


    // 線性查找法, 在一個有序數組arr中, 尋找大於target的元素的第一個索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回arr的元素個數 n
    // 相當於 upper_bound
    public static int firstGreaterThan(Comparable[] arr,Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");
            for (int i = 0; i < arr.length; i++)
                if (arr[i].compareTo(target) > 0)
                    return i;

            return arr.length;
        }

    // 線性查找法, 在一個有序數組arr中, 尋找小於等於target的元素的最大索引
    // 如果存在, 則返回相應的索引index
    // 否則, 返回 -1
    public static int lastLessOrEqual(Comparable[] arr,Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");

            for (int i = 0; i < arr.length; i++)
                if (arr[i].compareTo(target) > 0)
                    return i -1;

            return arr.length - 1;
        }

    // 線性查找法, 在一個有序數組arr中, 尋找小於target的元素的最大索引
    // 如果存在, 則返回相應的索引index
    //否則，返回-1
    public static int lastLessThan(Comparable[] arr, Comparable target){

            if (arr == null)
                throw new IllegalArgumentException("arr can not be null.");
            for (int i = 0; i < arr.length; i++)
                if (arr[i].compareTo(target) >= 0)
                    return i -1;

            return arr.length - 1;
        }
}
