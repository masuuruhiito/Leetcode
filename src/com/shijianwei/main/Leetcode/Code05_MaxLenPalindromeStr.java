package com.shijianwei.main.Leetcode;

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
}
