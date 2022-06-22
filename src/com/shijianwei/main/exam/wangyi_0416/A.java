package com.shijianwei.main.exam.wangyi_0416;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/4/16 14:51
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        print(n);
    }

    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(".");
            }
            for (int j = 0; j < (n + i) * (2); j++) {
                System.out.print("*");
            }
            for (int j = i; j < n; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
        for (int i = 0; i < 2 * n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < 2 * n; j++) {
                System.out.print(".");
            }
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i > 0; i--) {
            for (int j = i; j <= n; j++) {
                System.out.print(".");
            }
            for (int j = 0; j < 2*(n+i-1); j++) {
                System.out.print("*");
            }
            for (int j = i; j <= n; j++) {
                System.out.print(".");
            }
            System.out.println();
        }
    }
}
