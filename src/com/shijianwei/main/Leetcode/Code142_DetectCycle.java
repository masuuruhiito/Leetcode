package com.shijianwei.main.Leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author SHI
 * @date 2022/3/27 21:00
 */
public class Code142_DetectCycle {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }
    public ListNode detectCycle(ListNode head) {
        ListNode cur = head ;
        Set<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return cur ;
            }
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }


    /**
     * 最好还是采用双指针的办法，空间复杂度为o1
     *
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null ;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;

//        从循环中出来，代表此时已经完成了第一次相遇
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

//        此时只需要让fast指针（另外写一个指针也可以）指向head与slow指针一起走a步，他们就相遇了
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
