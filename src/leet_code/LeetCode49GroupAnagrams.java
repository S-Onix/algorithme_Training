package src.leet_code;

import java.util.*;

public class LeetCode49GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resultMap = new HashMap<>();
        for(int i = 0 ; i < strs.length; i++) {
            char [] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);

            /** 방법 1
            if(resultMap.containsKey(key)) {
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                resultMap.put(key, strList);
            }else {
                resultMap.get(key).add(strs[i]);
            }
             */
            /** 방법2 */
            resultMap.putIfAbsent(key, new ArrayList<>());
            resultMap.get(key).add(strs[i]);
        }

        return new ArrayList<>(resultMap.values());
    }
}
