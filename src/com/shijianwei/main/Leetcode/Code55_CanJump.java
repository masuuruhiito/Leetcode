package com.shijianwei.main.Leetcode;

import org.junit.Test;

/**
 * @author SHI
 * @date 2022/4/22 15:35
 */
public class Code55_CanJump {


    /**
     * [5,9,3,2,1,0,2,3,3,1,0,0]
     * 这个数据过不去，不能只考虑当下最优，还要考虑全局能不能到的问题
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int maxIndex = i;
            for (int j = i; j < ((i + nums[i]) < nums.length ? (i + nums[i]) : nums.length); j++) {
                maxIndex = Math.max(maxIndex, j + nums[j]);
            }
            if (maxIndex > i) {
                i = maxIndex-1;
            }else if (maxIndex < nums.length-1){
                return false;
            }
        }
        return true;
    }

    @Test
    public void canJumpTest() {
        int[] ints = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump2(ints));

    }



    public boolean canJump1(int[] nums) {
        return dfs(nums, 0);
    }

    private boolean dfs(int[] nums, int index) {
        if (index == nums.length-1) {
            return true;
        }
        int maxIndex = 0, maxValue = 0;
        for (int i = 0; i < nums[index]; i++) {

        }
        if (maxIndex == 0) {
            return false;
        }
        return dfs(nums, index);
    }


    public boolean canJump2(int[] nums) {
        int rightmost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
