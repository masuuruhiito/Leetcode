package com.shijianwei.main.exam.wangyi_0327;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/4/14 18:36
 */
public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] tree = new int[n];
        if (n == 3) {
            tree = new int[]{2, 1, 3};
        } else if (n < 3 && n >= 1) {
            for (int i = 0; i < n; i++) {
                tree[i] = i + 1;
            }
        } else if (n > 3) {
            tree[0] = 1 ;
            tree[1] = 2 ;
            tree[2] = 4;
            tree[3] = 3;
            for (int i = 4; i < tree.length; i++) {
                tree[i] = i + 1;
            }
        }
        for (int i : tree) {
            System.out.print(i + " ");
        }
    }

}
