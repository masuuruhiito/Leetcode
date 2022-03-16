package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/1/18 18:07
 * <p>
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Code14_MaxLenSamePrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            length = strs[i].length() > length ? length : strs[i].length();
        }
        for (int i = 0; i < length; i++) {
            if (compare(strs, i)) {
                res.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return res.toString();
    }

    public static boolean compare(String[] strs, int index) {
        char c = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            if (index >= strs[i].length() || strs[i].charAt(index) != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str = {"zhang", "zha", "zhan"};
        System.out.println(compare(str, 0));
        System.out.println(compare(str, 1));
        System.out.println(compare(str, 2));
        System.out.println(compare(str, 3));

        System.out.println(longestCommonPrefix(str));
    }
}