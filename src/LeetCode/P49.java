package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49 {
    public static void main(String[] s) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs != null && strs.length > 0) {
            Map<String, List<String>> hashMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                String hashString = generateHashString(strs[i]);
                List<String> list;
                if (hashMap.containsKey(hashString)) {
                    list = hashMap.get(hashString);
                } else {
                    list = new ArrayList<>();
                    hashMap.put(hashString, list);
                }
                list.add(strs[i]);
            }
            result.addAll(hashMap.values());
        }
        return result;
    }

    private String generateHashString(String string) {
        int[] hash = new int[26];
        for (int i = 0; i < string.length(); i++) {
            hash[string.charAt(i) - 'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hash.length; i++) {
            stringBuilder.append("#");
            stringBuilder.append(hash[i]);
        }
        return stringBuilder.toString();
    }
}
