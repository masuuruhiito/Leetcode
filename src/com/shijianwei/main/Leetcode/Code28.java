package com.shijianwei.main.Leetcode;

import com.shijianwei.main.common.TreeNode;

/**
 * @author SHI
 * @date 2022/9/11 22:00
 */
public class Code28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    public static boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
}
