package src.leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode242ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) return false;

        char [] sc = s.toCharArray();
        char [] tc = t.toCharArray();

        Arrays.sort(sc);
        Arrays.sort(tc);

        for(int i = 0; i < sc.length; i++)
            if(sc[i] != tc[i]) return false;

        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char c2 = t.charAt(i);
            map1.put(String.valueOf(c), map1.getOrDefault(c,0) + 1);
            map2.put(String.valueOf(c2), map2.getOrDefault(c2,0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            int sNum = map1.getOrDefault(String.valueOf(s.charAt(i)), 0);
            int tNum = map2.getOrDefault(String.valueOf(t.charAt(i)), 0);
            if(sNum != tNum) return false;
        }

        return true;
    }
}
