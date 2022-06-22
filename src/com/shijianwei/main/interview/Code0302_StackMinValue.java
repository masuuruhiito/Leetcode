package com.shijianwei.main.interview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Stack;

/**
 * @author SHI
 * @date 2022/4/26 21:24
 */
public class Code0302_StackMinValue {

    private class MyData {
        public MyData(int value, int curMin) {
            this.value = value;
            this.curMin = curMin;
        }

        int value;
        int curMin;
    }

    class MinStack {
        Stack<MyData> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new MyData(x, x));
            }else {
                stack.push(new MyData(x, Math.min(stack.peek().curMin, x)));
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int top() {
            if (!stack.isEmpty()) {
                return stack.peek().value;
            }else {
                return -1;
            }
        }

        public int getMin() {
            if (!stack.isEmpty()) {
                return stack.peek().curMin;
            }else {
                return -1;
            }
        }
    }
}
