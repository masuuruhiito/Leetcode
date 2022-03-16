package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/1/2 11:22
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 */
public class Code04_TwoSortedArrMedian {
    public static void main(String[] args) {
        int [] a  ={1,2,3,4,6};
        int [] b  ={1,6,8,9};
        int []c = hebing(a,b);
        System.out.printf("%.5f",findMedianSortedArrays(a, b));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        首先合并两个数组
        int []nums = hebing(nums1,nums2);
        if(nums.length%2==1){
            return nums[nums.length>>1];
        }else {
            return (double)(nums[nums.length>>1]+nums[(nums.length-1)>>1])/2;
        }
    }
    public static int[] hebing(int[] nums1, int[] nums2){
        int i = 0,k= 0 ,j = 0;
        int []nums = new int[nums1.length+nums2.length];
        while (i<nums1.length&&j<nums2.length){
            nums[k++]=nums1[i]> nums2[j]?nums2[j++]:nums1[i++];
        }
        while (i<nums1.length){
            nums[k++]=nums1[i++];
        }
        while (j<nums2.length){
            nums[k++]=nums2[j++];
        }
        return nums;
    }
}
