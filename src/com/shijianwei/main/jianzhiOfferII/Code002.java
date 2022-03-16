package com.shijianwei.main.jianzhiOfferII;

import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author SHI
 * @date 2022/2/16 11:02
 */
public class Code002 {
    public static String addBinary(String a, String b) {
        int flag = 0 ;
        int i= a.length()-1 , j = b.length()-1 ;
        StringBuilder res =new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while(i>=0 && j>=0){
            String tmp1 = a.substring(i,i+1);
            String tmp2 = b.substring(j,j+1);
            int tmp = Integer.valueOf(tmp1)+Integer.valueOf(tmp2)+flag;
            if(tmp>1){
                stack.push(tmp-2);
                flag=1;
            }else {
                stack.push(tmp);
                flag = 0;
            }
            i--;
            j--;
        }
        while (i>=0){
            String tmp1 = a.substring(i,i+1);
            int tmp = Integer.valueOf(tmp1)+flag;
            if(tmp>1){
                stack.push(tmp-2);
                flag=1;
            }else {
                stack.push(tmp);
                flag = 0;
            }
            i--;
        }
        while (j>=0){
            String tmp1 = b.substring(j,j+1);
            int tmp = Integer.valueOf(tmp1)+flag;
            if(tmp>1){
                stack.push(tmp-2);
                flag=1;
            }else {
                stack.push(tmp);
                flag = 0;
            }
            j--;
        }
        if(flag==1) stack.push(1);

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }


    public static String addBinary1(String a, String b) {
        return Integer.toBinaryString(
                Integer.valueOf(a,2)+Integer.valueOf(b,2)
        );
    }

//    模拟相加
    public static String addBinary2(String a, String b) {
        StringBuilder res = new StringBuilder();
        int n = Math.max(a.length(),b.length());
        int carry = 0 ;
        for (int i = 0; i < n; i++) {
            carry+=i<a.length()?a.charAt(a.length()-i-1)-'0':0;
            carry+=i<b.length()?b.charAt(b.length()-i-1)-'0':0;
            res.append((char)(carry % 2 + '0'));
            carry/=2;
        }
        if(carry==1){
            res.append(1);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary2("1", "111"));
    }
}
