package com.shijianwei.main.exam.shenxinfu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/16 19:48
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0], v = s[1];
        s = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        int ll = 0;
        int lDelFirst = Integer.MIN_VALUE, rDelFirst = Integer.MAX_VALUE;
        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        for (int rr = 0; rr < n; rr++) {
            if (rr > ll) {
                lDelFirst = Math.max(l, s[rr] - v);
                rDelFirst = Math.min(r, s[rr] + v);
            }
            l = Math.max(l, s[rr] - v);
            r = Math.min(r, s[rr] + v);
            if (r < l) {
                if (lDelFirst <= rDelFirst) {
                    if (rr < n - 1) {
                        lDelFirst = Math.max(l, s[rr + 1] - v);
                        rDelFirst = Math.min(r, s[rr + 1] + v);
                        if (lDelFirst <= rDelFirst) {
                            l = lDelFirst;
                            r = rDelFirst;
                        }else {
                            r = Integer.MAX_VALUE;
                            l = Integer.MIN_VALUE;
                            rDelFirst = Integer.MAX_VALUE;
                            lDelFirst = Integer.MIN_VALUE;
                        }
                    }else {
                        rDelFirst = Integer.MAX_VALUE;
                        lDelFirst = Integer.MIN_VALUE;
                    }
                }
                res++;
            }
        }
        System.out.println(res);
    }
}
