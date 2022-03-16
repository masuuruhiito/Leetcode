package com.shijianwei.main.jianzhiOffer.Code04_Find;

/**
 * @author SHI
 * @date 2022/1/20 14:20
 *
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *
 *
 * 使用二分查找，查找到最小的那个数，然后进行比较
 */
public class Code53 {


    public static void main(String[] args) {
        int [] a = {5,7,7,8,8,10};
        System.out.println(search(a, 6));
    }
    public static int search(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target);
        if(leftIndex!=-1){
            int count = 1 ;
            for (int i = leftIndex+1; i < nums.length; i++) {
                if(nums[i]==target){
                    count++;
                }
            }
            return count;
        }
        return 0 ;
    }

    public static int binarySearch(int[] nums, int target) {
        if (nums == null) {
            return -1 ;
        }
        int i= 0, j = nums.length-1;
        while (i <= j) {
            int mid = i+((j-i)>>1);
//            int mid = (j+i)>>1 ;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]<target){
                    return mid ;
                }else {
                    j= mid -1 ;
                }
            }else if(nums[mid]<target){
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        return -1 ;
    }




    public static int binarySearchEvolution1(int []a,int target) { // target 目标
        if(a==null){
            return -1 ;
        }
        int i = 0,j = a.length-1;
        while (i<=j){
            int mid = (j+i)/2 ;
            if(a[mid]>=target){
                if(mid==0){
                    return mid ;
                }else if(a[mid-1]>=target){
                    j= mid -1 ;
                }else {
                    return mid ;
                }
            }else {
                i=mid+1;
            }
        }
        return -1;
    }
}
