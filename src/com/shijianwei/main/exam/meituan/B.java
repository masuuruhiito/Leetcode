package com.shijianwei.main.exam.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/8/27 12:07
 */
public class B {
    static int[] ans;
    static {
        int[] nums = new int[500];
        int index = 0;
        for (int i = 100; i < 1000; i++) {
            int n = i;
            int n1 = n / 100;
            n %= 100;
            int n2 = n / 10;
            n %= 10;
            int n3 = n;
            if (Math.pow(n1, 3) + Math.pow(n2, 3) + Math.pow(n3, 3) == i) {
                nums[index++] = i;
            }
        }
        ans = Arrays.copyOf(nums, index + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            boolean have = false;
            for (int num : ans) {
                if (num >= m && num <= n) {
                    have = true;
                    System.out.println(num);
                }
            }
            if (!have) {
                System.out.println("no");
            }
        }

    }
}
