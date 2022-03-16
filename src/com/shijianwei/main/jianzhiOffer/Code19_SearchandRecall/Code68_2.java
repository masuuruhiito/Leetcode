package com.shijianwei.main.jianzhiOffer.Code19_SearchandRecall;

import sun.reflect.generics.tree.Tree;

/**
 * @author SHI
 * @date 2022/2/13 19:13
 * 剑指 Offer 68 - II. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class Code68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null ||root==p||root== q) return  root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) return right;
        if(right== null) return left;
        return root ;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree();

    }
    public static TreeNode generateTree(){
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);

        root.left.left= new TreeNode(6);
        root.left.right= new TreeNode(2);
        root.right.left= new TreeNode(0);
        root.right.right= new TreeNode(8);


        root.left.right.left= new TreeNode(7);
        root.left.right.right= new TreeNode(4);


        return root ;
    }
}
