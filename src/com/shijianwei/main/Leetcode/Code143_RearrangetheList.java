package com.shijianwei.main.Leetcode;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @author SHI
 * @date 2022/4/26 21:35
 */
public class Code143_RearrangetheList {
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

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < list.size(); i++) {
            int index = i / 2;
            if (i % 2 == 1) {
                cur.next = list.get(list.size() - 1 - index);
                cur = cur.next;
                cur.next = null;
            }else {
                cur.next = list.get(index);
                cur = cur.next;
                cur.next = null;
            }
        }
    }


    @Test
    public void reorderList1() {
        ListNode listNode = generatorList();
        reorderList1(listNode);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 首先找到链表中点，然后将后半截链表翻转，然后再将两个链表合并
     *
     * @param head
     */
    public void reorderList1(ListNode head) {
        ListNode cur = head;
        ListNode mid = findMid(cur);
        ListNode reverse = reverse(mid);
        head = merge(head, mid);
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode pre = new ListNode(-1, head);
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next;
            }
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = null;
        return slow;
    }


    public ListNode reverse(ListNode head) {
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


    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode cur = new ListNode(-1);
        ListNode res = cur;
        for (int i = 0; ; i++) {
            if (head1 == null || head2 == null) {
                break;
            }
            if (i % 2 == 0) {
                cur.next = head1;
                head1 = head1.next;
                cur = cur.next;
            }else {
                cur.next = head2;
                head2 = head2.next;
                cur = cur.next;
            }
        }
        cur.next = head1 == null ? head2 : head1;
        return res.next;
    }


    public static ListNode  generatorList(){
        ListNode head = new ListNode(1);
        head.next=  new ListNode(2);
        head.next.next=  new ListNode(3);
        head.next.next.next=  new ListNode(4);
        head.next.next.next.next=  new ListNode(5);
//        head.next.next.next.next.next=  new ListNode(6);
//        head.next.next.next.next.next.next=  new ListNode(7);
//        head.next.next.next.next.next.next.next=  new ListNode(8);

        return head;
    }


    @Test
    public void findMid() {
        System.out.println(findMid(generatorList()).val);
    }


    @Test
    public void reverse() {
        ListNode reverse = reverse(generatorList());
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }


    @Test
    public void merge() {
        ListNode merge = merge(generatorList(), generatorList());
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}
