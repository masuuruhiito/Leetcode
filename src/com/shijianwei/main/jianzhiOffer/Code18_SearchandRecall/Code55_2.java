package com.shijianwei.main.jianzhiOffer.Code18_SearchandRecall;


import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * @author SHI
 * @date 2022/2/13 15:27
 * 平衡二叉树：对于每个节点为根节点的二叉树的左子树和右子树的做大深度差不超过1
 *
 */
public class Code55_2 {
    public static boolean isBalanced(TreeNode root) {
        if(root == null ) return true;
        return Math.abs(maxDepth(root.left)-maxDepth(root.right))<=1&&isBalanced(root.left)&& isBalanced(root.right);
    }
    public static int maxDepth(TreeNode root){
        if(root== null ) return 0 ;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree();
        System.out.println(isBalanced(root));
    }
}
