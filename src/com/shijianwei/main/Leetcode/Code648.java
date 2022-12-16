package com.shijianwei.main.Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author SHI
 * @date 2022/9/10 23:05
 * <p>
 * https://leetcode.cn/problems/replace-words/
 */
public class Code648 {

    Trie trie = new Trie();

    /**
     * 前缀树，通过构建前缀树，可以看出是否包含当前前缀，并且直接走到最短的前缀
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            insert(s);
        }
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            s[i] = query(s[i]);
        }
        return String.join(" ", s);
    }

    public void insert(String word) {
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
            cur.isEnd = false;
        }
        cur.isEnd = true;
    }
//    private void insert(String word) {
//        Trie node = trie;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            int index = c - 'a';
//            if (node.children[index] == null) {
//                node.children[index] = new Trie();
//            }
//            node = node.children[index];
//        }
//        node.isEnd = true;
//    }


    public String query(String word) {
        Trie cur = trie;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                break;
            }
            if (cur.children[word.charAt(i) - 'a'].isEnd) {
                return word.substring(0, i + 1);
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return word;
    }
//    private String query(String word) {
//        Trie node = trie;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            int index = c - 'a';
//            if (node.children[index] == null) {
//                break;
//            }
//            if (node.children[index].isEnd) {
//                return word.substring(0, i + 1);
//            }
//            node = node.children[index];
//        }
//        return word;
//    }

    static class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd;
    }

//    /*构建前缀树（不标准前缀树）*/
//    public static String replaceWords1(List<String> dictionary, String sentence) {
//        Trie trie = new Trie();
//        /* 构建前缀树 */
//        for (String s : dictionary) {
//            Trie cur = trie;
//            for (int i = 0; i < s.length(); i++) {
//                cur.children.putIfAbsent(s.charAt(i), new Trie());
//                cur = cur.children.get(s.charAt(i));
//            }
//            cur.children.put('#', new Trie());
//        }
//        String[] s = sentence.split(" ");
//        for (int i = 0; i < s.length; i++) {
//            s[i] = findRoot(s[i], trie);
//        }
//        return String.join(" ", s);
//    }
//
//    public static String findRoot(String word, Trie trie) {
//        Trie cur = trie;
//        StringBuilder root = new StringBuilder();
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (cur.children.containsKey('#')) {
//                return root.toString();
//            }
//            if (!cur.children.containsKey(c)) {
//                return word;
//            }
//            root.append(c);
//            cur = cur.children.get(c);
//        }
//        return root.toString();
//    }
//
//    static class Trie {
//        HashMap<Character, Trie> children;
//
//        public Trie() {
//            children = new HashMap<>();
//        }
//    }

    /**
     * 暴力算法，
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public static String replaceWords2(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            String replace = "";
            for (String pre : set) {
                if (s[i].startsWith(pre)) {
                    if (replace.equals("") || pre.length() < replace.length()) {
                        replace = pre;
                    }
                }
            }
            s[i] = replace.equals("") ? s[i] : replace;
        }
        return String.join(" ", s);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("bat");
        list.add("rat");
//        System.out.println(replaceWords(list, "the cattle was rattled by the battery"));
        System.out.println(new Code648().replaceWords(list, "the cattle was rattled by the battery"));

    }
}
