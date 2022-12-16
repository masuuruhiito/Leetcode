package com.shijianwei.main.exam.sss;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/8/30 19:15
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-- > 0) {
            int x = sc.nextInt();
            if (x % 2 == 0) {
                System.out.println(x);
            }else {
                char[] chars = String.valueOf(x).toCharArray();
                boolean isOk = false;
                for (int i = 0; i < chars.length; i++) {
                    if (Integer.parseInt(String.valueOf(chars[i])) % 2 == 0 && chars.length > 1) {
                        char tmp = chars[i];
                        chars[i] = chars[chars.length - 1];
                        chars[chars.length - 1] = tmp;
                        System.out.println(String.valueOf(chars));
                        isOk = true;
                        break;
                    }
                }
                if (!isOk) {
                    System.out.println(-1);
                }
            }
        }
    }
}
