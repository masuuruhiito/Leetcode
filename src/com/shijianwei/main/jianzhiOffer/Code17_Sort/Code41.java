package com.shijianwei.main.jianzhiOffer.Code17_Sort;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * @author SHI
 * @date 2022/2/9 22:06
 * 剑指 Offer 41. 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 *
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 *
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 */
public class Code41 {

    static class MedianFinder1 {
//        实现该方法，需要大根堆和一个小根堆，在存储数据的时候，
//        先将数据存在大根堆里面然后判断大根堆的数据和小根堆的数据
//        如果大根堆的数据-小根堆的size>1 那么将大根堆的顶部送到小根堆，
        /** initialize your data structure here. */

        PriorityQueue<Integer> maxQueue ;
        PriorityQueue<Integer> minQueue ;
        public MedianFinder1() {
            maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1 ;
                }
            });
            minQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(maxQueue.size()!=minQueue.size()){
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            }else{
                minQueue.add(num);
                maxQueue.add(minQueue.poll());
            }
        }

        public double findMedian() {
            return (maxQueue.size()+minQueue.size())%2==0?(maxQueue.peek()+minQueue.peek())/2.0:maxQueue.peek();
        }

    }


    static class MedianFinder {
        /** initialize your data structure here. */

        PriorityQueue<Integer> maxQueue ;
        PriorityQueue<Integer> minQueue ;
        public MedianFinder() {
            maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1 ;
                }
            });
            minQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxQueue.add(num);
            if(!maxQueue.isEmpty()&&maxQueue.size()-minQueue.size()>1){
                minQueue.add(maxQueue.poll());
            }else if(!maxQueue.isEmpty()&&!minQueue.isEmpty()&&maxQueue.peek()>minQueue.peek()){
                Integer min= minQueue.poll();
                Integer max= maxQueue.poll();
                maxQueue.add(min);
                minQueue.add(max);
            }
        }

        public double findMedian() {
            if (!maxQueue.isEmpty() && !minQueue.isEmpty() && (maxQueue.size() + minQueue.size()) % 2 == 0) {
                return Double.parseDouble(String.format("%.1f",1.0*(maxQueue.peek() + minQueue.peek())/2));
            } else if (!maxQueue.isEmpty() && (maxQueue.size() + minQueue.size()) % 2 == 1) {
                return Double.parseDouble(String.format("%.1f",1.0*maxQueue.peek()));
            }
            return Double.parseDouble(String.format("%.1f",Double.MIN_VALUE));
        }

    }


    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        System.out.println(m.findMedian());
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
    }
}
