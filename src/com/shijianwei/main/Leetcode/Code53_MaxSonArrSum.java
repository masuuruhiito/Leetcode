package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/29 15:09
 */
public class Code53_MaxSonArrSum {
    /**
     * 返回最大子数和
     * 可以将
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = nums[0];
//        dp中保存的是每个位置之前的最大值
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int max = 0 ;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, max);
            }
        }
        return res;
    }
}
