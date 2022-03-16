package com.shijianwei.main.Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author SHI
 * @date 2022/2/17 10:56
 */
public class Code20 {
    public static boolean isValid(String s) {
        if(s==null) return true ;
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        int index = 0 ;
        while(index <s.length()){
            char tmp = s.charAt(index);
            if (map.containsKey(tmp)) {
                stack.push(tmp);
            }else{
                if(stack.isEmpty() || !map.get(stack.pop()).equals(tmp)){
                    return false ;
                }
            }
            index ++;
        }
        return stack.size()==0 ;
    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static class Code1920 {
        class Solution {
            public int[] buildArray(int[] nums) {
                int []ans = new int [nums.length];
                for (int i = 0; i < nums.length ; i++) {
                    ans[i]=nums[nums[i]];
                }
                return ans;
            }
        }
    }

    /**
     * @author SHI
     * @date 2022/1/17 20:12
     * <p>
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static class Code21 {

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


    //    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    //        ListNode prehead = new ListNode(-1);
    //
    //        ListNode prev = prehead;
    //        while (l1 != null && l2 != null) {
    //            if (l1.val <= l2.val) {
    //                prev.next = l1;
    //                l1 = l1.next;
    //            } else {
    //                prev.next = l2;
    //                l2 = l2.next;
    //            }
    //            prev = prev.next;
    //        }
    //
    //        prev.next = l1 == null ? l2 : l1;
    //
    //        return prehead.next;
    //    }


        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode prehead = new ListNode(-1);
            ListNode prev = prehead;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    prev.next = list1;
                    list1 = list1.next;
                } else {
                    prev.next = list2;
                    list2 = list2.next;
                }
                prev = prev.next;
            }
            prev.next = list1 == null ? list2 : list1;
            return prehead.next;
        }


        public static void main(String[] args) {
            ListNode l1 = new ListNode(1);
            l1.next = new ListNode(3);
            l1.next.next = new ListNode(5);

            ListNode l2 = new ListNode(2);
            l2.next = new ListNode(4);
            l2.next.next = new ListNode(6);

            ListNode l3 = mergeTwoLists(l1, l2);

            while (l3 != null) {
                System.out.println(l3.val);
                l3 = l3.next;
            }
        }

    }

    /**
     * @author SHI
     * @date 2022/1/16 18:41
     *
     * 704. 二分查找
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public static class Code704 {
        public static void main(String[] args) {
            int []a = {1,2,3,4,5,6,7};
            System.out.println(Solution.search(a,6));
        }
        static class Solution {

            public static int search(int[] nums, int target) {
                if(nums== null){
                    return -1 ;
                }
                int i = 0 ,j = nums.length-1;
                while (i<=j){
                    int mid =(i+j)/2;
                    if(nums[mid]>target){
                        j = mid -1;
                    }else if(nums[mid]<target){
                        i = mid +1;
                    }else {
                        return mid ;
                    }            }
                return -1 ;
            }
        }
    }
}
