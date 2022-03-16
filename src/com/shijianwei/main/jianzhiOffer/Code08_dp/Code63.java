package com.shijianwei.main.jianzhiOffer.Code08_dp;

import java.awt.color.ICC_ProfileGray;
import java.security.spec.RSAPrivateCrtKeySpec;

/**
 * @author SHI
 * @date 2022/2/5 15:12
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Code63 {
    public static int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0 ;
        int profit = 0, cost = Integer.MAX_VALUE;
        for (int price : prices) {
            cost = Math.min(price,cost);
            profit = Math.max(profit , price- cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        int []a={2,4,1};
        System.out.println(maxProfit(a));
    }
}
