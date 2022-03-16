package com.shijianwei.main.jianzhiOffer.Code04_Find;

/**
 * @author SHI
 * @date 2022/1/20 15:42
 * <p>
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class Code53_02 {
    public static int missingNumber(int[] nums) {
        if (nums == null) {
            return -1;
        }

//        if (nums[0] != 0) {
//            return 0;
//        }
//        if (nums[nums.length-1] == nums.length-1) {
//            return nums.length;
//        }


//        如果0号正确的情况下，那么肯定长度大于一，所以不用判断
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] != mid) {//证明丢失数据应该在左边或者mid本身
                j=mid-1 ;
            } else {//证明在右边
                i = mid+1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(missingNumber(a));
    }
}
