package com.shijianwei.main.Leetcode;

import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author SHI
 * @date 2022/3/28 15:29
 */
public class Code863_DistanceKsTreeNode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 可以把本题的树就当成图来计算，对每个节点都去dfs其左子树，右子树以及其父节点
     * 因为没有树的父节点对应关系，可以将数据存放在map中，然后对每个节点get就可以了
     *
     *
     * 中间出现错误：
     *      dfs时，不能回头，需要记录当前节点，然后下次递归调用时不能回头导致出现错误
     *          判断条件不是当前节点!= null 而是 当前节点！= src
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return null;
        }
//        首先根据root获得到所有节点的父节点
        Map<TreeNode, TreeNode> map = new HashMap<>();
        getParent(root, map);

        List<Integer> res = new ArrayList<>();
//        然后就可以从target出发，然后每次遍历他的三个方位，变成图
        dfs(null ,target, map, k, res, 0);
        return res;
    }

    public static void getParent(TreeNode root,Map<TreeNode, TreeNode> map) {
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
            getParent(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right, root);
            getParent(root.right, map);
        }
    }


    public static void dfs(TreeNode src , TreeNode target, Map<TreeNode, TreeNode> map, int k, List<Integer> res, int depth) {
        if (target == null) {
            return;
        }
        if (depth == k) {
            res.add(target.val);
            return;
        }
        if (target.left != src) {
            dfs(target,target.left, map, k, res, depth + 1);
        }
        if (target.right != src) {
            dfs(target,target.right, map, k, res, depth + 1);
        }
        if (map.get(target) != src) {
            dfs(target,map.get(target), map, k, res, depth + 1);
        }
    }






    @Test
    public void aa(){
        TreeNode root = generateTree();
//        Map<TreeNode, TreeNode> map = new HashMap<>();
//        getParent(root, map);
        List<Integer> list = distanceK(root, root.left, 2);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }



    public static TreeNode generateTree(){
        TreeNode root = new TreeNode(3);
        root.left=new TreeNode(5);
        root.right=new TreeNode(1);

        root.left.left= new TreeNode(6);
        root.left.right= new TreeNode(2);
        root.right.left= new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        return root ;
    }


}
