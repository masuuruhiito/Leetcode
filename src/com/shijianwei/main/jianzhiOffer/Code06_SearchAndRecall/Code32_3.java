package com.shijianwei.main.jianzhiOffer.Code06_SearchAndRecall;

import java.util.*;

/**
 * @author SHI
 * @date 2022/1/30 8:52
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 */
public class Code32_3 {
    public static void main(String[] args) {
        TreeNode root = construstTree();
        List<List<Integer>> list = levelOrder(root);

        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = list.get(i);
            for (Integer integer : tmp) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    //    goujianerchashu
    private static TreeNode construstTree() {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.right = node5;
        node3.left = node4;

        return node1;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> resList = new ArrayList<>();
        if (root != null) queue.add(root);
        int layer = 0;
        while (!queue.isEmpty()) {
            layer++;
            List<Integer> list = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if(layer%2==0) ((LinkedList<Integer>) list).addFirst(node.val);
                else ((LinkedList<Integer>) list).addLast(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

            }
            resList.add(list);
        }
        return resList;
    }
}
