package com.shijianwei.main.learn.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 想实现LRU，put和get都是o1
 *   可以使用多种数据结构叠加的方式
 *   各取优点
 *       puto1可以使用hashmap来实现，但是此时getLRU不是o1
 *       getlRUo1可以使用双向链表实现，记录每次的最近查询
 */

class LevelOrder {

//    实现层序遍历
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


    public static List<List<Integer>> LevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                tmp.add(poll.val);
            }
            res.add(tmp);
        }
        return res;
    }
}
