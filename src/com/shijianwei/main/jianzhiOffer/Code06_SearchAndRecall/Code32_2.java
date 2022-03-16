package com.shijianwei.main.jianzhiOffer.Code06_SearchAndRecall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SHI
 * @date 2022/1/29 17:15
 *
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Code32_2 {
    private static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> arr = new ArrayList<>();
        if(root!= null) queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i <len ; i++) {
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right !=null) queue.add(node.right);
                list.add(node.val);
            }
            arr.add(list);
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = construstTree();
        List<List<Integer>> list = levelOrder(root);

        for (int i = 0; i < list.size(); i++) {
            List<Integer> tmp = list.get(i);
            for (Integer integer : tmp) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
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

