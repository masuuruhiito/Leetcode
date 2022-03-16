package com.shijianwei.main.jianzhiOfferII.BitOperation;

/**
 * @author SHI
 * @date 2022/2/24 22:42
 */
public class Code001_IntegerDivision {
    public static int divide(int a, int b) {
        double num = 1.0*a/b ;
        num = num>Math.pow(2,31)-1?Math.pow(2,31)-1:num;
        return (int)num;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }
}
