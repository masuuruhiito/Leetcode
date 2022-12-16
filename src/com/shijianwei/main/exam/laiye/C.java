package com.shijianwei.main.exam.laiye;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/9/11 14:21
 */
public class C {
    static List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        digui(nums, 0);
        return res;
    }

    public static void digui(int[] nums, int index) {
        if (index >= nums.length) {
//            res.add(Arrays.toString(nums));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            digui(nums, i + 1);
            swap(nums, i, index);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
