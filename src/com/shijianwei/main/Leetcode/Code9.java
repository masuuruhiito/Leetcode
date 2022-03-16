package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/1/16 20:03
 */
public class Code9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(12));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(21));
    }
    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int i = 0 , j = chars.length -1;
        while (i<j){
            if(chars[i++]!=chars[j--]){
                return false ;
            }
        }
        return true ;
    }
}
