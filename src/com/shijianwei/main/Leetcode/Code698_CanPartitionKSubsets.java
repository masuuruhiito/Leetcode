package com.shijianwei.main.Leetcode;

import javafx.scene.chart.BubbleChart;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedMap;

/**
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4], k = 3
 * 输出: false
 *
 * @author SHI
 * @date 2022/4/22 14:00
 */
public class Code698_CanPartitionKSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }

        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - 1 - i] = tmp;
        }
        int ar = sum / k;
        int[] coll = new int[k];
        return backTrack(nums, coll, ar, 0);
    }

    private boolean backTrack(int[] nums, int[] coll, int target, int i) {
        if (i == nums.length) {
            return true;
        }
        for (int j = 0; j < coll.length; j++) {
            if (nums[i] + coll[j] > target) {
                continue;
            }
            coll[j] += nums[i];

            if (backTrack(nums, coll, target, i + 1)) {
                return true;
            }

            coll[j] -= nums[i];

            if (coll[i] == 0) {
                break;
            }
        }
        return false;
    }


}
