package com.shijianwei.main.exam.jingdong.day0903;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/3 18:56
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            int l = 0;
            if (chars[i] == '(') {
                l++;
            }
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == ')' && l > 0) {
                    count += 2;
                    l--;
                    res += count;
                }
            }
        }
        System.out.println(res);
    }
}
