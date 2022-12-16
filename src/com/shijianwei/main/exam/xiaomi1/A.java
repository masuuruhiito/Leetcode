package com.shijianwei.main.exam.xiaomi1;

/**
 * @author SHI
 * @date 2022/9/14 18:53
 */
public class A {
    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        left--;
        right--;
        ListNode<Integer> res = new ListNode<>();
        ListNode<Integer> cur = head;
        res.data = -1;
        res.next = head;
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
        }
        ListNode<Integer> tmp = cur.next;
        for (int i = 0; i < right - left; i++) {
            ListNode<Integer> next = tmp.next;
            tmp.next = next.next;
            next.next = cur.next;
            cur.next = next;
        }
        return res.next;
    }

    static class ListNode<T> {
        public T data;
        public ListNode next;
    }
}
