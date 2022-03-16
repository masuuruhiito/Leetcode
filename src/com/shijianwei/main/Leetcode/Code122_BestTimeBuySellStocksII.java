package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/28 14:11
 */
public class Code122_BestTimeBuySellStocksII {
    //只能买入一次,我还以为是多次
    public static int maxProfit1(int[] prices) {
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < prices.length - 1; i++) {
            int tmp = 0;
            while (i < prices.length - 1) {
                int target = prices[i + 1] - prices[i];
                if (target > 0) {
                    tmp += target;
                    i++;
                } else {
                    break;
                }
            }
            list.add(tmp);
        }
        for (Integer integer : list) {
            res += integer;
        }
        return res;
    }
}
