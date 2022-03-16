package com.shijianwei.main.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SHI
 * @date 2022/3/1 11:12
 *
 * 通过hash表逐一比较，后面出现的前面出现过的值会被覆盖，并不影响结果(每次o(1)，最终共O(n))
 * 或者直接暴力解法（两层循环判断有没有target，O（n^2））
 */
public class Code01_TwoNunSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                return new int []{map.get(target-nums[i]) , i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
