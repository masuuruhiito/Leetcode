package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/9/18 18:41
 */
public class Code416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if (sum % 2 == 1) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][(sum / 2) + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (nums[i] >= j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum / 2];
    }
}
