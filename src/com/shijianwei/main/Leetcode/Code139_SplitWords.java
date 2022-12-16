package com.shijianwei.main.Leetcode;

import com.shijianwei.main.common.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author SHI
 * @date 2022/4/10 21:18
 */
public class Code139_SplitWords {

    static Trie trie = new Trie();

    public static boolean wordBreak(String s, List<String> wordDict) {
        for (String s1 : wordDict) {
            add(s1);
        }
        return query(s);
    }

    public static void add(String word) {
        Trie cur = trie;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (cur.children[c] == null) {
                cur.children[c] = new Trie();
            }
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }

    public static boolean query(String word) {
        Trie cur = trie;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (cur.children[c] == null) {
                return false;
            }
            cur = !cur.children[c].isEnd ? cur.children[c] : trie;
        }
        return cur == trie;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("aaa");
        System.out.println(wordBreak("aaaaa", list));
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (String sub : set) {
                    if (i + sub.length() <= s.length() && s.substring(i, i + sub.length()).equals(sub)) {
                        dp[i + sub.length()] = true;
                    }
                }
            }

            int[][] ints = new ArrayList<Integer>().toArray(new int[][]{new int[]{}});


        }
        return dp[dp.length - 1];
    }
}

