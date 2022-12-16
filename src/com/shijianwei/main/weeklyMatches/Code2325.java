package com.shijianwei.main.weeklyMatches;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author SHI
 * @date 2022/8/14 23:27
 */
public class Code2325 {
    public String decodeMessage(String key, String message) {
        char[] k = key.toCharArray();
        char[] m = message.toCharArray();
        char[] tab = new char[26];
        char a = 'a';
        for (char value : k) {
            if (value != 0 && tab[value - 'a'] == 0) {
                tab[value - 'a'] = a++;
            }
        }
        for (int j = 0; j < m.length; j++) {
            if (m[j] != ' ') {
                m[j] = tab[j - 'a'];
            }
        }
        return String.valueOf(m);
    }
}
