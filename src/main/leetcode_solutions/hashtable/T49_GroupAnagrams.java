package main.leetcode_solutions.hashtable;


import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/20 11:10 PM
 */
public class T49_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++){
            String ss = getSortedString(strs[i]);
            if (!map.containsKey(ss)){
                map.put(ss, new ArrayList<String>());
            }
            map.get(ss).add(strs[i]);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }

    private String getSortedString(String s){
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        return new String(charArr);
    }
}
