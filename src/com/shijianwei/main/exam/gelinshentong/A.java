package com.shijianwei.main.exam.gelinshentong;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/10/8 22:33
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 1};
        System.out.println(getMax(nums));
    }

    public static int getMax(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 由于有先递增后递减的规律，那么就代表最大值一定是大于左边的值，并且大于右边的值
        // 并且时间复杂度小于n，那么可以使用二分的方式进行计算判断
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            int midL = mid;
            int midR = mid;
            while (midL > l && nums[mid] == nums[midL - 1]) {
                midL--;
            }
            while (midR < r && nums[midR + 1] == nums[mid]) {
                midR++;
            }
            if (midL == l && midR == r) {
                return nums[mid];
            } else if (midL == l) {
                if (nums[midR] > nums[midR + 1]) {
                    return nums[mid];
                } else {
                    l = midR + 1;
                }
            } else if (midR == r) {
                if (nums[midL] > nums[midL - 1]) {
                    return nums[mid];
                } else {
                    r = midL - 1;
                }
            } else {
                if (nums[midL] > nums[midL - 1] && nums[midR] > nums[midR + 1]) {
                    return nums[mid];
                } else if (nums[midL] > nums[midL - 1]) {
                    l = midR + 1;
                } else if (nums[midR] > nums[midR + 1]) {
                    r = midL - 1;
                }else {
                    throw new RuntimeException("原数组数据错误，请修改数据并重新尝试");
                }
            }
        }
        return nums[l];
    }
}
