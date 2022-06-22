package com.shijianwei.main.Leetcode;

import org.junit.Test;

/**
 * @author SHI
 * @date 2022/3/27 12:39
 */
public class Code470_UseRand7RealizeRand10 {
    public int rand10() {
        int ans = rand2();
        for (int i = 0; i < 3; i++) {
            ans <<= 1;
            ans ^= rand2();
        }
        return ans <= 10 && ans > 0 ? ans : rand10();
    }


//    先将rand7分为rand2
    public int rand2(){
        int res = rand7();
        return res == 7 ? rand7() : res%2;
    }




    public int rand7(){
        return (int)(Math.random()*7)+1;
    }



    @Test
    public void ms(){
        int[] nums = new int[12];
        for (int i = 0; i < 100000; i++) {
            nums[rand10()]++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(i + ":" + (1.0*nums[i] / 100000));
        }
    }


    public int random2() {
        int i = rand7();
        return i != 7 ? i%2 : random2();
    }


    public int random10(){
        int i = rand2();
        for (int j = 0; j < 3; j++) {
            i <<= rand2();
            i ^= rand2();
        }
        return i > 0 && i <= 10 ? i : random10();
    }
}
