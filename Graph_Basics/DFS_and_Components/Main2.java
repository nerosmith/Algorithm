package com.nero.main.java.algrorithm.Graph_Basics.DFS_and_Components;

import com.nero.main.java.algrorithm.Graph_Basics.Read＿Graph.ReadGraph;
import com.nero.main.java.algrorithm.Graph_Basics.SparseGraph;

public class Main2 {
    public static void main(String[] args) {

        // TestG1.txt
        String filename = "C:/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1,filename);
        Components components1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: "+components1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "C:/testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2,filename2);
        Components components2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: "+components2.count());
    }
}
