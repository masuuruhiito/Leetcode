package com.shijianwei.main.jianzhiOfferII.Sort;

import java.util.*;

/**
 * @author SHI
 * @date 2022/2/24 21:46
 */
public class Code033_DeflectionPhrase {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String keys = String.valueOf(chars);
            List<String> res = map.getOrDefault(keys,new ArrayList<String>());
            res.add(strs[i]);
            map.put(keys,res);
        }
        return new ArrayList<>(map.values());
    }
}
