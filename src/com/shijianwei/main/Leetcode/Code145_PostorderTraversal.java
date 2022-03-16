package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/28 14:13
 */
public class Code145_PostorderTraversal {


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res ;
    }

    public void postorder(TreeNode root,List<Integer> res) {
        if (root == null) {
            return ;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
