package com.shijianwei.main.exam.gelinshentong;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/10/8 22:43
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int fruitCount = sc.nextInt();

        System.out.println(getFuncCount(money, fruitCount));
    }

    /**
     * 可得到方程：x+y+z = fruitCount     x = fruitCount-y-z
     *           7x+3y+z/3=money        x = (double)(money-z/3-3y)/7
     *      则：fruitCount-y-z = (double)(money-z/3-3y)/7
     *      化简得：y = (7/4)*(fruitCount)-(5/3)*z-money/4
     *      由于money为整数，则z一定为3的倍数
     *      那么就可以 从不买荔枝到全买荔枝都算一边，算有一个解
     */
    public static int getFuncCount(int money, int fruitCount) {
        int res = 0;
        if (money < fruitCount / 7 || money > fruitCount * 3) {
            return res;
        }
        for (int z = 0; z <= money * 3; z += 3) {
            double y = 1.0 * 7 * fruitCount / 4 - 1.0 * 5 * z / 3 - 1.0 * money / 4;
            if (y >= 0 && fruitCount - y - z >= 0 && y % 1 == 0) {
                res++;
            }
        }
        return res;
    }
}
