package com.shijianwei.main.exam.gaotu;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/2 20:46
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();
        if (s1.length == 0 || s2.length == 0 || s1.length == 1 && s1[0] == '0' || s2.length == 1 && s2[0] == '0') {
            System.out.println(0);
            return;
        }
        long res = 0;
        for (int i = s2.length - 1; i >= 0; i--) {
            long ans = 0;
            for (int j = s1.length - 1; j >= 0; j--) {
                ans += (s1[j] - 48) * Math.pow(10, s1.length - 1 - j) * (s2[i] - 48);
            }
            ans *= Math.pow(10, s2.length - 1 - i);
            res += ans;
        }
        System.out.println(res);
    }
}
