package com.shijianwei.main.Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SHI
 * @date 2022/3/26 19:38
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class Code141_CircularLinkedList {
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
     * 这题可以将所有节点放入set中，ifcontains return true；
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode cur = head ;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return true ;
            }
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }





    /**
     * 也可以使用快慢指针，快指针一次走两格，慢指针一次一格，
     * 只要快慢指针相等，就返回，或者fast== null return false
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }
}
