package com.shijianwei.main.Leetcode;

import org.junit.Test;

/**
 * @author SHI
 * @date 2022/3/31 17:30
 */
public class Code394_StringDecoding {
    public static String decodeString(String s) {
        if (null == s) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder num = new StringBuilder();
            boolean flag = false;
            while(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                num.append(s.charAt(i++));
                flag = true;
            }
            if(flag) i++;
            StringBuilder str = new StringBuilder();
            while(s.charAt(i)!=']') {
                str.append(s.charAt(i++));
            }
            if (num.toString().equals("")) {
                continue;
            }
            for (int j = 0; j < Integer.valueOf(num.toString()); j++) {
                res.append(str);
            }
        }
        return res.toString() ;
    }




    @Test
    public void aa(){
        System.out.println(decodeString("3[a2[c]]"));
    }
}
