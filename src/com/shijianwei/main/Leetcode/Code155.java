package com.shijianwei.main.Leetcode;

import java.util.Stack;

/**
 * @author SHI
 * @date 2022/1/29 19:56
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class Code155 {
    class MinStack{
        Stack<Integer> elemsStack ;
        Stack<Integer> minStack ;

        public MinStack() {
            elemsStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            elemsStack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            }else{
                //如果不等于的话，在数据中含有相同元素时，在pop处会将该数据删掉，但实际上该元素还在elemStack中
                if(val<=minStack.peek()){
                    minStack.push(val);
                }
            }
        }

        public void pop() {
            int topElem = elemsStack.pop();
            if(!minStack.isEmpty()&&topElem  == minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return elemsStack.peek();
        }

        public int getMin() {
            if(!minStack.isEmpty()) return minStack.peek() ;
            return Integer.MAX_VALUE;
        }
    }
}
