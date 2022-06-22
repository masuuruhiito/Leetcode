package com.shijianwei.main.Leetcode;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/28 11:23
 */
public class Code257_AllBinaryTreePath {

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
    }

    public static void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.val);
        if (root.left == null && root.right == null) {//叶子节点
            res.add(sb.toString());
        } else {
            sb.append("->");
            dfs(root.left, sb.toString(), res);
            dfs(root.right, sb.toString(), res);
        }
    }

    public static void bfs(TreeNode root, String path, List<String> res) {

    }

    public static void main(String[] args) {
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


    static List<String> res = new ArrayList<>();

    public static List<String> binaryTreePaths1(TreeNode root) {
        dfs1(root, new StringBuilder());
        return res;
    }


    public static void dfs1(TreeNode root, StringBuilder tmp) {
        if (root == null) {
            return;
        }
        StringBuilder cur = new StringBuilder(tmp);
        cur.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(cur.toString());
        }else {
            cur.append("->");
            dfs1(root.left, cur);
            dfs1(root.right, cur);
        }
    }
}
