package com.shijianwei.main.Leetcode;

import java.util.HashSet;
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
}
