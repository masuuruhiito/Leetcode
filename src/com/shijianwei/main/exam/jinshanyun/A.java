package com.shijianwei.main.exam.jinshanyun;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/11/8 21:06
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double res = sc.nextInt() * 0.3;
            int len = sc.nextInt();
            if (len > 20) {
                res += 20 * 1.8 + (len - 20) * 2.5;
            }else {
                res += len * 1.8;
            }
            System.out.printf("%.2f\n", Math.max(res, 9));
        }
    }
}
