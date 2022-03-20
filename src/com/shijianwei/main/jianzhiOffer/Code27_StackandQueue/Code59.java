package com.shijianwei.main.jianzhiOffer.Code27_StackandQueue;

import javax.management.QueryEval;
import java.awt.font.NumericShaper;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author SHI
 * @date 2022/2/11 19:02
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *
 *  实现思路：
 *      No1：将每个数据都加入到priortyqueue中，然后每次弹出一个，直到右指针到lenth-1
 *      No2：自己实现双向队列，
 */
public class Code59 {

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        // 未形成窗口
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        // 形成窗口后
        for(int i = k; i < nums.length; i++) {
            if(deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }

    static class MaxComparable implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MaxComparable());
        if(nums.length<k) {
            k = nums.length;
        }
        int []res = new int[nums.length-k+1];
        int i = 0 , j = k-1 ,u = 0 ;
        int head ;
        for (int l = i; l <j ; l++) {
            queue.add(nums[l]);
        }
        while (j<=nums.length-1){
//        将每个数据都插入queue中，保存第一个数
            head= nums[j-k+1];
            queue.add(nums[j++]);
            if(!queue.isEmpty()) {
                res[u++] = queue.peek();
            }
            queue.remove(head);
        }
        return res;
    }






    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        int []res = maxSlidingWindow1(nums,3);
        for (int re : res) {
            System.out.print(re+" ");
        }
    }
}
