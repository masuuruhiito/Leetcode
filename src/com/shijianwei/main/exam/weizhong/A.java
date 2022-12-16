package com.shijianwei.main.exam.weizhong;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/10/16 20:13
 *
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 现在给你一个长度为n的字符串s。字符串中仅包含小写字母。
 *
 * 你可以从s中删去任意个字符。删除的字符可以是不连续的。
 *
 * 现在询问你通过不同的删除方法可以得到多少个不同的字符串。
 *
 *
 *
 * 例如：
 *
 * 对于串aab，可以通过删除得到如下字符串：
 *
 * “a”, “aa”, “ab”, “aab”，“b”, “”（空串）
 *
 * 所以其答案为6。
 *
 *
 *
 * 对于串aaab，可以通过删除得到如下字符串：
 *
 * “a”, “aa”, “aaa”, “ab”, “aab”, “aaab”，“b”，“”（空串）
 *
 * 所以其答案为8。
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        HashSet<String> set = new HashSet<>();
        getSubSeq(s.toCharArray(), 0, new StringBuilder(), set);
        System.out.println(set.size());
    }

    public static void getSubSeq(char[] chars, int i, StringBuilder res, HashSet<String> set) {
        if (i == chars.length) {
            set.add(res.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(res);
        getSubSeq(chars, i + 1, res.append(chars[i]), set);
        getSubSeq(chars, i + 1, stringBuilder, set);
    }
}
