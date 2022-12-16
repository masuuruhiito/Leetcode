package com.shijianwei.main.exam.didi;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/4 20:04
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(getRes(l[i], r[i], t[i]) + " ");
        }
    }

    public static long getRes(int l, int r, int t) {
        long res = 0;
        int[] last = null;
        for (int i = l; i <= r; i++) {
            int ans = 0;
            int[] cur;
            if (i % 10 != 0 && last != null) {
                last[last.length - 1] = i % 10;
                cur = last;
            } else {
                cur = getAllBit(i);
            }
            last = cur;
            for (Integer integer : cur) {
                ans ^= integer;
            }
            if (ans == t) {
                res++;
            }
        }
        return res;
    }

    public static int[] getAllBit(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[i] = chars[i] - 48;
        }
        return res;
    }
}
