package com.shijianwei.main.jianzhiOffer.Code21_BitOperation;

/**
 * @author SHI
 * @date 2022/2/15 14:51
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 * 分别计算两个数的每一位
 * 如果&为1
 */
public class Code65 {
    public int add(int a, int b) {
        if(a==0||b==0) return a^b;
        return add(a^b,(a&b)<<1);
    }

    //a&b+(a^b<<1) 为最终答案
    //但是不能使用+法
    //这样又出现了需要加法的操作，所以可以通过递归解决
}
