package com.shijianwei.main.Leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SHI
 * @date 2022/2/27 20:03
 * 全排列
 * DFS (回溯算法：每次遍历到底，然后回退，换其他情况)
 * <p>
 * <p>
 * BFS实现全排列
 */
public class Code46_AllPermutation {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res);
        return res;
    }

    public static void dfs(int[] nums, int begin, List<List<Integer>> res) {
        if (begin == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, i, begin);
            dfs(nums, i + 1, res);
            swap(nums, i, begin);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, nums.length, 0, used, stack, res);

        return res;
    }

    public static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> stack, List<List<Integer>> res) {
        if (len == depth) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            stack.addFirst(nums[i]);
            dfs(nums, len, depth + 1, used, stack, res);
            stack.removeFirst();
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }


    /**
     * 这个方法
     */
    List<String> res = new ArrayList<>();

    public List<String> permute1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs1(nums, 0);
        return res;
    }

    public void dfs1(int[] nums, int curIndex) {
        if (curIndex == nums.length - 1) {
            res.add(toString1(nums));
            return;
        }
        for (int i = curIndex; i < nums.length; i++) {
            swap(nums, i, curIndex);
            dfs1(nums, curIndex + 1);
            swap(nums, i, curIndex);
        }
    }


    @Test
    public void bbbb(){
        List<String> list = permute1(new int[]{1, 2, 3, 4});
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static String toString1(int[] nums) {
        StringBuilder res = new StringBuilder();
        for (int num : nums) {
            res.append(num).append(" ");
        }
        return res.toString();
    }
}
