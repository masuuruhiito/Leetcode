package com.shijianwei.main.Leetcode;

import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/1/17 16:27
 * <p>
 * 977. 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Code977 {

    //    时间复杂度超限
    public static int[] sortedSquares(int[] nums) {
        int[] numsp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsp[i] = nums[i] * nums[i];
        }
        Arrays.sort(numsp);
        return numsp;
    }


    //    使用双指针进行优化，将时间复杂度降低到o（n）级别
    public static int[] sortedSquares1(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                index = i;
                flag = true;
                break;
            }
        }
        if (!flag) {
            index = nums.length;
        }
        int i = index - 1, j = index, k = 0;
        while (i >= 0 && j <= nums.length - 1) {
            res[k++] = -nums[i] > nums[j] ? nums[j] * nums[j++] : nums[i] * nums[i--];
        }
        while (i >= 0) {
            res[k++] = nums[i] * nums[i--];
        }
        while (j <= nums.length - 1) {
            res[k++] = nums[j] * nums[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-5, -3, -2, -1};
        int[] b = sortedSquares1(a);
        for (int i : b) {
            System.out.println(i);
        }
    }
}