package com.shijianwei.main.Leetcode;

import org.junit.Test;

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


    /**
     * 采用上面dp的思想，看我是不是还会这个，也是看一下是不是真的学懂了
     *
     * dp[i] = nums[i-1]<nums[i]? dp[i-1]+1 : 或者i之前dp[i]最大的值
     *
     * 经实践，发现这个方法是错误的，因为如果出现[4,10,4,3,8,9] 3处应该重新计算值，而不是用之前最大的值
     *
     * @param nums
     * @return 返回最长递增子序列的length
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
//        是用动态规划，dp[i]的值为以i位置为结尾的最长子串
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]){
                dp[i] = dp[i - 1] + 1;
            }else {
                int max = dp[0];
                for (int j = 1; j < i; j++) {
                    max = max>= dp[j] ? max : dp[j];
                }
                dp[i] = max;
            }
        }
        return dp[nums.length - 1];
    }


    @Test
    public void aa(){
        int []nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS4(nums));
    }


    /**
     * 这次仿原本的做法，将 dp[i] = Math.max()
     * @param nums
     * @return
     */
    public int lengthOfLIS3(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0 ;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }



    /**
     * 对3进行优化，因为3为on2的，外边循环的on不能改变，那可不可以从里面优化，
     *      原本在里层循环是顺序遍历每个数据，那能不能把里面循环换成我们新维护数组，
     *      保持这个数组总是有序的，然后就可以通过二分查找，查现在这个数据应该插在哪里
     *      然后返回插入新数组数据的个数就可以了
     * @param nums
     * @return
     */
    public int lengthOfLIS4(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        int res = 0 ;
        for (int i = 0; i < nums.length; i++) {
            int l = 0, r = res;
            while (l < r) {
                int mid = l+((r-l)>>1);
                if (dp[mid] > nums[i]) {
                    r = mid - 1;
                }else {
                    l = mid ;
                }
            }
//            退出时，l == r 为插入位置，
            dp[l] = nums[i];
            if (r == res) res++ ;
        }
        return res;
    }

}
