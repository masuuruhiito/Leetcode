package com.shijianwei.main.exam.gaotu;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/2 20:46
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a + b > c && a + c > b && b + c > a) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
