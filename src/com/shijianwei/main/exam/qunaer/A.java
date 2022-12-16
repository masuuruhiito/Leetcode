package com.shijianwei.main.exam.qunaer;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/7 20:07
 */
public class A {
    public static int maxScore(int energy, int[][] actions) {
        // write code here
        Arrays.sort(actions, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (int) (1.0 * o2[1] / o2[0] - 1.0 * o1[1] / o1[0]);
            }
        });
        int res = 0;
        for (int[] action : actions) {
            if (energy >= action[0]) {
                res += action[1];
                energy -= action[0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        maxScore(10, new int[][]{{1, 1}, {2, 1}, {1, 3}});
    }
}
