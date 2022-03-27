package com.shijianwei.main.learn.algorithm;

import org.junit.Test;

/**
 * @author SHI
 * @date 2022/3/27 17:47
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void BinarySearchTest(){
        System.out.println(binarySearch(new int[]{1,2,3,4,4},6));
        System.out.println(binarySearch(new int[]{1,2,3,4,4},3));
    }
}
