package com.shijianwei.main.exam.wangyi_0327;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/4/14 18:09
 *
 * a b
 * dp[i] = dp[i-1] + dp[i-2]
 */
public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int x = s.nextInt();
        int y = s.nextInt();

        int[] dp1 = new int[a];
        int[] dp2 = new int[b];
        int i = 0, j = 0;
        dp1[0] = a;
        dp2[1] = b;

        while (dp1[i] <= 0 && dp2[j] <= 0) {

        }
    }
}
