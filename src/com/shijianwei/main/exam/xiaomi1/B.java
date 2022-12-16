package com.shijianwei.main.exam.xiaomi1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/9/14 19:08
 */
public class B {
    /* Write Code Here */
    public Node  Convert(Node pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        addToList(pRootOfTree);
        Node head = pRootOfTree;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    public Node addToList(Node cur) {
        if (cur == null) {
            return null;
        }
        Node left = addToList(cur.left);
        Node right = addToList(cur.right);

        if (left != null) {
            while (left.right != null) {
                left = left.right;
            }
            left.right = cur;
            cur.left = left;
        }
        if (right != null) {
            while (right.left != null) {
                right = right.left;
            }
            cur.right = right;
            right.left = cur;
        }
        return cur;
    }

    static class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Node res = null;
            List<Node> list = new ArrayList<>();

            while (in.hasNext()) {
                int item = in.nextInt();
                if (item == -1) {
                    list.add(null);
                } else {
                    list.add(new Node(item));
                }
            }
            int len = list.size();
            int i = 0;
            while (i <= (len - 2) / 2) {
                if (2 * i + 1 < len && list.get(i) != null) {
                    list.get(i).left = list.get(2 * i + 1);
                }
                if (2 * i + 2 < len && list.get(i) != null) {
                    list.get(i).right = list.get(2 * i + 2);
                }
                i++;
            }

            res = new B().Convert(list.get(0));
            if (res != null) {
                while (res.right != null && res.data != -1) {
                    System.out.print(String.valueOf(res.data) + " ");
                    res = res.right;
                }
                System.out.print(res.data + " ");
                while (res.left != null && res.data != -1) {
                    System.out.print(String.valueOf(res.data) + " ");
                    res = res.left;
                }
                System.out.print(res.data);
            }
            System.out.println();
        }
    }

}

