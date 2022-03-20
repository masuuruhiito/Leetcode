package com.shijianwei.main.Leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author SHI
 * @date 2022/3/20 15:37
 */
public class Code115_DiffSubsequence {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int pre = 1;
            for (int j = 1; j <= n; j++) {
                int cur = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += pre;
                }
                pre = cur;
            }
        }
        return dp[n];

//        ArrayList
//        ConcurrentHashMap
    }
}
