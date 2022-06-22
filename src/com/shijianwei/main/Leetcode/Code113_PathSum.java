package com.shijianwei.main.Leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/4/18 17:58
 */
public class Code113_PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, targetSum, 0, res, new LinkedList<>());
        return res;
    }

    public static void dfs(TreeNode root, int targetSum, int curSum,
                                          List<List<Integer>> res , LinkedList<Integer> tmp) {
        if (root == null) {
            return;
        }
        tmp.offerLast(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == targetSum) {
//            这里不能直接写add（tmp）是因为多次添加会因为tmp的地址相同而导致覆盖
            res.add(new ArrayList<>(tmp));
        }
        dfs(root.left, targetSum, curSum, res, tmp);
        dfs(root.right, targetSum, curSum, res, tmp);
        tmp.pollLast();
    }


    public static TreeNode generatorTree() {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(4);
        head.left.left = new TreeNode(11);
        head.left.left.left = new TreeNode(7);
        head.left.left.right = new TreeNode(2);

        head.right = new TreeNode(8);
        head.right.left = new TreeNode(13);
        head.right.right = new TreeNode(4);
        head.right.right.left = new TreeNode(5);
        head.right.right.right = new TreeNode(1);
        return head;
    }



    @Test
    public void aaa(){
        TreeNode root = generatorTree();
        List<List<Integer>> lists = pathSum(root, 22);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
