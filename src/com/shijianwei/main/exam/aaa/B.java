package com.shijianwei.main.exam.aaa;

/**
 * @author SHI
 * @date 2022/10/13 20:06
 */
public class B {
    public static void main(String[] args) {

    }

    public int Jump (int n, int[] A) {
        // write code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int cur = 0, maxIndex = 0, res = 0;
        for (int i = 0; i < n - 1; i++) {
            maxIndex = Math.max(maxIndex, i + A[i]);
            if (cur >= n) {
                break;
            }
            if (cur == i) {
                cur = maxIndex;
                res++;
            }
        }
        return res;
    }
}
