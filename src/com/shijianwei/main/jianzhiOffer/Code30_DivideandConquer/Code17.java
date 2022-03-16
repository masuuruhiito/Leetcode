package com.shijianwei.main.jianzhiOffer.Code30_DivideandConquer;

import java.io.*;
import java.util.*;

/**
 * @author SHI
 * @date 2022/2/15 17:42剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 */
public class Code17 {
    public static InputReader in = new InputReader(System.in);
    public static Scanner sc = new Scanner(new InputStreamReader(System.in));
    public static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) {
//        int n = in.nextInt();
        String[] s = in.next().split(" ");

        out.println(s[0]);
//        out.println(s[1]);
//        out.println(s[2]);
        out.flush();
        out.close();

    }
}
class InputReader{
    private final static int BUF_SZ = 65536;
    private BufferedReader in;
    private StringTokenizer tokenizer;
    public InputReader(InputStream in) {
        super();
        this.in = new BufferedReader(new InputStreamReader(in),BUF_SZ);
        tokenizer = new StringTokenizer("");
    }
    public String next() {
        while (!tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(in.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }
}
