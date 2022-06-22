package com.shijianwei.main.exam.wangyi_0327;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/4/14 18:20
 */
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int[] dp = new int[s.length()+1];
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) <= 1) {
                dp[i + 1] = Math.max(dp[i], dp[i - 1] + s.charAt(i) - 'a' + s.charAt(i - 1) - 'a' + 2);
            }
        }
        for (int i : dp) {
            System.out.print(i + " ");
        }
//        System.out.println(dp[s.length()]);

    }
}
