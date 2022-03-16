package com.shijianwei.main.jianzhiOffer.Code08_dp;

import com.sun.xml.internal.ws.api.pipe.Fiber;

/**
 * @author SHI
 * @date 2022/2/5 14:38
 *
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *
 */
public class Code10 {
    public static int fib(int n) {
        if(n==0||n==1){
            return n;
        }
        int a=1 , b = 0 ;
        for (int i = 1; i < n; i++) {//i = i因为0和1判断过了，从2开始进行计算；
            a= a+b;//a = 两数之和
            b =a-b ;//b = 原本的a
            a %= 1e9+7;
        }
        return a;
    }

    public static void main(String[] args) {
//        System.out.println(fib(1));
//        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(20));
    }
}
