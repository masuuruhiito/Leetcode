package com.shijianwei.main.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author SHI
 * @date 2022/9/12 5:35
 */
public class Code216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, k, n, res, new ArrayDeque<>(9));
        return res;
    }

    public static void dfs(int begin, int k, int target, List<List<Integer>> res, Deque<Integer> tmp) {
        if (tmp.size() == k) {
            if (target == 0)
                res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i <= 9 - (k - tmp.size()) + 1; i++) {
            if (target - i < 0) {
                break;
            }
            tmp.addLast(i);
            dfs(i + 1, k, target - i, res, tmp);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = combinationSum3(3, 7);
        System.out.println(list.toString());
    }
}
