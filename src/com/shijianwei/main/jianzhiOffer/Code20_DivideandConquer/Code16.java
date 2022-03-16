package com.shijianwei.main.jianzhiOffer.Code20_DivideandConquer;

/**
 * @author SHI
 * @date 2022/2/15 14:06
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 */
public class Code16 {
    public static double myPow(double x, int n) {
        if(x == 0 ) return 0 ;
        long l = n ; //n 有可能超出int范围
        double res =1;
        if(l<0){
            x = 1/x ;
            l = -l ;
        }
//        进行判断是否l大于0 不大于0返回
//        判断当前l的二进制的最后一个位置是否是1 是就乘当前的x
//        x每次都会变成x*x
        while (l>0){
            if((l&1)==1) res*=x ;
            x*= x ;
            l =l>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(1,100));
        System.out.println(myPow(2,10));
        System.out.println(myPow(2,4));
        System.out.println(myPow(2,5));
        System.out.println(myPow(2.1,3));
        System.out.println(myPow(3,3));
    }
}
