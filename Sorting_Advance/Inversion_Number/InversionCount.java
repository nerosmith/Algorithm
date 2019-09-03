package com.nero.main.java.algrorithm.Sorting_Advance.Inversion_Number;

import com.nero.main.java.algrorithm.SortTestHelper.SortTestHelper;

import java.util.Arrays;

// merge函數求出在arr[l...mid]和arr[mid+1...r]有序的基礎上, arr[l...r]的逆序數對個數
public class InversionCount {

    private static long merge(Comparable[] arr,int l,int mid,int r){
            Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

            // 初始化逆序數對個數 res = 0
            long res = 0L;

            // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
            int i = l, j = mid+1;
            for (int k = l; k <= r ; k++) {
                    // 如果左半部分元素已經全部處理完畢
                    if (i > mid){
                            arr[k] = aux[j-l];
                            j++;
                        }
                    // 如果右半部分元素已經全部處理完畢
                    else if (j > r){
                            arr[k] = aux[i-l];
                            i ++;
                        }
                    // 左半部分所指元素 <= 右半部分所指元素
                    else if ( aux[i-l].compareTo(aux[j-l]) <= 0){
                            arr[k] = aux[i-l];
                            i ++;
                        }
                    // 右半部分所指元素 < 左半部分所指元素
                    else {
                            arr[k] = aux[j-l];
                            j ++;
                         // 此時, 因為右半部分k所指的元素小
                         // 這個元素和左半部分的所有未處理的元素都構成了逆序數對
                         // 左半部分此時未處理的元素個數為 mid - j + 1
                            res += (long)(mid - i + 1);
                      }
                }
            return res;
        }

    public static long solve(Comparable[] arr){
            int n =  arr.length;
            return solve(arr,0,n-1);
        }

    // 求arr[l..r]範圍的逆序數對個數
    private static long solve(Comparable[] arr,int l,int r){
            if (l >= r)
                return 0L;

            int mid = l + (r-l)/2;
            // 求出 arr[l...mid] 範圍的逆序數
            long res  = solve(arr,l,mid);
            // 求出 arr[mid+1...r] 範圍的逆序數
            long res2 = solve(arr,mid+1,r);

            return res+res2+merge(arr,l,mid,r);
        }

    public static void main(String[] args) {
                int N = 5;

                // 測試1: 測試隨機數組
                Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
                System.out.println("Test Inversion Count for Random Array, n = " + N + " :" + solve(arr) );

                // 測試2: 測試完全有序的數組
                // 結果應該為0
                arr = SortTestHelper.generateNearlyOrderedArray(N,0);
                System.out.println("Test Inversion Count for Ordered Array, n = " + N + " :" + solve(arr) );

                // 測試3: 測試完全逆序的數組
                // 結果應改為 N*(N-1)/2
                arr = SortTestHelper.generateInversedArray(N);
                System.out.println("Test Inversion Count for Inversed Array, n = " + N + " :" + solve(arr) );
        }
}

