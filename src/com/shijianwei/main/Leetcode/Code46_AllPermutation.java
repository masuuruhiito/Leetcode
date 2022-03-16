package com.shijianwei.main.Leetcode;

import java.util.*;

/**
 * @author SHI
 * @date 2022/2/27 20:03
 * 全排列
 * DFS (回溯算法：每次遍历到底，然后回退，换其他情况)
 *
 *
 * BFS实现全排列
 */
public class Code46_AllPermutation {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res ;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0 ,used,stack ,res );

        return res ;
    }

    public static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> stack, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<>(stack));
            return ;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true ;
            stack.addFirst(nums[i]);
            dfs(nums, len, depth + 1, used, stack, res);
            stack.removeFirst();
            used[i] = false ;
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
