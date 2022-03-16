package com.shijianwei.main.exam.beike2022AutumnRecruit;

/**
 * @author SHI
 * @date 2022/3/11 15:32
 */
public class Code01_SubStr {
    public static String NS_String (String s, int k) {
        // Leetcode code here
        int[] chars = new int[26];
        for(int i = 0 ; i < s.length() ;i++){
            chars[s.charAt(i)-'a'] ++;
        }
        while(k-- >0){
            int i = 0 ;
            for( i = 0 ; i < chars.length  ;i ++){
                if(chars [i]!= 0){
                    chars[i] = 0 ;
                    break ;
                }
            }
            for(int j = 0 ; j < s.length() ;j++){
                if(s.charAt(j) == i+'a'){
                    s = del(s,j);
                    j--;
                }
            }
        }

        return s ;

    }


    public static String del(String s , int i){
        return s.substring(0,i)+s.substring(i+1);
    }


    public static void main(String[] args) {
        System.out.println(NS_String("aaabbbbccccc", 1));
    }
}
