package com.shijianwei.main.Nowcoder;

/**
 * @author SHI
 * @date 2022/3/11 21:07描述
 * 合并 k 个升序的链表并将结果作为一个升序的链表返回其头节点。
 *
 * 数据范围：节点总数 0 \le n \le 50000≤n≤5000，每个节点的val满足 |val| <= 1000∣val∣<=1000
 * 要求：时间复杂度 O(nlogn)O(nlogn)
 * 示例1
 * 输入：
 * [{1,2,3},{4,5,6,7}]
 * 复制
 * 返回值：
 * {1,2,3,4,5,6,7}
 * 复制
 * 示例2
 * 输入：
 * [{1,2},{1,4,5},{6}]
 * 复制
 * 返回值：
 * {1,1,2,4,5,6}
 */
public class CodeBM5_SortListNode {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


}
