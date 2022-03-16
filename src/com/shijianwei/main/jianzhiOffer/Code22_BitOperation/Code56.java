package com.shijianwei.main.jianzhiOffer.Code22_BitOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author SHI
 * @date 2022/2/15 17:54
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 */
public class Code56 {
    private static int []prime = new int [100];

    public static void generatorPrime(){
        int index=0;
        for (int i = 2; index<100 ; i++) {
            if (prime(i)) {
                prime[index++] = i;
            }
        }
    }

    public static boolean prime(int n){
        if(n<2) return false;
        boolean flag= true ;
        for (int i = 2; i <Math.sqrt(n) ; i++) {
            if (n % i == 0) {
                flag = false ;
                break ;
            }
        }
        return flag;
    }


    public static Map<Integer,Integer> PrimeFactors(int n){
//        初始化prime数组
        generatorPrime();
        int index = 0,count = 0 ;
        Map<Integer,Integer> res = new HashMap<>();
        while (n>1){
            if (n % prime[index] == 0) {
                n/=prime[index];
                res.put(prime[index],++count);
            }else {
                index++;
                count =0 ;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i : prime) {
            System.out.print(i+" ");
        }

        Map<Integer,Integer> map = PrimeFactors(24);
        for (Integer o : map.keySet()) {
            System.out.println(o+" "+map.get(o));
        }
    }
}
