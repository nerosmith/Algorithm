package com.nero.main.java.algrorithm.Minimum_Span_Trees.Weighted_Graph;

public class Edge<Weight extends Number & Comparable> implements Comparable<Edge>{

    private int a,b; // 邊的兩個端點
    private Weight weight; // 邊的權值

    public Edge(int a,int b,Weight weight){
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

    public Edge(Edge<Weight> e){
            this.a = e.a;
            this.b = e.b;
            this.weight = e.weight;
        }

    public int v(){return a;} // 返回第一個端點
    public int w(){return b;} // 返回第二個端點
    public Weight wt(){return weight;} // 返回權值

    // 給定一個頂點, 返回另一個頂點
    public int other(int x){
            assert x == a || x == b;
            return x == a ? b : a;
        }

    // 輸出邊的訊息
    @Override
    public String toString() {
            return "" + a + "-" + b + ": " + weight;
        }

    // 邊之間的比較
    @Override
    public int compareTo(Edge that) {
            if (weight.compareTo(that.wt()) < 0)
                return -1;
            else if(weight.compareTo(that.wt()) > 0)
                return 1;
            else
                return 0;
        }
}
