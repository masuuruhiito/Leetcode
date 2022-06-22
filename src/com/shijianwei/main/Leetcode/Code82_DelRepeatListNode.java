package com.shijianwei.main.Leetcode;

import org.junit.Test;

/**
 * @author SHI
 * @date 2022/4/5 12:49
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 */
public class Code82_DelRepeatListNode {
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
     * 因为是有序的，就保存当前节点，然后看下一个节点是否和当前节点相同
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int tmp = cur.next.val;
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;

    }



    public static ListNode  generatorList(){
        ListNode head = new ListNode(1);
        head.next=  new ListNode(1);
        head.next.next=  new ListNode(1);
        head.next.next.next=  new ListNode(4);
        head.next.next.next.next=  new ListNode(4);
        head.next.next.next.next.next=  new ListNode(6);
        head.next.next.next.next.next.next=  new ListNode(6);
        head.next.next.next.next.next.next.next=  new ListNode(8);

        return head;
    }
    @Test
    public void aa(){
        ListNode listNode = generatorList();
        ListNode listNode1 = deleteDuplicates(listNode);

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
}
