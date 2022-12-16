package com.shijianwei.main.exam.haoweilai;

/**
 * @author SHI
 * @date 2022/9/8 19:54
 * <p>
 * "newcoder","nowcoder"
 * [0, 0, 0, 0, 0, 0, 0, 0, 0]
 * [0, 1, 1, 1, 1, 1, 1, 1, 1]
 * [0, 1, 1, 1, 1, 1, 1, 2, 2]
 * [0, 1, 1, 2, 2, 2, 2, 2, 2]
 * [0, 1, 1, 2, 3, 3, 3, 3, 3]
 * [0, 1, 2, 2, 3, 4, 4, 4, 4]
 * [0, 1, 2, 2, 3, 4, 5, 5, 5]
 * [0, 1, 2, 2, 3, 4, 5, 6, 6]
 * [0, 1, 2, 2, 3, 4, 5, 6, 7]
 */
public class A {
    public static String LCS(String str1, String str2) {
        // write code here
        StringBuilder res = new StringBuilder();
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return res.toString();
        }
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < str2.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        if (dp[str1.length()][str2.length()] == 0) {
            return "-1";
        }

        int i = dp.length - 1, j = dp[0].length - 1;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j - 1] == dp[i - 1][j] && dp[i - 1][j] == dp[i][j - 1]) {
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                j--;
            } else if (i > j) {
                i--;
            }else {
                j--;
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(LCS("abcdef", "afcdec"));
    }
}
