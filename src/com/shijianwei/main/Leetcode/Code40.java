package com.shijianwei.main.Leetcode;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/12 4:48
 */
public class Code40 {
    /* 回溯+剪枝 */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> list = new ArrayList<>();
        if (candidates.length == 0) {
            return list;
        }
        Arrays.sort(candidates);
        dfs(candidates, len, 0, target, list, new ArrayDeque<>());
        return list;
    }

    public static void dfs(int[] candidates, int len, int index, int target, List<List<Integer>> set, Deque<Integer> tmp) {
        if (0 == target) {
            set.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < len; i++) {
            /* 对于每次可以先用target-curSum进行剪枝 */
            if (target - candidates[index] < 0) {
                break;
            }
            // 2、对于同一层的数据进行二次剪枝
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmp.addLast(candidates[i]);
            dfs(candidates, len, i + 1, target - candidates[i], set, tmp);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{1}, 1);
        System.out.println(lists.toString());
    }
}
