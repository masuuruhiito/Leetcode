package com.shijianwei.main.jianzhiOffer.Code02_Link;

import com.sun.deploy.cache.CacheEntry;

/**
 * @author SHI
 * @date 2022/1/17 14:12
 *
 * 剑指 Offer 35. 复杂链表的复制     ***********
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 *
 */
public class Code35 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

//    实现复制复杂链表
    public static Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        //将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
        for (Node node = head, copy = null; node != null; node = node.next.next) {
            copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
        }
        //把拷贝节点的random指针安排上
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }
        //分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
        Node newHead = head.next;
        for (Node node = head, temp = null; node != null && node.next != null;) {
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }

        return newHead;
    }



//    public static Node copyList(Node head) {
//        Node node=  head  ;
//        while (node!=null ){
//            Node newnode = new Node(head.val);
//
//            head.next = node;
//            head = head.next;
//        }
//    }
    public static void main(String[] args) {

    }
}
