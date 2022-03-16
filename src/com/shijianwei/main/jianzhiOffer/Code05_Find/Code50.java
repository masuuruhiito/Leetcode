package com.shijianwei.main.jianzhiOffer.Code05_Find;

/**
 * @author SHI
 * @date 2022/1/20 19:04
 *
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例 1:
 *
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 示例 2:
 *
 * 输入：s = ""
 * 输出：' '
 */
public class Code50 {
    public static char firstUniqChar(String s) {
        if(s.length()==0){
            return ' ';
        }
        char[] chars = s.toCharArray();
        int[] character =new int[26];
        for (int i = 0; i < chars.length; i++) {
            character[chars[i]-'a']++;
        }
        for (int i = 0; i < chars.length; i++) {
            if(character[chars[i]-'a']==1){
                return chars[i];
            }
        }
        return ' ';
    }


    public static void main(String[] args) {
        String s = "zhangsan";
        System.out.println(firstUniqChar(s));
    }
}
