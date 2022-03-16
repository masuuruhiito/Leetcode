package com.shijianwei.main.jianzhiOffer.Code12_DoublePointer;

import com.sun.org.apache.xpath.internal.operations.Equals;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author SHI
 * @date 2022/2/7 18:52
 * 剑指 Offer 52. 两个链表的第一个公共节点    **
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 * 示例 1：
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */
public class Code52 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1= headA,l2  = headB;
        if(l1== null || l2 == null )  return null ;
        Set<ListNode> set = new HashSet<>();
        int size = 0 ;
        while (l1!=null && l2!=null ){
            set.add(l1);
            size++;
            if(size!=set.size()){//证明在这次添加中出现重复
                return l1;
            }
            l1= l1.next;
            set.add(l2);
            size++ ;
            if(size!=set.size()){//证明在这次添加中出现
                return l2;
            }
            l2= l2.next;
        }
//        其中一个为空另外一个不为空的情况
        while(l1!=null){
            set.add(l1);
            size++;
            if(size!=set.size()){//证明在这次添加中出现重复
                return l1;
            }
            l1= l1.next;
        }
        while(l2!=null){
            set.add(l2);
            size++ ;
            if(size!=set.size()){//证明在这次添加中出现
                return l2;
            }
            l2= l2.next;
        }
        return null;
    }

//    想将两个链表从尾部逆序过来找不同的点，但单链表不能保存上一个节点的信息，还不能改变表结构，
//    所以想让两个链表一样长，然后进行比较，那么分别将两个链表拼接到另外一个链表的尾部，长度都为m+n
//    在比较的时候,从原本链表的末尾进行比较(相当于将headA变为headB,headB变为headA)
//    此时两个指针一起走,如果两个指针所对应的地址相等的话,证明找到了
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if(headA== null || headB == null )  return null ;
        ListNode l1= headA,l2  = headB;
        while (l1 != l2) {//null == null = true;
            l1 = l1== null ?headB :l1.next;
            l2 = l2== null ?headA :l2.next;
        }
        return l1 ;
    }


    public static void main(String[] args) {
        ListNode headA = new ListNode(2);
        headA.next = new ListNode(6 );
        headA.next.next = new ListNode(4);

        ListNode headB = new ListNode(1);
        headB.next = new ListNode(5);


        System.out.println(getIntersectionNode1(headA, headB).val);
    }
}
