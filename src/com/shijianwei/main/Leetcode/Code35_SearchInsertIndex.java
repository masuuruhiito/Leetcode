package com.shijianwei.main.Leetcode;

import java.util.Arrays;

/**
 * @author SHI
 * @date 2022/1/16 19:43
 *
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *      如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。(二分查找)
 */
public class Code35_SearchInsertIndex {
    public static void main(String[] args) {
        System.out.println(Solution.searchInsert(new int[]{1,2,4,5}, 3));
    }
    static class Solution {
        public static int searchInsert(int[] nums, int target) {
            int i= 0 ,j = nums.length-1 ;
            while (i<=j){
                int mid = i+((j-i)>>1);
                if(nums[mid]==target){
                    return mid ;
                }else if(nums[mid] >target){
                    j = mid -1 ;
                }else {
                    i = mid +1 ;
                }
            }
            return i ;
        }
    }


}
