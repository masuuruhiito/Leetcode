package com.shijianwei.main;

import javax.sound.midi.Soundbank;
import java.io.*;

class Test1 {
    public static void main(String []args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
//        String line = in.readLine(); // 输入一行字符
//        out.println(line); // 输出并换行
//
////        因为字符流是读buffer中的数据，并且修改buffer中的数据
////        想要数据同步就需要flush()刷新一下，将缓存刷新到内存中
////        对于多写的数据更好的用字符流
//        out.flush(); // 在控制台输出，不要忘记这句！


        System.out.println(b());
//        a();

    }


    public static Integer a() {
        return null;
    }
    public static int b() {
        return a();
    }

//    public static int c() {
//        return null;
//    }

}
