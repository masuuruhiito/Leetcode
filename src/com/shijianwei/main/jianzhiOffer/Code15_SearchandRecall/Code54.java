package com.shijianwei.main.jianzhiOffer.Code15_SearchandRecall;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/8 16:35
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 */
public class Code54 {
    static List<Integer> list ;
    static int k ;
    static class TreeNode{
        int val ;
        TreeNode left ;
        TreeNode right ;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    // 中序遍历的第四个数为当前
    public int kthLargest(TreeNode root, int k) {
        this.k =k ;
        list = new ArrayList<>();
        inOrder(root);
        return list.get(list.size()-k);
    }
//    这样为遍历全部的节点，性能较慢
    public static void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }


//    方法：因为为二叉搜索树，可以中序遍历，然后将后几个数据拿出来，
//          调整中序遍历为右根左，就可以将遍历出来的数据直接返回
//    中序遍历不需要返回值，可以将每个节点的值都保存来，然后在求出第k个数据的时候直接断掉

    static int res ;
    public static void inOrder1(TreeNode root){
        if(root == null || k<=0) return ;
        inOrder(root.right);
        if(--k==0) res = root.val;
        inOrder(root.left);
    }
}
