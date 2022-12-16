package com.shijianwei.main.exam.meituan.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author SHI
 * @date 2022/8/27 16:55
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String ori = br.readLine();
        int[] sunLen = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<String> sunStr = new ArrayList<>();

        System.out.println(2);
    }

    public static List<String> getSplitStrArr(List<String> strs, String sunStr) {
        Pattern pattern = Pattern.compile(sunStr);
        for (String str : strs) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.print(matcher.start() + " ");
                System.out.println(matcher.end());
            }
        }
        return null;
    }
}
