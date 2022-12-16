package com.shijianwei.main.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author SHI
 * @date 2022/9/11 22:30
 */
public class Code77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }
        dfs(n, k, 0, res, new ArrayDeque<>());
        return res;
    }

    public static void dfs(int n, int k, int begin, List<List<Integer>> res, Deque<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = begin; i <= n; i++) {
            tmp.addLast(i);
            dfs(n, k, i + 1, res, tmp);
            tmp.removeLast();
        }
    }
}
