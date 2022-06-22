package com.shijianwei.main.Leetcode;

import java.util.List;

/**
 * @author SHI
 * @date 2022/4/28 9:02
 */
public class Code19_DelBottomNode {
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
     * 切记对链表操作的时候需要定义新的链表头
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        int i = 0;
        //找到删除节点的前一个节点
        while (fast != null) {
            fast = fast.next;
            if (i++ > n) slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
