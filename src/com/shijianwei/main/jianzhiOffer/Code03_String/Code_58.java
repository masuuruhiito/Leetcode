package com.shijianwei.main.jianzhiOffer.Code03_String;

import sun.util.resources.hr.CalendarData_hr;

import java.sql.ResultSet;

/**
 * @author SHI
 * @date 2022/1/18 14:21
 *
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *
 *
 * 翻转相较于其他比较麻烦
 * 可以使用切片（字符串两个子串相加）
 */
public class Code_58 {
    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars,0,chars.length-1);
        reverse(chars,0,chars.length-n%chars.length-1);
        reverse(chars,chars.length-n%chars.length,chars.length-1);
        return String.valueOf(chars);
    }
    public static String reverseLeftWords1(String s, int n) {

        return s.substring(n)+s.substring(0,n);
    }

    public static void reverse(char[] chars ,int start ,int end ){
        while (start<end){
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp ;
        }
    }


    public static void main(String[] args) {
        System.out.println(reverseLeftWords1("abcdefg", 2));
    }
}
//1234567
//7654321
//6754321
//6712345