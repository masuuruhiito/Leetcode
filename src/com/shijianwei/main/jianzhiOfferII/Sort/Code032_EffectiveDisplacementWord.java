package com.shijianwei.main.jianzhiOfferII.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SHI
 * @date 2022/2/24 20:55
 */
public class Code032_EffectiveDisplacementWord {
    public boolean isAnagram1(String s , String t){
        if(s.isEmpty() || t.isEmpty() ||s.length()!=t.length() || s.equals(t)) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        Arrays.sort(schars);
        Arrays.sort(tchars);

        for (int i = 0; i <s.length(); i++) {
            if(schars[i] != tchars[i]) return false ;
        }
        return true ;
    }
    public boolean isAnagram(String s, String t) {
        if(s.isEmpty() || t.isEmpty() ||s.length()!=t.length() || s.equals(t)) return false;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
                if(map.get(t.charAt(i) )<0 ){
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
