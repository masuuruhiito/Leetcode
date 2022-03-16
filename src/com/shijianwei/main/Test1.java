package com.shijianwei.main;

import java.io.*;

class Test1 {
    public static void main(String []args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String line = in.readLine(); // 输入一行字符
        out.println(line); // 输出并换行
        out.flush(); // 在控制台输出，不要忘记这句！

    }




}
