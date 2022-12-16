package com.shijianwei.main.exam.sss;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/8/30 19:57
 */
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        if (n <= 2) {
            System.out.println(0);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.value - o1.value;
            }
        });
        for (int i = 1; i < n; i++) {
            Node node = new Node(Math.abs(nums[i - 1] - nums[i]), i - 1, i);
            queue.add(node);
        }
        Node poll = queue.poll();
        if (poll.value == queue.peek().value) {
            System.out.println(poll.value);
        }else {
            int left = poll.leftIndex - 1;
            int right = poll.rightIndex + 1;
            int leftAns = 0, rightAns = 0;
            leftAns = left >= 0 ? (Math.abs(nums[left] - nums[poll.rightIndex]) + 1) / 2 : 0;
            rightAns = right < nums.length ? (Math.abs(nums[right] - nums[poll.leftIndex]) + 1) / 2 : 0;
            queue.add(new Node(Math.min(leftAns, rightAns)));
            System.out.println(queue.peek().value);
        }
    }
}

class Node {
    int value;

    public Node(int value, int leftIndex, int rightIndex) {
        this.value = value;
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    public Node(int value) {
        this.value = value;
    }

    int leftIndex;
    int rightIndex;
}
