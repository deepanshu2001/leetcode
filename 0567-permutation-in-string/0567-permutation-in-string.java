import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            Map<Character, Integer> map2 = new HashMap<>();
            for (int j = 0; j < s1.length(); j++) {
                map2.put(s2.charAt(i + j), map2.getOrDefault(s2.charAt(i + j), 0) + 1);
            }
            // Compare map1 and map2 outside the inner loop
            if (map1.equals(map2)) {
                return true;
            }
        }
        return false;
    }
}
