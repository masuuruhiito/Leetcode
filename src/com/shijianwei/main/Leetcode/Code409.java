package com.shijianwei.main.Leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author SHI
 * @date 2022/9/18 18:02
 */
public class Code409 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        int res = 0;
        boolean containsSingle = false;
        for (Character character : map.keySet()) {
            if (map.get(character) / 2 >= 1) {
                res += (map.get(character) / 2) * 2;
            }
            if (map.get(character) % 2 == 1) {
                containsSingle = true;
            }
        }
        return containsSingle ? res + 1 : res;
    }

    public int longestPalindrome1(String s) {
        int[] nums = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            nums[c]++;
        }
        int single = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            single += num % 2;
        }
        return sum - (single > 0 ? single - 1 : single);
    }
}
