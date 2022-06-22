package com.shijianwei.main.exam.wangyi_0327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author SHI
 * @date 2022/4/14 18:53
 */
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader bu = new BufferedReader(new InputStreamReader(System.in));
        String s = bu.readLine();
        int m = Integer.valueOf(s.split(" ")[0]);
        int n = Integer.valueOf(s.split(" ")[0]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] str = bu.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.valueOf(str[j]);
            }
        }

        int[][] dp = new int[m][n];


        dp[0][0] = arr[0][0];
        for (int i = 1; i < dp.length; i++) {
            if (arr[i][0] == arr[i - 1][0]) {
                dp[i][0] = dp[i - 1][0] + 1;
            }else {
                dp[i][0] = dp[i - 1][0] + 2;
            }
        }
        for (int i = 1; i < dp[0].length; i++) {
            if (arr[0][i] == arr[0][i - 1]) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = dp[0][i - 1] + 2;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                int up = arr[i][j] == arr[i - 1][j] ? dp[i - 1][j] + 1 : dp[i - 1][j] + 2;
                int left = arr[i][j] == arr[i][j - 1] ? dp[i][j - 1] + 1 : dp[i][j - 1] + 2;
                int right;
                if (j == arr[0].length-1 || dp[i][j] == -1) {
                    right = Integer.MAX_VALUE;
                }else {
                    right = arr[i][j] == arr[i][j + 1] ? dp[i][j + 1] + 1 : dp[i][j + 1] + 2;
                }
                dp[i][j] = Math.min(up, Math.min(left, right));
            }
        }

        for (int[] ints : dp) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

}
