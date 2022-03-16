package com.shijianwei.main.Nowcoder;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/3/8 12:27
 */
public class Code01_dp_minCost {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println(minCost("abc", "abcd", 5, 2, 3));

    }

    public static int minCost(String str1 , String str2 ,int ic , int dc ,int rc){
        int len1 = str1.length();
        int len2 = str2.length();

        int [][]dp = new int[len1+1][len2+1];

        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j * ic;
        }
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i * dc;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = min(dp[i - 1][j - 1] + rc, dp[i - 1][j] + dc, dp[i][j - 1] + ic);
            }
        }

        return dp[len1][len2];
    }


    public static int min(int i, int j, int k) {
        int res = i;
        res = res < j ? res : j;
        res = res < k ? res : k;
        return res ;
    }

}
