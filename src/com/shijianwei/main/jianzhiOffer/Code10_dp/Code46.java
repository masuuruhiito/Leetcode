package com.shijianwei.main.jianzhiOffer.Code10_dp;

import java.awt.font.NumericShaper;

/**
 * @author SHI
 * @date 2022/2/6 11:18
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 递归方程：前面所有的方法+当前产生的方法（1或者2）
 */
public class Code46 {
    public static int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
//        dp[i]存储的是chars[i-1]中的方法数
        int []dp = new int[chars.length];
        dp[0] = 1;
        for (int i = 1; i <chars.length ; i++) {
            if(chars[i-1]>'2'&& chars[i-1]<='9' ||chars[i-1]=='0'){
                dp[i] = dp[i-1];
            }else if(chars[i-1]=='1'){
                if(i-2>=0){
                    dp[i] = dp[i-1]+dp[i-2];
                }else {
                    dp[i] = dp[i-1]+1;
                }
            }else if(chars[i-1]=='2'){
                if(chars[i]>='0'&&chars[i]<='5'){
                    if(i-2>=0){
                        dp[i] = dp[i-1]+dp[i-2];
                    }else {
                        dp[i] = dp[i-1]+1;
                    }
                }else if(chars[i]>='6'&&chars[i]<='9'){
                    dp[i]= dp[i-1];
                }
            }
        }
        return dp[chars.length-1];
    }

//    比较字典序将
    public static int translateNum1(int num) {
        int a= 1,b = 1 ;
        String s =String.valueOf(num);
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i-2,i);
            int c = tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
            b=a;//b存储a中的数据
            a=c;//a在上面条件成立的时候变成a+b
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(translateNum1(18580));
    }
}

/*
1 2 2 5 8
1       1
1 2     1+1
1 2 2   1+1+1
1 2 2 5 5


1 2 2 5
12 2 5
1 22 5
1 2 25
12 25


1 2 2 2 2
12 2 2 2
1 22 2 2
1 2 22 2
1 2 2 22
12 22 2
12 2 22
1 22 22
*/