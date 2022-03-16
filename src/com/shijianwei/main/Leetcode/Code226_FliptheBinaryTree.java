package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/3/12 14:20
 */
public class Code226_FliptheBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void invertTree(TreeNode root) {
        if (root == null) {
            return ;
        }
        swap(root);
        invertTree(root.left);
        invertTree(root.right);
    }

    public static void swap(TreeNode node) {
        TreeNode tmp = node.left ;
        node.left = node.right;
        node.right = tmp ;
    }
    public static void main(String[] args) {
        TreeNode treeNode = generateTree();
        List<Integer> list = inorderTraversal(treeNode);
//        invertTree(treeNode);
        List<Integer> list1 = inorderTraversal(treeNode);

        System.out.println(list.equals(list1));

        for (Integer integer : list1) {
            System.out.print(integer+" ");
        }
        System.out.println();
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }

    }

    public static TreeNode generateTree(){
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);

        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(5);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);

        root.left.left.left= new TreeNode(8);
        root.left.left.right= new TreeNode(9);
        return root ;
    }



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


}
