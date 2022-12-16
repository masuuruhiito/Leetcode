//package com.shijianwei.main.exam;
//
//import java.util.HashMap;
//
///**
// * @author SHI
// * @date 2022/8/6 15:29
// */
//public class meituan {
//    public static void main(String[] args) {
//        int n = 10;
//        int[] a = {1, 5, 8, 7, 6, 5, 5, 9, 5, 5};
//        int[] b = {10, 7, 9, 0, 5, 8, 4, 8, 9, 1};
//        System.out.println(funa(n, a, b));
//    }
//
//    public static boolean funa(int n, int[] a, int[] b) {
//        // map 中是保存每个字符当前的最大的值
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            Integer ai = map.get(a[i]);
//            Integer bi = map.get(b[i]);
//            if (ai != null && bi != null) {
//                if (ai.equals(bi)) {
//                    map.put(a[i], ai + 1);
//                    map.put(b[i], bi + 1);
//                } else {
//                    int tmp = ai > bi ? a[i] : b[i];
//                    map.put(tmp, map.get(tmp) + 1);
//                }
//            } else if (ai != null) {
//                map.put(a[i], ai + 1);
//            } else if (bi != null) {
//                map.put(b[i], bi + 1);
//            } else {
//                map.put(a[i], 1);
//                map.put(b[i], 1);
//            }
//        }
//        int max = 0;
//        for (Integer value : map.values()) {
//            max = Math.max(max, value);
//        }
//        return max >= (n + 1) / 2;
//    }
//
//    public static int getMinReverse(int n, int[] a, int[] b) {
//        // dp 向左表示反转，向下表示不反转
//        // 然后遍历出最大值
//        // 最后的dp的i就为反转次数
//        int[][] dp = new int[n + 1][n + 1];
//        for (int i = 0; i < n + 1; i++) {
//            dp[0][i] = 0;
//            dp[i][0] = 0;
//        }
//        // dp [i][j] 表示此时的最大长度
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//
//            }
//        }
//    }
//}
