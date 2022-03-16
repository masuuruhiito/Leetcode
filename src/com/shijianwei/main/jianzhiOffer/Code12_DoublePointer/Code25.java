package com.shijianwei.main.jianzhiOffer.Code12_DoublePointer;

import com.shijianwei.main.jianzhiOffer.Code11_DoublePointer.Code18;
import sun.plugin.javascript.navig.LinkArray;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author SHI
 * @date 2022/2/7 15:34
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Code25 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dom = new ListNode(0);
        ListNode cur = dom ;
        while (l1!=null && l2!= null){
            if(l1.val<l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next= l2 ;
                l2= l2.next;
            }
            cur= cur.next;
        }
        cur.next = l1==null ?l2:l1;
        return dom.next ;
    }

//    使用头节点值最小的链表来充当根链表
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1==null || l2 == null) return l1==null ?l2 :l1;
        ListNode cur;//xiao de zhi
        ListNode other;
        if(l1.val<=l2.val){
            cur = l1;
            other = l2 ;
        }else{
            cur = l2;
            other = l1;
        }
        ListNode res =cur ;

        while (cur.next!=null&& other!=null ){
            if(cur.next.val>other.val){
                insert(cur,other);
                other = other.next;
            }
            cur= cur.next;
        }
        cur.next =cur.next == null ?other.next:cur.next;
        return res ;
    }

    public static void insert(ListNode l1,ListNode l2){
        ListNode tmp = l1.next;
        l1.next = l2 ;
        l2.next= tmp ;
    }
}
