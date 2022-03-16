package com.shijianwei.main.jianzhiOffer.Code19_SearchandRecall;

/**
 * @author SHI
 * @date 2022/2/13 18:22
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 */
public class Code64 {
    int i = 1 ;
    public int sumNums2(int n) {
        if(n==1) return 1;
        n += sumNums(n-1);
        return n;
    }

    public static int sumNums(int n) {
        boolean judge = n>1 && (n+=sumNums(n-1)) > 0;
        return n;
    }

    public static int sumNums1(int n) {
        if(n==0) return 1;
        System.out.println(n);
        sumNums1(n-1);
        return n;
    }

    public static void main(String[] args) {
        int []a ={12,3,4,5,5,3};
        System.out.println(sumNums(3));
        System.out.println(sumNums(4));
        System.out.println(sumNums(5));
        System.out.println(sumNums(6));
    }
}
