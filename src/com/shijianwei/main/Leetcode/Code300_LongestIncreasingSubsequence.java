package com.shijianwei.main.Leetcode;

import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/2/27 14:43
 *
 * 是用动态规划，dp[i]的值为以i位置为结尾的最长子串
 * dp[i] = nums[i-1]<nums[i]? dp[i-1]+1 : 或者i之前dp[i]最大的值
 */
public class Code300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0 ;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0 ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res ;
    }


}
