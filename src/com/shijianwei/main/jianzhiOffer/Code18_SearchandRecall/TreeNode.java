package com.shijianwei.main.jianzhiOffer.Code18_SearchandRecall;

import sun.reflect.generics.tree.Tree;

/**
 * @author SHI
 * @date 2022/2/13 15:42
 */
public class TreeNode {
    int val;
    TreeNode left ;
    TreeNode right ;

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode generateTree(){
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);

        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(3);
        root.right.left= new TreeNode(3);
        root.right.right= new TreeNode(3);

        root.left.left.left= new TreeNode(4);
        root.left.left.right= new TreeNode(4);
        root.left.right.left= new TreeNode(4);
        root.left.right.right= new TreeNode(4);
        root.right.left.left= new TreeNode(4);
        root.right.left.right= new TreeNode(4);

        root.left.left.left.left = new TreeNode(5);
        root.left.left.left.right = new TreeNode(5);

        return root ;
    }
}
