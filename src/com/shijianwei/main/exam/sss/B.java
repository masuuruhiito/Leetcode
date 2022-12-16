package com.shijianwei.main.exam.sss;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/8/30 19:32
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int ans = 0;
        while (q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int min = Math.min(Math.min(a, b), c);
            ans = min * 2;
            ans += b == min ? 0 : b - min - 1;
            System.out.println(ans);
        }
    }
}
