package com.shijianwei.main.Leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Arrays.*;

/**
 * @author SHI
 * @date 2022/3/20 18:08
 */
public class Code23_MergeKAscList {
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

        @Override
        public String toString() {
            StringBuilder res = new StringBuilder();
            ListNode head = this;
            while (head != null) {
                res.append(head.val).append(" ");
                head = head.next;
            }
            return res.toString();
        }
    }

    /**
     * 想实现合并k个升序链表，可以将每个链表都加在优先队列中
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });

        PriorityQueue<ListNode> queue = new PriorityQueue<>(((o1, o2) -> o1.val-o2.val));
        ListNode cur = new ListNode(-1);
        ListNode res = cur ;
//        queue.addAll(Arrays.asList(lists));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            if (poll.next != null) {
                queue.add(poll.next);
            }
            cur = cur.next;
        }

        return res.next;
    }


    /**
     * 这个方法为将这些链表两两合并，然后将所有的链表合并
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
//        return doubleMerge(merge(lists, l, mid),merge(lists,mid,r));
        ListNode left = merge(lists, l, mid);
        ListNode right = merge(lists, mid+1, r);
        return doubleMerge(left, right);
    }

    public static ListNode doubleMerge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        ListNode cur = new ListNode(-1);
        ListNode res = cur ;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2 ;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return res.next;
    }


    @Test
    public void  a(){
        ListNode listNode = generatorList();
        ListNode listNode1 = generatorList();
        System.out.println(doubleMerge(listNode1, listNode).toString());
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


    public static void main(String[] args) {
//        System.out.println(mergeKLists(new ListNode[]{}));
//        System.out.println();
////        System.out.println(mergeKLists(new ListNode[]{}));
//        System.out.println(new ListNode[]{}.length);
//        System.out.println(new ListNode[]{} == null);


        ListNode listNode = generatorList();
        ListNode listNode1 = generatorList();
        ListNode listNode2 = generatorList();

        System.out.println();
        ListNode node = mergeKLists1(new ListNode[]{listNode, listNode1, listNode2});

//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
        System.out.println(node.toString());



    }


    public static ListNode func(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });


        for (ListNode list : lists) {
            queue.add(list);
        }

        ListNode cur = new ListNode(-1);
        ListNode res = cur;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll ;
            cur = cur.next;
            queue.add(poll.next);
        }


        return res.next;
    }




    public static ListNode merge1(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }
        int mid = i + ((j - i) >> 1);
        return doubleMerge1(merge1(lists, i, mid), merge1(lists, mid + 1, j));
    }

    public static ListNode doubleMerge1(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1==null ? list2 : list1 ;
        }
        ListNode cur = new ListNode(-1);
        ListNode res = cur;
        while (list1 != null && list2 != null) {
            cur.next = list1.val > list2.val ? list1 : list2;
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return res.next;
    }

}
