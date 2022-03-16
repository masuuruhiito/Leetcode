package com.shijianwei.main.Leetcode;

/**
 * @author SHI
 * @date 2022/3/6 13:51
 */
public class Code25_reveserList {
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


    /**
     *
     * @param head  头节点
     * @param k     每k个数据反转一次
     * @return      返回头节点
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k==1 || head == null || head.next == null) {
            return head;
        }
//        想要实现反转，需要定义返回的结果集
        ListNode res = new ListNode(0, head);
        int n = 0 ;
        while (n++ < k) {
            res = res.next;
        }
//        ListNode start = res;//替代res进行添加操作
//        因为reverse函数需要pre和tail，此时定义出pre和tail
        ListNode pre = new ListNode(0,head);
        ListNode cur = head ;
//        循环head，
        int cnt = 0 ;
        while (cur != null) {
//            因为在交换之后，此时需要将cur变为tail
            boolean flag = false;
            if (++cnt % k == 0) {
                ListNode tmp = pre.next;
                swapK(pre, cur.next);
                pre = tmp;
                flag = true;
            }
            cur = flag ? pre.next : cur.next;
        }
        return res;
    }

    /**
     *
     * @param pre   开始节点的pre节点
     * @param tail  末尾节点的next节点，最终指向tail节点
     * @return      返回值为链表新头节点
     */
    public static void swapK(ListNode pre, ListNode tail) {
        ListNode p1 = pre.next, p2 = p1.next;
        while (p2 != null && p2 != tail) {
            ListNode tmp = p2.next ;//record next节点
            p2.next = p1; //reverse p2,p1
            p1 = p2 ;
            p2 = tmp;//横向平移
        }
//        此时已经反转到了最后一个节点，需要将头尾两个位置进行赋值
        pre.next.next = tail;//头节点的next指向tail
        pre.next = p1 ;//p2 此时为tail 那么p1为当前最后节点，也就是新的头节点
        //将新的头节点与pre节点连接，形成完整链表

//        return pre.next ;//返回新的头节点
    }




    public static void main(String[] args) {
//        ListNode listNode = generatorList();
//        ListNode res = reverseKGroup(listNode, 3);
//        while (res != null) {
//            System.out.println(res.val);
//            res = res.next;
//        }

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

//        测试swapK()
//        swapK(head.next, head.next.next.next.next);
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }


//        测试reverseKGroup()
        ListNode res = reverseKGroup(head, 2);
        while (res != null) {
            System.out.print(res.val+" ");
            res = res.next;
        }

    }


}
