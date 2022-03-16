package com.shijianwei.main.Leetcode;

import java.util.*;

/**
 * @author SHI
 * @date 2022/3/6 12:32
 */
public class Code148_SortListNode {
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

    //    可以使用冒泡排序，只比较该节点和next节点
    public static void swap(ListNode pre , ListNode cur, ListNode next) {
        cur.next = next.next;
        next.next = cur;
        pre.next = next;
    }

//    冒泡排序时间复杂度太高了，超时，需要on*logn的算法
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1, head);
        ListNode cur = head, next = head.next ,pre = newHead;
        int len = 0 ;
        while (cur != null) {
            len ++;
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (cur.val > next.val) {
                    swap(pre, cur, next);
                    pre = pre.next;
                    next = cur.next;
                }else {
                    pre = pre.next;
                    cur = cur.next;
                    next = cur.next;
                }
            }
            cur = newHead.next;
            next = cur.next;
            pre = newHead;
        }
        return newHead.next;
    }


//    将数据拿出来重新创建n个节点
    public static ListNode sortList1(ListNode head) {
        List<Integer> num = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            num.add(cur.val);
            cur = cur.next;
        }
        Integer[] integers = num.toArray(new Integer[]{});
        Arrays.sort(integers);
        ListNode curr = new ListNode(integers[0]);
        ListNode res = curr ;
        for (int i = 1; i < integers.length; i++) {
            curr.next = new ListNode(integers[i]);
            curr = curr.next;
        }
        return res;
    }



//    将节点放到小根堆中，依次弹出最小的ListNode
//    定义结果链表，将每个node加在res后，返回res
    public static ListNode sortList2(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val- o2.val;
            }
        });
        while(head!=null){
            queue.add(head);
            head = head.next;
        }
        if(queue.isEmpty()) return null;
        ListNode res = new ListNode(-1);
        ListNode resList = res ;
        while (!queue.isEmpty()) {
            res.next = queue.poll();
            res = res.next ;
        }
        res.next = null ;
        return resList.next;
    }



    //    看题解使用归并排序,
//     很烦，下次再补充
//    最终形态


    /*
    归并思想：
        将整个链表分成两两一组的分链表（slow.next = null;）
        然后定义merge（left，right）
        里面定义了头节点res，然后比较left，right，val大的接在res后面，返回该链表即可
     */
    public static ListNode sortList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList3(head);
        ListNode right = sortList3(tmp);
        return merge(left,right);
    }

    public static ListNode merge(ListNode left, ListNode right ) {
        if (left == right) {
            return left;
        }
        ListNode tmp = new ListNode(0);
        ListNode res = tmp ;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                tmp.next = left;
                left = left.next;
            }else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        tmp.next = left != null ? left : right;
        return res.next;
    }


    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode fast = head.next, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode tmp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(tmp);
            ListNode h = new ListNode(0);
            ListNode res = h;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    h.next = left;
                    left = left.next;
                } else {
                    h.next = right;
                    right = right.next;
                }
                h = h.next;
            }
            h.next = left != null ? left : right;
            return res.next;
        }
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode res = sortList3(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
