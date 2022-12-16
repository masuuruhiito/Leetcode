package com.shijianwei.main.exam.oukeyunlian;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/16 15:23
 */
public class B {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String pStr = scanner.nextLine();
        String arrayStr = inputStr.substring(1, inputStr.lastIndexOf("]"));
        String[] arrayStrArray = arrayStr.split(",");
        Integer[] array = new Integer[arrayStrArray.length];
        for (int i = 0; i < arrayStrArray.length; i++) {
            if ("null".equals(arrayStrArray[i])) {
                continue;
            }
            array[i] = Integer.valueOf(arrayStrArray[i]);
        }

        TreeNode root = createTree(0, array);
        System.out.println(new B().kthSmallest(root, Integer.parseInt(pStr)));
    }

    static TreeNode createTree(int rootIndex, Integer[] values) {
        if (rootIndex >= values.length) {
            return null;
        }
        if (values[rootIndex] == null) {
            return null;
        }
        TreeNode rootNode = new TreeNode();
        rootNode.val = values[rootIndex];
        rootNode.left = createTree(2 * rootIndex + 1, values);
        rootNode.right = createTree(2 * rootIndex + 2, values);
        return rootNode;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
