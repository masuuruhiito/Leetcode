package com.shijianwei.main.exam.meituan.day0903;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/3 9:57
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (b >= 9) {
            System.out.println(Math.max(b + 2 - a, 0));
        }else {
            System.out.println(11 - a);
        }
    }
}
