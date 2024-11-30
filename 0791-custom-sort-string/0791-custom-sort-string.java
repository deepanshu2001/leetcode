import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                for (int j = 0; j < count; j++) {
                    ans.append(ch);
                }
                map.remove(ch);
            }
        }


        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            for (int j = 0; j < count; j++) {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}
