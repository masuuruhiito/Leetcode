package com.shijianwei.main.exam.kedaxunfei;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/10/9 19:52
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] nums = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = nums[i][j] + 2 * sc.nextInt() - 255;
                nums[i][j] = Math.max(0, Math.min(tmp, 255));
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }


//    public static void add(int a, int b) {
//
//    }
//
//    double add(double a, double b) {
//
//    }
}
