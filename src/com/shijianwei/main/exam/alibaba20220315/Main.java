package com.shijianwei.main.exam.alibaba20220315;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/3/14 19:03
 *
 * 题目：
 *      一个字符串，用来表示16进制数。一定是0x开头，从第三个字符开始，每个
 *      字符一定是'0'~'9'或者'a'到'f'。
 *      字符串的长度不超过200000。
 * 思路：
 *      因为都转换成二进制的话，对应16进制占4位
 *      这个时候可以先求出0-15的1的个数，将其保存
 *      然后再对字符串进行遍历
 *      记录 if s.charAt(i) != '0'-'9' ans += cnt[s.charAt(i)-'a'+10]
 *          else ans += cut[s.charAt(i)-'0']
 *      注：i从2开始，因为前面有0x的头
 *
 */
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int [] cnt = new int [16];
        for (int i = 1; i < 16; i++) {
            int tmp = i ;
            while (tmp > 0) {
                if ((tmp&1) ==1 ) cnt[i]++;
                tmp >>=1 ;
            }
        }

        String str = s.next();
        int ans = 0 ;
        for (int i = 2; i< str.length(); i++) {
            if (str.charAt(i)>='0' && str.charAt(i)<='9')
                ans += cnt[str.charAt(i)-'0'];
            else ans+=cnt[str.charAt(i)-'a'+10];
        }

        System.out.println(ans);

    }
}
