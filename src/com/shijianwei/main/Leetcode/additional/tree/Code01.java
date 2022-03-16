package com.shijianwei.main.Leetcode.additional.tree;

/**
 * @author SHI
 * @date 2022/2/15 21:14
 */
public class Code01 {

    public static void getPrimes(int n) {
        if (n < 2 || n > 1000000)   // 之所以限制最大值为100万，是因为JVM内存限制，当然有其他灵活方案可以绕过（比如位图法）
            throw new IllegalArgumentException("输入参数n错误！");

        int[] array = new int[n];   // 假设初始所有数都是素数，且某个数是素数，则其值为0；比如第一个数为素数那么array[0]为0
        array[0] = 1;   // 0不是素数
        array[1] = 1;   // 1不是素数
        // 下面是筛选核心过程
        for (int i = 2; i < Math.sqrt(n); i++) {   // 从最小素数2开始
            if (array[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    array[j] = 1;   // 标识该位置为非素数
                }
            }
        }

        // 打印n以内的所有素数，每排10个输出
        System.out.println(n + "以内的素数如下： ");
        int count = 0;        // 当前已经输出的素数个数
        int rowLength = 10;   // 每行输出的素数个数
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (count % rowLength == 0 && count != 0) {
                    System.out.println();
                }
                count++;

                System.out.print(i + "\t");
            }
        }
    }

    public static void main(String[] args) {
        getPrimes(99999);
    }
}
