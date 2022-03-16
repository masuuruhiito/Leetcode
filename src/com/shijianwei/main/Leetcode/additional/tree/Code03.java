package com.shijianwei.main.Leetcode.additional.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SHI
 * @date 2022/2/17 20:08
 */
public class Code03 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = Integer.MIN_VALUE;
        int i = 0 , j = 0 ;
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
