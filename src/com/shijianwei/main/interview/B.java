package com.shijianwei.main.interview;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/10/19 15:20
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1, 2, 3, 4};
        getString(nums);
        System.out.println(count);
    }


    public static void getString(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        fun(nums, 0);
    }

    static int count = 0;


    public static void fun(int[] nums, int index) {
        if (index == nums.length) {
            printArr(nums);
            count++;
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            fun(nums, index + 1);
            swap(nums, index, i);
        }
    }

    public static void printArr(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
