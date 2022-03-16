package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/5 19:48
 */
public class Code912_mergeSort {
    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums , start , mid , end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int len = end - start + 1;
        int[] help = new int[len];
        int i = start, j = mid + 1;
        int index = 0  ;
        while (i <= mid && j <= end) {
            help[index++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }
        while (i <= mid) {
            help[index++] = nums[i++];
        }
        while (j <= end) {
            help[index++] = nums[j++];
        }
        for (int k = 0; k < len; k++) {
            nums[k + start] = help[k];
        }
    }


    public static void main(String[] args) {
        int[] tmp = {5, 1, 1, 3, 0, 0};
        tmp = sortArray(tmp);
        for (int i : tmp) {
            System.out.println(i);

        }
    }
}
