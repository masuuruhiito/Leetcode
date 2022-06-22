package com.shijianwei.main.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author SHI
 * @date 2022/4/23 18:05
 */
public class Code206_Reverselinkedlist {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 使用栈翻转链表，空间复杂度比较高
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode cur = new ListNode(-1);
        ListNode res = cur;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
            cur.next = null;
        }
        return res.next;
    }

    /**
     * 对于每个节点，翻转他和下一个节点的引用，先记录住下一个
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            head.next = tmp;
            pre = cur;
            cur = head.next;
        }
        return pre;
    }
    public static ListNode  generatorList(){
        ListNode head = new ListNode(1);
        head.next=  new ListNode(2);
        head.next.next=  new ListNode(3);
        head.next.next.next=  new ListNode(4);
        head.next.next.next.next=  new ListNode(5);
        head.next.next.next.next.next=  new ListNode(6);
        head.next.next.next.next.next.next=  new ListNode(7);
        head.next.next.next.next.next.next.next=  new ListNode(8);

        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = generatorList();
        ListNode listNode1 = reverseList1(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
