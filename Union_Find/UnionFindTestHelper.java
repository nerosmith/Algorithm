package com.nero.main.java.algrorithm.Union_Find;

import com.nero.main.java.algrorithm.Union_Find.Optimize_by_Rank.UnionFind4;
import com.nero.main.java.algrorithm.Union_Find.Optimize_by_Size.UnionFind3;
import com.nero.main.java.algrorithm.Union_Find.Path_Compression.UnionFind5;
import com.nero.main.java.algrorithm.Union_Find.Quick_Find.UnionFind;
import com.nero.main.java.algrorithm.Union_Find.Quick_Find.UnionFind2;
import com.nero.main.java.algrorithm.Union_Find.Same_Cases_Test_for_UF.Pair;
import com.nero.main.java.algrorithm.Union_Find.Same_Cases_Test_for_UF.UF;
import com.nero.main.java.algrorithm.Union_Find.Same_Cases_Test_for_UF.UnionFind6;

public class UnionFindTestHelper {

    // 測試第一版本的並查集,測試元素個數為 n
    public static void testUF1(int n){
             UnionFind uf = new UnionFind(n);
             long startTime = System.currentTimeMillis();

            // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.unionElements(a,b);
                }

            // 再進行 n 次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.isConnected(a,b);
                }

            long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF1, " + 2*n + " ops, " + (endTime-startTime)+ "ms");
        }

    // 測試第二版本的並查集,測試元素個數為 n
    public static void testUF2(int n){
            UnionFind2 uf = new UnionFind2(n);
            long startTime = System.currentTimeMillis();

            // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.unionElements(a,b);
                }

            // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
            for (int i = 0; i < n; i++) {
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.isConnected(a,b);
                }

            long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF2, " + 2*n + " ops, " + (endTime-startTime) + "ms");
        }

    // 測試第三版本的並查集,測試元素個數為 n
    public static void testUF3(int n){
        UnionFind3 uf = new UnionFind3(n);
        long startTime = System.currentTimeMillis();

        // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
        for (int i = 0; i < n; i++) {
                int a = (int)(Math.random()*n);
                int b = (int)(Math.random()*n);
                uf.unionElements(a,b);
            }

        // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
        for (int i = 0; i < n; i++) {
                int a = (int)(Math.random()*n);
                int b = (int)(Math.random()*n);
                uf.isConnected(a,b);
            }

        long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF3, " + 2*n + " ops, " + (endTime-startTime)+ "ms");
        }

    // 測試第三版本的並查集,測試元素個數為 n
    public static void testUF4(int n){
            UnionFind4 uf = new UnionFind4(n);
            long startTime = System.currentTimeMillis();

            // 進行 n 次操作, 每次隨機選擇兩個元素進行合併操作
            for (int i = 0; i < n; i++) {
                int a = (int)(Math.random()*n);
                int b = (int)(Math.random()*n);
                uf.unionElements(a,b);
            }

            // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
            for (int i = 0; i < n; i++) {
                int a = (int)(Math.random()*n);
                int b = (int)(Math.random()*n);
                uf.isConnected(a,b);
            }

            long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF4, " + 2*n + " ops, " + (endTime-startTime)+ "ms");
        }

    // 測試第五版本的並查集, 測試元素個數為n, 測試邏輯和之前是完全一樣的
    public static void testUF5( int n ){

            UnionFind5 uf = new UnionFind5(n);

            long startTime = System.currentTimeMillis();

            // 進行n次操作, 每次隨機選擇兩個元素進行合併操作
            for( int i = 0 ; i < n ; i ++ ){
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.unionElements(a,b);
                }

                // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
            for(int i = 0 ; i < n ; i ++ ){
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.isConnected(a,b);
                }
            long endTime = System.currentTimeMillis();

            // 打印輸出對這2n個操作的耗時
            System.out.println("UF5, " + 2*n + " ops, " + (endTime-startTime) + "ms");
        }

    // 測試第六版本的並查集, 測試元素個數為n, 測試邏輯和之前是完全一樣的
    public static void testUF6( int n ){

            UnionFind6 uf = new UnionFind6(n);

            long startTime = System.currentTimeMillis();

            // 進行n次操作, 每次隨機選擇兩個元素進行合併操作
            for( int i = 0 ; i < n ; i ++ ){
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.unionElements(a,b);
                }
            // 再進行n次操作, 每次隨機選擇兩個元素, 查詢他們是否同屬一個集合
            for(int i = 0 ; i < n ; i ++ ){
                    int a = (int)(Math.random()*n);
                    int b = (int)(Math.random()*n);
                    uf.isConnected(a,b);
                }
                long endTime = System.currentTimeMillis();

            // 打印输出对这2n个操作的耗时
            System.out.println("UF6, " + 2*n + " ops, " + (endTime-startTime) + "ms");
        }

    public static void testUF(String ufName, UF uf, Pair<Integer,Integer>[] unionTest,Pair<Integer,Integer>[] connectTest){
            long startTime = System.currentTimeMillis();
            for( int i = 0 ; i < unionTest.length ; i ++ ){
                    int a = unionTest[i].a();
                    int b = unionTest[i].b();
                    uf.unionElements(a,b);
                }
            for(int i = 0 ; i < connectTest.length ; i ++ ){
                    int a = connectTest[i].a();
                    int b = connectTest[i].b();
                    uf.isConnected(a,b);
                }
            long endTime = System.currentTimeMillis();

            System.out.print( ufName + " with " + unionTest.length + " unionElements ops, ");
            System.out.print( connectTest.length + " isConnected ops, ");
            System.out.println( (endTime-startTime) + "ms");

        }
}
