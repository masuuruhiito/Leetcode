package com.shijianwei.main.exam.meituan.day0903;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/3 9:58
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int[] nums = Arrays.stream(s.trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[] chars = sc.nextLine().trim().toCharArray();
        for (int i = 1; i <= n; i++) {
            set.add(chars[i - 1]);
            HashSet<Integer> set1 = new HashSet<>();
            set1.add(i);
            getColorCount(nums, chars, set1);
            System.out.print(set.size()+" ");
            set.clear();
        }
    }

    static HashSet<Character> set = new HashSet<>();

    public static void getColorCount(int[] nums, char[] chars, HashSet<Integer> list) {
        if (list.size() == 0) {
            return;
        }
        HashSet<Integer> newSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                newSet.add(i + 2);
                set.add(chars[i + 1]);
            }
        }
        getColorCount(nums, chars, newSet);
    }
}
