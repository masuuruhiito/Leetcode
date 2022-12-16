package com.shijianwei.main.exam.jingdong.day0903;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/3 18:56
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        long[] s = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int res = 0;
        for (long j : s) {
            res += getNumsDealWithCount(j);
        }
        System.out.println(res);
    }

    public static long getNumsDealWithCount(long n) {
        if (n == 1) {
            return 0;
        }
        long res = 0;
        long[] nums = fun(n);
        if (nums == null) {
            res++;
            res += getNumsDealWithCount(n - 1);
        }else {
//            int i =
        }

//        if (list.size() == 0) {
//            res++;
//            res += getNumsDealWithCount(n - 1);
//        }else {
//            res += list.size() - 1;
//            for (Long l : list) {
//                res += getNumsDealWithCount(l);
//            }
//        }
//        return res;
        return res;
    }

    public static long[] fun(long n) {
        List<Long> res = new ArrayList<>();
        long i = (long) (Math.sqrt(n));
        while (i-- >= 2) {
            if (n % i == 0) {
                return new long[]{i, n / i};
            }
        }
        return null;
    }
}
