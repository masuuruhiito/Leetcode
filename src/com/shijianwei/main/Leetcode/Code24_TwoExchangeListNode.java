package com.shijianwei.main.Leetcode;

import java.util.HashMap;

/**
 * @author SHI
 * @date 2022/3/15 20:0924. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 */
public class Code24_TwoExchangeListNode {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int index = 0 ;
        ListNode node = head;
        ListNode res = head.next;
        ListNode pre = null;
        while (node != null) {
//            if ((index++)%2==0)
//            因为每次计算的时候都是将node和node.next交换
//            但是不是两个的话，就需要重写
            if(node.next!=null) swap(pre, node);
            pre = node;
            node = node.next;
        }
        return res ;
    }

    /*交换cur and cur.next*/
    public static void swap(ListNode pre, ListNode cur) {
        ListNode next = cur.next;
        cur.next = next.next;
        next.next = cur ;
        if (pre!= null) pre.next = next;
    }



    //    延申：不定数据为整体交换
    public static ListNode swapKGroup(ListNode head,int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        int index = 0 ;
        ListNode res = new ListNode(0, head);
        ListNode tail = head;
        ListNode start = res ;
        while (tail != null) {
            int cnt = 0 ;
            while (cnt < k && tail != null) {
                tail = tail.next ;
                cnt++ ;
            }
            if (cnt < k) {
                break ;
            }
            ListNode tmp = start.next;//保存下一次的头节点
            swapK(start, tail);
            start = tmp ;
        }
        return res.next ;

    }

    /*交换cur and cur.next*/
    public static void swapK(ListNode pre, ListNode tail) {
        ListNode start = pre.next;
        ListNode next = pre.next.next;
        while (next != null && next != tail) {
            ListNode tmp = next.next;
//            每次只将横向改变
            next.next = start;
//            横向后移
            start = next;
            next = tmp ;
        }
//        退出循环代表next = tail 或 == null
//        此时需要将pre指向next，pre下一个节点指向最后一个节点
        pre.next.next = tail;
        pre.next = start;

    }


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
        ListNode node = generatorList();
        ListNode res = swapPairs(node);


//        swap(node.next,node.next.next);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    /**
     * @author SHI
     * @date 2022/1/16 20:18
     *
     * 13. 罗马数字转整数
     * 罗马数字包含以下七种字符: I， C， X， L，C，D 和 M。
     *
     * 字符          数值
     * I             1
     * C             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + C + II 。
     *
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     *
     * I 可以放在 C (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     */
    public static class Code13_IexchangeInt {
        public static void main(String[] args) {
            System.out.println(romanToInt("MCMXCIV"));
        }

        public static int romanToInt(String s) {
            HashMap<Character,Integer> hashMap = new HashMap<>();
            hashMap.put('I',1);
            hashMap.put('V',5);
            hashMap.put('X',10);
            hashMap.put('L',50);
            hashMap.put('C',100);
            hashMap.put('D',500);
            hashMap.put('M',1000);
            char [] str = s.toCharArray();
            int res = 0 ;
            for (int i = 0; i < str.length; i++) {
                int value = hashMap.get(str[i]);
                if(i<str.length-1 && value<hashMap.get(str[i+1])){
                    res -= value ;
                }else {
                    res+=value ;
                }
            }
            return res ;
        }
    }
}
