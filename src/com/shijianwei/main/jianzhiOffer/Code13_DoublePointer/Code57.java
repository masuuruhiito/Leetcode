package com.shijianwei.main.jianzhiOffer.Code13_DoublePointer;

/**
 * @author SHI
 * @date 2022/2/7 20:34
 * 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 */
public class Code57 {
    public int[] twoSum(int[] nums, int target) {
        int  head = 0 ,end = nums.length-1 ;
        while (head<=end){
            if(target- nums[head] > nums[end])  head++;
            else if(target- nums[head] < nums[end]) end--;
            else return new int []{nums[head],nums[end]};
        }
        return null;
    }
}
