package com.shijianwei.main.exam.ones;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/11/8 20:09
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                num = (num + 1) % 1000000007;
            }else {
                num = (num * 2) % 1000000007;
            }
        }
        System.out.println(num);
    }
}
