package com.shijianwei.main.jianzhiOffer.Code19_SearchandRecall;

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
        TreeNode root = new TreeNode(6);
        root.left=new TreeNode(2);
        root.right=new TreeNode(8);

        root.left.left= new TreeNode(0);
        root.left.right= new TreeNode(4);
        root.right.left= new TreeNode(7);
        root.right.right= new TreeNode(9);


        root.left.right.left= new TreeNode(3);
        root.left.right.right= new TreeNode(5);


        return root ;
    }
}
