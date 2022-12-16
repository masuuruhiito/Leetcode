package com.shijianwei.main.exam.jinshanyun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/11/8 21:21
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), d = sc.nextInt(), n = sc.nextInt();
        StringBuilder str = new StringBuilder();
        str.append(1 / num);
        int a = 1 % num;
        if (a != 0) {
            str.append(".");
            ArrayList decimal = new ArrayList();
            Map map = new HashMap<>();
            int loop = -1;
            while (a != 0) {
                if (map.containsKey(a)) {
                    loop = (int) map.get(a);
                    break;
                }else {
                    decimal.add(a * 10 / num);
                    map.put(a, decimal.size() - 1);
                    a = a * 10 % num;
                }
            }
            if (loop == -1) {
                for (Object i : decimal) {
                    str.append(decimal.get((Integer) i));
                }
            }else {
                for (int i = 0; i < loop; i++) {
                    str.append(decimal.get(i));
                }
                str.append("(");
                for (int i = loop; i < decimal.size(); i++) {
                    str.append(decimal.get(i));
                }
                str.append(")");
            }
        }

        String s = str.toString().substring(str.indexOf("."));
        if (!s.contains("(")) {
            for (int i = d - 1; i < d - 1 + n; i++) {
                System.out.print(s.charAt(i));
            }
        }else {
            int end = s.indexOf(")");
            int start = s.indexOf("(");
            int len = end - start - 1;
            String nums = s.substring(start + 1, end);
            d--;
            d = d % len;
            while (n-- > 0) {
                System.out.print(nums.charAt(d++));
                if (d == len) {
                    d = 0;
                }
            }
        }
    }
}
