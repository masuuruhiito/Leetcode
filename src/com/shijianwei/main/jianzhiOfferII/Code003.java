package com.shijianwei.main.jianzhiOfferII;

/**
 * @author SHI
 * @date 2022/2/16 10:37
 */
public class Code003 {
    public static void main(String[] args) {
        int []res= new Code003().countBits(5);
        for (int re : res) {
            System.out.println(re);
        }

    }

    public int[] countBits(int n) {
        int []res = new int[n+1];
        for (int i = 0; i < res.length ; i++) {
            res[i] = count(i);
        }
        return res;
    }

    private static int count(int num) {
        int res= 0 ;
        while (num>0){
            num&=(num-1);
            res++;
        }
        return res;
    }



}
