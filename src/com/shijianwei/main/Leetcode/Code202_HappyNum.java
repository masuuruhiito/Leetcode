package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/12 15:17
 */
public class Code202_HappyNum {
//    应该将数据存放到集合中，然后用set去重返回
//    或者用快慢指针，如果成环的话，总有一次会追上满指针
    public boolean isHappy(int n) {
        int count = 0 ;
        while(n!=1){
            int []num = new int [10];
            int m = n ;
            int index = 0 ;
            while(m > 0){
                num[index++] = m%10;
                m /= 10 ;
            }
            int newn = 0 ;
            for(int i = 0 ; i < index ; i++){
                newn+=num[i]*num[i];
            }
            n = newn ;
            if(count++ >50 ){
                return false ;
            }
        }
        return true;
    }
}
