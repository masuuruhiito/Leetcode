package com.shijianwei.main.exam.qunaer;

import java.util.*;

/**
 * @author SHI
 * @date 2022/9/7 20:51
 */
public class C {
    public String showDown (String inHand) {
        // write code here
        String[] s = inHand.split(" ");
        PriorityQueue<BigNode> queue = new PriorityQueue<>(new Comparator<BigNode>() {
            @Override
            public int compare(BigNode o1, BigNode o2) {
                return o2.num - o1.num;
            }
        });
        HashMap<Character, Integer> colorMap = new HashMap<>();
        int maxColorNum = 0;
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        for (String value : s) {
            char color = value.charAt(0);
            if (colorMap.containsKey(color)) {
                colorMap.put(color, colorMap.get(color) + 1);
                maxColorNum = Math.max(maxColorNum, colorMap.get(color));
            }else {
                colorMap.put(color, 1);
            }
            Integer num = getNum(value.substring(1));
            if (map.containsKey(num)) {
                Node node = map.get(num);
                queue.remove(new BigNode(num, node));
                node.nums++;
                node.colors.add(color);
                map.put(num, node);
                queue.add(new BigNode(num, node));
            } else {
                ArrayList<Character> arr = new ArrayList<>();
                arr.add(color);
                map.put(num, new Node(1, arr));
                queue.add(new BigNode(num, map.get(num)));
            }
        }

        if (map.size() >= 5) {
            int num = queue.peek().num;
            if (num == 14 || isTongHuaShun(num, queue,true)) {
                return "HuangJiaTongHuaShun";
            } else if (isTongHuaShun(num, queue, true)) {
                return "TongHuaShun";
            }
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (entry.getValue().nums ==4) {
                return "SiTiao";
            }
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            if (entry.getValue().nums == 3) {
                for (Map.Entry<Integer, Node> nodeEntry : map.entrySet()) {
                    if (nodeEntry.getValue().nums == 2) {
                        return "HuLu";
                    }
                }
            }
        }

        if (maxColorNum >= 5) {
            return "TongHua";
        }

        return "LiangDui";

    }

    public static boolean isTongHuaShun(int num, PriorityQueue<BigNode> queue, boolean isTongHua) {
        PriorityQueue<BigNode> copy = queue;
        List<Character> colors = copy.peek().node.colors;
        for (int i = 1; i < copy.size(); i++) {
            BigNode poll = copy.poll();
            if (poll.num != num - 1 || (isTongHua && !containsList(colors, poll.node.colors))) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsList(List<Character> a, List<Character> b) {
        for (Character character : b) {
            if (!a.contains(character)) {
                return false;
            }
        }
        return true;
    }
    public static int getNum(String strNum) {
        switch (strNum) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(strNum);
        }
    }

    static class BigNode{
        int num;
        Node node;

        public BigNode(int num, Node node) {
            this.num = num;
            this.node = node;
        }
    }

    static class Node{
        int nums = 0;
        List<Character> colors = new ArrayList<>();

        public Node() {
        }

        public Node(int nums, List<Character> colors) {
            this.nums = nums;
            this.colors = colors;
        }
    }
}
