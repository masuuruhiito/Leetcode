package com.shijianwei.main.exam.wangyi_0416;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/4/16 14:51
 */
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        每次计算的0的数量保存在这里面
//        int[][] dp = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            int tmp = nums[i];
//            int ans = 0;
//            while ((tmp%10) ==0){
//                tmp /= 10;
//                ans++;
//            }
//            dp[i][i] = ans;
//        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(dp[i][i]);
//        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i; k < n ; k++) {
                int ans = 0;
                int tmp = 1;
                for (int j = i; j <= k; j++) {
                    tmp *= nums[j];
                }
                while ((tmp % 10) == 0) {
                    tmp /= 10;
                    ans++;
                }
//                System.out.println(" i= " + i + " k = " + k + " res = " + res + " ans = " + ans);
                res += ans;
            }
        }
        System.out.println(res);


    }
}
