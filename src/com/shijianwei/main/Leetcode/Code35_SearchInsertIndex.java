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

    /**
     * @author SHI
     * @date 2022/1/17 16:27
     *
     * 977. 有序数组的平方
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     */
    public static class Code977 {

    //    时间复杂度超限
        public static int[] sortedSquares(int[] nums) {
            int []numsp = new int [nums.length];
            for (int i = 0; i < nums.length; i++) {
                numsp[i]= nums[i]*nums[i];
            }
            Arrays.sort(numsp);
            return numsp;
        }


    //    使用双指针进行优化，将时间复杂度降低到o（n）级别
        public static int[] sortedSquares1(int[] nums) {
            int []res = new int [nums.length];
            int index = 0 ;
            boolean flag = false ;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]>0){
                    index= i ;
                    flag= true;
                    break;
                }
            }
            if(!flag){
                index = nums.length;
            }
            int i=index-1 , j= index,k=0;
            while (i>=0&&j<=nums.length-1){
                res[k++]= -nums[i] > nums[j] ? nums[j]*nums[j++] : nums[i]*nums[i--];
            }
            while (i>=0){
                res[k++]= nums[i]*nums[i--];
            }
            while (j <= nums.length - 1) {
                res[k++]= nums[j]*nums[j++];
            }
            return res ;
        }

        public static void main(String[] args) {
            int []a = {-5,-3,-2,-1};
            int []b = sortedSquares1(a);
            for (int i : b) {
                System.out.println(i);
            }
        }
    }
}
