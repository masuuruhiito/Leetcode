package com.shijianwei.main.jianzhiOffer.Code03_String;

/**
 * @author SHI
 * @date 2022/1/18 14:08
 *
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class Code05 {
    public static String replaceSpace(String s) {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if(' '==s.charAt(i)){
                str.append("%20");
            }else{
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        System.out.println(replaceSpace("zhang san  "));
    }
}
