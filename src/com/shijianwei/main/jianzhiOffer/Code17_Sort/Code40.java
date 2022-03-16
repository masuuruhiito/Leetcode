package com.shijianwei.main.jianzhiOffer.Code17_Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author SHI
 * @date 2022/2/9 15:41
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class Code40 {
//    投机取巧
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null ||k>arr.length) return null;
        Arrays.sort(arr);
        int []res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null ||k>arr.length) return null;
//        实现大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int count = 0 ;
        for (int i : arr) {
            if(count<k){
                queue.add(i);
                count ++;
            }
            else{
                if(!queue.isEmpty()&&queue.peek()>i){
                    queue.poll();
                    queue.add(i);
                }
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
