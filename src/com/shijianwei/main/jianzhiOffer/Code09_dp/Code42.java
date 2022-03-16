package com.shijianwei.main.jianzhiOffer.Code09_dp;

/**
 * @author SHI
 * @date 2022/2/5 15:41
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Code42 {
    public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0) return Integer.MIN_VALUE;
        int res= nums[0] ;
        for (int i = 1; i < nums.length; i++) {
//            将nums每个位置的值变为当前位置及前面的最大和
            nums[i] += Math.max(nums[i-1],0);
//            算出每个位置之后还要将前面最大的值记录下来
            res = Math.max(nums[i],res);
        }
        return res;
    }

    public static void main(String[] args) {
        int []a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
}
