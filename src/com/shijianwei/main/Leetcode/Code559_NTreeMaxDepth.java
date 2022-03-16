package com.shijianwei.main.Leetcode;

import java.util.List;

/**
 * @author SHI
 * @date 2022/2/28 14:21
 */
public class Code559_NTreeMaxDepth {
    public int maxDepth(Node root) {
        if (root==null ) return 0 ;
        int max =Integer.MIN_VALUE;
        for (Node child : root.children) {
            max =Math.max(max,maxDepth(child));
        }
        return 1 +max;
    }

    static class Node{
        int val ;
        List<Node> children;

        public Node() {
        }

        public Node(int value) {
            this.val = value;
        }

        public Node(int value, List<Node> children) {
            this.val = value;
            this.children = children;
        }
    }
}
