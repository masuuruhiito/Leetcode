package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/1 10:42
 * Binary tree
 *
 * 判断的时候不能只看不正确的值，也需要返回true；
 */
public class Code101_SymmetryBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        return judge(root.left,root.right);
    }

    public static boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null ) {
            return true ;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && judge(left.left, right.right) && judge(left.right, right.left);

    }

    static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
