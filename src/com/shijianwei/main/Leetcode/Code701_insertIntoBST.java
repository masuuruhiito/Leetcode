package com.shijianwei.main.Leetcode;

class Code701_insertIntoBST {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode proo=root;
        inserIN(proo,val);
        return root;
    }
    public static void inserIN(TreeNode root,int val){
//        if(root==null){
//            root= new TreeNode(val);
//            return;
//        }
        if (root.left == null && root.right == null) {
            if (val > root.val) root.right = new TreeNode(val);
            if (val < root.val) root.left = new TreeNode(val);
        } else if (root.right == null) {
            if (val > root.val) root.right = new TreeNode(val);
            if (val < root.val) inserIN(root.left, val);
        } else if (root.left == null) {
            if (val > root.val) inserIN(root.right, val);
            if (val < root.val) root.left = new TreeNode(val);
        } else {
            inserIN(val<root.val? root.left:root.right,val);
        }
        
    }


    public static void main(String[] args) {
        TreeNode treeNode = generateTree();
        insertIntoBST(treeNode,4);

    }

    public static TreeNode generateTree(){
        TreeNode root = new TreeNode(5);
        root.right=new TreeNode(14);

        root.right.left= new TreeNode(10);
        root.right.right= new TreeNode(77);


        root.right.left.right= new TreeNode(95);


        return root ;
    }
}
