package com.shijianwei.main.exam.meituan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author SHI
 * @date 2022/8/27 11:47
 */
public class A{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String s1 = br.readLine();
        String s2 = br.readLine();
        int count = 0;
        for (int i = 0; i <= n - m; i++) {
            if (compare(s1.substring(i, i + m), s2)) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static boolean compare(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            if (chars1[i] != chars2[i] && chars2[i] != '*') {
                return false;
            }
        }
        return true;
    }
}
