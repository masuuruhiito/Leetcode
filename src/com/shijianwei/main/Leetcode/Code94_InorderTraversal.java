package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/28 9:52
 */
public class Code94_InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        return res ;
    }

    public static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return ;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }
    public static void main(String[] args) {
        TreeNode head = generatorTree();
        List<Integer> res  = inorderTraversal(head);
        for (Integer re : res) {
            System.out.print(re+" ");
        }
    }

    public static TreeNode generatorTree() {
        TreeNode head = new TreeNode(1);
        head.right = new TreeNode(2);
        head.right.left = new TreeNode(3);
        return head;
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
