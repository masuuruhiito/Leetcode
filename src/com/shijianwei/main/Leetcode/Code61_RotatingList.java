package com.shijianwei.main.Leetcode;

import com.sun.corba.se.spi.orbutil.fsm.FSM;
import org.junit.Test;

import java.util.List;

/**
 * @author SHI
 * @date 2022/3/29 16:38
 */
public class Code61_RotatingList {
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
     * 思路:
     * 旋转链表,那么就可以定义dummy然后通过双指针计算出来应该在哪交换
     * 然后dummy.next= node node.next... = head;
     * 注:这个k可能比len大,那么就可以先进行取模操作
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (fast != null ) {
            fast = fast.next;
            len++;
        }
        k %= len;
        if (k == 0) {
            return head;
        }
        fast = head ;
        int i = 0 ;
        while (fast != null) {
            if (i++ > k) {
                slow = slow.next;
            }
            fast = fast.next;
        }

        ListNode node = slow.next;
        dummy.next = node ;
        slow.next = null ;

        for (int j = 0; j < k - 1; j++) {
            node = node.next;
        }
        node.next = head ;


        return dummy.next;

    }


    @Test
    public void aaa(){
        ListNode listNode = generatorList();
        rotateRight(listNode, 4);
    }

    public static ListNode  generatorList(){
        ListNode head = new ListNode(0);
        head.next=  new ListNode(1);
        head.next.next=  new ListNode(2);
        return head;
    }
}
