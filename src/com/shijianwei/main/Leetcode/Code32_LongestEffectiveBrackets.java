package com.shijianwei.main.Leetcode;

import java.util.Stack;

/**
 * @author SHI
 * @date 2022/2/28 10:39
 * (((()))()))
 *
 * 最长连续的括号
 * 那么就进行动态规划呗
 *
 */
public class Code32_LongestEffectiveBrackets {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int count = 0 ;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    count = Math.max(count, i - stack.peek());
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }
}
