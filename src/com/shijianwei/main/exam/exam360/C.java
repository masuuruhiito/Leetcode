//package com.shijianwei.main.exam.exam360;
//
//import java.util.*;
//
///**
// * @author SHI
// * @date 2022/9/9 17:10
// */
//public class C {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long n = sc.nextLong();
//        int m = sc.nextInt();
//        List<Boolean> ans = new LinkedList<>();
//        for (long i = 0; i < n; i++) {
//            ans.add(false);
//        }
//        int left = 0;
//        int right = 0;
//        for (int i = 0; i < m; i++) {
//            left = sc.nextInt();
//            right = sc.nextInt();
//            for (int j = left - 1; j < right; j++) {
//                ans.get(j) = !ans.get(j);
//            }
//            int count = 0;
//            for (int j = 0; j < n; j++) {
//                if (!ans[j]) {
//                    count++;
//                }
//            }
//            System.out.println(n - count);
//        }
//    }
//}
