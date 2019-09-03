package com.nero.main.java.algrorithm.Binary_Search_Tree.Floor_and_Ceil_in_BST;

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

    // 測試二分搜索樹中的floor和ceil兩個函數
    public static void main(String[] args) {
            BST<Integer,Integer> bst = new BST<>();

            //將[0, N)之間的偶數保存在nums中
            int N = 1000;
            ArrayList<Integer> nums = new ArrayList<Integer>();
            for(int i = 0 ; i < N ; i += 2)
                nums.add(i);
            int minNum = nums.get(0);
            int maxNum = nums.get(nums.size()-1);

            // 將nums亂序處理
            shuffle(nums);

            // 向二分搜索樹中插入[0, N)之間的所有偶數
            for(Integer num: nums)
                bst.insert(num, num);

            // 對[0...N]區間裡的N+1個數, 調用二分搜索樹的floor和ceil, 查看其結果
            for( int i = 0 ; i < N ; i ++ ){
                    // 測試floor
                    Integer floorKey = bst.floor(new Integer(i));
                    if(i % 2 == 0){
                            if(i >= 0 && i < N) assert floorKey == i;
                            else if(i < 0)      assert floorKey == null;
                            else                assert floorKey == maxNum;
                        }
                    else{
                            if(i - 1 >= 0 && i - 1 < N) assert floorKey == i - 1;
                            else if(i - 1 < 0)          assert floorKey == null;
                            else                        assert floorKey == maxNum;
                        }

                    System.out.print( "The floor of " + i + " is ");
                    if( floorKey == null )
                        System.out.println("NULL");
                    else
                        System.out.println(floorKey);


                    // 測試ceil
                    Integer ceilKey = bst.ceil(new Integer(i));
                    if(i % 2 == 0) {
                            if( i >= 0 && i < N ) assert ceilKey == i;
                            else if(i < 0)        assert ceilKey == minNum;
                            else                  assert ceilKey == null;
                        }
                    else{
                            if(i + 1 >= 0 && i + 1 < N) assert ceilKey == i + 1;
                            else if(i + 1 < 0)          assert ceilKey == minNum;
                            else                        assert ceilKey == null;
                        }

                    System.out.print( "the ceil of " + i + " is ");
                    if( ceilKey == null )
                        System.out.println("NULL");
                    else
                        System.out.println(ceilKey);

                    System.out.println();
                }
        }
}
