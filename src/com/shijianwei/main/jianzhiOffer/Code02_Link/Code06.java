package com.shijianwei.main.jianzhiOffer.Code02_Link;


/**
 * @author SHI
 * @date 2022/1/17 10:43
 *
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Code06 {

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

//    如果要反转链表的话可以重新声明一个列表
    public static int[] reversePrint(ListNode head) {
        int count = 0 ;
        ListNode node = head ;
        while (node!=null ){
            count++;
            node = node.next ;
        }
        ListNode listNode = head ;
        int [] res = new int [count];
        for (int i = count-1; i >=0 ; i--) {
            res[i]=listNode.val;
            listNode= listNode.next;
        }
        return res ;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        head.next = new ListNode(2);

        head.next.next = new ListNode(3);

        int []res = reversePrint(head);

        for (int re : res) {
            System.out.println(re);
        }
    }
}
