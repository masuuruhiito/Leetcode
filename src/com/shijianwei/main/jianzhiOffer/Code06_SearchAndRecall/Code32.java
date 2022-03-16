package com.shijianwei.main.jianzhiOffer.Code06_SearchAndRecall;

import sun.reflect.generics.tree.Tree;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @author SHI
 * @date 2022/1/29 14:57
 * 面试题32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *
 * 实现BFS    先将节点保存在队列中，然后将当前节点的左右孩子入队，将当前节点弹出，保存在数组中
 *           然后重复进行将头节点的左右孩子入队，然后头节点弹出，保存在数组中
 *           队列为空时证明没有孩子了
 *
 */
public class Code32 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        int res [] = levelOrder(root);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }
    public static int[] levelOrder(TreeNode root) {
        if(root==null) return new int [0];
        List<Integer> arr= new ArrayList<>();
        TreeNode node = root ;
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(node);
        while (queue.size()!=0){
            node = ((LinkedList<TreeNode>) queue).getFirst();

            if(node.left!=null){
                ((LinkedList<TreeNode>) queue).add(node.left);
            }
            if(node.right!=null){
                ((LinkedList<TreeNode>) queue).add(node.right);
            }

            arr.add(queue.poll().val) ;
        }
        int []res = new int[arr.size()];
        int i = 0 ;
        for (Integer integer : arr) {
            res[i++] = integer ;
        }
        return res ;
    }



}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
