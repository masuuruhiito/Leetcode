package com.shijianwei.main.Leetcode;

import com.shijianwei.main.common.TreeNode;

/**
 * @author SHI
 * @date 2022/9/11 21:51
 */
public class Code124 {
    static int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max(root);
        return maxSum;
    }

    public static int max(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(max(root.left), 0);
        int right = Math.max(max(root.right), 0);

        maxSum = Math.max(maxSum, root.val + left + right);
        return root.val + Math.max(left, right);
    }

}
