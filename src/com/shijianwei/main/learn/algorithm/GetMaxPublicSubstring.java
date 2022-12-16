package com.shijianwei.main.learn.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author SHI
 * @date 2022/8/1 20:52
 */
public class GetMaxPublicSubstring {
    public static void main(String[] args) {
        getMaxPublicSubstring("asdb", "sd");
        violence("asdb", "sd");
    }

    /**
     * 设置dp数组，
     * 首先写dp递推表达式：
     *      dp[i][j] 代表以i，j为尾的字符串的最长公共子串的长度
     *      dp[i][j] = dp[i][j]
     * @param str1
     * @param str2
     */
    public static void getMaxPublicSubstring(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 0; i < chars1.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < chars2.length + 1; i++) {
            dp[0][i] = 0;
        }

        int max = 0;
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                if (max == ints[j]) {
                    System.out.println(str2.substring(j - max, max));
                }
            }
        }
    }

    public static void violence(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return;
        }
        if (str2.length() > str1.length()) {
            String tmp = str1;
            str1 = str2;
            str2 = tmp;
        }
        HashSet<String> sub1 = getAllSubString(str1);
        HashSet<String> sub2 = getAllSubString(str2);
        String maxSub = "";
        for (String s : sub2) {
            if (sub1.contains(s)) {
                maxSub = maxSub.length() >= s.length() ? maxSub : s;
            }
        }
        System.out.println(maxSub);
    }

    public static HashSet<String> getAllSubString(String str) {
        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = 0; j < str.length(); j++) {
//                set.add(str.substring(i, j));
//            }
//        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                set.add(str.substring(i, j + 1));
            }
        }
        return set;
    }
}
