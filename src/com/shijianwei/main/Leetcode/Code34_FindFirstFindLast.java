package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/8/14 22:50
 *
 * 找到一个数据的下界，相当于找到下一个数据的上界-1
 */
public class Code34_FindFirstFindLast {
    public int[] searchRange(int[] nums, int target) {
        int l = findFirst(nums, target);
        int nextL = findFirst(nums, target + 1);
        if (l == nums.length || nums[l] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{l, nextL - 1};
    }

    public static int findFirst(int[] nums, int target) {
        int i = 0, j = nums.length;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] >= target) {
                j = mid;
            }else {
                i = mid + 1;
            }
        }
        return i;
    }
}
