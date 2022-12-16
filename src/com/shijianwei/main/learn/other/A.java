package com.shijianwei.main.learn.other;

/**
 * @author SHI
 * @date 2022/12/15 15:09
 */
public class A {
    public static void main(String[] args) {
        long res = getRes("10.0.3.193");
        System.out.println(res);
    }

    public static long getRes(String s) {
        String[] split = s.split("\\.");
        long res = 0;
        for (int i = split.length - 1; i >= 0; i--) {
            res += Long.parseLong(split[i]) << ((split.length - 1 - i) * 8);
        }
        return res;
    }
}
