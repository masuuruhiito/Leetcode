package com.shijianwei.main.jianzhiOffer.Code01_Stack;

import java.util.Stack;

/**
 * @author SHI
 * @date 2022/1/16 15:55
 *
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 队列的声明如下，
 *      请实现它的两个函数 appendTail 和 deleteHead ，
 *      分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 *      (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *
 * 解：如果使用linklist的话会更快，因为stack会
 */
public class Code09 {

    class CQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;
        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

//        尾部插入
        public void appendTail(int value) {
            stack1.add(value);
        }

//        头部删除
        public int deleteHead() {
            if(stack2.isEmpty()){
                if (stack1.isEmpty()) {
                    return -1;
                }
                while (!stack1.isEmpty()) {
                    stack2.add(stack1.pop());
                }
                return stack2.pop();
            }else{
                return stack2.pop();
            }

        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
