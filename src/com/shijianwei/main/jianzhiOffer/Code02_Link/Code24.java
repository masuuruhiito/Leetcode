package com.shijianwei.main.jianzhiOffer.Code02_Link;

/**
 * @author SHI
 * @date 2022/1/17 11:49
 *
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 *
 * 实现链表反转
 *      实际上是先存储前驱节点，和当前节点
 *      遍历每个节点，将每个节点的后续节点保存为next
 *      curr.next = prev ;
 *
 */
public class Code24 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode  generatorList(){
        ListNode head = new ListNode(1);
        head.next=  new ListNode(2);
        head.next.next=  new ListNode(3);
        head.next.next.next=  new ListNode(4);
        head.next.next.next.next=  new ListNode(5);
        head.next.next.next.next.next=  new ListNode(6);
        head.next.next.next.next.next.next=  new ListNode(7);
        head.next.next.next.next.next.next.next=  new ListNode(8);

        return head;
    }

//    记录前驱节点的方式
    public static ListNode reverseList(ListNode head) {
//        当前节点
        ListNode curr = head ;
//        前一个节点
        ListNode prev = null ;

        while ( curr!=null ){
            ListNode next = curr.next ;
            curr.next = prev ;
//            实现++操作
            prev = curr ;
            curr = next ;
        }
        return prev ;
    }


    //    递归方式
    public static ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return res ;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);


//        while (head!=null){
//            System.out.println(head.val);
//            head= head.next;
//        }
        System.out.println("------------------------------------------------------");

        ListNode node = reverseList(head);

        while (node!=null){
            System.out.println(node.val);
            node= node.next;
        }





    }

}
