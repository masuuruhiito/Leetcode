package com.shijianwei.main.exam.exam360;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/9 16:20
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim().split(" ")[0]);
        int[] nums = Arrays.stream(sc.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        long res = 0;
        res += Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                res += nums[i] | nums[j

                        ];
            }
        }
        System.out.println(res);
    }
}
