package com.shijianwei.main.jianzhiOffer.Code23_Math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SHI
 * @date 2022/2/15 15:53
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * 可以通过hashmap sort 和摩尔投票法（超过半数的数为1，不超过的为-1），将票数与0比较
 */
public class Code39 {
    public static int majorityElement1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer)>(nums.length/2)) return integer;
        }
        return Integer.MIN_VALUE;
    }

//    摩尔投票法：如果count==0 证明这个数一定在数组的后面
    public static int majorityElement(int[] nums) {
        int count  =0 , res =0 ;
        for (int num : nums) {
            if(count==0) res = num;
            count += num == res ? 1 : -1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
