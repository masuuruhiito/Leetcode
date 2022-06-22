package com.shijianwei.main.Leetcode;

import jdk.nashorn.internal.ir.IfNode;
import lombok.AllArgsConstructor;

import java.util.*;

/**
 * @author SHI
 * @date 2022/4/5 13:44
 */
public class Code62_DifferentPaths {

    /**
     * 求出不同路径可以使用dfs每次直接遍历到end point，然后结果+1
     *
     * 时间长不写算法了，记录一下手生，md简单题都不会了
     *
     * 首先：递归的时候，不只是最后一个节点的值为1，最后一条边都是1，也都只有一条回到终点的路线
     * 其次：因为初始值为0，那么结束条件应该为m-1
     *
     * 注意，因为每次都递归对时间消耗太大，所以会超时
     * 但是可以去使用一个缓存来降低时间复杂度
     *
     *  咋反倒通过的样例更少了呢,理论上是可以的啊应该
     *
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return dfs(new HashMap<>(), 0, 0, m, n);
    }

    public int dfs(Map<Node, Integer> map, int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1) {
            return 1;
        }
        Node node = new Node(i, j);
        if (map.containsKey(node)) {
            return map.get(node);
        }else {
            map.put(node, dfs(map, i + 1, j, m, n) + dfs(map, i, j + 1, m, n));
        }
        return map.get(node);
    }

    class Node{
        int v1 ;
        int v2 ;

        public Node(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return v1 == node.v1 &&
                    v2 == node.v2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v1, v2);
        }
    }


    /**
     * 可以使用dp每次计算该节点的可行路径数，第一列第一排都为0
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i + 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }



    /**
     * 对dp进行空间优化：
     *      因为本题，只需要上一行的数据和前一个数据，那么就可以使用一个一维数组，
     *      两层遍历，每个节点的值等于前一个节点加上本节点的值，
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

}
