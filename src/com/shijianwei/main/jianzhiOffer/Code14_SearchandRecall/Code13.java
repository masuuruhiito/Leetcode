package com.shijianwei.main.jianzhiOffer.Code14_SearchandRecall;

import javafx.scene.media.VideoTrack;

/**
 * @author SHI
 * @date 2022/2/8 13:12
 * 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 由于机器人每次只能移动一格（即只能从 xx 运动至 x \pm 1x±1），因此每次只需计算 xx 到 x \pm 1x±1 的数位和增量。本题说明 1 \leq n,m \leq 1001≤n,m≤100 ，以下公式仅在此范围适用。
 *
 * 以下代码为增量公式的三元表达式写法，将整合入最终代码中。

 * (i+1)%10==0?s1-8:s1+1
 *
 */
public class Code13 {
    private int m , n , k  ;
    private boolean [][]visit ;//用于判断该点是否被遍历过
//    首先对于这个来说需要从顶点开始，判断每个节点是否
    public int movingCount(int m, int n, int k) {
        this.m = m ;
        this.n = n ;
        this.k = k ;
        visit = new boolean[m][n];
        return dfs(0,0,0,0);
    }

//    这种是只找出可用的，所以为dfs
    public int dfs(int i , int j , int s1 , int s2 ){
//        先写鲁棒
        if(i<0||j<0||i>m-1||j>n-1||s1+s2>k||visit[i][j]) return 0;
        visit[i][j] = true;
        return 1+dfs(i+1,j,(i+1)%10==0?s1-8:s1+1,s2)+dfs(i,j+1,s1,(j+1)%10==0?s2-8:s2+1);
    }

//    bfs将
    public int bfs(int i , int j , int s1 , int s2 ){
//        先写鲁棒
        if(i<0||j<0||i>m-1||j>n-1||s1+s2>k||visit[i][j]) return 0;
        visit[i][j] = true;
        return 1+dfs(i+1,j,(i+1)%10==0?s1-8:s1+1,s2)+dfs(i,j+1,s1,(j+1)%10==0?s2-8:s2+1);
    }

}
