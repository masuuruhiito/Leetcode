package com.shijianwei.main.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

/**
 * @author SHI
 * @date 2022/3/27 11:54
 */
public class Code33_SearchRotateSortedArr {
    /**
     * 这样做没啥意思，不过时间和空间还是挺优化的
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return map.getOrDefault(target, -1);
    }



    /**
     * 看题解根据升序和旋转，那么可以看是二分查找的变形
     * @param nums
     * @param target
     * @return
     */
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1 ;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
//            求出此时的mid
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
//            首先判断mid是在旋转数组的左侧还是右侧，
            if (nums[mid] >= nums[l]) {//in left
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{//in right
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1 ;
    }




//    些许浪费时间
    public int search2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1 ;
        }
        int i = 0; //原数组头位置
        for (i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }
        int len = nums.length - i; //翻转的长度
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1) < 3 ?
                    i + l + ((r - l) >> 1) :
                    l + ((r - l) >> 1) - 3;
            if (nums[mid] > target) {
                r--;
            } else if (nums[mid] < target) {
                l++;
            }else {
                return l + ((r - l) >> 1);
            }
        }
        return -1;
    }





}
