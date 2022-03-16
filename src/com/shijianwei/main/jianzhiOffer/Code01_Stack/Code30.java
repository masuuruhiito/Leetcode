package com.shijianwei.main.jianzhiOffer.Code01_Stack;

/**
 * @author SHI
 * @date 2022/1/16 16:19
 *
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 问：在如果pop弹出了最小值，那么head.nowMin()的值如何保证是新的而不是旧的
 *      每一个数据都有对应自己的nowMin
 *      当弹出堆顶为最小值时，剩余元素的nowMin是在没有该最小值生成的nowMin
 *      所以不会处错
 */
public class Code30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(13);
        minStack.push(12);
        minStack.push(11);

        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        minStack.push(1);
        System.out.println(minStack.min());


    }
    static class MinStack {
        class Node{
            Integer value ;
            Integer nowMin ;

            public Node(Integer value, Integer nowMin, Node next) {
                this.value = value;
                this.nowMin = nowMin;
                this.next = next;
            }

            Node next ;
        }
        private Node head ;
        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x,x,null );
            }else{
//                这句保证了head一直为栈顶
                head = new Node(x,Math.min(x,head.nowMin),head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int min() {
            return head.nowMin;
        }
    }

}
