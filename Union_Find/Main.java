package com.nero.main.java.algorithm.Union_Find;

public class Main {
    public static void main(String[] args) {
        int n = 100000;

        // 雖然isConnected只需要O(1)的時間, 但由於union操作需要O(n)的時間
        // 總體測試過程的算法複雜度是O(n^2)的
        UnionFindTestHelper.testUF1(n);

        // 對於UF2來說, 其時間性能是O(n*h)的, h為並查集表達的樹的最大高度
        // 這裡嚴格來講, h 和 logn 沒有關係, 但總體來說 h < n
        // 由於UF2樹的平衡的概率是不能保證的,所以性能上不一定能比 UF1 好上多少
        UnionFindTestHelper.testUF2(n);

        // 對於UF3來說, 其時間性能依然是O(n*h)的, h為並查集表達的樹的最大高度
        // 但由於UF3能更高概率的保證樹的平衡, 所以性能更優
        UnionFindTestHelper.testUF3(n);

        // UF4雖然相對UF3進行有了優化, 但優化的地方出現的情況較少,
        // 所以性能更優表現的不明顯, 甚至在一些數據下性能會更差
        UnionFindTestHelper.testUF4(n);
    }
}
