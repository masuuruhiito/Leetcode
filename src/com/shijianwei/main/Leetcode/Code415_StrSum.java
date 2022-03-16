package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/1 11:38
 */
public class Code415_StrSum {
    public static String addStrings(String num1, String num2) {
        int i = num1.length()-1 , j = num2.length()-1 ;
        int flag= 0 ;
        StringBuilder res= new StringBuilder();
        while (i>=0 || j>=0){
            int tmp1 = i < 0 ? 0 : num1.charAt(i)-'0';
            int tmp2 = j < 0 ? 0 : num2.charAt(j)-'0';
            int bitsum = tmp1+tmp2+flag;
            flag = bitsum/10;
            res.append(bitsum % 10);
            i-- ;j--;
        }
        if (flag == 1) res.append(1);
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }
}
