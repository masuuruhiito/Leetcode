package com.shijianwei.main.exam.oukeyunlian;

/**
 * @author SHI
 * @date 2022/9/16 15:19
 */
import java.util.*;

public class A {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    public int coinChange(int[] coins, int curAmount, int[] count) {
        if (curAmount <= 0) {
            return curAmount < 0 ? -1 : 0;
        }
        if (count[curAmount - 1] != 0) {
            return count[curAmount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, curAmount - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[curAmount - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[curAmount - 1];
    }






    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arrayStr = scanner.nextLine();
        String amountStr = scanner.nextLine();
        if (null == arrayStr || !arrayStr.startsWith("[") || !arrayStr.endsWith("]")) {
            return;
        }
        arrayStr = arrayStr.substring(1, arrayStr.lastIndexOf("]"));
        String[] arrayStrArray = arrayStr.split(",");
        int[] arr = new int[arrayStrArray.length];
        for (int j = 0; j < arrayStrArray.length; j++) {
            arr[j] = Integer.parseInt(arrayStrArray[j]);
        }

        System.out.println(new A().coinChange(arr, Integer.parseInt(amountStr)));
    }
}
