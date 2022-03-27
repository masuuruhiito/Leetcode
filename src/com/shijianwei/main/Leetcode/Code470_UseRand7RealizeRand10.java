package com.shijianwei.main.Leetcode;

import org.junit.Test;

/**
 * @author SHI
 * @date 2022/3/27 12:39
 */
public class Code470_UseRand7RealizeRand10 {
    public int rand10() {
        return (int)(1.0*rand7()/7*10) ;
    }
    @Test
    public void ms(){
        System.out.println(rand10());
        System.out.println(rand7());

    }


    public int rand7(){
        return (int)(Math.random()*7)+1;
    }
}
