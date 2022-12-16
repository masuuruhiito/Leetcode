package com.shijianwei.main.exam.ant;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/27 19:24
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 3) {
            System.out.println(-1);
            return;
        }
        if (!isZhishu(n)) {
            System.out.print(n + " ");
            for (int i = 1; i < n; i++) {
                System.out.print(i + " ");
            }
        }else {
            if (n >= 11) {
                System.out.print(9 + " ");
                for (int i = 1; i < n; i++) {
                    if (i == 9) {
                        System.out.print(n + " ");
                    }else {
                        System.out.print(i + " ");
                    }
                }
            }else {
                System.out.println(-1);
            }
        }

    }

    public static boolean isZhishu(int num) {
        int sqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
