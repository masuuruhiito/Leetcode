package com.shijianwei.main.Leetcode;

import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/3/2 10:45
 */
public class Code215_TheFirstKLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
