package com.shijianwei.main.Nowcoder.ProgrammersCodeTestGuide;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/3/15 12:49
 */
public class CD4_ThreeNumSum {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            func(arr, k);

        }


        public static void func(int[] arr, int k) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                int target = k - arr[i];
                if (i > 0 && arr[i] == arr[i - 1]) continue;
                int left = i + 1, right = arr.length - 1;
                while (left < right) {
                    if (arr[left] + arr[right] > target) {
                        right--;
                    } else if (arr[left] + arr[right] < target){
                        left++;
                    }else {
                        if (arr[left] != arr[right] && arr[left] != arr[right] ) {
                            res.append(arr[i]).append(" ").append(arr[left]).append(" ").append(arr[right]).append("\n");
                        }
                        left++;
                        right--;
                    }
                }


            }
            System.out.println(res.toString());
        }

    }
}
