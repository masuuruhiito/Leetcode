package com.shijianwei.main.jianzhiOffer.Code19_SearchandRecall;

/**
 * @author SHI
 * @date 2022/2/13 18:48
 *剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 */
public class Code68 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>q.val) {TreeNode tmp = p ; p = q; q = tmp ;}
        while (root!=null ){
            if(root.val>q.val) root = root.left;
            else if(root.val<p.val) root = root.right ;
            else break;
        }
        return root;
    }

    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&& root.val>q.val){
            return lowestCommonAncestor1(root.left,p,q);
        }else if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor1(root,p,q);
        }else{
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree();
        lowestCommonAncestor1(root,root.left.left,root.left.right.right);
    }
}
