package com.shijianwei.main.exam.weizhong;

import java.util.*;

/**
 * @author SHI
 * @date 2022/10/16 20:54
 *
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 如果一个字符串中字符A出现的次数、字符B出现的次数、字符C出现的次数均相等，则这样的字符串称为一个相等串。
 *
 * 给定一个由字符A、B、C构成的字符串s，请问s所有的非空子串中是否存在一个相等串，如果存在，输出最长相等子串的长度；否则输出0。
 *
 * 注：字符串中任意连续的字符组成的子序列称为该串的子串。例如，字符串abc中，a、b、c、ab、bc、abc均为abc串的子串，而ac不是abc的子串。
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        if (!s.contains("A") || !s.contains("B") || !s.contains("C")) {
            System.out.println(0);
            return;
        }
        int[][] curCount = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                curCount[i][j] = s.charAt(i-1) - 'A' == j ? curCount[i - 1][j] + 1 : curCount[i - 1][j];
            }
        }
        if (n % 3 == 0 && curCount[n][0] == curCount[n][1] && curCount[n][0] == curCount[n][2]) {
            System.out.println(n);
            return;
        }

        for (int i = (n / 3) * 3; i >= 3; i = i - 3) {
            for (int l = 0; l < n - i + 1; l++) {
                int r = l + i;
                int aCount = curCount[r][0] - curCount[l][0];
                int bCount = curCount[r][1] - curCount[l][1];
                int cCount = curCount[r][2] - curCount[l][2];
                if (aCount == bCount && aCount == cCount) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(0);
    }
//}

//    PriorityQueue<int[]> skip = new PriorityQueue<>(new Comparator<int[]>() {
//        @Override
//        public int compare(int[] o1, int[] o2) {
//            return o1[0] - o2[0];
//        }
//    });

//    public static void addSkip(PriorityQueue<int[]> skip,int[]nums ) {
//        if (skip.size() == 0) {
//            skip.add(nums);
//            return;
//        }
//        for (int i = 0; i < skip.size(); i++) {
//
//        }
//        for (int[] ints : skip) {
//            if (ints[0] <= nums[0] && ints[1] >= nums[1]) {
//                return;
//            }else if (ints[0] <= nums[0] && ints[1] >= nums[1])
//        }
//        skip.stream().
//    }
}
