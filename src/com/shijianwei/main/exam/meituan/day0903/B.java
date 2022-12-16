package com.shijianwei.main.exam.meituan.day0903;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/3 9:57
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int mex = getMex(nums);
        for (int i = 0; i < n; i++) {
            System.out.println(Math.min(mex, nums[i]));
        }
    }

    public static int getMex(int[] nums) {
        int[] cp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(cp);
        int i = 0;
        int j = cp.length - 1;
        while (j > i) {
            int mid = i + ((j - i) >> 1);
            if (cp[mid] > mid) {
                j = mid;
            } else if (cp[mid] == mid) {
                i = mid + 1;
            }
        }
        if (i == 0) {
            return cp[i] == 0 ? cp[cp.length - 1] + 1 : 0;
        }else {
            return cp[i - 1] + 1;
        }
    }
}
