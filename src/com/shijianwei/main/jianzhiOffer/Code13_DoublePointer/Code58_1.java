package com.shijianwei.main.jianzhiOffer.Code13_DoublePointer;

import javax.swing.text.DefaultEditorKit;

/**
 * @author SHI
 * @date 2022/2/7 20:48
 *
 */
public class Code58_1 {
//    想使用split偷懒,结果在对于空格处无法继续进行
//    能进行,晚上大脑死机了,导致出现问题
    public static String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1; i >=0 ; i--) {
            if (ss[i].equals("")) continue;
            sb.append(ss[i]).append(" ");
        }
        return sb.toString().trim();
    }

//
    public static String reverseWords1(String s) {
        if(s.isEmpty()) return "" ;
        s = s.trim();
        int fast = s.length()-1 ,slow = s.length()-1 ;
        StringBuilder res = new StringBuilder();
        while (fast>=0){
            while (fast>=0&&s.charAt(fast)!=' ') fast-- ;//结束时fast = 倒数第一个空格位置
            res.append(s,fast+1,slow+1).append(" ");
            while (fast>=0&& s.charAt(fast)==' ') fast-- ;//结束时fast = 倒数第2个不是空格位置
            slow = fast;
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }
}
