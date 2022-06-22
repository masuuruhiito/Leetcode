package com.shijianwei.main.exam.qingeryiju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


/**
 * @author SHI
 * @date 2022/4/25 20:44
 *
 */
public class AssembleTheParser {

    //最大循环次数
    private static long Maximum_Cycle_Times = 1000000000;
    //当前寄存器个数-1（最后一个寄存器下标）
    private static int lastIndex = 0;
    //保存所有执行语句
    private static StringBuilder allStatement = new StringBuilder();
    //将所有语句进行拆分，方便jnz回溯
    private static String[] statementArr = null;
    //保存寄存器对应的数据值
    private static int[] nums = new int[100];
    //保存寄存器Key对应的数组下标
    private static HashMap<String, Integer> map = new HashMap<>();


    public static void main(String[] args) throws IOException, IllegalAccessException {
        //利用缓冲读取加快读取速度
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int cur = 0;
        int pre = 0;
        //通过cur与n来控制输入循环次数
        while (cur++ < n) {
            allStatement.append(reader.readLine().trim()).append("|");
        }
        statementArr = allStatement.toString().split("\\|");
        long startTime = System.currentTimeMillis();
        while (pre < n && Maximum_Cycle_Times-- > 0) {
            //pre为下次执行的数组下标
            pre = execute(pre);
        }
        //打印对应结果
        for (String s : map.keySet()) {
            System.out.println(s + ":" + nums[map.get(s)]);
        }
        System.out.println("当前程序执行总时间为：" + String.valueOf(System.currentTimeMillis() - startTime) + "ms");

//        关闭缓冲区流
        reader.close();
    }


    /**
     * 执行对应index行的语句
     * @param index 当前执行语句下标
     * @return 返回下一次应该执行的下标
     * @throws IllegalAccessException
     */
    public static int execute(int index) throws IllegalAccessException {
        long startTime = System.currentTimeMillis();
        String str = statementArr[index];
        String[] s = str.split(" ");
        if (s.length == 3) {
            if (s[0].toLowerCase().equals("mov")) {
                if (map.containsKey(s[1])) {
                    map.put(s[1], lastIndex);
                    nums[lastIndex] = map.containsKey(s[2]) ? nums[map.get(s[2])] : Integer.parseInt(s[2]);
                }else {
                    map.put(s[1], lastIndex);
                    nums[lastIndex++] = map.containsKey(s[2]) ? nums[map.get(s[2])] : Integer.parseInt(s[2]);
                }
            } else if (s[0].toLowerCase().equals("jnz")) {
                if (nums[map.get(s[1])] != 0) {
                    return index+ Integer.parseInt(s[2]);
                }
            } else {
                throw new IllegalAccessException("mov or jnz 操作命令出现问题！");
            }
        } else if (s.length == 2) {
            if (s[0].toLowerCase().equals("inc")) {
                nums[map.get(s[1])]++;
            } else if (s[0].toLowerCase().equals("dec")) {
                nums[map.get(s[1])]--;
            } else {
                throw new IllegalAccessException("inc or dec 操作命令出现问题！");
            }
        } else {
            throw new IllegalAccessException("输入参数不符合规定！");
        }
        //打印每个语句执行的执行时间，以及当前数据信息
//        System.out.print(str + "语句执行时间为：" + String.valueOf(System.currentTimeMillis() - startTime) + "----");
//        for (String ss : map.keySet()) {
//            System.out.print(ss + ":" + nums[map.get(ss)] + "||");
//        }
//        System.out.println();
        return index + 1;
    }
}