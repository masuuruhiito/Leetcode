package com.shijianwei.main.jianzhiOffer.Code21_BitOperation;

/**
 * @author SHI
 * @date 2022/2/9 23:28
 * 剑指 Offer 15. 二进制中1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * 提示：
 *
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用 二进制补码 记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 *
 * 示例 1：
 *
 * 输入：n = 11 (控制台输入 00000000000000000000000000001011)
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class Code15 {
    // you need to treat n as an unsigned value
    public static int hammingWeight1(int n) {
        int count = 0 ;
        for (int i = 0; i < 32; i++) {
            if((1&n)==1)   count++;
            n >>=1;
        }
        return count;
    }


    public static int hammingWeight(int n) {
        int count = 0 ;
        while (n!=0){
//            每次n&n-1会将最小的1进行反转，总的执行次数为1的个数次
            n&= n-1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
    }
}
