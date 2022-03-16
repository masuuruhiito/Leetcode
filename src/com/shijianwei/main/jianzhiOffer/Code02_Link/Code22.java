package com.shijianwei.main.jianzhiOffer.Code02_Link;

import java.util.List;

/**
 * @author SHI
 * @date 2022/1/29 19:07
 * 快慢指针
 */
public class Code22 {

    public static void main(String[] args) {
        ListNode head = conList();
        System.out.println(getKthFromEnd(head, 3).val);
    }
//    快速生成链表数据
    public static ListNode conList(){
        ListNode head =new ListNode(1);
        ListNode cur =head ;
        ListNode tmp = null ;

        for (int i = 2; i < 8; i++) {
            tmp = new ListNode(i);
            cur.next = tmp;
            cur = cur.next;
        }
        return head;
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null){
            return null ;
        }
        ListNode fast = head ;
        ListNode slow = head ;

//        while (fast!=null && k>0){
//            k--;
//            fast = fast.next;
//        }
//        while (fast!=null ){
//            fast = fast.next;
//            slow = slow.next;
//        }

//        这个方法会增加一个对总长的判断，比上面的好
        int len = 0 ;
        while (fast!=null){
            if(len>=k) slow = slow.next;
            fast = fast.next;
            len++;
        }
        if(len<k) return null ;
        return slow ;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
