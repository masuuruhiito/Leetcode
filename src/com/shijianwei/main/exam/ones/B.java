package com.shijianwei.main.exam.ones;

import java.util.*;

/**
 * @author SHI
 * @date 2022/11/8 20:15
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] x = new int[k];
        int[] y = new int[k];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            if (!map.containsKey(x[i])) {
                HashMap<Integer, Integer> tmp = new HashMap<>();
                tmp.put(y[i], 1);
                map.put(x[i], tmp);
            }else {
                map.get(x[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            int xCnt = 0;
            for (int j = 0; j < k; j++) {
                if (x[j] == x[i]) {
                    xCnt++;
                }
            }
            int yCnt = 0;
            for (int j = 0; j < k; j++) {
                if (y[j] == y[i]) {
                    yCnt++;
                }
            }
            int cur = xCnt - 1 + yCnt;
            res = Math.max(res, cur);
        }
        System.out.println(res);
    }
}
