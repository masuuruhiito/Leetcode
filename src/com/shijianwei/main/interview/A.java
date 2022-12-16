package com.shijianwei.main.interview;

/**
 * @author SHI
 * @date 2022/10/17 15:26
 */
public class A {
    public static int getLen(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0) {
            return str1.length() == 0 ? str2.length() : str1.length();
        }
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        int[][] dp = new int[c1.length + 1][c2.length + 1];
        // 初始化行列
        for (int i = 0; i <= c1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= c2.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                int up = dp[i - 1][j];
                int left = dp[i][j - 1];
                int leftUp = dp[i - 1][j - 1];
                dp[i][j] = c1[i - 1] == c2[j - 1] ? leftUp : Math.min(up, left) + 1;
            }
        }
        return dp[c1.length][c2.length];
    }

    public static void main(String[] args) {
        System.out.println(getLen("str1", "str3"));
    }
}
