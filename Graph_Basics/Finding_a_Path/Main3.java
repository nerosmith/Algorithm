package com.nero.main.java.algrorithm.Graph_Basics.Finding_a_Path;

import com.nero.main.java.algrorithm.Graph_Basics.Read＿Graph.ReadGraph;
import com.nero.main.java.algrorithm.Graph_Basics.SparseGraph;

public class Main3 {
    public static void main(String[] args) {
            String filename = "C:/testG.txt";
            SparseGraph g = new SparseGraph(7, false);
            ReadGraph readGraph = new ReadGraph(g,filename);
            g.show();
            System.out.println();

            Path path = new Path(g,0);
            System.out.println("Path from 0 to 6 : ");
            path.showPath(6);
        }
}
