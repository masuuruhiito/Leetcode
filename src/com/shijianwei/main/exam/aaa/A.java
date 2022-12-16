package com.shijianwei.main.exam.aaa;

/**
 * @author SHI
 * @date 2022/9/20 13:55
 */
public class A {
    //    public static int[] getNoHavingNum(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return null;
//        }
//        int
//        int i = 0, j = nums.length - 1;
//        while (i < j) {
//            int mid = i + ((j - i) >> 1);
//            if (nums[mid] == mid) {
//                nums
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//
//        }
//    }
    public static void main(String[] args) {
        int array[] = {0, 1, 6, 7, 10, 3, 9, 4, 2};
        MyTest test = new MyTest(array, array.length + 1);
        test.search();
    }


    static class MyTest {

        private int[] datas;// 整型数组来存放数据元素
        private int n;//元素的个数

        //在构造函数中初始化数组
        public MyTest(int[] datas, int n) {
            this.n = n;
            this.datas = new int[n + 1];//将第一个元素置零，为了处理起来方便
            for (int i = 1; i < n - 1; i++)
                this.datas[i] = datas[i];
            this.datas[n - 1] = -1;
            this.datas[n] = -1;//没有存放元素用-1表示
        }

        //查找的过程
        public void search() {
            int a = n;
            int b = n - 1;
            int c = -1;
            int index = 1;
            while (index <= n) {
                if (datas[index] == 0 || datas[index] == -1)
                    index++;
                else {
                    if (a == -1)
                        a = index;
                    else if (b == -1)
                        b = index;
                    else
                        c = index;
                    int value = datas[index];
                    datas[index] = -1;
                    boolean flag = false;//作为跳出循环的条件
                    while (!flag) {
                        if (datas[value] != -1) {
                            int data = datas[value];
                            datas[value] = 0;
                            value = data;
                        } else {
                            flag = true;
                            datas[value] = 0;
                            if (a == value)
                                a = -1;
                            else if (b == value)
                                b = -1;
                            else
                                c = -1;
                        }
                    }
                    index++;
                }
            }
            System.out.println("result:");
            if (a != -1)
                System.out.println(a);
            if (b != -1)
                System.out.println(b);
            if (c != -1)
                System.out.println(c);
        }
    }
}
