package com.shijianwei.main.exam.meituan.day202110;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/8/27 13:21
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long res = 0;
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums, 0, nums.length);

            for (int i = 0; i < n; i++) {
                res += Math.abs(nums[i] - (i + 1));
            }
            System.out.println(res);
        }
    }
}
