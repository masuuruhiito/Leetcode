package com.shijianwei.main.exam.meituan.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author SHI
 * @date 2022/8/27 16:18
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] dealWith = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            map.put(i, i);
        }
        Node[] nodes = new Node[n];
        int index = -1;
        for (int i : dealWith) {
            map.put(i, index--);
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            nodes[i++] = new Node(entry.getKey(), entry.getValue());
        }
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });

        for (Node node : nodes) {
            System.out.println(node.key);
        }
    }


    static class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
