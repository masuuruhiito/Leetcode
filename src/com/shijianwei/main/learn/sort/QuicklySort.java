package com.shijianwei.main.learn.sort;

/**
 * @author SHI
 * @date 2022/4/24 18:14
 */
public class QuicklySort {
    public static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return ;
        }
        int random = l + (int) (Math.random() * (r - l));
        swap(nums, random, r);
        int[] partation = partation(nums, l, r);
        quickSort(nums, l, partation[0]);
        quickSort(nums, partation[1], r);
    }

    public static int[] partation(int[] nums, int l, int r) {
        int i = l - 1, j = r;
        int left = l;
        int target = nums[r];
        while (left < j) {
            if (nums[left] > target) {
                swap(nums, left, --j);
            } else if (nums[left] < target) {
                swap(nums, left++, ++i);
            } else {
                left++;
            }
        }
//        swap(nums, r, j);
        return new int[]{i, j};
    }


    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{4,2,6,3,6,4,8};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
