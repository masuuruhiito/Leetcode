package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/2/27 14:58
 */
public class Code160_CrossLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA ==null || headB == null ) return null ;
        ListNode nodeA = headA ;
        ListNode nodeB = headB ;

        while (nodeA !=nodeB ) {
            nodeA = nodeA == null ?headB :nodeA.next;
            nodeB = nodeB == null ?headA :nodeB.next;
        }
        return nodeA;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
