package com.shijianwei.main.jianzhiOffer.Code10_dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author SHI
 * @date 2022/2/7 13:28
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Code48 {
//    方法：遍历下标，找出以每个字符为末尾的字符串的最长子串，然后将最大值返回
    public int lengthOfLongestSubstring(String s) {
        int res= 0 ;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int size = 0 ;//记录当前位置的最长字符
            for (int j = i; j >=0 ; j--) {
                set.add(s.charAt(j));
                if (size+1 != set.size()) {
                    break;//此时代表已经找到了第一个重复字符
                }
                size++;
            }
            res= Math.max(res,size);
        }
        return res ;
    }


//    滑动窗口，当当前字符出现过时，将左指针指向上一次的该值，计算长度，逐一比较
    public static int lengthOfLongestSubstring1(String s) {
        int res = 0 ,j = -1 ;//j 为慢指针
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) j = Math.max(j,map.get(s.charAt(i)));
            map.put(s.charAt(i),i);
            res = Math.max(res,i-j);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }
}
