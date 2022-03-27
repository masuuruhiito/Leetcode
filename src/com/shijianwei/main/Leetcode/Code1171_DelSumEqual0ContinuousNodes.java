package com.shijianwei.main.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SHI
 * @date 2022/3/27 20:07
 *
 * 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 *
 * 删除完毕后，请你返回最终结果链表的头节点。
 *
 *
 *
 * 你可以返回任何满足题目要求的答案。
 *
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 */
public class Code1171_DelSumEqual0ContinuousNodes {
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
     * 这题是真的牛，把数据拿出来删完再创建就不用写了，真没必要
     * <p>
     * 看了题解的前缀和版本，真的牛
     *  思路：
     *      sum变量，求当前之前所有节点的和，将sum和ListNode存放在map中
     *      （map中的值相同时覆盖，就是利用了这个性质，只要两次的值相同，那么就可以把中间节点删除）
     *      说起来，很简单，但是想到这个的人是真的厉害
     *
     * @param head
     * @return
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            sum += cur.val;
            map.put(sum, cur);
        }
//        此时可以在map中找到最后一次等于该节点的值的后继，指过去就可以了
        sum = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            sum += cur.val;
            cur.next = map.get(sum).next;
        }
        return dummy.next;
    }
}
