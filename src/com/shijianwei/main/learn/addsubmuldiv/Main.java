package com.shijianwei.main.learn.addsubmuldiv;

/**
 * @author SHI
 * @date 2022/10/8 23:48
 * 不使用加减乘除实现加减乘除（位运算实现）
 */
public class Main {
    /**
     * 实现加法前要只要的点：
     * ^操作相当于无进位相加     11 0 00 0 01 1 10 1
     * &操作相当于获取进位位置   11 1 10 0 01 0 00 0
     * <p>
     * 那么a+b就等于a^b+a&b<<1，直到进位为0
     * 注：
     *  a&b的值代表哪个位置需要进位，而进位的数据，应该加到左移一位的位置上
     */
    public static int add(int a, int b) {
        while (b != 0) {
            int ca = a;
            a = ca ^ b;
            b = (ca & b) << 1;
        }
        return a;
    }

    /**
     * a-b == a+(-b)
     * 将其取反即可
     * 注：
     *  对于Integer.MIN_VALUE的值为 -Integer.MAX_VALUE-1
     *  所以在int范围内没有Integer.MIN_VALUE的abs
     *  但是用计算机算Math.abs(Integer.MIN_VALUE) == Integer.MIN_VALUE;
     *  所以需要对被减数判断是不是Integer.MIN_VALUE
     */
    public static int subtraction(int a, int b) {
        return add(a, add(~b, 1));
    }


    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(add(12, 2));
        System.out.println(add(1, 20));
        System.out.println(add(1, -2));
        System.out.println(add(-1, -2));
        System.out.println(add(0, -2));
        System.out.println(add(-11111111, 11111111));
        System.out.println(add(Integer.MAX_VALUE, 0));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(add(Integer.MAX_VALUE, 1) == Integer.MIN_VALUE);

        System.out.println(~Integer.MIN_VALUE);
    }
}
