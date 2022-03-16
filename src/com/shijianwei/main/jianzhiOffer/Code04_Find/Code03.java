package com.shijianwei.main.jianzhiOffer.Code04_Find;

import java.util.HashSet;

/**
 * @author SHI
 * @date 2022/1/20 14:05
 *
 * 剑指 Offer 03. 数组中重复的数字
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class Code03 {

    public static void main(String[] args) {
        int []a = {1,2,3,4,5,2,4,1};
        System.out.println(findRepeatNumber1(a));
    }

    public static int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if(set.size()!=i+1){
                return nums[i];
            }
        }
        return -1;
    }



    public static int findRepeatNumber1(int[] nums) {
        int[] count = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(++count[nums[i]] > 1){
                return nums[i];
            }
        }
        throw new RuntimeException("Not Found");
    }
}
