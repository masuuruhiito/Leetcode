package com.shijianwei.main.exam.jingdong.day0903;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/3 18:55
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cur = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n; i++) {
            cur = sc.nextInt();
            if (cur > max) {
                count = 1;
                max = cur;
            } else if (cur == max) {
                count++;
            }
        }
        System.out.println(count == n ? 0 : n - count);
    }
}
