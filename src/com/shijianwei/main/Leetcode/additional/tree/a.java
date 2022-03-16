package com.shijianwei.main.Leetcode.additional.tree;

/**
 * @author SHI
 * @date 2022/1/29 20:10
 *
 * 找出二叉树的最大子树和（含有负数）
 *
 * 使用后序遍历，左右根
 */
public class a {
//    构造树方法
    private static TreeNode construstTree(){
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();
        TreeNode node5 = new TreeNode();
        TreeNode node6 = new TreeNode();
//
        node1.value =6;
        node2.value =3;
        node3.value =-7;
        node4.value =-1;
        node5.value =9;

        node1.left= node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        return node1;
    }

    private static int maxSum = Integer.MIN_VALUE;
    public static int findMaxChildTree(TreeNode root,TreeNode resNode ){
        if(root==null){
            return 0;
        }
        int l = findMaxChildTree(root.left,resNode);
        int r = findMaxChildTree(root.right,resNode);
        int sum = l+r+root.value;
        if(sum>maxSum){
            maxSum = sum ;
            resNode = root;
        }
        return sum ;
    }


    public static void main(String[] args) {
        TreeNode root = construstTree();
        TreeNode node = root ;
        findMaxChildTree(root,node);
        System.out.println(maxSum);
        System.out.println(node.value);
    }

    static class TreeNode{
        int value ;
        TreeNode left ;
        TreeNode right ;

    }

}

