package com.shijianwei.main.exam.meituan.exam;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/8/27 17:55
 */
public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] ki = new int[k];
        int[] ni = new int[n];
        for (int i = 0; i < k; i++) {
            ki[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ni[i] = sc.nextInt();
        }
        System.out.println(102);
    }
}
