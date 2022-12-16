package com.shijianwei.main.exam.baidu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/13 20:13
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        int[] nums = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = Arrays.stream(nums).sum();
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 0;
        f[2] = 0;

        int[] cur = new int[n];
        System.arraycopy(nums, 0, cur, 0, n);
        for (int i = 3; i <= n; i++){
            int f1 = f[i - 1] + Math.min(nums[i - 1] / 3, Math.min(cur[i - 2] / 2, cur[i - 3] / 3));
            int f2 = f[i - 2] + Math.min(nums[i - 1] / 3, Math.min(nums[i - 2] / 2, cur[i - 3] / 3));
            int f3 = f[i - 3] + Math.min(nums[i - 1] / 3, Math.min(nums[i - 2] / 2, nums[i - 3] / 3));
            int tmp = 0;
            if (f1 >= f2 && f1 >= f3) {
                tmp = Math.min(nums[i - 1] / 3, Math.min(cur[i - 2] / 2, cur[i - 3] / 3));
                f[i] = f1;
            } else if (f2 >= f1 && f2 >= f3) {
                tmp = Math.min(nums[i - 1] / 3, Math.min(nums[i - 2] / 2, cur[i - 3] / 3));
                f[i] = f2;
            }else {
                tmp = Math.min(nums[i - 1] / 3, Math.min(nums[i - 2] / 2, nums[i - 3] / 3));
                f[i] = f2;
            }
            cur[i - 1] -= 3 * tmp;
            cur[i - 2] -= 2 * tmp;
            cur[i - 3] -= tmp;
        }

        System.out.println(sum - f[n]);
    }
}
