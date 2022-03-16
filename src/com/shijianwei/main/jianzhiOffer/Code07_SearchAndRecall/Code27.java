package com.shijianwei.main.jianzhiOffer.Code07_SearchAndRecall;

import javax.xml.soap.Node;
import java.util.List;
import java.util.Stack;

/**
 * @author SHI
 * @date 2022/1/30 11:15
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *  首先想复制节点的时候，另外开一个地址，然后左右跟，左根右，跟左右
 *
 */
public class Code27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null ;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left!=null) stack.push(node.left);
            if(node.left!=null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root ;
    }

    public TreeNode firstOrder(TreeNode node){
        if(node==null) return null;
        System.out.println(node.val);
        TreeNode tmp = node.left;
        node.left = firstOrder(node.right);
        node.right = firstOrder(tmp);
        return node ;
    }

    public static void main(String[] args) {
        TreeNode root = construstTree();

    }
    //    goujianerchashu
    private static TreeNode construstTree(){
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2 ;
        node1.right = node3 ;

        node3.right= node5;
        node3.left = node4 ;

        return node1;
    }
}
