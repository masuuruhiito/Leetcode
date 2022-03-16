package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/2/24 19:07
 *
 *
 * 对于一个子串来说，bb是回文 bbb也是 bbbb也是，所以说只要判断出下一个字符与当前相同，那么就直接+1，判断下一位
 */
public class Code05_MaxPalindromeString {
    public static String longestPalindrome(String s) {
        if(s.length() <2 ) return s;
        int max = 1 ;
        int start = 0 ;
        for (int i = 0; i < s.length(); ) {
            if(s.length()-i < max/2 ) break;
            int l = i , r = i ;
            while (r+1<s.length() && s.charAt(r+1)==s.charAt(r)){
                r++;//此时去重
            }
//            判断当前数据和前一个数据是否一致
            i = r+1 ;
            while (l>0 && r<s.length()-1 && s.charAt(l-1) == s.charAt(r+1)){
                l--;
                r++;
            }
            if(max < r-l+1){
                max = r-l+1 ;
                start = l;
            }
        }
        return s.substring(start,start+max) ;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }


}
