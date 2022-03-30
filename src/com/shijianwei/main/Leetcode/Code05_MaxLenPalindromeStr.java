package com.shijianwei.main.Leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/1/2 13:00
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 * 来源：力扣（Leetcode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code05_MaxLenPalindromeStr {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
        System.out.println(isPalindromic("zhz",0,2));

    }

//    暴力
    public static String longestPalindrome(String s) {
        int ans = 1 ;
        String str = s;
        for (int i = 0; i <s.length()-1; i++) {
            for (int j = i; j <s.length() ; j++) {
                if(isPalindromic(s,i,j)){
                    if(ans<=j-i+1){
                        ans = j-i+1 ;
                        str = s.substring(i,j+1);
                    }
                }

            }
        }
        return str ;
    }

    public static boolean isPalindromic(String s,int start ,int end ){
        for (int i = start; i <(end+start+1)>>1; i++) {
            if(s.charAt(i)!=s.charAt((end-(i-start)))){
                return false ;
            }
        }
        return true;
    }




//    中心扩散法

    /**
     * 啊这，这破题，我是真的，错一次，调一次，真心马虎
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if(s==null || s.length() == 0) return "";
        char[] chars = s.toCharArray();
        int maxLen = 1 ;
        String res = s.substring(0, 1);
        for (int i = 0; i < chars.length; i++) {
            int left = i  ,right = i ;
//            因为相等的数据不管多少个都是回文字符串
            while (left != 0 && chars[left - 1] == chars[left]) {
                left--;
            }
            while (right != chars.length - 1 && chars[right] == chars[right + 1]) {
                right++;
            }
//            此时已经去除了左右相等的字符
            while ( left != 0 && right != chars.length - 1 && chars[left-1] == chars[right+1] ) {
                left--;
                right++;
            }
            if (right - left+1 > maxLen) {
                maxLen = right - left+1;
                res = String.valueOf(chars, left, maxLen);
            }
        }
        return res ;
    }


    @Test
    public void aaa(){
        System.out.println(longestPalindrome1("aaaa"));
    }



    /**
     * 使用dp数组来减少重复计算
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0;  //最长回文串的起点
        int maxEnd = 0;    //最长回文串的终点
        int maxLen = 1;  //最长回文串的长度

        boolean[][] dp = new boolean[strLen][strLen];

        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
