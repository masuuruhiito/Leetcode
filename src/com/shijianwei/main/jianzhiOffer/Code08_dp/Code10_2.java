package com.shijianwei.main.jianzhiOffer.Code08_dp;

/**
 * @author SHI
 * @date 2022/2/5 14:58
 *
 * 青蛙跳台问题，与feibnace数列差的只是初始值不一样；
 */
public class Code10_2 {
    public int numWays(int n) {
        if(n<2) return 1;
        int a =1 , b = 1 ;
        for(int i = 1 ; i<n ;i++){
            a = a+b ;
            b = a-b ;
            a %= 1e9+7 ;
        }
        return a ;
    }
}
