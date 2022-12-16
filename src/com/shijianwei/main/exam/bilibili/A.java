package com.shijianwei.main.exam.bilibili;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHI
 * @date 2022/9/20 18:59
 */
public class A {
    public static ListNode longestList(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        // write code here
        // 头节点为奇数
        ListNode jcur = head;
        int j = 1;
        int o = 0;
        int jsum = 0;
        int osum = 0;
        List<ListNode> jlist = new ArrayList<>();
        List<ListNode> olist = new ArrayList<>();
        while (jcur != null) {
            if (jcur.val % 2 == j % 2) {
                j++;
            } else {
                jsum++;
                jlist.add(jcur);
            }
            if (jcur.val % 2 == o % 2) {
                o++;
            } else {
                osum++;
                olist.add(jcur);
            }
            jcur = jcur.next;
        }

        pre = deleted(pre, jsum > osum ? olist : jlist);
        return pre.next;
    }

    public static ListNode deleted(ListNode head, List<ListNode> list) {
        if (list.size() == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        int index = 0;
        while (cur != null) {
            if (cur == list.get(index) && pre != null) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode generatorList(){
        ListNode head = new ListNode(1);
        head.next=  new ListNode(2);
        head.next.next=  new ListNode(2);
        head.next.next.next=  new ListNode(3);
        head.next.next.next.next=  new ListNode(4);
        head.next.next.next.next.next=  new ListNode(5);
//        head.next.next.next.next.next=  new ListNode(6);
//        head.next.next.next.next.next.next=  new ListNode(7);
//        head.next.next.next.next.next.next.next=  new ListNode(8);

        return head;
    }
    public static void main(String[] args) {

        ListNode listNode = longestList(generatorList());
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
