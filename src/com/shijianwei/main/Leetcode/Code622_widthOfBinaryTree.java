package com.shijianwei.main.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SHI
 * @date 2022/4/11 17:41
 */
public class Code622_WidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0 ;
        Deque<TreeNode> queueNode = new LinkedList<>();
        Deque<Integer> queueIndex = new LinkedList<>();
        int res = 0;
        queueNode.add(root);
        queueIndex.add(0);
        while (!queueNode.isEmpty()) {
            int size = queueIndex.size();
            int tmpWidth = 0;
            boolean flag = false;
            int l = -1, r = -1;
            while (size-- > 0) {
                TreeNode node = queueNode.pollFirst();
                int index = queueIndex.pollFirst();
                if (!flag) {
                    l = index ;
                    flag = true;
                }
                r = index;
                if (node.left != null) {
                    queueNode.add(node.left);
                    queueIndex.add(index * 2 + 1);
                }
                if (node.right != null) {
                    queueNode.add(node.right);
                    queueIndex.add(index * 2 + 2);
                }
                tmpWidth = Math.max(tmpWidth, r - l + 1);
            }
            res = Math.max(tmpWidth, res);
        }

        return res;
    }
}
