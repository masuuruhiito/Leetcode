package com.shijianwei.main.exam.alibaba20220315;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/3/14 19:28
 *
 *
 * 2 4
 * 0 1 0 0
 * 1 0 1 0
 *
 * 题目：
 *      小红拿到了一个几 行 m 列的矩阵，矩阵中用
 *      1 表示人，O表示聚光灯。每个聚光灯可以朝着上、下、左、右四个方向照射 (照射的距离是无穷大的)，
 *      若某个方向上至少有一个人，那么小红就获得了1分。
 *      小红想知道，所有的聚光灯一共可以获得多少分？
 *      （注意：本题的输入数据较大，使用python的同学请用pypy提交，否则可能会超时！）
 *      输入描述:
 *          第一行两个整数 n, m(1 ≤n, m ≤ 1103)
 *          接下来n行，每行m个整数,ai,j用来表示矩阵中的位置是人还是聚光灯
 *          (0 ≤ az,j<1)
 *      输出描述:
 *          输出一行，一个整数表示这些灯的分数总和。
 *
 *
 *
 * 思路：可以遍历每个节点，查看每个节点的上下左右是否为1，有就cnt++，但时间复杂度比较高
 *
 *      也可以分别按照行列来找，每次遍历一行的时候先判断有没有1，先找1的左边有几个0，
 *                          然后找1的右边有几个0 然后++，列同理，只需要每行每列遍历两边
 *
 *      而方法一对每个0都需要进行遍历，
 *
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][]s = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < m; j++) {
                if (s[i][j] ==1  ) flag = true ;
                else if (flag) ans ++ ;
            }
            flag = false;
            for (int j = m-1 ; j >=0 ; j--) {
                if (s[i][j] ==1 ) flag = true ;
                else if (flag) ans ++ ;
            }
        }
        for (int i = 0; i < m; i++) {
            boolean flag = false ;
            for (int j = 0; j < n; j++) {
                if (s[j][i] ==1 ) flag = true ;
                else if (flag) ans++ ;
            }
            flag = false;
            for (int j = n-1; j >=0  ; j--) {
                if (s[j][i] ==1 ) flag = true ;
                else if (flag) ans++ ;
            }
        }
        System.out.println(ans);
    }
}
