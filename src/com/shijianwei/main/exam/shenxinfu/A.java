package com.shijianwei.main.exam.shenxinfu;

/**
 * @author SHI
 * @date 2022/9/16 19:32
 */
public class A {
    public int minDistance (String a, String b) {
        // write code here
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        if (s1.length * s1.length == 0) {
            return s1.length + s2.length;
        }
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i < s1.length + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < s2.length + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                int left = dp[i - 1][j] + 1;
                int down = dp[i][j - 1] + 1;
                int leftDown = dp[i - 1][j - 1];

                if (s1[i - 1] != s2[j - 1]) {
                    leftDown += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[s1.length][s2.length];
    }
}
