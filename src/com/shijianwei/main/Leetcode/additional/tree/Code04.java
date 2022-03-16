package com.shijianwei.main.Leetcode.additional.tree;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/2/17 20:21
 */
public class Code04 {
    public static String getStr(String s){
        if(s == null  ) return null ;
        int count = 0 ;
        char character = '0';
        int i = 0 ; int j = 0 ;
        while (i<s.length() && j <s.length()){
            if(s.charAt(j) == s.charAt(i)){
                j++;
                if(count<j-i){
                    count = j-i;
                    character = s.charAt(i);
                }
            }else {
                j=++i;
            }
        }
        StringBuilder res = new StringBuilder( );
        for (int k = 0; k < count; k++) {
            res.append(character);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            System.out.println(getStr(s));
        }

    }
}
