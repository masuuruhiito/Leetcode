package com.shijianwei.main.exam.didi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/4 19:30
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);
        long[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(nums);
        long sum = Arrays.stream(nums).sum();
        for (int i = nums.length - 1; i >= 0; i--) {
            double target = 1.0 * sum / (i + 1);
            if (nums[i] <= target * k) {
                System.out.println(i + 1);
                return;
            }
            sum -= nums[i];
        }
    }
}
