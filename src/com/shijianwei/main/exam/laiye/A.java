package com.shijianwei.main.exam.laiye;

import java.util.HashMap;

/**
 * @author SHI
 * @date 2022/9/11 14:01
 */
public class A {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
