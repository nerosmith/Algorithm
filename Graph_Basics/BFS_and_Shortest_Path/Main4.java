package com.nero.main.java.algrorithm.Graph_Basics.BFS_and_Shortest_Path;

import com.nero.main.java.algrorithm.Graph_Basics.Finding_a_Path.Path;
import com.nero.main.java.algrorithm.Graph_Basics.Read＿Graph.ReadGraph;
import com.nero.main.java.algrorithm.Graph_Basics.SparseGraph;

// 測試無權圖最短路徑算法
public class Main4 {
      public static void main(String[] args) {
            String filename = "C:/testG.txt";
            SparseGraph g1 = new SparseGraph(7, false);
            ReadGraph readGraph1 = new ReadGraph(g1,filename);
            g1.show();

            // 比較使用深度優先遍歷和廣度優先遍歷獲得路徑的不同
            // 廣度優先遍歷獲得的是無權圖的最短路徑
            Path dfs = new Path(g1,0);
            System.out.print("DFS : ");
            dfs.showPath(6);

            ShortestPath bfs = new ShortestPath(g1,0);
            System.out.print("BFS : ");
            bfs.showPath(6);
            System.out.println();

            filename = "C:/testG1.txt";
            SparseGraph g2 = new SparseGraph(13, false);
            ReadGraph readGraph2 = new ReadGraph(g2,filename);
            g2.show();

            // 比較使用深度優先遍歷和廣度優先遍歷獲得路徑的不同
            // 廣度優先遍歷獲得的是無權圖的最短路徑
            Path dfs2 = new Path(g2,0);
            System.out.print("DFS : ");
            dfs2.showPath(3);

            ShortestPath bfs2 = new ShortestPath(g2,0);
            System.out.print("BFS : ");
            bfs2.showPath(3);
         }
    }
