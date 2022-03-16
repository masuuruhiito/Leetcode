package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/2/27 12:33
 */
public class Code121_BestTimeBuySellStocks {


    public static int maxProfit(int[] prices) {
        if(prices.length==0) return 0 ;
        int min = prices[0], max = 0 ;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max ;
    }

    public static void main(String[] args) {
        int []a = {7,1,5,3,6,4};
        System.out.println(maxProfit(a));
    }
}
