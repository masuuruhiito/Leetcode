package com.shijianwei.main.exam.wangyi_0416;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/4/16 14:51
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();
        long x = sc.nextLong();

        //如果说最小的1...n都比x大，那么可以直接返回
        long presum = (1+n)*n/2;
        if (presum > x) {
            System.out.println(-1);
            return;
        }

//        定义差值
        long dif = x - presum;

//        计算出平分到每个数据相差的值
        long add = dif / n;

//        dif修改为剩下的余数部分（最后需要补齐）
        dif -= add * n;
        //保留最大数据（加的时候大部分情况在最后一个位置加，所以就要记录加完偏移量以及dif的maxNum是否符合）
        long maxNum = n + add;

//        repNum的作用是计算出去除的数据，如果说去除最后一个，加上maxNum，那就相当于加1，
//        如果说去除倒数第二个相当于加2,也就是变相的增加数组的大小,增加dif
        long repNum = 0;
        if (dif > 0) {
            repNum = maxNum + 1 - dif;
            maxNum++;
        }

//        最大值越界可以直接返回
        if (maxNum > k) {
            System.out.println(-1);
            return;
        }

//        那么就可以输出从1+add开始的n个数据，
        for (long i = 1 + add; i <= maxNum; i++) {
            if (i == repNum) {
                continue;
            }
            System.out.print(i+" ");
        }
    }
}
