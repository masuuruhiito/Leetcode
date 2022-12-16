package com.shijianwei.main.exam.weizhong;

import java.util.Scanner;

/**
 * @author SHI
 * @date 2022/10/16 20:41
 *
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小明最近喜欢上了打鼓
 *
 * 乐谱中有两种音符，敲击鼓心可以演奏出“咚”音符(在乐谱中用‘o’表示)，而敲击鼓边可以演奏出“咔”音符(在乐谱中用‘x’表示)。同时，乐谱中还存在休止符(什么也不用演奏，用‘_’表示)。而乐谱则可以表示为含有‘o’、‘x’、‘_’三种字符的字符串（如”ooxx_oxxo_o_x_oox”）
 *
 * 小明的好朋友最近赠送了他一张乐谱作为新年礼物(用由‘o’和‘x’组成的字符串表示)。
 *
 * 小明想知道，这张乐谱最长的困难段长度为多少。
 *
 * 困难段是指不包含休止符的一段子串，同时含有字符’o’和’x’。
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] split = sc.next().split("_");
        int maxDiffLen = 0;
        for (String s : split) {
            if (s.contains("x") && s.contains("o") && s.length() > maxDiffLen) {
                maxDiffLen = s.length();
            }
        }
        System.out.println(maxDiffLen);
    }
}
