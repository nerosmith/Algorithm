package com.nero.main.java.algrorithm.Binary_Search_Tree.Predecessor_and_Successor_in_BST;

import java.util.ArrayList;

public class Main {

    // 打亂數組順序
    private static void shuffle(ArrayList arr) {
            for (int i = arr.size() - 1; i >= 0; i--) {
                int pos = (int) (Math.random() * (i + 1));
                Object t = arr.get(pos);
                arr.set(pos, arr.get(i));
                arr.set(i, t);
            }
        }

    // 測試二分搜索樹中的predecessor和successor兩個函數
    public static void main(String[] args) {
            // 生成 0 到 N-1 一共 N 個數字的數組
            int N = 1000;
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for( int i = 0 ; i < N ; i ++)
                nums.add(i);

            // 將數組中的數組亂序
            shuffle(nums);

            // 將這個N個數插入到二叉樹中
            BST<Integer, Integer> bst = new BST<>();
            for(Integer num: nums)
                bst.insert(num, num);

            // 測試前驅算法, 除了數字0沒有前驅, 每個數字x的前驅應該為x-1
            for(int i = 0 ; i < N ; i ++) {
                    if (i == 0) {
                        assert bst.predecessor(i) == null;
                        System.out.println("The predesessor of 0 is NULL");
                    } else {
                            assert bst.predecessor(i) == i - 1;
                            System.out.println("The predesessor of " + i + " is " + (i - 1));
                        }
                }

            System.out.println();

            // 測試後繼算法, 除了數字沒有N-1後繼, 每個數字x的後繼應該為x+1
                for(int i = 0 ; i < N ; i ++){
                    if( i == N-1 ){
                            assert bst.successor(i) == null;
                            System.out.println("The successor of " + i + " is NULL");
                        }
                    else{
                            assert bst.successor(i) == i+1;
                            System.out.println("The successor of " + i + " is " + (i+1));
                        }
                }
        }
}
