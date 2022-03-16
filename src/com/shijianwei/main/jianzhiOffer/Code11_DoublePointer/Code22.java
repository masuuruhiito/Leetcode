package com.shijianwei.main.jianzhiOffer.Code11_DoublePointer;

import javax.swing.*;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/7 15:12
 */
public class Code22 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head ;
        ListNode slow = head ;
        int len = 0 ;
        while (fast!=null){
            fast = fast.next;
            len++ ;
        }
        for (int i = k; i < len; i++) {
            slow = slow.next;
        }
        return slow ;
    }

    public static ListNode conList(){
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head ;
    }

    public static void main(String[] args) {
        ListNode head = conList();
        System.out.println(getKthFromEnd(head, 2).val);
    }
}
