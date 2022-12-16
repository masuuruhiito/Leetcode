package com.shijianwei.main.exam.sss;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/8/30 20:37
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] split = sc.nextLine().split("");
        HashMap<Integer, String> color = new HashMap<>();
        int i = 0;
        for (String s : split) {
            color.put(i++, s);
        }
        int[][] nums = new int[n - 1][2];
        for (i = 0; i < n - 1; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        HashMap<int[], Cur> map = new HashMap<>();
//        for (i = 0; i < n - 1; i++) {
//            Cur cur = map.containsKey(nums[i]) ? new Cur() : map.get(nums[i]);
//
//            cur.lList.add();
//
//            map.put(nums[i], cur);
//        }
    }

    static class Cur {
        List<Node> lList;
        List<Node> rList;

        public Cur() {
            this.lList = new ArrayList<>();
            this.rList = new ArrayList<>();
        }
    }

    static class Node {
        int value;
        String color;
    }
}
