package com.shijianwei.main.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SHI
 * @date 2022/3/20 14:06
 */
public class Code239_MaxNumSlidWindow {
//    实现一个队列，然后将每次的最大值存入其中
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length + 1 - k];
        Deque<Integer> deque = new LinkedList<>();
        //先将前k个数据放入队列中
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
//        然后开始对后面数据进行添加以及删除
        for (int i = k; i < nums.length; i++) {
            //如果最前面的值为最大值，将其删除，然后在开始填加
            if (deque.peekFirst() == nums[i - k]) deque.removeFirst();

//            将比该数据小的数据都可以清除了，因为这些数据不会成为区域最大值
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }

        return res ;
    }
}
