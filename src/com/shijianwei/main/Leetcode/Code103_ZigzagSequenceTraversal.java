package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SHI
 * @date 2022/2/27 15:33
 */
public class Code103_ZigzagSequenceTraversal {

    public static void main(String[] args) {
        TreeNode root = construstTree();
        List<List<Integer>> list = zigzagLevelOrder(root);

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

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if( root!=null ) queue.add(root);
        int layer = 0 ;
        while (queue.size()!=0) {
            layer ++;
            int len = queue.size();
            LinkedList<Integer> list  = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                if(layer%2 ==0) list.addFirst(node.val);
                else list.addLast(node.val);

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(list);

        }
        return res ;
    }

    static class TreeNode{
        int val ;
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
