package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/1 11:00
 */
public class Code111_MinDepth {
    public static int minDepth(TreeNode root) {
        if (root == null ) return 0;
//        判断是否为叶子节点
        if (root.left == null && root.right == null) {
            return 1 ;
        }
        if (root.left == null || root.right == null) {
            TreeNode node = root.right == null ? root.left : root.right;
            return 1 + minDepth(node);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println(minDepth(generateTree()));
    }
    static class TreeNode{
        int val ;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }
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
