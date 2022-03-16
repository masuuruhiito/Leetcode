package com.shijianwei.main.Leetcode;

import java.util.*;

/**
 * @author SHI
 * @date 2022/3/5 21:48
 *
 * 中序遍历，直接看是不是有序的就可以
 *
 * 可以不使用递归的方式，然后可以出现第一次不符合规定的时候返回false
 *
 * 也可以直接递归，但是刚刚没找到条件
 */
public class Code98_IsValidBST {
    public boolean isValidBST(TreeNode root) {
        inOrder(root);

        Iterator<Integer> iterable = res.iterator();
        Long pre = Long.MIN_VALUE;
        while (iterable.hasNext()) {
            int cur = iterable.next();
            if (cur <= pre) {
                return false;
            }
            pre = (long) cur ;
        }
        return true;
    }

    List<Integer> res = new ArrayList<>();
    public void  inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        return isValidBST1(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST1(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (min >= root.val || max <= root.val) {
            return false;
        }
        return isValidBST1(root.left, min, root.val) && isValidBST1(root.right, root.val, max);
    }


    /**
     * 非递归式中序遍历
     * @param root
     */
    public static void isValidBST2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (stack != null || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();

            }

        }
    }

    public boolean isValidBST3(TreeNode root) {
        return inOrder3(root);
    }
    long pre = Long.MIN_VALUE;
    public boolean inOrder3(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean l = inOrder3(root.left);
        if(root.val <= pre) return false;
        pre = root.val ;
        boolean r = inOrder3(root.right);


        return l && r;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }

        TreeNode(int x) {
            val = x;
        }
    }
}
