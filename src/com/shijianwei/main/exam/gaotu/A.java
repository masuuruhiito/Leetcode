package com.shijianwei.main.exam.gaotu;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/2 20:45
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String[] split = String.valueOf(a).split("");
        StringBuilder sb = new StringBuilder();
        HashSet set = new HashSet();
        for (int i = split.length - 1; i >= 0; i--) {
            if (set.contains(split[i])) {
                continue;
            }
            set.add(split[i]);
            sb.append(split[i]);
        }
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
