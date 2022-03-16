package com.shijianwei.main.jianzhiOffer.Code11_DoublePointer;

import com.shijianwei.main.jianzhiOffer.Code02_Link.Code24;
import com.sun.org.apache.bcel.internal.generic.IMPDEP1;

/**
 * @author SHI
 * @date 2022/2/7 14:55
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class Code18 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }



//    删除操作只需要node.next = node.next.next ;
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val ) return head.next;
        ListNode node = head ;
        while (node.next!=null && node.next.val != val )    node = node.next;
        if(node.next!=null) node.next = node.next.next;
        return head;
    }

}
